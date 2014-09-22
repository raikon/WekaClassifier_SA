package run;

import java.io.IOException;

import textProcessing.Normalizer;



public class prova {

	public static void main(String[] args) throws IOException {
		Normalizer n = new Normalizer();
		String s = "t¢McDonald\u2019s CEO: \u2018We Pay Fair Wages\u2019: McDonald\u2019s CEO said Thursday his company\u2019s	employees are	paid	fairly and that they are provided ...";
		
		byte[] utf8 = s.getBytes("UTF-8");
		String a = new String(utf8);
		System.out.println(a);	
		
		String str = "THIS GUYS AT THE MCDONALDS DRIVE THRU &gt;&gt;&gt;&gt; Ã°Å¸Ëœï¿½ omgomgomg";
		System.out.println(n.cleanText(str));
		
	}
	
	public static String removeSpecialChars(String content) throws IOException {
		content = content
				.replaceAll("â‚¬","€")
				.replaceAll( "â€š", "‚")
				.replaceAll("Æ'","ƒ")
				.replaceAll("â€ž","„")
				.replaceAll("â€¦","…")
				.replaceAll("â€¡","‡")
				.replaceAll("Ë†","ˆ")
				.replaceAll("â€°","‰")
				.replaceAll("Å","Š")
				.replaceAll("â€¹","‹")
				.replaceAll("Å'","Œ")
				.replaceAll("Å½","Ž")
				.replaceAll("â€˜","'")
				.replaceAll("â€™","'")
				.replaceAll("â€œ","\"")
				.replaceAll("â€","\"")
				.replaceAll("â€¢","•")
				.replaceAll("â€\"","–")
				.replaceAll("â€\"","—")
				.replaceAll("Ëœ","˜")
				.replaceAll("â\"¢","™")
				.replaceAll("Å¡","š")
				.replaceAll("â€º","›")
				.replaceAll("Å\"","œ")
				.replaceAll("Å¾","ž")
				.replaceAll("Å¸","Ÿ")
				.replaceAll("Â¡","¡")
				.replaceAll("Â¢","¢")
				.replaceAll("Â£","£")
				.replaceAll("Â¤","¤")
				.replaceAll("Â¥","¥")
				.replaceAll("Â¦","¦")
				.replaceAll("Â§","§")
				.replaceAll("Â¨","¨")
				.replaceAll("Â©","©")
				.replaceAll("Âª","ª")
				.replaceAll("Â«","«")
				.replaceAll("Â¬","¬")
				.replaceAll("Â®","®")
				.replaceAll("Â¯","¯")
				.replaceAll("Â°","°")
				.replaceAll("Â±","±")
				.replaceAll("Â²","²")
				.replaceAll("Â³","³")
				.replaceAll("Â´","´")
				.replaceAll("Âµ","µ")
				.replaceAll("Â¶","¶")
				.replaceAll("Â·","·")
				.replaceAll("Â¸","¸")
				.replaceAll("Â¹","¹")
				.replaceAll("Âº","º")
				.replaceAll("Â»","»")
				.replaceAll("Â¼","¼")
				.replaceAll("Â½","½")
				.replaceAll("Â¾","¾")
				.replaceAll("Â¿","¿")
				.replaceAll("Ã€","À")
				.replaceAll("Ã","Á")
				.replaceAll("Ã‚","Â")
				.replaceAll("Ãƒ","Ã")
				.replaceAll("Ã\"","Ä")
				.replaceAll("Ã…","Å")
				.replaceAll("Ã†","Æ")
				.replaceAll("Ã‡","Ç")
				.replaceAll("Ãˆ","È")
				.replaceAll("Ã‰","É")
				.replaceAll("ÃŠ","Ê")
				.replaceAll("Ã‹","Ë")
				.replaceAll("ÃŒ","Ì")
				.replaceAll("Ã","Í")
				.replaceAll("ÃŽ","Î")
				.replaceAll("ÃŸ","Ï")
				.replaceAll("Ã","Ð")
				.replaceAll("Ã","Ñ")
				.replaceAll("Ã","Ò")
				.replaceAll("Ã\"","Ó")
				.replaceAll("Ã\"","Ô")
				.replaceAll("Ã•","Õ")
				.replaceAll("Ã–","Ö")
				.replaceAll("Ã—","×")
				.replaceAll("Ã˜","Ø")
				.replaceAll("Ã™","Ù")
				.replaceAll("Ãš","Ú")
				.replaceAll("Ã›","Û")
				.replaceAll("Ãœ","Ü")
				.replaceAll("Ã","Ý")
				.replaceAll("Ãž","Þ")
				.replaceAll("ÃŸ","ß")
				.replaceAll("Ã","à")
				.replaceAll("Ã¡","á")
				.replaceAll("Ã¢","â")
				.replaceAll("Ã£","ã")
				.replaceAll("Ã¤","ä")
				.replaceAll("Ã¥","å")
				.replaceAll("Ã¦","æ")
				.replaceAll("Ã§","ç")
				.replaceAll("Ã¨","è")
				.replaceAll("Ã©","é")
				.replaceAll("Ãª","ê")
				.replaceAll("Ã«","ë")
				.replaceAll("Ã¬","ì")
				.replaceAll("Ã","í")
				.replaceAll("Ã®","î")
				.replaceAll("Ã¯","ï")
				.replaceAll("Ã°","ð")
				.replaceAll("Ã±","ñ")
				.replaceAll("Ã²","ò")
				.replaceAll("Ã³","ó")
				.replaceAll("Ã´","ô")
				.replaceAll("Ãµ","õ")
				.replaceAll("Ã¶","ö")
				.replaceAll("Ã·","÷")
				.replaceAll("Ã¸","ø")
				.replaceAll("Ã¹","ù")
				.replaceAll("Ãº","ú")
				.replaceAll("Ã»","û")
				.replaceAll("Ã¼","ü")
				.replaceAll("Ã½","ý")
				.replaceAll("Ã¾","þ")
				.replaceAll("Ã¿","ÿ");
		return content;
	}

}
