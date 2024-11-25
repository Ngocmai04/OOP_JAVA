public class AIMS {
    public static void main(String[] args) {
        // Create an empty cart
        Cart anOrder = new Cart();

        // Add DVDs to the cart
        DigitalVdDisc dvd1 = new DigitalVdDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVdDisc dvd2 = new DigitalVdDisc("Star Wars", "Science Fiction", "George Lucas", 120, 24.95f); // Fixed typo "Geogre"
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVdDisc dvd3 = new DigitalVdDisc("Aladdin", "Animation", 18.99f); 
        anOrder.addDigitalVideoDisc(dvd3);

        // Print cart contents
        System.out.println("Cart contents:");
        anOrder.print();
       
        // Remove a DVD
        System.out.println("\nRemoving 'Aladdin'..."); 
        anOrder.removeDigitalVideoDisc(dvd3);

        // Print cart contents after removal
        System.out.println("\nCart contents after removal:");
       

        // Calculate and print total cost
        System.out.printf("\nTotal cost is: %.2f\n", anOrder.totalCost()); 
    }
}