package org.bandahealth.idempiere.graphql.model.input;

import java.sql.Timestamp;
import org.compiere.model.I_AD_User;

/**
 * Generated Interface for AD_User - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_UserInput extends I_AD_User {

	/**
	 * Set AD_Image.
	 *
	 * @param AD_Image Image or Icon
	 */
	void setAD_ImageInput(ForeignEntityInput AD_Image);

	/**
	 * Get AD_Image.
	 *
	 * @return Image or Icon
	 */
	ForeignEntityInput AD_Image();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within tenant
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	void setUUID(String UUID);

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	String getUUID();

	/**
	 * Set AuthenticationType.
	 *
	 * @param AuthenticationType AuthenticationType
	 */
	void setAuthenticationTypeInput(I_AD_Ref_ListInput AuthenticationType);

	/**
	 * Get AuthenticationType.
	 *
	 * @return AuthenticationType
	 */
	I_AD_Ref_ListInput AuthenticationType();

	/**
	 * Column name BH_HasAcceptedTermsOfUse
	 */
	static final String COLUMNNAME_BH_HasAcceptedTermsOfUse = "BH_HasAcceptedTermsOfUse";

	/**
	 * Set HasAcceptedTermsOfUse.
	 *
	 * @param BH_HasAcceptedTermsOfUse HasAcceptedTermsOfUse
	 */
	void setBH_HasAcceptedTermsOfUse(boolean BH_HasAcceptedTermsOfUse);

	/**
	 * Get HasAcceptedTermsOfUse.
	 *
	 * @return HasAcceptedTermsOfUse
	 */
	boolean isBH_HasAcceptedTermsOfUse();

	/**
	 * Column name BH_TOS_DATE_ACCEPTED
	 */
	static final String COLUMNNAME_BH_TOS_DATE_ACCEPTED = "BH_TOS_DATE_ACCEPTED";

	/**
	 * Set BH_TOS_DATE_ACCEPTED.
	 *
	 * @param BH_TOS_DATE_ACCEPTED BH_TOS_DATE_ACCEPTED
	 */
	void setBH_TOS_DATE_ACCEPTED(Timestamp BH_TOS_DATE_ACCEPTED);

	/**
	 * Get BH_TOS_DATE_ACCEPTED.
	 *
	 * @return BH_TOS_DATE_ACCEPTED
	 */
	Timestamp getBH_TOS_DATE_ACCEPTED();

	/**
	 * Set BP_Location.
	 *
	 * @param BP_Location Address of the Business Partner
	 */
	void setBP_LocationInput(ForeignEntityInput BP_Location);

	/**
	 * Get BP_Location.
	 *
	 * @return Address of the Business Partner
	 */
	ForeignEntityInput BP_Location();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(ForeignEntityInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	ForeignEntityInput C_BPartner();

	/**
	 * Set C_BPartner_Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	void setC_BPartner_LocationInput(ForeignEntityInput C_BPartner_Location);

	/**
	 * Get C_BPartner_Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	ForeignEntityInput C_BPartner_Location();

	/**
	 * Set C_Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	void setC_CampaignInput(ForeignEntityInput C_Campaign);

	/**
	 * Get C_Campaign.
	 *
	 * @return Marketing Campaign
	 */
	ForeignEntityInput C_Campaign();

	/**
	 * Set C_Greeting.
	 *
	 * @param C_Greeting Greeting to print on correspondence
	 */
	void setC_GreetingInput(ForeignEntityInput C_Greeting);

	/**
	 * Get C_Greeting.
	 *
	 * @return Greeting to print on correspondence
	 */
	ForeignEntityInput C_Greeting();

	/**
	 * Set C_Job.
	 *
	 * @param C_Job Job Position
	 */
	void setC_JobInput(ForeignEntityInput C_Job);

	/**
	 * Get C_Job.
	 *
	 * @return Job Position
	 */
	ForeignEntityInput C_Job();

	/**
	 * Set C_Location.
	 *
	 * @param C_Location Location or Address
	 */
	void setC_LocationInput(ForeignEntityInput C_Location);

	/**
	 * Get C_Location.
	 *
	 * @return Location or Address
	 */
	ForeignEntityInput C_Location();

	/**
	 * Set IsMenuAutoExpand.
	 *
	 * @param IsMenuAutoExpand If ticked, the menu is automatically expanded
	 */
	void setIsMenuAutoExpandInput(I_AD_Ref_ListInput IsMenuAutoExpand);

	/**
	 * Get IsMenuAutoExpand.
	 *
	 * @return If ticked, the menu is automatically expanded
	 */
	I_AD_Ref_ListInput IsMenuAutoExpand();

	/**
	 * Set LeadSource.
	 *
	 * @param LeadSource The source of this lead/opportunity
	 */
	void setLeadSourceInput(I_AD_Ref_ListInput LeadSource);

	/**
	 * Get LeadSource.
	 *
	 * @return The source of this lead/opportunity
	 */
	I_AD_Ref_ListInput LeadSource();

	/**
	 * Set LeadStatus.
	 *
	 * @param LeadStatus The status of this lead/opportunity in the sales cycle
	 */
	void setLeadStatusInput(I_AD_Ref_ListInput LeadStatus);

	/**
	 * Get LeadStatus.
	 *
	 * @return The status of this lead/opportunity in the sales cycle
	 */
	I_AD_Ref_ListInput LeadStatus();

	/**
	 * Set NotificationType.
	 *
	 * @param NotificationType Type of Notifications
	 */
	void setNotificationTypeInput(I_AD_Ref_ListInput NotificationType);

	/**
	 * Get NotificationType.
	 *
	 * @return Type of Notifications
	 */
	I_AD_Ref_ListInput NotificationType();

	/**
	 * Set R_DefaultMailText.
	 *
	 * @param R_DefaultMailText R_DefaultMailText
	 */
	void setR_DefaultMailTextInput(ForeignEntityInput R_DefaultMailText);

	/**
	 * Get R_DefaultMailText.
	 *
	 * @return R_DefaultMailText
	 */
	ForeignEntityInput R_DefaultMailText();

	/**
	 * Set SalesRep.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	void setSalesRepInput(ForeignEntityInput SalesRep);

	/**
	 * Get SalesRep.
	 *
	 * @return Sales Representative or Company Agent
	 */
	ForeignEntityInput SalesRep();

	/**
	 * Set Supervisor.
	 *
	 * @param Supervisor Supervisor for this user/organization - used for escalation and approval
	 */
	void setSupervisorInput(ForeignEntityInput Supervisor);

	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	ForeignEntityInput Supervisor();
}
