
public class RiceNum {

	public static void main(String[] args) {
		int i=1,j=1;    //i存放格子中的米粒数，j存放格子数
		while(j<=20) {
			System.out.println("第"+j+"个格子的米粒数是："+i);
			j++;
			i=i*2;
		}

	}

}
