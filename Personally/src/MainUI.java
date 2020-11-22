import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI extends JFrame implements ActionListener {
	// 定义组件
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
		// 创建组件
		jb1 = new JButton("重新表白");
		jb2 = new JButton("继续表白");
		jb3 = new JButton("退出");
		// 设置监听
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jrb1 = new JRadioButton("愿意    ");
		jrb2 = new JRadioButton("不愿意");
		bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		jrb2.setSelected(true);
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jlb1 = new JLabel("表      白        对       象：  ");
		jlb2 = new JLabel("说一句你想表白的话：    ");
		jlb3 = new JLabel("是否愿意余生与ta一起过：");
		jtf = new JTextField(10);
		jpf = new JPasswordField(10);
		// 加入到JPanel中
		jp1.add(jlb1);
		jp1.add(jtf);
		jp2.add(jlb2);
		jp2.add(jpf);
		jp3.add(jlb3);
		jp3.add(jrb1);
		jp3.add(jrb2);
		jp4.add(jb1); // 添加按钮
		jp4.add(jb2);
		jp4.add(jb3);
		// 加入JFrame中
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.setLayout(new GridLayout(4, 2)); // 选择GridLayout布局管理器
		this.setTitle("表白系统");
		this.setSize(320, 200);
		this.setLocation(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置当关闭窗口时，保证JVM也退出
		this.setVisible(true);
		this.setResizable(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}