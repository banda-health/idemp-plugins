package org.bandahealth.idempiere.graphql.model.input;

import java.sql.Timestamp;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCampaign;
import org.compiere.model.MImage;
import org.compiere.model.MLocation;
import org.compiere.model.MMailText;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_AD_User;
import org.compiere.model.X_C_Greeting;
import org.compiere.model.X_C_Job;
import org.compiere.util.Env;

/**
 * Generated Model for AD_User - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserInput extends X_AD_User implements I_AD_UserInput {

	 private I_AD_ImageInput AD_Image;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput IsMenuAutoExpand_RL;
	 private I_AD_Ref_ListInput LeadSource_RL;
	 private I_AD_Ref_ListInput LeadStatus_RL;
	 private I_AD_Ref_ListInput NotificationType_RL;
	 private I_AD_UserInput SalesRep;
	 private I_AD_UserInput Supervisor;
	 private I_C_BPartnerInput C_BPartner;
	 private I_C_BPartner_LocationInput C_BPartner_Location;
	 private I_C_CampaignInput C_Campaign;
	 private I_C_GreetingInput C_Greeting;
	 private I_C_JobInput C_Job;
	 private I_C_LocationInput BP_Location;
	 private I_C_LocationInput C_Location;
	 private I_R_MailTextInput R_DefaultMailText;

	/**
	 * Standard constructor
	 */
	public X_AD_UserInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Image.
	 *
	 * @param AD_Image Image or Icon
	 */
	public void setAD_Image(I_AD_ImageInput AD_Image) {
		this.AD_Image = AD_Image;
		MImage foreignEntity;
		if (AD_Image != null &&
				(foreignEntity = new Query(getCtx(), MImage.Table_Name, MImage.COLUMNNAME_AD_Image_UU + "=?", get_TrxName())
						.setParameters(AD_Image.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Image_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Image_ID(0);
		}
	}

	/**
	 * Get Image.
	 *
	 * @return Image or Icon
	 */
	public I_AD_ImageInput getAD_Image() {
		return AD_Image;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}
	/**
	 * Set User/Contact.
	 *
	 * @param AD_User_ID User within the system - Internal or Business Partner Contact
	 */

	public void setAD_User_ID(int AD_User_ID) {
		if (get_ID() == 0) {
			super.setAD_User_ID(AD_User_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_User_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_User_UU();
	}

	/**
	 * Set bandahealth_bpartners.
	 *
	 * @param bandahealth_bpartners bandahealth_bpartners
	 */
	public void setbandahealth_bpartners(String bandahealth_bpartners) {
		set_Value(COLUMNNAME_bandahealth_bpartners, bandahealth_bpartners);
	}


	/**
	 * Get bandahealth_bpartners.
	 *
	 * @return bandahealth_bpartners
	 */
	public String getbandahealth_bpartners() {
 		return (String) get_Value(COLUMNNAME_bandahealth_bpartners);
	}


	/**
	 * Set HasAcceptedTermsOfUse.
	 *
	 * @param BH_HasAcceptedTermsOfUse HasAcceptedTermsOfUse
	 */
	public void setBH_HasAcceptedTermsOfUse(boolean BH_HasAcceptedTermsOfUse) {
		set_Value(COLUMNNAME_BH_HasAcceptedTermsOfUse, BH_HasAcceptedTermsOfUse);
	}


	/**
	 * Get HasAcceptedTermsOfUse.
	 *
	 * @return HasAcceptedTermsOfUse
	 */
	public boolean isBH_HasAcceptedTermsOfUse() {
 		Object columnValue = get_Value(COLUMNNAME_BH_HasAcceptedTermsOfUse);
		if (columnValue != null) {
			if (columnValue instanceof Boolean) {
				return ((Boolean) columnValue);
			}
			return "Y".equals(columnValue);
		}
		return false;
	}


	/**
	 * Set BH_TOS_DATE_ACCEPTED.
	 *
	 * @param BH_TOS_DATE_ACCEPTED BH_TOS_DATE_ACCEPTED
	 */
	public void setBH_TOS_DATE_ACCEPTED(Timestamp BH_TOS_DATE_ACCEPTED) {
		set_Value(COLUMNNAME_BH_TOS_DATE_ACCEPTED, BH_TOS_DATE_ACCEPTED);
	}


	/**
	 * Get BH_TOS_DATE_ACCEPTED.
	 *
	 * @return BH_TOS_DATE_ACCEPTED
	 */
	public Timestamp getBH_TOS_DATE_ACCEPTED() {
 		return (Timestamp) get_Value(COLUMNNAME_BH_TOS_DATE_ACCEPTED);
	}


	/**
	 * Set BP Address.
	 *
	 * @param BP_Location Address of the Business Partner
	 */
	public void setBP_Location(I_C_LocationInput BP_Location) {
		this.BP_Location = BP_Location;
		MLocation foreignEntity;
		if (BP_Location != null &&
				(foreignEntity = new Query(getCtx(), MLocation.Table_Name, MLocation.COLUMNNAME_C_Location_UU + "=?", get_TrxName())
						.setParameters(BP_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBP_Location_ID(foreignEntity.get_ID());
		} else {
			this.setBP_Location_ID(0);
		}
	}

	/**
	 * Get BP Address.
	 *
	 * @return Address of the Business Partner
	 */
	public I_C_LocationInput getBP_Location() {
		return BP_Location;
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	public void setC_BPartner(I_C_BPartnerInput C_BPartner) {
		this.C_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public I_C_BPartnerInput getC_BPartner() {
		return C_BPartner;
	}

	/**
	 * Set Partner Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	public void setC_BPartner_Location(I_C_BPartner_LocationInput C_BPartner_Location) {
		this.C_BPartner_Location = C_BPartner_Location;
		MBPartnerLocation foreignEntity;
		if (C_BPartner_Location != null &&
				(foreignEntity = new Query(getCtx(), MBPartnerLocation.Table_Name, MBPartnerLocation.COLUMNNAME_C_BPartner_Location_UU + "=?", get_TrxName())
						.setParameters(C_BPartner_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartner_Location_ID(foreignEntity.get_ID());
		} else {
			this.setC_BPartner_Location_ID(0);
		}
	}

	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	public I_C_BPartner_LocationInput getC_BPartner_Location() {
		return C_BPartner_Location;
	}

	/**
	 * Set Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	public void setC_Campaign(I_C_CampaignInput C_Campaign) {
		this.C_Campaign = C_Campaign;
		MCampaign foreignEntity;
		if (C_Campaign != null &&
				(foreignEntity = new Query(getCtx(), MCampaign.Table_Name, MCampaign.COLUMNNAME_C_Campaign_UU + "=?", get_TrxName())
						.setParameters(C_Campaign.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Campaign_ID(foreignEntity.get_ID());
		} else {
			this.setC_Campaign_ID(0);
		}
	}

	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public I_C_CampaignInput getC_Campaign() {
		return C_Campaign;
	}

	/**
	 * Set Greeting.
	 *
	 * @param C_Greeting Greeting to print on correspondence
	 */
	public void setC_Greeting(I_C_GreetingInput C_Greeting) {
		this.C_Greeting = C_Greeting;
		X_C_Greeting foreignEntity;
		if (C_Greeting != null &&
				(foreignEntity = new Query(getCtx(), X_C_Greeting.Table_Name, X_C_Greeting.COLUMNNAME_C_Greeting_UU + "=?", get_TrxName())
						.setParameters(C_Greeting.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Greeting_ID(foreignEntity.get_ID());
		} else {
			this.setC_Greeting_ID(0);
		}
	}

	/**
	 * Get Greeting.
	 *
	 * @return Greeting to print on correspondence
	 */
	public I_C_GreetingInput getC_Greeting() {
		return C_Greeting;
	}

	/**
	 * Set Position.
	 *
	 * @param C_Job Job Position
	 */
	public void setC_Job(I_C_JobInput C_Job) {
		this.C_Job = C_Job;
		X_C_Job foreignEntity;
		if (C_Job != null &&
				(foreignEntity = new Query(getCtx(), X_C_Job.Table_Name, X_C_Job.COLUMNNAME_C_Job_UU + "=?", get_TrxName())
						.setParameters(C_Job.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Job_ID(foreignEntity.get_ID());
		} else {
			this.setC_Job_ID(0);
		}
	}

	/**
	 * Get Position.
	 *
	 * @return Job Position
	 */
	public I_C_JobInput getC_Job() {
		return C_Job;
	}

	/**
	 * Set Address.
	 *
	 * @param C_Location Location or Address
	 */
	public void setC_Location(I_C_LocationInput C_Location) {
		this.C_Location = C_Location;
		MLocation foreignEntity;
		if (C_Location != null &&
				(foreignEntity = new Query(getCtx(), MLocation.Table_Name, MLocation.COLUMNNAME_C_Location_UU + "=?", get_TrxName())
						.setParameters(C_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Location_ID(foreignEntity.get_ID());
		} else {
			this.setC_Location_ID(0);
		}
	}

	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	public I_C_LocationInput getC_Location() {
		return C_Location;
	}
	/**
	 * Set Verification Info.
	 *
	 * @param EMailVerify Verification information of EMail Address
	 */

	public void setEMailVerify(String EMailVerify) {
		if (get_ID() == 0) {
			super.setEMailVerify(EMailVerify);
		}
	}
	/**
	 * Set EMail Verify.
	 *
	 * @param EMailVerifyDate Date Email was verified
	 */

	public void setEMailVerifyDate(Timestamp EMailVerifyDate) {
		if (get_ID() == 0) {
			super.setEMailVerifyDate(EMailVerifyDate);
		}
	}

	/**
	 * Set eve_bpartners.
	 *
	 * @param eve_bpartners eve_bpartners
	 */
	public void seteve_bpartners(String eve_bpartners) {
		set_Value(COLUMNNAME_eve_bpartners, eve_bpartners);
	}


	/**
	 * Get eve_bpartners.
	 *
	 * @return eve_bpartners
	 */
	public String geteve_bpartners() {
 		return (String) get_Value(COLUMNNAME_eve_bpartners);
	}


	/**
	 * Set Auto expand menu.
	 *
	 * @param IsMenuAutoExpand_RL If ticked, the menu is automatically expanded
	 */
	public void setIsMenuAutoExpand_RL(I_AD_Ref_ListInput IsMenuAutoExpand_RL) {
		this.IsMenuAutoExpand_RL = IsMenuAutoExpand_RL;
		MRefList foreignEntity;
		if (IsMenuAutoExpand_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IsMenuAutoExpand_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setIsMenuAutoExpand(foreignEntity.getValue());
		} else {
			this.setIsMenuAutoExpand(null);
		}
	}

	/**
	 * Get Auto expand menu.
	 *
	 * @return If ticked, the menu is automatically expanded
	 */
	public I_AD_Ref_ListInput getIsMenuAutoExpand_RL() {
		return IsMenuAutoExpand_RL;
	}

	/**
	 * Set Lead Source.
	 *
	 * @param LeadSource_RL The source of this lead/opportunity
	 */
	public void setLeadSource_RL(I_AD_Ref_ListInput LeadSource_RL) {
		this.LeadSource_RL = LeadSource_RL;
		MRefList foreignEntity;
		if (LeadSource_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(LeadSource_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setLeadSource(foreignEntity.getValue());
		} else {
			this.setLeadSource(null);
		}
	}

	/**
	 * Get Lead Source.
	 *
	 * @return The source of this lead/opportunity
	 */
	public I_AD_Ref_ListInput getLeadSource_RL() {
		return LeadSource_RL;
	}

	/**
	 * Set Lead Status.
	 *
	 * @param LeadStatus_RL The status of this lead/opportunity in the sales cycle
	 */
	public void setLeadStatus_RL(I_AD_Ref_ListInput LeadStatus_RL) {
		this.LeadStatus_RL = LeadStatus_RL;
		MRefList foreignEntity;
		if (LeadStatus_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(LeadStatus_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setLeadStatus(foreignEntity.getValue());
		} else {
			this.setLeadStatus(null);
		}
	}

	/**
	 * Get Lead Status.
	 *
	 * @return The status of this lead/opportunity in the sales cycle
	 */
	public I_AD_Ref_ListInput getLeadStatus_RL() {
		return LeadStatus_RL;
	}

	/**
	 * Set Notification Type.
	 *
	 * @param NotificationType_RL Type of Notifications
	 */
	public void setNotificationType_RL(I_AD_Ref_ListInput NotificationType_RL) {
		this.NotificationType_RL = NotificationType_RL;
		MRefList foreignEntity;
		if (NotificationType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(NotificationType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setNotificationType(foreignEntity.getValue());
		} else {
			this.setNotificationType(null);
		}
	}

	/**
	 * Get Notification Type.
	 *
	 * @return Type of Notifications
	 */
	public I_AD_Ref_ListInput getNotificationType_RL() {
		return NotificationType_RL;
	}

	/**
	 * Set Default mail template.
	 *
	 * @param R_DefaultMailText Default mail template
	 */
	public void setR_DefaultMailText(I_R_MailTextInput R_DefaultMailText) {
		this.R_DefaultMailText = R_DefaultMailText;
		MMailText foreignEntity;
		if (R_DefaultMailText != null &&
				(foreignEntity = new Query(getCtx(), MMailText.Table_Name, MMailText.COLUMNNAME_R_MailText_UU + "=?", get_TrxName())
						.setParameters(R_DefaultMailText.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setR_DefaultMailText_ID(foreignEntity.get_ID());
		} else {
			this.setR_DefaultMailText_ID(0);
		}
	}

	/**
	 * Get Default mail template.
	 *
	 * @return Default mail template
	 */
	public I_R_MailTextInput getR_DefaultMailText() {
		return R_DefaultMailText;
	}
	/**
	 * Set Default mail template.
	 *
	 * @param R_DefaultMailText_ID Default mail template
	 */

	public void setR_DefaultMailText_ID(int R_DefaultMailText_ID) {
		if (get_ID() == 0) {
			super.setR_DefaultMailText_ID(R_DefaultMailText_ID);
		}
	}

	/**
	 * Set Sales Representative.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	public void setSalesRep(I_AD_UserInput SalesRep) {
		this.SalesRep = SalesRep;
		MUser_BH foreignEntity;
		if (SalesRep != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(SalesRep.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setSalesRep_ID(foreignEntity.get_ID());
		} else {
			this.setSalesRep_ID(0);
		}
	}

	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	public I_AD_UserInput getSalesRep() {
		return SalesRep;
	}
	/**
	 * Set Sales Representative.
	 *
	 * @param SalesRep_ID Sales Representative or Company Agent
	 */

	public void setSalesRep_ID(int SalesRep_ID) {
		if (get_ID() == 0) {
			super.setSalesRep_ID(SalesRep_ID);
		}
	}
	/**
	 * Set Salt.
	 *
	 * @param Salt Random data added to improve password hash effectiveness
	 */

	public void setSalt(String Salt) {
		if (get_ID() == 0) {
			super.setSalt(Salt);
		}
	}

	/**
	 * Set Supervisor.
	 *
	 * @param Supervisor Supervisor for this user/organization - used for escalation and approval
	 */
	public void setSupervisor(I_AD_UserInput Supervisor) {
		this.Supervisor = Supervisor;
		MUser_BH foreignEntity;
		if (Supervisor != null &&
				(foreignEntity = new Query(getCtx(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_AD_User_UU + "=?", get_TrxName())
						.setParameters(Supervisor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setSupervisor_ID(foreignEntity.get_ID());
		} else {
			this.setSupervisor_ID(0);
		}
	}

	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	public I_AD_UserInput getSupervisor() {
		return Supervisor;
	}
	/**
	 * Set Supervisor.
	 *
	 * @param Supervisor_ID Supervisor for this user/organization - used for escalation and approval
	 */

	public void setSupervisor_ID(int Supervisor_ID) {
		if (get_ID() == 0) {
			super.setSupervisor_ID(Supervisor_ID);
		}
	}
}
