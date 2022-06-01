package com.zee.zee5Dashboard.controller;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import com.zee.zee5Dashboard.entity.BeforeTvDashboard;
import com.zee.zee5Dashboard.entity.WeeklyWebisode;
import com.zee.zee5Dashboard.service.WeeklyWebisodeService;



@Controller
public class WeeklyWebisodeController {

@Autowired
private WeeklyWebisodeService weeklyWebisodeService;

@GetMapping("/zee5dashboard/weeklywebisode")
public String webisodes(Model model)
{


List<WeeklyWebisode> allShows = weeklyWebisodeService.getAllWebisodes();


int position = 1;
for (WeeklyWebisode show: allShows) {
show.setPosition(position++);
}
model.addAttribute("listWebisodes", weeklyWebisodeService.getAllWebisodes());
return "WeeklyWebisode";
}



}