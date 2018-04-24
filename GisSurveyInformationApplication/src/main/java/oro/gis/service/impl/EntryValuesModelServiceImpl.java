package oro.gis.service.impl;

import java.util.ArrayList;
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

	public List<EntryValuesModel> getFieldDataRows(int fieldId)
	{

	List<Map<String, Object>> listOfFields = this.jdbcTemplate.queryForList("select * from data_entry_values where field_id= ?",new Object[] {new Integer(fieldId)}); 
	List<EntryValuesModel> listOfObjects = new ArrayList<EntryValuesModel>();
	EntryValuesModel tableRow;
	for(Map<String,Object> row : listOfFields)
	{
		tableRow = new EntryValuesModel();
		tableRow.setSno((int)row.get("s_no"));
		tableRow.setEntryID((int)row.get("entry_id"));
		tableRow.setFieldID((int)row.get("field_id"));
		tableRow.setFieldValue((String)row.get("field_value"));
		listOfObjects.add(tableRow);
	}
	return listOfObjects;

	}
}
