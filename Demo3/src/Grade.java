import java.util.Scanner;

public class Grade {

	public static void main(String[] args) {
		double score;
		Scanner sc=new Scanner(System.in);
		System.out.println("��������ĳɼ�:");
		score=sc.nextDouble();
		if(score>=90&&score<=100) {System.out.println("���㰡");}
		else if(score>=80&&score<90) {System.out.println("����");}
		else if(score>=60&&score<80) {System.out.println("����");}
		else if(score>=0&&score<60) {System.out.println("��");}
		else {System.out.println("�������!");}
	}

}
