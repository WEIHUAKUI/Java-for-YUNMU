import java.util.Scanner;

public class StrCompare {

	public static void main(String[] args) {
String str1,str2,strt;
int res;
Scanner sc=new Scanner(System.in);
System.out.println("输入第一个单词：");
str1=sc.next();
System.out.println("输入第二个单词：");
str2=sc.next();
strt=str1.compareTo(str2)>0?str2:str1;
System.out.println(strt.equals(str1)?(str1+str2):(str2+str1));
//res=str1.compareTo(str2);
//System.out.println(res);
/*if (res>=0){
	System.out.println(str2+str1);
}else if (res<=0){                    //如果不是以上结果执行下一个判断
    System.out.println(str1+str2); 
}*/
	}

}
