package nw;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class test implements ActionListener{
	JFrame f;
	JMenuBar mb;
	JMenu file,edit;
	JMenuItem cut, copy, paste, selectAll;
	JTextArea ta;
	JMenuItem i_save,i_load;
	
	test(){
		f=new JFrame("춘현 메모장");
		cut = new JMenuItem("잘라내기");
		copy = new JMenuItem("복사");
		paste = new JMenuItem("붙여넣기");
		selectAll = new JMenuItem("모두선택");
		i_save = new JMenuItem("저장");
		i_load = new JMenuItem("불러오기");
		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		selectAll.addActionListener(this);
		i_save.addActionListener(this);
		i_load.addActionListener(this);
		
		mb = new JMenuBar();
		file = new JMenu("파일");
		edit = new JMenu("편집");
		
		edit.add(cut);edit.add(copy);edit.add(paste);edit.add(selectAll);
		mb.add(file); mb.add(edit);
		file.add(i_save); file.add(i_load);
		ta = new JTextArea();
		ta.setBounds(5,5,360,320);
		f.add(mb); f.add(ta);
		f.setJMenuBar(mb);
		f.setLayout(null);
		f.setSize(400,400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}


public void actionPerformed(ActionEvent e) {
	if(e.getSource()==cut)
		ta.cut();
	
	if(e.getSource()==paste)
		ta.paste();;
	
	if(e.getSource()==copy)
		ta.copy();
	
	if(e.getSource()==selectAll)
		ta.selectAll();
	
	if(e.getSource()==i_save) {
		FileDialog fd = new FileDialog(f, "저장", FileDialog.SAVE);
		fd.setVisible(true);
		
		String path = fd.getDirectory() + fd.getFile();
		if(fd.getFile()==null) return;
		try {
			FileWriter fw = new FileWriter(path);
			String s = ta.getText();
			fw.write(s);
			fw.close();
		}catch(Exception e1) {
			e1.getStackTrace();
		}
	}
	if(e.getSource()==i_load) {
		FileDialog fd = new FileDialog(f, "불러오기", FileDialog.LOAD);
		fd.setVisible(true);
		String path = fd.getDirectory() + fd.getFile();
		String s="";
		if(fd.getFile() == null)return;
		try {
			FileReader fr = new FileReader(path);
			int k;
			while(true) {
				k = fr.read();
				if(k==-1)break;
				s+= (char)k;
			}
			fr.close();
		}catch(Exception e2){
			System.out.println("오류"+e2);
		}
		ta.setText(s);
	}
}

 public static void main(String[] args) {		
 new test();
 }
}



