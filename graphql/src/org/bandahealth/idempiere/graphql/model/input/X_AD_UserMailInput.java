package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MMailText;
import org.compiere.model.MOrg;
import org.compiere.model.MUserMail;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_UserMail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserMailInput extends MUserMail implements I_AD_UserMailInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mR_MailText;
	private I_AD_Ref_ListInput mIsDelivered;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_UserMailInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MUserMail(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		MUser_BH foreignEntity;
		if (get_ID() == 0 && AD_User != null &&
				(foreignEntity = new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
						.setParameters(AD_User.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_User_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public ForeignEntityInput AD_User() {
		return mAD_User;
	}
	/**
	 * Set User Mail.
	 *
	 * @param AD_UserMail_ID Mail sent to the user
	 */

	public void setAD_UserMail_ID(int AD_UserMail_ID) {
		if (get_ID() == 0) {
			super.setAD_UserMail_ID(AD_UserMail_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_UserMail_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_UserMail_UU();
	}
	/**
	 * Set Delivery Confirmation.
	 *
	 * @param DeliveryConfirmation EMail Delivery confirmation
	 */

	public void setDeliveryConfirmation(String DeliveryConfirmation) {
		if (get_ID() == 0) {
			super.setDeliveryConfirmation(DeliveryConfirmation);
		}
	}

	/**
	 * Set Delivered.
	 *
	 * @param IsDelivered Delivered
	 */
	@JsonProperty("IsDelivered")
	public void setIsDeliveredInput(I_AD_Ref_ListInput IsDelivered) {
		this.mIsDelivered = IsDelivered;
		MRefList_BH foreignEntity;
		if (get_ID() == 0 &&IsDelivered != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IsDelivered.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setIsDelivered(foreignEntity.getValue());
		}
	}

	/**
	 * Get Delivered.
	 *
	 * @return Delivered
	 */
	@JsonProperty("IsDelivered")
	public I_AD_Ref_ListInput IsDelivered() {
		return mIsDelivered;
	}
	/**
	 * Set Message ID.
	 *
	 * @param MessageID EMail Message ID
	 */

	public void setMessageID(String MessageID) {
		if (get_ID() == 0) {
			super.setMessageID(MessageID);
		}
	}

	/**
	 * Set Mail Template.
	 *
	 * @param R_MailText Text templates for mailings
	 */
	@JsonProperty("R_MailText")
	public void setR_MailTextInput(ForeignEntityInput R_MailText) {
		this.mR_MailText = R_MailText;
		MMailText foreignEntity;
		if (get_ID() == 0 && R_MailText != null &&
				(foreignEntity = new Query(getCtx(), "R_MailText", "R_MailText_UU=?", get_TrxName())
						.setParameters(R_MailText.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setR_MailText_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Mail Template.
	 *
	 * @return Text templates for mailings
	 */
	@JsonProperty("R_MailText")
	public ForeignEntityInput R_MailText() {
		return mR_MailText;
	}
}
