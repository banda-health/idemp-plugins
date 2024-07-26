package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_UserPreferenceResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MUserPreference;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_UserPreference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_UserPreferenceInput extends MUserPreference implements I_AD_UserPreferenceInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mViewFindResult;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_UserPreference_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_UserPreferenceInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
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
	 * @param AD_User User within the system - Internal or Business Partner Contact
	 */
	@JsonProperty("AD_User")
	public void setAD_UserInput(ForeignEntityInput AD_User) {
		this.mAD_User = AD_User;
		if (get_ID() != 0) {
			return;
		}
		if (AD_User != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + AD_User.getUU());
			}
		} else {
			this.setAD_User_ID(0);
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
	@JsonProperty("AD_UserPreference_ID")
	public void setAD_UserPreference_IDFromJson(int AD_UserPreference_ID) {
		if (get_ID() == 0) {
			super.setAD_UserPreference_ID(AD_UserPreference_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_UserPreference_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_UserPreference_UU();
	}

	/**
	 * Set View find result.
	 *
	 * @param ViewFindResult Does the system must switch to grid mode after the Find panel closes
	 */
	@JsonProperty("ViewFindResult")
	public void setViewFindResultInput(ForeignEntityInput ViewFindResult) {
		this.mViewFindResult = ViewFindResult;
		if (ViewFindResult != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_UserPreferenceResolver.VIEWFINDRESULT_UUIDS_BY_VALUE.containsValue(ViewFindResult.getUU())) {
				throw new AdempiereException("The reference list UU of " + ViewFindResult.getUU() +
						" is not in the list defined for the ViewFindResult column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ViewFindResult.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setViewFindResult(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ViewFindResult.getUU());
			}
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
	public ForeignEntityInput ViewFindResult() {
		return mViewFindResult;
	}
}
