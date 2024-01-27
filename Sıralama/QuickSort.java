package Sıralama;

public class QuickSort {

	 // dizideki iki eleman�n yerini de�i�tiren fonksiyon
    static void swap(int[] dizi, int i, int j)
    {
        int temp = dizi[i];
        dizi[i] = dizi[j];
        dizi[j] = temp;
    }
 
    // Bu fonksiyon son eleman� pivot olarak al�r, pivot eleman�n� s�ralanm�� dizide do�ru konuma yerle�tirir 
    //ve t�m k���k elemanlar� pivotun soluna ve t�m b�y�k elemanlar� pivotun sa��na yerle�tirir.
    
    static int partition(int[] dizi, int ilkIndeks, int sonIndeks)
    {
        // pivotu se�me
        int pivot = dizi[sonIndeks];
 
        // Daha k���k ��enin dizini ve �u ana kadar bulunan pivotun do�ru konumunu g�sterir
        int i = (ilkIndeks - 1);
 
        for (int j = ilkIndeks; j <= sonIndeks - 1; j++) {
 
            // mevcut eleman pivottan k���kse yer de�i�me yap
            if (dizi[j] < pivot) {
 
                // k���k eleman�n indeksini bir artt�r ve yer de�i�
                i++;
                swap(dizi, i, j);
            }
        }
        swap(dizi, i + 1, sonIndeks);
        return (i + 1);
    }
 
    // Quick Sort'un ana fonksiyonu
    // dizi[] --> s�ralanacak dizi,
    // ilkIndeks --> ba�lama indeksi,
    // sonIndeks --> biti� indeksi
    static void quickSort(int[] dizi, int ilkIndeks, int sonIndeks)
    {
        if (ilkIndeks < sonIndeks) {
 
            // pi dizi[p] nin b�l�mleme (potrition) indeksidir.
        	
            int pi = partition(dizi, ilkIndeks, sonIndeks);
 
            // ��eleri b�l�mden (pi) �nce ve b�l�mden sonra ayr� ayr� s�ralay�n
            
            quickSort(dizi, ilkIndeks, pi - 1);
            quickSort(dizi, pi + 1, sonIndeks);
        }
    }
    // dizi yazd�rma
    public static void printdizi(int[] dizi)
    {
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + " ");
        }
    }
 
    public static void main(String[] args)
    {
        int[] dizi = { 10, 7, 8, 9, 1, 5 };
        int N = dizi.length;
 
        // fonksiyon �a��rma
        quickSort(dizi, 0, N - 1);
        System.out.println("Sorted diziay:");
        printdizi(dizi);
    }

}
