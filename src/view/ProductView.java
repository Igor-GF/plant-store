package view;

import enums.SoortProduct;
import model.Product;
import repository.ProductRepository;

public class ProductView {
    private static final ProductRepository repo = new ProductRepository();
    public static void toonProduct(int artCode) {
        Product productUitRepo = repo.getProduct(artCode);

        if (productUitRepo.getProduct().equals(SoortProduct.PLANT)) {
            PlantView.toonPlant(artCode);
        }

        if (productUitRepo.getProduct().equals(SoortProduct.TOEBEHOREN)) {
            ToebehorenView.toonToebeheren(artCode);
        }

        if (productUitRepo == null) {
            System.out.println("ART. CODE " + artCode + " IS NIET GEVONDEN.");
        }

//        else {
//            System.out.println();
//            toonHoofding();
//            System.out.printf(
//                    "\n%1$-8d  %2$-12s  %5$-12d  %2$-12s",
//                    productUitRepo.getArtCode(),
//                    productUitRepo.getKleur(),
//                    productUitRepo.getPrijs(),
//                    productUitRepo.getProduct()
//            );
//        }
    }

//    private static void toonHoofding() {
//        System.out.printf(
//                "%1$-8d  %2$-12s  %5$-12d  %2$-12s",
//                "ARTCODE", "KLEUR", "PRIJS", "PRODUCT"
//        );
//        System.out.printf(
//                "\n%1$-8d  %2$-12s  %5$-12d  %2$-12s",
//                "-------", "-------", "-------", "-------");
//    }
}
