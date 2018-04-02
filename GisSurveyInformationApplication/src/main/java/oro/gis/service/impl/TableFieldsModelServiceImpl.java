package oro.gis.service.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import oro.gis.model.TableFieldsModel;
import oro.gis.model.TableNameModel;
import oro.gis.model.UserDetailsTable;
import oro.gis.service.custom.TableFieldsModelCustomService;

public class TableFieldsModelServiceImpl implements TableFieldsModelCustomService
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public TableFieldsModel getObject(String fieldLabel, String fieldDesc, String fieldType, String dataType, int dataTypeID,
			String fieldRequired, int sequence)
	{
		return new TableFieldsModel( fieldLabel,  fieldDesc,  fieldType,  dataType,  dataTypeID,fieldRequired,  sequence);
	}
	
	public TableFieldsModel getObject(int id)
	{
		return new TableFieldsModel(id);
	}
	
	public List<TableFieldsModel> getTablesList(int id) 
	{
		List<Map<String, Object>> listOfFields = this.jdbcTemplate.queryForList("select * from data_fields where data_type_id= ?",new Object[] {new Integer(id)}); 
		List<TableFieldsModel> listOfObjects = new ArrayList<TableFieldsModel>();
		TableFieldsModel tableRow;
		for(Map<String,Object> row : listOfFields)
		{
			tableRow = new TableFieldsModel();
			tableRow.setDataType((String)row.get("data_type"));
			tableRow.setDataTypeID((int)row.get("data_type_id"));
			tableRow.setFieldDesc((String)row.get("field_desc"));
			tableRow.setFieldID((int)row.get("field_id"));
			tableRow.setFieldLabel((String)row.get("field_label"));
			tableRow.setFieldRequired((String)row.get("field_req"));
			tableRow.setFieldType((String)row.get("field_type"));
			tableRow.setSequence((int)row.get("sequence"));
			listOfObjects.add(tableRow);
		}
		return listOfObjects;
	}

}	