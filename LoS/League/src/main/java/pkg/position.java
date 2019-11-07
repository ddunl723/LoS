package pkg;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class position {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Float positionID;
	private String name;
	private String image;
	
	public position() {}
	
	public position(Float positionID, String name, String image) {
		super();
		this.positionID = positionID;
		this.name = name;
		this.image = image;
	}

	public Float getPositionID() {
		return positionID;
	}

	public void setPositionID(Float positionID) {
		this.positionID = positionID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
