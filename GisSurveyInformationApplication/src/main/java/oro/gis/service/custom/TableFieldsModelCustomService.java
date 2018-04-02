package oro.gis.service.custom;

import java.util.List;

import oro.gis.model.TableFieldsModel;
import oro.gis.model.TableNameModel;


public interface TableFieldsModelCustomService 
{

	public TableFieldsModel getObject(String fieldLabel, String fieldDesc, String fieldType, String dataType, int dataTypeID,String fieldRequired, int sequence);
	
	public TableFieldsModel getObject(int id);
	
	public List getTablesList(int dataTypeID);

}
