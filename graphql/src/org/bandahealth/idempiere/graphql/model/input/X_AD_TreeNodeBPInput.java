package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MTree_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTree_NodeBP;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_TreeNodeBP - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_TreeNodeBPInput extends MTree_NodeBP implements I_AD_TreeNodeBPInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Tree;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_TreeNodeBP_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_TreeNodeBPInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MTree_NodeBP(null, (ResultSet) null, null),
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
	 * Set Tree.
	 *
	 * @param AD_Tree Identifies a Tree
	 */
	@JsonProperty("AD_Tree")
	public void setAD_TreeInput(ForeignEntityInput AD_Tree) {
		this.mAD_Tree = AD_Tree;
		MTree_BH foreignEntity;
		if (get_ID() == 0 && AD_Tree != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Tree", "AD_Tree_UU=?", get_TrxName())
							.setParameters(AD_Tree.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Tree_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Tree with UUID " + AD_Tree.getUUID());
			}
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
		setAD_TreeNodeBP_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_TreeNodeBP_UU();
	}
}
