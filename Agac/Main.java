package Agac;
public class Main {
    public static void main(String[] args) {
        Dugum kok = new Dugum(100); //-> Köke 5 verdik
        Dugum dge1 = new Dugum(50); //-> Düğümün ekle fonksiyonu kullanıkarak eklenecek
        Dugum dge2 = new Dugum(80);
        Dugum dge3 = new Dugum(120);
        Dugum dge4 = new Dugum(115);
        Dugum dge5 = new Dugum(130);
        kok.ekle(dge1);
        kok.ekle(dge2);
        kok.ekle(dge3);
        kok.ekle(dge4);
        kok.ekle(dge5);
        //System.out.println(kok.icerik); (5)
        //System.out.println(kok.sag.icerik); (25)
        //System.out.println(kok.sol.icerik); (4)
        //System.out.println(kok.sag.sag.icerik); (30)

        System.out.println("Kökün orjinali");
        kok.araGezinti();
        System.out.println("--------------------------------------------");
        kok.sil(kok, 120);
        System.out.println("Min değer:" + kok.sag.min().icerik);
        kok.araGezinti();
        System.out.println("--------------------------------------------");
        System.out.println(kok.min().icerik);
        System.out.println(kok.sol.min().icerik);
        System.out.println(kok.sag.min().icerik);
    }
}