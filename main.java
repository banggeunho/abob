import java.util.*;
import java.io.*;
public class main {

	public static void main(String[] args) {
		// Variable
		Scanner scan = new Scanner(System.in);
		int a_time = 0; //남는 시간
		int[] c_r_time = new int[5];
		int[] r_d_time = new int[5];
		int[] m_time = new int[5]; //이동하는데 총 걸리는 시간
		int cur_index = 0;
		int des_index = 0;
		String cur_loc = null; // 현재 위치
		String des_loc = null; // 목적 위치
		String store_loc = null; // 가게 위치
		String temp;
		floydwarshall floyd = new floydwarshall();
		locationToIndex lti = new locationToIndex();
		DB jdbc = new DB();
		
		System.out.println("남는 시간 입력: ");
		a_time=scan.nextInt();
		temp = scan.nextLine();
		
		System.out.println("현재 위치 입력: ");
		cur_loc = scan.nextLine();
		
		System.out.println("목적지 입력: ");
		des_loc = scan.nextLine();
		
		temp = lti.Convert(cur_loc, des_loc);		
		cur_index = Integer.parseInt(temp.substring(0, temp.indexOf(",")));
		des_index = Integer.parseInt(temp.substring(temp.indexOf(",")+1));
		//System.out.println(cur_index+"     "+des_index);
		
		for(int i=0;i<5;i++) {// <식당> 0:가천관, 1:비전타워(학식), 2:비전타워(학식)
									//, 3:교육대학(학식), 4:예술대학(학식)
		c_r_time[i] = floyd.distance(cur_index, i*2+1);
		r_d_time[i] = floyd.distance( i*2+1, des_index);
		m_time[i] = c_r_time[i] + r_d_time[i];
		if(jdbc.DB(a_time, m_time[i],i*2+1))
		System.out.println("<최소이동시간>\n"+"현재~식당 : "+ c_r_time[i]+"\n식당~목적지: "+r_d_time[i]);
		}
		

								
	}


}


