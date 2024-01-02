package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_User;

/**
 * Generated Interface for AD_User - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_UserInput extends I_AD_User {

	/**
	 * Set AD_Image.
	 *
	 * @param AD_Image Image or Icon
	 */
	void setAD_ImageInput(I_AD_ImageInput AD_Image);

	/**
	 * Get AD_Image.
	 *
	 * @return Image or Icon
	 */
	I_AD_ImageInput AD_Image();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();

	/**
	 * Set BP_Location.
	 *
	 * @param BP_Location Address of the Business Partner
	 */
	void setBP_LocationInput(I_C_LocationInput BP_Location);

	/**
	 * Get BP_Location.
	 *
	 * @return Address of the Business Partner
	 */
	I_C_LocationInput BP_Location();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(I_C_BPartnerInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	I_C_BPartnerInput C_BPartner();

	/**
	 * Set C_BPartner_Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	void setC_BPartner_LocationInput(I_C_BPartner_LocationInput C_BPartner_Location);

	/**
	 * Get C_BPartner_Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	I_C_BPartner_LocationInput C_BPartner_Location();

	/**
	 * Set C_Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	void setC_CampaignInput(I_C_CampaignInput C_Campaign);

	/**
	 * Get C_Campaign.
	 *
	 * @return Marketing Campaign
	 */
	I_C_CampaignInput C_Campaign();

	/**
	 * Set C_Greeting.
	 *
	 * @param C_Greeting Greeting to print on correspondence
	 */
	void setC_GreetingInput(I_C_GreetingInput C_Greeting);

	/**
	 * Get C_Greeting.
	 *
	 * @return Greeting to print on correspondence
	 */
	I_C_GreetingInput C_Greeting();

	/**
	 * Set C_Job.
	 *
	 * @param C_Job Job Position
	 */
	void setC_JobInput(I_C_JobInput C_Job);

	/**
	 * Get C_Job.
	 *
	 * @return Job Position
	 */
	I_C_JobInput C_Job();

	/**
	 * Set C_Location.
	 *
	 * @param C_Location Location or Address
	 */
	void setC_LocationInput(I_C_LocationInput C_Location);

	/**
	 * Get C_Location.
	 *
	 * @return Location or Address
	 */
	I_C_LocationInput C_Location();

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
	void setR_DefaultMailTextInput(I_R_MailTextInput R_DefaultMailText);

	/**
	 * Get R_DefaultMailText.
	 *
	 * @return R_DefaultMailText
	 */
	I_R_MailTextInput R_DefaultMailText();

	/**
	 * Set SalesRep.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	void setSalesRepInput(I_AD_UserInput SalesRep);

	/**
	 * Get SalesRep.
	 *
	 * @return Sales Representative or Company Agent
	 */
	I_AD_UserInput SalesRep();

	/**
	 * Set Supervisor.
	 *
	 * @param Supervisor Supervisor for this user/organization - used for escalation and approval
	 */
	void setSupervisorInput(I_AD_UserInput Supervisor);

	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	I_AD_UserInput Supervisor();
}
