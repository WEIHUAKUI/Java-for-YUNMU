import java.util.Scanner;

public class MyCalendar {

    public static void main(String[] args) {

        //System.out.println(getTotalDays(2017,3));
        printCalendar();
        
    }
    
    public static void printCalendar(){
        System.out.println("������4λ������ݣ�");
        Scanner input = new Scanner(System.in);
        int  nian = input.nextInt();
        System.out.println("�������·ݣ�");
        int yue = input.nextInt();
        
        System.out.println("\t\t\t"+nian+","+yue);
        System.out.println("----------------------------------------------------------");
        System.out.println("������  ����һ  ���ڶ�  ������   ������   ������  ������");
        
        //1��ǰ���ȴ�ӡ���� \t,��ӡ������  Ӧ����getTotalDays(��,��)
        int spaces = getTotalDays(nian, yue)%7;
        for(int i = 0;i<spaces;i++){
            System.out.print("\t");
        }
        
        int days = getDaysOfMonth(nian, yue);
        for (int i = 1; i <=days; i++) {
            System.out.print(i+"\t");
            if((i+spaces) % 7 == 0){
                System.out.println();
            }
        }
    }
    
    //����һ������,����1905��1.1 ��ָ�����ָ���·ݵ���һ�����µ�,һ���ж�����? 2017 4
    //1905.1.1  -  2017.3.31 ������
    //1905.1.1 - 2016.12.31  +  ����!
    //2017.1.1 - 2017.3.31  ����!
    private static int getTotalDays(int year,int month){
        return getDaysFrom1905(year) + getDaysThisYear(year,month);
    }
    
    //����һ������,����ָ�����1��1�� �� ָ���·ݵ�ǰһ�����µ׵�����,  2017.4    2017.1.1-2017.3.31
    public static int getDaysThisYear(int year,int month){//2017.4 
        //һ��  , �ۼ�  ѭ��  for
        int sum = 0;
        for (int i = 1; i < month; i++) {
            sum += getDaysOfMonth(year,i);
        }
        return sum;
    }
    
    //����һ������; ����ָ�����,ָ���·ݵ�����1842 1 3 5 7 8 10 12  
    // 4 6 9 11   --- 30   2 -- ƽ�� 28  ����29��
    private static int getDaysOfMonth(int year,int month){
        /*if(month == 1 ||month == 3 ||month == 5 
                ||month == 7 ||month == 8 ||month == 10 ||month == 12){
            return 31;
        }else if(month == 4||month == 6 ||month == 9 ||month == 11){
            return 30;
        }else if(month == 2){
            //��Ҫ�Ե�ǰ��ݽ����ж�
            if(isRun(year)){
                return 29;
            }else{
                return 28;
            }
        }else{
            return 0;
        }*/
        switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            return 31;
        case 4:
        case 6:
        case 9:
        case 11:
            return 30;
        case 2:
            if(isRun(year)){
                return 29;
            }else{
                return 28;
            }
        default:
            return 0;
        }
    }
    
    //��1905�� ��ָ����ݵ���һ������һ��������;2017  1905.1.1 - 2016.12.31
    //��� -- �ۼ�  --  ѭ�� 1905-365 1906-365 1907-365 1908-366
    private static int getDaysFrom1905(int year){//1909
        int sum = 0;
        for(int i = 1905;i<year;i++){
            //�������  += 366   1905  1906 1907 1908
            if(isRun(i)){
                //��
                sum += 366;
            }else{
                sum += 365;
            }
        }
        return sum;
    }

    // ����һ������,�ж�ĳ������Ƿ�������,����Ƿ���true,���򷵻�false;
    private static boolean isRun(int year) {
        // 2016 �� 2017 ���� 2000 �� 2100 ����
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        }
        return false;
    }
}