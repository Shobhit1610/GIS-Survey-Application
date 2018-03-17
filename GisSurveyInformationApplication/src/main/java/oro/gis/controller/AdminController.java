package oro.gis.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import oro.gis.bean.AdminDetailsBean;

@Controller
@RequestMapping(value="/admin")
public class AdminController 
{
		
	@RequestMapping(value="",method=RequestMethod.GET)
	public ModelAndView index(Model model)
	{
		ModelAndView indexView = new ModelAndView();
		model.addAttribute("adminDetails", new AdminDetailsBean());
		indexView.setViewName("adminSide/adminLogin");
		return indexView;
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ModelAndView index(@ModelAttribute("adminDetails") AdminDetailsBean adminDetailsBean, HttpServletRequest request)
	{
		ModelAndView indexView = new ModelAndView();
		if(adminDetailsBean.verify())
		{
			indexView.setViewName("adminSide/adminPanel");
		}
		else
		{
			request.setAttribute("error","Wrong Details...");
			indexView.setViewName("adminSide/adminLogin");
		}
		return indexView;
	}

}
