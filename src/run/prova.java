package run;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import textProcessing.Normalizer;

public class prova {

	public static void main(String[] args) throws IOException {
		Normalizer n = new Normalizer();
		String s = "\":\"ðŸ§ðŸ’™ðŸ§ðŸ’™ðŸ§\n@Luke5SOS\n\nHey Luke Hemmings from 5SOS \n \nIf you were a burger at McDonalds\nyou'd be McGorgeous\n\nPls follow me?\n\nLove youðŸ’•\n\nðŸ§ðŸ’™ðŸ§ðŸ’™ðŸ§ \nx1905";

		byte[] utf8 = s.getBytes("UTF-8");
		String a = new String(utf8);
		//System.out.println(a);
		
		byte[] utf8bis = a.getBytes("CP1252");
		String abis = new String(utf8,"ISO-8859-1");
		//System.out.println(abis);
		
		//System.out.println(removeSpecialChars(a));
		
		String prova = "@ddlovato: Me &amp; @dallaslovato during simpler times when we'd dress up because it was a big deal to go to McDonalds. #lateTBTÃ°Å¸ï¿½â€Ã¢ï¿½Â¤Ã¯Â¸ï¿½ http://t\u2026";
		
		System.out.println(n.cleanText(prova));
		
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
