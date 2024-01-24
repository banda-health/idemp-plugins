package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRequestCategory;
import org.compiere.model.Query;
import org.compiere.model.X_R_CategoryUpdates;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for R_CategoryUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_CategoryUpdatesInput extends X_R_CategoryUpdates implements I_R_CategoryUpdatesInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mR_Category;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The R_CategoryUpdates_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_R_CategoryUpdatesInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_R_CategoryUpdates(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
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
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
		if (get_ID() == 0 && AD_User != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(AD_User.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_User_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UUID " + AD_User.getUUID());
			}
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
	 * Set Category.
	 *
	 * @param R_Category Request Category
	 */
	@JsonProperty("R_Category")
	public void setR_CategoryInput(ForeignEntityInput R_Category) {
		this.mR_Category = R_Category;
		MRequestCategory foreignEntity;
		if (get_ID() == 0 && R_Category != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "R_Category", "R_Category_UU=?", get_TrxName())
							.setParameters(R_Category.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_Category_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_Category with UUID " + R_Category.getUUID());
			}
		}
	}

	/**
	 * Get Category.
	 *
	 * @return Request Category
	 */
	@JsonProperty("R_Category")
	public ForeignEntityInput R_Category() {
		return mR_Category;
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setR_CategoryUpdates_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getR_CategoryUpdates_UU();
	}
}
