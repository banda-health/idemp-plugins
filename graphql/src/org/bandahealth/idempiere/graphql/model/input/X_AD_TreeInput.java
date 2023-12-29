package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Tree;
import org.compiere.util.Env;

/**
 * Generated Model for AD_Tree - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_TreeInput extends X_AD_Tree implements I_AD_TreeInput {

	 private I_AD_ColumnInput Parent_Column;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput TreeType_RL;
	 private I_AD_TableInput AD_Table;

	/**
	 * Standard constructor
	 */
	public X_AD_TreeInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	public void setAD_Table(I_AD_TableInput AD_Table) {
		this.AD_Table = AD_Table;
		MTable foreignEntity;
		if (get_ID() == 0 &&AD_Table != null &&
				(foreignEntity = new Query(getCtx(), MTable.Table_Name, MTable.COLUMNNAME_AD_Table_UU + "=?", get_TrxName())
						.setParameters(AD_Table.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Table_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public I_AD_TableInput getAD_Table() {
		return AD_Table;
	}
	/**
	 * Set Table.
	 *
	 * @param AD_Table_ID Database Table information
	 */

	public void setAD_Table_ID(int AD_Table_ID) {
		if (get_ID() == 0) {
			super.setAD_Table_ID(AD_Table_ID);
		}
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
	public void setParent_Column(I_AD_ColumnInput Parent_Column) {
		this.Parent_Column = Parent_Column;
		MColumn foreignEntity;
		if (Parent_Column != null &&
				(foreignEntity = new Query(getCtx(), MColumn.Table_Name, MColumn.COLUMNNAME_AD_Column_UU + "=?", get_TrxName())
						.setParameters(Parent_Column.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setParent_Column_ID(foreignEntity.get_ID());
		} else {
			this.setParent_Column_ID(0);
		}
	}

	/**
	 * Get Parent Column.
	 *
	 * @return The link column on the parent tab.
	 */
	public I_AD_ColumnInput getParent_Column() {
		return Parent_Column;
	}
	/**
	 * Set Parent Column.
	 *
	 * @param Parent_Column_ID The link column on the parent tab.
	 */

	public void setParent_Column_ID(int Parent_Column_ID) {
		if (get_ID() == 0) {
			super.setParent_Column_ID(Parent_Column_ID);
		}
	}

	/**
	 * Set Type | Area.
	 *
	 * @param TreeType_RL Element this tree is built on (i.e Product, Business Partner)
	 */
	public void setTreeType_RL(I_AD_Ref_ListInput TreeType_RL) {
		this.TreeType_RL = TreeType_RL;
		MRefList foreignEntity;
		if (get_ID() == 0 &&TreeType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(TreeType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setTreeType(foreignEntity.getValue());
		}
	}

	/**
	 * Get Type | Area.
	 *
	 * @return Element this tree is built on (i.e Product, Business Partner)
	 */
	public I_AD_Ref_ListInput getTreeType_RL() {
		return TreeType_RL;
	}
}
