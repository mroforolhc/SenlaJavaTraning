public class Person {
    private String fullName;
    private String gender;

    Person(String fullName, String gender) {
        setFullName(fullName);
        setGender(gender);
        System.out.println("\n[Person]: " + this.fullName + " " + this.gender);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}