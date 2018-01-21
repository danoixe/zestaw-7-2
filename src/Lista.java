import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Lista {

	int [] liczby;
	int pojemnosc;
	int rozmiar=0; 
	
	public Lista(int pojemnosc) {
		this.pojemnosc = pojemnosc;
		liczby = new int[pojemnosc];
	}
	
	public void dodajElement(int element) {
		if(rozmiar>=pojemnosc) {
			System.out.println("Tablica jest pe³na");
		}
		else {
			liczby[rozmiar]=element;
			rozmiar++;
		}
	}
	
	public int znajdz(int liczba) {
		int pozycja = -1;
		for (int i=0; i<rozmiar; i++) {
			if (liczby[i]==liczba) {
				pozycja = i;
				break;
			}
		}
		return pozycja;
	}
	
	public void pisz() {
		System.out.println("Rozmiar: "+rozmiar);
		System.out.println("Pojemnoœæ: "+pojemnosc);
		System.out.print("Elementy: ");
		for (int i=0; i<rozmiar; i++) {
			System.out.print(" "+liczby[i]);
		}
		System.out.println();
	}
	
	public void usunPierwszy(int liczba) {
		for (int i=0; i<rozmiar; i++) {
			if(liczby[i]==liczba) {
				while (i<rozmiar-1) {
					liczby[i]=liczby[i+1];
					i++;
				}
				rozmiar--;
				break;
			}
		}
	}
	
	public void usunPowtorzenia() {
		for (int i=0; i<rozmiar; i++) {
			for(int j=i+1; j<rozmiar; j++) {
				if (liczby[j]==liczby[i]) {
					int k=j;
					while(k<rozmiar-1) {
						liczby[k]=liczby[k+1];
						k++;
					}
					rozmiar--;
				}
			}
		}
	}
	
	public void odwroc() {
		int temp;
		for (int i=0; i<rozmiar; i++) {
			temp=liczby[i];
			liczby[i]=liczby[rozmiar-i];
			liczby[rozmiar-i]=temp;
		}
	}
	
	public void zapiszDoPliku(String nazwaPliku) throws IOException {
		String sciezka = "";
		File plik = new File(nazwaPliku);
		BufferedWriter dod = new BufferedWriter(new FileWriter(plik));
		for(int i=0; i<rozmiar; i++) {
			dod.write(liczby[i]+" ");
		}
	}
}









