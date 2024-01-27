package Karma;

public class Main {
    public static void main(String[] args) {
        Karma km = new Karma(5);
        Eleman eleman = new Eleman(1980,20,"Dodo");
        Eleman eleman3 = new Eleman(1980,20,"Ahmet");
        Eleman eleman4 = new Eleman(1981,19,"Salih");

        km.karmaEkle(eleman);
        km.karmaEkle(eleman3);
        km.karmaEkle(eleman4);

        for(int i=0;i<km.bl[0].size();i++){
            Eleman eleman2 = km.bl[0].get(i);
            System.out.println(eleman2.dogumTarihi + eleman2.adi);
        }
        Eleman e = km.karmaAra(1981);
        //hSystem.out.println(e.dogumTarihi + " " + e.adi)   ;;

    }
    
}
