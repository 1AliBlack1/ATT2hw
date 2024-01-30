package ToyStore;

class Toy {
    private int toyId;
    private String name;
    private int quantity;
    private int weight;

    public Toy(int toyId, String name, int quantity, int weight) {
        this.toyId = toyId;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int getToyId() {
        return toyId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getWeight() {
        return weight;
    }

    public void decreaseQuantity() {
        quantity--;
    }

    public void setWeight(int newWeight) {
    }
}