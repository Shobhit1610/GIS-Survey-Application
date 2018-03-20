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

import oro.gis.model.TableFieldsModel;
import oro.gis.model.TableNameModel;
import oro.gis.service.TableFieldsModelService;
import oro.gis.service.TableNameModelService;
import oro.gis.service.UserDetailsTableService;

@Controller
@RequestMapping(value="/admin/table")
public class AdminModifyTableController 
{

	private int noOfColumns;
	
	@Autowired
	private TableNameModelService tableNameModelService;
	
	@Autowired
	private TableFieldsModelService tableFieldsModelService;
	
	@Autowired
	private UserDetailsTableService userDetailsTableService;
	
	@Autowired
	private Map<String,Object> placeholders;
	
	
	@RequestMapping(value="/addTable",method=RequestMethod.POST)
	public ModelAndView addTable(@ModelAttribute("tablenamedetails") TableNameModel tableName,@ModelAttribute("tablefieldsdetails") TableFieldsModel tableFields,HttpServletRequest request)
	{
		int dataTypeID;
		ModelAndView addTableView = new ModelAndView();
		if(tableFields.status())
		{
			tableFieldsModelService.save(tableFields);
			this.noOfColumns--;
			if(noOfColumns!= 0)
			{
				request.setAttribute("noOfColumns",noOfColumns);
				addTableView.setViewName("adminSide/createOrDeleteTable/addTableFields");
			}
			else
			{
				request.setAttribute("confirmation","Table and its fields added Successfully");
				long users = userDetailsTableService.count();
				long tables = tableNameModelService.count();
				placeholders = new HashMap<String,Object>();
				placeholders.put("users_count",users);
				placeholders.put("tables_count", tables);
				addTableView.addAllObjects(placeholders);
				addTableView.setViewName("adminSide/adminPanel");
			}
		}
		else if(tableName.status())
		{
			tableNameModelService.save(tableName);
			this.noOfColumns = Integer.parseInt(request.getParameter("totalColumns"));
			request.setAttribute("noOfColumns",noOfColumns);
			dataTypeID=tableNameModelService.getCurrentDataTypeId();
			request.setAttribute("datatypeid",dataTypeID);
			addTableView.setViewName("adminSide/createOrDeleteTable/addTableFields");
		}
		else
		{
			addTableView.setViewName("adminSide/createOrDeleteTable/addTableName");
		}
		return addTableView;
				
	}
	
	@RequestMapping(value="/deleteTable",method=RequestMethod.POST)
	public ModelAndView deleteTable(HttpServletRequest request)
	{
		ModelAndView deletedTableView = new ModelAndView();
		if(request.getParameter("tableDeleted")==null)
		{
			deletedTableView.addObject("details",tableNameModelService.getAllTables());
			deletedTableView.addObject("show",true);
			deletedTableView.setViewName("adminSide/createOrDeleteTable/deleteTable");
		}
		else
		{
		int id = Integer.parseInt((String)request.getParameter("tableDeleted"));
		tableNameModelService.delete(new TableNameModel(id));
		tableFieldsModelService.deleteAllByDataTypeID(id);
		request.setAttribute("confirmation","Table and its fields deleted Successfully");
		long users = userDetailsTableService.count();
		long tables = tableNameModelService.count();
		placeholders = new HashMap<String,Object>();
		placeholders.put("users_count",users);
		placeholders.put("tables_count", tables);
		deletedTableView.addAllObjects(placeholders);
		deletedTableView.setViewName("adminSide/adminPanel");
		}
		return deletedTableView;
	}
	
	@RequestMapping(value="/showAllTables" ,method=RequestMethod.POST)
	public ModelAndView showAllTables()
	{
		ModelAndView showTableView = new ModelAndView();
		showTableView.addObject("details",tableNameModelService.getAllTables());
		showTableView.addObject("show",false);
		showTableView.setViewName("adminSide/createOrDeleteTable/showAllTables");
		return showTableView;
	}

}
