
public class FractrionAdd {

	public static void main(String[] args) {
		int i,j=1;
		long sum=0,temp=1;      //sum表示累加的和
		for(i=1;i<=20;i++) {  //i加数的个数，j是计算阶乘时的乘数，累加的和，temp表示每个加数（阶乘的值）
			temp=1;
			for(j=1;j<=i;j++) {    //求i的阶乘i!,保存在temp
				temp*=j;          //temp=temp*j
			}
			sum+=temp;	
		}
		System.out.printf("1!+2!+…+20!=%d",sum);

	}

}
