package oro.gis.service.custom;

import java.util.List;
import java.util.Map;

public interface TableNameModelCustomService
{
	public List<Map<String,Object>> getAllTables();
	public int getCurrentDataTypeId();
}
