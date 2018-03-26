package oro.gis.service.custom;

import java.util.List;


public interface TableFieldsModelCustomService 
{
	public void deleteAllByDataTypeID(int dataTypeID);
	
	public List getAllTableDetails(int dataTypeID);
	
	public List getModelObjectList();
}
