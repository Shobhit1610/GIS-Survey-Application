package oro.gis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="data_entry_values")
@Component
public class EntryValuesModel 
{
	@Id
	@Column(name="s_no")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sno;
	
	@Column(name="entry_id")
	private int entryID;
	
	@Column(name="field_id")
	private int fieldID;
	
	@Column(name="field_value")
	String fieldValue;

	/*public EntryValuesModel()
	{
		this.entryID=-1;
		this.fieldID=-1;
		this.fieldValue=null;
	}*/
	public void setSno(int sno)
	{
		this.sno = sno;
	}
	
	public int getSno()
	{
		return this.sno;
	}
	
	public int getEntryID() {
		return entryID;
	}

	public void setEntryID(int entryID) {
		this.entryID = entryID;
	}

	public int getFieldID() {
		return fieldID;
	}

	public void setFieldID(int fieldID) {
		this.fieldID = fieldID;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	
}
