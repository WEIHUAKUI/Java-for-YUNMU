import java.util.Scanner;

public class Baoxiao {

	public static void main(String[] args) {
		int zhicheng,tianshu;
		double jiaotong,zhusu,baoxiao=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("���������ְ��(�߼�-0���м�-1������-2��:");
		zhicheng=sc.nextInt();
		System.out.println("��������ĳ�������:");
		tianshu=sc.nextInt();
		System.out.println("��������Ľ�ͨ��(Ԫ/��):");
		jiaotong=sc.nextDouble();
		System.out.println("���������ס�޷�(Ԫ/��):");
		zhusu=sc.nextDouble();
sc.close();
switch(zhicheng) {
case 0:  //�߼�ְ��
if(zhusu>600)zhusu=600;
baoxiao=jiaotong+zhusu*tianshu+180*tianshu;
break;
case 1:  //�м�ְ��
if(zhusu>450)zhusu=450;
baoxiao=jiaotong+zhusu*tianshu+150*tianshu;
break;	
case 2:  //����ְ��
if(zhusu>300)zhusu=300;
baoxiao=jiaotong+zhusu*tianshu+120*tianshu;
break;
	default:System.out.println("�������");
}
System.out.println("��������:"+baoxiao+"Ԫ");
	}

}
