import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		String name,pwd,validate;
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入用户名:");
		name=sc.next();
		System.out.println("请输入密码:");
		pwd=sc.next();
		System.out.println("请输入验证码:");
		validate=sc.next();
		sc.close();
		
		if(!name.equals("admin")||!pwd.equals("123456")||!validate.equals("888888"))
		System.out.println("登录失败");
		if(name.equals("admin")||pwd.equals("123456")||validate.equals("888888"))
			System.out.println("登录成功");

	}

}
