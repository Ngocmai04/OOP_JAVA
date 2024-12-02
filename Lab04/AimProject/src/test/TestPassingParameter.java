package Lab04.AimProject.src.test;

import Lab04.AimProject.src.aims.media.DigitalVdDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
      DigitalVdDisc jungleDVD=new DigitalVdDisc("Jungle");
        DigitalVdDisc cinderellaDVD=new DigitalVdDisc("Cinderella");
        
        swap(jungleDVD, cinderellaDVD); // chua doi
        System.out.println("jungle DVD title: "+ jungleDVD.get_Title());
        System.out.println("cinderella dvd title: "+ cinderellaDVD.get_Title());

        changeTitle(jungleDVD, cinderellaDVD.get_Title()); // da thay doi
        System.out.println("jungle dvd title: "+ jungleDVD.get_Title());
    }


    public static void swap(DigitalVdDisc o1, DigitalVdDisc o2){
        DigitalVdDisc tmp= o1;
        o1=o2;
        o2=tmp;
    }

    public static void changeTitle(DigitalVdDisc dvd, String title){
        String oldTitle=dvd.get_Title();
        dvd.set_Title(title);
        dvd=new DigitalVdDisc(oldTitle);
    }
}
