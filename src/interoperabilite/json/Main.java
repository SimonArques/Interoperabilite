package interoperabilite.json;

import java.util.ArrayList;
import java.util.Date;
import interoperabilite.json.entities.Document;
import interoperabilite.json.entities.User;
import interoperabilite.json.manager.JsonManager;

public class Main {

	public static void main(String[] args) {

		userCreation();
		documentCreation();

		userExtraction();
		documentExtraction();
	}

	private static void documentExtraction() {
		ArrayList<Document> extracteds = new ArrayList<Document>();
		extracteds = JsonManager.getInstance().<Document> readFromFile(
				"test2.json", Document.class);
		System.out.println("Extracted " + extracteds);

		for (Document item : extracteds) {
			System.out.println("////////////////");
			System.out.println(item);
			System.out.println("////////////////");
		}
	}

	private static void documentCreation() {
		Document docItem1 = new Document(3, "doc3", "tutute");
		JsonManager.getInstance().clear().addItem(docItem1)
				.sendToFile("test2.json");
	}

	private static void userExtraction() {
		ArrayList<User> extracteds = new ArrayList<User>();
		extracteds = JsonManager.getInstance().<User> readFromFile(User.class);

		for (User item : extracteds) {
			System.out.println("////////////////");
			System.out.println(item.toString());
			System.out.println("////////////////");
		}
	}

	private static void userCreation() {
		User user1 = new User(1, "jean", "piere", "jeanpierre@gmail.com",
				"jeanjean", "password1!", new Date(), new ArrayList<Document>());
		user1.addDocument(new Document(1, "doc1", "http://mydoc.com/doc"))
				.addDocument(new Document(2, "doc2", "http://mydoc2.com/doc"));

		User user2 = new User(2, "yvi", "po", "ypo@gmail.com", "yvipo",
				"password2!", new Date(), new ArrayList<Document>());
		user2.addDocument(new Document(1, "myDoc", "http://mydoc.com/doc"))
				.addDocument(
						new Document(2, "otherDoc", "http://mydoc2.com/doc"));

		ArrayList<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);

		for (User user : users) {
			System.out.println("////////////////");
			System.out.println(user.toString());
			System.out.println("////////////////");
			System.out
					.println(JsonManager.getInstance().addItem(user).toJSON());
			System.out.println("////////////////");
		}

		JsonManager.getInstance().sendToFile();
	}
}
