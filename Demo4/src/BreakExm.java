import java.util.Scanner;

public class BreakExm {

	public static void main(String[] args) {
	final int MAX=100000;//声明常量MAX保存捐款限额
	double donation=0;//每个同学的捐款数
	double sum=0;//实际的捐款总数
	int i;
	Scanner sc = new Scanner(System.in); 
	for(i=1;i<=1000;i++) {
		System.out.println("请输入下一个同学的捐款数：");
		donation=sc.nextDouble();
		sum=sum+donation;
		if(sum>=MAX)break;
	}
System.out.println("捐款人数："+i+"总捐款数："+sum);
	}

}
