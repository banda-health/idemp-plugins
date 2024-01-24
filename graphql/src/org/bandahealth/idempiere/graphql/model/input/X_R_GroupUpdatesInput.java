package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MGroup;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_R_GroupUpdates;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for R_GroupUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_GroupUpdatesInput extends X_R_GroupUpdates implements I_R_GroupUpdatesInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_User;
	private ForeignEntityInput mR_Group;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The R_GroupUpdates_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_R_GroupUpdatesInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_R_GroupUpdates(null, (ResultSet) null, null),
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
	 * Set Group.
	 *
	 * @param R_Group Request Group
	 */
	@JsonProperty("R_Group")
	public void setR_GroupInput(ForeignEntityInput R_Group) {
		this.mR_Group = R_Group;
		MGroup foreignEntity;
		if (get_ID() == 0 && R_Group != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "R_Group", "R_Group_UU=?", get_TrxName())
							.setParameters(R_Group.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_Group_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_Group with UUID " + R_Group.getUUID());
			}
		}
	}

	/**
	 * Get Group.
	 *
	 * @return Request Group
	 */
	@JsonProperty("R_Group")
	public ForeignEntityInput R_Group() {
		return mR_Group;
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setR_GroupUpdates_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getR_GroupUpdates_UU();
	}
}
