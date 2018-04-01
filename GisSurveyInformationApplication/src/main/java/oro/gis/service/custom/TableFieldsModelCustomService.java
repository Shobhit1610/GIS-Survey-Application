package oro.gis.service.custom;

import java.util.List;

import oro.gis.model.TableFieldsModel;
import oro.gis.model.TableNameModel;


public interface TableFieldsModelCustomService 
{
	public void deleteAllByDataTypeID(int dataTypeID);
	
	public List getAllTableDetails(int dataTypeID);
	
	public List getModelObjectList();
	
	public TableFieldsModel getObject(int id);
	public TableFieldsModel getObject(String fieldLabel, String fieldDesc, String fieldType, String dataType, int dataTypeID,
			String fieldRequired, int sequence);
	public TableFieldsModel getObject();
	public TableFieldsModel getTableFieldObjectByID(int tableid);
}
