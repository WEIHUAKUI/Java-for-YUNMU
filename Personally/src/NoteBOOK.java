import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.datatransfer.*;
class text implements Serializable{
	String keyword;//密码
	String textmain;//文本部分
}
public class NoteBOOK extends JFrame implements ActionListener,ListSelectionListener{
	MenuBar menusBar;//菜单栏
	MenuItem open,keep,save,newfile,exit_out,about,text_font,colorchoose,backchoose,timeadd,keyopen,keysave,zcancel,copy,paste,cut,delete,selectall,search,autoline;
	Menu file,edit,format,help;//菜单种类
	MenuShortcut opencut,dsavecut,savecut,newworkcut,quitcut,aboutcut,fontchoosecut,colorchoosecut,backchoosecut,timeaddcut,keyopencut,keysavecut,zcancelcut,copycut,pastecut,cutcut,deletecut,selectallcut,searchcut,autolinecut;
	Toolkit tool=this.getToolkit();
	Clipboard clip;//剪贴版
	Image image=tool.getImage("data/icon.jpg");//框架图标
	JTextArea textarea;//文本区域
	JDialog dialog,fontdialog,keydialog,searchdialog;//问是否
	JList fontlist;//字体单
	Choice fontpara;//字体粗斜
	JTextField fontsizetext;//字体大小输入
	JTextField searchtext;//搜索文字
	JTextField changetext;//替换文字
	TextField keyentertext;//密码输入
	JScrollPane listscroll,textscroll;
	JPanel fontbuttonpanel,fontmainpanel,fontsizepanel,searchpanel,searchbuttonpanel,searchtextpanel,changepanel,changetextpanel,changebuttonpanel;
	GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
	String fontname[]=ge.getAvailableFontFamilyNames();//字体库
	boolean havesave=true;//是否已存
	boolean enterquit=false;//用来判定对话框之前是否按退出
	JButton yes,no,cancel,ok,can,keyok,searchok,searchcancel,changeok,changeall;//对话框按钮
	JLabel tip,fonttype,fontsize,searchtip,changetip;//提示
	FileDialog filedialog;//输入输出对话框
	text text;//存储对象
	String opensource="";//用来判断是否已保存
	String texttype="宋体";//字体
	String direct="";//保存路径
	String canceltext="";//用来撤销
	int size=18;//字体大小
	int para=0;//字体粗斜
	Font font=new Font(texttype,Font.PLAIN,size);
	Color fontcolor=Color.black;//字体颜色
	Color backcolor=Color.white;//背景颜色
	Date nowtime;//现在时间
	char savemode1='s';
	char savemode2='t';//加密保存方式
	public NoteBOOK(String title){
		this.setIconImage(image);//图标
		setTitle(title);//标题
		this.setResizable(true);//大小可调
		this.setBackground(Color.cyan);
		this.setBounds(new Rectangle(150,100,800,550));//窗口大小
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.out.println("程序关闭");
				System.exit(0);
				}
            public void windowOpened(WindowEvent e){
            	System.out.println("程序打开");
            	}
            });//程序关闭监听
            clip=getToolkit().getSystemClipboard();//获得剪贴版
            this.initcopy();//初始化为空
            textarea=new JTextArea();
            textarea.setLineWrap(false);
            textarea.setFont(font);
            textarea.setForeground(Color.black);
            textarea.setBackground(Color.white);
            textscroll=new JScrollPane(textarea);
            this.add(textscroll);
            //文本域
