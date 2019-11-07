package pkg;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource
public interface teaminterface  extends CrudRepository <team, Integer>{
	
	@Modifying
	@Transactional
	@Query(value="update team set wins=:wins, losses=:losses where name=:name",nativeQuery=true)
	Integer updateteam(int wins, int losses, String name);
	
	@Query(value="select * from team",nativeQuery=true)
	ArrayList<team> getteam();
	
	@Query(value="select * from team where regionID=:regionID",nativeQuery=true)
	ArrayList<team> getteambyregion(int regionID);
}
