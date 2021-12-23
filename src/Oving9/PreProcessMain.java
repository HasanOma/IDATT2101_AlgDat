package Oving9;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PreProcessMain {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("");
        InputStream inputStream1 = new FileInputStream("");
        MapData mapData = new MapData();
        mapData.nodeInput(inputStream);
        System.out.println("Nodes read");
        mapData.edgeInput(inputStream1);
        System.out.println("Vertexes read");

        PreProcess preProcess = new PreProcess(mapData.getNrOfNodes(), mapData.getNodeList());
        preProcess.makeAdjLists();
        preProcess.createFileFrom("PreFileFrom.txt");
        preProcess.createFileTo("PreFileTo.txt");
        System.out.println("Preprocessed files are made");
    }
}
