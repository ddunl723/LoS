package pkg;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class team {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int teamID;
	private int regionID;
	private String name;
	private int wins;
	private int losses;
	private int regseed;
	private String bracket;
	private String logo;
	
	public team() {}
	
	public team(int teamID, int regionID, String name, int wins, int losses, int regseed, String bracket, String logo) {
		super();
		this.teamID = teamID;
		this.regionID = regionID;
		this.name = name;
		this.wins = wins;
		this.losses = losses;
		this.regseed = regseed;
		this.bracket = bracket;
		this.logo = logo;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	public int getRegionID() {
		return regionID;
	}

	public void setRegionID(int regionID) {
		this.regionID = regionID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getRegseed() {
		return regseed;
	}

	public void setRegseed(int regseed) {
		this.regseed = regseed;
	}

	public String getGroup() {
		return bracket;
	}

	public void setGroup(String bracket) {
		this.bracket = bracket;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
}
