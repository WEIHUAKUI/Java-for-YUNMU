import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI extends JFrame implements ActionListener {
	// �������
	JButton jb1, jb2, jb3 = null;
	JRadioButton jrb1, jrb2 = null;
	JPanel jp1, jp2, jp3, jp4 = null;
	JTextField jtf = null;
	JLabel jlb1, jlb2, jlb3 = null;
	JPasswordField jpf = null;
	ButtonGroup bg = null;

	public static void main(String[] args) {
		MainUI mUI = new MainUI();
	}

	public MainUI() {
		// �������
		jb1 = new JButton("���±��");
		jb2 = new JButton("�������");
		jb3 = new JButton("�˳�");
		// ���ü���
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jrb1 = new JRadioButton("Ը��    ");
		jrb2 = new JRadioButton("��Ը��");
		bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		jrb2.setSelected(true);
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jlb1 = new JLabel("��      ��        ��       ��  ");
		jlb2 = new JLabel("˵һ�������׵Ļ���    ");
		jlb3 = new JLabel("�Ƿ�Ը��������taһ�����");
		jtf = new JTextField(10);
		jpf = new JPasswordField(10);
		// ���뵽JPanel��
		jp1.add(jlb1);
		jp1.add(jtf);
		jp2.add(jlb2);
		jp2.add(jpf);
		jp3.add(jlb3);
		jp3.add(jrb1);
		jp3.add(jrb2);
		jp4.add(jb1); // ��Ӱ�ť
		jp4.add(jb2);
		jp4.add(jb3);
		// ����JFrame��
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.setLayout(new GridLayout(4, 2)); // ѡ��GridLayout���ֹ�����
		this.setTitle("���ϵͳ");
		this.setSize(320, 200);
		this.setLocation(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���õ��رմ���ʱ����֤JVMҲ�˳�
		this.setVisible(true);
		this.setResizable(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}