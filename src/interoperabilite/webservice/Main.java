package interoperabilite.webservice;

import interoperabilite.webservice.manager.HtmlPageSaver;
import interoperabilite.webservice.manager.HttpClientManager;

public class Main {

	public static void main(String[] args) {
		/* Web management */
		webManagement();

		/* Rest management */

	}

	public static void webManagement(){
		/* Web management */
		HttpClientManager manager = new HttpClientManager("127.0.0.1","1212");
		System.out.println(manager.GetHttpStringItem());

		System.out.println("//////////////////////");

		HtmlPageSaver saver = new HtmlPageSaver();
		HttpClientManager manager1 = new HttpClientManager("fr.wikipedia.org/wiki/Representational_state_transfer#Assimilation_.C3.A0_un_protocole_ou_un_format");
		saver.SaveHtmlToFile(manager1.GetHttpStringItem());
		saver.LaunchHtmlFile();

		System.out.println("//////////////////////");

		HttpClientManager manager2 = new HttpClientManager("http://www-inf.it-sudparis.eu/cours/WebServices/Docs/Bob_WS-1.pdf");
		manager2.GetHttpPdfItem("dl1");

		System.out.println("//////////////////////");

		byte[] pdf = manager2.LoadLocalPdf("C:\\Users\\tactfactory\\workspaceLuna\\Interoperabilite\\download\\dl1.pdf");
		manager2.saveByteArrayPdf(pdf, "myByteArray");
	}
}
