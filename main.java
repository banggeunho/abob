import java.util.*;
import java.io.*;
public class main {

	public static void main(String[] args) {
		// Variable
		Scanner scan = new Scanner(System.in);
		int a_time = 0; //남는 시간
		int t_time = 0; //총 걸리는 시간
		String cur_loc = null; // 현재 위치
		String des_loc = null; // 목적 위치
		String store_loc = null; // 가게 위치
		
		a_time=scan.nextInt();
		//
		//floyd warshall 사용 후 db한테 시간 넘겨서 출력하는 것....
		// 최소 경로 추가....
		
		DB jdbc = new DB();
		jdbc.DB(a_time);
	}
}
