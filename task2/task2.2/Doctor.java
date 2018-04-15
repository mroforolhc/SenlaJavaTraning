public class Doctor extends Person {
    private String position;
    private Hospital hospital;

    Doctor(String fullName, String gender, String position, Hospital hospital) {
    	super(fullName, gender);
    	setPosition(position);
    	setHospital(hospital);
    	System.out.println("[Doctor]: " + this.position + " " + hospital.getTitle());
    }

    public String getPosition() {
    	return position;
    }

    public void setPosition(String position) {
    	this.position = position;
    }

    public Hospital getHospital() {
    	return hospital;
    }

    public void setHospital(Hospital hospital) {
    	this.hospital = hospital;
    }

}