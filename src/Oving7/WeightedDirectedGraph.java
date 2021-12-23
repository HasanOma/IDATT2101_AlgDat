package Oving7;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WeightedDirectedGraph {
    public class Edge {
        int to, from;
        int eFlow;
        Edge parallel;
        final int capacity;

        public Edge(int to, int from, int weight) {
            this.to = to;
            this.from = from;
            this.capacity = weight;
        }

        public boolean parallel(){
            return capacity == 0;
        }

        public int getCapacity(){
            return capacity - eFlow;
        }

        public void changeFlow(int bottleneck){
            eFlow += bottleneck;
            parallel.eFlow -= bottleneck;
        }

    }

    private int n, k;
    private List<List<Edge>> graphTable;

    public WeightedDirectedGraph(BufferedReader br) throws IOException {
        createGraph(br);
    }

    public void createGraph(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        graphTable = new ArrayList<>(n);

        for (int i = 0; i < this.n; i++) {
            graphTable.add(new ArrayList<>());
        }
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            addEdge(from, to, weight);
        }
    }

    public void addEdge(int vertexFrom, int vertexTo, int weight) {
        if (vertexFrom <= n) {
            Edge edge1 = new Edge(vertexTo, vertexFrom, weight);
            Edge edge2 = new Edge(vertexFrom, vertexTo, 0);
            graphTable.get(vertexFrom).add(edge1);
            graphTable.get(vertexTo).add(edge2);
            edge1.parallel = edge2;
            edge2.parallel = edge1;
        }
    }

    public int bfs(int start, int sink) {
        boolean[] visited = new boolean[n];
        Integer[] prevNode = new Integer[n];
        int j = 0;
        Queue<Integer> q = new ArrayDeque<>(n);
        visited[start] = true;
        q.offer(start);

        Edge[] prevEdge = new Edge[n];
        while (!q.isEmpty()) {
            int node = q.poll();
            if (node == sink) break;

            for (Edge edge : graphTable.get(node)) {
                int cap = edge.getCapacity();
                if (cap > 0 && !visited[edge.to]) {
                    visited[edge.to] = true;
                    prevNode[edge.to] = node;
                    prevEdge[edge.to] = edge;
                    q.offer(edge.to);
                }
            }
        }

        if (prevEdge[sink] == null) return 0;

        int flow = Integer.MAX_VALUE;
        for (Edge edge = prevEdge[sink]; edge != null; edge = prevEdge[edge.from])
            flow = Math.min(flow, edge.getCapacity());

        for (Edge edge = prevEdge[sink]; edge != null; edge = prevEdge[edge.from]) edge.changeFlow(flow);

        String str = "";
        for (int i = sink; i != start; i = prevNode[i]){
            str = i + " " + str + " ";
        }
        System.out.println(flow + "        " + start + " " + str);

        return flow;
    }

    public void edmondKarp(int start, int sink){
        int maxFlow = 0;
        int flow;
        do {
            flow = bfs(start, sink);
            maxFlow += flow;
        } while (flow != 0);
        System.out.println("Max flow " + maxFlow);
    }

    public static void main(String[] args) throws IOException {
        WeightedDirectedGraph graph;
        FileReader file = new FileReader("C:\\Users\\hassa\\NTNU.Data\\2år\\1.sem\\AlgDat\\AlgDat_IDATT2101\\src\\main\\java\\Oving7\\nodeinput.txt");
        BufferedReader br = new BufferedReader(file);
        graph = new WeightedDirectedGraph(br);

        System.out.println("Maksimum flyt graf Oppgave 5 fra start K til sluk S med Edmond Karp: ");
        System.out.println("Økning : Flytøkende vei");
        graph.edmondKarp(6, 7);
    }
}