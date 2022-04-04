package lc;

import java.util.ArrayList;

public class Kuyruk {

		ArrayList<Character> tabloDegerleri = new ArrayList<Character>();
		
		void ekle(Character deger) {
			tabloDegerleri.add(deger);
		}
		void sil() {
			tabloDegerleri.remove(0);
		}
		Character getir(int in) {
			return tabloDegerleri.get(in);
		}
		
		int boyut() {
			return tabloDegerleri.size();
		}
		
		void goster() {
			System.out.println(tabloDegerleri);
		}
}
