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
	
	private List<TableFieldsModel> allFields;
	
	public void deleteAllByDataTypeID(int dataTypeID)
	{
		jdbcTemplate.update("delete from data_fields where data_type_id = ?",new Object[] {Long.valueOf(dataTypeID)});
	}

	public List<TableFieldsModel> getAllTableDetails(int id) 
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

	public List<TableFieldsModel> getModelObjectList() 
	{
		this.allFields = new ArrayList<TableFieldsModel>();
		return this.allFields;
	}
	
	public TableFieldsModel getObject(String fieldLabel, String fieldDesc, String fieldType, String dataType, int dataTypeID,
			String fieldRequired, int sequence)
	{
		return new TableFieldsModel( fieldLabel,  fieldDesc,  fieldType,  dataType,  dataTypeID,fieldRequired,  sequence);
	}
	
	public TableFieldsModel getObject(int id)
	{
		return new TableFieldsModel(id);
	}
	
	public TableFieldsModel getObject()
	{
		return new TableFieldsModel();
	}
	
	@SuppressWarnings("unchecked")
	public TableFieldsModel getTableFieldObjectByID(int tableid)
	{
		TableFieldsModel requiredObject = (TableFieldsModel)this.jdbcTemplate.queryForObject(
														"select * from data_fields where user_id = ?",
														new Object[] {tableid},
														new RowMapper() {
																			@Override
																			public Object mapRow(ResultSet rs, int rowNum) throws SQLException 
																			{
																				TableFieldsModel field = new TableFieldsModel();
																				field.setFieldID(rs.getInt("field_id"));
																				field.setDataType(rs.getString("data_type"));
																				field.setDataTypeID(rs.getInt("data_type_id"));
																				field.setFieldDesc(rs.getString("field_desc"));
																				field.setFieldLabel(rs.getString("field_label"));
																				field.setFieldRequired(rs.getString("field_req"));
																				field.setFieldType(rs.getString("field_type"));
																				field.setSequence(rs.getInt("sequence"));
																				return field;
																			}
																		});
		return requiredObject;
	}
}	