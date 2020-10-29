import java.util.Scanner;

public class ComputeArea {

	public static void main(String[] args) {
		//int r;
		double r;   //申明变量（变径）
		//r=1546;  //半径赋值为1546
		
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入圆的半径:");
		r=sc.nextDouble();
		final double PI=3.14;
		double area=PI*r*r;  //定义常量PI
		
			
		System.out.println(area);
/*
		//int iA1,iA2,iA3;
		
		int iA1;
		int iA2;
		int iA3;
*/

	}

}
