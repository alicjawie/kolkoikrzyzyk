package kolko;

import java.util.Scanner;

public class Gra {

	private Plansza plansza;
	private Gracz gracze[];
	private Gracz ktoTeraz;

	public Gra() {
		plansza = new Plansza();
		gracze = new Gracz[2];
	}

	public void utworzGracza1() {
		gracze[0] = new Gracz(SymbolGracza.KOLKO);
	}

	public void utworzGracza2() {
		gracze[1] = new Gracz(SymbolGracza.KRZYZYK);
	}

	public void start() {
		ktoTeraz = gracze[0];
	}

	public void wykonajRuch() {
		System.out.println("Kolej na gracza " + ktoTeraz.getSymbol());
		System.out.println(plansza.zwrocRysunekPlanszy());
		Scanner skan = new Scanner(System.in);
		int wspolrzednaX;
		int wspolrzednaY;
		do {
			System.out.println("Podaj wspó³rzêdn¹ x: ");
			wspolrzednaX = skan.nextInt();
			System.out.println("Podaj wspó³rzêdn¹ y: ");
			wspolrzednaY = skan.nextInt();
			if (!plansza.czyKratkaZajeta(wspolrzednaX, wspolrzednaY)) {
				break;
			}
			System.out.println("Kozik nie oszukuj :P");
		} while (true);
		
		plansza.ustawSymbolNaKratce(wspolrzednaX, wspolrzednaY,
				ktoTeraz.getSymbol());

		if (ktoTeraz == gracze[0]) {
			ktoTeraz = gracze[1];
		} else {
			ktoTeraz = gracze[0];
		}

	}

	public boolean czyKoniec() {

		for (int i = 0; i < 3; i++) {
			if (czyKoniecWKolumnie(i) || czyKoniecWWierszu(i)) {
				return true;
			}
		}
		if (czyKoniecPoPrzekatnej1() || czyKoniecPoPrzekatnej2()) {
			return true;
		}
		return false;

	}

	private boolean czyKoniecWKolumnie(int numerKolumny) {
		for (int y = 1; y < 3; y++) {
			SymbolGracza symbolNaTejKratce = plansza.pokazSymbolNaKratce(
					numerKolumny, y);
			SymbolGracza symbolNaPoprzedniej = plansza.pokazSymbolNaKratce(
					numerKolumny, y - 1);
			if ((symbolNaTejKratce == symbolNaPoprzedniej)
					&& (symbolNaTejKratce != null)) {

			} else {
				return false;
			}
		}
		return true;
	}

	private boolean czyKoniecWWierszu(int numerWiersza) {
		for (int x = 1; x < 3; x++) {
			SymbolGracza symbolNaTejKratce = plansza.pokazSymbolNaKratce(x,
					numerWiersza);
			SymbolGracza symbolNaPoprzedniej = plansza.pokazSymbolNaKratce(
					x - 1, numerWiersza);
			if ((symbolNaTejKratce == symbolNaPoprzedniej)
					&& (symbolNaTejKratce != null)) {

			} else {
				return false;
			}
		}
		return true;
	}

	private boolean czyKoniecPoPrzekatnej1() {
		for (int x = 1; x < 3; x++) {
			SymbolGracza symbolNaTejKratce = plansza.pokazSymbolNaKratce(x, x);
			SymbolGracza symbolNaPoprzedniej = plansza.pokazSymbolNaKratce(
					x - 1, x - 1);
			if ((symbolNaTejKratce == symbolNaPoprzedniej)
					&& (symbolNaTejKratce != null)) {

			} else {
				return false;
			}
		}
		return true;

	}

	private boolean czyKoniecPoPrzekatnej2() {
		for (int i = 1; i < 3; i++) {
			SymbolGracza symbolNaTejKratce = plansza.pokazSymbolNaKratce(i,
					2 - i);
			SymbolGracza symbolNaPoprzedniej = plansza.pokazSymbolNaKratce(
					i - 1, 2 - (i - 1));
			if ((symbolNaTejKratce == symbolNaPoprzedniej)
					&& (symbolNaTejKratce != null)) {

			} else {
				return false;
			}
		}
		return true;

	}

}
