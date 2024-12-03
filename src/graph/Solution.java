package graph;

import java.util.*;

class GraphTraversal {
    private int count;
    private LinkedList<Integer>[] vertexList;

    @SuppressWarnings("unchecked")
    public GraphTraversal(int n) {
        count = n;
        vertexList = new LinkedList[n];

        for (int i = 0; i < n; i++)
            vertexList[i] = new LinkedList<>();
    }

    public void addEdge(int a, int b) {
        vertexList[a].add(b);
        vertexList[b].add(a);
    }

    public void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        boolean[] isVisit = new boolean[count];

        isVisit[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            result.add(v);

            for (int n : vertexList[v]) {
                if (!isVisit[n]) {
                    isVisit[n] = true;
                    queue.add(n);
                }
            }
        }

        for (int r : result)
            System.out.print(r + " ");

        System.out.println();
    }

    public void DFS(int start) {
        boolean[] isVisit = new boolean[count];
        List<Integer> result = new ArrayList<>();
        DFSUtil(start, isVisit, result);

        for (int v : result)
            System.out.print(v + " ");

        System.out.println();
    }

    private void DFSUtil(int v, boolean[] isVisit, List<Integer> result) {
        isVisit[v] = true;
        result.add(v);

        for (int n : vertexList[v]) {
            if (!isVisit[n])
                DFSUtil(n, isVisit, result);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int v = scanner.nextInt();
        int n = scanner.nextInt();

        GraphTraversal graph = new GraphTraversal(v);

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            graph.addEdge(a, b);
        }

        int start = scanner.nextInt();

        graph.DFS(start);
        graph.BFS(start);

        scanner.close();
    }
}
