package com.zee.zee5Dashboard.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import com.zee.zee5Dashboard.entity.BeforeTvDashboard;
import com.zee.zee5Dashboard.service.BeforeTvDashboardService;

@Controller
public class BeforeTvDashboardController {

	 @Autowired
	    private BeforeTvDashboardService beforetvService;
	    
//		@GetMapping({"/zee5dashboard/beforetv-dash","/shows"})
//		public String listShows(Model model)
//		{			
//			List<BeforeTvDashboard> listShow = beforetvService.getAllShows();
//			model.addAttribute("listShows", listShow);
//			return "BeforeTvDashboard";
//		}
	 
	 
	    // handler method to handle list shows and return mode and view
//	    @GetMapping({"/zee5dashboard/beforetv-dash", "/shows"})
//	    public String listShows(HttpServletRequest request, Model model) {
//	        int currPage = 1;  // default page number
//	        int pageSize = 3;  // default pageSize
//	        int numRecords = beforetvService.getAllShows().size();
//	        int numPages = numRecords / pageSize;
//	        if (numRecords % pageSize > 0) {
//	        	numPages++;
//	        }
//	        
//	        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
//	        	currPage = Integer.parseInt(request.getParameter("page"));
//	        }
//	        
//	    	Page<BeforeTvDashboard> allShows = beforetvService.getAllShowsByPage(currPage-1, pageSize);
//	    	int position = (currPage-1)*pageSize + 1;
//	    	for (BeforeTvDashboard show: allShows) {
//	    		show.setPosition(position++);
//	    	}
//	    	model.addAttribute("numPages", numPages);
//	    	model.addAttribute("pageSize", pageSize);
//	    	model.addAttribute("allShows", allShows);
//	    	model.addAttribute("currPage", currPage);
//	    	model.addAttribute("numRecords", numRecords);
//	        return "BeforeTvDashboard";
//	    }
//	    
	 
	 void combineDaysApplicable(List<BeforeTvDashboard> allShows) {
			// Combine the days applicable for same shows
			// for each position, compare consecutive positions
			// if the data is the same, add days to previous show object, delete next object
			for (int i=0; i < allShows.size()-1; i++) {
				if (allShows.get(i).sameAs(allShows.get(i+1))) {
					String newDayApplicable = allShows.get(i).getDayApplicable() + "," + allShows.get(i+1).getDayApplicable();
					if (newDayApplicable.equals("Sun,Mon,Tue,Wed,Thu,Fri,Sat")) {
						newDayApplicable = "All";
					}
					allShows.get(i).setDayApplicable(newDayApplicable);
					allShows.remove(i+1);
					i--;
				}
			}
		}
	 
	 
	 @GetMapping({"/zee5dashboard/beforetv-dash","/shows"})
	 public String beforeTvDashboard(Model model)
	 {

	 List<BeforeTvDashboard> allShows = beforetvService.getAllShows();
	 int position = 1;
	 for (BeforeTvDashboard show: allShows) {
	 show.setPosition(position++);
	 }
	 model.addAttribute("allShows", allShows);
	 return "BeforeTvDashboard";
	 }

//	    @RequestMapping(path = {"/","/search"})
//	    public String home(BeforeTvDashboard show, Model model, String keyword) {
//	     if(keyword!=null) {
//	      List<BeforeTvDashboard> list = beforetvService.findByKeyword(keyword);
//	      model.addAttribute("list", list);
//	     }else {
//	     List<BeforeTvDashboard> list = beforetvService.getAllShows();
//	     model.addAttribute("list", list);}
//	     return "BeforeTvDashboard";
//	    }
	   
	    @GetMapping("/zee5dashboard/beforetv-add")
	    public String createShowForm(Model model) {
	        // create show object to hold show form data
	        BeforeTvDashboard show = new BeforeTvDashboard();
	        model.addAttribute("show", show);
	        return "BeforeTvDashboard_CreateShow";
	    }
	    
