package oro.gis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="DATA_FIELDS")
@Component
public class TableFieldsModel 
{
	@Id
	@Column(name="FIELD_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int fieldID;
	
	@Column(name="FIELD_LABEL")
	private String fieldLabel;
	
	@Column(name="FIELD_DESC")
	private String fieldDesc;
	
	@Column(name="FIELD_TYPE")
	private String fieldType;
	
	@Column(name="DATA_TYPE")
	private String dataType;
	
	@Column(name="DATA_TYPE_ID")
	private int dataTypeID;
	
	@Column(name="FIELD_REQ")
	private String fieldRequired;
	
	@Column(name="SEQUENCE")
	private int sequence;
	
	public TableFieldsModel()
	{
		
	}
	
	
	public TableFieldsModel(String fieldLabel, String fieldDesc, String fieldType, String dataType, int dataTypeID,
			String fieldRequired, int sequence) {
		super();
		this.fieldLabel = fieldLabel;
		this.fieldDesc = fieldDesc;
		this.fieldType = fieldType;
		this.dataType = dataType;
		this.dataTypeID = dataTypeID;
		this.fieldRequired = fieldRequired;
		this.sequence = sequence;
	}


	public TableFieldsModel(int dataTypeID)
	{
		this.dataTypeID=dataTypeID;
	}

	public void setFieldID(int fieldID)
	{
		this.fieldID=fieldID;
	}
	public int getFieldID()
	{
		return fieldID;
	}
	public String getFieldLabel()
	{
		return fieldLabel;
	}
	public void setFieldLabel(String fieldLabel) 
	{
		this.fieldLabel = fieldLabel;
	}
	public String getFieldDesc() 
	{
		return fieldDesc;
	}
	public void setFieldDesc(String fieldDesc) 
	{
		this.fieldDesc = fieldDesc;
	}
	public String getFieldType() 
	{
		return fieldType;
	}
	public void setFieldType(String fieldType) 
	{
		this.fieldType = fieldType;
	}
	public String getDataType() 
	{
		return dataType;
	}
	public void setDataType(String dataType) 
	{
		this.dataType = dataType;
	}
	public int getDataTypeID() 
	{
		return dataTypeID;
	}
	public void setDataTypeID(int dataTypeID) 
	{
		this.dataTypeID = dataTypeID;
	}
	public String getFieldRequired() 
	{
		return fieldRequired;
	}
	public void setFieldRequired(String fieldRequired) 
	{
		this.fieldRequired = fieldRequired;
	}
	public int getSequence() 
	{
		return sequence;
	}
	public void setSequence(int sequence) 
	{
		this.sequence = sequence;
	}
	public boolean status() 
	{
		if(this.fieldID >=0 && this.fieldLabel!=null && this.fieldDesc!=null && this.fieldType!=null && this.dataType!=null && this.dataTypeID >=0 && this.fieldRequired!=null && this.sequence >=0 )
			return true;
		return false;
	}
	public String toString()
	{
		return fieldID+fieldType+fieldRequired+fieldLabel+fieldID+fieldDesc+dataTypeID+dataType;
	}
}
