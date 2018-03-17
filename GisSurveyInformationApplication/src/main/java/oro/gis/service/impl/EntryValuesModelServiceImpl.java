package oro.gis.service.impl;

import java.util.ArrayList;
import java.util.List;

import oro.gis.model.EntryValuesModel;
import oro.gis.service.custom.EntryValuesModelCustomService;

public class EntryValuesModelServiceImpl implements EntryValuesModelCustomService
{

	public EntryValuesModel getEntryValuesModelObject()
	{
		return new EntryValuesModel();
	}
	public List<EntryValuesModel> getEmptyFieldValues() 
	{
		List<EntryValuesModel> listofValues = new ArrayList<EntryValuesModel>(); 
		for(int i=0;i<10;i++)
			listofValues.add(new EntryValuesModel());
			
		return listofValues;
	}
	
}
