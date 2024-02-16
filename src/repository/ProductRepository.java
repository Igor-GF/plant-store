package repository;

import excepition.WaardeNietGevondenException;
import model.Plant;
import model.Product;
import model.Toebehoren;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductRepository {
    private static final ArrayList<Product> producten = new ArrayList<>();

    { setRepository(); }

    public void setRepository() {
        List<Plant> planten = new PlantRepository().getAll();
        List<Toebehoren> toebehorenLijst = new ToebehorenRepository().getAll();
        List<Product> lijst = new ArrayList<>();

        lijst.addAll(planten);
        lijst.addAll(toebehorenLijst);

        lijst.stream()
            .sorted(Comparator.comparingInt(Product::getArtCode))
            .forEach(producten::add);
    }

    public Product getProduct(int artCode) throws WaardeNietGevondenException {
        if (producten.size() == 0) setRepository();

        if (producten.stream().noneMatch(p -> p.getArtCode() == artCode)) {
            throw new WaardeNietGevondenException("Er is GEEN product met Art. code " + artCode + ". ");
        }

        return producten.stream()
                .filter(p -> p.getArtCode() == artCode)
                .findFirst()
                .orElse(null);
    }
}
