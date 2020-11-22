import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class QQLogin {
	private JPasswordField passwordField;
	private JTextField textField;
	private JFrame frame;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			QQLogin window = new QQLogin();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application
	 */
	public QQLogin() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setTitle("QQ登陆");
		frame.setResizable(false);
		frame.setBounds(100, 100, 220, 136);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JLabel label = new JLabel();
		label.setText("用户名：");
		label.setBounds(10, 21, 66, 18);
		frame.getContentPane().add(label);
		final JLabel label_1 = new JLabel();
		label_1.setText("密码：");
		label_1.setBounds(10, 45, 66, 18);
		frame.getContentPane().add(label_1);
		final JButton button = new JButton();
		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent e) {
				System.out.println("用户名：" + textField.getText());
				System.out.println("密码：" + new String(passwordField.getPassword()));
			}
		});
		button.setText("确定");
		button.setBounds(10, 69, 66, 28);
		frame.getContentPane().add(button);
		final JButton button_1 = new JButton();
		button_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent e) {
				textField.setText("");
				passwordField.setText("");
			}
		});
		button_1.setText("取消");
		button_1.setBounds(133, 69, 66, 28);
		frame.getContentPane().add(button_1);
		textField = new JTextField();
		textField.setBounds(66, 20, 133, 21);
		frame.getContentPane().add(textField);
		passwordField = new JPasswordField();
		passwordField.setBounds(66, 45, 133, 21);
		frame.getContentPane().add(passwordField);
	}
}