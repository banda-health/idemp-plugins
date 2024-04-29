package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MTree_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_TreeNodeU4;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_TreeNodeU4 - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_TreeNodeU4Input extends X_AD_TreeNodeU4 implements I_AD_TreeNodeU4Input {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Tree;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_TreeNodeU4_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_TreeNodeU4Input(@JsonProperty("UU") String UU) {
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
		if (get_ID() != 0) {
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
	 * Set Tree.
	 *
	 * @param AD_Tree Identifies a Tree
	 */
	@JsonProperty("AD_Tree")
	public void setAD_TreeInput(ForeignEntityInput AD_Tree) {
		this.mAD_Tree = AD_Tree;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Tree != null) {
			// Since an entity was passed, make sure it's in the DB
			MTree_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Tree", "AD_Tree_UU=?", get_TrxName())
							.setParameters(AD_Tree.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Tree_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Tree with UU " + AD_Tree.getUU());
			}
		} else {
			this.setAD_Tree_ID(0);
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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_TreeNodeU4_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_TreeNodeU4_UU();
	}
}
