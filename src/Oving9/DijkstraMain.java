package Oving9;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DijkstraMain {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("");
        InputStream inputStream1 = new FileInputStream("");
        InputStream inputStream2 = new FileInputStream("");
        MapData mapData = new MapData();
        mapData.nodeInput(inputStream);
        System.out.println("Nodes read");
        mapData.edgeInput(inputStream1);
        System.out.println("Vertexes read");
        mapData.readInterestPoint(inputStream2);
        System.out.println("Interest points added");

        long start;
        long end;

        /*
        System.out.println("\nDijkstra stjoerdal to Meraaker");
        start = System.nanoTime();
        mapData.dijkstraWithEnd(6579983, 1693246);
        end = System.nanoTime();
        System.out.println((end - start)/1000000000 + " seconds used");
        mapData.printTime(1693246);
        mapData.nodesInShortestPath(1693246);
        mapData.writeMapData(1693246, "DijkstrasMapStjordal-Meroker.txt");
*/
//        System.out.println("\nDijk Malvik");
//        start = System.nanoTime();
//        mapData.dijkstraWithEnd(1752175, 6840121);
//        end = System.nanoTime();
//        System.out.println((end - start)/1000000000 + " seconds used");
//        mapData.printTime(6840121);
//        mapData.nodesInShortestPath(6840121);
//        mapData.writeMapData(6840121, "DijkMapMalvik.txt");
        /*
        System.out.println("\nDijkstra Kårvåg–Gjemnes");
        start = System.nanoTime();
        mapData.dijkstraWithEnd(6368906, 6789998);
        end = System.nanoTime();
        System.out.println((end - start)/1000000000 + " seconds used");
        mapData.printTime(6789998);
        mapData.nodesInShortestPath(6789998);
        mapData.writeMapData(6789998, "DijkstraMapKårvåg–Gjemnes.txt");
*/

        /*
        System.out.println("\nDijkstra Oslo-Trd");
        start = System.nanoTime();
        mapData.dijkstraWithEnd(2518118, 6861306);
        end = System.nanoTime();
        System.out.println((end - start)/1000000000 + " seconds used");
        mapData.printTime(6861306);
        mapData.nodesInShortestPath(6861306);
        mapData.writeMapData(6861306, "DijkstraMaOslo-Trd.txt");
*/

        /**/
        System.out.println("\nDijkstra Tampere–Trondheim");
        start = System.nanoTime();
        mapData.dijkstraWithEnd(  136963, 6861306);
        end = System.nanoTime();
        System.out.println((end - start)/1000000000 + " seconds used");
        mapData.printTime(6861306);
        mapData.nodesInShortestPath(6861306);
        mapData.writeMapData(6861306, "DijkstraMapTampere–Trondheim.txt");

    }
}
