import java.util.Scanner;

public class Revenue {

	public static void main(String[] args) {
		double revenue,income=0,in;
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入您的年收收入:");
		revenue=sc.nextDouble();
		if(revenue<=5000) {income=0;}
		else if(revenue<=36000&&revenue>5000) {income=(revenue-5000)*0.03;}
		else if(revenue>36000&&revenue<=144000) {income=(revenue-36000)*0.1+31000*0.03;}
		else if(revenue>144000&&revenue<=300000) {income=(revenue-144000)*0.2+(108000*0.1)+(31000*0.03);}
		else if(revenue>300000&&revenue<=420000) {income=(revenue-300000)*0.25+(156000*0.2)+(108000*0.1)+(31000*0.03);}
		else if(revenue>420000&&revenue<=660000) {income=(revenue-420000)*0.3+(120000*0.25)+(156000*0.2)+(108000*0.1)+(31000*0.03);}
		else if(revenue>660000&&revenue<=960000) {income=(revenue-660000)*0.35+(240000*0.3)+(120000*0.25)+(156000*0.2)+(108000*0.1)+(31000*0.03);}
		else {income=(revenue-960000)*0.45+(300000*0.35)+(240000*0.3)+(120000*0.25)+(156000*0.2)+(108000*0.1)+(31000*0.03);}
		in=revenue-income;
	System.out.println("您税收后的收入为:"+in);
	}

}
