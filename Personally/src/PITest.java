public class PITest {
  private static int bytelimit = 5;// ֻȡС��λ��ǰΪ5λ
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    // ��֪Pi�����ú���4 * (1 �C 1/3 + 1/5 �C 1/7 + ��) ���㣬С�������λ----����Բ����
    // ˼·������������ʽ�����5λֵ������һ��5λֵ�Ƚϣ������ͬ��Ϊ���ս����
    // �����ͬ���򱣴���ֵ�����������´ε�ֵ�Ƚ�ֱ����ͬ
    double pitemp = 0;// ���ݹ�ʽ����ֵ
    double finalpi = 0; // �ϴ�����ֵ��С�������λ��
    double pi = 0;// ��������ֵ��С�������λ��
    int i = 0;// ������
    double b = 0;// ��ʽ�������ڵ�ֵ
    int ii = 20;// ������ֵͬ����,�����������������ii��������ֵͬ
    int finalii = 20;// ��iiֵ��ͬ��������iiֵ�仯�� ���ָ�iiֵ
    // int iii=20;//������ͬ����
    while (true) {
      // ��������
      if (i == 1000000) {
        break;
      }
      double rs = 1 + 2 * i;
      double d = 1 / rs;
      if (i % 2 == 0 && i != 1) {
        b = b + d;
        // System.out.println("---"+i+"----��------***"+b);
      } else {
        b = b - d;
        // System.out.println("---"+i+"----��------***"+b);
      }
      i = i + 1;
      // System.out.println(b);
      pitemp = (b) * 4;
      // System.out.println(pitemp);
      // С�����λ�����ڵ���5λ
      if (String.valueOf(pitemp).length() > bytelimit) {
        pi = subInt(pitemp);// ��ȡС�����5λ��ֵ
        System.out.println(i + "��---pi--####" + pi + "---final--####"
            + finalpi);
        // ����ϴν���뱾�ν����ͬ��������������-1��
        // �������ͬ������ǰ���������ٴν����ͬ�����������������ָ���ʼֵ,�����汾�ε���ֵ������׼�����´αȽ�
        if (finalpi == pi) {
          System.out.println("��" + (finalii + 1 - ii)
              + "��-----��ͬ----------���ս��-------------finaoanoaof"
              + pitemp);
          ii = ii - 1;
          if (ii == 0) {
            System.out.println("���ռ���ó���Բ����Ϊ" + pitemp);
            System.out.println("��������Բ���ʵ�ǰ��λС��" + pi);
            break;
          }
        } else {
          finalpi = pi;
          ii = finalii;
        }
      }
    }
  }
  // ��ʽ��С��
  public static double subInt(double i) {
    String s = String.valueOf(i).substring(0, bytelimit + 2);// ��ȡ С�����5λ
    String ss = String.valueOf(i).substring(bytelimit + 2, bytelimit + 3);// ��ȡС�����6λ
    double dd = Double.parseDouble(s);// ת��ΪС�������5λ��С��
    // �����6λ��ֵ���ڵ���5�������������룬��ת�����С������0.00001
    if (ss.compareTo("5") >= 0) {
      dd = dd + 0.00001;
    }
    return dd;
  }
}