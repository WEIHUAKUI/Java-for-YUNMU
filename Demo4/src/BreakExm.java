import java.util.Scanner;

public class BreakExm {

	public static void main(String[] args) {
	final int MAX=100000;//��������MAX�������޶�
	double donation=0;//ÿ��ͬѧ�ľ����
	double sum=0;//ʵ�ʵľ������
	int i;
	Scanner sc = new Scanner(System.in); 
	for(i=1;i<=1000;i++) {
		System.out.println("��������һ��ͬѧ�ľ������");
		donation=sc.nextDouble();
		sum=sum+donation;
		if(sum>=MAX)break;
	}
System.out.println("���������"+i+"�ܾ������"+sum);
	}

}
