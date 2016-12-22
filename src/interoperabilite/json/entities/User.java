package interoperabilite.json.entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class User {
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private String login;
	private String password;
	private Date lastconnection;
	private ArrayList<Document> documents;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getLastconnection() {
		return lastconnection;
	}
	public void setLastconnection(Date lastconnection) {
		this.lastconnection = lastconnection;
	}
	public ArrayList<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(ArrayList<Document> documents) {
		this.documents = documents;
	}

	public User addDocument(Document item){
		this.documents.add(item);
		return this;
	}

	public User(){
		this.documents = new ArrayList<Document>();
	}

	public User(String item){
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(org.codehaus.jackson.JsonGenerator.Feature.QUOTE_FIELD_NAMES, true);

		User user = null;

		try {
			user = mapper.readValue(item, User.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(user != null){
			this.id = user.id;
			this.firstname = user.firstname;
			this.lastname = user.lastname;
			this.email = user.email;
			this.login = user.login;
			this.password = user.password;
			this.lastconnection = user.lastconnection;
			this.documents = user.documents;
		}
	}

	public User(Integer id, String firstname, String lastname, String email,
			String login, String password, Date lastconnection,
			ArrayList<Document> documents) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.login = login;
		this.password = password;
		this.lastconnection = lastconnection;
		this.documents = documents;
	}

	@Override
	public String toString() {
		String result = "";
		result += this.id + "\n";
		result += this.firstname + "\n";
		result += this.lastname + "\n";
		result += this.email + "\n";
		result += this.login + "\n";
		result += this.password + "\n";
		result += this.lastconnection + "\n";
		for (Document document : documents) {
			result += document.toString();
		}
		return result;
	}
}
