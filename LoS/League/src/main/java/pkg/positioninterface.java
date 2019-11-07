package pkg;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface positioninterface extends CrudRepository <position, Integer>{

	@Query(value="select * from position",nativeQuery=true)
	ArrayList<position> getpos();
}
