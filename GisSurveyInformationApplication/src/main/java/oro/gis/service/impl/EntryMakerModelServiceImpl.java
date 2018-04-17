package oro.gis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import oro.gis.service.EntryMakerModelService;
import oro.gis.service.custom.EntryMakerModelCustomService;

public class EntryMakerModelServiceImpl implements EntryMakerModelCustomService 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int getEntryId() 
	{
		int id = this.jdbcTemplate.queryForObject("select max(entry_id) from data_entry_maker;",Integer.class);
		return id;
	}

}
