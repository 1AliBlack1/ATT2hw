package ToyStore;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ToyStore implements PrizeHandler {
    private List<Toy> toys = new ArrayList<>();

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateWeight(int toyId, int newWeight) {
        Toy toy = findToyById(toyId);
        if (toy != null) {
            toy.setWeight(newWeight);
        }
    }

    private Toy findToyById(int toyId) {
        for (Toy toy : toys) {
            if (toy.getToyId() == toyId) {
                return toy;
            }
        }
        return null;
    }

    public Toy drawToy() {
        List<Integer> weightedToys = new ArrayList<>();
        for (Toy toy : toys) {
            for (int i = 0; i < toy.getWeight(); i++) {
                weightedToys.add(toy.getToyId());
            }
        }

        if (weightedToys.isEmpty()) {
            System.out.println("В магазине нет игрушек");
            return null;
        }

        int selectedToyId = weightedToys.get(new Random().nextInt(weightedToys.size()));
        Toy prizeToy = findToyById(selectedToyId);

        if (prizeToy != null && prizeToy.getQuantity() > 0) {
            prizeToy.decreaseQuantity();
            return prizeToy;
        } else {
            System.out.println("Извините, данной игрушки больше нет в наличии.");
            return null;
        }
    }

    @Override
    public void handlePrize(Toy prizeToy) {
        try (FileWriter fileWriter = new FileWriter("prizes.txt", true)) {
            fileWriter.write(prizeToy.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}