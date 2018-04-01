package oro.gis.bean;

import oro.gis.model.TableFieldsModel;

public class TableDetailsBean {

	private String dataTypeName;

	private String dataTypeDescription;

	private String active;

	private TableFieldsModel[] list;

	public String getDataTypeName() {
		return dataTypeName;
	}

	public void setDataTypeName(String dataTypeName) {
		this.dataTypeName = dataTypeName;
	}

	public String getDataTypeDescription() {
		return dataTypeDescription;
	}

	public void setDataTypeDescription(String dataTypeDescription) {
		this.dataTypeDescription = dataTypeDescription;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public TableFieldsModel[] getList() {
		return list;
	}

	public void setList(TableFieldsModel[] list) {
		this.list = list;
	}

	public void addObject()
	{
		
	}
}
