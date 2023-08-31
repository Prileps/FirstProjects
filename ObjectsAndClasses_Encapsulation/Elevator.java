package ObjectsAndClasses_Encapsulation;

import javax.swing.plaf.IconUIResource;

public class Elevator {
    int currentFloor = 1;
    int minFloor;
    int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown() {
            currentFloor = currentFloor - 1;
    }

    public void moveUp() {
            currentFloor = currentFloor + 1;
    }

    public void move(int floor) {
        if (floor <= maxFloor && floor >= minFloor) {
            if (currentFloor > floor) {
                while (currentFloor != floor) {
                    System.out.println(currentFloor);
                    moveDown();
                }
            }
            if (currentFloor < floor) {
                while (currentFloor != floor) {
                    System.out.println(currentFloor);
                    moveUp();
                }
            }
        } else {
            System.out.println("Выбранного этажа нет в здании, введите верный этаж:");
        }
    }
}
