package oro.gis.service.custom;

import java.util.List;
import java.util.Map;

import oro.gis.model.TableNameModel;

public interface TableNameModelCustomService
{

	public TableNameModel getObject(String name,String desc,String active);
	
	public int getCurrentDataTypeId();
	
	public List<Map<String,Object>> getTablesList();
	
	public TableNameModel getObject(int id);

	public int checkDuplicate(TableNameModel tableName);
}
