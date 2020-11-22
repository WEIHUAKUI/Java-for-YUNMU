
public class NoQiantao {

	public static void main(String[] args) {
		char workday='y';
		byte weather=0;  //0表示天晴，1表示下雨
			if(workday=='y') {
System.out.println("早安，打工人");
	}
	else if(workday == 'n' && weather == 0) {
			System.out.println("室外玩");
		}
		else if(workday == 'n' && weather == 1){
			System.out.println("室内玩");
		}
	  }
	}

