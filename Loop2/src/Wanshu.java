
public class Wanshu {

	public static void main(String[] args) {
		int i,j,sum;    //i代表要检查的数,j是代表因子,sum是因子的和
		for(i=1;i<=1000;i++) {
			sum=0;
			for(j=1;j<=i/2;j++) {   //求i的因子和
				if(i%j==0) {
					sum+=j;    //sum=sum+j
				}
			}
			if(i==sum)System.out.println(i+"是完数");
		}

	}

}
