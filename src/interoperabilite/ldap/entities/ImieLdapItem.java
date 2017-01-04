package interoperabilite.ldap.entities;

import java.util.ArrayList;

public class ImieLdapItem {
	private String cn;
	private String instanceType;
	private String nTSecurityDescriptor;
	private String objectCategory;
	private ArrayList<String> objectClass;
	private String accountExpires;
	private String badPasswordTime;
	private String badPwdCount;
	private String codePage;
	private String countryCode;
	private String displayName;
	private String distinguishedName;
	private ArrayList<String> dSCorePropagationData;
	private String givenName;
	private String lastLogoff;
	private String lastLogon;
	private String lastLogonTimestamp;
	private String logonCount;
	private String mail;
	private String memberOf;
	private String msDSSupportedEncryptionTypes;//"msDS-SupportedEncryptionTypes"
	private String name;
	private String objectGUID;
	private String objectSid;
	private String primaryGroupID;
	private String pwdLastSet;
	private String sAMAccountName;
	private String sAMAccountType;
	private String sn;
	private String userAccountControl;
	private String userPrincipalName;
	private String uSNChanged;
	private String uSNCreated;
	private String whenChanged;
	private String whenCreated;
	private String aCSPolicyName;
	private String adminCount;
	private String adminDescription;
	private String adminDisplayName;
	private String allowedAttributes;
	private String allowedAttributesEffective;
	private String allowedChildClasses;
	private String allowedChildClassesEffective;
	private String assistant;
	private String attributeCertificateAttribute;
	private String audio;
	private String bridgeheadServerListBL;
	private String businessCategory;
	private String c;
	/*canonicalName
	carLicense
	co
	comment
	company
	controlAccessRights
	createTimeStamp
	dBCSPwd
	defaultClassStore
	department
	departmentNumber
	description
	desktopProfile
	destinationIndicator
	directReports
	displayNamePrintable
	division
	dSASignature
	dynamicLDAPServer
	employeeID
	employeeNumber
	employeeType
	extensionName
	facsimileTelephoneNumber
	flags
	fromEntry
	frsComputerReferenceBL
	fRSMemberReferenceBL
	fSMORoleOwner
	generationQualifier
	groupMembershipSAM
	groupPriority
	groupsToIgnore
	homeDirectory
	homeDrive
	homePhone
	homePostalAddress
	houseIdentifier
	initials
	internationalISDNNumber
	ipPhone
	isCriticalSystemObject
	isDeleted
	isPrivilegeHolder
	isRecycled
	jpegPhoto
	l
	labeledURI
	lastKnownParent
	lmPwdHistory
	localeID
	lockoutTime
	logonHours
	logonWorkstation
	managedObjects
	manager
	masteredBy
	maxStorage
	mhsORAddress
	middleName
	mobile
	modifyTimeStamp
	msCOM-PartitionSetLink
	msCOM-UserLink
	msCOM-UserPartitionSetLink
	msDFSR-ComputerReferenceBL
	msDFSR-MemberReferenceBL
	msDRM-IdentityCertificate
	msDS-AllowedToActOnBehalfOfOtherIdentity
	msDS-AllowedToDelegateTo
	msDS-Approx-Immed-Subordinates
	msDS-AssignedAuthNPolicy
	msDS-AssignedAuthNPolicySilo
	msDS-AuthenticatedAtDC
	msDS-AuthenticatedToAccountlist
	msDS-AuthNPolicySiloMembersBL
	msDS-Cached-Membership
	msDS-Cached-Membership-Time-Stamp
	msDS-ClaimSharesPossibleValuesWithBL
	mS-DS-ConsistencyChildCount
	mS-DS-ConsistencyGuid
	mS-DS-CreatorSID
	msDS-EnabledFeatureBL
	msDS-FailedInteractiveLogonCount
	msDS-FailedInteractiveLogonCountAtLastSuccessfulLogon
	msDS-HABSeniorityIndex
	msDS-HostServiceAccountBL
	msDS-IsDomainFor
	msDS-IsFullReplicaFor
	msDS-IsPartialReplicaFor
	msDS-IsPrimaryComputerFor
	msDS-KrbTgtLinkBl
	msDS-LastFailedInteractiveLogonTime
	msDS-LastKnownRDN
	msDS-LastSuccessfulInteractiveLogonTime
	msDS-LocalEffectiveDeletionTime
	msDS-LocalEffectiveRecycleTime
	msDs-masteredBy
	msds-memberOfTransitive
	msDS-MembersForAzRoleBL
	msDS-MembersOfResourcePropertyListBL
	msds-memberTransitive
	msDS-NCReplCursors
	msDS-NCReplInboundNeighbors
	msDS-NCReplOutboundNeighbors
	msDS-NC-RO-Replica-Locations-BL
	msDS-NcType
	msDS-NonMembersBL
	msDS-ObjectReferenceBL
	msDS-OIDToGroupLinkBl
	msDS-OperationsForAzRoleBL
	msDS-OperationsForAzTaskBL
	msDS-parentdistname
	msDS-PhoneticCompanyName
	msDS-PhoneticDepartment
	msDS-PhoneticDisplayName
	msDS-PhoneticFirstName
	msDS-PhoneticLastName
	msDS-PrimaryComputer
	msDS-PrincipalName
	msDS-PSOApplied
	msDS-ReplAttributeMetaData
	msDS-ReplValueMetaData
	msDS-ReplValueMetaDataExt
	msDS-ResultantPSO
	msDS-RevealedDSAs
	msDS-RevealedListBL
	msDS-SecondaryKrbTgtNumber
	msDS-Site-Affinity
	msDS-SourceObjectDN
	msDS-SyncServerUrl
	msDS-TasksForAzRoleBL
	msDS-TasksForAzTaskBL
	msDS-TDOEgressBL
	msDS-TDOIngressBL
	msDS-User-Account-Control-Computed
	msDS-UserPasswordExpiryTimeComputed
	msDS-ValueTypeReferenceBL
	msExchHouseIdentifier
	msIIS-FTPDir
	msIIS-FTPRoot
	mSMQDigests
	mSMQDigestsMig
	mSMQSignCertificates
	mSMQSignCertificatesMig
	msNPAllowDialin
	msNPCallingStationID
	msNPSavedCallingStationID
	msPKIAccountCredentials
	msPKI-CredentialRoamingTokens
	msPKIDPAPIMasterKeys
	msPKIRoamingTimeStamp
	msRADIUSCallbackNumber
	msRADIUS-FramedInterfaceId
	msRADIUSFramedIPAddress
	msRADIUS-FramedIpv6Prefix
	msRADIUS-FramedIpv6Route
	msRADIUSFramedRoute
	msRADIUS-SavedFramedInterfaceId
	msRADIUS-SavedFramedIpv6Prefix
	msRADIUS-SavedFramedIpv6Route
	msRADIUSServiceType
	msRASSavedCallbackNumber
	msRASSavedFramedIPAddress
	msRASSavedFramedRoute
	msSFU30Name
	msSFU30NisDomain
	msSFU30PosixMemberOf
	msTSAllowLogon
	msTSBrokenConnectionAction
	msTSConnectClientDrives
	msTSConnectPrinterDrives
	msTSDefaultToMainPrinter
	msTSExpireDate
	msTSExpireDate2
	msTSExpireDate3
	msTSExpireDate4
	msTSHomeDirectory
	msTSHomeDrive
	msTSInitialProgram
	msTSLicenseVersion
	msTSLicenseVersion2
	msTSLicenseVersion3
	msTSLicenseVersion4
	msTSLSProperty01
	msTSLSProperty02
	msTSManagingLS
	msTSManagingLS2
	msTSManagingLS3
	msTSManagingLS4
	msTSMaxConnectionTime
	msTSMaxDisconnectionTime
	msTSMaxIdleTime
	msTSPrimaryDesktop
	msTSProfilePath
	msTSProperty01
	msTSProperty02
	msTSReconnectionAction
	msTSRemoteControl
	msTSSecondaryDesktops
	msTSWorkDirectory
	netbootSCPBL
	networkAddress
	nonSecurityMemberBL
	ntPwdHistory
	o
	objectVersion
	operatorCount
	otherFacsimileTelephoneNumber
	otherHomePhone
	otherIpPhone
	otherLoginWorkstations
	otherMailbox
	otherMobile
	otherPager
	otherTelephone
	otherWellKnownObjects
	ou
	ownerBL
	pager
	partialAttributeDeletionList
	partialAttributeSet
	personalTitle
	photo
	physicalDeliveryOfficeName
	possibleInferiors
	postalAddress
	postalCode
	postOfficeBox
	preferredDeliveryMethod
	preferredLanguage
	preferredOU
	primaryInternationalISDNNumber
	primaryTelexNumber
	profilePath
	proxiedObjectName
	proxyAddresses
	queryPolicyBL
	registeredAddress
	replPropertyMetaData
	replUpToDateVector
	repsFrom
	repsTo
	revision
	roomNumber
	scriptPath
	sDRightsEffective
	secretary
	seeAlso
	serialNumber
	serverReferenceBL
	servicePrincipalName
	showInAdvancedViewOnly
	siteObjectBL
	st
	street
	streetAddress
	structuralObjectClass
	subRefs
	subSchemaSubEntry
	systemFlags
	telephoneNumber
	teletexTerminalIdentifier
	telexNumber
	terminalServer
	thumbnailLogo
	thumbnailPhoto
	title
	uid
	unicodePwd
	url
	userCertificate
	userParameters
	userPassword
	userPKCS12
	userSharedFolder
	userSharedFolderOther
	userSMIMECertificate
	userWorkstations
	uSNDSALastObjRemoved
	USNIntersite
	uSNLastObjRem
	uSNSource
	wbemPath
	wellKnownObjects
	wWWHomePage
	x121Address
	x500uniqueIdentifier*/
}
