import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Api {

	public static void main(String[] args) throws SAXException, ParserConfigurationException {
		// Εμφανίζουμε το μενού. Το μενού τρέχει μέχρι να δώσουμε 0.
		while (true) {
			Scanner user_input = new Scanner(System.in);

			System.out.println("######---Επιλογές Menu------------");
			System.out.println("######---Επιλογή 1--- ΟΝΟΜΑ ΟΡΓΑΝΙΣΜΟΥ ");
			System.out.println("######---Επιλογή 2----ΚΑΤΗΓΟΡΙΑ ΟΡΓΑΝΙΣΜΟΥ");
			System.out.println("######---Επιλογή 3----SITE ΟΡΓΑΝΙΣΜΟΥ");
			System.out.println("######---Επιλογή 4----EMAIL ΟΡΓΑΝΙΣΜΟΥ");
			System.out.println("######---Επιλογή 5----ΦΟΡΕΑΣ ΟΡΓΑΝΙΣΜΟΥ");
			System.out.println("######---Έξοδος με 0");
			System.out.println("######---Δώστε απο το πληκτρολόγιο επιλογή (1-10) και κατόπιν πιέστε Enter.....");

			// Παίρνουμε την τιμή από τον χρήστη
			String selection = user_input.next();
			int select = Integer.parseInt(selection);
			if (select==0) break;
			try {
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db
						.parse(new URL("https://diavgeia.gov.gr/opendata/organizations/99206917.xml").openStream());
				switch (select) {

				case 1:

					System.out.println(selection);

					// Δημιουργούμε τα κατάλληλα αντικείμενα για να διαχειριστούμε την απάντηση από
					// το A

					NodeList myinfo = doc.getElementsByTagName("label");
					Node mynode = null;
					for (int j = 0; j < myinfo.getLength(); j++) {
						mynode = myinfo.item(j);
						System.out.print("To όνομα του οργανισμού είναι: ");
						System.out.println(mynode.getTextContent());
						System.out.println("-------------------------------------\n");
					}
					break;

				case 2:
					myinfo = doc.getElementsByTagName("category");
					mynode = null;
					for (int j = 0; j < myinfo.getLength(); j++) {
						mynode = myinfo.item(j);
						System.out.print("Η κατηγορία του οργανισμού είναι: ");
						System.out.println(mynode.getTextContent());
						System.out.println("-------------------------------------\n");
					}

					break;
				case 3:
					myinfo = doc.getElementsByTagName("website");
					mynode = null;
					for (int j = 0; j < myinfo.getLength(); j++) {
						mynode = myinfo.item(j);
						System.out.print("To website του οργανισμού είναι: ");
						System.out.println(mynode.getTextContent());
						System.out.println("-------------------------------------\n");
					}
					break;
				case 4:
					myinfo = doc.getElementsByTagName("odeManagerEmail");
					mynode = null;
					for (int j = 0; j < myinfo.getLength(); j++) {
						mynode = myinfo.item(j);
						System.out.print("To email του οργανισμού είναι: ");
						System.out.println(mynode.getTextContent());
						System.out.println("-------------------------------------\n");
					}
					break;
				case 5:
					myinfo = doc.getElementsByTagName("supervisorLabel");
					mynode = null;
					for (int j = 0; j < myinfo.getLength(); j++) {
						mynode = myinfo.item(j);
						System.out.print("O φορέας του οργανισμού είναι: ");
						System.out.println(mynode.getTextContent());
						System.out.println("-------------------------------------\n");
					}
					break;
				case 6:
					doc= db
					.parse(new URL("https://diavgeia.gov.gr/opendata/search?org=99206917").openStream());

					

					/*
					 * //Μετατρέπουμε το κείμενο σε Double, στρογγυλοποιώ το αποτέλεσμα σε ακέραιο
					 * αριθμό προς τα επάνω. double pages =
					 * Double.parseDouble(mynode.getTextContent()) / 100; int f_pages = (int)
					 * Math.ceil(pages);
					 * System.out.println("Αριθμός Σελίδων αποτελέσματος: "+f_pages);
					 * 
					 * String selection_pages = "1";
					 * 
					 * 
					 * int total_number = 0;
					 * 
					 * for(int y=0; y < f_pages ; y++ ) {
					 * 
					 * //Ζητάμε από τον χρήστη να δώσει 1 για να πάρει τα επόμενα 100 αποτελέσματα
					 * System.out.
					 * println("######--- Πατήστε το 1 και Enter για να εμφανιστούν τα 100 επόμενα αποτελέσματα | Πατήστε x και Enter για τερματισμό ------"
					 * ); Scanner user_input2 = new Scanner(System.in); //Παίρνουμε την τιμή από τον
					 * χρήστη selection_pages = user_input2.next(); if(selection_pages.equals("1"))
					 * {
					 * 
					 * //Δημιουργούμε τα κατάλληλα αντικείμενα για να διαχειριστούμε την απάντηση
					 * από το API //Χρησιμοποιούμε την μεταβλητή page για να πάρουμε την σελίδα που
					 * θέλουμε DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
					 * DocumentBuilder db2 = dbf2.newDocumentBuilder(); Document doc2 =
					 * db2.parse(new URL(
					 * "https://diavgeia.gov.gr/opendata/search.xml?org=99206919&from_date=2018-03-11&page="
					 * +y).openStream());
					 * 
					 * //Επιλέγουμε το XML tag που μας ενδιαφέρει. Δημιουργούμε μια λίστα από Nodes.
					 * //Κάθε Node έχει και το περιεχόμενο του tag για κάθε απόφαση. NodeList n1 =
					 * doc2.getElementsByTagName("subject");
					 * 
					 * //Παίρνουμε ένα-ένα τα Nodes και προβάλουμε το περιεχόμενο τους. for(int n =0
					 * ; n < n1.getLength(); n++) { Node mynoded = n1.item(n);
					 * System.out.println("--- No: "+total_number+" ");
					 * System.out.println(mynoded.getTextContent());
					 * System.out.println("-------------------------------------"); total_number++;
					 * }//FOR }//IF else if(selection_pages.equals("x")) { break; }
					 * 
					 * 
					 * }//FOR
					 */

				}
			} catch (MalformedURLException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			}
		}
	} // Τέλος του Μενού While

}
