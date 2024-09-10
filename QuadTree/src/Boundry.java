public class Boundry {
    public int xMin, yMin, xMax, yMax;
    public Boundry(int xMin, int yMin, int xMax, int yMax) {
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public int getxMin() {
        return xMin;
    }

    public int getyMin() {
        return yMin;
    }

    public int getxMax() {
        return xMax;
    }

    public int getyMax() {
        return yMax;
    }

    public boolean inRange(int x, int y) {
        return (x >= this.xMin && x <= this.xMax) && (y >= this.yMin && y <= this.yMax);
    }
}
