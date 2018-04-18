public class Number {
    private int largeD;
    private int num;

    Number() {
        randomNum();
    }

    public int getLargeD() {
        return largeD;
    }
    public void setLargeD(int largeD) {
        this.largeD = largeD;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

    public void randomNum() {
        num = 100 + (int) (Math.random() * 901);
        setNum(num);
    }

    public void calcLargeDigit() {
        int one = getNum() % 10;
        int two = (getNum() / 10) % 10;
        int three = getNum() / 100;

        if ((one >= two) && (one >= three)) { setLargeD(one); }
        else if (two >= three) { setLargeD(two); }
        else setLargeD(three);
    }
}
