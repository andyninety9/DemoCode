import java.util.ArrayList;
import java.util.List;

public class QuadTree {
    public final int MAX_CHILD = 4;
    int level = 0;
    List<Node> nodes;
    QuadTree northWest = null;
    QuadTree northEast = null;
    QuadTree southWest = null;
    QuadTree southEast = null;

    public Boundry boundry;

    public QuadTree(int level, Boundry boundry) {
        this.level = level;
        this.boundry = boundry;
        nodes = new ArrayList<Node>();
    }

    public void split(){
        int xOffset = this.boundry.getxMin() + (this.boundry.getxMax() - this.boundry.getxMin() / 2);
        int yOffset = this.boundry.getyMin()
                + (this.boundry.getyMax() - this.boundry.getyMin()) / 2;

        this.northWest = new QuadTree(this.level + 1, new Boundry(this.boundry.getxMin(),
                this.boundry.getyMin(), xOffset, yOffset));
        this.northEast = new QuadTree(this.level + 1, new Boundry(xOffset, this.boundry.getyMin(),
                xOffset, yOffset));
        this.southWest = new QuadTree(this.level + 1, new Boundry(
                this.boundry.getxMin(), xOffset, xOffset,
                this.boundry.getyMax()));
        this. southEast = new QuadTree(this.level + 1, new Boundry(xOffset, yOffset,
                this.boundry.getxMax(), this.boundry.getyMax()));
    }

    public void insert(int x, int y, City data){
        if(!this.boundry.inRange(x, y)){
            return;
        }
        Node newNode = new Node(x, y, data);
        if(nodes.size() < MAX_CHILD){
            nodes.add(newNode);
            return;
        }

        if(this.northEast == null){
            split();
        }
        if (this.northWest.boundry.inRange(x, y))
            this.northWest.insert(x, y, data);
        else if (this.northEast.boundry.inRange(x, y))
            this.northEast.insert(x, y, data);
        else if (this.southWest.boundry.inRange(x, y))
            this.southWest.insert(x, y, data);
        else if (this.southEast.boundry.inRange(x, y))
            this.southEast.insert(x, y, data);
        else
            System.out.printf("ERROR : Unhandled partition %d %d", x, y);
    }

    public static void dfs(QuadTree tree) {
        if (tree == null)
            return;

        System.out.printf("\nLevel = %d [X1=%d Y1=%d] \t[X2=%d Y2=%d] ",
                tree.level, tree.boundry.getxMin(), tree.boundry.getyMin(),
                tree.boundry.getxMax(), tree.boundry.getyMax());

        for (Node node : tree.nodes) {
            System.out.printf(" \n\t  x=%d y=%d", node.x, node.y);
        }
        if (tree.nodes.isEmpty()) {
            System.out.printf(" \n\t  Leaf Node.");
        }
        dfs(tree.northWest);
        dfs(tree.northEast);
        dfs(tree.southWest);
        dfs(tree.southEast);

    }
}
