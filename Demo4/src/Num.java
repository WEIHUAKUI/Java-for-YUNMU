/**
 * 求1-100的和
 * @author 魏华奎
 *
 */
public class Num {

	public static void main(String[] args) {
		int i=1,sum=0;    
		while(i<=100) {
			sum=sum+i;
			i++;
		}
System.out.println("1+2+3+……+99+100="+sum);
	}

}
