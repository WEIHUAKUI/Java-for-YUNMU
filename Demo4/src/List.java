/**
 * 习题内容：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
 * @作者 魏华奎
 *原理：下一个数的分母等于上一个数的分子，下一个数的分子等于上一个数的分子加分母
 *解决方法：d=n，n=d+centre;
 */
public class List {
	public static void main(String[] args) {
		int n = 2;		//第一个数分子n=2
		int d = 1;		//第一个数分母d=1
		int centre = 0; //中间变量centre初始化
		double fruit = 0;//初始化fruit（结果）变量为double类型
		for(int i = 1;i<=20;i++) {	//从2/1（即fruit(结果)+i=(double)n/d）开始到i等于20时结束，i每执行一次加1
			fruit += (double)n/d;//得到下一个分数，强制转换变量为double类型，并输出到fruit（结果）变量里面
			centre = d;		//令t等于第一个数的分子 
			d = n;		//导出下一个数的分母：下一个数的分母等于上一个数的分子
			n = d+centre;	//导出下一个数的分子：下一个数的分子等于上一个数的分子加分母
		}
		System.out.printf("前20项之和为："+fruit);
	}

}
