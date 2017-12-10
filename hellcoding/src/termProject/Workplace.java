package termProject;

public class Workplace {
	public static String[] Places = {
			"Unknown Place",
			"Seoul",
			"Daejeon",
			"Daegu",
			"Busan",
			"Jeju"
	};
	private String name;
	
	public static final Workplace workplaceUnknown = new Workplace (Places[0]);
	public static final Workplace workplaceSeoul = new Workplace (Places[1]);
	public static final Workplace workplaceDaejeon = new Workplace (Places[2]);
	public static final Workplace workplaceDaegu = new Workplace (Places[3]);
	public static final Workplace workplaceBusan = new Workplace (Places[4]);
	public static final Workplace workplaceJeju = new Workplace (Places[5]);
	
	public String toString () {
		return this.name;
	}
	
	private Workplace (String place) {
		for (int i=0; i<Places.length; i++) {
			if (Places[i].equals(place)) {
				this.name = Places[i];
				return;
			}
		}
		this.name = "Unknown Place";
	}
	
	private Workplace () {
		this.name = "Unknown Place";
	}
}