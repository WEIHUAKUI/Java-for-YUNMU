import java.util.Scanner;

public class StrCompare {

	public static void main(String[] args) {
String str1,str2,strt;
int res;
Scanner sc=new Scanner(System.in);
System.out.println("�����һ�����ʣ�");
str1=sc.next();
System.out.println("����ڶ������ʣ�");
str2=sc.next();
strt=str1.compareTo(str2)>0?str2:str1;
System.out.println(strt.equals(str1)?(str1+str2):(str2+str1));
//res=str1.compareTo(str2);
//System.out.println(res);
/*if (res>=0){
	System.out.println(str2+str1);
}else if (res<=0){                    //����������Ͻ��ִ����һ���ж�
    System.out.println(str1+str2); 
}*/
	}

}
