import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		String[] array;

		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		String s = buff.readLine();

		StringEditor edit = new StringEditor(s);
		edit.parseToArray();
		array = edit.getWordArray();

		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}