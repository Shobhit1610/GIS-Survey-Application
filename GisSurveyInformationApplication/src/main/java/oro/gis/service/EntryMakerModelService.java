package oro.gis.service;

import org.springframework.data.repository.CrudRepository;
import oro.gis.service.custom.EntryMakerModelCustomService;
import oro.gis.model.EntryMakerModel;

public interface EntryMakerModelService extends CrudRepository<EntryMakerModel, Long>,EntryMakerModelCustomService {

}
