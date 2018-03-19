package oro.gis.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import oro.gis.model.UserDetailsTable;
import oro.gis.service.UserDetailsTableService;

@Controller
@RequestMapping(value = "/admin/user")
public class AdminModifyUserController 
{
	@Autowired
	UserDetailsTableService userDetailsTableService;
	
	@Autowired
	Map<String,Object> placeholders;
	
	private int id;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView index() 
	{
		ModelAndView indexView = new ModelAndView();
		placeholders = new HashMap<String,Object>();
		placeholders.put("details",userDetailsTableService.getUserList());
		placeholders.put("show",false);
		indexView.addAllObjects(placeholders);
		indexView.setViewName("adminSide/createOrDeleteUser/adminclickuser");
		return indexView;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("userDetails") UserDetailsTable userDetails,HttpServletRequest request) 
	{
		ModelAndView addUserView = new ModelAndView();
		if (userDetails.status()) 
		{
			userDetailsTableService.save(userDetails);
			request.setAttribute("confirmation", "Record Added Successfully");
			addUserView.setViewName("adminSide/adminPanel");
		}
		else
		{
			placeholders = new HashMap<String,Object>();
			placeholders.put("link","addUser");
			placeholders.put("process","Add");
			addUserView.addAllObjects(placeholders);
			addUserView.setViewName("adminSide/addUser");
		}
		return addUserView;
	}
	
	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute("userDetails") UserDetailsTable userDetails,HttpServletRequest request) 
	{
		placeholders = new HashMap<String,Object>();
		ModelAndView editUserView = new ModelAndView();
		
		if (userDetails.status()) 
		{
			userDetailsTableService.update(userDetails,this.id);
			request.setAttribute("confirmation", "Record Updated Successfully");
			editUserView.setViewName("adminSide/adminPanel");
		}
		else if((String) request.getParameter("option")!=null)
		{
		    this.id = Integer.parseInt((String) request.getParameter("option"));
			placeholders.put("link","editUser");
			placeholders.put("process","Edit");
			editUserView.addAllObjects(placeholders);
			editUserView.setViewName("adminSide/createOrDeleteUser/askingDetails");
		}
		else
		{
			placeholders.put("details",userDetailsTableService.getUserList());
			placeholders.put("link","editUser");
			placeholders.put("process","Edit");
			placeholders.put("show",true);
			editUserView.addAllObjects(placeholders);
			editUserView.setViewName("adminSide/createOrDeleteUser/selectUser");
		}
		return editUserView;
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public ModelAndView deleteUser(HttpServletRequest request) 
	{
		ModelAndView deleteUserView = new ModelAndView();
		if((String) request.getParameter("option")!=null)
		{
			int id = Integer.parseInt((String) request.getParameter("option"));
			userDetailsTableService.delete(new UserDetailsTable(id));
			request.setAttribute("confirmation", "Record deleted Successfully");
			deleteUserView.setViewName("adminSide/adminPanel");
		}
		else
		{
			placeholders = new HashMap<String,Object>();
			placeholders.put("details",userDetailsTableService.getUserList());
			placeholders.put("link","deleteUser");
			placeholders.put("process","Delete");
			placeholders.put("show",true);
			deleteUserView.addAllObjects(placeholders);
			deleteUserView.setViewName("adminSide/createOrDeleteUser/selectUser");
		}
		return deleteUserView;
		
	}

}
