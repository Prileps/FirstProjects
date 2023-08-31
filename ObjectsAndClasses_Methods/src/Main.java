public class Main {

    public static void main(String[] args) {
        Basket basketVova = new Basket();
        basketVova.add("Bottle of water", 40, 2, 1);
        basketVova.add("Chocolate", 50, 4, 1);
        basketVova.print("Vova");

        Basket basketPetya = new Basket();
        basketPetya.add("eggs", 100, 10, 10);
        basketPetya.print("Petya");

        System.out.println();
        System.out.println("Средняя цена товара во всех корзинах");
        System.out.println(Basket.getAveragePriceByProduct());
        System.out.println();
        System.out.println("Средняя стоимость корзины");
        System.out.println(Basket.getAveragePriceByBasket());
    }
}
