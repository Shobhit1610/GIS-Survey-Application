package oro.gis.service.custom;

import java.util.List;
import java.util.Map;

import oro.gis.model.TableFieldsModel;
import oro.gis.model.TableNameModel;

public interface TableNameModelCustomService
{
	public List<Map<String,Object>> getAllTables();
	public int getCurrentDataTypeId();
	public TableNameModel getObject(String name,String desc,String active);
	public TableNameModel getObject(int id);
	public TableNameModel getObject();
	public TableNameModel getTableNameObjectByID(int tableid);
}
