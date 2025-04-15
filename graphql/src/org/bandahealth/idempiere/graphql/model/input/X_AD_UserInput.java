package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_UserResolver;
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
 * @version Release 12 - $Id$
 */
public class X_AD_UserInput extends MUser_BH implements I_AD_UserInput {

	private ForeignEntityInput mAD_Image;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAuthenticationType;
	private ForeignEntityInput mBP_Location;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_BPartner_Location;
	private ForeignEntityInput mC_Campaign;
	private ForeignEntityInput mC_Greeting;
	private ForeignEntityInput mC_Job;
	private ForeignEntityInput mC_Location;
	private ForeignEntityInput mIsMenuAutoExpand;
	private ForeignEntityInput mLeadSource;
	private ForeignEntityInput mLeadStatus;
	private ForeignEntityInput mNotificationType;
	private ForeignEntityInput mR_DefaultMailText;
	private ForeignEntityInput mSalesRep;
	private ForeignEntityInput mSupervisor;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_User_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_UserInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
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
							.setParameters(AD_Image.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Image_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Image with UU " + AD_Image.getUU());
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
	 * @param AD_Org Organizational entity within tenant
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
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
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
	@JsonProperty("AD_User_ID")
	public void setAD_User_IDFromJson(int AD_User_ID) {
		if (get_ID() == 0) {
			super.setAD_User_ID(AD_User_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_User_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_User_UU();
	}

	/**
	 * Set Authentication Type.
	 *
	 * @param AuthenticationType Authentication Type
	 */
	@JsonProperty("AuthenticationType")
	public void setAuthenticationTypeInput(ForeignEntityInput AuthenticationType) {
		this.mAuthenticationType = AuthenticationType;
		if (AuthenticationType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_UserResolver.AUTHENTICATIONTYPE_UUIDS_BY_VALUE.containsValue(AuthenticationType.getUU())) {
				throw new AdempiereException("The reference list UU of " + AuthenticationType.getUU() +
						" is not in the list defined for the AuthenticationType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(AuthenticationType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAuthenticationType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + AuthenticationType.getUU());
			}
		} else {
			this.setAuthenticationType(null);
		}
	}

	/**
	 * Get Authentication Type.
	 *
	 * @return Authentication Type
	 */
	@JsonProperty("AuthenticationType")
	public ForeignEntityInput AuthenticationType() {
		return mAuthenticationType;
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
							.setParameters(BP_Location.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBP_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Location with UU " + BP_Location.getUU());
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
	 * Set Business Partner.
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
							.setParameters(C_BPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + C_BPartner.getUU());
			}
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner.
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
							.setParameters(C_BPartner_Location.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_BPartner_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner_Location with UU " + C_BPartner_Location.getUU());
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
							.setParameters(C_Campaign.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Campaign_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Campaign with UU " + C_Campaign.getUU());
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
							.setParameters(C_Greeting.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Greeting_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Greeting with UU " + C_Greeting.getUU());
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
							.setParameters(C_Job.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Job_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Job with UU " + C_Job.getUU());
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
							.setParameters(C_Location.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Location with UU " + C_Location.getUU());
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
	@JsonProperty("EMailVerify")
	public void setEMailVerifyFromJson(String EMailVerify) {
		if (get_ID() == 0) {
			super.setEMailVerify(EMailVerify);
		}
	}
	/**
	 * Set EMail Verify.
	 *
	 * @param EMailVerifyDate Date Email was verified
	 */
	@JsonProperty("EMailVerifyDate")
	public void setEMailVerifyDateFromJson(Timestamp EMailVerifyDate) {
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
	public void setIsMenuAutoExpandInput(ForeignEntityInput IsMenuAutoExpand) {
		this.mIsMenuAutoExpand = IsMenuAutoExpand;
		if (IsMenuAutoExpand != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_UserResolver.ISMENUAUTOEXPAND_UUIDS_BY_VALUE.containsValue(IsMenuAutoExpand.getUU())) {
				throw new AdempiereException("The reference list UU of " + IsMenuAutoExpand.getUU() +
						" is not in the list defined for the IsMenuAutoExpand column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsMenuAutoExpand.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsMenuAutoExpand(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsMenuAutoExpand.getUU());
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
	public ForeignEntityInput IsMenuAutoExpand() {
		return mIsMenuAutoExpand;
	}

	/**
	 * Set Lead Source.
	 *
	 * @param LeadSource The source of this lead/opportunity
	 */
	@JsonProperty("LeadSource")
	public void setLeadSourceInput(ForeignEntityInput LeadSource) {
		this.mLeadSource = LeadSource;
		if (LeadSource != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_UserResolver.LEADSOURCE_UUIDS_BY_VALUE.containsValue(LeadSource.getUU())) {
				throw new AdempiereException("The reference list UU of " + LeadSource.getUU() +
						" is not in the list defined for the LeadSource column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(LeadSource.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setLeadSource(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + LeadSource.getUU());
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
	public ForeignEntityInput LeadSource() {
		return mLeadSource;
	}

	/**
	 * Set Lead Status.
	 *
	 * @param LeadStatus The status of this lead/opportunity in the sales cycle
	 */
	@JsonProperty("LeadStatus")
	public void setLeadStatusInput(ForeignEntityInput LeadStatus) {
		this.mLeadStatus = LeadStatus;
		if (LeadStatus != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_UserResolver.LEADSTATUS_UUIDS_BY_VALUE.containsValue(LeadStatus.getUU())) {
				throw new AdempiereException("The reference list UU of " + LeadStatus.getUU() +
						" is not in the list defined for the LeadStatus column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(LeadStatus.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setLeadStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + LeadStatus.getUU());
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
	public ForeignEntityInput LeadStatus() {
		return mLeadStatus;
	}

	/**
	 * Set Notification Type.
	 *
	 * @param NotificationType Type of Notifications
	 */
	@JsonProperty("NotificationType")
	public void setNotificationTypeInput(ForeignEntityInput NotificationType) {
		this.mNotificationType = NotificationType;
		if (NotificationType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_UserResolver.NOTIFICATIONTYPE_UUIDS_BY_VALUE.containsValue(NotificationType.getUU())) {
				throw new AdempiereException("The reference list UU of " + NotificationType.getUU() +
						" is not in the list defined for the NotificationType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(NotificationType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setNotificationType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + NotificationType.getUU());
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
	public ForeignEntityInput NotificationType() {
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
							.setParameters(R_DefaultMailText.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setR_DefaultMailText_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_MailText with UU " + R_DefaultMailText.getUU());
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
							.setParameters(SalesRep.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setSalesRep_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + SalesRep.getUU());
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
	@JsonProperty("Salt")
	public void setSaltFromJson(String Salt) {
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
							.setParameters(Supervisor.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setSupervisor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + Supervisor.getUU());
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
