public class Patient extends Person {
    private long insuranceNumber;
    private String address;
    private long phone;
    private Passport passport;

    Patient(String fullName, String gender, long insNum, String address, long phone, Passport passport) {
    	super(fullName, gender);
    	setInsuranceNumber(insNum);
    	setAddress(address);
    	setPhone(phone);
    	setPassport(passport);
    	System.out.println("[Patient]: " + this.address + " " + "Pass: " + passport.getSeries() + " " + passport.getNumber());
    }

    public long getInsuranceNumber() {
    	return insuranceNumber;
    }

    public void setInsuranceNumber(long insuranceNumber) {
    	this.insuranceNumber = insuranceNumber;
    }

    public String getAddress() {
    	return address;
    }

    public void setAddress(String address) {
    	this.address = address;
    }

    public long getPhone() {
    	return phone;
    }

    public void setPhone(long phone) {
    	this.phone = phone;
    }

    public Passport getPassport() {
    	return passport;
    }

    public void setPassport(Passport passport) {
    	this.passport = passport;
    }
}