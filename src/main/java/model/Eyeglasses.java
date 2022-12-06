package model;

public class Eyeglasses {
    private String id;
    private String name;
    private double price;
    private int quantity;

    private String url;

    public Eyeglasses() {
    }

    public Eyeglasses(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity++;
    }

    public Eyeglasses(String name, double price, int quantity, String url) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.url = url;
    }

    public Eyeglasses(String id, String name, double price, int quantity, String url) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
