package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MWebMenu;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for U_WebMenu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_U_WebMenuInput extends MWebMenu implements I_U_WebMenuInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mParentMenu;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_U_WebMenuInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MWebMenu(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Parent Menu.
	 *
	 * @param ParentMenu Parent Menu
	 */
	@JsonProperty("ParentMenu")
	public void setParentMenuInput(ForeignEntityInput ParentMenu) {
		this.mParentMenu = ParentMenu;
		MWebMenu foreignEntity;
		if (ParentMenu != null &&
				(foreignEntity = new Query(getCtx(), "U_WebMenu", "U_WebMenu_UU=?", get_TrxName())
						.setParameters(ParentMenu.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setParentMenu_ID(foreignEntity.get_ID());
		} else {
			super.setParentMenu_ID(0);
		}
	}

	/**
	 * Get Parent Menu.
	 *
	 * @return Parent Menu
	 */
	@JsonProperty("ParentMenu")
	public ForeignEntityInput ParentMenu() {
		return mParentMenu;
	}
	/**
	 * Set Web Menu.
	 *
	 * @param U_WebMenu_ID Web Menu
	 */

	public void setU_WebMenu_ID(int U_WebMenu_ID) {
		if (get_ID() == 0) {
			super.setU_WebMenu_ID(U_WebMenu_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setU_WebMenu_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getU_WebMenu_UU();
	}
}
