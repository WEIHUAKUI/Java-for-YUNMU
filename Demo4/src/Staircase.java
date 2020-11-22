
public class Staircase {

	public static void main(String[] args) {
	for(int i=100;i<=999;i++) {
		/*
		if(i%2==1&&i%3==2&&i%4==3&&i%5==4&&i%6==5&&i%7==0) {
		System.out.println(i);
		}*/
		if(i%2!=1)continue;
		if(i%3!=2)continue;
		if(i%4!=3)continue;
		if(i%5!=4)continue;
		if(i%6!=5)continue;
		if(i%7!=0)continue;
		System.out.println(i);
		
	}

	}

}
