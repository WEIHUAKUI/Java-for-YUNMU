/**
 * 
 * @author 魏华奎
 *
 */
public class Peach {

	public static void main(String[] args) {
		int n=1;  //i表示的是第几天，n代表每天的桃子数
for(int i=10;i>=1;i--) {
	System.out.printf("第%d天猴子还有%d个桃子。\n",i,n);
	n=(n+1)*2;  //计算前一天的桃子数
}
System.out.printf("第一天猴子摘了%d个桃子。",n);
	}

}
