package pkg;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unused")
@RepositoryRestResource
public interface luckyinterface extends CrudRepository <lucky, Integer>{
	
	@Query(value="select * from lucky",nativeQuery=true)
	ArrayList<lucky> getlucky();
}
