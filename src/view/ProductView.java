package view;

import enums.SoortProduct;
import excepition.WaardeNietGevondenException;
import model.Product;
import repository.ProductRepository;

public class ProductView {
    private static final ProductRepository repo = new ProductRepository();

    public static void toonProduct(int artCode) throws WaardeNietGevondenException {
        Product productUitRepo = repo.getProduct(artCode);

        if (productUitRepo.getProduct().equals(SoortProduct.PLANT)) {
            PlantView.toonPlant(artCode);
        }

        if (productUitRepo.getProduct().equals(SoortProduct.TOEBEHOREN)) {
            ToebehorenView.toonToebeheren(artCode);
        }
    }
}
