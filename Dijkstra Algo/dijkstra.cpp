//
==================================================================================
//NAME:Saurabh Birari
//==================================================================================
#include <iostream>
using namespace std;

class graph{
	int vertices=0;
	int **adj;
public:
	graph(){
		cout<<"Enter total no of lanes ";
		cin>>vertices;
	}
	int read_G();
	void path(int);
	void path_rep_ver(int);
};

int graph::read_G(){
	adj = new int*[vertices];
	for(int i = 0; i < vertices; ++i) {
	    adj[i] = new int[vertices];
	}

	for(int i=0;i<vertices;i++)
		for(int j=0;j<vertices;j++)
			adj[i][j]=999;

	for(int r=0;r<vertices;r++)
	{

		for(int c=r+1;c<vertices;c++)
		{   
cout<<"enter distance between lane "<<r+1<<" and "<<c+1<<" : ";
			cin>>adj[r][c];
			adj[c][r]=adj[r][c];	// Creates cost matrix
		}
	}

return 0;
}

void graph::path(int start){
	int visited[vertices],min,count=1,i,distance=0,temp=0;
	for(i=0;i<vertices;i++){
		visited[i]=0;
	}
	cout<<"Visits lane :"<<start+1;
	visited[start]=1;
	while(count!=vertices) {
		min=adj[start][start];
		for(i=0;i<vertices;i++)
			if(min>adj[start][i] && !visited[i]){
				min=adj[start][i];
				temp=i;
			}

		visited[temp]=1;
		count++;
		cout<<" --> "<<temp+1;
		distance=distance+min;
		start=temp;

	}
	cout<<endl<<"Total minimum distance traveled :"<<distance;
}

int main() {
	int start;
	graph g;
	g.read_G();
	cout<<"Enter the starting point (Starting lane):";
	cin>>start;
	g.path(--start);
	return 0;
}




