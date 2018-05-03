package oro.gis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value="/addUser",method=RequestMethod.GET)
	public ModelAndView addUser()
	{
		ModelAndView addUserView = new ModelAndView();
		
			placeholders = new HashMap<String,Object>();
			placeholders.put("userDetails",userDetailsTableService.getObject());
			
			addUserView.addAllObjects(placeholders);
			addUserView.setViewName("adminSide/createOrDeleteUser/addUser");
			
		return addUserView;
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("userDetails") UserDetailsTable userDetails) 
	{
		ModelAndView addUserView = new ModelAndView();
			
			int duplicateId = userDetailsTableService.checkDuplicate(userDetails);
			placeholders = new HashMap<String,Object>();

			if(duplicateId==-1)
			{
				userDetailsTableService.save(userDetails);
				placeholders.put("confirmation","Record Added Successfully");
			}
			else
			{
				placeholders.put("error"," Duplicate Entry");
				//placeholders.put("confirmation"," Duplicate Entry found at ID - "+duplicateId);
			}
			
		
			long users = userDetailsTableService.count();
			long tables = tableNameModelService.count();
			placeholders.put("users_count",users);
			placeholders.put("tables_count", tables);
			
			addUserView.addAllObjects(placeholders);
			addUserView.setViewName("adminSide/adminPanel");
		
		return addUserView;
	}
	
	@RequestMapping(value="/showUsers",method=RequestMethod.GET)
	public ModelAndView showUsers()
	{
		ModelAndView showUsersView = new ModelAndView();
		
			placeholders = new HashMap<String,Object>();
			placeholders.put("details",userDetailsTableService.getUserList());
		
			showUsersView.addAllObjects(placeholders);
			showUsersView.setViewName("adminSide/createOrDeleteUser/showAllUsers");
		
		return showUsersView;
	}
	
	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public ModelAndView editUser(@RequestParam("userid") String userId) 
	{
		ModelAndView editUserView = new ModelAndView();
		
			int id = Integer.parseInt(userId);
			
			placeholders = new HashMap<String,Object>();
			placeholders.put("newuserDetails", userDetailsTableService.getObject());
			placeholders.put("olddetails",userDetailsTableService.getUserObjectByID(id));
			
			editUserView.addAllObjects(placeholders);
			editUserView.setViewName("adminSide/createOrDeleteUser/editUser");
		
		return editUserView;
	}
	
	@RequestMapping(value="/editUser",method=RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute("newuserDetails") UserDetailsTable newUserDetails,@RequestParam("userid") String userId)
	{
		ModelAndView editUserView = new ModelAndView();
		
			int id = Integer.parseInt(userId);
			int duplicateId = userDetailsTableService.checkDuplicate(newUserDetails);
			placeholders = new HashMap<String,Object>();
			
			if(duplicateId==-1)
			{
				userDetailsTableService.update(newUserDetails,id);
				
				placeholders.put("confirmation", "Record edited Successfully");
			}
			else
			{
				placeholders.put("error","Duplicate Entry");
			}
			
			long users = userDetailsTableService.count();
			long tables = tableNameModelService.count();
			placeholders.put("users_count",users);
			placeholders.put("tables_count", tables);
			
			editUserView.addAllObjects(placeholders);
			editUserView.setViewName("adminSide/adminPanel");
		
		return editUserView;
	}

	@RequestMapping(value = "/deleteUsers", method = RequestMethod.POST)
	public ModelAndView deleteUsers(@RequestParam("usersDeleted") List<String> values) 
	{
		ModelAndView deleteUserView = new ModelAndView();
		
			for(String value : values)
			{
				int id = Integer.parseInt(value);
				userDetailsTableService.delete(new UserDetailsTable(id));
			}
			
			long users = userDetailsTableService.count();
			long tables = tableNameModelService.count();
			placeholders = new HashMap<String,Object>();
			placeholders.put("users_count",users);
			placeholders.put("tables_count", tables);
			placeholders.put("confirmation", "Records deleted Successfully");
		
			deleteUserView.addAllObjects(placeholders);
			deleteUserView.setViewName("adminSide/adminPanel");
		
		return deleteUserView;
	}
	
}
