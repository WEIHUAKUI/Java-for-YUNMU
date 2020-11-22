import java.util.Scanner;

public class Baoxiao {

	public static void main(String[] args) {
		int zhicheng,tianshu;
		double jiaotong,zhusu,baoxiao=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入你的职称(高级-0，中级-1，初级-2）:");
		zhicheng=sc.nextInt();
		System.out.println("请输入你的出差天数:");
		tianshu=sc.nextInt();
		System.out.println("请输入你的交通费(元/天):");
		jiaotong=sc.nextDouble();
		System.out.println("请输入你的住宿费(元/天):");
		zhusu=sc.nextDouble();
sc.close();
switch(zhicheng) {
case 0:  //高级职称
if(zhusu>600)zhusu=600;
baoxiao=jiaotong+zhusu*tianshu+180*tianshu;
break;
case 1:  //中级职称
if(zhusu>450)zhusu=450;
baoxiao=jiaotong+zhusu*tianshu+150*tianshu;
break;	
case 2:  //初级职称
if(zhusu>300)zhusu=300;
baoxiao=jiaotong+zhusu*tianshu+120*tianshu;
break;
	default:System.out.println("输入错误！");
}
System.out.println("报销费用:"+baoxiao+"元");
	}

}
