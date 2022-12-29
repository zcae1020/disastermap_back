package disastermap.dmap.domain;

public class LatLng {
    private double x, y;

    public LatLng(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "LatLng{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
