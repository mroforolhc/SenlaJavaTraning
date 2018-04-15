public class Test {
	public static void main(String[] args) {
		Hospital hosp = new Hospital(1, "Hospital #2", "Empire St. 19/23");
		Passport pass = new Passport(5400, 284528, "569-090");
		Patient patient = new Patient("Yan Markov", "Transgender", 109025483, "Lenina St. 13/88", 474747, pass);
		Doctor doctor = new Doctor("House M.D.", "Male", "Chief Doctor", hosp);
	}
}
