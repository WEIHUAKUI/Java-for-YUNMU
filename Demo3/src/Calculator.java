import java.util.Scanner;//����ɨ��

public class Calculator {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	      double a,b;  //������������a,b
	      int c;       //����ѡ���������c
		  System.out.println("�򵥼�����:");
		  System.out.println("====�˵�====");
		  System.out.println("1-------�ӷ�");
		  System.out.println("2-------����");
	      System.out.println("3-------�˷�");
		  System.out.println("4-------����");
		  System.out.println("============");
		  System.out.println("��������ѡ������㷨��:");
		  c=sc.nextInt();     //�û������������c
	      System.out.println("������Ҫ��������ݵĵ�һ����(a):");
	      a=sc.nextInt();  //�û���������a
	      System.out.println("������Ҫ��������ݵĵڶ�����(b):");
	      b=sc.nextInt();  //�û���������b
	      System.out.println("�������������:");
	      switch(c) //�жϼ�������ѡ�����㷨��
	      {
	      case 1: //�ӷ�����
	      System.out.println(a+"+"+b+"="+(a+b)); //��������ͬʱ����������
	      break; //ֹͣ���
	      case 2: //��������
	      System.out.println(a+"-"+b+"="+(a-b));//��������ͬʱ����������
	      break; //ֹͣ���
	      case 3: //�˷�����
	      System.out.println(a+"*"+b+"="+(a*b));//��������ͬʱ����������
	      break; //ֹͣ���
	      case 4: //��������
	      if(b==0) //�жϱ�����b�Ƿ����0
	      System.out.println("���㷨����󣡱���������Ϊ�㡣");
	      else //���з�������������
	      System.out.println(a+"/"+b+"="+(a/b));//��������ͬʱ����������
	      break; //ֹͣ���
	      default: //��������������ͣ��������
	      System.out.println("����ѡ������������!\n");
	      break; //ֹͣ���
	      }
	    }

}
