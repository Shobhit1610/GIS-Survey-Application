package oro.gis.service.custom;

import java.util.List;
import java.util.Map;

import oro.gis.model.UserDetailsTable;

public interface UserDetailsTableCustomService
{
	public UserDetailsTable getObject();
	
	public List<Map<String,Object>> getUserList(); 
	
	public UserDetailsTable getUserObjectByID(int userid);
	
	public void update(UserDetailsTable userDetails, int id);
	
	public boolean verify(String userName,String password);
	
	public UserDetailsTable getUserObjectByCredentials(String username,String password);

	public int checkDuplicate(UserDetailsTable userDetails);
}
