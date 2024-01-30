package ToyStore;

public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        // Пример добавления игрушек
        Toy toy1 = new Toy(1, "Кукла", 10, 20);
        Toy toy2 = new Toy(2, "Машинка", 15, 30);
        Toy toy3 = new Toy(3, "Мяч", 8, 10);

        toyStore.addToy(toy1);
        toyStore.addToy(toy2);
        toyStore.addToy(toy3);

        // Пример изменения веса (частоты выпадения) игрушки
        toyStore.updateWeight(1, 30);

        // Пример розыгрыша и вывод результатов
        Toy prizeToy = toyStore.drawToy();
        if (prizeToy != null) {
            System.out.println("Вы выиграли " + prizeToy.getName() + "!");
            toyStore.handlePrize(prizeToy);
        }
    }
}