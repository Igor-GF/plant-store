package repository;

import model.Plant;
import model.Product;
import model.Toebehoren;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductRepository {
    private static final ArrayList<Product> producten = new ArrayList<>();

    public void setRepository() {
        List<Plant> planten = new PlantRepository().getAllePlanten();
        List<Toebehoren> toebehorenLijst = new ToebehorenRepository().getAlleToebehoren();
        List<Product> lijst = new ArrayList<>();

        lijst.addAll(planten);
        lijst.addAll(toebehorenLijst);

        lijst.stream()
            .sorted(Comparator.comparingInt(Product::getArtCode))
            .forEach(producten::add);
    }

    public Product getProduct(int artCode) {
        if (producten.size() == 0) setRepository();

        return producten.stream()
                .filter(p -> p.getArtCode() == artCode)
                .findFirst()
                .orElse(null);
    }
}
