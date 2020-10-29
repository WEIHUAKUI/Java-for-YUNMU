
public class Exchange {

	public static void main(String[] args) {
		int a=0;
		//int a=200;  //解析错误，只截后半段
		byte b=1;
		short c;
		c=b;
						b=(byte) a;
						a=c;
						System.out.println("a="+a);
						System.out.println("b="+b);
						System.out.println("kw");

						long test=100L;
						float d=3.14f;
						double e=3.14d;
						
						char f=65;
						System.out.println(f);
						System.out.println("i+j="+ 10+ 5);
						System.out.println(10+5+"个");
						
						
	}

}
