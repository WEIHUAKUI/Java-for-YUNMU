import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.datatransfer.*;
class text implements Serializable{
	String keyword;//����
	String textmain;//�ı�����
}
public class NoteBOOK extends JFrame implements ActionListener,ListSelectionListener{
	MenuBar menusBar;//�˵���
	MenuItem open,keep,save,newfile,exit_out,about,text_font,colorchoose,backchoose,timeadd,keyopen,keysave,zcancel,copy,paste,cut,delete,selectall,search,autoline;
	Menu file,edit,format,help;//�˵�����
	MenuShortcut opencut,dsavecut,savecut,newworkcut,quitcut,aboutcut,fontchoosecut,colorchoosecut,backchoosecut,timeaddcut,keyopencut,keysavecut,zcancelcut,copycut,pastecut,cutcut,deletecut,selectallcut,searchcut,autolinecut;
	Toolkit tool=this.getToolkit();
	Clipboard clip;//������
	Image image=tool.getImage("data/icon.jpg");//���ͼ��
	JTextArea textarea;//�ı�����
	JDialog dialog,fontdialog,keydialog,searchdialog;//���Ƿ�
	JList fontlist;//���嵥
	Choice fontpara;//�����б
	JTextField fontsizetext;//�����С����
	JTextField searchtext;//��������
	JTextField changetext;//�滻����
	TextField keyentertext;//��������
	JScrollPane listscroll,textscroll;
	JPanel fontbuttonpanel,fontmainpanel,fontsizepanel,searchpanel,searchbuttonpanel,searchtextpanel,changepanel,changetextpanel,changebuttonpanel;
	GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
	String fontname[]=ge.getAvailableFontFamilyNames();//�����
	boolean havesave=true;//�Ƿ��Ѵ�
	boolean enterquit=false;//�����ж��Ի���֮ǰ�Ƿ��˳�
	JButton yes,no,cancel,ok,can,keyok,searchok,searchcancel,changeok,changeall;//�Ի���ť
	JLabel tip,fonttype,fontsize,searchtip,changetip;//��ʾ
	FileDialog filedialog;//��������Ի���
	text text;//�洢����
	String opensource="";//�����ж��Ƿ��ѱ���
	String texttype="����";//����
	String direct="";//����·��
	String canceltext="";//��������
	int size=18;//�����С
	int para=0;//�����б
	Font font=new Font(texttype,Font.PLAIN,size);
	Color fontcolor=Color.black;//������ɫ
	Color backcolor=Color.white;//������ɫ
	Date nowtime;//����ʱ��
	char savemode1='s';
	char savemode2='t';//���ܱ��淽ʽ
	public NoteBOOK(String title){
		this.setIconImage(image);//ͼ��
		setTitle(title);//����
		this.setResizable(true);//��С�ɵ�
		this.setBackground(Color.cyan);
		this.setBounds(new Rectangle(150,100,800,550));//���ڴ�С
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.out.println("����ر�");
				System.exit(0);
				}
            public void windowOpened(WindowEvent e){
            	System.out.println("�����");
            	}
            });//����رռ���
            clip=getToolkit().getSystemClipboard();//��ü�����
            this.initcopy();//��ʼ��Ϊ��
            textarea=new JTextArea();
            textarea.setLineWrap(false);
            textarea.setFont(font);
            textarea.setForeground(Color.black);
            textarea.setBackground(Color.white);
            textscroll=new JScrollPane(textarea);
            this.add(textscroll);
            //�ı���
