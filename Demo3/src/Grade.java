import java.util.Scanner;

public class Grade {

	public static void main(String[] args) {
		double score;
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入你的成绩:");
		score=sc.nextDouble();
		if(score>=90&&score<=100) {System.out.println("优秀啊");}
		else if(score>=80&&score<90) {System.out.println("良好");}
		else if(score>=60&&score<80) {System.out.println("及格");}
		else if(score>=0&&score<60) {System.out.println("差");}
		else {System.out.println("输入错误!");}
	}

}
