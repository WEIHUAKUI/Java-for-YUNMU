
public class FractrionAdd {

	public static void main(String[] args) {
		int i,j=1;
		long sum=0,temp=1;      //sum��ʾ�ۼӵĺ�
		for(i=1;i<=20;i++) {  //i�����ĸ�����j�Ǽ���׳�ʱ�ĳ������ۼӵĺͣ�temp��ʾÿ���������׳˵�ֵ��
			temp=1;
			for(j=1;j<=i;j++) {    //��i�Ľ׳�i!,������temp
				temp*=j;          //temp=temp*j
			}
			sum+=temp;	
		}
		System.out.printf("1!+2!+��+20!=%d",sum);

	}

}
