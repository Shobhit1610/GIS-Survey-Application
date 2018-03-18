package oro.gis.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	//Run for asking details
	public ModelAndView index(Model model)
	{
		ModelAndView indexView = new ModelAndView();
		model.addAttribute("adminDetails", new AdminDetailsBean());
		indexView.setViewName("adminSide/adminLogin");
		return indexView;
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	// Run when
		// 1. Accept credentials of admin
		// 2. Redirect of Admin Panel occurs after getting logged in
	public ModelAndView index(@ModelAttribute("adminDetails") AdminDetailsBean adminDetailsBean, HttpServletRequest request,HttpSession session)
	{
		ModelAndView indexView = new ModelAndView();
		
		//Run if already logged and clicked on dashBoard link on navigation bar
		// so value stored in session cannot be null then
		if((Boolean)session.getAttribute("logged")!=null)
		{
			indexView.setViewName("adminSide/adminPanel");
		}
		
		//Run when given right credentials and then store value in session
		else if(adminDetailsBean.verify())
		{
			//storing value in session for not asking again
			session.setAttribute("logged", true);
			indexView.setViewName("adminSide/adminPanel");
		}
		
		//Run when wrong credentials are given
		else
		{
			request.setAttribute("error","Wrong Details...");
			indexView.setViewName("adminSide/adminLogin");
		}
		return indexView;
		
	}
}
