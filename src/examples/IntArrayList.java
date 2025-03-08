package examples.lists;

import utils.ArrayList;

public class IntArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        // Adding elements
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(1, 15); 

        System.out.println("ArrayList contents: ");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();

        numbers.remove(2);
        System.out.println("After removing index 2: ");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();

        System.out.println("Size of list: " + numbers.size());
    
        System.out.println("Contains 20? " + numbers.contains(20));
        System.out.println("Contains 50? " + numbers.contains(50));
    }
}