package org.bandahealth.idempiere.graphql.model.input;

import java.sql.Timestamp;
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
	void setAD_Image(I_AD_ImageInput AD_Image);

	/**
	 * Get AD_Image.
	 *
	 * @return Image or Icon
	 */
	I_AD_ImageInput getAD_Image();

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

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
	 * Column name bandahealth_bpartners
	 */
	public static final String COLUMNNAME_bandahealth_bpartners = "bandahealth_bpartners";

	/**
	 * Set bandahealth_bpartners.
	 *
	 * @param bandahealth_bpartners bandahealth_bpartners
	 */
	public void setbandahealth_bpartners(String bandahealth_bpartners);

	/**
	 * Get bandahealth_bpartners.
	 *
	 * @return bandahealth_bpartners
	 */
	public String getbandahealth_bpartners();

	/**
	 * Column name BH_HasAcceptedTermsOfUse
	 */
	public static final String COLUMNNAME_BH_HasAcceptedTermsOfUse = "BH_HasAcceptedTermsOfUse";

	/**
	 * Set HasAcceptedTermsOfUse.
	 *
	 * @param BH_HasAcceptedTermsOfUse HasAcceptedTermsOfUse
	 */
	public void setBH_HasAcceptedTermsOfUse(boolean BH_HasAcceptedTermsOfUse);

	/**
	 * Get HasAcceptedTermsOfUse.
	 *
	 * @return HasAcceptedTermsOfUse
	 */
	public boolean isBH_HasAcceptedTermsOfUse();

	/**
	 * Column name BH_TOS_DATE_ACCEPTED
	 */
	public static final String COLUMNNAME_BH_TOS_DATE_ACCEPTED = "BH_TOS_DATE_ACCEPTED";

	/**
	 * Set BH_TOS_DATE_ACCEPTED.
	 *
	 * @param BH_TOS_DATE_ACCEPTED BH_TOS_DATE_ACCEPTED
	 */
	public void setBH_TOS_DATE_ACCEPTED(Timestamp BH_TOS_DATE_ACCEPTED);

	/**
	 * Get BH_TOS_DATE_ACCEPTED.
	 *
	 * @return BH_TOS_DATE_ACCEPTED
	 */
	public Timestamp getBH_TOS_DATE_ACCEPTED();

	/**
	 * Set BP_Location.
	 *
	 * @param BP_Location Address of the Business Partner
	 */
	void setBP_Location(I_C_LocationInput BP_Location);

	/**
	 * Get BP_Location.
	 *
	 * @return Address of the Business Partner
	 */
	I_C_LocationInput getBP_Location();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartner(I_C_BPartnerInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	I_C_BPartnerInput getC_BPartner();

	/**
	 * Set C_BPartner_Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	void setC_BPartner_Location(I_C_BPartner_LocationInput C_BPartner_Location);

	/**
	 * Get C_BPartner_Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	I_C_BPartner_LocationInput getC_BPartner_Location();

	/**
	 * Set C_Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	void setC_Campaign(I_C_CampaignInput C_Campaign);

	/**
	 * Get C_Campaign.
	 *
	 * @return Marketing Campaign
	 */
	I_C_CampaignInput getC_Campaign();

	/**
	 * Set C_Greeting.
	 *
	 * @param C_Greeting Greeting to print on correspondence
	 */
	void setC_Greeting(I_C_GreetingInput C_Greeting);

	/**
	 * Get C_Greeting.
	 *
	 * @return Greeting to print on correspondence
	 */
	I_C_GreetingInput getC_Greeting();

	/**
	 * Set C_Job.
	 *
	 * @param C_Job Job Position
	 */
	void setC_Job(I_C_JobInput C_Job);

	/**
	 * Get C_Job.
	 *
	 * @return Job Position
	 */
	I_C_JobInput getC_Job();

	/**
	 * Set C_Location.
	 *
	 * @param C_Location Location or Address
	 */
	void setC_Location(I_C_LocationInput C_Location);

	/**
	 * Get C_Location.
	 *
	 * @return Location or Address
	 */
	I_C_LocationInput getC_Location();

	/**
	 * Column name eve_bpartners
	 */
	public static final String COLUMNNAME_eve_bpartners = "eve_bpartners";

	/**
	 * Set eve_bpartners.
	 *
	 * @param eve_bpartners eve_bpartners
	 */
	public void seteve_bpartners(String eve_bpartners);

	/**
	 * Get eve_bpartners.
	 *
	 * @return eve_bpartners
	 */
	public String geteve_bpartners();

	/**
	 * Set IsMenuAutoExpand_RL.
	 *
	 * @param IsMenuAutoExpand_RL If ticked, the menu is automatically expanded
	 */
	void setIsMenuAutoExpand_RL(I_AD_Ref_ListInput IsMenuAutoExpand_RL);

	/**
	 * Get IsMenuAutoExpand_RL.
	 *
	 * @return If ticked, the menu is automatically expanded
	 */
	I_AD_Ref_ListInput getIsMenuAutoExpand_RL();

	/**
	 * Set LeadSource_RL.
	 *
	 * @param LeadSource_RL The source of this lead/opportunity
	 */
	void setLeadSource_RL(I_AD_Ref_ListInput LeadSource_RL);

	/**
	 * Get LeadSource_RL.
	 *
	 * @return The source of this lead/opportunity
	 */
	I_AD_Ref_ListInput getLeadSource_RL();

	/**
	 * Set LeadStatus_RL.
	 *
	 * @param LeadStatus_RL The status of this lead/opportunity in the sales cycle
	 */
	void setLeadStatus_RL(I_AD_Ref_ListInput LeadStatus_RL);

	/**
	 * Get LeadStatus_RL.
	 *
	 * @return The status of this lead/opportunity in the sales cycle
	 */
	I_AD_Ref_ListInput getLeadStatus_RL();

	/**
	 * Set NotificationType_RL.
	 *
	 * @param NotificationType_RL Type of Notifications
	 */
	void setNotificationType_RL(I_AD_Ref_ListInput NotificationType_RL);

	/**
	 * Get NotificationType_RL.
	 *
	 * @return Type of Notifications
	 */
	I_AD_Ref_ListInput getNotificationType_RL();

	/**
	 * Set R_DefaultMailText.
	 *
	 * @param R_DefaultMailText R_DefaultMailText
	 */
	void setR_DefaultMailText(I_R_MailTextInput R_DefaultMailText);

	/**
	 * Get R_DefaultMailText.
	 *
	 * @return R_DefaultMailText
	 */
	I_R_MailTextInput getR_DefaultMailText();

	/**
	 * Set SalesRep.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	void setSalesRep(I_AD_UserInput SalesRep);

	/**
	 * Get SalesRep.
	 *
	 * @return Sales Representative or Company Agent
	 */
	I_AD_UserInput getSalesRep();

	/**
	 * Set Supervisor.
	 *
	 * @param Supervisor Supervisor for this user/organization - used for escalation and approval
	 */
	void setSupervisor(I_AD_UserInput Supervisor);

	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	I_AD_UserInput getSupervisor();
}
