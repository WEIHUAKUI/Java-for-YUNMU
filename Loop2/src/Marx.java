/**
 * �����Ԫһ�η���ʽ���JAVA���뷽��
 * 
 * @���� κ���� ԭ��:��x,y,z 1-30֮���ȫ��ֵ������� �ҳ���������x + y + z == 30 && (3 * x) + (2 * y)+z == 50
 *      ͬʱ������x,y,z��ֵ 
 *      ��Ϊ��С�������ˣ�Ů�ˣ�����ÿһ��������һ��
 */
public class Marx {

	public static void main(String[] args) {
		System.out.println("��Ԫһ�η���ʽ��");// ���
		System.out.println("x+y+z=30");// ���
		System.out.println("3*x+2*y+z=50");// ���
		System.out.println("�Ľ⼯Ϊ��");// ���
		for (int x = 0; x <= 30; x++) {// ��x���в�������
			for (int y = 0; y <= 30; y++) {// ��y���в�������
				for (int z = 0; z <= 30; z++) {// ��z���в�������
					if (x + y + z == 30 && (3 * x) + (2 * y) + z == 50) {
						// Ѱ�ҷ�������(x + y + z == 30 && (3 * x) + (2 * y) + z == 50)ͬʱ������x,y,z��ֵ
						if (x >= 1 && y >= 1 && z >= 1) {
							// ��Ϊ��С�������ˣ�Ů�ˣ�����ÿһ��������һ��
							System.out.print("���� x=" + x + " ");// ���x��ֵ
							System.out.print("Ů�� y=" + y + " ");// ���y��ֵ
							System.out.print("С�� z=" + z + " ");// ���z��ֵ
							System.out.print("\n");// ÿ���һ��x,y,z��ֵ����һ��
							break;// ���û���˾�ǿ����ֹ
						}
					}
				}
			}
		}

	}

}
