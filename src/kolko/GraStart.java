package kolko;

public class GraStart {

	public static void main(String[] args) {
		
		Gra gra = new Gra();
		gra.utworzGracza1();
		gra.utworzGracza2();
		gra.start();

		do {
			gra.wykonajRuch();
		} while (!gra.czyKoniec());
		
		System.out.println("Gra zakonczona");
		
	}

}
