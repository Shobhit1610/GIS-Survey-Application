package oro.gis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import oro.gis.model.UserDetailsTable;
import oro.gis.service.TableFieldsModelService;
import oro.gis.service.TableNameModelService;
import oro.gis.service.UserDetailsTableService;

@Controller
@RequestMapping(value="/admin/table")
public class AdminModifyTableController 
{

	@Autowired
	private TableNameModelService tableNameModelService;
	
	@Autowired
	private TableFieldsModelService tableFieldsModelService;
	
	@Autowired
	private UserDetailsTableService userDetailsTableService;
	
	@Autowired
	private Map<String,Object> placeholders;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public ModelAndView index(Model model)
	{
		ModelAndView indexView = new ModelAndView();
		
			long users = userDetailsTableService.count();
			long tables = tableNameModelService.count();
			placeholders = new HashMap<String,Object>();
			placeholders.put("users_count",users);
			placeholders.put("tables_count", tables);
			indexView.addAllObjects(placeholders);
			indexView.setViewName("adminSide/adminPanel");
			
		return indexView;
	}
	
	@RequestMapping(value="/addTable",method=RequestMethod.GET)
	public ModelAndView addTable()
	{
		ModelAndView addTableView = new ModelAndView();
			
			addTableView.setViewName("adminSide/createOrDeleteTable/addTable");
		
		return addTableView;
	}
	
	@RequestMapping(value="/addTable",method=RequestMethod.POST)
	public ModelAndView addTable(HttpServletRequest request)
	{
		ModelAndView addTableView = new ModelAndView();
		
			int duplicateId = tableNameModelService.checkDuplicate(tableNameModelService.getObject(request.getParameter("tablename.dataTypeName"), request.getParameter("tablename.dataTypeDescription"), request.getParameter("tablename.active")));
			placeholders = new HashMap<String,Object>();

			if(duplicateId == -1)
			{
				System.out.println(duplicateId);
				tableNameModelService.save(tableNameModelService.getObject(request.getParameter("tablename.dataTypeName"), request.getParameter("tablename.dataTypeDescription"), request.getParameter("tablename.active")));
				
				int id = tableNameModelService.getCurrentDataTypeId();
				int fieldNumber = Integer.parseInt(request.getParameter("field-no"));
				for(int i =0;i<fieldNumber;i++)
				{
					String fieldLabel = request.getParameter("field["+i+"].fieldLabel");
					String fieldDesc = request.getParameter("field["+i+"].fieldDesc");
					String fieldType = request.getParameter("field["+i+"].fieldType");
					String dataType = request.getParameter("field["+i+"].fieldLabel");
					int dataTypeID = id;
					String fieldRequired = request.getParameter("field["+i+"].fieldRequired");
					int sequence = Integer.parseInt(request.getParameter("field["+i+"].sequence"));
					
					tableFieldsModelService.save(tableFieldsModelService.getObject(fieldLabel, fieldDesc, fieldType, dataType, dataTypeID, fieldRequired, sequence));
					
					placeholders.put("confirmation","Table added successfully");
					
				}
				
			}
			else
			{
				System.out.println(duplicateId);
				placeholders.put("error","ERROR : Table can't be added");
				placeholders.put("confirmation"," Duplicate Entry found at ID - "+duplicateId);
			}
			
			long users = userDetailsTableService.count();
			long tables = tableNameModelService.count();
			placeholders.put("users_count",users);
			placeholders.put("tables_count", tables);
			addTableView.addAllObjects(placeholders);
			addTableView.setViewName("adminSide/adminPanel");
			
		return addTableView;
				
	}
	
	@RequestMapping(value="/showTables",method=RequestMethod.GET)
	public ModelAndView showUsers()
	{
		ModelAndView showUsersView = new ModelAndView();
		
			placeholders = new HashMap<String,Object>();
			placeholders.put("details",tableNameModelService.getTablesList());
		
			showUsersView.addAllObjects(placeholders);
			showUsersView.setViewName("adminSide/createOrDeleteTable/showAllTables");
		
		return showUsersView;
	}
	
		
	@RequestMapping(value = "/deleteTables", method = RequestMethod.POST)
	public ModelAndView deleteUsers(@RequestParam("tablesDeleted") List<String> values) 
	{
		ModelAndView deleteTableView = new ModelAndView();
		
			for(String value : values)
			{
				int id = Integer.parseInt(value);
				tableNameModelService.delete(tableNameModelService.getObject(id));
				tableFieldsModelService.delete(tableFieldsModelService.getObject(id));
			}
			
			long users = userDetailsTableService.count();
			long tables = tableNameModelService.count();
			placeholders = new HashMap<String,Object>();
			placeholders.put("users_count",users);
			placeholders.put("tables_count", tables);
			placeholders.put("confirmation", "Records deleted Successfully");
		
			deleteTableView.addAllObjects(placeholders);
			deleteTableView.setViewName("adminSide/adminPanel");
		
		return deleteTableView;
	}
}
