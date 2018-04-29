package oro.gis.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import oro.gis.model.EntryValuesModel;
import oro.gis.model.TableFieldsModel;
import oro.gis.model.TableNameModel;
import oro.gis.service.EntryValuesModelService;
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
	private EntryValuesModelService entryValuesModelService;
	
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
		
			int duplicateId = tableNameModelService.checkDuplicate(new TableNameModel(request.getParameter("tablename.dataTypeName"), request.getParameter("tablename.dataTypeDescription"), request.getParameter("tablename.active")));
			placeholders = new HashMap<String,Object>();

			if(duplicateId == -1)
			{
				tableNameModelService.save(new TableNameModel(request.getParameter("tablename.dataTypeName"), request.getParameter("tablename.dataTypeDescription"), request.getParameter("tablename.active")));
				
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
					
					tableFieldsModelService.save(new TableFieldsModel(fieldLabel, fieldDesc, fieldType, dataType, dataTypeID, fieldRequired, sequence));
					
					placeholders.put("confirmation","Table added successfully");
					
				}
				
			}
			else
			{
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
	
	@RequestMapping(value = "/editTable", method = RequestMethod.GET)
	public ModelAndView editTable(@RequestParam("tableid") String tableId) 
	{
		ModelAndView editTableView = new ModelAndView();
		
			int id = Integer.parseInt(tableId);
			
			placeholders = new HashMap<String,Object>();
			placeholders.put("newtablenamedetails", tableNameModelService.getObject());
			placeholders.put("oldtablenamedetails",tableNameModelService.getDetails(id));
			placeholders.put("oldtablefieldsdetails",tableFieldsModelService.getFieldsList(id));
			
			editTableView.addAllObjects(placeholders);
			editTableView.setViewName("adminSide/createOrDeleteTable/editTable");
		
		return editTableView;
	}
	
	@RequestMapping(value="/editTable",method=RequestMethod.POST)
	public ModelAndView editTable(HttpServletRequest request)
	{
		ModelAndView editTableView = new ModelAndView();
			
			int dataTypeId = Integer.parseInt(request.getParameter("tablename.dataTypeId")); 
			TableNameModel editedTable = new TableNameModel(dataTypeId,request.getParameter("tablename.dataTypeName"), request.getParameter("tablename.dataTypeDescription"), request.getParameter("tablename.active"));
			placeholders = new HashMap<String,Object>();
			/*
			int duplicateId = tableNameModelService.checkDuplicate(editedTable);
			
			if(duplicateId == -1)
			{
			*/	tableNameModelService.save(editedTable);
				
				int fieldCount = tableFieldsModelService.getFieldCount(dataTypeId);
				for(int i =1;i<=fieldCount;i++)
				{
					String fieldLabel = request.getParameter("field["+i+"].fieldLabel");
					String fieldDesc = request.getParameter("field["+i+"].fieldDesc");
					String fieldType = request.getParameter("field["+i+"].fieldType");
					String dataType = "ACTIVITY";
					String fieldRequired = request.getParameter("field["+i+"].fieldRequired");
					int sequence = Integer.parseInt(request.getParameter("field["+i+"].sequence"));
					int fieldId = Integer.parseInt(request.getParameter("field["+i+"].fieldId"));
					
					System.out.println(i+" "+fieldLabel+" "+fieldDesc+" "+fieldType+" "+dataType+" "+dataTypeId+" "+fieldRequired+" "+sequence+" "+fieldId);
					tableFieldsModelService.save(new TableFieldsModel(fieldLabel, fieldDesc,  fieldType,  dataType,  dataTypeId, fieldRequired,  sequence, fieldId));
					
					
				}
				
				int extraFieldCount = Integer.parseInt(request.getParameter("field-no"));
				for(int i =0;i<extraFieldCount;i++)
				{
					String fieldLabel = request.getParameter("fieldextra["+i+"].fieldLabel");
					String fieldDesc = request.getParameter("fieldextra["+i+"].fieldDesc");
					String fieldType = request.getParameter("fieldextra["+i+"].fieldType");
					String dataType = "ACTIVITY";
					String fieldRequired = request.getParameter("fieldextra["+i+"].fieldRequired");
					int sequence =i+fieldCount;
					
					System.out.println(i+" "+fieldLabel+" "+fieldDesc+" "+fieldType+" "+dataType+" "+dataTypeId+" "+fieldRequired+" "+sequence);
					tableFieldsModelService.save(new TableFieldsModel(fieldLabel, fieldDesc,  fieldType,  dataType,  dataTypeId, fieldRequired,  sequence));
					System.out.println("Extra Field added");
					
				}
				placeholders.put("confirmation","Table edited successfully");
				
			/*}
			
			else
			{
				placeholders.put("error","Duplicate Entry");
				//placeholders.put("confirmation"," Duplicate Entry found at ID - "+duplicateId);
			}
			*/	
			long users = userDetailsTableService.count();
			long tables = tableNameModelService.count();
			placeholders.put("users_count",users);
			placeholders.put("tables_count", tables);
			
			editTableView.addAllObjects(placeholders);
			editTableView.setViewName("adminSide/adminPanel");
		
		return editTableView;
	}
	
	@RequestMapping(value = "/deleteTables", method = RequestMethod.POST)
	public ModelAndView deleteTables(@RequestParam("tablesDeleted") List<String> values) 
	{
		ModelAndView deleteTableView = new ModelAndView();
		
			for(String value : values)
			{
				int id = Integer.parseInt(value);
				tableNameModelService.delete(tableNameModelService.getObject(id));
				List<TableFieldsModel> fieldsDeleted = tableFieldsModelService.getFieldsList(id);
				for(TableFieldsModel field : fieldsDeleted)
					tableFieldsModelService.delete(field);
			}
			
			long users = userDetailsTableService.count();
			long tables = tableNameModelService.count();
			placeholders = new HashMap<String,Object>();
			placeholders.put("users_count",users);
			placeholders.put("tables_count", tables);
			placeholders.put("confirmation", "Tables deleted Successfully");
		
			deleteTableView.addAllObjects(placeholders);
			deleteTableView.setViewName("adminSide/adminPanel");
		
		return deleteTableView;
	}
	
	@RequestMapping(value = "/viewAllTables" , method = RequestMethod.GET)
	public ModelAndView showData()
	{
		ModelAndView showDataView = new ModelAndView();
			
			placeholders = new HashMap<String,Object>();
			placeholders.put("details",tableNameModelService.getTablesList());
			
			showDataView.addAllObjects(placeholders);
			showDataView.setViewName("adminSide/createOrDeleteTable/viewAllTables");
		
		
		return showDataView;
	}
	
	@RequestMapping(value = "/viewTableData" , method = RequestMethod.GET)
	public ModelAndView showData(@RequestParam("tableid") String tableId)
	{
		ModelAndView showDataView = new ModelAndView();
		
			int tableID = Integer.parseInt(tableId);
			TableNameModel tableName = tableNameModelService.getDetails(tableID);
			List<TableFieldsModel> tableFieldsList = tableFieldsModelService.getFieldsList(tableID);
			List<List<EntryValuesModel>> modalMap = new ArrayList<List<EntryValuesModel>>();
			for(TableFieldsModel x : tableFieldsList)
			{
				List<EntryValuesModel> row = entryValuesModelService.getFieldDataRows(x.getFieldID(),tableID);
				modalMap.add(row);
				
			}
					placeholders = new HashMap<String,Object>();
			placeholders.put("tableName",tableName);
			placeholders.put("tableFieldsList",tableFieldsList);
			placeholders.put("modalMap",modalMap);
			showDataView.addAllObjects(placeholders);
			showDataView.setViewName("adminSide/createOrDeleteTable/viewTableData");
			
		return showDataView;
	}
	
	@RequestMapping(value="/editTableData",method=RequestMethod.GET)
	public ModelAndView editTableData(@RequestParam("tableid") String tableId, @RequestParam("row") String row,HttpServletRequest request)
	{
		ModelAndView editTableDataView = new ModelAndView();
			
			int tableID = Integer.parseInt(tableId);
			int rowNumber = Integer.parseInt(row);
			
			HttpSession session = request.getSession();
			session.setAttribute("tableID",tableID);
			session.setAttribute("rowNumber",rowNumber);
		
			TableNameModel tableName = tableNameModelService.getDetails(tableID);
			List<TableFieldsModel> tableFieldsList = tableFieldsModelService.getFieldsList(tableID);
			
			List<List<EntryValuesModel>> modalMap = new ArrayList<List<EntryValuesModel>>();
			for(TableFieldsModel x : tableFieldsList)
			{
				List<EntryValuesModel> rowItems = entryValuesModelService.getFieldDataRows(x.getFieldID(),tableID);
				modalMap.add(rowItems);
				
			}
			
			placeholders = new HashMap<String,Object>();
			placeholders.put("rownumber",rowNumber);
			placeholders.put("modalmap",modalMap);
			placeholders.put("tabledetails",tableName);
			placeholders.put("fielddetails",tableFieldsList);
			editTableDataView.addAllObjects(placeholders);
			
			editTableDataView.setViewName("adminSide/createOrDeleteTable/editTableData");
		
		return editTableDataView;
	}
	
	@RequestMapping(value="/editTableData",method=RequestMethod.POST)
	public ModelAndView editTableData(HttpServletRequest request)
	{
		ModelAndView editTableDataView = new ModelAndView();

			HttpSession session = request.getSession();
			int tableID = (Integer)session.getAttribute("tableID");
			int rowNumber = (Integer)session.getAttribute("rowNumber");
			
			List<TableFieldsModel> tableFieldsList = tableFieldsModelService.getFieldsList(tableID);
			Map<String,String[]> requestMap = request.getParameterMap();
			List<List<EntryValuesModel>> modalMap = new ArrayList<List<EntryValuesModel>>();
			
			for(TableFieldsModel x : tableFieldsList)
			{
				List<EntryValuesModel> rowItems = entryValuesModelService.getFieldDataRows(x.getFieldID(),tableID);
				modalMap.add(rowItems);
				
			}
			
			for(int i=0;i<modalMap.size();i++)
				
			{	try
				{
				EntryValuesModel field = new EntryValuesModel();
				field.setEntryID(modalMap.get(i).get(rowNumber).getEntryID());
				field.setFieldID(modalMap.get(i).get(rowNumber).getFieldID());
				
				String values[] = requestMap.get(Integer.toString(field.getFieldID()));
				for(String a : values) {
					System.out.println(a);
				}
				field.setFieldValue(values[0]);
				entryValuesModelService.deletePrevious(field);
				entryValuesModelService.save(field);
				}
				
				catch(Exception e)
				{
					break;
				}
			}

			
			
			long users = userDetailsTableService.count();
			long tables = tableNameModelService.count();
			placeholders = new HashMap<String,Object>();
			placeholders.put("users_count",users);
			placeholders.put("tables_count", tables);
			placeholders.put("confirmation", "User Entry edited Successfully");
			editTableDataView.addAllObjects(placeholders);
			editTableDataView.setViewName("adminSide/adminPanel");
		
		return editTableDataView;
	}
	
}
