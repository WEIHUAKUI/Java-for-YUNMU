
public class Match {

	public static void main(String[] args) {
		char i, j, k;// ����A-i,B-j,C-k��α�X,Y,Z�����˴�
		for (i = 'X'; i <= 'Z'; i++) {// ��һ��
			for (j = 'X'; j <= 'Z'; j++) {// �ڶ���
				if (i != j) { // ����A��X����������������Ǳ�������ôִ����һ��
					for (k = 'X'; k <= 'Z'; k++) {// ������
						if (i != k && j != k) {// ����C��X,Z����������������Ǳ�������ôִ����һ��
							if (i != 'X' && k != 'X' && k != 'Z') {// ���������ȫ�����㣬������
								System.out.printf("A--%c\nB--%c\nC--%c\n", i, j, k);
							}
						}
					}
				}
			}
		}
	}
}
