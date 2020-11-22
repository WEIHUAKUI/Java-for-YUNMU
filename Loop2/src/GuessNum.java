
public class GuessNum {

	public static void main(String[] args) {
		int x, y, z;
		for (x = 0; x <= 9; x++) {
			for (y = 0; y <= 9; y++) {
				for (z = 0; z <= 9; z++) {
					if ((x * 100 + y * 10 + z) + (y * 100 + z * 10 + z)==532) {
						System.out.println("x的值为："+x+" y的值为："+y+" z的值为："+z);
					}

				}
			}
		}
	}

}
