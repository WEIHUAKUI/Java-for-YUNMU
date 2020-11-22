import java.util.Scanner;
public class Squid1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
final int MAX=100000;
double donation=0,sum=0;//donation是一个学生捐款数目  sum是捐款总人数
Scanner sc=new Scanner(System.in);	 
System.out.println("请第一个同学的输入捐款数：");
		donation=sc.nextLong();
		int i=1;
		sum=sum+donation;
		if(sum>=MAX)sum=donation;
while(donation<10000&&i<1000) {
	System.out.println("请输入下一个同学的捐款数：");
	donation=sc.nextDouble();
	sum=sum+donation;
	if(sum>=MAX)break;
	i++;
}
 System.out.printf("捐款人数："+i+"总捐款数："+sum);   
	
}
	
}
