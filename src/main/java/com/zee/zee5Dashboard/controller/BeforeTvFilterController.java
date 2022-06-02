package com.zee.zee5Dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.zee.zee5Dashboard.entity.BeforeTVFilter;

import com.zee.zee5Dashboard.service.BeforeTvFilterService;

@Controller
public class BeforeTvFilterController {

	 @Autowired
	    private BeforeTvFilterService beforetvfilterService;
	    
	    // handler method to handle list shows and return mode and view
//	    @GetMapping({"/zee5dashboard/beforetv-dash", "/shows"})
//	    public String listShows(HttpServletRequest request , Model model) {
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
	    
	    @GetMapping("/zee5dashboard/beforetv-filter")
	    public  String beforeTvDashboard(Model model)
	    {
	    	
	    	List<BeforeTVFilter> allShows = beforetvfilterService.getAllShows();
	    	int position = 1;
	    	for (BeforeTVFilter show: allShows) {
	    		show.setPosition(position++);
	    	}
		    model.addAttribute("allShows", allShows);
		     return "BeforeTVFilter";
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
	   
//	    @GetMapping("/zee5dashboard/beforetv-add")
//	    public String createShowForm(Model model) {
//	        // create show object to hold show form data
//	        BeforeTvDashboard show = new BeforeTvDashboard();
//	        model.addAttribute("show", show);
//	        return "BeforeTvDashboard_CreateShow";
//	    }
	    
//	    @PostMapping("/zee5dashboard/shows")
//	    public String saveShow(@ModelAttribute("show") BeforeTvDashboard show) {
//	        beforetvService.saveShow(show);
//	        return "redirect:/zee5dashboard/beforetv-dash";
//	    }
//	    
	    
	    @GetMapping("/zee5dashboard/filter-edit/{id}")
		public String editShowForm(@PathVariable Long id, Model model) {
			model.addAttribute("show", beforetvfilterService.getShowById(id));
			return "BeforeTVFilter_EditShow";
		}
	    
	    @PostMapping("/zee5dashboard/filter-shows/{id}")
	    public String updateShow(@PathVariable Long id, @ModelAttribute("beforetvfilterService") BeforeTVFilter show, Model model) {
	        // get show from database by id
	        BeforeTVFilter existingShow = beforetvfilterService.getShowById(id);
	        existingShow.setId(id);
	        existingShow.setShowName(show.getShowName());
	        existingShow.setId(show.getId());
	        existingShow.setEpisodeId(show.getEpisodeId());
	        existingShow.setIndexNo(show.getIndexNo());
	        existingShow.setReleaseDate(show.getReleaseDate());
	        existingShow.setLanguage(show.getLanguage());
	        existingShow.setStartTime(show.getStartTime());
	        existingShow.setEndTime(show.getEndTime());
	        existingShow.setSVODRemarks(show.getSVODRemarks());
	        existingShow.setSVODStatus(show.getSVODStatus());
	        existingShow.setAVODRemarks(show.getAVODRemarks());
	        existingShow.setAVODStatus(show.getAVODStatus());
	        existingShow.setSource(show.getSource());
	        existingShow.setAddedOn(show.getAddedOn());
	        existingShow.setPremiumOnZee5(show.getPremiumOnZee5());
	        existingShow.setFreeOnZee5(show.getFreeOnZee5());


	        // save updated show object
	        beforetvfilterService.updateShow(existingShow);
	        return "redirect:/zee5dashboard/beforetv-filter";
	    }
//	    
//	    @GetMapping("/zee5dashboard/beforetv-delete/{id}")
//	    public String deleteShow(@PathVariable Long id) {
//	        beforetvService.deleteShowById(id);
//	        return "redirect:/zee5dashboard/beforetv-dash";
//	    }
//	    
	    
	     @GetMapping("/zee5dashboard/filter-delete/{id}")
	    public String deleteShow(@PathVariable Long id) {
	        beforetvfilterService.deleteShowById(id);
	        return "redirect:/zee5dashboard/beforetv-filter";
	    }
	    
	    // API functions
//	    @GetMapping("/api/shows")
//	    public ResponseEntity<?> listShowsApi() {
//	    	List<BeforeTvDashboard> allShows = beforetvService.getAllShows();
//	    	// if the list is empty
//	        if (allShows == null || allShows.isEmpty()) {
//	            Map<String, String> map = getMessageMap("No data found");
//	            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
//	        }
//	        return ResponseEntity.ok(allShows);
//	    }
//	    @PostMapping("/api/shows")
//	    public ResponseEntity<?> createShowApi(BeforeTvDashboard show) {
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
