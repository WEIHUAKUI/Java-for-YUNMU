
public class PrintAdd {

	public static void main(String[] args) {
		int i,j;   //i����ڼ��У�j����ڼ���
		for(i=1;i<=4;i++) {    //���1-4��
			/*	
			if(i==3) {
					System.out.print("\n");
					continue;
					}
					*/
				for(j=1;j<=5;j++) {//���ÿ�е�5������
					if(i==3) {
						break;
						}	
				System.out.print(i*j+"\t");
				}
			System.out.print("\n");
			}
		}
	}