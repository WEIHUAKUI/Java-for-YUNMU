import java.util.Scanner;

public class WhileFactorial {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		  int n;//����nΪ����
		  System.out.println("������һ����������׳�:");
		  n=in.nextInt();//����һ��n����׳�
		  int i=1,m=1;//����i��1��ʼ��m������
		  while(i<=n)//��iС��nʱ����������n��ֹͣ
		  {
		   m=m*i;//ÿһ�γ���+1��������nֹͣ
		   i++;//ִ��i++
		  }
			System.out.println(n+"�Ľ׳�Ϊ:"+m);//������
	}

}
