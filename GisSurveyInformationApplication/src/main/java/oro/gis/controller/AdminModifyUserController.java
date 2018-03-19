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
import oro.gis.service.TableNameModelService;
import oro.gis.service.UserDetailsTableService;

@Controller
@RequestMapping(value = "/admin/user")
public class AdminModifyUserController 
{
	@Autowired
	UserDetailsTableService userDetailsTableService;
	
	@Autowired
	Map<String,Object> placeholders;
	
	@Autowired
	TableNameModelService tableNameModelService;
	
	private int id;


	// Run when admin click on Add Users
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("userDetails") UserDetailsTable userDetails,HttpServletRequest request) 
	{
		ModelAndView addUserView = new ModelAndView();
		
		//Run when details are provided by admin
		if (userDetails.status()) 
		{
			userDetailsTableService.save(userDetails);
			request.setAttribute("confirmation", "Record Added Successfully");
			long users = userDetailsTableService.count();
			long tables = tableNameModelService.count();
			placeholders = new HashMap<String,Object>();
			placeholders.put("users_count",users);
			placeholders.put("tables_count", tables);
			addUserView.setViewName("adminSide/adminPanel");
		}
		
		//First run asking details of user from admin
		else
		{
			placeholders = new HashMap<String,Object>();
			placeholders.put("link","addUser");
			placeholders.put("process","Add");
			addUserView.setViewName("adminSide/createOrDeleteUser/addUser");
		}
		addUserView.addAllObjects(placeholders);
		return addUserView;
	}
	
	//Run when admin request to edit a user
	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute("userDetails") UserDetailsTable userDetails,HttpServletRequest request) 
	{
		placeholders = new HashMap<String,Object>();
		ModelAndView editUserView = new ModelAndView();
		
		//Run when recieve a model object with updated details
		if (userDetails.status()) 
		{
			userDetailsTableService.update(userDetails,this.id);
			request.setAttribute("confirmation", "Record Updated Successfully");
			long users = userDetailsTableService.count();
			long tables = tableNameModelService.count();
			placeholders = new HashMap<String,Object>();
			placeholders.put("users_count",users);
			placeholders.put("tables_count", tables);
			editUserView.setViewName("adminSide/adminPanel");
		}
		
		//Accept the id and now ask for new details
		else if((String) request.getParameter("option")!=null)
		{
		    this.id = Integer.parseInt((String) request.getParameter("option"));
			placeholders.put("link","editUser");
			placeholders.put("process","Edit");
			editUserView.addAllObjects(placeholders);
			editUserView.setViewName("adminSide/createOrDeleteUser/addUser");
		}
		
		//Run to ask admin which user need to be updated
		else
		{
			placeholders.put("details",userDetailsTableService.getUserList());
			placeholders.put("link","editUser");
			placeholders.put("process","Edit");
			placeholders.put("show",true);
			editUserView.setViewName("adminSide/createOrDeleteUser/deleteUser");
		}
		editUserView.addAllObjects(placeholders);
		return editUserView;
	}

	//Run when admin want to delete any user
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public ModelAndView deleteUser(HttpServletRequest request) 
	{
		ModelAndView deleteUserView = new ModelAndView();
		
		//Run when admin sent the user id of deleted user
		if((String) request.getParameter("option")!=null)
		{
			int id = Integer.parseInt((String) request.getParameter("option"));
			userDetailsTableService.delete(new UserDetailsTable(id));
			request.setAttribute("confirmation", "Record deleted Successfully");
			long users = userDetailsTableService.count();
			long tables = tableNameModelService.count();
			placeholders = new HashMap<String,Object>();
			placeholders.put("users_count",users);
			placeholders.put("tables_count", tables);
			deleteUserView.setViewName("adminSide/adminPanel");
		}
		
		//Run to ask admin which user to delete from list
		else
		{
			placeholders = new HashMap<String,Object>();
			placeholders.put("details",userDetailsTableService.getUserList());
			placeholders.put("link","deleteUser");
			placeholders.put("process","Delete");
			placeholders.put("show",true);
			deleteUserView.setViewName("adminSide/createOrDeleteUser/deleteUser");
		}
		deleteUserView.addAllObjects(placeholders);
		return deleteUserView;
		
	}

	//Run when all details are asked
	@RequestMapping(value = "/showAllUsers", method = RequestMethod.POST)
	public ModelAndView showAllUsers()
	{
		ModelAndView showAllUsersView = new ModelAndView();
		placeholders = new HashMap<String,Object>();
		placeholders.put("details",userDetailsTableService.getUserList());
		placeholders.put("show",false);
		showAllUsersView.addAllObjects(placeholders);
		showAllUsersView.setViewName("adminSide/createOrDeleteUser/showAllUsers");
		return showAllUsersView;
	}
}
