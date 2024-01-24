package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MMenu_BH;
import org.bandahealth.idempiere.base.model.MTree_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_TreeBar;
import org.compiere.util.Env;

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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_TreeBar_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_TreeBarInput(@JsonProperty("UUID") String UUID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_TreeBar(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_TreeBar_UU(ID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
}
