package oro.gis.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import oro.gis.service.TableNameModelService;
import oro.gis.service.UserDetailsTableService;

@Controller
@RequestMapping(value="/admin")
public class AdminController 
{
	@Autowired
	UserDetailsTableService userDetailsTableService;
	
	@Autowired
	TableNameModelService tableNameModelService;
		
	@RequestMapping(value="",method=RequestMethod.GET)
	public ModelAndView index(Model model)
	{
		ModelAndView indexView = new ModelAndView();
		
			long users = userDetailsTableService.count();
			long tables = tableNameModelService.count();
			Map<String,Object> placeholder = new HashMap<String,Object>();
			placeholder.put("users_count",users);
			placeholder.put("tables_count", tables);
			indexView.addAllObjects(placeholder);
			indexView.setViewName("adminSide/adminPanel");
			
		return indexView;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView login(String error,String logout)
	{
		ModelAndView loginView = new ModelAndView();
		
			if(error!=null)
				loginView.addObject("error","Wrong credentials...");
		
			if(logout!=null)
				loginView.addObject("error","Successfully logged out...");
			
			loginView.setViewName("adminSide/adminLogin");
			
		return loginView;
	}


}