	    @PostMapping("/zee5dashboard/shows")
	    public String saveShow(@ModelAttribute("show") BeforeTvDashboard show) {
//	        beforetvService.saveShow(show);
	    	 if (show.getDayApplicable().toLowerCase().equals("all")) {
					show.setDayApplicable("Sun,Mon,Tue,Wed,Thu,Fri,Sat");
				}
		        List<String> days = Arrays.asList(show.getDayApplicable().split(","));  // convert days to list
				for (String day: days) { 
					// create a new object with each day and save it to DB
					
					BeforeTvDashboard newShow = new BeforeTvDashboard(
						show.getId(), show.getShowID() , show.getShowName() , show.getShowStartTime(), show.getShowEndTime(),show.getSTATUS(),show.getSeasonID(),show.getDayApplicable()
					);
					beforetvService.saveShow(newShow);
				}
	        return "redirect:/zee5dashboard/beforetv-dash";
	    }
	    
	    @GetMapping("/zee5dashboard/beforetv-edit/{id}")
	    public String editShowForm(@PathVariable Long id, Model model) {
//	        model.addAttribute("show", beforetvService.getShowById(id));
//	        return "BeforeTvDashboard_EditShow";
	    	
	    	List<BeforeTvDashboard> allShows = beforetvService.getAllShows();
			combineDaysApplicable(allShows);
			for (BeforeTvDashboard show : allShows) {
				if (show.getId() == id) {
					model.addAttribute("show", show);
					return "BeforeTvDashboard_EditShow";
				}
			}
	        return "redirect:/zee5dashboard/beforetv-dash";
	    }
	    
	    void deleteSameShows(BeforeTvDashboard oldShow) {
			// get details of current show using ID
			BeforeTvDashboard show = beforetvService.getShowById(oldShow.getId());

			// get all shows from the database with the same details
			List<BeforeTvDashboard> sameShows = beforetvService.getAllShows();
			sameShows.removeIf((eachShow) -> !show.sameAs(eachShow));

			// delete all these shows from the database
			for (BeforeTvDashboard eachShow : sameShows) {
				beforetvService.deleteShowById(eachShow.getId());
			}
		}
	    
	    @PostMapping("/shows/{id}")
	    public String updateShow(@PathVariable Long id, @ModelAttribute("beforetvdashboard") BeforeTvDashboard show, Model model) {
	        // get show from database by id
//	        BeforeTvDashboard existingShow = beforetvService.getShowById(id);
//	        existingShow.setId(id);
//	        existingShow.setShowID(show.getShowID());
//	        existingShow.setShowName(show.getShowName());
//	        existingShow.setShowStartTime(show.getShowStartTime());
//	        existingShow.setShowEndTime(show.getShowEndTime());
//	        existingShow.setDayApplicable(show.getDayApplicable());
//	        existingShow.setSTATUS(show.getSTATUS());
//	        existingShow.setSeasonID(show.getSeasonID());
	        //existingShow.setToch(show.getToch());

	        // save updated show object
//	        beforetvService.updateShow(existingShow);
	    	
	    	deleteSameShows(show);
	        // add shows to the database
			return saveShow(show);  // use same method which is used for creating a show
//	        return "redirect:/zee5dashboard/beforetv-dash";
	    }
	    
	    @GetMapping("/zee5dashboard/beforetv-delete/{id}")
	    public String deleteShow(@PathVariable Long id) {
	        beforetvService.deleteShowById(id);
	        return "redirect:/zee5dashboard/beforetv-dash";
	    }
	    
	    
	    // API functions
//	    @GetMapping("/api/shows")
//	    public ResponseEntity<?> listShowsApi() {
//	    	List<Show> allShows = beforetvService.getAllShows();
//	    	// if the list is empty
//	        if (allShows == null || allShows.isEmpty()) {
//	            Map<String, String> map = getMessageMap("No data found");
//	            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
//	        }
//	        return ResponseEntity.ok(allShows);
//	    }
//	    @PostMapping("/api/shows")
//	    public ResponseEntity<?> createShowApi(Show show) {
//	    	if (beforetvService.getAllShows().contains(show)) {
//	    		return ResponseEntity.ok(getMessageMap("Show already exists in the data"));
//	    	}
//	        return ResponseEntity.ok(beforetvService.saveShow(show));
//	    }
//		public Map<String, String> getMessageMap(String message)	{
//			Map<String, String> map = new HashMap<>();
//			map.put("message", message);
//			return map;
//		}
}
