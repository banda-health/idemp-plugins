package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRoleIncluded;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Role_Included - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Role_IncludedInput extends MRoleIncluded implements I_AD_Role_IncludedInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Role;
	private ForeignEntityInput mIncluded_Role;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_Role_IncludedInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MRoleIncluded(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public void setAD_RoleInput(ForeignEntityInput AD_Role) {
		this.mAD_Role = AD_Role;
		X_AD_Role foreignEntity;
		if (get_ID() == 0 && AD_Role != null &&
				(foreignEntity = new Query(getCtx(), "AD_Role", "AD_Role_UU=?", get_TrxName())
						.setParameters(AD_Role.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Role_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public ForeignEntityInput AD_Role() {
		return mAD_Role;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Role_Included_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Role_Included_UU();
	}

	/**
	 * Set Included Role.
	 *
	 * @param Included_Role Included Role
	 */
	@JsonProperty("Included_Role")
	public void setIncluded_RoleInput(ForeignEntityInput Included_Role) {
		this.mIncluded_Role = Included_Role;
		X_AD_Role foreignEntity;
		if (get_ID() == 0 && Included_Role != null &&
				(foreignEntity = new Query(getCtx(), "AD_Role", "AD_Role_UU=?", get_TrxName())
						.setParameters(Included_Role.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setIncluded_Role_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Included Role.
	 *
	 * @return Included Role
	 */
	@JsonProperty("Included_Role")
	public ForeignEntityInput Included_Role() {
		return mIncluded_Role;
	}
}
