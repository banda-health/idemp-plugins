package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MCampaign;
import org.compiere.model.MImage;
import org.compiere.model.MLocation;
import org.compiere.model.MMailText;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_Greeting;
import org.compiere.model.X_C_Job;

import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for AD_User - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_UserInput extends MUser_BH implements I_AD_UserInput {

	private ForeignEntityInput mAD_Image;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBP_Location;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_BPartner_Location;
	private ForeignEntityInput mC_Campaign;
	private ForeignEntityInput mC_Greeting;
	private ForeignEntityInput mC_Job;
	private ForeignEntityInput mC_Location;
	private ForeignEntityInput mR_DefaultMailText;
	private ForeignEntityInput mSalesRep;
	private ForeignEntityInput mSupervisor;
	private I_AD_Ref_ListInput mIsMenuAutoExpand;
	private I_AD_Ref_ListInput mLeadSource;
	private I_AD_Ref_ListInput mLeadStatus;
	private I_AD_Ref_ListInput mNotificationType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_UserInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MUser_BH(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Image.
	 *
	 * @param AD_Image Image or Icon
	 */
	@JsonProperty("AD_Image")
	public void setAD_ImageInput(ForeignEntityInput AD_Image) {
		this.mAD_Image = AD_Image;
		MImage foreignEntity;
		if (AD_Image != null &&
				(foreignEntity = new Query(getCtx(), "AD_Image", "AD_Image_UU=?", get_TrxName())
						.setParameters(AD_Image.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Image_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Image_ID(0);
		}
	}

	/**
	 * Get Image.
	 *
	 * @return Image or Icon
	 */
	@JsonProperty("AD_Image")
	public ForeignEntityInput AD_Image() {
		return mAD_Image;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
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
	 * Set BP Address.
	 *
	 * @param BP_Location Address of the Business Partner
	 */
	@JsonProperty("BP_Location")
	public void setBP_LocationInput(ForeignEntityInput BP_Location) {
		this.mBP_Location = BP_Location;
		MLocation foreignEntity;
		if (BP_Location != null &&
				(foreignEntity = new Query(getCtx(), "C_Location", "C_Location_UU=?", get_TrxName())
						.setParameters(BP_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setBP_Location_ID(foreignEntity.get_ID());
		} else {
			super.setBP_Location_ID(0);
		}
	}

	/**
	 * Get BP Address.
	 *
	 * @return Address of the Business Partner
	 */
	@JsonProperty("BP_Location")
	public ForeignEntityInput BP_Location() {
		return mBP_Location;
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set Partner Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	@JsonProperty("C_BPartner_Location")
	public void setC_BPartner_LocationInput(ForeignEntityInput C_BPartner_Location) {
		this.mC_BPartner_Location = C_BPartner_Location;
		MBPartnerLocation foreignEntity;
		if (C_BPartner_Location != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner_Location", "C_BPartner_Location_UU=?", get_TrxName())
						.setParameters(C_BPartner_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_Location_ID(foreignEntity.get_ID());
		} else {
			super.setC_BPartner_Location_ID(0);
		}
	}

	/**
	 * Get Partner Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	@JsonProperty("C_BPartner_Location")
	public ForeignEntityInput C_BPartner_Location() {
		return mC_BPartner_Location;
	}

	/**
	 * Set Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	@JsonProperty("C_Campaign")
	public void setC_CampaignInput(ForeignEntityInput C_Campaign) {
		this.mC_Campaign = C_Campaign;
		MCampaign foreignEntity;
		if (C_Campaign != null &&
				(foreignEntity = new Query(getCtx(), "C_Campaign", "C_Campaign_UU=?", get_TrxName())
						.setParameters(C_Campaign.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Campaign_ID(foreignEntity.get_ID());
		} else {
			super.setC_Campaign_ID(0);
		}
	}

	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	@JsonProperty("C_Campaign")
	public ForeignEntityInput C_Campaign() {
		return mC_Campaign;
	}

	/**
	 * Set Greeting.
	 *
	 * @param C_Greeting Greeting to print on correspondence
	 */
	@JsonProperty("C_Greeting")
	public void setC_GreetingInput(ForeignEntityInput C_Greeting) {
		this.mC_Greeting = C_Greeting;
		X_C_Greeting foreignEntity;
		if (C_Greeting != null &&
				(foreignEntity = new Query(getCtx(), "C_Greeting", "C_Greeting_UU=?", get_TrxName())
						.setParameters(C_Greeting.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Greeting_ID(foreignEntity.get_ID());
		} else {
			super.setC_Greeting_ID(0);
		}
	}

	/**
	 * Get Greeting.
	 *
	 * @return Greeting to print on correspondence
	 */
	@JsonProperty("C_Greeting")
	public ForeignEntityInput C_Greeting() {
		return mC_Greeting;
	}

	/**
	 * Set Position.
	 *
	 * @param C_Job Job Position
	 */
	@JsonProperty("C_Job")
	public void setC_JobInput(ForeignEntityInput C_Job) {
		this.mC_Job = C_Job;
		X_C_Job foreignEntity;
		if (C_Job != null &&
				(foreignEntity = new Query(getCtx(), "C_Job", "C_Job_UU=?", get_TrxName())
						.setParameters(C_Job.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Job_ID(foreignEntity.get_ID());
		} else {
			super.setC_Job_ID(0);
		}
	}

	/**
	 * Get Position.
	 *
	 * @return Job Position
	 */
	@JsonProperty("C_Job")
	public ForeignEntityInput C_Job() {
		return mC_Job;
	}

	/**
	 * Set Address.
	 *
	 * @param C_Location Location or Address
	 */
	@JsonProperty("C_Location")
	public void setC_LocationInput(ForeignEntityInput C_Location) {
		this.mC_Location = C_Location;
		MLocation foreignEntity;
		if (C_Location != null &&
				(foreignEntity = new Query(getCtx(), "C_Location", "C_Location_UU=?", get_TrxName())
						.setParameters(C_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Location_ID(foreignEntity.get_ID());
		} else {
			super.setC_Location_ID(0);
		}
	}

	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	@JsonProperty("C_Location")
	public ForeignEntityInput C_Location() {
		return mC_Location;
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
	 * Set Auto expand menu.
	 *
	 * @param IsMenuAutoExpand If ticked, the menu is automatically expanded
	 */
	@JsonProperty("IsMenuAutoExpand")
	public void setIsMenuAutoExpandInput(I_AD_Ref_ListInput IsMenuAutoExpand) {
		this.mIsMenuAutoExpand = IsMenuAutoExpand;
		MRefList_BH foreignEntity;
		if (IsMenuAutoExpand != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IsMenuAutoExpand.getID())
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
	@JsonProperty("IsMenuAutoExpand")
	public I_AD_Ref_ListInput IsMenuAutoExpand() {
		return mIsMenuAutoExpand;
	}

	/**
	 * Set Lead Source.
	 *
	 * @param LeadSource The source of this lead/opportunity
	 */
	@JsonProperty("LeadSource")
	public void setLeadSourceInput(I_AD_Ref_ListInput LeadSource) {
		this.mLeadSource = LeadSource;
		MRefList_BH foreignEntity;
		if (LeadSource != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(LeadSource.getID())
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
	@JsonProperty("LeadSource")
	public I_AD_Ref_ListInput LeadSource() {
		return mLeadSource;
	}

	/**
	 * Set Lead Status.
	 *
	 * @param LeadStatus The status of this lead/opportunity in the sales cycle
	 */
	@JsonProperty("LeadStatus")
	public void setLeadStatusInput(I_AD_Ref_ListInput LeadStatus) {
		this.mLeadStatus = LeadStatus;
		MRefList_BH foreignEntity;
		if (LeadStatus != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(LeadStatus.getID())
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
	@JsonProperty("LeadStatus")
	public I_AD_Ref_ListInput LeadStatus() {
		return mLeadStatus;
	}

	/**
	 * Set Notification Type.
	 *
	 * @param NotificationType Type of Notifications
	 */
	@JsonProperty("NotificationType")
	public void setNotificationTypeInput(I_AD_Ref_ListInput NotificationType) {
		this.mNotificationType = NotificationType;
		MRefList_BH foreignEntity;
		if (NotificationType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(NotificationType.getID())
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
	@JsonProperty("NotificationType")
	public I_AD_Ref_ListInput NotificationType() {
		return mNotificationType;
	}

	/**
	 * Set Default mail template.
	 *
	 * @param R_DefaultMailText Default mail template
	 */
	@JsonProperty("R_DefaultMailText")
	public void setR_DefaultMailTextInput(ForeignEntityInput R_DefaultMailText) {
		this.mR_DefaultMailText = R_DefaultMailText;
		MMailText foreignEntity;
		if (R_DefaultMailText != null &&
				(foreignEntity = new Query(getCtx(), "R_MailText", "R_MailText_UU=?", get_TrxName())
						.setParameters(R_DefaultMailText.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setR_DefaultMailText_ID(foreignEntity.get_ID());
		} else {
			super.setR_DefaultMailText_ID(0);
		}
	}

	/**
	 * Get Default mail template.
	 *
	 * @return Default mail template
	 */
	@JsonProperty("R_DefaultMailText")
	public ForeignEntityInput R_DefaultMailText() {
		return mR_DefaultMailText;
	}

	/**
	 * Set Sales Representative.
	 *
	 * @param SalesRep Sales Representative or Company Agent
	 */
	@JsonProperty("SalesRep")
	public void setSalesRepInput(ForeignEntityInput SalesRep) {
		this.mSalesRep = SalesRep;
		MUser_BH foreignEntity;
		if (SalesRep != null &&
				(foreignEntity = new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
						.setParameters(SalesRep.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setSalesRep_ID(foreignEntity.get_ID());
		} else {
			super.setSalesRep_ID(0);
		}
	}

	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	@JsonProperty("SalesRep")
	public ForeignEntityInput SalesRep() {
		return mSalesRep;
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
	@JsonProperty("Supervisor")
	public void setSupervisorInput(ForeignEntityInput Supervisor) {
		this.mSupervisor = Supervisor;
		MUser_BH foreignEntity;
		if (Supervisor != null &&
				(foreignEntity = new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
						.setParameters(Supervisor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setSupervisor_ID(foreignEntity.get_ID());
		} else {
			super.setSupervisor_ID(0);
		}
	}

	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	@JsonProperty("Supervisor")
	public ForeignEntityInput Supervisor() {
		return mSupervisor;
	}
}
