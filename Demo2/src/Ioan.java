import java.util.Scanner;

public class Ioan {

	public static void main(String[] args) {
		double rate,loan,monRepay,totalRepay;
		int year;
		Scanner sc=new Scanner(System.in);
		System.out.println("������:");
		rate=sc.nextDouble();
		Scanner sc1=new Scanner(System.in);
		System.out.println("���:");
		year=sc1.nextInt();
		Scanner sc2=new Scanner(System.in);
		System.out.println("�����ܶ�:");
		loan=sc1.nextDouble();
		sc1.close();
		monRepay=(loan*rate)/(1-(1/Math.pow((1+rate), year*12)));
		totalRepay=monRepay*year*12;
		System.out.println("�����ܶ�:"+totalRepay);
		System.out.println("�»����:"+monRepay);
	}

}
