/**
 * 打印出100~999之间的所有“水仙花数”。所谓“水仙花数”，是指一个3位数，其各位数字立方和等于该数本身。
 * 
 * @author 魏华奎
 *
 */
public class Daffodil {

	public static void main(String[] args) {
		System.out.println("1-999中的水仙花数如下：");
		for (int i = 100; i <= 999; i++) { // 定义一个1-999的数i，不停增加
			int g, s, b; // 定义整型：g为各位，s为十位，b为个位
			b = i / 100; // 取百位数上的数b
			s = (i - b * 100) / 10;// 取十位数上的数s
			g = i - b * 100 - s * 10;// 取个位上的数g
			if (i == g * g * g + s * s * s + b * b * b) {// 如果满足各位数字立方和等于该数本身，输出i
				System.out.println(i);
			}
		}
	}
}
