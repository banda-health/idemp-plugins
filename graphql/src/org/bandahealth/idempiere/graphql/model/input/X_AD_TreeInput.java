package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MTree_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_TreeResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MOrg;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Tree - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_TreeInput extends MTree_BH implements I_AD_TreeInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mParent_Column;
	private ForeignEntityInput mTreeType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_Tree_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_TreeInput(@JsonProperty("UU") String UU) {
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
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Table != null) {
			// Since an entity was passed, make sure it's in the DB
			MTable foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
							.setParameters(AD_Table.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Table_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Table with UU " + AD_Table.getUU());
			}
		} else {
			this.setAD_Table_ID(0);
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	@JsonProperty("AD_Table")
	public ForeignEntityInput AD_Table() {
		return mAD_Table;
	}
	/**
	 * Set Tree.
	 *
	 * @param AD_Tree_ID Identifies a Tree
	 */
	@JsonProperty("AD_Tree_ID")
	public void setAD_Tree_IDFromJson(int AD_Tree_ID) {
		if (get_ID() == 0) {
			super.setAD_Tree_ID(AD_Tree_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_Tree_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_Tree_UU();
	}

	/**
	 * Set Parent Column.
	 *
	 * @param Parent_Column The link column on the parent tab.
	 */
	@JsonProperty("Parent_Column")
	public void setParent_ColumnInput(ForeignEntityInput Parent_Column) {
		this.mParent_Column = Parent_Column;
		if (Parent_Column != null) {
			// Since an entity was passed, make sure it's in the DB
			MColumn foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Column", "AD_Column_UU=?", get_TrxName())
							.setParameters(Parent_Column.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setParent_Column_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Column with UU " + Parent_Column.getUU());
			}
		} else {
			this.setParent_Column_ID(0);
		}
	}

	/**
	 * Get Parent Column.
	 *
	 * @return The link column on the parent tab.
	 */
	@JsonProperty("Parent_Column")
	public ForeignEntityInput Parent_Column() {
		return mParent_Column;
	}

	/**
	 * Set Type | Area.
	 *
	 * @param TreeType Element this tree is built on (i.e Product, Business Partner)
	 */
	@JsonProperty("TreeType")
	public void setTreeTypeInput(ForeignEntityInput TreeType) {
		this.mTreeType = TreeType;
		if (get_ID() != 0) {
			return;
		}
		if (TreeType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_TreeResolver.TREETYPE_UUIDS_BY_VALUE.containsValue(TreeType.getUU())) {
				throw new AdempiereException("The reference list UU of " + TreeType.getUU() +
						" is not in the list defined for the TreeType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(TreeType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setTreeType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + TreeType.getUU());
			}
		} else {
			this.setTreeType(null);
		}
	}

	/**
	 * Get Type | Area.
	 *
	 * @return Element this tree is built on (i.e Product, Business Partner)
	 */
	@JsonProperty("TreeType")
	public ForeignEntityInput TreeType() {
		return mTreeType;
	}
}
