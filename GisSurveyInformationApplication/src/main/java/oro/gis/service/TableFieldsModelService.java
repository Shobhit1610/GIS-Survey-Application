package oro.gis.service;
/*package oro.gis.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import oro.gis.model.TableFieldsModel;

@Transactional
public interface TableFieldsService extends CrudRepository<TableFieldsModel, Long>
{

	public TableFieldsModel getUserList();

}
*/
import org.springframework.data.repository.CrudRepository;


import oro.gis.model.TableFieldsModel;
import oro.gis.service.custom.TableFieldsModelCustomService;

public interface TableFieldsModelService extends CrudRepository<TableFieldsModel, Long> , TableFieldsModelCustomService 
{
	
}
