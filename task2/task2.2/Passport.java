public class Passport {
    private int series;
    private int number;
    private String subdivisionCode;

    Passport(int series, int number, String subdivisionCode) {
        setSeries(series);
        setNumber(number);
        setSubdivisionCode(subdivisionCode);
        System.out.println("[Passport]: " + this.series + " " + this.number + " " + this.subdivisionCode);
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSubdivisionCode() {
        return subdivisionCode;
    }

    public void setSubdivisionCode(String subdivisionCode) {
        this.subdivisionCode = subdivisionCode;
    }
}