//------------------------------------------------
            searchdialog=new JDialog(this,"搜索/替換",false);
            searchdialog.setResizable(false);
            searchdialog.setLayout(new BorderLayout());
            searchdialog.setSize(250,230);
            searchok=new JButton("查找下一个");
            searchcancel=new JButton("取消搜索");
            searchtext=new JTextField("",10);
            searchtip=new JLabel("搜索关键字：");
            searchpanel=new JPanel();
            searchpanel.setBorder(BorderFactory.createTitledBorder("搜索"));//加边框
            searchpanel.setLayout(new BoxLayout(searchpanel, BoxLayout.Y_AXIS));//上下的
            searchbuttonpanel=new JPanel();
            searchbuttonpanel.setLayout(new FlowLayout());
            searchtextpanel=new JPanel();
            searchtextpanel.setLayout(new FlowLayout());
            searchtextpanel.add(searchtip);
            searchtextpanel.add(searchtext);
            searchbuttonpanel.add(searchok);
            searchbuttonpanel.add(searchcancel);
            searchpanel.add(searchtextpanel);
            searchpanel.add(searchbuttonpanel);
            searchdialog.add(searchpanel,BorderLayout.NORTH);
            searchok.addActionListener(this);
            searchcancel.addActionListener(this);   //搜索对话框(搜索)
           
            changetext=new JTextField("",10);
            changetip=new JLabel("替换为：  ");
            changeok=new JButton("替换");
            changeall=new JButton("全部替换");
            changepanel=new JPanel();
            changepanel.setBorder(BorderFactory.createTitledBorder("替换"));//加边框
            changepanel.setLayout(new BoxLayout(changepanel, BoxLayout.Y_AXIS));//上下的
            changebuttonpanel=new JPanel();
            changebuttonpanel.setLayout(new FlowLayout());
            changetextpanel=new JPanel();
            changetextpanel.setLayout(new FlowLayout());
            changetextpanel.add(changetip);
            changetextpanel.add(changetext);
            changebuttonpanel.add(changeok);
            changebuttonpanel.add(changeall);
            changepanel.add(changetextpanel);
            changepanel.add(changebuttonpanel);
            searchdialog.add(changepanel,BorderLayout.CENTER);
            changeok.addActionListener(this);
            changeall.addActionListener(this);     //搜索对话框(替换)
           
            keyentertext=new TextField("",8);
            keyentertext.setEchoChar('*');
            keyok=new JButton("输入完成");
            keydialog=new JDialog(this,"密码设置",true);
            keydialog.setResizable(false);
            keydialog.setLayout(new FlowLayout());
            keydialog.setSize(250,80);
            keydialog.add(keyentertext);
            keydialog.add(keyok);
            keyok.addActionListener(this);          //密码对话框
            
            yes=new JButton("是");
            no=new JButton("否");
            cancel=new JButton("取消");
            tip=new JLabel("文件的文字已经改动，要保存文件吗？");
            dialog=new JDialog(this,"写字板",true);
            dialog.setResizable(false);
            dialog.setLayout(new FlowLayout());
            dialog.setSize(250,100);
            dialog.add(tip);
            dialog.add(yes);
            dialog.add(no);
            dialog.add(cancel);
            yes.addActionListener(this);
            no.addActionListener(this);
            cancel.addActionListener(this);          //保存提示对话框

            ok=new JButton("确定");
            can=new JButton("取消");
            fontpara=new Choice();
            fontpara.add("一般");
            fontpara.add("粗体");
            fontpara.add("斜体");
            fontpara.add("粗斜体");
            fonttype=new JLabel("字体选择：");
            fontsize=new JLabel("字体大小选择：");
            fontsizetext=new JTextField("18",2);
            fontlist=new JList(fontname);
            listscroll=new JScrollPane(fontlist);
            fontbuttonpanel=new JPanel();
            fontbuttonpanel.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
            fontbuttonpanel.add(ok);
            fontbuttonpanel.add(can);
            fontmainpanel=new JPanel();
            fontmainpanel.setLayout(new BorderLayout());
            fontmainpanel.add(fonttype,BorderLayout.NORTH);
            fontmainpanel.add(listscroll,BorderLayout.CENTER);
            fontsizepanel=new JPanel();
            fontsizepanel.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
            fontsizepanel.add(fontsize);
            fontsizepanel.add(fontsizetext);
            fontsizepanel.add(fontpara);
            fontdialog=new JDialog(this,"字体对话框",true);
            fontdialog.setResizable(false);
            fontdialog.setLayout(new BorderLayout());
            fontdialog.setSize(440,200);
            fontdialog.add(fontmainpanel,BorderLayout.WEST);
            fontdialog.add(fontbuttonpanel,BorderLayout.SOUTH);
            fontdialog.add(fontsizepanel,BorderLayout.EAST);
            fontlist.addListSelectionListener(this);
            ok.addActionListener(this);
            can.addActionListener(this);                    //字体对话框
