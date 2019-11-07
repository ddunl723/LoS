package pkg;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class region {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int regionID;
	private int powerrank;
	private String name;
	private String fullname;
	private String home;
	
	public region() {}
	
	public region(int regionID, int powerrank, String name, String fullname, String home) {
		super();
		this.regionID = regionID;
		this.powerrank = powerrank;
		this.name = name;
		this.fullname = fullname;
		this.home = home;
	}

	public int getRegionID() {
		return regionID;
	}

	public void setRegionID(int regionID) {
		this.regionID = regionID;
	}

	public int getPowerrank() {
		return powerrank;
	}

	public void setPowerrank(int powerrank) {
		this.powerrank = powerrank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}
	
}
