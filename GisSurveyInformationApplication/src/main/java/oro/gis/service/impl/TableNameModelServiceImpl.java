package oro.gis.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import oro.gis.model.TableNameModel;
import oro.gis.model.UserDetailsTable;
import oro.gis.service.custom.TableNameModelCustomService;

public class TableNameModelServiceImpl implements TableNameModelCustomService
{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public TableNameModel getObject(int id ,String name,String desc,String active)
	{
		return new TableNameModel(name,desc,active);
	}
	
	public int getCurrentDataTypeId()
	{
		return this.jdbcTemplate.queryForObject("select max(data_type_id) from data_name",Integer.class);
	}
	
	public List<Map<String, Object>> getTablesList() 
	{
		return this.jdbcTemplate.queryForList("select * from data_name");
	}

	public TableNameModel getDetails(int tableid)
	{
		TableNameModel requiredObject = (TableNameModel)this.jdbcTemplate.queryForObject(
														"select * from data_name where data_type_id = ?",
														new Object[] {tableid},
														new RowMapper() {
																			@Override
																			public Object mapRow(ResultSet rs, int rowNum) throws SQLException 
																			{
																				TableNameModel table = new TableNameModel();
																				table.setDataTypeID(rs.getInt("data_type_id"));
																				table.setDataTypeName(rs.getString("data_type_name"));
																				table.setDataTypeDescription(rs.getString("data_type_description"));
																				table.setActive(rs.getString("active"));
																				return table;
																			}
																		});
		return requiredObject;
	}
	
	public int checkDuplicate(TableNameModel tableName)
	{
		int cnt = this.jdbcTemplate.queryForObject("select count(*) from data_name where data_type_name=?",new Object[] {tableName.getDataTypeName()},Integer.class);
		if(cnt>0)
		{
			int id = this.jdbcTemplate.queryForObject("select data_type_id from data_name where data_type_name=?",new Object[] {tableName.getDataTypeName()},Integer.class);
			return id;
		}
		else
			return -1;
	}
	

	public TableNameModel getObject()
	{
		return new TableNameModel();
	}

	public TableNameModel getObject(int id)
	{
		return new TableNameModel(id);
	}

}
