package oro.gis.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import oro.gis.model.TableFieldsModel;
import oro.gis.model.TableNameModel;
import oro.gis.service.custom.TableNameModelCustomService;

public class TableNameModelServiceImpl implements TableNameModelCustomService
{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> getAllTables() 
	{
		return this.jdbcTemplate.queryForList("select * from data_name");
	}

	public int getCurrentDataTypeId()
	{
		return this.jdbcTemplate.queryForObject("select max(data_type_id) from data_name",Integer.class);
	}
	
	public TableNameModel getObject(String name,String desc,String active)
	{
		return new TableNameModel(name,desc,active);
	}
	
	public TableNameModel getObject(int id)
	{
		return new TableNameModel(id);
	}
	public TableNameModel getObject()
	{
		return new TableNameModel();
	}

	@SuppressWarnings("unchecked")
	public TableNameModel getTableNameObjectByID(int tableid)
	{
		TableNameModel requiredObject = (TableNameModel)this.jdbcTemplate.queryForObject(
														"select * from data_name where user_id = ?",
														new Object[] {tableid},
														new RowMapper() {
																			@Override
																			public Object mapRow(ResultSet rs, int rowNum) throws SQLException 
																			{
																				TableNameModel table = new TableNameModel();
																				table.setDataTypeID(rs.getInt("data_type_id"));
																				table.setDataTypeName(rs.getString("data_type-name"));
																				table.setDataTypeDescription(rs.getString("data_type_description"));
																				table.setActive(rs.getString("active"));
																				return table;
																			}
																		});
		return requiredObject;
	}
}
