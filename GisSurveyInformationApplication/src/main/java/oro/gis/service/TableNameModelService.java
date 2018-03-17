package oro.gis.service;

import org.springframework.data.repository.CrudRepository;

import oro.gis.model.TableNameModel;
import oro.gis.service.custom.TableNameModelCustomService;

public interface TableNameModelService extends CrudRepository<TableNameModel, Long> , TableNameModelCustomService 
{
	
}
