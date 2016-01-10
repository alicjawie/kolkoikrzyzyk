package kolko;

public class Plansza {
	
	private SymbolGracza kratki[][];
	
	public Plansza() {
		kratki = new SymbolGracza[3][3];
	}
	
	public void ustawSymbolNaKratce(int x, int y, SymbolGracza symbol) {
		if (kratki[x][y] == null) {
			kratki[x][y] = symbol;
		} else {
			throw new IllegalArgumentException("Podana kratka nie jest juz pusta");
		}
	}
	
	public boolean czyKratkaZajeta(int x, int y) {
		return !(kratki[x][y] == null);
	}
	
	public SymbolGracza pokazSymbolNaKratce(int x, int y) {
		return kratki[x][y];
	}
	
	public String zwrocRysunekPlanszy(){
		
		String pierwszaLinijka = linijkaJakoTekst(0) + "\n";
		String liniaPozioma = "_____" + "\n";
		String drugaLinijka = linijkaJakoTekst(1) + "\n";
		String trzeciaLinijka = linijkaJakoTekst(2);
		
		return pierwszaLinijka + liniaPozioma + drugaLinijka + liniaPozioma + trzeciaLinijka;
	}
	
	public String kratkaJakoTekst(int x, int y) {
		if (kratki[x][y] == SymbolGracza.KOLKO){
			return "O";
		} else if (kratki[x][y] == SymbolGracza.KRZYZYK){
			return "X";
		} else {
			return " ";
		}
	}
	
	public String linijkaJakoTekst(int numerLinijki) {
		return kratkaJakoTekst(0, numerLinijki) + "|" + kratkaJakoTekst(1, numerLinijki) + "|" + kratkaJakoTekst(2, numerLinijki);
	}

}
