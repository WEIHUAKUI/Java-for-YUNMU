/**
 * 解出三元一次方程式组的JAVA代码方案
 * 
 * @作者 魏华奎 原理:对x,y,z 1-30之间的全部值进行穷举 找出符合条件x + y + z == 30 && (3 * x) + (2 * y)+z == 50
 *      同时成立的x,y,z的值 
 *      因为有小孩，男人，女人，所以每一个至少有一人
 */
public class Marx {

	public static void main(String[] args) {
		System.out.println("三元一次方程式组");// 输出
		System.out.println("x+y+z=30");// 输出
		System.out.println("3*x+2*y+z=50");// 输出
		System.out.println("的解集为：");// 输出
		for (int x = 0; x <= 30; x++) {// 对x进行不断增加
			for (int y = 0; y <= 30; y++) {// 对y进行不断增加
				for (int z = 0; z <= 30; z++) {// 对z进行不断增加
					if (x + y + z == 30 && (3 * x) + (2 * y) + z == 50) {
						// 寻找符合条件(x + y + z == 30 && (3 * x) + (2 * y) + z == 50)同时成立的x,y,z的值
						if (x >= 1 && y >= 1 && z >= 1) {
							// 因为有小孩，男人，女人，所以每一个至少有一人
							System.out.print("男人 x=" + x + " ");// 输出x的值
							System.out.print("女人 y=" + y + " ");// 输出y的值
							System.out.print("小孩 z=" + z + " ");// 输出z的值
							System.out.print("\n");// 每输出一次x,y,z的值换行一次
							break;// 如果没有了就强制终止
						}
					}
				}
			}
		}

	}

}
