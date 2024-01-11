package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MMenu_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTreeFavorite;
import org.compiere.model.MTreeFavoriteNode;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Tree_Favorite_Node - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Tree_Favorite_NodeInput extends MTreeFavoriteNode implements I_AD_Tree_Favorite_NodeInput {

	private ForeignEntityInput mAD_Menu;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Tree_Favorite;
	private ForeignEntityInput mParent;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_Tree_Favorite_NodeInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MTreeFavoriteNode(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Favorite Tree.
	 *
	 * @param AD_Tree_Favorite Favorite Tree
	 */
	@JsonProperty("AD_Tree_Favorite")
	public void setAD_Tree_FavoriteInput(ForeignEntityInput AD_Tree_Favorite) {
		this.mAD_Tree_Favorite = AD_Tree_Favorite;
		MTreeFavorite foreignEntity;
		if (get_ID() == 0 && AD_Tree_Favorite != null &&
				(foreignEntity = new Query(getCtx(), "AD_Tree_Favorite", "AD_Tree_Favorite_UU=?", get_TrxName())
						.setParameters(AD_Tree_Favorite.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Tree_Favorite_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Favorite Tree.
	 *
	 * @return Favorite Tree
	 */
	@JsonProperty("AD_Tree_Favorite")
	public ForeignEntityInput AD_Tree_Favorite() {
		return mAD_Tree_Favorite;
	}
	/**
	 * Set Favorite Node Tree.
	 *
	 * @param AD_Tree_Favorite_Node_ID Favorite Node Tree
	 */

	public void setAD_Tree_Favorite_Node_ID(int AD_Tree_Favorite_Node_ID) {
		if (get_ID() == 0) {
			super.setAD_Tree_Favorite_Node_ID(AD_Tree_Favorite_Node_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Tree_Favorite_Node_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Tree_Favorite_Node_UU();
	}

	/**
	 * Set Parent.
	 *
	 * @param Parent Parent of Entity
	 */
	@JsonProperty("Parent")
	public void setParentInput(ForeignEntityInput Parent) {
		this.mParent = Parent;
		MTreeFavoriteNode foreignEntity;
		if (Parent != null &&
				(foreignEntity = new Query(getCtx(), "AD_Tree_Favorite_Node", "AD_Tree_Favorite_Node_UU=?", get_TrxName())
						.setParameters(Parent.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setParent_ID(foreignEntity.get_ID());
		} else {
			super.setParent_ID(0);
		}
	}

	/**
	 * Get Parent.
	 *
	 * @return Parent of Entity
	 */
	@JsonProperty("Parent")
	public ForeignEntityInput Parent() {
		return mParent;
	}
}
