public class Main {
    public static void main(String[] args) {
        QuadTree map = new QuadTree(1, new Boundry(0,0, 600, 600));

        City chicago = new City("Chicago", "CHI", 234.0, "2.7M");
        City milwaukee = new City("Milwaukee", "MIL", 96.0, "590K");
        City detroit = new City("Detroit", "DET", 142.9, "670K");
        City seattle = new City("Seattle", "SEA", 142.5, "3.8M");
        City vancouver = new City("Vancouver", "VAN", 114.9, "675K");
        City anchorage = new City("Anchorage", "ANC", 1960.0, "291K");

        map.insert(300, 300, chicago); // Tọa độ Chicago
        map.insert(310, 290, milwaukee); // Tọa độ Milwaukee
        map.insert(420, 300, detroit); // Tọa độ Detroit
        map.insert(100, 500, seattle); // Tọa độ Seattle
        map.insert(100, 550, vancouver); // Tọa độ Vancouver
        map.insert(100, 580, anchorage); // Tọa độ Anchorage

        QuadTree.dfs(map);
    }
}

