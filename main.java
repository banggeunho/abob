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
		int cnt=0;
		String cur_loc = null; // 현재 위치
		String des_loc = null; // 목적 위치
		String store_loc = null; // 가게 위치
		String temp;
		floydwarshall floyd = new floydwarshall();
		//locationToIndex lti = new locationToIndex();
		//DB jdbc = new DB();
		//GUI GUI = new GUI();

		GUI frame = new GUI();			
		frame.setVisible(true);
	}


}


