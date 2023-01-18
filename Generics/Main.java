package teht1;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		/*
		 * Tee geneerinen metodi, joka tulostaa sille parametrina välitetyn taulukon (riippumatta
		 * taulukon sisallosta). Testaa metodin toiminta.
		 * Huom! Geneerisella metodilla voi olla argumentteina vain olioita. Siten taulukoiden
		 * tyyppinä ei voi olla primitiivityyppi (int, double, …), vaan tyypiksi täytyy antaa niiden
		 * olioversio eli kaareluokka (Integer, Double, Character).
		 * */
		
		System.out.println("1.");
		System.out.println("Integers");
		Integer[] intArray = { 1, 4, 5, 34 };
		printArray(intArray);
		
		System.out.println("Strings");
		String[] stringArray = { "aa", "bb", "cc", "dd" };
		printArray(stringArray);
		
		/*
		 * Tee geneerinen metodi, joka palauttaa suurimman sille parametrina valitetysta
		 * kolmesta oliosta. Testaa metodin toiminta erityyppisillä olioilla.
		 * */
		
		System.out.println("2.");
		System.out.println("Integers");
		System.out.println(returnLargest(intArray));
		
		System.out.println("Strings");
		System.out.println(returnLargest(stringArray));
		
		/*
		 * Tee geneerinen metodi, joka vaihtaa ArrayList-listan ensimmaisen ja viimeisen
		 * alkion paikkaa keskenaan. Testaa metodin toiminta.
		 * */
		
		System.out.println("3.");
		ArrayList<String> stringList = new ArrayList<String>();
		stringList.add("First");
		stringList.add("Middle");
		stringList.add("Last");
		
		System.out.println("ArrayList");
		System.out.println(stringList);
		
		stringList = swapLastAndFirst(stringList);
		
		System.out.println("ArrayList swapped");
		System.out.println(stringList);
		
		/*
		 * Tee geneerinen metodi, joka laskee listassa olevien lukujen (Number-luokan
		 * periva luokka) summan. Testaa metodin toiminta.
		 * */
		
		System.out.println("4.");
		System.out.println("Integers");
		System.out.println("Sum");
		System.out.println(sum(intArray));
		
	}

	private static <T> void printArray(T[] elements){
		
		for(T element : elements) {
			System.out.println(element);
		}
    }
	
	private static <T extends Comparable<T>> T returnLargest(T[] elements){
		
		T largest = elements[0];
		
		for(T element : elements) {
			if(element.compareTo(largest) > 0) {
				largest = element;
			}
		}
		return largest;
    }
	
	private static <T> ArrayList<T> swapLastAndFirst(ArrayList<T> elements){
		
		T firstElement = elements.get(0);
		elements.set(0, elements.get(elements.size()-1));
		elements.set(elements.size()-1, firstElement);
	
		return elements;
	}
	
	private static <T extends Number> double sum(T[] elements){

		double sum = 0d;
		
		for(T element : elements) {
			sum += element.doubleValue();
		}
		return sum;
    }
	
}
