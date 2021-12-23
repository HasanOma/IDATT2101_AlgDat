package Oving6;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class UnweightedDirectedGraph {
    public static class Edge{
        int to, from;

        public Edge(int from, int to) {
            this.to = to;
            this.from = from;
        }
    }

    private int n,k;
    int nodes = 0;
    private Integer[] prev;
    private List<List<Edge>> graphTable;
    private Stack<Integer> stack = new Stack<>();

    public UnweightedDirectedGraph(BufferedReader br) throws IOException {
        createGraph(br);
    }

    public void createGraph(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        graphTable = new ArrayList<>(n);
        nodes++;

        for (int i = 0; i < this.n; i++){
            graphTable.add(new ArrayList<>());
            nodes++;
        }
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            addEdge(from, to);
        }
    }

    public void bfs(int start) {
        prev = new Integer[n];
        boolean[] visited = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Edge> edgeList = graphTable.get(node);

            for (Edge edge : edgeList) {
                if (!visited[edge.to]) {
                    visited[edge.to] = true;
                    prev[edge.to] = node;
                    queue.offer(edge.to);
                    stack.add(edge.to);
                }

            }
        }
    }

    public void addEdge(int vertexFrom, int vertexTo){
        graphTable.get(vertexFrom).add(new Edge(vertexFrom , vertexTo));
    }

    public String bfsStringDist(int startNode, int endNode){
        bfs(startNode);
        List<Integer> list = new ArrayList<>();
        for (Integer i = prev[endNode]; i != null ; i = prev[i]) {
            list.add(i);
        }
        int integer = -2;
        if (list.isEmpty()){
            integer = -1;
        }
        if (list.size() >= 1){
            integer = list.get(0);
        }
        return endNode +"        " + integer +
                "         " + list.size();
    }

    public int[] topologicalSort(){
        boolean[] visited = new boolean[n];
        int[] order = new int[n];
        int i1 = n-1;

        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                i1 = dfs(i1, i, visited, order);
            }
        }
        return order;
    }

    public int dfs( int number, int index, boolean[] visited, int [] order){
        visited[index] = true;
        List<Edge> edgeList = graphTable.get(index);

        if (edgeList != null) {
            for (Edge edge : edgeList) {
                if (!visited[edge.to]) {
                    number = dfs(number, edge.to, visited, order);
                }
            }
        }
        order[number] = index;
        return number-1;
    }
}
