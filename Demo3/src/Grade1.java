import java.util.Scanner;

public class Grade1 {

	public static void main(String[] args) {
		int score;
		Scanner sc=new Scanner(System.in);
		System.out.println("��������ĳɼ�:");
		score=sc.nextInt();
		switch(score/10) {
		case 10:
		case 9:System.out.println("����");
		break;
		case 8:
			System.out.println("����");
			break;
		case 7:
		case 6:
			System.out.println("����");
			break;
		case 5:
		case 4:
		case 3:
		case 2:
		case 1:
		case 0:
			System.out.println("��");
			break;
			default:
				System.out.println("�������");
		}

	}

}
