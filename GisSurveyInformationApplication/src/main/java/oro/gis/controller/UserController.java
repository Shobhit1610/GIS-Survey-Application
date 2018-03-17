package oro.gis.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import oro.gis.model.EntryMakerModel;
import oro.gis.model.EntryValuesModel;
import oro.gis.model.TableFieldsModel;
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
	public ModelAndView index(Model model) {
		ModelAndView indexView = new ModelAndView();
		model.addAttribute("userDetails", new UserDetailsTable());
		indexView.setViewName("userSide/userLogin");
		return indexView;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView userLogin(@ModelAttribute("userDetails") UserDetailsTable userDetails,
			HttpServletRequest request,HttpSession session)
	{
		ModelAndView userLoginView = new ModelAndView();
		if (userDetailsTableService.verify(userDetails.getUsername(), userDetails.getPassword())) 
		{
			userLoginView.setViewName("userSide/userPanel");
			userLoginView.addObject("details", tableNameModelService.getAllTables());
			System.out.println(userDetails.getUserid());
			session.setAttribute("UserDetails",userDetails);
		} else {
			request.setAttribute("error", "Wrong Details...");
			userLoginView.setViewName("userSide/userLogin");
		}
		return userLoginView;
	}

	@RequestMapping(value = "/addEntry", method = RequestMethod.POST)
	public ModelAndView userPanel(HttpServletRequest request) {
		ModelAndView userPanelView = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("option"));
		List<TableFieldsModel> fieldDetails = tableFieldModelService.getAllTableDetails(id);
		userPanelView.addObject("fielddetails",fieldDetails);
		//userPanelView.addObject("fieldvalues",fieldValues);
		userPanelView.setViewName("userSide/userFieldsPanel");
		return userPanelView;
	}

	@RequestMapping(value="/saveEntry", method=RequestMethod.POST)
	public ModelAndView saveValues(HttpServletRequest request,HttpSession session) 
	{
		ModelAndView saveEntryView = new ModelAndView();
		Map<String, String[]> fieldVauesMap = request.getParameterMap();
		List<EntryValuesModel> fieldValues = entryValuesModelService.getEmptyFieldValues();
		EntryValuesModel temp = entryValuesModelService.getEntryValuesModelObject();
		EntryMakerModel user = new EntryMakerModel();
		UserDetailsTable detailsTable = (UserDetailsTable)session.getAttribute("UserDetails");
		int id = userDetailsTableService.getUserIDByObject(detailsTable);
		user.setUserID(id);
		entryMakerModelService.save(user);
		for(String x : fieldVauesMap.keySet())
		{
			temp.setFieldID(Integer.parseInt(x));
			temp.setFieldValue(fieldVauesMap.get(x)[0]);
			temp.setEntryID(id);
			entryValuesModelService.save(temp);
		}
		saveEntryView.addObject("details", tableNameModelService.getAllTables());
		saveEntryView.setViewName("userSide/userPanel");
		return saveEntryView;
	}
}
