package oro.gis.service;

import org.springframework.data.repository.CrudRepository;

import oro.gis.model.EntryMakerModel;
import oro.gis.service.custom.EntryMakerModelCustomService;

public interface EntryMakerModelService extends CrudRepository<EntryMakerModel, Long> , EntryMakerModelCustomService  {

}