//-------------------------------------------------------
            menusBar=new MenuBar();
            file=new Menu("文件");
            edit=new Menu("编辑");
            format=new Menu("格式");
            help=new Menu("帮助");
            newfile=new MenuItem("新建");
            open=new MenuItem("打开");
            keep=new MenuItem("保存");
            save=new MenuItem("另存为");
            exit_out=new MenuItem("退出");
            zcancel=new MenuItem("撤销");
            copy=new MenuItem("复制");
            paste=new MenuItem("粘贴");
            cut=new MenuItem("剪切");
            delete=new MenuItem("删除");
            selectall=new MenuItem("全选");
            search=new MenuItem("搜索/替換");
            timeadd=new MenuItem("时间/日期");
            autoline=new MenuItem("自动换行");
            text_font=new MenuItem("字体格式...");
            colorchoose=new MenuItem("字体颜色...");
            backchoose=new MenuItem("背景颜色...");
            about=new MenuItem("关于");
            keyopen=new MenuItem("载入加密文件");
            keysave=new MenuItem("加密保存为");

            newworkcut=new MenuShortcut(KeyEvent.VK_N);
            newfile.setShortcut(newworkcut);
            opencut=new MenuShortcut(KeyEvent.VK_O);
            open.setShortcut(opencut);
            dsavecut=new MenuShortcut(KeyEvent.VK_S);
            keep.setShortcut(dsavecut);
            savecut=new MenuShortcut(KeyEvent.VK_L);
            save.setShortcut(savecut);
            quitcut=new MenuShortcut(KeyEvent.VK_Q);
            exit_out.setShortcut(quitcut);
            fontchoosecut=new MenuShortcut(KeyEvent.VK_F);
            text_font.setShortcut(fontchoosecut);
            colorchoosecut=new MenuShortcut(KeyEvent.VK_Y);
            colorchoose.setShortcut(colorchoosecut);
            backchoosecut=new MenuShortcut(KeyEvent.VK_B);
            backchoose.setShortcut(backchoosecut);
            aboutcut=new MenuShortcut(KeyEvent.VK_H);
            about.setShortcut(aboutcut);
            timeaddcut=new MenuShortcut(KeyEvent.VK_F5);
            timeadd.setShortcut(timeaddcut);
            keyopencut=new MenuShortcut(KeyEvent.VK_P);
            keyopen.setShortcut(keyopencut);
            keysavecut=new MenuShortcut(KeyEvent.VK_K);
            keysave.setShortcut(keysavecut);
            copycut=new MenuShortcut(KeyEvent.VK_C);
            copy.setShortcut(copycut);
            pastecut=new MenuShortcut(KeyEvent.VK_V);
            paste.setShortcut(pastecut);
            cutcut=new MenuShortcut(KeyEvent.VK_X);
            cut.setShortcut(cutcut);
            deletecut=new MenuShortcut(KeyEvent.VK_DELETE);
            delete.setShortcut(deletecut);
            selectallcut=new MenuShortcut(KeyEvent.VK_A);
            selectall.setShortcut(selectallcut);
            zcancelcut=new MenuShortcut(KeyEvent.VK_Z);
            zcancel.setShortcut(zcancelcut);
            searchcut=new MenuShortcut(KeyEvent.VK_F3);
            search.setShortcut(searchcut);
            autolinecut=new MenuShortcut(KeyEvent.VK_F2);
            autoline.setShortcut(autolinecut);

            file.add(newfile);
            file.add(open);
            file.add(keep);
            file.add(save);
            file.addSeparator();
            file.add(keyopen);
            file.add(keysave);
            file.addSeparator();
            file.add(exit_out);
            edit.add(zcancel);
            edit.addSeparator();
            edit.add(copy);
            edit.add(paste);
            edit.add(cut);
            edit.add(delete);
            edit.addSeparator();
            edit.add(search);
            edit.addSeparator();
            edit.add(selectall);
            edit.add(timeadd);
            format.add(autoline);
            format.addSeparator();
            format.add(text_font);
            format.add(colorchoose);
            format.add(backchoose);
            help.add(about);
            menusBar.add(file);
            menusBar.add(edit);
            menusBar.add(format);
            menusBar.add(help);
            setMenuBar(menusBar);

            newfile.addActionListener(this);
            open.addActionListener(this);
            keep.addActionListener(this);
            save.addActionListener(this);
            exit_out.addActionListener(this);
            zcancel.addActionListener(this);
            copy.addActionListener(this);
            paste.addActionListener(this);
            cut.addActionListener(this);
            search.addActionListener(this);
            delete.addActionListener(this);
            selectall.addActionListener(this);
            keyopen.addActionListener(this);
            keysave.addActionListener(this);
            text_font.addActionListener(this);
            colorchoose.addActionListener(this);
            backchoose.addActionListener(this);
            timeadd.addActionListener(this);
            autoline.addActionListener(this);
            about.addActionListener(this);      //菜单栏
            }
 //------------------------------------------------------
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==newfile){
			this.judge();
			this.newwork();
			}
		if(e.getSource()==open){
			this.judge();
			this.open();
			}
		if(e.getSource()==keep){
			this.dsave();
			}
		if(e.getSource()==save){
			this.save();
			}
		if(e.getSource()==exit_out){
			this.judge();
			this.quit();
			}
		if(e.getSource()==keyopen){
			this.judge();
			this.keyopen();
			}
		if(e.getSource()==keysave){
			this.keysave();
			}
		if(e.getSource()==zcancel){
			this.zcancel();
			}
		if(e.getSource()==copy){
			this.copy();
			}
		if(e.getSource()==paste){
			this.paste();
			}
		if(e.getSource()==cut){
			this.cut();
			}
		if(e.getSource()==search){
			searchdialog.setVisible(true);
			}
		if(e.getSource()==searchok){
			this.search();
			}
		if(e.getSource()==searchcancel){
			searchdialog.setVisible(false);
			}
		if(e.getSource()==changeok){
			this.change();
			}
		if(e.getSource()==changeall){
			this.changeall();
			}
		if(e.getSource()==delete){
			this.delete();
			}
		if(e.getSource()==selectall){
			this.selectall();
			}
		if(e.getSource()==timeadd){
			this.time();
			}
		if(e.getSource()==autoline){
			this.autoline();
			}
		if(e.getSource()==text_font){
            fontdialog.setVisible(true);
			}
		if(e.getSource()==colorchoose){
			this.colorchoose();
			}
		if(e.getSource()==backchoose){
			this.backchoose();
			}
		if(e.getSource()==about){
			this.about();
			}
		if(e.getSource()==cancel){
			dialog.setVisible(false);
			enterquit=false;
			}
		if(e.getSource()==no){
			if(!enterquit){
				dialog.setVisible(false);
				textarea.setText("");
				}else if(enterquit){
				System.exit(0);
				}
				else{
					
				}
			}
		if(e.getSource()==yes){
			dialog.setVisible(false);
			this.save();
			if(enterquit){
				System.exit(0);
				}
			}
		if(e.getSource()==ok){
			this.font();
			textarea.setFont(font);
			fontdialog.setVisible(false);
			}
		if(e.getSource()==can){
			fontdialog.setVisible(false);
			}
		if(e.getSource()==keyok){
			keydialog.setVisible(false);
			}
		}
	public void valueChanged(ListSelectionEvent e){
		texttype=fontname[fontlist.getSelectedIndex()];
	}
	public void newwork(){
		if(!havesave){
			dialog.setVisible(true);
		}else{
			textarea.setText("");
			direct="";
			canceltext=textarea.getText();//用于撤销
			}		
		opensource=textarea.getText();
	}
	public void open(){
		if(!havesave){
			dialog.setVisible(true);
		}try{
			filedialog=new FileDialog(this,"打开",FileDialog.LOAD);
			filedialog.setVisible(true);
			if(filedialog.getDirectory()!=null && filedialog.getFile()!=null){
				BufferedReader in=new BufferedReader(new InputStreamReader(new FileInputStream(filedialog.getDirectory()+filedialog.getFile())));
				String temp="";
				String now=(String)in.readLine();
				while(now!=null){
					temp+=now+"\r"+"\n";
					now=(String)in.readLine();
				}
				textarea.setText(temp);
				in.close();
				opensource=temp;
				direct=filedialog.getDirectory()+filedialog.getFile();
				canceltext=textarea.getText();//用于撤销
			}
        }catch(Exception e){
        	System.out.println("Read error:"+e);
        	JOptionPane.showMessageDialog(this,"读入错误","警告",JOptionPane.WARNING_MESSAGE);
        }
	}
	public void dsave(){
		if(direct==""){
			this.save();
		}
		else if(direct!="null" && direct!="nullnull"){
			try{
				OutputStreamWriter out=new OutputStreamWriter(new FileOutputStream(direct));
				out.write(textarea.getText());
				out.close();
				opensource=textarea.getText();
			}catch(Exception e){
				System.out.println("Write error:"+e);
				JOptionPane.showMessageDialog(this,"写入错误","警告",JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	public void save(){
		try{
			filedialog=new FileDialog(this,"保存",FileDialog.SAVE);
			filedialog.setVisible(true);
			if(filedialog.getDirectory()!=null && filedialog.getFile()!=null){
				OutputStreamWriter out=new OutputStreamWriter(new FileOutputStream(filedialog.getDirectory()+filedialog.getFile()));
				out.write(textarea.getText());
				out.close();
				opensource=textarea.getText();
				direct=filedialog.getDirectory()+filedialog.getFile();
			}
		}catch(Exception e){
			System.out.println("Write error:"+e);
			JOptionPane.showMessageDialog(this,"写入错误","警告",JOptionPane.WARNING_MESSAGE);
		}
	}
	public void quit(){
		if(!havesave){
			enterquit=true;
			dialog.setVisible(true);
		}
		else{
			System.exit(0);
		}
	}
	public void judge(){//判断是否保存
		if(textarea.getText().equals(opensource)){
			havesave=true;
		}
		else{
			havesave=false;
		}
	}
	public void font(){//字体格式
		try{
			size=Integer.parseInt(fontsizetext.getText());
			if(size<=0 || size>99){
				size=18;
				throw new Exception("字体大小范围为1~99,字体将还原为默认值");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(this,"字体大小错误","警告",JOptionPane.WARNING_MESSAGE);
		}
		if(fontpara.getSelectedItem()=="一般"){
			font=new Font(texttype,Font.PLAIN,size);
		}
		else if(fontpara.getSelectedItem()=="粗体"){
			font=new Font(texttype,Font.BOLD,size);
		}
		else if(fontpara.getSelectedItem()=="斜体"){
			font=new Font(texttype,Font.ITALIC,size);
		}
		else if(fontpara.getSelectedItem()=="粗斜体"){
			font=new Font(texttype,Font.BOLD+Font.ITALIC,size);
		}
		else{}
	}
	public void colorchoose(){//字体颜色
		fontcolor=JColorChooser.showDialog(this,"字体颜色选择",textarea.getForeground());
		textarea.setForeground(fontcolor);
	}
	public void backchoose(){//背景颜色
		backcolor=JColorChooser.showDialog(this,"字体颜色选择",textarea.getBackground());
		textarea.setBackground(backcolor);
	}
	public void about(){//关于
		JOptionPane.showMessageDialog(this,"\t写字板\n\t写字板 FOR JAVA,如果有我发给你的文件那么密码就是123456，你也可以自己另外保存一个其他密码的。#滑稽#魏华奎","关于",JOptionPane.PLAIN_MESSAGE);
	}
	public void time(){//当前时间
		nowtime=new Date();
		canceltext=textarea.getText();//用于撤销
		textarea.replaceRange(nowtime+"",textarea.getSelectionStart(),textarea.getSelectionEnd());
	}
	public void keysave(){//加密保存
		try{
			FileDialog filedialog=new FileDialog(this,"加密保存",FileDialog.SAVE);
			filedialog.setVisible(true);
			text=new text();
			text.textmain=textarea.getText();
			text.keyword="";
			keydialog.setVisible(true);
			this.keyset();
			this.secret(savemode1,savemode2);
			if(filedialog.getDirectory()!=null && filedialog.getFile()!=null){
				ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filedialog.getDirectory()+filedialog.getFile()));
				out.writeObject(text);
				out.close();
				direct=filedialog.getDirectory()+filedialog.getFile();
			}
		}catch(Exception e){
			System.out.println("Write error:"+e);
			JOptionPane.showMessageDialog(this,"加密出错","警告",JOptionPane.WARNING_MESSAGE);
		}
	}
	public void keyopen(){//加密打开
		try{
			FileDialog filedialog=new FileDialog(this,"打开",FileDialog.LOAD);
			filedialog.setVisible(true);
			if(filedialog.getDirectory()!=null && filedialog.getFile()!=null){
				ObjectInputStream in=new ObjectInputStream(new FileInputStream(filedialog.getDirectory()+filedialog.getFile()));
				text=(text)in.readObject();
				in.close();
				this.breaksecret(savemode1,savemode2);
				keydialog.setVisible(true);
				this.keyjudge(keyentertext.getText(),text.keyword);
				textarea.setText(text.textmain);
				canceltext=textarea.getText();//用于撤销
				direct=filedialog.getDirectory()+filedialog.getFile();
			}
		}catch(Exception e){
			System.out.println("Read error:"+e);
			JOptionPane.showMessageDialog(this,"解码错误","警告",JOptionPane.WARNING_MESSAGE);
		}
	}
	public void secret(char a,char b){//加密
		char main[]=text.textmain.toCharArray();
		char key[]=text.keyword.toCharArray();
		for(int i=0;i<main.length;i++){
			main[i]=(char)(main[i]^a);
		}
		for(int i=0;i<key.length;i++){ 
			key[i]=(char)(key[i]^b);
		}
		text.textmain=new String(main);
		text.keyword=new String(key);
	}
	public void breaksecret(char a,char b){//解码
		char main[]=text.textmain.toCharArray();
		char key[]=text.keyword.toCharArray();
		for(int i=0;i<main.length;i++){
			main[i]=(char)(main[i]^a);
		}
		for(int i=0;i<key.length;i++){ 
			key[i]=(char)(key[i]^b);
		}
		text.textmain=new String(main);
		text.keyword=new String(key);
	}
	public void copy(){
		String selection=textarea.getSelectedText();
		if (selection==null){}
		else{
			StringSelection clipString=new StringSelection(selection);
			clip.setContents(clipString,clipString);
		}
	}
	public void initcopy(){//初始化入剪贴版
		String selection="";
		StringSelection clipString=new StringSelection(selection);
		clip.setContents(clipString,clipString);
	}
	public void paste(){
		Transferable clipdata=clip.getContents(NoteBOOK.this);
		try{
			canceltext=textarea.getText();//用于撤销
			String temp=(String)clipdata.getTransferData(DataFlavor.stringFlavor);
			textarea.replaceRange(temp,textarea.getSelectionStart(),textarea.getSelectionEnd());
		}catch(Exception e){}
	}
	public void cut(){
		String selection=textarea.getSelectedText();
		if (selection==null){}
		else{
			canceltext=textarea.getText();//用于撤销
			StringSelection clipString=new StringSelection(selection);
			clip.setContents(clipString,clipString);
			textarea.replaceRange("",textarea.getSelectionStart(),textarea.getSelectionEnd());
		}
	}
	public void delete(){
		canceltext=textarea.getText();//用于撤销
		textarea.replaceRange("",textarea.getSelectionStart(),textarea.getSelectionEnd());
	}
	public void selectall(){
		textarea.selectAll();
	}
	public void keyset(){//密码设置
        text.keyword=keyentertext.getText();
        keyentertext.setText("");
	}
	public void keyjudge(String a,String b){
		if(a.equals(b)){
		}
		else{
			this.secret(savemode1,savemode2);
			JOptionPane.showMessageDialog(this,"密码错误","警告",JOptionPane.WARNING_MESSAGE);
		}
	}
	public void zcancel(){
		String temp=textarea.getText();
		textarea.setText(canceltext);
		canceltext=temp;
	}
	public void search(){
		String needsearch=searchtext.getText();
		String main=textarea.getText();
		String temp;
		if(needsearch.equals("")){
			JOptionPane.showMessageDialog(this,"关键字为空！","警告",JOptionPane.WARNING_MESSAGE);
		}
		else if(needsearch.length()>main.length()){
			JOptionPane.showMessageDialog(this,"没有找到关键字","提示",JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			int position=textarea.getSelectionEnd()-needsearch.length()+1;
			if(position>=main.length()-needsearch.length() ||position<0){
				position=0;
			}
			for(;position<=main.length()-needsearch.length();position++){
				temp=main.substring(position,position+needsearch.length());
				if(temp.equals(needsearch)){
					textarea.setSelectionStart(position);
					textarea.setSelectionEnd(position+needsearch.length());
					break;
				}
				else if(position>=main.length()-needsearch.length()){
					textarea.setSelectionStart(0);
					textarea.setSelectionEnd(0);
					JOptionPane.showMessageDialog(this,"没有找到关键字","提示",JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
		}
	}
	public void change(){
		String changeword=changetext.getText();
		if(textarea.getSelectionStart()!=textarea.getSelectionEnd()){
			textarea.replaceRange(changeword,textarea.getSelectionStart(),textarea.getSelectionEnd());
		}
		else if(textarea.getSelectionStart()==textarea.getSelectionEnd()){
			JOptionPane.showMessageDialog(this,"先搜索再替换","警告",JOptionPane.WARNING_MESSAGE);
		}
	}
	public void changeall(){
		String needsearch=searchtext.getText();
		String changeword=changetext.getText();
		String main=textarea.getText();
		String temp;
		for(int i=0;i<=main.length()-needsearch.length();i++){
			temp=main.substring(i,i+needsearch.length());
			if(temp.equals(needsearch)){
				textarea.setSelectionStart(i);
				textarea.setSelectionEnd(i+needsearch.length());
				textarea.replaceRange(changeword,textarea.getSelectionStart(),textarea.getSelectionEnd());
				main=textarea.getText();
			}
		}
	}
	public void autoline(){
		if(!textarea.getLineWrap()){
			textarea.setLineWrap(true);
			autoline.setLabel("取消自动换行");
		}
		else if(textarea.getLineWrap()){
			textarea.setLineWrap(false);
			autoline.setLabel("自动换行");
		}
	}
	public static void main(String[] args) {
		NoteBOOK SlNotepad=new NoteBOOK("写字板");
		SlNotepad.show();
	}
}
