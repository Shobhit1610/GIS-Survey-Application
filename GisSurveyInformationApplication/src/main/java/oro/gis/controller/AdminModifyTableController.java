package oro.gis.controller;

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

@Controller
@RequestMapping(value="/admin/table")
public class AdminModifyTableController 
{

	private int noOfColumns;
	
	@Autowired
	private TableNameModelService tableNameModelService;
	
	@Autowired
	private TableFieldsModelService tableFieldsModelService;
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public ModelAndView index()
	{
		ModelAndView indexView = new ModelAndView();
		indexView.addObject("details",tableNameModelService.getAllTables());
		indexView.setViewName("adminSide/createOrDeleteTable/adminclicktable");
		return indexView;
	}
	
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
		int id = Integer.parseInt((String)request.getParameter("option"));
		tableNameModelService.delete(new TableNameModel(id));
		tableFieldsModelService.deleteAllByDataTypeID(id);
		request.setAttribute("confirmation","Table and its fields deleted Successfully");
		deletedTableView.setViewName("adminSide/adminPanel");
		return deletedTableView;
	}

}
