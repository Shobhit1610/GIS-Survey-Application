package oro.gis.service.custom;

import java.util.List;
import java.util.Map;

import oro.gis.model.TableNameModel;

public interface TableNameModelCustomService
{

	public TableNameModel getObject(int id,String name,String desc,String active);
	
	public int getCurrentDataTypeId();
	
	public List<Map<String,Object>> getTablesList();
	
	public TableNameModel getDetails(int id);

	public int checkDuplicate(TableNameModel tableName);
	
	public TableNameModel getObject();
	
	public TableNameModel getObject(int id);
}
