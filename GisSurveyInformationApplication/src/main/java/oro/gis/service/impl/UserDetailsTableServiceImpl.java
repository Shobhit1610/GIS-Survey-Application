package oro.gis.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import oro.gis.model.UserDetailsTable;
import oro.gis.service.custom.UserDetailsTableCustomService;

public class UserDetailsTableServiceImpl implements UserDetailsTableCustomService
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
		public UserDetailsTable getObject()
	{
		return new UserDetailsTable();
	}
	
	public List<Map<String,Object>> getUserList()
	{
		return this.jdbcTemplate.queryForList("select * from userdetails");
	}
	
	@SuppressWarnings("unchecked")
	public UserDetailsTable getUserObjectByID(int userid)
	{
		UserDetailsTable requiredObject = (UserDetailsTable)this.jdbcTemplate.queryForObject(
														"select * from userdetails where user_id = ?",
														new Object[] {userid},
														new RowMapper() {
																			@Override
																			public Object mapRow(ResultSet rs, int rowNum) throws SQLException 
																			{
																				UserDetailsTable user = new UserDetailsTable();
																				user.setUserid(rs.getInt("user_id"));
																				user.setName(rs.getString("name"));
																				user.setUsername(rs.getString("username"));
																				user.setPassword(rs.getString("password"));
																				return user;
																			}
																		});
		return requiredObject;
	}
	
	public void update(UserDetailsTable userDetailsTable,int userID)
	{
		this.jdbcTemplate.update("update userdetails set name=?,username=?,password=? where user_id=?",new Object[] {userDetailsTable.getName(),userDetailsTable.getUsername(),userDetailsTable.getPassword(),userID});
	}
	
	public boolean verify(String username,String password)
	{
		int cnt = this.jdbcTemplate.queryForObject("select count(*) from userdetails where username=? AND password=?",new Object[] {username,password},Integer.class);
		if(cnt>0)
			return true;
		return false;
		
	}
	
	@SuppressWarnings("unchecked")
	public UserDetailsTable getUserObjectByCredentials(String username,String password)
	{
		UserDetailsTable requiredObject = (UserDetailsTable)this.jdbcTemplate.queryForObject(
														"select * from userdetails where username=? AND password=?",
														new Object[] {username,password},
														new RowMapper() {
																			@Override
																			public Object mapRow(ResultSet rs, int rowNum) throws SQLException 
																			{
																				UserDetailsTable user = new UserDetailsTable();
																				user.setUserid(rs.getInt("user_id"));
																				user.setName(rs.getString("name"));
																				user.setUsername(rs.getString("username"));
																				user.setPassword(rs.getString("password"));
																				return user;
																			}
																		});
		return requiredObject;
	}
}