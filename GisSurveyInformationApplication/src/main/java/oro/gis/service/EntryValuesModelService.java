package oro.gis.service;

import org.springframework.data.repository.CrudRepository;

import oro.gis.model.EntryValuesModel;
import oro.gis.service.custom.EntryValuesModelCustomService;

public interface EntryValuesModelService extends CrudRepository<EntryValuesModel, Long> , EntryValuesModelCustomService {

}
