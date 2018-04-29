package oro.gis.service.custom;

import java.util.List;

import oro.gis.model.TableFieldsModel;


public interface TableFieldsModelCustomService 
{

	public TableFieldsModel getObject(String fieldLabel, String fieldDesc, String fieldType, String dataType, int dataTypeID,String fieldRequired, int sequence,int fieldId);
	
	public TableFieldsModel getObject(int id);
	
	public List<TableFieldsModel> getFieldsList(int dataTypeID);
	
	public TableFieldsModel getObject();

	public int getFieldCount(int dataTypeId);
}
