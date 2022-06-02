package com.zee.zee5Dashboard.controller;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import com.zee.zee5Dashboard.entity.WeeklyWebisode;
import com.zee.zee5Dashboard.entity.WeeklyWebisodeConfiguration;
import com.zee.zee5Dashboard.service.WeeklyWebisodeConfigurationService;



@Controller



public class WeeklyWebisodeConfigurationController {

@Autowired
private WeeklyWebisodeConfigurationService weeklyWebisodeConfigurationService;

@GetMapping("/zee5dashboard/weeklywebisode/weeklywebisodeconfiguration")
public String webisodesConfiguration(Model model)
{


List<WeeklyWebisodeConfiguration> allShows = weeklyWebisodeConfigurationService.getAllWebisodesConfiguration();


int position = 1;
for (WeeklyWebisodeConfiguration show: allShows) {
show.setPosition(position++);
}
model.addAttribute("listWebisodesConfiguration", weeklyWebisodeConfigurationService.getAllWebisodesConfiguration());
return "WeeklyWebisodeConfiguration";
}



}