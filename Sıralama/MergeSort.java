package Sıralama;


public class MergeSort {
		 
    // dizi[] i�indeki iki alt diziyi birle�tirir.
    // Birinci alt dizi: dizi[sol..orta]
    // ikinci alt dizi: dizi[orta+1..sag]
    void birlestir(int dizi[], int sol, int orta, int sag)
    {
        // Birle�tirilecek iki alt dizinin boyutlar�n� bul
        int n1 = orta - sol + 1;
        int n2 = sag - orta;
 
        // Create temp arrays
        int SOL[] = new int[n1];
        int SAG[] = new int[n2];
 
        // Ge�ici dizilere alt dizileri kopyala
        for (int i = 0; i < n1; ++i)
            SOL[i] = dizi[sol + i];
        for (int j = 0; j < n2; ++j)
            SAG[j] = dizi[orta + 1 + j];
 
        // ge�ici dizileri s�rala 
 
        // Birinci ve ikinci alt dizilerin ba�lang�� indeksleri
        int i = 0, j = 0;
 
        // Birle�tirilmi� alt dizi dizisinin ba�lang�� indeksi
        int k = sol;
        while (i < n1 && j < n2) {
            if (SOL[i] <= SAG[j]) {
                dizi[k] = SOL[i];
                i++;
            }
            else {
                dizi[k] = SAG[j];
                j++;
            }
            k++;
        }
 
        // Varsa SOL[]'un kalan elemanlar�n� kopyala
        while (i < n1) {
            dizi[k] = SOL[i];
            i++;
            k++;
        }
 
        // Varsa SAG[]'�nn kalan elemanlar�n� kopyala
        while (j < n2) {
            dizi[k] = SAG[j];
            j++;
            k++;
        }
    }
 
    // birlestir() metodunu kullanarak dizi[sol..sag] dizisini s�ralayan fonksiyon 
    
    void sirala(int dizi[], int sol, int sag)
    {
        if (sol < sag) {
 
            // orta noktay� bul
            int orta = sol + (sag - sol) / 2;
 
            // Birinci ve ikinci alt dizi par�alar�n� s�ralay�n
            sirala(dizi, sol, orta);
            sirala(dizi, orta + 1, sag);
 
            // s�ralanm�� alt dizileri birle�tir
            birlestir(dizi, sol, orta, sag);
        }
    }
 
    // A utility function to print array of size n
    static void diziYazdir(int dizi[])
    {
        int n = dizi.length;
        for (int i = 0; i < n; ++i)
            System.out.print(dizi[i] + " ");
        System.out.println();
    }
 
    public static void main(String args[])
    {
        int dizi[] = { 12, 11, 13, 5, 6, 7 };
 
        System.out.println("Given array is");
        diziYazdir(dizi);
 
        MergeSort ob = new MergeSort();
        ob.sirala(dizi, 0, dizi.length - 1);
 
        System.out.println("\n s�ralanm�� dizi");
        diziYazdir(dizi);
    }
}

