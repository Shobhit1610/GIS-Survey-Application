package oro.gis.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="data_entry_maker")
@Component
public class EntryMakerModel 
{
	@Id
	@Column(name="entry_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int entryID;
	
	@Column(name="entry_date")
	private Date entryDate;
	
	@Column(name="user_id")
	private int userID;

	public EntryMakerModel()
	{
		this.entryDate = new Date();
	}
	public EntryMakerModel(int userID)
	{
		this.entryDate = new Date();
		this.userID = userID;
	}
	public int getEntryID() {
		return entryID;
	}

	public void setEntryID(int entryID) {
		this.entryID = entryID;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
}
