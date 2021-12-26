package pk;

import java.util.ArrayList;
import java.io.*;
import java.lang.*;

public class Main {

	public static void main(String[] args) {
		String[] metin = "Ayir bakem bu yaziyi".split("[\\s]");
		Buffer bf = new Buffer();
	    for(int i = 0; i<metin.length; i++) {
	    	bf.ekle(metin[i]);
	    }
	    bf.goster();
	    bf.sil();
	    bf.sil();
	    bf.goster(); //System.out.println(bf.kelimeler);
	    System.out.println(bf.getir());
	}
}
