package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
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
import org.compiere.util.Env;

import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for AD_User - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_User_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_UserInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MUser_BH(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Image.
	 *
	 * @param AD_Image Image or Icon
	 */
	@JsonProperty("AD_Image")
	public void setAD_ImageInput(ForeignEntityInput AD_Image) {
		this.mAD_Image = AD_Image;
		if (AD_Image != null) {
			// Since an entity was passed, make sure it's in the DB
			MImage foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Image", "AD_Image_UU=?", get_TrxName())
							.setParameters(AD_Image.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Image_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Image with UUID " + AD_Image.getUUID());
			}
		} else {
			this.setAD_Image_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_User_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (BP_Location != null) {
			// Since an entity was passed, make sure it's in the DB
			MLocation foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Location", "C_Location_UU=?", get_TrxName())
							.setParameters(BP_Location.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setBP_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Location with UUID " + BP_Location.getUUID());
			}
		} else {
			this.setBP_Location_ID(0);
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
		if (C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_BPartner.getUUID());
			}
		} else {
			this.setC_BPartner_ID(0);
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
		if (C_BPartner_Location != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartnerLocation foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner_Location", "C_BPartner_Location_UU=?", get_TrxName())
							.setParameters(C_BPartner_Location.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BPartner_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner_Location with UUID " + C_BPartner_Location.getUUID());
			}
		} else {
			this.setC_BPartner_Location_ID(0);
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
		if (C_Campaign != null) {
			// Since an entity was passed, make sure it's in the DB
			MCampaign foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Campaign", "C_Campaign_UU=?", get_TrxName())
							.setParameters(C_Campaign.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Campaign_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Campaign with UUID " + C_Campaign.getUUID());
			}
		} else {
			this.setC_Campaign_ID(0);
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
		if (C_Greeting != null) {
			// Since an entity was passed, make sure it's in the DB
			X_C_Greeting foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Greeting", "C_Greeting_UU=?", get_TrxName())
							.setParameters(C_Greeting.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Greeting_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Greeting with UUID " + C_Greeting.getUUID());
			}
		} else {
			this.setC_Greeting_ID(0);
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
		if (C_Job != null) {
			// Since an entity was passed, make sure it's in the DB
			X_C_Job foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Job", "C_Job_UU=?", get_TrxName())
							.setParameters(C_Job.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Job_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Job with UUID " + C_Job.getUUID());
			}
		} else {
			this.setC_Job_ID(0);
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
		if (C_Location != null) {
			// Since an entity was passed, make sure it's in the DB
			MLocation foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Location", "C_Location_UU=?", get_TrxName())
							.setParameters(C_Location.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Location with UUID " + C_Location.getUUID());
			}
		} else {
			this.setC_Location_ID(0);
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
		if (IsMenuAutoExpand != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsMenuAutoExpand.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setIsMenuAutoExpand(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + IsMenuAutoExpand.getUUID());
			}
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
		if (LeadSource != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(LeadSource.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setLeadSource(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + LeadSource.getUUID());
			}
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
		if (LeadStatus != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(LeadStatus.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setLeadStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + LeadStatus.getUUID());
			}
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
		if (NotificationType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(NotificationType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setNotificationType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + NotificationType.getUUID());
			}
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
		if (R_DefaultMailText != null) {
			// Since an entity was passed, make sure it's in the DB
			MMailText foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_MailText", "R_MailText_UU=?", get_TrxName())
							.setParameters(R_DefaultMailText.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_DefaultMailText_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_MailText with UUID " + R_DefaultMailText.getUUID());
			}
		} else {
			this.setR_DefaultMailText_ID(0);
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
		if (SalesRep != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(SalesRep.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setSalesRep_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + SalesRep.getUUID());
			}
		} else {
			this.setSalesRep_ID(0);
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
		if (Supervisor != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(Supervisor.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setSupervisor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + Supervisor.getUUID());
			}
		} else {
			this.setSupervisor_ID(0);
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
