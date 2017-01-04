package interoperabilite.cour;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import interoperabilite.cour.User.Gender;
import interoperabilite.cour.User.Name;
import interoperabilite.json.manager.JsonManager;

public class Main {

	public static void main(String[] args) {
		////////////////////////////////////
//		User user = new User();
//		user.setGender(Gender.FEMALE);
//		Name name = new Name();
//		name.setFirst("dupon");
//		name.setLast("dupon");
//		user.setName(name);
//
//		System.out.println(user.toString());

		///////////////////////////////////

//		String jsonUser = "{"+
//				  "\"name\" : { \"first\" : \"Joe\", \"last\" : \"Sixpack\" },"+
//				  "\"gender\" : \"MALE\","+
//				  "\"verified\" : false,"+
//				  "\"userImage\" : \"Rm9vYmFyIQ==\""+
//				"}";
//
//		ObjectMapper mapper = new ObjectMapper();
//		User userFromJson = null;
//		try {
//			userFromJson = mapper.readValue(jsonUser, User.class);
//		} catch (JsonParseException e) {
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println(userFromJson);

		///////////////////////////////////

//		User userFromJsonFile = null;
//		try {
//			userFromJsonFile = mapper.readValue(new File(".\\json\\jsonUser1.json"), User.class);
//		} catch (JsonParseException e) {
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println(userFromJsonFile);

		///////////////////////////////////

//		UserList usersFromJsonFile1 = null;
//		try {
//			usersFromJsonFile1 = mapper.readValue(new File(".\\json\\jsonUsersListObject.json"), UserList.class);
//		} catch (JsonParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		for (User item : usersFromJsonFile1.users) {
//			System.out.println(item);
//		}

		///////////////////////////////////

//		ArrayList<User> usersFromJsonFile2 = null;
//		try {
//			usersFromJsonFile2 = mapper.readValue(new File(".\\json\\jsonUsersArray.json"),
//					mapper.getTypeFactory().constructCollectionType(
//							ArrayList.class, User.class));
//		} catch (JsonParseException e) {
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		for (User item : usersFromJsonFile2) {
//			System.out.println(item);
//		}

		///////////////////////////////////

		ArrayList<User> userForManager = new ArrayList<User>();
		userForManager.add(new User(Gender.MALE,"user1","last1",false,null));
		userForManager.add(new User(Gender.FEMALE,"user2","last2",false,null));
		userForManager.add(new User(Gender.MALE,"user3","last3",false,null));
		userForManager.add(new User(Gender.FEMALE,"user4","last4",false,null));
		userForManager.add(new User(Gender.MALE,"user5","last5",false,null));
		userForManager.add(new User(Gender.FEMALE,"user6","last6",false,null));

		JsonManager.getInstance().addItems(userForManager);
		JsonManager.getInstance().sendToFile("managerTest.json");

		ArrayList<User> userFromManager = JsonManager.getInstance().readFromFile("managerTest.json", User.class);

		for (User user : userFromManager) {
			System.out.println(user.toString());
		}
	}
}