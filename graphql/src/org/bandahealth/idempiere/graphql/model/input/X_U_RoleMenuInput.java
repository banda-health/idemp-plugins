package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;
import org.compiere.model.X_U_RoleMenu;
import org.compiere.model.X_U_WebMenu;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for U_RoleMenu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_U_RoleMenuInput extends X_U_RoleMenu implements I_U_RoleMenuInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Role;
	private ForeignEntityInput mU_WebMenu;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The U_RoleMenu_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_U_RoleMenuInput(@JsonProperty("UU") String UU) {
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
		if (!is_new()) {
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
	 * Set Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public void setAD_RoleInput(ForeignEntityInput AD_Role) {
		this.mAD_Role = AD_Role;
		if (AD_Role != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_Role foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Role", "AD_Role_UU=?", get_TrxName())
							.setParameters(AD_Role.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Role_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Role with UU " + AD_Role.getUU());
			}
		} else {
			this.setAD_Role_ID(-1);
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
	@JsonProperty("U_RoleMenu_ID")
	public void setU_RoleMenu_IDFromJson(int U_RoleMenu_ID) {
		if (get_ID() == 0) {
			super.setU_RoleMenu_ID(U_RoleMenu_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setU_RoleMenu_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (U_WebMenu != null) {
			// Since an entity was passed, make sure it's in the DB
			X_U_WebMenu foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "U_WebMenu", "U_WebMenu_UU=?", get_TrxName())
							.setParameters(U_WebMenu.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setU_WebMenu_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table U_WebMenu with UU " + U_WebMenu.getUU());
			}
		} else {
			this.setU_WebMenu_ID(0);
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
