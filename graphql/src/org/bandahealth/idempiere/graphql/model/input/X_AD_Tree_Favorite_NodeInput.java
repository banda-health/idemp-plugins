package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MMenu_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTreeFavorite;
import org.compiere.model.MTreeFavoriteNode;
import org.compiere.model.Query;
import org.compiere.util.Env;

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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Tree_Favorite_Node_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_Tree_Favorite_NodeInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Menu != null) {
			// Since an entity was passed, make sure it's in the DB
			MMenu_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Menu", "AD_Menu_UU=?", get_TrxName())
							.setParameters(AD_Menu.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Menu_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Menu with UUID " + AD_Menu.getUUID());
			}
		} else {
			this.setAD_Menu_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Tree_Favorite != null) {
			// Since an entity was passed, make sure it's in the DB
			MTreeFavorite foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Tree_Favorite", "AD_Tree_Favorite_UU=?", get_TrxName())
							.setParameters(AD_Tree_Favorite.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Tree_Favorite_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Tree_Favorite with UUID " + AD_Tree_Favorite.getUUID());
			}
		} else {
			this.setAD_Tree_Favorite_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Tree_Favorite_Node_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (Parent != null) {
			// Since an entity was passed, make sure it's in the DB
			MTreeFavoriteNode foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Tree_Favorite_Node", "AD_Tree_Favorite_Node_UU=?", get_TrxName())
							.setParameters(Parent.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setParent_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Tree_Favorite_Node with UUID " + Parent.getUUID());
			}
		} else {
			this.setParent_ID(0);
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
