package pkg;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unused")
@RepositoryRestResource
public interface playerinterface extends CrudRepository <player, Integer>{

	
	@Query(value="select * from player where chmp1ID=:chmpID"
			+ " or chmp2ID=:chmpID or chmp3ID=:chmpID",nativeQuery=true)
	ArrayList<player> chmp1orchmp2orchmp3(@Param("chmpID") int chmpID);

	@Query(value="select AVGJOE.positionID as playerID, AVGJOE.positionID, -1 as teamID, (select top 1 [chmp1ID] from player where positionID = AVGJOE.positionID group by [chmp1ID] order by count(*) desc) as chmp1ID, (select top 1 [chmp1ID] from player where positionID = AVGJOE.positionID and [chmp1ID] !=(select top 1 [chmp1ID] from player where positionID = AVGJOE.positionID group by [chmp1ID] order by count(*) desc) group by [chmp1ID] order by count(*) desc ) as chmp2ID, (select top 1 [chmp1ID] from player where positionID = AVGJOE.positionID and [chmp1ID] !=(select top 1 [chmp1ID] from player where positionID = AVGJOE.positionID group by [chmp1ID] order by count(*) desc) and [chmp1id]!=(select top 1 [chmp1ID] from player where positionID = AVGJOE.positionID and [chmp1ID] !=(select top 1 [chmp1ID] from player where positionID = AVGJOE.positionID group by [chmp1ID] order by count(*) desc) group by [chmp1ID] order by count(*) desc ) group by [chmp1ID] order by count(*) desc ) as chmp3ID, KDA,csAVG,csPM,GPM,KP,gPerc,champsPlayed, (select [name] from position where positionID = AVGJOE.positionID ) as tag, (select [name] from position where positionID = AVGJOE.positionID ) as trueName, (select [name] from position where positionID = AVGJOE.positionID ) + '.png' as facepic from  (select  distinct positionID , round(avg(KDA),2) kda,round(avg(csAVG),2) csavg,round(avg(csPM),2) csPM,round(avg(GPM),2) GPM,round(avg(KP),2) KP, round(avg(gPerc),2) gPerc,round(avg(champsPlayed),2) champsPlayed from player group by positionID ) as AVGJOE", nativeQuery=true)
	ArrayList<player> plyavg();	
	
	@Query(value="select -1 as playerID, AVGJOE.positionID,"
			+ "-1 as teamID, (select top 1 [chmp1ID] from player where positionID = AVGJOE.positionID"
			+ " group by [chmp1ID] order by count(*) desc) as chmp1ID, (select top 1 [chmp1ID] "
			+ "from player where positionID = AVGJOE.positionID and [chmp1ID] !=(select top 1 [chmp1ID] "
			+ "from player where positionID = AVGJOE.positionID group by [chmp1ID] order by count(*) "
			+ "desc) group by [chmp1ID] order by count(*) desc ) as chmp2ID, (select top 1 [chmp1id] "
			+ "from player where positionID = AVGJOE.positionID and [chmp1ID] !=(select top 1 [chmp1ID] "
			+ "from player where positionID = AVGJOE.positionID group by [chmp1id] order by count(*) "
			+ "desc) and [chmp1ID]!=(select top 1 [chmp1ID] from player "
			+ "where positionID = AVGJOE.positionID and [chmp1ID] !=(select top 1 [chmp1ID] from "
			+ "player where positionID = AVGJOE.positionID group by [chmp1ID] order by count(*) desc) "
			+ "group by [chmp1ID] order by count(*) desc ) group by [chmp1ID] order by count(*) desc ) "
			+ "as chmp3ID, KDA,csAVG,csPM,GPM,KP,gPerc,champsPlayed, (select [name] from position where "
			+ "positionID = AVGJOE.positionID ) as tag, (select [name] from position where "
			+ "positionID = AVGJOE.positionID ) as trueName, (select [name] from position where "
			+ "positionID = AVGJOE.positionID ) + '.png' as facepic from  (select  distinct "
			+ "positionID , round(avg(KDA),2) kda,round(avg(csAVG),2) csavg,round(avg(csPM),2) "
			+ "csPM,round(avg(GPM),2) GPM,round(avg(KP),2) KP, round(avg(gPerc),2) gPerc,"
			+ "round(avg(champsPlayed),2) champsPlayed from player group by positionID ) as AVGJOE", nativeQuery=true)
	Iterable<player> plyavg2();
	
	@Query(value="select * from player",nativeQuery=true)
	ArrayList<player> getplayer();
	
	@Modifying
	@Transactional
	@Query(value="update player set chmp1ID=:chmp1ID,"
			+ "chmp2ID=:chmp2ID, chmp3ID=:chmp3ID, KDA=:KDA, csAVG=:csAVG, csPM=:csPM, GPM=:GPM,"
			+ "KP=:KP, gperc=:gperc, champsplayed=:champsplayed where tag=:tag",nativeQuery=true)
	int updateplayer(int chmp1ID, int chmp2ID, int chmp3ID,
			float KDA, float csAVG, float csPM, int GPM, float KP, float gperc,
			int champsplayed, String tag);
	
	@Modifying
	@Transactional
	@Query(value="select * from player where teamID=:teamID order by positionID asc",nativeQuery=true)
	ArrayList<player> getplybyteamid(int teamID);
	
}
