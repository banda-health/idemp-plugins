package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MElement;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.MTree;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for C_Element - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ElementInput extends MElement implements I_C_ElementInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput ElementType_RL;
	 private I_AD_TreeInput AD_Tree;

	/**
	 * Standard constructor
	 */
	public X_C_ElementInput(String ID) {
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
	 * Set Tree.
	 *
	 * @param AD_Tree Identifies a Tree
	 */
	public void setAD_Tree(I_AD_TreeInput AD_Tree) {
		this.AD_Tree = AD_Tree;
		MTree foreignEntity;
		if (get_ID() == 0 &&AD_Tree != null &&
				(foreignEntity = new Query(getCtx(), MTree.Table_Name, MTree.COLUMNNAME_AD_Tree_UU + "=?", get_TrxName())
						.setParameters(AD_Tree.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Tree_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Tree.
	 *
	 * @return Identifies a Tree
	 */
	public I_AD_TreeInput getAD_Tree() {
		return AD_Tree;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_Element_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_Element_UU();
	}

	/**
	 * Set Type.
	 *
	 * @param ElementType_RL Element Type (account or user defined)
	 */
	public void setElementType_RL(I_AD_Ref_ListInput ElementType_RL) {
		this.ElementType_RL = ElementType_RL;
		MRefList foreignEntity;
		if (get_ID() == 0 &&ElementType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ElementType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setElementType(foreignEntity.getValue());
		}
	}

	/**
	 * Get Type.
	 *
	 * @return Element Type (account or user defined)
	 */
	public I_AD_Ref_ListInput getElementType_RL() {
		return ElementType_RL;
	}
}
