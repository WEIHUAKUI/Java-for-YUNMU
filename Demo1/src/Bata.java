import java.util.Scanner;

public class Bata {

	public static void main(String[] args) {
		int a,b,c;                             //申明变量a,b,c
		System.out.println("请输入a:");
		Scanner a1=new Scanner(System.in);    //用户输入a1
		a=a1.nextInt();                       //令a=a1
		System.out.println("请输入b:");
		Scanner b1=new Scanner(System.in);    //用户输入b1
		b=b1.nextInt();                       //令b=b1
		if (a>=b){
			c=a;
            System.out.println("c="+c);      //判断a是否大于等于b，是输出c=a
		}else if (a<=b){                    //如果不是以上结果执行下一个判断
			c=b;
            System.out.println("c="+c);     //判断b是否大于等于a，是输出c=b
                   }
		}

}
