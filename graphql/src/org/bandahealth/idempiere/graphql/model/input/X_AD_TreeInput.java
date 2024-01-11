package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MTree_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MOrg;
import org.compiere.model.MTable;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Tree - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeInput extends MTree_BH implements I_AD_TreeInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mParent_Column;
	private I_AD_Ref_ListInput mTreeType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_TreeInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MTree_BH(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		MTable foreignEntity;
		if (get_ID() == 0 && AD_Table != null &&
				(foreignEntity = new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
						.setParameters(AD_Table.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Table_ID(foreignEntity.get_ID());
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

	public void setAD_Tree_ID(int AD_Tree_ID) {
		if (get_ID() == 0) {
			super.setAD_Tree_ID(AD_Tree_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Tree_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		MColumn foreignEntity;
		if (Parent_Column != null &&
				(foreignEntity = new Query(getCtx(), "AD_Column", "AD_Column_UU=?", get_TrxName())
						.setParameters(Parent_Column.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setParent_Column_ID(foreignEntity.get_ID());
		} else {
			super.setParent_Column_ID(0);
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
	public void setTreeTypeInput(I_AD_Ref_ListInput TreeType) {
		this.mTreeType = TreeType;
		MRefList_BH foreignEntity;
		if (get_ID() == 0 &&TreeType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(TreeType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setTreeType(foreignEntity.getValue());
		}
	}

	/**
	 * Get Type | Area.
	 *
	 * @return Element this tree is built on (i.e Product, Business Partner)
	 */
	@JsonProperty("TreeType")
	public I_AD_Ref_ListInput TreeType() {
		return mTreeType;
	}
}
