
/**
 * 我国古代数学家祖冲之研究出了计算圆周率最简单的办法： PI=4/1-4/3+4/5-4/7+4/9-4/11+4/13-4/15+4/17......
 * 这个算式的结果会无限接近于圆周率的值 我国古代数学家祖冲之计算出，圆周率在3.1415926和3.1415927之间
 * 请编程计算，要想得到这样的结果，他要经过多少次加减法运算？
 * 
 */
public class PIcount {
	public static void main(String[] args) {
		double beichushu = 4;// 被除数为4，恒定不变
		int chushu = -1;// 除数
		double PI = 0;// π的初始值
		int count = 0;// 记录加法减法运算次数
		while (PI >= 3.1415927 || PI <= 3.1415926) {// 控制π值范围，在范围外就循环，直至到范围内
			// 加法运算
			chushu += 2;
			PI = PI + beichushu / chushu;
			// 减法运算
			chushu += 2;
			PI = PI - beichushu / chushu;
			// 加减法运算一共运算了2次，每次循环自增2
			count += 2;
		}
		System.out.println("使用祖冲之算法出π值，需要经过" + count + "次加减法运算。");
	}
}