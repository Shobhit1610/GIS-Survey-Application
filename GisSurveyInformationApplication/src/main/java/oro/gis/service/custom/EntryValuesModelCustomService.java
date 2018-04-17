package oro.gis.service.custom;

import java.util.List;

import oro.gis.model.EntryValuesModel;

public interface EntryValuesModelCustomService
{

	public List<EntryValuesModel> getFieldDataRows(int field);
}
