package oro.gis.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import oro.gis.model.EntryMakerModel;
import oro.gis.model.EntryValuesModel;
import oro.gis.model.UserDetailsTable;
import oro.gis.service.EntryMakerModelService;
import oro.gis.service.EntryValuesModelService;
import oro.gis.service.TableFieldsModelService;
import oro.gis.service.TableNameModelService;
import oro.gis.service.UserDetailsTableService;
@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	UserDetailsTableService userDetailsTableService;

	@Autowired
	TableNameModelService tableNameModelService;

	@Autowired
	TableFieldsModelService tableFieldModelService;
	
	@Autowired
	EntryValuesModelService entryValuesModelService;
	
	@Autowired
	EntryMakerModelService entryMakerModelService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request) 
	{
		ModelAndView indexView = new ModelAndView();
			
			HttpSession session = request.getSession(false);
			if(session==null || session.getAttribute("UserLogged")==null)
			{
				indexView.addObject("userDetails", new UserDetailsTable());
				indexView.setViewName("home");
			}
					else
			{
				indexView.addObject("details", tableNameModelService.getTablesList());		
				indexView.setViewName("userSide/userPanel");
			}
			
		return indexView;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView userLogin(@ModelAttribute("userDetails") UserDetailsTable userDetails,HttpServletRequest request)
	{
		ModelAndView userLoginView = new ModelAndView();
			
			if (userDetailsTableService.verify(userDetails.getUsername(), userDetails.getPassword())) 
			{
				HttpSession session = request.getSession();
				session.setAttribute("UserLogged",true);
				session.setAttribute("UserCredentials", userDetailsTableService.getUserObjectByCredentials(userDetails.getUsername(),userDetails.getPassword()));
				
				userLoginView.addObject("details", tableNameModelService.getTablesList());
				userLoginView.setViewName("userSide/userPanel");
				
			} 
			else
			{
				userLoginView.addObject("error","Wrong Details..");
				userLoginView.setViewName("home");
			}
			
		return userLoginView;
	}

	@RequestMapping(value = "/addEntry", method = RequestMethod.GET)
	public ModelAndView addEntry(@RequestParam("tableid") String tableid , HttpServletRequest request)
	{
		ModelAndView addEntryView = new ModelAndView();
			
			HttpSession session = request.getSession();
			if(session==null || session.getAttribute("UserLogged")==null)
			{
				addEntryView.addObject("userDetails", new UserDetailsTable());
				addEntryView.setViewName("home");
			}
			else
			{
				int datatype_id = Integer.parseInt(tableid);
				request.setAttribute("fielddetails",tableFieldModelService.getFieldsList(datatype_id));
				request.setAttribute("tabledetails",tableNameModelService.getDetails(datatype_id));
				addEntryView.setViewName("userSide/userFieldEntry");
			}
			
		return addEntryView;
	}
	
	@RequestMapping(value="/addEntry", method=RequestMethod.POST)
	public ModelAndView saveValues(HttpServletRequest request) 
	{
		ModelAndView saveEntryView = new ModelAndView();
		
			HttpSession session = request.getSession();
			UserDetailsTable userDetails = (UserDetailsTable)session.getAttribute("UserCredentials");
			
			int userid = userDetails.getUserid();
			entryMakerModelService.save(new EntryMakerModel(userid));
			int entryId = entryMakerModelService.getEntryId();
		
			Map<String, String[]> fieldVauesMap = request.getParameterMap();
			for(String x : fieldVauesMap.keySet())
			{
				System.out.println(x);
				EntryValuesModel entryValues = new EntryValuesModel();
				entryValues.setEntryID(entryId);
				entryValues.setFieldID(Integer.parseInt(x));
				entryValues.setFieldValue(fieldVauesMap.get(x)[0]);
				entryValuesModelService.save(entryValues);
			}
			
			saveEntryView.addObject("confirmation","Data added Succesfully");
			saveEntryView.addObject("details", tableNameModelService.getTablesList());		
			saveEntryView.setViewName("userSide/userPanel");
			
		return saveEntryView;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request)
	{
		ModelAndView logoutView = new ModelAndView();
		
			HttpSession session = request.getSession();
			session.invalidate();
			logoutView.setViewName("home");
			logoutView.addObject("userDetails",new UserDetailsTable());
			
		return logoutView;
	}
}
