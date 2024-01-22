package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MMenu_BH;
import org.bandahealth.idempiere.base.model.MTree_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_TreeBar;

import java.sql.ResultSet;

/**
 * Generated Model for AD_TreeBar - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_TreeBarInput extends X_AD_TreeBar implements I_AD_TreeBarInput {

	private ForeignEntityInput mAD_Menu;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Tree;
	private ForeignEntityInput mAD_User;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_TreeBarInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_TreeBar(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Menu.
	 *
	 * @param AD_Menu Identifies a Menu
	 */
	@JsonProperty("AD_Menu")
	public void setAD_MenuInput(ForeignEntityInput AD_Menu) {
		this.mAD_Menu = AD_Menu;
		MMenu_BH foreignEntity;
		if (get_ID() == 0 && AD_Menu != null &&
				(foreignEntity = new Query(getCtx(), "AD_Menu", "AD_Menu_UU=?", get_TrxName())
						.setParameters(AD_Menu.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Menu_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Menu.
	 *
	 * @return Identifies a Menu
	 */
	@JsonProperty("AD_Menu")
	public ForeignEntityInput AD_Menu() {
		return mAD_Menu;
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
	 * Set Tree.
	 *
	 * @param AD_Tree Identifies a Tree
	 */
	@JsonProperty("AD_Tree")
	public void setAD_TreeInput(ForeignEntityInput AD_Tree) {
		this.mAD_Tree = AD_Tree;
		MTree_BH foreignEntity;
		if (get_ID() == 0 && AD_Tree != null &&
				(foreignEntity = new Query(getCtx(), "AD_Tree", "AD_Tree_UU=?", get_TrxName())
						.setParameters(AD_Tree.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tree_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Tree.
	 *
	 * @return Identifies a Tree
	 */
	@JsonProperty("AD_Tree")
	public ForeignEntityInput AD_Tree() {
		return mAD_Tree;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_TreeBar_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_TreeBar_UU();
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
}
