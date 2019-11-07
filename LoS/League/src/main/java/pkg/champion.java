package pkg;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class champion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int chmpID;
	private String name;
	private int gban;
	private int gplay;
	private int wins;
	private int losses;
	@Column(name="WR", columnDefinition="decimal", precision=12, scale=2)
	private java.math.BigDecimal WR;
	@Column(name="pos1ID",nullable = true)
	private Float pos1ID;
	@Column(name="pos2ID",nullable = true)
	private Float pos2ID;
	@Column(name="pos3ID",nullable = true)
	private Float pos3ID;
	private String facepic;
	
	public champion () {}
	public champion(String name, int gban, int gplay, int wins, int losses, Float pos1id, Float pos2id, Float pos3id,
			String facepic) {
		super();
		this.losses=losses;
		this.name = name;
		this.gban = gban;
		this.gplay = gplay;
		this.wins = wins;
		pos1ID = pos1id;
		pos2ID = pos2id;
		pos3ID = pos3id;
		this.facepic = facepic;
	}
	
	public champion(int chmpID, String name, int gban, int gplay, int wins, java.math.BigDecimal wR, Float pos1id, Float pos2id, Float pos3id,
		String facepic) {
	super();
	this.chmpID = chmpID;
	this.name = name;
	this.gban = gban;
	this.gplay = gplay;
	this.wins = wins;
	WR = wR;
	pos1ID = pos1id;
	pos2ID = pos2id;
	pos3ID = pos3id;
	this.facepic = facepic;
}

	public int getChmpID() {
		return chmpID;
	}

	public void setChmpID(int chmpID) {
		this.chmpID = chmpID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGban() {
		return gban;
	}

	public void setGban(int gban) {
		this.gban = gban;
	}

	public int getGplay() {
		return gplay;
	}

	public void setGplay(int gplay) {
		this.gplay = gplay;
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

	public Float getPos1ID() {
		return pos1ID;
	}

	public void setPos1ID(Float pos1id) {
		pos1ID = pos1id;
	}

	public Float getPos2ID() {
		return pos2ID;
	}

	public void setPos2ID(Float pos2id) {
		pos2ID = pos2id;
	}

	public Float getPos3ID() {
		return pos3ID;
	}

	public void setPos3ID(Float pos3id) {
		pos3ID = pos3id;
	}

	public String getFacepic() {
		return facepic;
	}

	public void setFacepic(String facepic) {
		this.facepic = facepic;
	}
	public java.math.BigDecimal getWR() {
		return WR;
	}
	public void setWR(java.math.BigDecimal wR) {
		WR = wR;
	}
	
	
	
}
