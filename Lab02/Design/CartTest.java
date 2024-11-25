

public class CartTest {
    public static void main (String[] args){
        Cart cart= new Cart();

        DigitalVdDisc dvd1= new DigitalVdDisc("The Lion King","Animation","Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVdDisc dvd2= new DigitalVdDisc("Star Wars","Science Fiction","George Lacas",87, 25.95f);
        cart. addDigitalVideoDisc(dvd2);

        DigitalVdDisc dvd3 =new DigitalVdDisc("Aladin","Animation",18.99f);
        cart.addDigitalVideoDisc(dvd3);

        cart.print();
        }
}
