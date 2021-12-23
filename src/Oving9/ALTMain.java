package Oving9;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ALTMain {
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

        InputStream inputStream3 = new FileInputStream("");
        InputStream inputStream4 = new FileInputStream("");
        mapData.readPreProcessedFileFromLandmark(inputStream3);
        mapData.readPreProcessedFileToLandmark(inputStream4);
        System.out.println("Preprocessed files read");

        long start;
        long end;

        /*
        System.out.println("\nALT Stjørdal to Meråker");
        start = System.nanoTime();
        mapData.ALT(1693246, 6579983);
        end = System.nanoTime();
        System.out.println((end - start)/1000000000 + " seconds used");
        mapData.printTime(6579983);
        mapData.nodesInShortestPath(6579983);
        mapData.writeMapData(6579983, "ALTMapStjørdal-Meråker.txt");
*/

        /*
        System.out.println("\nALT Kårvåg–Gjemnes");
        start = System.nanoTime();
        mapData.ALT(6368906, 6789998);
        end = System.nanoTime();
        System.out.println((end - start)/1000000000 + " seconds used");
        mapData.printTime(6789998);
        mapData.nodesInShortestPath(6789998);
        mapData.writeMapData(6789998, "ALTMapKårvåg–Gjemnes.txt");
*/


        /*
        System.out.println("\nALT Oslo–Trondheim");
        start = System.nanoTime();
        mapData.ALT(  2518118, 6861306);
        end = System.nanoTime();
        System.out.println((end - start)/1000000000 + " seconds used");
        mapData.printTime(6861306);
        mapData.nodesInShortestPath(6861306);
        mapData.writeMapData(6861306, "ALTMapOslo–Trondheim.txt");
*/

        /**/
        System.out.println("\nALT Tampere–Trondheim");
        start = System.nanoTime();
        mapData.ALT(  136963, 6861306);
        end = System.nanoTime();
        System.out.println((end - start)/1000000000 + " seconds used");
        mapData.printTime(6861306);
        mapData.nodesInShortestPath(6861306);
        mapData.writeMapData(6861306, "ALTMapTampere–Trondheim.txt");

    }
}
