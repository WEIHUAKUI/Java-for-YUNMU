
public class PrintAdd {

	public static void main(String[] args) {
		int i,j;   //i代表第几行，j代表第几列
		for(i=1;i<=4;i++) {    //输出1-4行
			/*	
			if(i==3) {
					System.out.print("\n");
					continue;
					}
					*/
				for(j=1;j<=5;j++) {//输出每行的5个数字
					if(i==3) {
						break;
						}	
				System.out.print(i*j+"\t");
				}
			System.out.print("\n");
			}
		}
	}