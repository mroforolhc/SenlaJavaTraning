public class Main {
	public static void main(String[] args) {
	    Number num = new Number();
	    System.out.println("Число: " + num.getNum());
	    num.calcLargeDigit();
        System.out.println("Наибольшая цифра: " + num.getLargeD());
	}
}