package interoperabilite.ldap.manager;

import interoperabilite.ldap.entities.LdapConfiguration;
import interoperabilite.ldap.entities.LdapItem;
import interoperabilite.ldap.entities.imie.Promotion;
import interoperabilite.ldap.entities.imie.User;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class LdapManager {
	/*
	 * private final static String LDAP_CONTEXT_FACTORY =
	 * "com.sun.jndi.ldap.LdapCtxFactory"; private final static String
	 * LDAP_BASE_DN = "DC=Develo,DC=COM"; private final static String
	 * LDAP_AUTHENTICATION_MODE = "simple"; private final static String
	 * LDAP_USER = "Develo" + "\\" + "Administrateur"; private final static
	 * String LDAP_PASSWORD = "password"; private final static String
	 * LDAP_SERVER_URL = "LDAP://10.0.0.0:389";
	 */

	private LdapContext ctx;

	private Hashtable<String, String> env;

	private static LdapManager INSTANCE = new LdapManager();

	public static LdapManager getInstance() {
		return INSTANCE;
	}

	private LdapManager() {
		env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, LdapConfiguration
				.getInstance().getLdapContextFactory());
		env.put(Context.PROVIDER_URL, LdapConfiguration.getInstance()
				.getLdapServerUrl()
				+ "/"
				+ LdapConfiguration.getInstance().getLdapBaseDN());
		env.put(Context.SECURITY_AUTHENTICATION, LdapConfiguration
				.getInstance().getLdapAuthentificationMode());
		env.put(Context.SECURITY_PRINCIPAL, LdapConfiguration.getInstance()
				.getLdapUser());
		env.put(Context.SECURITY_CREDENTIALS, LdapConfiguration.getInstance()
				.getLdapPassword());
		env.put("java.naming.ldap.attributes.binary", "objectGUID");
	}

	public ArrayList<LdapItem> request(String ouSearch, Boolean isDebug) {
		try {
			ctx = new InitialLdapContext(env, null);

			// Filtre du LDAP
			NamingEnumeration<SearchResult> userAnswer = ctx.search(ouSearch,
					null);

			return itemExport(userAnswer, isDebug);

		} catch (NamingException e) {
			System.err.println("Problème de connexion");
			e.printStackTrace();
		} finally {
			try {
				ctx.close();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public ArrayList<LdapItem> requestInspector(String ouSearch, Boolean isDebug) {
		ArrayList<LdapItem> items = new ArrayList<LdapItem>();

		try {
			ctx = new InitialLdapContext(env, null);
			// Filtre du LDAP
			NamingEnumeration<SearchResult> userAnswer = ctx.search(ouSearch,
					null);

			items = itemExport(userAnswer, isDebug);

			ctx.close();

			for (LdapItem ldapItem : items) {
				ldapItem.setOuTree(ouSearch);
			}

			for (LdapItem ldapItem : items) {
				requestInspector(ldapItem, ldapItem.getOuTree(), isDebug);
			}

		} catch (NamingException e) {
			System.err.println("Problème de connexion");
			e.printStackTrace();
		}

		return items;
	}

	public void requestInspector(LdapItem item, String ouTree, Boolean isDebug) {
		try {
			if (item.getOu() != null && !item.getOu().equals("")) {
				ouTree = "OU=" + item.getOu() + "," + ouTree;
				item.setOuTree(ouTree);

				ctx = new InitialLdapContext(env, null);
				NamingEnumeration<SearchResult> userAnswer = ctx.search(ouTree,
						null);
				ctx.close();

				item.setSubItems(itemExport(userAnswer, isDebug));
				for (LdapItem ldapItem2 : item.getSubItems()) {
					requestInspector(ldapItem2, ouTree, isDebug);
				}
			}
		} catch (NamingException e) {
			System.err.println("Problème de connexion");
			e.printStackTrace();
		}
	}

	private ArrayList<LdapItem> itemExport(
			NamingEnumeration<SearchResult> userAnswer, Boolean isDebug)
			throws NamingException {

		ArrayList<LdapItem> toReturn = new ArrayList<LdapItem>();

		while (userAnswer.hasMoreElements()) {
			SearchResult sr = (SearchResult) userAnswer.next();
			Attributes attrs = sr.getAttributes();

			if (attrs != null) {
				LdapItem item = new LdapItem();
				try {
					// Récupération des attributs

					for (NamingEnumeration ae = attrs.getAll(); ae.hasMore();) {
						Attribute attr = (Attribute) ae.next();
						if (attr.getID().equals("sn")) {
							if (isDebug) {
								System.out.println("sn "
										+ attr.get(0).toString());
							}
							item.setSn(attr.get(0).toString());
						} else if (attr.getID().equals("cn")) {
							if (isDebug) {
								System.out.println("cn "
										+ attr.get(0).toString());
							}
							item.setCn(attr.get(0).toString());
						} else if (attr.getID().equals("displayName")) {
							if (isDebug) {
								System.out.println("displayName "
										+ attr.get(0).toString());
							}
							item.setDisplayName(attr.get(0).toString());
						} else if (attr.getID().equals("number")) {
							if (isDebug) {
								System.out.println("number "
										+ attr.get(0).toString());
							}
							item.setNumber(attr.get(0).toString());
						} else if (attr.getID().equals("value")) {
							if (isDebug) {
								System.out.println("value "
										+ attr.get(0).toString());
							}
							item.setValue(attr.get(0).toString());
						} else if (attr.getID().equals("name")) {
							if (isDebug) {
								System.out.println("name "
										+ attr.get(0).toString());
							}
							item.setName(attr.get(0).toString());
						} else if (attr.getID().equals("mail")) {
							if (isDebug) {
								System.out.println("mail "
										+ attr.get(0).toString());
							}
							item.setMail(attr.get(0).toString());
						} else if (attr.getID().equals("objectClass")) {
							if (isDebug) {
								System.out.println("objectClass "
										+ attr.get(0).toString());
							}
							item.getObjectClass().add((attr.get(0).toString()));
						} else if (attr.getID().equals("objectCategory")) {
							if (isDebug) {
								System.out.println("objectCategory "
										+ attr.get(0).toString());
							}
							item.setObjectCategory(attr.get(0).toString());
						} else if (attr.getID().equals("sAMAccountType")) {
							if (isDebug) {
								System.out.println("sAMAccountType "
										+ attr.get(0).toString());
							}
							item.setsAMAccountType(attr.get(0).toString());
						} else if (attr.getID().equals("description")) {
							if (isDebug) {
								System.out.println("description "
										+ attr.get(0).toString());
							}
							item.setDescription(attr.get(0).toString());
						} else if (attr.getID().equals("telephoneNumber")) {
							if (isDebug) {
								System.out.println("telephoneNumber "
										+ attr.get(0).toString());
							}
							item.setTelephoneNumber(attr.get(0).toString());
						} else if (attr.getID().equals("givenName")) {
							if (isDebug) {
								System.out.println("givenName "
										+ attr.get(0).toString());
							}
							item.setGivenName(attr.get(0).toString());
						} else if (attr.getID().equals("manager")) {
							if (isDebug) {
								System.out.println("manager "
										+ attr.get(0).toString());
							}
							item.setManager(attr.get(0).toString());
						} else if (attr.getID().equals("directReports")) {
							if (isDebug) {
								System.out.println("directReports "
										+ attr.get(0).toString());
							}
							item.setDirectReports(attr.get(0).toString());
						} else if (attr.getID().equals("proxyAddresses")) {
							if (isDebug) {
								System.out.println("proxyAddresses "
										+ attr.get(0).toString());
							}
							item.setProxyAddresses(attr.get(0).toString());
						} else if (attr.getID().equals("scriptPath")) {
							if (isDebug) {
								System.out.println("scriptPath "
										+ attr.get(0).toString());
							}
							item.setScriptPath(attr.get(0).toString());
						} else if (attr.getID().equals("sAMAccountName")) {
							if (isDebug) {
								System.out.println("sAMAccountName "
										+ attr.get(0).toString());
							}
							item.setsAMAccountName(attr.get(0).toString());
						} else if (attr.getID().equals("accountExpires")) {
							if (isDebug) {
								System.out.println("accountExpires "
										+ attr.get(0).toString());
							}
							item.setAccountExpires(attr.get(0).toString());
						} else if (attr.getID().equals("groupType")) {
							if (isDebug) {
								System.out.println("groupType "
										+ attr.get(0).toString());
							}
							item.setGroupType(attr.get(0).toString());
						} else if (attr.getID().equals("servicePrincipalName")) {
							if (isDebug) {
								System.out.println("servicePrincipalName "
										+ attr.get(0).toString());
							}
							item.setServicePrincipalName(attr.get(0).toString());
						} else if (attr.getID().equals("msNPAllowDialin")) {
							if (isDebug) {
								System.out.println("msNPAllowDialin "
										+ attr.get(0).toString());
							}
							item.setMsNPAllowDialin(attr.get(0).toString());
						} else if (attr.getID().equals("whenCreated")) {
							if (isDebug) {
								System.out.println("whenCreated "
										+ attr.get(0).toString());
							}
							item.setWhenCreated(attr.get(0).toString());
						} else if (attr.getID().equals("pwdLastSet")) {
							if (isDebug) {
								System.out.println("pwdLastSet "
										+ attr.get(0).toString());
							}
							item.setPwdLastSet(attr.get(0).toString());
						} else if (attr.getID().equals("primaryGroupID")) {
							if (isDebug) {
								System.out.println("primaryGroupID "
										+ attr.get(0).toString());
							}
							item.setPrimaryGroupID(attr.get(0).toString());
						} else if (attr.getID().equals("objectGUID")) {
							if (isDebug) {
								System.out.println("objectGUID "
										+ attr.get(0).toString());
							}
							item.setObjectGUID((byte[]) attr.get(0));
						} else if (attr.getID().equals("objectSID")) {
							if (isDebug) {
								System.out.println("objectSID "
										+ attr.get(0).toString());
							}
							item.setObjectSID(attr.get(0).toString());
						} else if (attr.getID().equals("operatingSystem")) {
							if (isDebug) {
								System.out.println("operatingSystem "
										+ attr.get(0).toString());
							}
							item.setOperatingSystem(attr.get(0).toString());
						} else if (attr.getID().equals("memberOf")) {
							if (isDebug) {
								System.out.println("memberOf "
										+ attr.get(0).toString());
							}
							item.setMemberOf(attr.get(0).toString());
						} else if (attr.getID().equals("ou")) {
							if (isDebug) {
								System.out.println("ou "
										+ attr.get(0).toString());
							}
							item.setOu(attr.get(0).toString());
						} else if (attr.getID().equals("dc")) {
							if (isDebug) {
								System.out.println("dc "
										+ attr.get(0).toString());
							}
							item.setDc(attr.get(0).toString());
						} else if (attr.getID().equals("anr")) {
							if (isDebug) {
								System.out.println("anr "
										+ attr.get(0).toString());
							}
							item.setAnr(attr.get(0).toString());
						} else if (attr.getID().equals(
								"isMemberOfPartialAttributeSet")) {
							if (isDebug) {
								System.out
										.println("isMemberOfPartialAttributeSet "
												+ attr.get(0).toString());
							}
							item.setIsMemberOfPartialAttributeSet(attr.get(0)
									.toString());
						} else if (attr.getID().equals("systemFlags")) {
							if (isDebug) {
								System.out.println("systemFlags "
										+ attr.get(0).toString());
							}
							item.setSystemFlags(attr.get(0).toString());
						} else if (attr.getID().equals("adminCount")) {
							if (isDebug) {
								System.out.println("adminCount "
										+ attr.get(0).toString());
							}
							item.setAdminCount(attr.get(0).toString());
						} else if (attr.getID().equals("fSMORoleOwner")) {
							if (isDebug) {
								System.out.println("fSMORoleOwner "
										+ attr.get(0).toString());
							}
							item.setfSMORoleOwner(attr.get(0).toString());
						} else {
							item.setOther(attr.get(0).toString());
							if (isDebug) {
								System.out.println("other "
										+ attr.get(0).toString());
							}
						}
					}

				} catch (NamingException e) {
					System.err.println("Défaut : " + e);
					e.printStackTrace();
				}
				toReturn.add(item);
			}
		}
		return toReturn;
	}

	public SearchResult findAccountByAccountName(String ldapSearchBase,
			String accountName) throws NamingException {

		String searchFilter = "(&(objectClass=user)(sAMAccountName="
				+ accountName + "))";

		SearchControls searchControls = new SearchControls();
		searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);

		NamingEnumeration<SearchResult> results = ctx.search(ldapSearchBase,
				searchFilter, searchControls);

		SearchResult searchResult = null;
		if (results.hasMoreElements()) {
			searchResult = (SearchResult) results.nextElement();

			// make sure there is not another item available, there should be
			// only 1 match
			if (results.hasMoreElements()) {
				System.err
						.println("Matched multiple users for the accountName: "
								+ accountName);
				return null;
			}
		}

		return searchResult;
	}

	public String findGroupBySID(String ldapSearchBase, String sid)
			throws NamingException {

		String searchFilter = "(&(objectClass=group)(objectSid=" + sid + "))";

		SearchControls searchControls = new SearchControls();
		searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);

		NamingEnumeration<SearchResult> results = ctx.search(ldapSearchBase,
				searchFilter, searchControls);

		if (results.hasMoreElements()) {
			SearchResult searchResult = (SearchResult) results.nextElement();

			// make sure there is not another item available, there should be
			// only 1 match
			if (results.hasMoreElements()) {
				System.err
						.println("Matched multiple groups for the group with SID: "
								+ sid);
				return null;
			} else {
				return (String) searchResult.getAttributes()
						.get("sAMAccountName").get();
			}
		}
		return null;
	}

	public String getPrimaryGroupSID(SearchResult srLdapUser)
			throws NamingException {
		byte[] objectSID = (byte[]) srLdapUser.getAttributes().get("objectSid")
				.get();
		String strPrimaryGroupID = (String) srLdapUser.getAttributes()
				.get("primaryGroupID").get();

		String strObjectSid = decodeSID(objectSID);

		return strObjectSid.substring(0, strObjectSid.lastIndexOf('-') + 1)
				+ strPrimaryGroupID;
	}

	/**
	 * The binary data is in the form: byte[0] - revision level byte[1] - count
	 * of sub-authorities byte[2-7] - 48 bit authority (big-endian) and then
	 * count x 32 bit sub authorities (little-endian)
	 *
	 * The String value is: S-Revision-Authority-SubAuthority[n]...
	 *
	 * Based on code from here -
	 * http://forums.oracle.com/forums/thread.jspa?threadID=1155740&tstart=0
	 */
	public static String decodeSID(byte[] sid) {

		final StringBuilder strSid = new StringBuilder("S-");

		// get version
		final int revision = sid[0];
		strSid.append(Integer.toString(revision));

		// next byte is the count of sub-authorities
		final int countSubAuths = sid[1] & 0xFF;

		// get the authority
		long authority = 0;
		// String rid = "";
		for (int i = 2; i <= 7; i++) {
			authority |= ((long) sid[i]) << (8 * (5 - (i - 2)));
		}
		strSid.append("-");
		strSid.append(Long.toHexString(authority));

		// iterate all the sub-auths
		int offset = 8;
		int size = 4; // 4 bytes for each sub auth
		for (int j = 0; j < countSubAuths; j++) {
			long subAuthority = 0;
			for (int k = 0; k < size; k++) {
				subAuthority |= (long) (sid[offset + k] & 0xFF) << (8 * k);
			}

			strSid.append("-");
			strSid.append(subAuthority);

			offset += size;
		}

		return strSid.toString();
	}

	public ArrayList<User> getStudentsByPromotion(Promotion promotion) {
		ArrayList<LdapItem> items = this.request(promotion.getOu(), false);

		for (LdapItem user_ldapitem : items) {
			promotion.getUsers().add(
					new User(0, user_ldapitem.getName(), user_ldapitem
							.getGivenName(), "", "", user_ldapitem
							.getObjectGUID(), null));
		}

		return promotion.getUsers();
	}

	public ArrayList<Promotion> getAllPromotions(String school) {
		String requestBase = "OU=Eleves,OU=Utilisateurs,OU=Formation,OU="
				+ school + ",OU=Sites";
		ArrayList<LdapItem> items = this.request(requestBase, false);

		ArrayList<Promotion> promotions = new ArrayList<Promotion>();

		for (LdapItem ldapItem : items) {
			String name = ldapItem.getName();
			String sub_request = "OU=" + ldapItem.getOu() + "," + requestBase;
			ArrayList<LdapItem> sub_items = this.request(sub_request, false);
			for (LdapItem sub_ldapItem : sub_items) {
				String years = sub_ldapItem.getName();
				Promotion promo = new Promotion(0, years, name);
				promo.setOu("OU=" + sub_ldapItem.getName() + "," + sub_request);
				promotions.add(promo);
			}
		}

		return promotions;
	}

	public ArrayList<Promotion> getPromotions(String school, String years,
			String promotion) {
		String requestBase = "OU=Eleves,OU=Utilisateurs,OU=Formation,OU="
				+ school + ",OU=Sites";
		ArrayList<LdapItem> items = this.request(requestBase, false);

		ArrayList<Promotion> promotions = new ArrayList<Promotion>();

		if (promotion.equals("") || promotion == null) {
			for (LdapItem ldapItem : items) {
					String name = ldapItem.getName();
					String sub_request = "OU=" + ldapItem.getOu() + ","
							+ requestBase;
					ArrayList<LdapItem> sub_items = this.request(sub_request,
							false);

					if (years.equals("") || years == null) {
						for (LdapItem sub_ldapItem : sub_items) {
							Promotion promo = new Promotion(0, years, name);
							promo.setOu("OU=" + sub_ldapItem.getName() + ","
									+ sub_request);
							promotions.add(promo);
						}
					} else {
						for (LdapItem sub_ldapItem : sub_items) {
							if (sub_ldapItem.getName().contains(years)) {
								Promotion promo = new Promotion(0, years, name);
								promo.setOu("OU=" + sub_ldapItem.getName()
										+ "," + sub_request);
								promotions.add(promo);
							}
						}
					}
			}
		} else {
			for (LdapItem ldapItem : items) {
				if (ldapItem.getName().contains(promotion)) {
					String name = ldapItem.getName();
					String sub_request = "OU=" + ldapItem.getOu() + ","
							+ requestBase;
					ArrayList<LdapItem> sub_items = this.request(sub_request,
							false);

					if (years.equals("") || years == null) {
						for (LdapItem sub_ldapItem : sub_items) {
							Promotion promo = new Promotion(0, years, name);
							promo.setOu("OU=" + sub_ldapItem.getName() + ","
									+ sub_request);
							promotions.add(promo);
						}
					} else {
						for (LdapItem sub_ldapItem : sub_items) {
							if (sub_ldapItem.getName().contains(years)) {
								Promotion promo = new Promotion(0, years, name);
								promo.setOu("OU=" + sub_ldapItem.getName()
										+ "," + sub_request);
								promotions.add(promo);
							}
						}
					}
				}
			}
		}

		return promotions;
	}
}