
public class Wanshu {

	public static void main(String[] args) {
		int i,j,sum;    //i����Ҫ������,j�Ǵ�������,sum�����ӵĺ�
		for(i=1;i<=1000;i++) {
			sum=0;
			for(j=1;j<=i/2;j++) {   //��i�����Ӻ�
				if(i%j==0) {
					sum+=j;    //sum=sum+j
				}
			}
			if(i==sum)System.out.println(i+"������");
		}

	}

}
