package interoperabilite.ldap;

import java.util.ArrayList;

import interoperabilite.json.manager.JsonManager;
import interoperabilite.ldap.entities.LdapItem;
import interoperabilite.ldap.entities.imie.Promotion;
import interoperabilite.ldap.entities.imie.User;
import interoperabilite.ldap.manager.LdapManager;

public class Main {
	public static void main(String[] args) {
		// LdapManager.getInstance().request("OU=Utilisateurs,OU=Formation,OU=RENNES,OU=Sites");
		/*ArrayList<LdapItem> items = LdapManager.getInstance().requestInspector(
				"OU=CPCSI,OU=Eleves,OU=Utilisateurs,OU=Formation,OU=RENNES,OU=Sites", false);

		LdapManager.getInstance().getStudents();

		JsonManager.getInstance().clear();

		System.out.println("/////////////////////////");

		for (LdapItem ldapItem : items) {
			 JsonManager.getInstance().addItem(ldapItem);
			System.out.println("Name : " + ldapItem.getName() + "\n" + "ou : "
					+ ldapItem.getOu() + "\n" + "ouTree : "
					+ ldapItem.getOuTree());
			ldapItem.printRecLdapItem("  .");
		}

		 JsonManager.getInstance().sendToFile("ldap.json");
		OU=Eleves,OU=Utilisateurs,OU=Formation,OU=RENNES,OU=Sites
		OU=Formateurs_Externes,OU=Utilisateurs,OU=Formation,OU=RENNES,OU=Sites*/

		LdapManager.getInstance().requestInspector("OU=Sites", true);

		/*ArrayList<Promotion> items = LdapManager.getInstance().getAllPromotions("RENNES");

		for (Promotion promotion : items) {
			System.out.println(promotion.getName() + " : " + promotion.getYears() + " : " + promotion.getOu());
			LdapManager.getInstance().getStudentsByPromotion(promotion);
			for (User user : promotion.getUsers()) {
				System.out.println(user.getFirstname() +" : "+ user.getGuid());
			}
		}*/




		/*ArrayList<Promotion> promos = LdapManager.getInstance().getAllPromotions("RENNES");
		ArrayList<User> users = LdapManager.getInstance().getStudentsByPromotion(promos.get(1));
		LdapManager.getInstance().getStudentsByPromotion(promos.get(2));
		LdapManager.getInstance().getStudentsByPromotion(promos.get(3));
		LdapManager.getInstance().getStudentsByPromotion(promos.get(4));
		LdapManager.getInstance().getStudentsByPromotion(promos.get(5));

		for (Promotion promotion : promos) {
			System.out.println(promotion.getName() + " : " + promotion.getYears());
			for (User user : promotion.getUsers()) {
				System.out.println("  =>  " + user.getFirstname());
			}
		}

		ArrayList<Promotion> promos1 = LdapManager.getInstance().getPromotions("RENNES","2016-2018",null);

		for (Promotion promotion : promos1) {
			LdapManager.getInstance().getStudentsByPromotion(promotion);
			System.out.println(promotion.getName() + " : " + promotion.getYears());
			for (User user : promotion.getUsers()) {
				System.out.println("  =>  " + user.getFirstname());
			}
		}*/
	}

}
