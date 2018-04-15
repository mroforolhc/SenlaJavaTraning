public class Hospital {
    private int id;
    private String title;
    private String address;

    Hospital(int id, String title, String address) {
        setId(id);
        setTitle(title);
        setAddress(address);
        System.out.println("[Hospital]: " + this.id + " " + this.title + " " + this.address);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}