//------------------------------------------------
            searchdialog=new JDialog(this,"����/��Q",false);
            searchdialog.setResizable(false);
            searchdialog.setLayout(new BorderLayout());
            searchdialog.setSize(250,230);
            searchok=new JButton("������һ��");
            searchcancel=new JButton("ȡ������");
            searchtext=new JTextField("",10);
            searchtip=new JLabel("�����ؼ��֣�");
            searchpanel=new JPanel();
            searchpanel.setBorder(BorderFactory.createTitledBorder("����"));//�ӱ߿�
            searchpanel.setLayout(new BoxLayout(searchpanel, BoxLayout.Y_AXIS));//���µ�
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
            searchcancel.addActionListener(this);   //�����Ի���(����)
           
            changetext=new JTextField("",10);
            changetip=new JLabel("�滻Ϊ��  ");
            changeok=new JButton("�滻");
            changeall=new JButton("ȫ���滻");
            changepanel=new JPanel();
            changepanel.setBorder(BorderFactory.createTitledBorder("�滻"));//�ӱ߿�
            changepanel.setLayout(new BoxLayout(changepanel, BoxLayout.Y_AXIS));//���µ�
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
            changeall.addActionListener(this);     //�����Ի���(�滻)
           
            keyentertext=new TextField("",8);
            keyentertext.setEchoChar('*');
            keyok=new JButton("�������");
            keydialog=new JDialog(this,"��������",true);
            keydialog.setResizable(false);
            keydialog.setLayout(new FlowLayout());
            keydialog.setSize(250,80);
            keydialog.add(keyentertext);
            keydialog.add(keyok);
            keyok.addActionListener(this);          //����Ի���
            
            yes=new JButton("��");
            no=new JButton("��");
            cancel=new JButton("ȡ��");
            tip=new JLabel("�ļ��������Ѿ��Ķ���Ҫ�����ļ���");
            dialog=new JDialog(this,"д�ְ�",true);
            dialog.setResizable(false);
            dialog.setLayout(new FlowLayout());
            dialog.setSize(250,100);
            dialog.add(tip);
            dialog.add(yes);
            dialog.add(no);
            dialog.add(cancel);
            yes.addActionListener(this);
            no.addActionListener(this);
            cancel.addActionListener(this);          //������ʾ�Ի���

            ok=new JButton("ȷ��");
            can=new JButton("ȡ��");
            fontpara=new Choice();
            fontpara.add("һ��");
            fontpara.add("����");
            fontpara.add("б��");
            fontpara.add("��б��");
            fonttype=new JLabel("����ѡ��");
            fontsize=new JLabel("�����Сѡ��");
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
            fontdialog=new JDialog(this,"����Ի���",true);
            fontdialog.setResizable(false);
            fontdialog.setLayout(new BorderLayout());
            fontdialog.setSize(440,200);
            fontdialog.add(fontmainpanel,BorderLayout.WEST);
            fontdialog.add(fontbuttonpanel,BorderLayout.SOUTH);
            fontdialog.add(fontsizepanel,BorderLayout.EAST);
            fontlist.addListSelectionListener(this);
            ok.addActionListener(this);
            can.addActionListener(this);                    //����Ի���
