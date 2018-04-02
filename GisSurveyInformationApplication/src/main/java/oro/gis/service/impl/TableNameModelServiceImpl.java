package oro.gis.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import oro.gis.model.TableNameModel;
import oro.gis.service.custom.TableNameModelCustomService;

public class TableNameModelServiceImpl implements TableNameModelCustomService
{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public TableNameModel getObject(String name,String desc,String active)
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

	public TableNameModel getObject(int id)
	{
		return new TableNameModel(id);
	}
}
