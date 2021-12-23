package Oving6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class GraphMain {
    public static void main(String[] args) throws IOException {
        UnweightedDirectedGraph graph;
        FileReader file = new FileReader("./nodeinput.txt");
        BufferedReader br = new BufferedReader(file);
        graph = new UnweightedDirectedGraph(br);


        graph.bfs(0);
        System.out.println("Distances from startnode " + 0 + " ");
        for (int i = 0; i < graph.nodes-1; i++) {
            System.out.println("to:    prev:    distance:");
            System.out.println(graph.bfsStringDist(0, i));
        }


        UnweightedDirectedGraph graph2;
        FileReader file2 = new FileReader("./nodeinputsort.txt");
        BufferedReader br2 = new BufferedReader(file2);
        graph2 = new UnweightedDirectedGraph(br2);
        System.out.println("\nGraph2\nTopological sort order:\n" + Arrays.toString(graph2.topologicalSort()));


        br.close();
        br2.close();
    }
}