//-------------------------------------------------------
            menusBar=new MenuBar();
            file=new Menu("�ļ�");
            edit=new Menu("�༭");
            format=new Menu("��ʽ");
            help=new Menu("����");
            newfile=new MenuItem("�½�");
            open=new MenuItem("��");
            keep=new MenuItem("����");
            save=new MenuItem("���Ϊ");
            exit_out=new MenuItem("�˳�");
            zcancel=new MenuItem("����");
            copy=new MenuItem("����");
            paste=new MenuItem("ճ��");
            cut=new MenuItem("����");
            delete=new MenuItem("ɾ��");
            selectall=new MenuItem("ȫѡ");
            search=new MenuItem("����/��Q");
            timeadd=new MenuItem("ʱ��/����");
            autoline=new MenuItem("�Զ�����");
            text_font=new MenuItem("�����ʽ...");
            colorchoose=new MenuItem("������ɫ...");
            backchoose=new MenuItem("������ɫ...");
            about=new MenuItem("����");
            keyopen=new MenuItem("��������ļ�");
            keysave=new MenuItem("���ܱ���Ϊ");

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
            about.addActionListener(this);      //�˵���
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
			canceltext=textarea.getText();//���ڳ���
			}		
		opensource=textarea.getText();
	}
	public void open(){
		if(!havesave){
			dialog.setVisible(true);
		}try{
			filedialog=new FileDialog(this,"��",FileDialog.LOAD);
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
				canceltext=textarea.getText();//���ڳ���
			}
        }catch(Exception e){
        	System.out.println("Read error:"+e);
        	JOptionPane.showMessageDialog(this,"�������","����",JOptionPane.WARNING_MESSAGE);
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
				JOptionPane.showMessageDialog(this,"д�����","����",JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	public void save(){
		try{
			filedialog=new FileDialog(this,"����",FileDialog.SAVE);
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
			JOptionPane.showMessageDialog(this,"д�����","����",JOptionPane.WARNING_MESSAGE);
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
	public void judge(){//�ж��Ƿ񱣴�
		if(textarea.getText().equals(opensource)){
			havesave=true;
		}
		else{
			havesave=false;
		}
	}
	public void font(){//�����ʽ
		try{
			size=Integer.parseInt(fontsizetext.getText());
			if(size<=0 || size>99){
				size=18;
				throw new Exception("�����С��ΧΪ1~99,���彫��ԭΪĬ��ֵ");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(this,"�����С����","����",JOptionPane.WARNING_MESSAGE);
		}
		if(fontpara.getSelectedItem()=="һ��"){
			font=new Font(texttype,Font.PLAIN,size);
		}
		else if(fontpara.getSelectedItem()=="����"){
			font=new Font(texttype,Font.BOLD,size);
		}
		else if(fontpara.getSelectedItem()=="б��"){
			font=new Font(texttype,Font.ITALIC,size);
		}
		else if(fontpara.getSelectedItem()=="��б��"){
			font=new Font(texttype,Font.BOLD+Font.ITALIC,size);
		}
		else{}
	}
	public void colorchoose(){//������ɫ
		fontcolor=JColorChooser.showDialog(this,"������ɫѡ��",textarea.getForeground());
		textarea.setForeground(fontcolor);
	}
	public void backchoose(){//������ɫ
		backcolor=JColorChooser.showDialog(this,"������ɫѡ��",textarea.getBackground());
		textarea.setBackground(backcolor);
	}
	public void about(){//����
		JOptionPane.showMessageDialog(this,"\tд�ְ�\n\tд�ְ� FOR JAVA,������ҷ�������ļ���ô�������123456����Ҳ�����Լ����Ᵽ��һ����������ġ�#����#κ����","����",JOptionPane.PLAIN_MESSAGE);
	}
	public void time(){//��ǰʱ��
		nowtime=new Date();
		canceltext=textarea.getText();//���ڳ���
		textarea.replaceRange(nowtime+"",textarea.getSelectionStart(),textarea.getSelectionEnd());
	}
	public void keysave(){//���ܱ���
		try{
			FileDialog filedialog=new FileDialog(this,"���ܱ���",FileDialog.SAVE);
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
			JOptionPane.showMessageDialog(this,"���ܳ���","����",JOptionPane.WARNING_MESSAGE);
		}
	}
	public void keyopen(){//���ܴ�
		try{
			FileDialog filedialog=new FileDialog(this,"��",FileDialog.LOAD);
			filedialog.setVisible(true);
			if(filedialog.getDirectory()!=null && filedialog.getFile()!=null){
				ObjectInputStream in=new ObjectInputStream(new FileInputStream(filedialog.getDirectory()+filedialog.getFile()));
				text=(text)in.readObject();
				in.close();
				this.breaksecret(savemode1,savemode2);
				keydialog.setVisible(true);
				this.keyjudge(keyentertext.getText(),text.keyword);
				textarea.setText(text.textmain);
				canceltext=textarea.getText();//���ڳ���
				direct=filedialog.getDirectory()+filedialog.getFile();
			}
		}catch(Exception e){
			System.out.println("Read error:"+e);
			JOptionPane.showMessageDialog(this,"�������","����",JOptionPane.WARNING_MESSAGE);
		}
	}
	public void secret(char a,char b){//����
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
	public void breaksecret(char a,char b){//����
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
	public void initcopy(){//��ʼ���������
		String selection="";
		StringSelection clipString=new StringSelection(selection);
		clip.setContents(clipString,clipString);
	}
	public void paste(){
		Transferable clipdata=clip.getContents(NoteBOOK.this);
		try{
			canceltext=textarea.getText();//���ڳ���
			String temp=(String)clipdata.getTransferData(DataFlavor.stringFlavor);
			textarea.replaceRange(temp,textarea.getSelectionStart(),textarea.getSelectionEnd());
		}catch(Exception e){}
	}
	public void cut(){
		String selection=textarea.getSelectedText();
		if (selection==null){}
		else{
			canceltext=textarea.getText();//���ڳ���
			StringSelection clipString=new StringSelection(selection);
			clip.setContents(clipString,clipString);
			textarea.replaceRange("",textarea.getSelectionStart(),textarea.getSelectionEnd());
		}
	}
	public void delete(){
		canceltext=textarea.getText();//���ڳ���
		textarea.replaceRange("",textarea.getSelectionStart(),textarea.getSelectionEnd());
	}
	public void selectall(){
		textarea.selectAll();
	}
	public void keyset(){//��������
        text.keyword=keyentertext.getText();
        keyentertext.setText("");
	}
	public void keyjudge(String a,String b){
		if(a.equals(b)){
		}
		else{
			this.secret(savemode1,savemode2);
			JOptionPane.showMessageDialog(this,"�������","����",JOptionPane.WARNING_MESSAGE);
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
			JOptionPane.showMessageDialog(this,"�ؼ���Ϊ�գ�","����",JOptionPane.WARNING_MESSAGE);
		}
		else if(needsearch.length()>main.length()){
			JOptionPane.showMessageDialog(this,"û���ҵ��ؼ���","��ʾ",JOptionPane.INFORMATION_MESSAGE);
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
					JOptionPane.showMessageDialog(this,"û���ҵ��ؼ���","��ʾ",JOptionPane.INFORMATION_MESSAGE);
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
			JOptionPane.showMessageDialog(this,"���������滻","����",JOptionPane.WARNING_MESSAGE);
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
			autoline.setLabel("ȡ���Զ�����");
		}
		else if(textarea.getLineWrap()){
			textarea.setLineWrap(false);
			autoline.setLabel("�Զ�����");
		}
	}
	public static void main(String[] args) {
		NoteBOOK SlNotepad=new NoteBOOK("д�ְ�");
		SlNotepad.show();
	}
}
