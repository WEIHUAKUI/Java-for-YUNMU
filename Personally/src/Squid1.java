import java.util.Scanner;
public class Squid1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
final int MAX=100000;
double donation=0,sum=0;//donation��һ��ѧ�������Ŀ  sum�Ǿ��������
Scanner sc=new Scanner(System.in);	 
System.out.println("���һ��ͬѧ������������");
		donation=sc.nextLong();
		int i=1;
		sum=sum+donation;
		if(sum>=MAX)sum=donation;
while(donation<10000&&i<1000) {
	System.out.println("��������һ��ͬѧ�ľ������");
	donation=sc.nextDouble();
	sum=sum+donation;
	if(sum>=MAX)break;
	i++;
}
 System.out.printf("���������"+i+"�ܾ������"+sum);   
	
}
	
}
