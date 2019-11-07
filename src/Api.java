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
		// ����������� �� �����. �� ����� ������ ����� �� ������� 0.
		while (true) {
			Scanner user_input = new Scanner(System.in);

			System.out.println("######---�������� Menu------------");
			System.out.println("######---������� 1--- ����� ���������� ");
			System.out.println("######---������� 2----��������� ����������");
			System.out.println("######---������� 3----SITE ����������");
			System.out.println("######---������� 4----EMAIL ����������");
			System.out.println("######---������� 5----������ ����������");
			System.out.println("######---������ �� 0");
			System.out.println("######---����� ��� �� ������������ ������� (1-10) ��� ������� ������ Enter.....");

			// ��������� ��� ���� ��� ��� ������
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

					// ������������ �� ��������� ����������� ��� �� �������������� ��� �������� ���
					// �� A

					NodeList myinfo = doc.getElementsByTagName("label");
					Node mynode = null;
					for (int j = 0; j < myinfo.getLength(); j++) {
						mynode = myinfo.item(j);
						System.out.print("To ����� ��� ���������� �����: ");
						System.out.println(mynode.getTextContent());
						System.out.println("-------------------------------------\n");
					}
					break;

				case 2:
					myinfo = doc.getElementsByTagName("category");
					mynode = null;
					for (int j = 0; j < myinfo.getLength(); j++) {
						mynode = myinfo.item(j);
						System.out.print("� ��������� ��� ���������� �����: ");
						System.out.println(mynode.getTextContent());
						System.out.println("-------------------------------------\n");
					}

					break;
				case 3:
					myinfo = doc.getElementsByTagName("website");
					mynode = null;
					for (int j = 0; j < myinfo.getLength(); j++) {
						mynode = myinfo.item(j);
						System.out.print("To website ��� ���������� �����: ");
						System.out.println(mynode.getTextContent());
						System.out.println("-------------------------------------\n");
					}
					break;
				case 4:
					myinfo = doc.getElementsByTagName("odeManagerEmail");
					mynode = null;
					for (int j = 0; j < myinfo.getLength(); j++) {
						mynode = myinfo.item(j);
						System.out.print("To email ��� ���������� �����: ");
						System.out.println(mynode.getTextContent());
						System.out.println("-------------------------------------\n");
					}
					break;
				case 5:
					myinfo = doc.getElementsByTagName("supervisorLabel");
					mynode = null;
					for (int j = 0; j < myinfo.getLength(); j++) {
						mynode = myinfo.item(j);
						System.out.print("O ������ ��� ���������� �����: ");
						System.out.println(mynode.getTextContent());
						System.out.println("-------------------------------------\n");
					}
					break;
				case 6:
					doc= db
					.parse(new URL("https://diavgeia.gov.gr/opendata/search?org=99206917").openStream());

					

					/*
					 * //������������ �� ������� �� Double, ������������� �� ���������� �� �������
					 * ������ ���� �� �����. double pages =
					 * Double.parseDouble(mynode.getTextContent()) / 100; int f_pages = (int)
					 * Math.ceil(pages);
					 * System.out.println("������� ������� �������������: "+f_pages);
					 * 
					 * String selection_pages = "1";
					 * 
					 * 
					 * int total_number = 0;
					 * 
					 * for(int y=0; y < f_pages ; y++ ) {
					 * 
					 * //������ ��� ��� ������ �� ����� 1 ��� �� ����� �� ������� 100 ������������
					 * System.out.
					 * println("######--- ������� �� 1 ��� Enter ��� �� ����������� �� 100 ������� ������������ | ������� x ��� Enter ��� ���������� ------"
					 * ); Scanner user_input2 = new Scanner(System.in); //��������� ��� ���� ��� ���
					 * ������ selection_pages = user_input2.next(); if(selection_pages.equals("1"))
					 * {
					 * 
					 * //������������ �� ��������� ����������� ��� �� �������������� ��� ��������
					 * ��� �� API //�������������� ��� ��������� page ��� �� ������� ��� ������ ���
					 * ������� DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
					 * DocumentBuilder db2 = dbf2.newDocumentBuilder(); Document doc2 =
					 * db2.parse(new URL(
					 * "https://diavgeia.gov.gr/opendata/search.xml?org=99206919&from_date=2018-03-11&page="
					 * +y).openStream());
					 * 
					 * //���������� �� XML tag ��� ��� ����������. ������������ ��� ����� ��� Nodes.
					 * //���� Node ���� ��� �� ����������� ��� tag ��� ���� �������. NodeList n1 =
					 * doc2.getElementsByTagName("subject");
					 * 
					 * //��������� ���-��� �� Nodes ��� ���������� �� ����������� ����. for(int n =0
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
	} // ����� ��� ����� While

}
