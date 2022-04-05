package lc;

import java.io.*;
import java.util.*;
import java.lang.Math;

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
		
		
		
		Kuyruk cikti = new Kuyruk(); //Cikti fonksiyonlarini ve sayisini tutmak icin
		for (int i = ayrac+2 ; i < ilk.length(); i+=2) {
			cikti.ekle(ilk.charAt(i));
		}
		
		String kontrol;
        Kuyruk term = new Kuyruk();
        Kuyruk minterm = new Kuyruk();
		Kuyruk maxterm = new Kuyruk();
		for (int j = 0; j < cikti.boyut(); j++) {
			f = new File("dogruluk_tablosu.txt");
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String fonksiyon = br.readLine();
			System.out.print(fonksiyon.charAt(ayrac+((j+1)*2))+" = ");
			for (int i = 0; i < Math.pow(2,tbd.boyut()); i++) {
				kontrol = br.readLine();
				term.ekle(kontrol.charAt(ayrac+((j+1)*2)));
			}
			for(int k = 0; k < term.boyut(); k++) {
				if(term.getir(k).equals('1')) {
					minterm.ekle(Character.forDigit(k, 10));
				}
				if(term.getir(k).equals('0')) {
					maxterm.ekle(Character.forDigit(k, 10));
				}			
			}
			System.out.print("E");
			minterm.goster();
			System.out.print(fonksiyon.charAt(ayrac+((j+1)*2))+" = ");
			for (int l = 0; l< minterm.boyut(); l++) {
				System.out.print("m"+minterm.getir(l)+" + ");
			}
			System.out.println();
			System.out.print(fonksiyon.charAt(ayrac+((j+1)*2))+" = ");
			System.out.print("U");
			maxterm.goster();
			System.out.print(fonksiyon.charAt(ayrac+((j+1)*2))+" = ");
			for (int n = 0; n< maxterm.boyut(); n++) {
				System.out.print("M"+maxterm.getir(n)+" + ");
			}
			System.out.println();
			System.out.println();
			term.temiz();
		}
		
		f = new File("dogruluk_tablosu.txt");
		fr = new FileReader(f);
		br = new BufferedReader(fr);
		br.readLine();
		
		String satir = "";
		while (br.ready()) {
			for (int j = 0; j < cikti.boyut(); j++) {
				for(int g = 0; g < minterm.boyut(); g++) {
	        	   satir = br.readLine();
	        	   if(minterm.equals(Character.forDigit(g, 10))) {
	        		   Character deger = satir.charAt(ayrac+((j+1)*2));
	        		   if(deger.equals(1)){
	               		System.out.println(ilk.charAt(ayrac+((j+1)*2))+" = ");
	               		for (int i = 0; i < tbd.boyut(); i++) { //Satir degiskenleri icin
	       	            	Character tempc = satir.charAt(i*2);
	       	            	if(tempc.equals('0')){
	       	            		System.out.print(ilk.charAt(i*2)+"'");
	       	            	}
	       	            	else if(tempc.equals('1')) {
	       	            		System.out.print(ilk.charAt(i*2));
	       	            	}
	       	            }
	       	            System.out.print(" + ");
	               	}
	        	   }
				}
				System.out.println();
				for(int h = 0; h < maxterm.boyut(); h++) {
					satir = br.readLine();
		        	   if(minterm.equals(Character.forDigit(h, 10))) {
		        		   Character deger = satir.charAt(ayrac+((j+1)*2));
		        		   if(deger.equals(1)){
		               		System.out.println(ilk.charAt(ayrac+((j+1)*2))+" = ");
		               		for (int i = 0; i < tbd.boyut(); i++) { //Satir degiskenleri icin
		       	            	Character tempc = satir.charAt(i*2);
		       	            	if(tempc.equals('0')){
		       	            		System.out.print(ilk.charAt(i*2)+"'");
		       	            	}
		       	            	else if(tempc.equals('1')) {
		       	            		System.out.print(ilk.charAt(i*2));
		       	            	}
		       	            }
		       	            System.out.print(" + ");
		               	}
		        	   }
					}
				}
			
			satir = br.readLine();
            for (int j = 0; j < cikti.boyut(); j++) { //Ciktilar icin gezinecek.
            	Character deger = satir.charAt(ayrac+((j+1)*2));
            	if(deger.equals(1)){
            		System.out.println(ilk.charAt(ayrac+((j+1)*2))+" = ");
            		for (int i = 0; i < tbd.boyut(); i++) { //Satir degiskenleri icin
    	            	Character tempc = satir.charAt(i*2);
    	            	if(tempc.equals('0')){
    	            		System.out.print(ilk.charAt(i*2)+"'");
    	            	}
    	            	else if(tempc.equals('1')) {
    	            		System.out.print(ilk.charAt(i*2));
    	            	}
    	            }
    	            System.out.print(" + ");
            	}
            	System.out.println();
            	
            }
            
	            
        }
		
		
		
		Kuyruk kd = new Kuyruk();//Kullanicidan aldigimiz degerleri tutmak icin
		for (int i = 0; i < tbd.boyut(); i++) {
			System.out.print("Lutfen degiskenin degerini giriniz: ");
			char tempChar = sc.next().charAt(0);
			kd.ekle(tempChar);
		}
		
		f = new File("dogruluk_tablosu.txt");
		fr = new FileReader(f);
		br = new BufferedReader(fr);
		br.readLine();
		
		satir = "";
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
		
		System.out.println();
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