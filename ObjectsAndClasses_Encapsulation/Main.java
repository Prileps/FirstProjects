package ObjectsAndClasses_Encapsulation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Elevator elevator = new Elevator(-3, 26);
        while (true) {
            System.out.print("Введите номер этажа: ");
            int floor = new Scanner(System.in).nextInt();
            elevator.move(floor);
        }

//        ObjectsAndClasses_Encapsulation.Dimensions dimensions1 = new ObjectsAndClasses_Encapsulation.Dimensions(3, 4, 5);
//
//        ObjectsAndClasses_Encapsulation.Goods goods = new ObjectsAndClasses_Encapsulation.Goods(
//                dimensions1,
//                3.4,
//                "Москва",
//                true,
//                "erg5r",
//                false
//        );
//
//        System.out.println(goods);
//
//        ObjectsAndClasses_Encapsulation.Dimensions dimensions2 = new ObjectsAndClasses_Encapsulation.Dimensions(10, 20, 30);
//
//        ObjectsAndClasses_Encapsulation.Goods otherGoods = new ObjectsAndClasses_Encapsulation.Goods(
//                dimensions2,
//                70.9,
//                "London",
//                true,
//                "ert6j",
//                false
//        );
//
//
//        System.out.println("\n" + otherGoods);
    }
}
