import java.util.Scanner;

public class Num {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int num,numReverse,x1,x2,x3,y1;
		Scanner sc=new Scanner(System.in);
		        System.out.println("请输入一个三位数的整数:");
		       num=sc.nextInt();
		       while(num!=0){
		            int a=num%10;
		            System.out.print(a);
		            num=num/10;}
		        /*x3=num/100;  //百位上的数值
		        y1=num%100;   //取余去掉百位
		        x2=y1/10;     //十位上的数值
		        x1=y1%10;    //取余去掉十位，留下个位
		        numReverse=x1*100+x2*10+x3;
		        System.out.println("反转后的数值为"+numReverse);
		        */}
	}
	
