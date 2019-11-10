import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Api {

	public static void main(String[] args) throws SAXException, ParserConfigurationException, URISyntaxException {
		// Εμφανίζουμε το μενού. Το μενού τρέχει μέχρι να δώσουμε 0.
		while (true) {
			Scanner user_input = new Scanner(System.in);

			System.out.println("------------Επιλογές Menu------------");
			System.out.println("--Επιλογή 1--ΛΗΨΗ ΟΛΩΝ ΤΩΝ ΠΑΝΕΠΗΣΤΗΜΙΩΝ ΤΗΣ ΕΛΛΑΔΑΣ ");
			System.out.println("--Επιλογή 2--ΛΗΨΗ ΤΩΝ ΘΕΣΕΩΝ ΠΡΟΣΩΠΙΚΟΥ ΤΟΥ ΠΑ.ΜΑΚ.");
			System.out.println("--Επιλογή 3--ΛΗΨΗ ΒΑΣΙΚΩΝ ΠΛΗΡΟΦΟΡΙΩΝ ΓΙΑ ΤΟ ΠΑ.ΜΑΚ.");
			System.out.println("--Επιλογή 4--ΛΗΨΗ ΤΩΝ ΟΡΓΑΝΩΤΙΚΩΝ ΜΟΝΑΔΩΝ ΤΟΥ ΠΑ.ΜΑΚ.");
			System.out.println("--Επιλογή 5--ΛΗΨΗ ΤΩΝ ΥΠΟΓΡΑΦΟΝΤΩΝ ΤΟΥ ΠΑ.ΜΑΚ.");
			System.out.println(
					"--Επιλογή 6--ΛΗΨΗ ΤΩΝ 5 ΠΡΩΤΩΝ ΠΡΑΞΕΩΝ ΤΟΥ ΠΑ.ΜΑΚ. ΠΟΥ ΕΧΟΥΝ ΑΝΑΚΛΗΘΕΙ ΤΟ ΔΙΑΣΤΗΜΑ 20-01-2018 ΜΕ 20-01-2019. ");
			System.out.println(
					"--Επιλογή 7--ΛΗΨΗ ΤΩΝ ΠΡΑΞΕΩΝ ΤΟΥ ΠΑ.ΜΑΚ. ΠΟΥ ΕΧΟΥΝ ΥΠΟΓΕΓΡΑΦΕΙ ΑΠΟ ΣΥΓΚΕΚΡΙΜΕΝΟ ΥΠΟΓΡΑΦΟΝΤΑ (100005406) ΤΟ ΔΙΑΣΤΗΜΑ 20-01-2018 ΜΕ 20-02-2018 (2Η ΣΕΛΙΔΑ) ");
			System.out.println("--Επιλογή 8--ΛΗΨΗ ΤΗΣ ΠΡΑΞΗΣ 609Ν469Β7Ι-ΑΑ9 ΣΕ ΜΟΡΦΗ PDF. ");
			System.out.println("--Επιλογή 9--ΛΗΨΗ ΤΩΝ 50 ΠΡΩΤΩΝ ΧΡΗΜΑΤΙΚΩΝ ΕΝΤΑΛΜΑΤΩΝ ΤΟΥ ΟΡΓΑΝΙΣΜΟΥ ΠΟΥ ΕΠΙΘΥΜΕΙΤΕ. ");
			System.out.println("--Επιλογή 10--ΛΗΨΗ ΤΩΝ 10 ΜΕ ΣΕΙΡΑ ΣΧΕΤΙΚΟΤΗΤΑΣ ΠΡΑΞΕΩΝ ΤΥΠΟΥ Β.1.3 ΤΟΥ ΟΡΓΑΝΙΣΜΟΥ ΠΟΥ ΕΠΙΘΥΜΕΙΤΕ, ΤΟ ΔΙΑΣΤΗΜΑ 20-01-2018 ΜΕ 20-02-2018. ");
			System.out.println("--Έξοδος με 0--");
			System.out.println("######-Δώστε απο το πληκτρολόγιο επιλογή (1-10) και κατόπιν πιέστε Enter.....");

			// Παίρνουμε την τιμή από τον χρήστη
			String selection = user_input.next();
			int select = Integer.parseInt(selection);
			if (select == 0)
				break;
			try {
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = null;
				switch (select) {

				case 1:
					System.out.println(selection);
					doc = db.parse(new URL("https://diavgeia.gov.gr/opendata/organizations.xml?category=UNIVERSITY")
							.openStream());
					NodeList myinfo = doc.getElementsByTagName("label");
					Node mynode = null;
					System.out.println("Τα πανεπιστήμια της Ελλάδας είναι:");
					for (int j = 0; j < myinfo.getLength(); j++) {
						System.out.print(j + 1 + ") ");
						mynode = myinfo.item(j);
						System.out.println(mynode.getTextContent());
					}
					break;

				case 2:
					doc = db.parse(new URL("https://diavgeia.gov.gr/opendata/organizations/99206919/positions.xml")
							.openStream());
					myinfo = doc.getElementsByTagName("label");
					mynode = null;
					System.out.println("Οι θέσεις του διοικητικού προσωπικού του Πανεπιστημίου Μακεδονίας είναι:");
					for (int j = 0; j < myinfo.getLength(); j++) {
						System.out.print(j + 1 + ") ");
						mynode = myinfo.item(j);
						System.out.println(mynode.getTextContent());
					}

					break;
					
				case 3:
					doc = db.parse(new URL("https://diavgeia.gov.gr/opendata/organizations/99206919.xml").openStream());
					myinfo = doc.getElementsByTagName("label");
					NodeList myinfo1 = doc.getElementsByTagName("website");
					NodeList myinfo2 = doc.getElementsByTagName("odeManagerEmail");
					mynode = null;
					for (int j = 0; j < myinfo.getLength(); j++) {
						mynode = myinfo.item(j);
						System.out.println("Πληροφορίες του Πανεπιστημίου: ");
						System.out.print("Όνομα: ");
						System.out.println(mynode.getTextContent());
						mynode = myinfo1.item(j);
						System.out.print("Website: ");
						System.out.println(mynode.getTextContent());
						mynode = myinfo2.item(j);
						System.out.print("Email: ");
						System.out.println(mynode.getTextContent());
						System.out.println("------------------------------------------\n");
					}
					break;

				case 4:
					doc = db.parse(new URL(
							"https://diavgeia.gov.gr/opendata/organizations/99206919/units.xml?descendants=children")
									.openStream());
					myinfo = doc.getElementsByTagName("label");
					myinfo1 = doc.getElementsByTagName("category");
					mynode = null;
					System.out.println("Οι οργανωτικοί φορείς του ΠΑ.ΜΑΚ. είναι: ");
					for (int j = 0; j < myinfo.getLength(); j++) {
						mynode = myinfo.item(j);
						System.out.print("Όνομα: ");
						System.out.println(mynode.getTextContent());
						mynode = myinfo1.item(j);
						System.out.print("Κατηγορία: ");
						System.out.println(mynode.getTextContent());
						System.out.println("------------------------------------------\n");
					}
					break;

				case 5:
					doc = db.parse(new URL("https://diavgeia.gov.gr/opendata/organizations/99206919/signers.xml")
							.openStream());
					myinfo = doc.getElementsByTagName("firstName");
					myinfo1 = doc.getElementsByTagName("lastName");
					System.out.println("Οι υπογράφοντες του ΠΑ.ΜΑΚ είναι:");
					mynode = null;
					for (int j = 0; j < myinfo.getLength(); j++) {
						mynode = myinfo.item(j);
						System.out.print("Όνομα: ");
						System.out.println(mynode.getTextContent());
						mynode = myinfo1.item(j);
						System.out.print("Επώνυμο: ");
						System.out.println(mynode.getTextContent());
						System.out.println("------------------------------------------\n");
					}
					break;

				case 6:
					doc = db.parse(new URL(
							"https://diavgeia.gov.gr/opendata/search.xml?org=99206919&from_date=2018-01-20&to_date=2019-01-20&status=revoked&size=5")
									.openStream());
					myinfo = doc.getElementsByTagName("subject");
					mynode = null;
					System.out.println("Θέματολογία όλων των πράξεων του ΠΑ.ΜΑΚ. που έχουν ανακληθεί: \n");
					for (int j = 0; j < myinfo.getLength(); j++) {
						System.out.println("No" + (j + 1) + ":");
						mynode = myinfo.item(j);
						System.out.println(mynode.getTextContent());
						System.out.println("------------------------------------------\n");
					}
					break;

				case 7:
					doc = db.parse(new URL(
							"https://diavgeia.gov.gr/opendata/search.xml?org=99206919&from_date=2018-01-20&to_date=2018-02-20&signer=100005406&page=2")
									.openStream());
					myinfo = doc.getElementsByTagName("subject");
					mynode = null;
					System.out
							.println("2η σελίδα με πράξεις που έχουν υπογεγραφεί από τον υπογραφέα με id=100005406: ");
					for (int j = 0; j < myinfo.getLength(); j++) {
						System.out.println("No" + (j + 1) + ":");
						mynode = myinfo.item(j);
						System.out.println(mynode.getTextContent());
						System.out.println("------------------------------------------\n");
					}
					break;

				case 8:
					doc = db.parse(
							new URL("https://diavgeia.gov.gr/opendata/search.xml?org=99206919&ada=609Ν469Β7Ι-ΑΑ9")
									.openStream());
					myinfo = doc.getElementsByTagName("documentUrl");
					mynode = null;
					System.out.println("Ανακατεύθυνση στον σύνδεσμο λήψης της πράξης 609Ν469Β7Ι-ΑΑ9:");
					for (int j = 0; j < myinfo.getLength(); j++) {
						mynode = myinfo.item(j);
						System.out.println(mynode.getTextContent() + "\n");
						if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
							Desktop.getDesktop().browse(new URI(mynode.getTextContent()));
						}
					}
					break;

				case 9:
					System.out.println(
							"Παρακαλώ δώστε τον οργανισμό για τον οποίο θέλετε να δείτε τις πράξεις με θέμα:Χρηματικό Ένταλμα (πχ 99206919)");
					String orgNum = user_input.next();
					doc = db.parse(new URL("https://diavgeia.gov.gr/opendata/search.xml?org=" + orgNum
							+ "&subject=Χρηματικό%20Ένταλμα&size=50").openStream());
					String orgName = null;
					Document doc2 = db.parse(
							new URL("https://diavgeia.gov.gr/opendata/organizations/" + orgNum + ".xml").openStream());
					myinfo = doc2.getElementsByTagName("label");
					for (int j = 0; j < myinfo.getLength(); j++) {
						mynode = myinfo.item(j);
						orgName = mynode.getTextContent();
					}
					myinfo = doc.getElementsByTagName("ada");
					myinfo2 = doc.getElementsByTagName("issueDate");
					mynode = null;
					System.out.println("Πληροφορίες για τα χρηματικά εντάλματα του οργανισμού " + orgName + ":");
					for (int j = 0; j < myinfo.getLength(); j++) {
						System.out.println("No" + (j + 1) + ":");
						mynode = myinfo.item(j);
						System.out.print("Ο κωδικός του χρηματικού εντάλματος είναι: ");
						System.out.println(mynode.getTextContent());
						mynode = myinfo2.item(j);
						System.out.print("Η ημερομηνία έκδοσης του εντάλματος είναι: ");
						System.out.println(mynode.getTextContent());
						System.out.println("------------------------------------------");
					}
					break;

				case 10:
					System.out.println(
							"Παρακαλώ δώστε τον οργανισμό για τον οποίο θέλετε να δείτε τις πράξεις τύπου Β.1.3 με σχετική σειρά (πχ 99206919)");
					orgNum = user_input.next();
					doc = db.parse(new URL("https://diavgeia.gov.gr/opendata/search.xml?org=" + orgNum +"&type=Β.1.3&from_date=2018-01-20&to_date=2018-02-20&size=10")
							.openStream());
					
					orgName = null;
					doc2 = db.parse(
							new URL("https://diavgeia.gov.gr/opendata/organizations/" + orgNum + ".xml").openStream());
					myinfo = doc2.getElementsByTagName("label");
					for (int j = 0; j < myinfo.getLength(); j++) {
						mynode = myinfo.item(j);
						orgName = mynode.getTextContent();
					}
					
					myinfo = doc.getElementsByTagName("ada");
					myinfo1= doc.getElementsByTagName("url");
					mynode = null;
					System.out.println("Πληροφορίες πράξεων Β.1.3 για τον οργανισμό: " + orgName);
					for (int j = 0; j < myinfo.getLength(); j++) {
						System.out.println("No" + (j + 1) + ":");
						mynode = myinfo.item(j);
						System.out.print("Ο κωδικός της πράξης είναι: ");
						System.out.println(mynode.getTextContent());
						mynode = myinfo1.item(j);
						System.out.print("Ο σύνδεσμος για περαιτέρω λεπτομέριες της πράξης είναι: ");
						System.out.println(mynode.getTextContent());
						System.out.println("------------------------------------------");
					}
				}

			} catch (MalformedURLException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			}
		}
	} // Τέλος του Μενού While
}
