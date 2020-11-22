
public class Senior {

	public static void main(String[] args) {
		int day = 0, distance = 0;
		for (day = 0; distance < 7;) {
			day++;
			distance += 3;
			if (distance < 7)
				distance -= 2;
		}
		System.out.println("青蛙爬出来需要" + day + "天");
	}
}
