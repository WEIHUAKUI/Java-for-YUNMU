import java.util.Scanner;

public class yx {

	public static void main(String[] args) {
		double y;
		Scanner sc=new Scanner(System.in);
		System.out.println("������һ��xֵ:");
		double x=sc.nextDouble();
		if(x>5) {System.out.println("y��ֵΪ"+(y=x+3));}
		else if(x<=5&&x>=0) {System.out.println("y��ֵΪ"+(y=0));}
		else if(x<0) {System.out.println("y��ֵΪ"+(y=2*x+30));}

	}

}
