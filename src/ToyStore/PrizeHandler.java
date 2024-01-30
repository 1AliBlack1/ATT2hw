package ToyStore;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

interface PrizeHandler {
    void handlePrize(Toy prizeToy);
}