package interoperabilite.ldap.entities;

import java.util.ArrayList;

import interoperabilite.json.manager.JsonManager;
import interoperabilite.ldap.manager.LdapManager;

public class LdapConfiguration {

	private String ldapContextFactory;
	private String ldapBaseDN;
	private String ldapAuthentificationMode;
	private String ldapUser;
	private String ldapPassword;
	private String ldapServerUrl;

	public String getLdapContextFactory() {
		return ldapContextFactory;
	}
	public void setLdapContextFactory(String ldapContextFactory) {
		this.ldapContextFactory = ldapContextFactory;
	}
	public String getLdapBaseDN() {
		return ldapBaseDN;
	}
	public void setLdapBaseDN(String ldapBaseDN) {
		this.ldapBaseDN = ldapBaseDN;
	}
	public String getLdapAuthentificationMode() {
		return ldapAuthentificationMode;
	}
	public void setLdapAuthentificationMode(String ldapAuthentificationMode) {
		this.ldapAuthentificationMode = ldapAuthentificationMode;
	}
	public String getLdapUser() {
		return ldapUser;
	}
	public void setLdapUser(String ldapUser) {
		this.ldapUser = ldapUser;
	}
	public String getLdapPassword() {
		return ldapPassword;
	}
	public void setLdapPassword(String ldapPassword) {
		this.ldapPassword = ldapPassword;
	}
	public String getLdapServerUrl() {
		return ldapServerUrl;
	}
	public void setLdapServerUrl(String ldapServerUrl) {
		this.ldapServerUrl = ldapServerUrl;
	}

	private static LdapConfiguration INSTANCE = null;

	public static synchronized LdapConfiguration getInstance() {
		if (INSTANCE == null) {
			ArrayList<LdapConfiguration> configs = JsonManager.getInstance().<LdapConfiguration>readFromFile("configuration.json",".\\config\\",LdapConfiguration.class);
			for (LdapConfiguration ldapConfiguration : configs) {
				INSTANCE = ldapConfiguration;
			}
		}
		return INSTANCE;
	}

	private LdapConfiguration() {

	}
}
