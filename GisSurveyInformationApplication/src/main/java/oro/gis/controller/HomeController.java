package oro.gis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import oro.gis.model.UserDetailsTable;

@Controller
@RequestMapping("/")
public class HomeController 
{
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public ModelAndView home()
	{
		ModelAndView homeView = new ModelAndView();
		homeView.setViewName("home");
		homeView.addObject("userDetails",new UserDetailsTable());
		return homeView;
	}
	
}
