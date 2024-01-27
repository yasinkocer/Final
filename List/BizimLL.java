package List;

public class BizimLL {
    Eleman bas;
    Eleman son;

    public BizimLL(){
        bas = null; //->Liste yeni oluşturulduğu vakit baş eleman null olmalı.
        son = null; //->Aynı şekilde son da null olmalı.
    }

    public void basaEkle(int sayi) {
        Eleman yEleman = new Eleman(sayi);
        if(doluMu()){
            //liste dolu
            yEleman.siradaki = bas;
            bas = yEleman;
        }else{
            //liste boş
            bas = yEleman; //bas ve sona eklenen ilk elemanın referasını gönderdik. Artık baş ve son bu elemanın refini tutuyor.
            son = yEleman;
        }
    }

    public void sonaEkle(int sayi){
        Eleman yEleman = new Eleman(sayi);
        if(doluMu()){
            //liste dolu
            son.siradaki = yEleman;
            son = yEleman;
        }else{
            //liste boş
            bas = yEleman; //bas ve sona eklenen ilk elemanın referasını gönderdik. Artık baş ve son bu elemanın refini tutuyor.
            son = yEleman;
        }
    }

    public void yazdir(){
        Eleman tmp = bas;
        while(tmp != null){
            System.out.print(tmp.sayi + " ");
            tmp = tmp.siradaki;
        }
    }

    public boolean doluMu(){
        if(bas != null){
            return true;
        }else{
            return false;
        }

    }
}
