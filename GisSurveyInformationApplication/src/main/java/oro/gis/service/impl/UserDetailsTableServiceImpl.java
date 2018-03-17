package oro.gis.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import oro.gis.model.UserDetailsTable;
import oro.gis.service.custom.UserDetailsTableCustomService;

public class UserDetailsTableServiceImpl implements UserDetailsTableCustomService
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String,Object>> getUserList()
	{
		return this.jdbcTemplate.queryForList("select * from userdetails");
	}
	
	public boolean verify(String username,String password)
	{
		int cnt = this.jdbcTemplate.queryForObject("select count(*) from userdetails where username=? AND password=?",new Object[] {username,password},Integer.class);
		if(cnt>0)
			return true;
		return false;
		
	}
	
	public void update(UserDetailsTable userDetailsTable,int userID)
	{
		this.jdbcTemplate.update("update userdetails set name=?,username=?,password=? where user_id=?",new Object[] {userDetailsTable.getName(),userDetailsTable.getUsername(),userDetailsTable.getPassword(),userID});
	}

	@Override
	public int getUserIDByObject(UserDetailsTable userDetailsTable) 
	{
		int id = this.jdbcTemplate.queryForObject("select user_id from userdetails where username=? AND password = ?",new Object[] {userDetailsTable.getUsername(),userDetailsTable.getPassword()},Integer.class);
		return id;
	}
}