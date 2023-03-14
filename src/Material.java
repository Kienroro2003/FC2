public class Material {
    private String id;
    private String name;
    private String unitOfMeasurement;
    private int count;
    private long price;

    public Material() {
    }

    public Material(String id, String name, String unitOfMeasurement, int count, long price) {
        this.id = id;
        this.name = name;
        this.unitOfMeasurement = unitOfMeasurement;
        this.count = count;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unitOfMeasurement='" + unitOfMeasurement + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}
