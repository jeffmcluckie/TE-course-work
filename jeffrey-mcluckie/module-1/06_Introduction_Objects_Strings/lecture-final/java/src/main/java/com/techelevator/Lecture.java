package com.techelevator;

import java.util.Locale;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */


		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();


		/* Other commonly used methods:
		 *
		 * endsWith *
		 * startsWith *
		 * indexOf
		 * lastIndexOf
		 * length *
		 * substring *
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

		// Play with some string methods. Woot!

		String message = "Java green is awesome!!!";
		System.out.println("The message is " + message.length() + " characters long");

		// What are my first/last characters
		System.out.println("Is the first character an A " + message.startsWith("A"));
		System.out.println("Is the last character an ! " + message.endsWith("!"));

		// Talk more about substring & immutability
		// Strings are immutable, the string methods don't change the string you call them on
		// They return back new Strings that you can save in a new variable
		String scream = message.toUpperCase();
		System.out.println("Scream the message " + scream);
		System.out.println("Whisper the message " + message.toLowerCase());

		// Pull apart the string
		System.out.println("What are the 5th-8th characters of message " + message.substring(5, 9));
		System.out.println("What are the 5th-8th characters of scream " + scream.substring(5, 9));

		// Strings are immutable, so our message doesn't change
		System.out.println("Message is now?" + message);

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

		String hello1 = new String("hello"); // uncommon syntax but needed for this example
		String hello2 = new String("hello"); // Check FunStuff for practical example

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

	}
}
