package oro.gis.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import oro.gis.model.EntryValuesModel;
import oro.gis.service.custom.EntryValuesModelCustomService;

public class EntryValuesModelServiceImpl implements EntryValuesModelCustomService

{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<EntryValuesModel> getFieldDataRows(int fieldId,int dataTypeId)
	{

	List<Map<String, Object>> listOfFieldIds = this.jdbcTemplate.queryForList("select field_id from data_fields where data_type_id= ?",new Object[] {new Integer(dataTypeId)}); 
	int firstFieldId =(Integer)listOfFieldIds.get(0).get("field_id");
	List<Map<String, Object>> listOfFieldsData = this.jdbcTemplate.queryForList("select * from data_entry_values where field_id= ?",new Object[] {new Integer(fieldId)}); 
	List<Map<String,Object>> entryIds = this.jdbcTemplate.queryForList("select entry_id from data_entry_values where field_id = ?",new Object[] {new Integer(firstFieldId)});
	EntryValuesModel tableRow;
	
	Map<Integer,EntryValuesModel> listOfObjects = new LinkedHashMap<Integer,EntryValuesModel>();
	for(Map<String,Object> x : entryIds)
	{
		tableRow = new EntryValuesModel();
		tableRow.setEntryID((Integer)x.get("entry_id"));
		tableRow.setFieldID(fieldId);
		tableRow.setFieldValue("-----------");
		listOfObjects.put((Integer)x.get("entry_id"),tableRow);
	}
	
	for(Map<String,Object> row : listOfFieldsData)
	{
		tableRow = new EntryValuesModel();
		tableRow.setEntryID((int)row.get("entry_id"));
		tableRow.setFieldID(fieldId);
		tableRow.setFieldValue((String)row.get("field_value"));
		listOfObjects.put((Integer)row.get("entry_id"),tableRow);
	}
	List<EntryValuesModel> objectList = new ArrayList<EntryValuesModel>(listOfObjects.values()); 
	return objectList;

	}
	
	public void deletePrevious(EntryValuesModel model)
	{
		int fieldId = model.getFieldID();
		int entryId = model.getEntryID();
		
		this.jdbcTemplate.update("delete from data_entry_values where entry_id = ? AND field_id = ? ",new Object[] {new Integer(entryId),new Integer(fieldId)});
		
	}
}
