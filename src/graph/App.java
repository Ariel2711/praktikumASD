package graph;

import java.util.*;

class Graph {
    private int count;
    private LinkedList<Integer>[] vertexList;

    @SuppressWarnings("unchecked")
    public Graph(int n) {
        count = n;
        vertexList = new LinkedList[n];
        for (int i = 0; i < n; i++)
            vertexList[i] = new LinkedList<>();
    }

    public void addEdge(int a, int b) {
        vertexList[a].add(b);
    }

    public List<Integer> BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        boolean[] isVisit = new boolean[count];

        isVisit[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            result.add(v);

            List<Integer> neighbors = new ArrayList<>(vertexList[v]);
            Collections.sort(neighbors);

            for (int n : neighbors)
                if (!isVisit[n]) {
                    isVisit[n] = true;
                    queue.add(n);
                }
        }
        return result;
    }

    public List<Integer> DFS(int start) {
        boolean[] isVisit = new boolean[count];
        List<Integer> result = new ArrayList<>();
        DFSUtil(start, isVisit, result);
        return result;
    }

    private void DFSUtil(int v, boolean[] isVisit, List<Integer> result) {
        isVisit[v] = true;
        result.add(v);

        List<Integer> neighbors = new ArrayList<>(vertexList[v]);
        Collections.sort(neighbors);

        for (int n : neighbors)
            if (!isVisit[n])
                DFSUtil(n, isVisit, result);
    }

    public int startToEnd(int start, int end, List<Integer> listVertex) {
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < listVertex.size(); i++) {
            if (listVertex.get(i) == start)
                startIndex = i;

            if (listVertex.get(i) == end)
                endIndex = i;
        }

        int result = 0;
        result = startIndex - endIndex;
        result = result < 0 ? (result * -1) : result;
        return result;
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int vertexCount = scanner.nextInt();
        int edges = scanner.nextInt();
        int root = scanner.nextInt();

        Graph graph = new Graph(vertexCount);

        for (int i = 0; i < edges; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.addEdge(a, b);
        }

        List<Integer> dfsPath = graph.DFS(root);
        System.out.print("DFS traversal: ");
        for (int v : dfsPath)
            System.out.print(v + " ");
        System.out.println();

        List<Integer> bfsPath = graph.BFS(root);
        System.out.print("BFS traversal: ");
        for (int v : bfsPath)
            System.out.print(v + " ");
        System.out.println();

        if (graph.startToEnd(start, end, dfsPath) <= graph.startToEnd(start, end, bfsPath))
            System.out.println("DFS adalah jalur terpendek");
        else
            System.out.println("BFS adalah jalur terpendek");

        scanner.close();
    }
}
