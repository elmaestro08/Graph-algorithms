def BFS(adj,start):
    path = []
    queue = [start]
    visited = [0 for n in range(len(adj))]
    visited[start] = 1
    path.append(start)
    while queue:
        u = queue.pop(0)
        for v in adj[u]:
            if visited[v] == 0:
                queue.append(v)
                visited[v] = 1
                path.append(v)

    else:
        return path


def main():
    adj = [[1,2], [3,4], [5,6], [1], [1], [2],[2]]
    print(BFS(adj,0))

if __name__=='__main__':
    main()