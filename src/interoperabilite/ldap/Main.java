package interoperabilite.ldap;

import java.util.ArrayList;

import interoperabilite.ldap.entities.LdapItem;
import interoperabilite.ldap.manager.LdapManager;

public class Main {
	public static void main(String[] args) {
		//LdapManager.getInstance().request("OU=Utilisateurs,OU=Formation,OU=RENNES,OU=Sites");
		ArrayList<LdapItem> items = LdapManager.getInstance().requestInspector("OU=Sites");

		for (LdapItem ldapItem : items) {
			System.out.println("Name : "+ ldapItem.getName() +"\n  ou : "+ldapItem.getOu() + "\n    ouTree : "+ ldapItem.getOuTree());
		}
	}
}
