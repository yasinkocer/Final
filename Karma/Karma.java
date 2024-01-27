package Karma;

import java.util.LinkedList;

public class Karma {
    int N;
    LinkedList<Eleman>[] bl;

    //Sınıfı oluştururken kullanıcıdan lenght alma
    Karma(int N){
        this.N = N;
        bl = new LinkedList[N];
        for(int i = 0; i<N ; i++){
            bl[i] = new LinkedList();
        }
    }

    int karmaFonks(int dogumTarihi){
        return dogumTarihi % N;
    }
    
    void karmaEkle(Eleman yeni){
        int dt = yeni.dogumTarihi;
        int adres = karmaFonks(dt);
        bl[adres].add(yeni);
    }

    Eleman karmaAra(int dogumTarihi){
        Eleman tmp = null;
        int adres = karmaFonks(dogumTarihi);
        for(int i = 0 ; i<bl[adres].size();i++){
            tmp = bl[adres].get(i);
            if(dogumTarihi == tmp.dogumTarihi)
                break;
        }
        return tmp;
    }

}
