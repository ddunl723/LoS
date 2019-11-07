package pkg.cotroller.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pkg.*;

@SuppressWarnings("unused")


//This is the controller for the Champion table
@RestController
@RequestMapping("/champions")
public class mastercontrol {
	@Autowired
	chmpinterface ch;
	
	
	@GetMapping("/hello")
	public String sayhello() {
		return "Hello from the champ controller";
	}
	
	@CrossOrigin(origins="*")
	@PostMapping(value="/insert/")
	@ResponseBody
	public int post(@RequestParam("name") String name, @RequestParam("gban") int gban, @RequestParam("gplay") int gplay,
						@RequestParam("wins") int wins, @RequestParam("losses") int losses, @RequestParam("pos1ID") Float pos1ID,
						@RequestParam("pos2ID") Float pos2ID,@RequestParam("pos3ID") Float pos3ID,@RequestParam("facepic") String facepic) {
	int ThisChamp = ch.postChamp(name,gban,gplay,wins,losses,pos1ID,pos2ID,pos3ID,facepic);
	int result=0;
	if(ThisChamp==1)
			result=1;
	else if(ThisChamp!=1)
			result=-1;
	return result;
	}
	
	@CrossOrigin(origins="*")
	@PostMapping(value="/updatechamp/")
	public int updatechmp(@RequestParam("gban") int gban, @RequestParam("gplay") int gplay,
							@RequestParam("wins") int wins, @RequestParam("losses") int losses,
							@RequestParam("name") String name,@RequestParam("pos1ID") Float pos1ID,
							@RequestParam("pos2ID") Float pos2ID,@RequestParam("pos3ID") Float pos3ID) {
		int ThisChamp= ch.updatechamp(gban, gplay, wins, losses, name,pos1ID,pos2ID,pos3ID);
		int result=0;
		if(ThisChamp==1)
				result=1;
		else if(ThisChamp!=1)
				result=-1;
		return result;
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(value="/getChampion/")
	public ArrayList<champion> getChampion(){
		return ch.getchmp();
	}
	
	/*@CrossOrigin(origins="*")
	@GetMapping(value="/lucky/")
	public ArrayList<champion> getluk(){
		return ch.lucky();
	}
	*/
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/chmpname/", method=RequestMethod.GET,produces = "text/plain")
	@ResponseBody
	public String getchampname(@RequestParam("chmpID") int chmpID) {
		return ch.getchmpname(chmpID);
	}
	
	@CrossOrigin(origins="*")
	@PostMapping(value="/deletechamp/")
	public void updatechmp(@RequestParam("name") String name) {
		ch.deleteByName(name);
	}
	
	
		
}
//This is the controller for the Player table.
@RestController
@RequestMapping("/players")
class playercontrol{
	@Autowired
	playerinterface pl;
	
	@CrossOrigin(origins="*")
	@GetMapping(value="/players")
	public Iterable<player> findNuts(){
		return pl.findAll();
	}
	
	@GetMapping("/hello")
	public String sayhello() {
		return "Hello from the player controller";
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(value="/plyid/")
	public Optional<player>  playid(@RequestParam("playerID") int playerID) {
		Optional<player> answer = pl.findById(playerID);
		return answer;
	}
	@CrossOrigin(origins="*")
	@GetMapping(value= "/plyavg/")
	public ArrayList<player> getavg(){
		return pl.plyavg();
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(value="/getPlayer/")
	public ArrayList<player> getply(){
		return pl.getplayer();
	}
	
	//This method is post and not put because of html limitations, get would work as well
	@CrossOrigin(origins="*")
	@PostMapping(value="/updateplayer/")
	@ResponseBody
	public int updateply(@RequestParam("chmp1ID") int chmp1ID, @RequestParam("chmp2ID") int chmp2ID,
							@RequestParam("chmp3ID") int chmp3ID, @RequestParam("KDA") float KDA,
							@RequestParam("csAVG") float csAVG, @RequestParam("csPM") float csPM,
							@RequestParam("GPM") int GPM, @RequestParam("KP") float KP, @RequestParam("gperc") float gperc,
							@RequestParam("champsplayed") int champsplayed,
							@RequestParam("tag") String tag) {
		int thisply= pl.updateplayer(chmp1ID, chmp2ID, chmp3ID, KDA, csAVG, csPM, GPM, KP, gperc, champsplayed, tag);
		int result=0;
		if(thisply==1)
				result=1;
		else if(thisply!=1)
				result=-1;
		return result;
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(value="/count/")
	public Long Count() {
		Long numberNuts = pl.count();
		return numberNuts;
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(value="/plybyteam/")
	public ArrayList<player> getplybyteamid(@RequestParam("teamID") int teamID) {
		 return pl.getplybyteamid(teamID);
	}
	
}
//This is the controller for the Team table
@RestController
@RequestMapping("/teams")
class teamcontrol{
	@Autowired
	teaminterface te;
	
	@GetMapping("/hello")
	public String sayhello() {
		return "Hello from the team controller";
	}
	
	@CrossOrigin(origins="*")
	@PostMapping("/updateteam/")
	public int updateteam(@RequestParam("wins") int wins, @RequestParam("losses") int losses,
							 @RequestParam("name") String name) {
		int thistm=te.updateteam(wins, losses, name);
		int result=0;
		if(thistm==1)
			result=1;
	else if(thistm!=1)
			result=-1;
	return result;
	}
	
	@CrossOrigin(origins="*")
	@GetMapping("/getTeam/")
	public ArrayList<team> gette(){
		return te.getteam();
	}
	
	@CrossOrigin(origins="*")
	@GetMapping("/getTeambyRegion/")
	public ArrayList<team> getteambyregion(@RequestParam("regionID") int regionID){
		return te.getteambyregion(regionID);
	}
}
//This is the controller for the Region table
@RestController
@RequestMapping("/regions")
class regioncontrol{
	@Autowired
	regioninterface re;
	
	@CrossOrigin(origins="*")
	@GetMapping("/hello")
	public String sayhello() {
		return "Hello from the region controller";
	}
	
	@CrossOrigin(origins="*")
	@GetMapping("/getRegion/")
	public ArrayList<region> getreg(){
		return re.getregion();
	}
}
//This is the controller for the Position table
@RestController
@RequestMapping("/positions")
class positioncontrol{
	@Autowired
	positioninterface po;
	
	@GetMapping("/hello")
	public String sayhello() {
		return "Hello from the posistion controller";
	}
	
	@CrossOrigin(origins="*")
	@GetMapping("/getPosition/")
	public ArrayList<position> getPosition(){
		return po.getpos();
	}
}

@RestController
@RequestMapping("/champions")
class luckycontrol {
	@Autowired
	luckyinterface lu;
	
	@CrossOrigin(origins="*")
	@GetMapping(value="/getLucky/")
	public ArrayList<lucky> getlucky(){
		return lu.getlucky();
	}
}
