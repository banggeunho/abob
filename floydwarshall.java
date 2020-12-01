public class floydwarshall {
	/*
	 * 0: IT����
	 * 1: ��õ��(�Ĵ�)
	 * 2: �۷ι�����
	 * 3: ����Ÿ��(�н�)
	 * 4: ��������1
	 * 5: ����Ÿ��(�Ĵ簡)
	 * 6: ��������2
	 * 7: �������п�(�н�)
	 * 8: �߾ӵ�����
	 * 9: ��������1(�н�)
	 * 10: ��������������
	 * 11: ��������2
	 * 12: ���̿��������
	 * 13: ���̿����뿬����
	 * 14: ������
	 * 15: �л�ȸ��
	 * 16: �����
	 * */
	static String location[] = new String[]{"IT대학","가천관(식당)","글로벌센터","비전타워(학식)","공과대학1","비전타워(식당가)",
	                               "공과대학2","교육대학원(학식)","중앙도서관","예술대학1(학식)","전자정보도서관","예술대학2",
	                               "바이오나노대학","바이오나노연구대학","웅지관","학생회관","기숙사"};
	
	static int INF = 1000000;
    static int arr[][] = {{1,INF,2,3,2,5,INF,INF,INF,INF,3,INF,INF,3,INF,INF,INF},        
			{INF,1,INF,5,5,INF,INF,5,INF,INF,5,INF,2,5,3,INF,INF},
			{2,INF,1,INF,2,INF,INF,INF,INF,3,INF,INF,INF,INF,INF,INF,INF},
			{3,5,INF,1,3,2,INF,INF,INF,INF,2,INF,INF,4,INF,INF,INF},
			{2,5,2,3,1,INF,INF,INF,INF,3,4,4,5,INF,INF,INF,INF},
			{5,INF,INF,2,INF,1,INF,INF,INF,INF,INF,INF,INF,2,INF,INF,INF},
			{INF,INF,INF,INF,INF,INF,1,INF,INF,INF,INF,INF,INF,2,3,INF,INF},
			{INF,5,INF,INF,INF,INF,INF,1,8,INF,INF,7,6,INF,INF,INF,INF},        				
			{INF,INF,INF,INF,INF,INF,INF,8,1,INF,INF,INF,INF,INF,INF,5,INF},
			{INF,INF,3,INF,3,INF,INF,INF,INF,1,INF,5,6,INF,INF,INF,INF},
			{3,5,INF,2,4,INF,INF,INF,INF,INF,1,INF,INF,4,INF,INF,INF},
			{INF,INF,INF,INF,4,INF,INF,7,INF,5,INF,1,2,INF,INF,INF,INF},
			{INF,2,INF,INF,5,INF,INF,6,INF,6,INF,2,1,INF,INF,INF,INF},
			{3,5,INF,4,INF,2,2,INF,INF,INF,4,INF,INF,1,4,INF,INF},
			{INF,3,INF,INF,INF,INF,3,INF,INF,INF,INF,INF,INF,4,1,INF,INF},
			{INF,INF,INF,INF,INF,INF,INF,INF,5,INF,INF,INF,INF,INF,INF,1,8},
			{INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,8,1}};
    static int path[][] = new int[17][17];
    static int cost[][] = new int[17][17];
    
	floydwarshall() {
		for(int i =0; i<arr.length;i++)
			for(int j=0; j<arr.length;j++) {
				path[i][j] = 0;
			}
		cost = arr;
		for(int k= 0 ; k < arr.length ; k++){
			for(int i = 0 ; i < arr.length ; i++){
				for(int j = 0 ; j < arr.length ; j++){
					if(cost[i][k]+cost[k][j] < cost[i][j]) {
						cost[i][j] = cost[i][k]+cost[k][j];
						path[i][j]=k;
					}
				}
			}
		}
	}
	private static StringBuilder sb = new StringBuilder();
	
	public static String getPath()
	{
		return sb.toString();
	}
	
	public static void printPath(int start, int dest)
	{	
		if(sb.length()>1) sb.delete(0,sb.length());
		sb.append(location[start]+"-->");
		path(start,dest);
		sb.append(location[dest]);
	}
	
	static void path(int start,int dest) {
		if(path[start][dest]!=0) {
			int path_vertex = path[start][dest];
			path(start, path_vertex);
			sb.append(location[path[start][dest]]+"-->");
			path(path[start][dest],dest);
		}
	}

	static int distance(int start, int dest) {     
		return cost[start][dest];	
	}
}