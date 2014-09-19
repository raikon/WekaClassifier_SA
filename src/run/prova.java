package run;

import java.io.IOException;

import textProcessing.Normalizer;

public class prova {

	public static void main(String[] args) throws IOException {
		Normalizer n = new Normalizer();
		System.out.println(n.cleanText("t e6am walk back to the room #gambling #mcdonalds #sadlydelicious #movingwalkway http://t.co/8Wq7MI1WQD"));

	}

}
