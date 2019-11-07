package pkg;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface regioninterface  extends CrudRepository <region, Integer>{
	
	@Query(value="select * from region",nativeQuery=true)
	ArrayList<region> getregion();
}
