package Oving9;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StationsMain {
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
        System.out.println("\nRøros Charching Stations");
        mapData.stationsToMapData(mapData.dijkstraDistStations(1419364, 4), "RørosChargeStations.txt");//Røros hotell Charging
        System.out.println("\nVærnes Gas Stations");
        mapData.stationsToMapData(mapData.dijkstraDistStations(6590451, 2), "VærnesGasStations.txt");//Værnes Gas
    }
}
