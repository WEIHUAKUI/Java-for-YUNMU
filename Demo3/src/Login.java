import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		String name,pwd,validate;
		Scanner sc=new Scanner(System.in);
		System.out.println("�������û���:");
		name=sc.next();
		System.out.println("����������:");
		pwd=sc.next();
		System.out.println("��������֤��:");
		validate=sc.next();
		sc.close();
		
		if(!name.equals("admin")||!pwd.equals("123456")||!validate.equals("888888"))
		System.out.println("��¼ʧ��");
		if(name.equals("admin")||pwd.equals("123456")||validate.equals("888888"))
			System.out.println("��¼�ɹ�");

	}

}
