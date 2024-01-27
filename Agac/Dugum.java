package Agac;

public class Dugum {
    //Bir Dugum için gerekli bilgiler burada
    int icerik;
    Dugum sag;
    Dugum sol;

    Dugum(int icerik){
        this.icerik = icerik ;
        sag = null;
        sol = null;
    }

    void ekle(Dugum yeni){ //->Aradaki fark recursive kullanıyor kolaylık sağlar. (Ekle methodu kendi içinde çağrılması)
        if(yeni.icerik > this.icerik){
            if(sag == null)
                this.sag = yeni; //-> Sağ boş ise o düğümün sağına yeni gelen eleman eklenir (this)
            else
                sag.ekle(yeni); //->Sağ taraf boş değil ise sağ tarafın ekle methodu çağrılır
        }else {
            if(sol == null) 
                this.sol = yeni;
            else
                 sol.ekle(yeni);
        }    

    }

    //recursive stackover; Kendi kendini çağırdığından aynı zamanda döngü görevi de görüyor.
    //neden ihtiyaç var: 
    /*
     -Parçala yönet dediğimiz yapıları bu tür algoritmaları yani bir bütünden parçalama işlemi...
     -
    */
    void ongezinti() {
        /*
        (Her geçtiği yolu kaydediyor)
         * İlk yazdıracağı şey kökün içeriği, sonda null değil ise solu yazdıracak. solun öngezintisi içeriği olur.
         * Solun on gezintisi çağırınca null olana kadar yazdıracak ve null çıkınca sağ taraf null değilse çalışacak
         * null ise bir üst ebevyn i sağ kısmına geçecek, öyle öyle tüm yerleri gezip en son kökün sağ tarafını btiirecek
         * -----
         * İlk içinde bulunduğu düğümün içeriğini yazdır
         * Sonra sol null değil ise sol.gezinti çağır
         * Kendi içinde sol.gezintiyi çağırdı.
         * Çalışma alanlarında sol ve sağ nulla gelince bir sonraki çağrıldığı yere gelir.
         */

        System.out.println(icerik);
        if(sol != null)
            sol.ongezinti();
        if(sag != null)
            sag.ongezinti();
        
    }

    void araGezinti() { //-> bu şekilde ilk yazılan soldaki en küçük değer. Sonra kök ve sağ tarafın en küçüğünden büyüğe. Bu şekilde küçükten büyüğe sıralar.
        if(sol != null)
            sol.araGezinti();
        System.out.print(icerik + " ");
        if(sag != null)
            sag.araGezinti();
    }

    Dugum min(){
        Dugum tmp = this;
        while(tmp.sol != null){
            if(sol!=null)
                tmp = tmp.sol;
        }//this => bu sınıf
        return tmp;
    }
    void sil(Dugum parent, int veri){
        //Silme işlemi yapabilmek için önce arama yapabilmemiz lazım. Aramaya kök dürümden başlayacağız.
        if(this.icerik == veri){
            System.out.println("Silinecek içecek: " + this.icerik);
            System.out.println("Silinecek Elemanın Atası:" + parent.icerik);
            if(sag == null && sol == null){
                //-> Yapram düğüm bulundu.
                System.out.println("Yaprak Düğüm");
                if(this.icerik > parent.icerik) {
                    parent.sag = null;
                }else{
                    parent.sol = null;
                }
            }
            else if(sag != null && sol == null){
                //-> Sadece sağ cocuk
                System.out.println("Sadece Sağ cocuk");
                if(this.icerik > parent.icerik) {
                    parent.sag = this.sag;
                }else{
                    parent.sol = this.sag;
                }
            }
            else if(sag == null && sol != null){
                //-> Sadece sol cocuk
                System.out.println("Sadece Sol cocuk");
                if(this.icerik > parent.icerik) {
                    parent.sag = this.sol;
                }else{
                    parent.sol = this.sol;
                }
            }
            else if(sag != null && sol != null){
                //-> İki Çocuğu var
                System.out.println("İki cocuklu eleman");
                Dugum min = this.sag.min();
                System.out.println("sağın en küçük değeri :" + min.icerik);
                int x = min.icerik;
                this.sag.sil(this, x);
                this.icerik = x;
                //Silinecek eleman = this.icerik. 
                //sağın en küçüğünü bul onu çift çocuğu olana atadı ve kendini sildi.
            }
        }else{
            if(veri > this.icerik){
                if(sag == null){
                    System.out.println("Silinecek Eleman Yok");
                    return;
                }else{
                parent = this; //-> Ebeveny korumak için gerekli kod.
                sag.sil(parent, veri);
                }
            }else{
                if(sol == null){
                    return;
                }else{
                    parent = this;
                    sol.sil(parent, veri);
                }
            }
        }
        //-> 1 Yaprak Silme:
            //-> sol ve sağ null ise ebeveyn in solu ve ya sağını null yaparız
        //-> 2 Tek sağ ve tek çocuk:
            //-> Sağ null ve sol != null veya tersi ise tek çocuk var. Ebeveyn i ise altındaki çocuğa bağlarsak ortada kalan çocuk silinmiş olur
        //-> 3 İki çocuklu Düğüm silme
            //-
    }
}