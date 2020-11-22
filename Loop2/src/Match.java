
public class Match {

	public static void main(String[] args) {
		char i, j, k;// 定义A-i,B-j,C-k如何被X,Y,Z三个人打
		for (i = 'X'; i <= 'Z'; i++) {// 第一场
			for (j = 'X'; j <= 'Z'; j++) {// 第二场
				if (i != j) { // 不能A和X比赛，如果不和他们比赛，那么执行下一步
					for (k = 'X'; k <= 'Z'; k++) {// 第三场
						if (i != k && j != k) {// 不能C和X,Z比赛，如果不和他们比赛，那么执行下一步
							if (i != 'X' && k != 'X' && k != 'Z') {// 如果这样子全部满足，输出结果
								System.out.printf("A--%c\nB--%c\nC--%c\n", i, j, k);
							}
						}
					}
				}
			}
		}
	}
}
