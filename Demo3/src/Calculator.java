import java.util.Scanner;//申明扫描

public class Calculator {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	      double a,b;  //定义两个数字a,b
	      int c;       //定义选择计算类型c
		  System.out.println("简单计算器:");
		  System.out.println("====菜单====");
		  System.out.println("1-------加法");
		  System.out.println("2-------减法");
	      System.out.println("3-------乘法");
		  System.out.println("4-------除法");
		  System.out.println("============");
		  System.out.println("请输入你选择的运算法则:");
		  c=sc.nextInt();     //用户输入计算类型c
	      System.out.println("请输入要运算的数据的第一个数(a):");
	      a=sc.nextInt();  //用户输入数字a
	      System.out.println("请输入要运算的数据的第二个数(b):");
	      b=sc.nextInt();  //用户输入数字b
	      System.out.println("运算过程与结果是:");
	      switch(c) //判断计算类型选择运算法则
	      {
	      case 1: //加法运算
	      System.out.println(a+"+"+b+"="+(a+b)); //输出结果的同时输出运算过程
	      break; //停止输出
	      case 2: //减法运算
	      System.out.println(a+"-"+b+"="+(a-b));//输出结果的同时输出运算过程
	      break; //停止输出
	      case 3: //乘法运算
	      System.out.println(a+"*"+b+"="+(a*b));//输出结果的同时输出运算过程
	      break; //停止输出
	      case 4: //除法运算
	      if(b==0) //判断被除数b是否等于0
	      System.out.println("运算法则错误！被除数不能为零。");
	      else //进行非零数除法运算
	      System.out.println(a+"/"+b+"="+(a/b));//输出结果的同时输出运算过程
	      break; //停止输出
	      default: //如果不是上面类型，输出错误
	      System.out.println("运算选择错误，数据溢出!\n");
	      break; //停止输出
	      }
	    }

}
