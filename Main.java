package lc;

import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		//System.out.println("Hello World");
		Scanner sc = new Scanner(System.in);
		try {
		File f = new File("dogruluk_tablosu.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		String ilk = br.readLine();
		int ayrac = ilk.indexOf('|');
		Kuyruk tbd = new Kuyruk(); //Tablo degiskenleri ve sayisi icin tutuyoruz.
		for (int i = 0; i < ayrac; i+=2) {
			tbd.ekle(ilk.charAt(i));
		}
		
		Kuyruk kd = new Kuyruk();//Kullanicidan aldigimiz degerleri tutmak icin
		for (int i = 0; i < tbd.boyut(); i++) {
			System.out.print("Lutfen degiskenin degerini giriniz: ");
			char tempChar = sc.next().charAt(0);
			kd.ekle(tempChar);
		}
		
		Kuyruk cikti = new Kuyruk(); //Cikti fonksiyonlarini ve sayisini tutmak icin
		for (int i = ayrac+2 ; i < ilk.length(); i+=2) {
			cikti.ekle(ilk.charAt(i));
		}
		
		//Kontrol saglayip dogru satiri bulduk.
		String satir = "";
		while (br.ready()) {
            satir = br.readLine();
            int esit = 0;
            for (int i = 0; i < tbd.boyut(); i++) {
            	Character tempc = new Character(satir.charAt(i*2));
            	if(tempc.equals(kd.getir(i))){
            		esit++;
            	}
            }
            if(esit == tbd.boyut()) {
            	break;
            }
            
        }
		
		for(int i = 0; i< cikti.boyut(); i++) {
			System.out.println(cikti.getir(i) + " fonksiyonun ciktisi = " + satir.charAt(ayrac+((i+1)*2)));
		}
		
		br.close();
		System.out.println();
		System.out.println("\tDogruluk Tablosu Kontrol icin ");
		System.out.println("_________________________________________");
		System.out.println(ilk);
		System.out.println(satir);

		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
