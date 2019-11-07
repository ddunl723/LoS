package pkg;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class player {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int playerID;
	private Float positionid;
	private int teamID;
	private int chmp1ID;
	private int chmp2ID;
	private int chmp3ID;
	private float KDA;
	private float csAVG;
	private float csPM;
	private int GPM;
	private float KP;
	private float gperc;
	private int champsplayed;
	private String tag;
	private String truename;
	private String facepic;
	
	public player() {}

	public player(int playerID, Float positionid, int teamID, int chmp1id, int chmp2id, int chmp3id, float kDA,
			float csAVG, float csPM, int gPM, float kP, float gperc, int champsplayed, String tag, String truename,
			String facepic) {
		super();
		this.playerID = playerID;
		this.positionid = positionid;
		this.teamID = teamID;
		chmp1ID = chmp1id;
		chmp2ID = chmp2id;
		chmp3ID = chmp3id;
		KDA = kDA;
		this.csAVG = csAVG;
		this.csPM = csPM;
		GPM = gPM;
		KP = kP;
		this.gperc = gperc;
		this.champsplayed = champsplayed;
		this.tag = tag;
		this.truename = truename;
		this.facepic = facepic;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public Float getPositionid() {
		return positionid;
	}

	public void setPositionid(Float positionid) {
		this.positionid = positionid;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	public int getChmp1ID() {
		return chmp1ID;
	}

	public void setChmp1ID(int chmp1id) {
		chmp1ID = chmp1id;
	}

	public int getChmp2ID() {
		return chmp2ID;
	}

	public void setChmp2ID(int chmp2id) {
		chmp2ID = chmp2id;
	}

	public int getChmp3ID() {
		return chmp3ID;
	}

	public void setChmp3ID(int chmp3id) {
		chmp3ID = chmp3id;
	}

	public float getKDA() {
		return KDA;
	}

	public void setKDA(float kDA) {
		KDA = kDA;
	}

	public float getCsAVG() {
		return csAVG;
	}

	public void setCsAVG(float csAVG) {
		this.csAVG = csAVG;
	}

	public float getCsPM() {
		return csPM;
	}

	public void setCsPM(float csPM) {
		this.csPM = csPM;
	}

	public int getGPM() {
		return GPM;
	}

	public void setGPM(int gPM) {
		GPM = gPM;
	}

	public float getKP() {
		return KP;
	}

	public void setKP(float kP) {
		KP = kP;
	}

	public float getgPerc() {
		return gperc;
	}

	public void setgPerc(float gperc) {
		this.gperc = gperc;
	}

	public int getChampsplayed() {
		return champsplayed;
	}

	public void setChampsplayed(int champsplayed) {
		this.champsplayed = champsplayed;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getFacepic() {
		return facepic;
	}

	public void setFacepic(String facepic) {
		this.facepic = facepic;
	}

	

	
}
