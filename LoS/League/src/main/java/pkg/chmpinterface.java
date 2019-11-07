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
public interface chmpinterface extends CrudRepository <champion, Integer>{
	@Modifying
	@Transactional
	@Query(value="insert into champion (name, gban, gplay,wins,losses,pos1ID,pos2ID,pos3ID,facepic)"
	+ "values (:name, :gban, :gplay,:wins,:losses,:pos1ID,:pos2ID,:pos3ID,:facepic)", nativeQuery=true)
	Integer postChamp(@Param("name") String name, @Param("gban") int gban,
			@Param("gplay") int gplay, @Param("wins") int wins, @Param("losses") int losses,
			@Param("pos1ID") Float pos1ID, @Param("pos2ID") Float pos2ID,
			@Param("pos3ID") Float pos3ID,@Param("facepic") String facepic);
	
	@Modifying
	@Transactional
	@Query(value="update champion set gban=:gban, gplay=:gplay, wins=:wins, losses=:losses, pos1ID=:pos1ID, pos2ID=:pos2ID, pos3ID=:pos3ID "
			+ "where name=:name", nativeQuery=true)
	Integer updatechamp(int gban, int gplay, int wins, int losses, String name, Float pos1ID, Float pos2ID, Float pos3ID);
	
	@Query(value="select * from champion where name != 'Nothing' order by name asc",nativeQuery=true)
	ArrayList<champion> getchmp();
	
	@Query(value="select name from champion where chmpID=:chmpID",nativeQuery=true)
	String getchmpname(int chmpID);
	
	@Modifying
	@Transactional
	void deleteByName(String name);
}
