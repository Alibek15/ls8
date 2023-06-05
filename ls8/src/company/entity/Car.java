package company.entity;

public class Car {

    private Integer id;

    private String name;

    private double price;

    private double engineVolume;

    public Car(final Integer id, final String name, final double price, final double engineVolume) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.engineVolume = engineVolume;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", engineVolume=" + engineVolume +
                '}';
    }
}
