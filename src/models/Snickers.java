package models;

public class Snickers {
    private Long id;
    private String nameType; //разновидность батончика
    private double weight;
    private String barcode; //штрих-код
    private int price;
    private int count; //кол-во каждого типа продукта в базе
    public Snickers(){}
    public Snickers(Long id, String nameType, double weight, String barcode, int count, int price) {
        this.id = id;
        this.nameType = nameType;
        this.weight = weight;
        this.barcode = barcode;
        this.count = count;
        this.price = price;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNameType() {
        return nameType;
    }
    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public String getBarcode() {
        return barcode;
    }
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public String toString() {
        return "\n\nSnickers:" +
                "Id: " + id +
                "\nNameType: " + nameType +
                "\nWeight: " + weight +
                "\nBarcode: " + barcode +
                "\nPrice: " + price +
                "\nCount: " + count ;
    }
}
