package Sıralama;
public class SiralamaAlgoritmalari {
	
	public static void bubleSort(int[] dizi) {
		int temp;
		for(int i=0; i<dizi.length;i++) {
			for(int j=0; j < dizi.length - i - 1; j++) {
				
				if(dizi[j] > dizi[j+1]) {
					temp=dizi[j];
					dizi[j]=dizi[j+1];
					dizi[j+1]=temp;
				}
			}
		}
		for(int i=0; i<dizi.length;i++) {
			System.out.print(dizi[i] +" , ");
		}
		System.out.println("");
	}
	
	public static void selectionSort(int[] dizi) {
		
		for(int i=0; i<dizi.length; i++) {
			
			int minindex=i;
			for(int j=i+1; j<dizi.length; j++) {
				
				if(dizi[minindex]<dizi[j]) {
					minindex=j;
				}
			}
			int temp=dizi[minindex];
			dizi[minindex]=dizi[i];
			dizi[i]=temp;
			
		}
		for(int i=0; i<dizi.length;i++) {
			System.out.print(dizi[i] +" , ");
		}
	}
	
	public static void insertionSort(int[] dizi) {
		
		for(int i=1; i<dizi.length; i++) {
			int key=dizi[i];
			int j=i-1;
			
			while(j>=0 && dizi[j]>key) {
				dizi[j+1]=dizi[j];
				j--;
			}
			dizi[j+1]=key;
		}
		for(int i=0; i<dizi.length;i++) {
			System.out.print(dizi[i] +" , ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		int[] dizi= {10, 2, 8, 3, 9, 4, 1, -1};
		
		

	}

}
