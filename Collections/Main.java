import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * 1. Tee seuraavat kaksi luokkakohtaista geneerista metodia: 1) metodi, joka
		 * tulostaa parametrina annetusta listasta kaikki ainutkertaiset arvot sekä
		 * niiden maaran. 2) metodi, joka tulostaa parametrina annetusta listasta kaikki
		 * arvot. Testaa ohjelman toiminta main-metodista erisisaltoisillä listoilla
		 * tulostamalla ensin kaikki arvot listasta ja sen jalkeen ainutkertaiset arvot.
		 * Testaus esimerkiksi: 1) listalla, jonka sisällöksi arvotaan 50 satunnaista
		 * kokonaislukua valilta 1-30 ja 2) listalla, jonka sisaltona on merkkijonoja
		 * (myös samoja).
		 * */
		
		System.out.println("1.");
		List<Integer> integerList = generateRandomValueList(50, 1, 30);
		List<String> stringList = generateRandomStringList(50);
		
		System.out.println("Integer:");
		printUniqueValuesInList(integerList);
		printAllValues(integerList);
		
		System.out.println("\nString:");
		printUniqueValuesInList(stringList);
		printAllValues(stringList);
		
		/*
		 * 2. Tee sananpilkkoja-ohjelma, jolle syotetaan yksi kerrallaan sanoja
		 * kayttajan valitsema maara. Ohjelma pilkkoo kayttajan antaman merkkijonon
		 * pienemmiksi osamerkkijonoiksi ja laskee, kuinka monta kertaa kukin naista
		 * osamerkkijonoista esiintyy käyttäjän antamissa kaikissa merkkijonoissa.
		 * Esimerkiksi viiden merkin mittainen merkkijono pilkotaan viideksi eri
		 * merkkijonoksi. Seuraavassa esimerkki osamerkkijonoiksi pilkkomisesta:
		 * Käyttäjä syottämät sanat: suo, suola, suoli, summa Sanat pilkotaan
		 * seuraaviksi osamerkkijonoiksi: suo, su, s suola, suol, suo, su, s suoli,
		 * suol, suo, su, s summa, summ, sum, su, s Ohjelman tulee siis laskea, kuinka
		 * monta kertaa kukin näistä osamerkkijonoista esiintyy. Esimerkiksi yllä
		 * olevassa tilanteessa esiintymisiä olisi seuraavasti: s: 4, su:4, suo:3,
		 * sum:1, suol:2, summ:1, suola:1, suoli:1, summa:1 Ohjelman ratkaisussa
		 * kannattaa kayttaa esimerkiksi HashMap-kokoelmaa siten, että osamerkkijono
		 * toimii avaimena ja niiden määrä arvona.
		 * */
		
		System.out.println("2.");
		List<String> list = new ArrayList<String>();
		list.add("suo");
		list.add("suola");
		list.add("suoli");
		list.add("summa");
		
		wordSplitter(list);
		
	}

	
	private static void wordSplitter(List<String> input) {
		
		HashMap<String, Integer> inputMap = new HashMap<String, Integer>();
		
		for (String item : input) {
			List<String> splitWords = splitInput(item);
			for(String word : splitWords) {
				if(inputMap.containsKey(word)) {
					int value = inputMap.get(word);
					value++;
					inputMap.put(word, value);
				} else if(word != "") {
					inputMap.put(word, 1);
				}
			}
			
		}
		
		System.out.println(inputMap);
		
	}


	private static List<String> splitInput(String i) {
		
		List<String> values = new ArrayList<String>();
		
		values.add(i);
		
		while(i.length() > 0) {
			i = i.substring(0, (i.length()-1));
			values.add(i);
		}
		
		return values;
	}


	private static <T> void printUniqueValuesInList(List<T> elements){
		
		List<T> usedValues = new ArrayList<T>();
		
		int count = 0;
		
		System.out.println("Listan kaikki ainutkertaiset arvot sekä niiden maara");
		System.out.println("Arvot:");
		
		for(T element : elements) {
			if(!usedValues.contains(element)) {
				System.out.println(element);
				usedValues.add(element);
				count++;
			}

		}
		
		System.out.println("Ainutkertaisten arvojen lukumaara: " + count);
		
    }
	
	private static <T> void printAllValues(List<T> elements){
		
		System.out.println("Listan kaikki arvot");
		System.out.println("Arvot:");
		
		for(T element : elements) {
			System.out.println(element);
		}

	}
	
	private static List<Integer> generateRandomValueList(int length, int min, int max){
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < length; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
			list.add(randomNum);
		}
		
		return list;
	}
	
	private static List<String> generateRandomStringList(int length){
		
		List<String> randomWords = new ArrayList<String>();
		randomWords.add("cemetery");
		randomWords.add("force");
		randomWords.add("plug");
		randomWords.add("fill");
		randomWords.add("appear");
		randomWords.add("soggy");
		randomWords.add("dependent");
		randomWords.add("cluttered");
		randomWords.add("crazy");
		randomWords.add("permissible");
		randomWords.add("needless");
		randomWords.add("appreciate");
		randomWords.add("government");
		randomWords.add("extra-small");
		randomWords.add("rail");
		randomWords.add("fair");
		randomWords.add("cautious");
		randomWords.add("upset");
		randomWords.add("snotty");
		randomWords.add("brother");
		randomWords.add("glamorous");
		randomWords.add("rub");
		randomWords.add("territory");
		randomWords.add("tangible");
		randomWords.add("fretful");
		randomWords.add("boast");
		randomWords.add("battle");
		randomWords.add("comfortable");
		randomWords.add("selective");
		randomWords.add("ask");
		
		List<String> list = new ArrayList<String>();
		
		for(int i = 0; i < length; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, randomWords.size());
			list.add(randomWords.get(randomNum));
		}
		
		return list;
	}
	
}
