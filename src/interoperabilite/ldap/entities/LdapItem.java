package interoperabilite.ldap.entities;

import java.util.ArrayList;

public class LdapItem {
	private String sn;
	private String servicePrincipalName;
	private String groupType;
	private String accountExpires;
	private String sAMAccountName;
	private String scriptPath;
	private String proxyAddresses;
	private String directReports;
	private String manager;
	private String givenName;
	private String telephoneNumber;
	private String description;
	private String sAMAccountType;
	private String objectCategory;
	private ArrayList<String> objectClass;
	private String mail;
	private String name;
	private String value;
	private String number;
	private String displayName;
	private String cn;
	private String other;
	private String fSMORoleOwner;
	private String adminCount;
	private String systemFlags;
	private String isMemberOfPartialAttributeSet;
	private String dc;
	private String ou;
	private String memberOf;
	private String operatingSystem;
	private String objectSID;
	private byte[] objectGUID;
	private String primaryGroupID;
	private String pwdLastSet;
	private String whenCreated;
	private String msNPAllowDialin;
	private String anr;
	private String ouTree;

	private ArrayList<LdapItem> subItems;

	public String getOuTree() {
		return ouTree;
	}

	public void setOuTree(String ouTree) {
		this.ouTree = ouTree;
	}

	public String getAnr() {
		return anr;
	}

	public void setAnr(String anr) {
		this.anr = anr;
	}

	public ArrayList<LdapItem> getSubItems() {
		return subItems;
	}

	public void setSubItems(ArrayList<LdapItem> subItems) {
		this.subItems = subItems;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getServicePrincipalName() {
		return servicePrincipalName;
	}

	public void setServicePrincipalName(String servicePrincipalName) {
		this.servicePrincipalName = servicePrincipalName;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public String getAccountExpires() {
		return accountExpires;
	}

	public void setAccountExpires(String accountExpires) {
		this.accountExpires = accountExpires;
	}

	public String getsAMAccountName() {
		return sAMAccountName;
	}

	public void setsAMAccountName(String sAMAccountName) {
		this.sAMAccountName = sAMAccountName;
	}

	public String getScriptPath() {
		return scriptPath;
	}

	public void setScriptPath(String scriptPath) {
		this.scriptPath = scriptPath;
	}

	public String getProxyAddresses() {
		return proxyAddresses;
	}

	public void setProxyAddresses(String proxyAddresses) {
		this.proxyAddresses = proxyAddresses;
	}

	public String getDirectReports() {
		return directReports;
	}

	public void setDirectReports(String directReports) {
		this.directReports = directReports;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getsAMAccountType() {
		return sAMAccountType;
	}

	public void setsAMAccountType(String sAMAccountType) {
		this.sAMAccountType = sAMAccountType;
	}

	public String getObjectCategory() {
		return objectCategory;
	}

	public void setObjectCategory(String objectCategory) {
		this.objectCategory = objectCategory;
	}

	public ArrayList<String> getObjectClass() {
		return objectClass;
	}

	public void setObjectClass(ArrayList<String> objectClass) {
		this.objectClass = objectClass;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getfSMORoleOwner() {
		return fSMORoleOwner;
	}

	public void setfSMORoleOwner(String fSMORoleOwner) {
		this.fSMORoleOwner = fSMORoleOwner;
	}

	public String getAdminCount() {
		return adminCount;
	}

	public void setAdminCount(String adminCount) {
		this.adminCount = adminCount;
	}

	public String getSystemFlags() {
		return systemFlags;
	}

	public void setSystemFlags(String systemFlags) {
		this.systemFlags = systemFlags;
	}

	public String getIsMemberOfPartialAttributeSet() {
		return isMemberOfPartialAttributeSet;
	}

	public void setIsMemberOfPartialAttributeSet(
			String isMemberOfPartialAttributeSet) {
		this.isMemberOfPartialAttributeSet = isMemberOfPartialAttributeSet;
	}

	public String getDc() {
		return dc;
	}

	public void setDc(String dc) {
		this.dc = dc;
	}

	public String getOu() {
		return ou;
	}

	public void setOu(String ou) {
		this.ou = ou;
	}

	public String getMemberOf() {
		return memberOf;
	}

	public void setMemberOf(String memberOf) {
		this.memberOf = memberOf;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getObjectSID() {
		return objectSID;
	}

	public void setObjectSID(String objectSID) {
		this.objectSID = objectSID;
	}

	public byte[] getObjectGUID() {
		return objectGUID;
	}

	public void setObjectGUID(byte[] objectGUID) {
		this.objectGUID = objectGUID;
	}

	public String getPrimaryGroupID() {
		return primaryGroupID;
	}

	public void setPrimaryGroupID(String primaryGroupID) {
		this.primaryGroupID = primaryGroupID;
	}

	public String getPwdLastSet() {
		return pwdLastSet;
	}

	public void setPwdLastSet(String pwdLastSet) {
		this.pwdLastSet = pwdLastSet;
	}

	public String getWhenCreated() {
		return whenCreated;
	}

	public void setWhenCreated(String whenCreated) {
		this.whenCreated = whenCreated;
	}

	public String getMsNPAllowDialin() {
		return msNPAllowDialin;
	}

	public void setMsNPAllowDialin(String msNPAllowDialin) {
		this.msNPAllowDialin = msNPAllowDialin;
	}

	public LdapItem addItem(LdapItem item) {
		this.subItems.add(item);
		return this;
	}

	public LdapItem() {
		this.subItems = new ArrayList<LdapItem>();
		this.objectClass = new ArrayList<String>();
	}

	public void printRecLdapItem(String sep){
		this.printRecLdapItem(this.getSubItems(),sep);
	}

	private void printRecLdapItem(ArrayList<LdapItem> items, String sep){
		System.out.println("//////////");
		for (LdapItem item : items) {
			System.out.println(sep + "Name : " + item.getName() + "\n"+ sep +"ou : "
					+ item.getOu() + "\n"+sep+"ouTree : "
					+ item.getOuTree());
			if (!item.getSubItems().isEmpty()) {
				sep += "  .";
				printRecLdapItem(item.getSubItems(), sep);
			}
		}
	}
}