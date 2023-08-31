public class Basket {

    private static int countBaskets = 0;
    private static int priceForAll = 0;
    private static int countProducts = 0;
    private String items = "";
    private int totalPrice = 0;
    private double totalWeight  = 0; //вес в кг
    private int limit;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getCountBaskets() {
        return countBaskets;
    }

    public static void increaseCount(int count) {
        Basket.countBaskets = Basket.countBaskets + count;
    }

    public static void increasePriceForAll(int priceForAll) {
        Basket.priceForAll = Basket.priceForAll + priceForAll;
    }

    public static void increaseCountAll(int countAll) {
        Basket.countProducts = Basket.countProducts + countAll;
    }

    public void add(String name, int price) {
        add(name, price, 1, 0);
    }

    public void add(String name, int price, int count) {
        add(name, price, count, 0);
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occurred :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + "шт. " + weight + "кг - " + price + "руб/шт";
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + weight;
        increaseCountAll(count);
        increasePriceForAll(price * count);
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public static int getPriceForAll() {
        return priceForAll;
    }
    public static int getCountProducts() {
        return countProducts;
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }

    public static int getAveragePriceByProduct() {
        return (priceForAll / countProducts);
    }

    public static int getAveragePriceByBasket() {
        return (priceForAll / countBaskets);
    }

}
