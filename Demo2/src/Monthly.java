import java.util.Scanner;

public class Monthly {

	public static void main(String[] args) {
		double a,b,c,d,e,f,g,h,k,q,w,s,x;//声明变量（用户输入贷款总额（a)、年数(b)、利率(c))
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入贷款总额（元）:");
		a=sc.nextDouble();
		System.out.println("请输入年数（年）:");
		b=sc.nextDouble();
		System.out.println("请输入年利率（输入小数）:");
		c=sc.nextDouble();
		d=c/12;//计算月利率
		e=a*d;//贷款总额*月利率
		f=1+d;//月利率+1
		g=b*12;//年数*12
		h=Math.pow(f, g);
		k=1/h;
		q=1-k;
		w=e/q;
		x=a/12*b;
		s=x+g;
		System.out.println("每月所还利息总额为"+q+"元");
		System.out.println("每月还款金额（等额本息）"+s+"元");
	}

}
