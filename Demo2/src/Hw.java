import java.util.Scanner;

public class Hw {

	public static void main(String[] args) {
				double h,w;   //申明变量(h为长，w为宽）
				Scanner sc=new Scanner(System.in);
				System.out.println("请输入长方形的长:");
				h=sc.nextDouble();
				System.out.println("请输入长方形的宽:");
				w=sc.nextDouble();
				double area=h*w; //长方形面积
				double ares=h*2+w*2;//长方形周长
				System.out.println("长方形面积为"+area);
				System.out.println("长方形周长为"+ares);

	}

}
