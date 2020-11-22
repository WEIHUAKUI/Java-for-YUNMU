
public class Team {

	public static void main(String[] args) {
		char A, B, C, X, Y, Z;
		for (A = 'X'; A <= 'Z'; A++) {
			for (B = 'X'; B <= 'Z'; B++) {
				for (C = 'X'; C <= 'Z'; C++) {
					if (A == B || A == C || B == C)
						continue;
					if (A == 'X' || C == 'X' || C == 'Z')
						continue;
					System.out.printf("A:%s , B:%s , C:%s\n", A, B, C);
				}
			}
		}

	}

}
