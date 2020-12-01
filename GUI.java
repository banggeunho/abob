

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.border.Border;
import javax.swing.ListSelectionModel; 

public class GUI extends JFrame implements ActionListener {
	static String[][]  menu_list;
	String[] columnNames = { "번호","메뉴", "위치" , "비용", "식사가능시간" };
	private JPanel contentPane;
	private JPanel panel_1;
	private JTextField a_time;
	private JTextField cur_loc;
	private JTextField des_loc;
	JTable table=new JTable();
	List list;
	JTextPane txtpnDetail;
	
	int cur_index;
	int des_index;
	int str_index;
	private JScrollPane scroll;


	@SuppressWarnings("rawtypes")
	public GUI() {

		setTitle("Abob Project v4.2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 342);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(85, 107, 47));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();//왼쪽 패널
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBackground(new Color(85, 107, 47));
		panel.setBounds(12, 10, 188, 283);
		contentPane.add(panel);
		panel.setLayout(null);
		
		a_time = new JTextField();
		a_time.setText("30");
		a_time.setBounds(22, 86, 128, 21);
		panel.add(a_time);
		a_time.setColumns(10);		
		
		cur_loc = new JTextField();
		cur_loc.setText("IT\uB300\uD559");
		cur_loc.setColumns(10);
		cur_loc.setBounds(22, 133, 128, 21);
		panel.add(cur_loc);
		
		des_loc = new JTextField();
		des_loc.setText("\uAC00\uCC9C\uAD00");
		des_loc.setColumns(10);
		des_loc.setBounds(22, 178, 128, 21);
		panel.add(des_loc);
		
		JButton btnNewButton = new JButton("Show Bob");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("배달의민족 주아", Font.PLAIN, 16));
		btnNewButton.setBorder(UIManager.getBorder("CheckBox.border"));
		btnNewButton.setBackground(new Color(128, 128, 0));
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp;
				locationToIndex lti = new locationToIndex();
				menu_list = new String[40][6]; //버튼 누를때마다 array 초기화
				DB jdbc = new DB();
				int cnt=0;
				txtpnDetail.setText("Detail..");
				
				int[] c_r_time = new int[5];
				int[] r_d_time = new int[5];
				int[] m_time = new int[5]; 
				temp = lti.Convert(cur_loc.getText(), des_loc.getText());		
				cur_index = Integer.parseInt(temp.substring(0, temp.indexOf(",")));
				des_index = Integer.parseInt(temp.substring(temp.indexOf(",")+1));
				for(int i=0;i<5;i++) {// <식당> 0:가천관, 1:비전타워(학식), 2:비전타워(학식)
					//, 3:교육대학(학식), 4:예술대학(학식)
					c_r_time[i] = floydwarshall.distance(cur_index, i*2+1);
					r_d_time[i] = floydwarshall.distance( i*2+1, des_index);
					m_time[i] = c_r_time[i] + r_d_time[i];
					try {
						if(jdbc.DB(Integer.parseInt(a_time.getText()), m_time[i], i*2+1)) {
							cnt++;
						}	
					}
					catch(NumberFormatException | NullPointerException e1) {
						JOptionPane.showMessageDialog(null,"숫자를 입력해주세요!","알림",JOptionPane.PLAIN_MESSAGE);
						cnt=-1;
						break;
					}
				}
				if(cnt>0) {
					DefaultTableModel dtm = new DefaultTableModel();
					for(int i =0;i<columnNames.length;i++) {
						dtm.addColumn(columnNames[i]);
					}
					for(int i=0; i<menu_list.length; i++) {
						if(menu_list[i][0] != null)
							dtm.addRow(menu_list[i]);
						else break;
					}					
					table.setModel(dtm);
					DB.menu_cnt=0;
				}
				else if(cnt!=-1){
					JOptionPane.showMessageDialog(null,"식사시간이 부족합니다!.(ㅠㅠ)","알림",JOptionPane.PLAIN_MESSAGE);
					}
				}
		});
		btnNewButton.setBounds(12, 229, 164, 44);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Free Time (\uBD84)");
		lblNewLabel.setFont(new Font("배달의민족 주아", Font.PLAIN, 13));
		lblNewLabel.setBounds(12, 68, 138, 15);
		panel.add(lblNewLabel);
		
		JLabel lblCurrentLocation = new JLabel("Current Location");
		lblCurrentLocation.setFont(new Font("배달의민족 주아", Font.PLAIN, 13));
		lblCurrentLocation.setBounds(12, 113, 109, 15);
		panel.add(lblCurrentLocation);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("배달의민족 주아", Font.PLAIN, 13));
		lblDestination.setBounds(12, 160, 96, 15);
		panel.add(lblDestination);
		
		JLabel lblproject = new JLabel("\uC544\uBC25Project");
		lblproject.setBackground(new Color(85, 107, 47));
		lblproject.setFont(new Font("배달의민족 주아", Font.PLAIN, 22));
		lblproject.setHorizontalTextPosition(SwingConstants.CENTER);
		lblproject.setHorizontalAlignment(SwingConstants.CENTER);
		lblproject.setBounds(12, 10, 164, 48);
		panel.add(lblproject);
		
		panel_1 = new JPanel();//오른쪽 큰 패널
		panel_1.setAutoscrolls(true);
		panel_1.setLayout(null);
		panel_1.setPreferredSize (new Dimension (200,600));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_1.setBackground(new Color(85, 107, 47));
		panel_1.setBounds(212, 10, 381, 283);
		contentPane.add(panel_1);
		
		list = new List();
		list.setVisible(false);
		
		list.setForeground(Color.GRAY);
		table.setEditingRow(1);
		table.setEditingColumn(1);
		table.setVerifyInputWhenFocusTarget(false);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("배달의민족 주아", Font.PLAIN, 13));
		table.setFillsViewportHeight(true);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
					JTable target = (JTable)e.getSource();
					System.out.println(target.getSelectedRow());
			    	str_index = Integer.parseInt(menu_list[target.getSelectedRow()][5]);
			    	StringBuilder rs = new StringBuilder();
			    	int time = floydwarshall.distance(cur_index, str_index) + floydwarshall.distance(str_index, des_index);
			    	rs.append("<최단경로>  총 "+time+"분 소요\n");
					floydwarshall.printPath(cur_index, str_index);
					if(str_index != cur_index)
					rs.append(floydwarshall.getPath() +"["+floydwarshall.distance(cur_index, str_index)+"분 소요]\n");
					floydwarshall.printPath(str_index, des_index);
					if(str_index != des_index)
					rs.append(floydwarshall.getPath() +"["+floydwarshall.distance(str_index, des_index)+"분 소요]\n");
			    	txtpnDetail.setText(rs.toString());
			}
		});
		table.setPreferredScrollableViewportSize(new Dimension(200, 400));
		table.setAutoCreateRowSorter(true);
		table.setBounds(8, 39, 361, 156);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		scroll = new JScrollPane(table);
		scroll.setAutoscrolls(true);
		//scroll.setViewportView(table);
		scroll.setBounds(10, 39, 359, 156);
		panel_1.add(scroll);		
		//panel_1.add(table);		
		
		
		
		list.setBounds(363, 0, 18, 23);//y축 조절, 콤보박스 삽입
		panel_1.add(list);
		list.setFont(new Font("배달의민족 주아", Font.PLAIN, 14));
		
	/*	//라디오버튼 추가
		JRadioButton priceRB = new JRadioButton("가격순");
		JRadioButton timeRB = new JRadioButton("시간순");
		ButtonGroup group = new ButtonGroup();
		group.add(priceRB);
		group.add(timeRB);
		panel_1.add(priceRB);
		panel_1.add(timeRB);
		priceRB.setFont(new Font("배달의민족 주아", Font.PLAIN, 17));	
		timeRB.setFont(new Font("배달의민족 주아", Font.PLAIN, 17));	
		priceRB.setBounds(209,18,80,15);
		timeRB.setBounds(289,18,80,15);
		priceRB.setBackground(new Color(85, 107, 47));
		timeRB.setBackground(new Color(85, 107, 47));
		
		priceRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int size = list.getItemCount();
				String getlist[] = new String[size];
				String temp[] = new String[size];
				String intStr;
				int price[][] = new int[size][2];
				for(int i=0; i<	list.getItemCount(); i++) {
					getlist[i]= list.getItem(i);
					temp=getlist[i].split("//");
					intStr= temp[2].replaceAll("[^\\d]", "");
					price[i][0] = Integer.parseInt(intStr);
					price[i][1] = i;
				}
				Arrays.sort(price,Comparator.comparing(o1-> o1[0]));
				list.setVisible(false);
				
				for(int i=0; i<size;i++)
				{
					list.add(list.getItem(price[i][1]),size+1);
				}
				for(int i=size-1; i>=0; i--)
				{
					list.remove(i);
				}
				list.setVisible(true);
			}
		});
		
		timeRB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int size = list.getItemCount();
				String getlist[] = new String[size];
				String temp[] = new String[size];
				String intStr;
				int time[][] = new int[size][2];
				for(int i=0; i<	list.getItemCount(); i++) {
					getlist[i]= list.getItem(i);
					temp=getlist[i].split("//");
					intStr= temp[3].replaceAll("[^\\d]", "");
					time[i][0] = Integer.parseInt(intStr);
					time[i][1] = i;
				}
				Arrays.sort(time,Comparator.comparing(o1-> o1[0]));
				list.setVisible(false);
				
				for(int i=0; i<size;i++)
				{
					list.add(list.getItem(time[i][1]),size+1);
				}
				for(int i=size-1; i>=0; i--)
				{
					list.remove(i);
				}
				list.setVisible(true);
			}
		});*/

		
		
		
		//식사가능한 메뉴
		JLabel lblNewLabel_1 = new JLabel("Bob List");
		lblNewLabel_1.setBounds(10, 10, 347, 23);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));		
		
		txtpnDetail = new JTextPane();
		txtpnDetail.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txtpnDetail.setFont(new Font("배달의민족 주아", Font.PLAIN, 13));
		txtpnDetail.setForeground(new Color(0, 0, 0));
		txtpnDetail.setBackground(new Color(85, 107, 47));
		txtpnDetail.setText("Detail..");
		txtpnDetail.setBounds(10, 201, 361, 72);
		panel_1.add(txtpnDetail);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public Border getScrollViewportBorder() {
		return scroll.getViewportBorder();
	}
	public void setScrollViewportBorder(Border viewportBorder) {
		scroll.setViewportBorder(viewportBorder);
	}
	}