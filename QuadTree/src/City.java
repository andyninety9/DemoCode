public class City {
    private String name;
    private String code;
    private double area;
    private String population;

    public City() {
    }

    public City(String name, String code, double area, String population) {
        this.name = name;
        this.code = code;
        this.area = area;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", area=" + area +
                ", population='" + population + '\'' +
                '}';
    }
}
