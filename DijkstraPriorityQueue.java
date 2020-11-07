import java.util.*;

class Node implements Comparable<Node>{
    int vertex, distance;

    public Node(int vertex, int distance){
        this.vertex  = vertex;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        return distance - o.distance;
    }
}

public class DijkstraPriorityQueue {
	static final int inf = 1000;
    static int vertexNum;
    static int[] d;
    static int[] path;
    static int[][] distanceTable = {
    		{0,inf,6,3,inf},
    		{3,0,inf,inf,inf},
    		{inf,inf,0,2,inf},
    		{inf,1,1,0,inf},
    		{inf,4,inf,2,0}
    };
    
    public static void dijkstra(int start, int end){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[vertexNum];
        Stack st = new Stack();
        queue.add(new Node(start, 0));
        d[start] = 0;
        
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            int cur = curNode.vertex;
            
            if(check[cur] == true) continue;
            check[cur] = true;
            
            for(int i = 0; i < vertexNum; i++){
                if(d[i] > d[cur] + distanceTable[cur][i]){
                    d[i] = d[cur] + distanceTable[cur][i];
                    queue.add(new Node(i, d[i]));//vertex number, distance
                    path[i]= cur;
                }
            }       
        }
        
        int p= path[end];
        st.push(end);
        while(true) {
        	if(start==p) {
        		st.push(start);
        		break;
        	}
        	else {
        		st.push(p);
        		p=path[p];
        	}
        }
        System.out.println("length is "+d[end]);
        int s = st.size();
        for(int i=0; i<s; i++)
        {
        	if(i==0)
        		System.out.print(st.pop());
        	else
        		System.out.print("->"+st.pop());
        }
     }

    public static void main(String[] args){
 
    	vertexNum = 5;
        d = new int[vertexNum];
        path = new int[vertexNum];
        for(int i = 0; i < vertexNum; i++){
            d[i] = inf;
        }
        
        dijkstra(1,2);
    }

    
}