import java.util.Scanner;

public class Bata {

	public static void main(String[] args) {
		int a,b,c;                             //��������a,b,c
		System.out.println("������a:");
		Scanner a1=new Scanner(System.in);    //�û�����a1
		a=a1.nextInt();                       //��a=a1
		System.out.println("������b:");
		Scanner b1=new Scanner(System.in);    //�û�����b1
		b=b1.nextInt();                       //��b=b1
		if (a>=b){
			c=a;
            System.out.println("c="+c);      //�ж�a�Ƿ���ڵ���b�������c=a
		}else if (a<=b){                    //����������Ͻ��ִ����һ���ж�
			c=b;
            System.out.println("c="+c);     //�ж�b�Ƿ���ڵ���a�������c=b
                   }
		}

}
