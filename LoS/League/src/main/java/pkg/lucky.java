package pkg;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class lucky {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int chmpID;
	private String name;

	
	public lucky() {}
	
	public lucky(String name, int chmpID) {
		super();
		this.name = name;
		this.chmpID=chmpID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return chmpID;
	}

	public void setId(int id) {
		this.chmpID = id;
	}
	
	
}
