import java.util.Scanner;

public class IfExm {

	public static void main(String[] args) {
		int Java;//成绩
		int english;
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入你的Java成绩（0-100）:");
		Java=sc.nextInt();//输入成绩
		//System.out.println("请输入你的English成绩（0-100）:");
		//english=sc.nextInt();
		if (Java>90&&Java<100){//判断||english>90
			System.out.println("没钱");
			System.out.println("但是小伙子优秀啊");
		}else if (Java<90){                    //如果不是以上结果执行下一个判断
            System.out.println("考这一点点分，想P吃");
            System.out.println("不如跳舞");
		}else if (Java>100){                    //如果不是以上结果执行下一个判断
                System.out.println("你确定这个是成绩，成绩范围应在1-100分之间，请重新输入");
               System.out.println("这都不会还敢要手机，看为师不打死你"); }

	}

}
