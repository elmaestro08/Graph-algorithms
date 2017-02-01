import java.util.Scanner;
public class Topological {
	int vertices,edges;
	int graph[][],indegree[],visited[];
	
	

	public Topological() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter total no of vertices : ");
		vertices=sc.nextInt();
		graph=new int [vertices][vertices];
		indegree=new int [vertices];
		visited=new int [vertices];
		
		for(int i=0;i<vertices;i++){	//Initialization of graph
			for(int j=0;j<vertices;j++){
				graph[i][j]=0;
			}
			indegree[i]=0;
			visited[i]=0;
		}
	}

	void create(){
		System.out.println("Enter total no of Edges : ");
		Scanner sc=new Scanner(System.in);
		edges=sc.nextInt();
		
		System.out.println("Enter source and destination vertex ");
		
		for(int i=0;i<edges;i++){
			System.out.println(++i+".");
			--i;
			System.out.println("Source vertex : "); 
			int u=sc.nextInt();
			System.out.println("Destination vertex : ");
			int v=sc.nextInt();
			graph[u][v]=1;
		}
	}
	
	
	int cal_indegree(int ver){
		int count=0;
		for(int i=0;i<vertices;i++){
			if(graph[i][ver]==1)
				count++;
		}
		return count;
	}
	
	void topological_sorting(){
		int j;
		for(int i=0;i<vertices;i++){
			indegree[i]=cal_indegree(i);
		}
		
		System.out.println("Result of Topological sorting is : ");
		for(int i=0;i<vertices;i++){
			j=0;
			while(j<vertices){
				if(visited[j]==0 && indegree[j]==0){
					visited[j]=1;
					System.out.print(j+" ");
					for(int k=0;k<vertices;k++){
						if(graph[j][k]!=0)
							indegree[k]--;
					}
					break;
				}
				j++;
			}
			if(j==vertices){
				System.out.println("Graph has a cycle");
				break;
			}
				
		}
	}
	

	public static void main(String[] args) {
		Topological topo=new Topological();
		topo.create();
		topo.topological_sorting();

	}

}

