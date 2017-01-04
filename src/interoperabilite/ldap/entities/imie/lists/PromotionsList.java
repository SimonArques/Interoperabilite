package interoperabilite.ldap.entities.imie.lists;

import interoperabilite.json.manager.JsonManager;
import interoperabilite.ldap.entities.imie.Promotion;

import java.util.ArrayList;

public class PromotionsList {
	private ArrayList<Promotion> promotions;

	public ArrayList<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(ArrayList<Promotion> promotions) {
		this.promotions = promotions;
	}

	private PromotionsList(){

	}

	/** Instance unique pré-initialisée */
	private static PromotionsList INSTANCE = new PromotionsList();

	/** Point d'accès pour l'instance unique du singleton */
	public static synchronized PromotionsList getInstance(){
		if (INSTANCE == null) {
			ArrayList<Promotion> promotions = JsonManager.getInstance().<Promotion>readFromFile("imiepromotions.json",".\\config\\imie\\",Promotion.class);
			INSTANCE = new PromotionsList();
			INSTANCE.setPromotions(promotions);
		}
		return INSTANCE;
	}
}
