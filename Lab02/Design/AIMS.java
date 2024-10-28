
public class AIMS {
    public static void main(String[] args) {
        //Tạo giỏ hàng trống
        Cart anOrder = new Cart();

        //Thêm đĩa vào giỏ hàng
        DigitalVdDisc dvd1 = new DigitalVdDisc("The Lion King","Animation","Roger Allers",87,19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVdDisc dvd2 = new DigitalVdDisc("Star wars","Science Fiction","Geogre Lucas",87,24.95f);
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVdDisc dvd3 = new DigitalVdDisc("Aladin", "Animation" , 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

       
        anOrder.print();

        anOrder.removeDigitalVideoDisc(dvd2);
        
        System.out.printf("Total cost is: %.2f",anOrder.totalCost());
    }
}