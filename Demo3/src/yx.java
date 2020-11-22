import java.util.Scanner;

public class yx {

	public static void main(String[] args) {
		double y;
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入一个x值:");
		double x=sc.nextDouble();
		if(x>5) {System.out.println("y的值为"+(y=x+3));}
		else if(x<=5&&x>=0) {System.out.println("y的值为"+(y=0));}
		else if(x<0) {System.out.println("y的值为"+(y=2*x+30));}

	}

}
