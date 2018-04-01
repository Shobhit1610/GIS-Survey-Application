package oro.gis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.stereotype.Component;

@Entity
@Table(name="DATA_NAME")
@Component
public class TableNameModel
{
	@Id
	@Column(name="DATA_TYPE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int dataTypeID;
	
	@Column(name="DATA_TYPE_NAME")
	private String dataTypeName;
	
	@Column(name="DATA_TYPE_DESCRIPTION")
	private String dataTypeDescription;
	
	@Column(name="ACTIVE")
	private String active;
	
	public TableNameModel()
	{
		
	}
	
	public TableNameModel(String dataTypeName, String dataTypeDescription, String active) {
		this.dataTypeName = dataTypeName;
		this.dataTypeDescription = dataTypeDescription;
		this.active = active;
	}

	public int getDataTypeID() {
		return dataTypeID;
	}

	public void setDataTypeID(int dataTypeID) {
		this.dataTypeID = dataTypeID;
	}

	public TableNameModel(int dataTypeID)
	{
		this.dataTypeID=dataTypeID;
	}
	
	public String getDataTypeName() 
	{
		return dataTypeName;
	}
	public void setDataTypeName(String dataTypeName) 
	{
		this.dataTypeName = dataTypeName;
	}
	public String getDataTypeDescription() 
	{
		return dataTypeDescription;
	}
	public void setDataTypeDescription(String dataTypeDescription) 
	{
		this.dataTypeDescription = dataTypeDescription;
	}
	public String getActive() 
	{
		return active;
	}
	public void setActive(String active) 
	{
		this.active = active;
	}
	public boolean status()
	{
		if(this.dataTypeID>=0 && this.dataTypeName!=null && this.dataTypeDescription!=null && this.active!=null)
			return true;
		return false;
	}
	
	public String toString()
	{
		return dataTypeName+dataTypeDescription+dataTypeID+active;
	}
}
