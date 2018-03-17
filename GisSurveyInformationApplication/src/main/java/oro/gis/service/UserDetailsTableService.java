package oro.gis.service;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import oro.gis.model.UserDetailsTable;
import oro.gis.service.custom.UserDetailsTableCustomService;

@Transactional
public interface UserDetailsTableService extends CrudRepository<UserDetailsTable,Long> , UserDetailsTableCustomService 
{

	
	
}
