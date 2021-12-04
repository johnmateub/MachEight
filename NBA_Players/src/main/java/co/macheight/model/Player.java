package co.macheight.model;

public class Player {

	private String firstName;
	private String lastName;
	private Integer heightInches;
	private Double heightMeters;
	
	public Player(String firstName, String lastName, Integer heightInches, Double heightMeters) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.heightInches = heightInches;
		this.heightMeters = heightMeters;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getHeightInches() {
		return heightInches;
	}

	public void setHeightInches(Integer heightInches) {
		this.heightInches = heightInches;
	}

	public Double getHeightMeters() {
		return heightMeters;
	}

	public void setHeightMeters(Double heightMeters) {
		this.heightMeters = heightMeters;
	}
	
	public String getCompleteName() {
		return this.firstName + " " + this.lastName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((heightInches == null) ? 0 : heightInches.hashCode());
		result = prime * result + ((heightMeters == null) ? 0 : heightMeters.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (heightInches == null) {
			if (other.heightInches != null)
				return false;
		} else if (!heightInches.equals(other.heightInches))
			return false;
		if (heightMeters == null) {
			if (other.heightMeters != null)
				return false;
		} else if (!heightMeters.equals(other.heightMeters))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Player [firstName=" + firstName + ", lastName=" + lastName + ", heightInches=" + heightInches
				+ ", heightMeters=" + heightMeters + "]";
	}
	
}
