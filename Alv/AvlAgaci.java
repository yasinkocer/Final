package Alv;

public class AvlAgaci {
	AvlDugum kok;
	
	AvlDugum ekle(AvlDugum dugum, int icerik) { 
		  
        /* 1.  normal BST ağacı gibi ekleme yap */
        if (dugum == null) 
            return (new AvlDugum(icerik)); 
  
        if (icerik < dugum.icerik) 
            dugum.sol = ekle(dugum.sol, icerik); 
        else if (icerik > dugum.icerik) 
            dugum.sag = ekle(dugum.sag, icerik); 
        else // Duplicate keys not allowed 
            return dugum; 
  
        /* 2. düğüm boyunu güncelle */
        dugum.boy = 1 + max(boy(dugum.sol), boy(dugum.sag)); 
  
        /* 3. denge değerini al */
        int denge = denge(dugum); 
  
        // 4. rotasyonlar
        //denge fonksiyonu solboy - sagboy işlemi ile hesaplanır.
        //eğer dengesizlik varsa(denge=2 ve denge = -2) 4 durum ortaya çıkacaktır 
        //4.1. Sağ rotasyon
        //denge değeri pozitifse(denge =+2) ve son eklenen düğümün içeriği dengesizliğin belirlendiği düğümün solundaki düğümün içeriğinden k���kse bu rotasyon uygulanır.
        //�art: denge = 2 ve icerik<dugum.sol.icerik
        //Bu durumda son eklenen eleman dengesizliğin belirlendiği düğümün solunun soluna eklenmiştir. bu durumda düğümü sağa doğru döndürerek dengesizlik düzeltilir.
        if (denge == 2 && icerik < dugum.sol.icerik) 
            return sagRotasyon(dugum); 
  
        //4.2. Sol rotasyon
        //denge değeri negatifse(denge=-2) ve son eklenen düğümün içeriği dengesizliğin belirlendiği düğümün sağındaki düğümün içeriğinden büyükse bu rotasyon uygulanır.  
        //�art: denge=-2 ve icerik>dugum.sag.icerik
        //Bu durumda son eklenen eleman dengesizli�in belirlendi�i d���m�n sa��n�n sa��na eklenmi�tir. bu durumda d���m� SOLA do�ru d�nd�rerek dengesizlik d�zeltilir.
        if (denge == -2 && icerik > dugum.sag.icerik) 
            return solRotasyon(dugum); 
  
        //4.3. Sol Sa� rotasyon
        //denge de�eri pozitifse(denge=+2) ve son eklenen d���m�n i�eri�i dengesizli�in belirlendi�i d���m�n solundaki d���m�n i�eri�inden b�y�kse bu rotasyon uygulan�r.  
        //�art: denge=+2 ve icerik>dugum.sol.icerik
        //Bu durumda son eklenen eleman dengesizli�in belirlendi�i d���m�n SOLUnun SA�Ina eklenmi�tir. bu durumda d���m�n sol �ocu�una SOL rotasyon, d���me SA� rotasyon uygulan�r. 
        if (denge == 2 && icerik > dugum.sol.icerik) { 
        	System.out.println("SOL SAĞ rotasyon");
            dugum.sol = solRotasyon(dugum.sol); 
            return sagRotasyon(dugum); 
        } 
  
        //4.4. SA� SOL rotasyon
        //denge de�eri negatifse(denge=-2) ve son eklenen d���m�n i�eri�i dengesizliğin belirlendi�i düğümün sağındaki düğümün içeriğinden k���kse bu rotasyon uygulan�r.  
        //�art: denge=-2 ve icerik<dugum.sag.icerik
        //Bu durumda son eklenen eleman dengesizli�in belirlendi�i d���m�n SA��n�n SOLuna eklenmi�tir. bu durumda d���m�n sa� �ocu�una SA� rotasyon, d���me SOL rotasyon uygulan�r. 
        if (denge == -2 && icerik < dugum.sag.icerik) { 
        	System.out.println("SAĞ SOL rotasyon");
            dugum.sag = sagRotasyon(dugum.sag); 
            return solRotasyon(dugum); 
        } 
  
        /* hiçbir rotasyon yapılmas�dıysa d���m� d�n */
        return dugum; 
    }
	
	int denge(AvlDugum dugum) {
		return boy(dugum.sol) - boy(dugum.sag);
	}
	
	int boy(AvlDugum dugum) {
		if(dugum==null)
			return 0;
		else
			return dugum.boy;
	}
	
	int max(int a, int b) {
		if(a>b)
			return a;
		else
			return b;
	}
	void araGezinti(AvlDugum dugum) {
		if(dugum!=null) {
			araGezinti(dugum.sol);
			System.out.print(dugum.icerik +" / ");
			araGezinti(dugum.sag);
		}
	}
	AvlDugum solRotasyon(AvlDugum dugum) {
		AvlDugum y=dugum.sag;
		AvlDugum t2=y.sol;
		System.out.println("SOL rotasyon");
		//rotasyon i�lemi
		y.sol=dugum;
		dugum.sag=t2;
		
		//boy g�ncellemesi
		dugum.boy=max(boy(dugum.sol), boy(dugum.sag)) + 1;
		y.boy=max(boy(y.sol), boy(y.sag)) +1;
		
		//d�nd�rme sonucu yeni eleman� d�n
		return y;
	}
	
	AvlDugum sagRotasyon(AvlDugum dugum) {
		AvlDugum y=dugum.sol;
		AvlDugum t2=y.sag;
		System.out.println("SAĞ rotasyon");
		//rotasyon i�lemi
		y.sag=dugum;
		dugum.sol=t2;
		
		//boy g�ncelleme
		dugum.boy=max(boy(dugum.sol), boy(dugum.sag)) + 1;
		y.boy=max(boy(y.sol), boy(y.sag)) +1;
		
		// yeni eleman� d�n
		return y;
	}
}
