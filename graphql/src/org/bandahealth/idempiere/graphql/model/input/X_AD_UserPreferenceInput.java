package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUserPreference_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_UserPreference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_UserPreferenceInput extends MUserPreference_BH implements I_AD_UserPreferenceInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private I_AD_Ref_ListInput mViewFindResult;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_UserPreferenceInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MUserPreference_BH(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set AD_UserPreference_ID.
	 *
	 * @param AD_UserPreference_ID AD_UserPreference_ID
	 */

	public void setAD_UserPreference_ID(int AD_UserPreference_ID) {
		if (get_ID() == 0) {
			super.setAD_UserPreference_ID(AD_UserPreference_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_UserPreference_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_UserPreference_UU();
	}

	/**
	 * Set View find result.
	 *
	 * @param ViewFindResult Does the system must switch to grid mode after the Find panel closes
	 */
	@JsonProperty("ViewFindResult")
	public void setViewFindResultInput(I_AD_Ref_ListInput ViewFindResult) {
		this.mViewFindResult = ViewFindResult;
		MRefList_BH foreignEntity;
		if (ViewFindResult != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ViewFindResult.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setViewFindResult(foreignEntity.getValue());
		} else {
			this.setViewFindResult(null);
		}
	}

	/**
	 * Get View find result.
	 *
	 * @return Does the system must switch to grid mode after the Find panel closes
	 */
	@JsonProperty("ViewFindResult")
	public I_AD_Ref_ListInput ViewFindResult() {
		return mViewFindResult;
	}
}
