package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRoleMenu;
import org.compiere.model.MWebMenu;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;

import java.sql.ResultSet;

/**
 * Generated Model for U_RoleMenu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_U_RoleMenuInput extends MRoleMenu implements I_U_RoleMenuInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Role;
	private ForeignEntityInput mU_WebMenu;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_U_RoleMenuInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MRoleMenu(null, (ResultSet) null, null), null, Table_Name, ID),
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
		if (AD_Role != null &&
				(foreignEntity = new Query(getCtx(), "AD_Role", "AD_Role_UU=?", get_TrxName())
						.setParameters(AD_Role.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Role_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Role_ID(0);
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
	 * Set Role Menu.
	 *
	 * @param U_RoleMenu_ID Role Menu
	 */

	public void setU_RoleMenu_ID(int U_RoleMenu_ID) {
		if (get_ID() == 0) {
			super.setU_RoleMenu_ID(U_RoleMenu_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setU_RoleMenu_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getU_RoleMenu_UU();
	}

	/**
	 * Set Web Menu.
	 *
	 * @param U_WebMenu Web Menu
	 */
	@JsonProperty("U_WebMenu")
	public void setU_WebMenuInput(ForeignEntityInput U_WebMenu) {
		this.mU_WebMenu = U_WebMenu;
		MWebMenu foreignEntity;
		if (U_WebMenu != null &&
				(foreignEntity = new Query(getCtx(), "U_WebMenu", "U_WebMenu_UU=?", get_TrxName())
						.setParameters(U_WebMenu.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setU_WebMenu_ID(foreignEntity.get_ID());
		} else {
			super.setU_WebMenu_ID(0);
		}
	}

	/**
	 * Get Web Menu.
	 *
	 * @return Web Menu
	 */
	@JsonProperty("U_WebMenu")
	public ForeignEntityInput U_WebMenu() {
		return mU_WebMenu;
	}
}
