package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MElement;
import org.compiere.model.MOrg;
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

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mElementType;
	 private I_AD_TreeInput mAD_Tree;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_ElementInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Tree.
	 *
	 * @param AD_Tree Identifies a Tree
	 */
	@JsonProperty("AD_Tree")
	public void setAD_TreeInput(I_AD_TreeInput AD_Tree) {
		this.mAD_Tree = AD_Tree;
		MTree foreignEntity;
		if (get_ID() == 0 &&AD_Tree != null &&
				(foreignEntity = new Query(getCtx(), MTree.Table_Name, MTree.COLUMNNAME_AD_Tree_UU + "=?", get_TrxName())
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
	public I_AD_TreeInput AD_Tree() {
		return mAD_Tree;
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
	 * @param ElementType Element Type (account or user defined)
	 */
	@JsonProperty("ElementType")
	public void setElementTypeInput(I_AD_Ref_ListInput ElementType) {
		this.mElementType = ElementType;
		MRefList_BH foreignEntity;
		if (get_ID() == 0 &&ElementType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ElementType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setElementType(foreignEntity.getValue());
		}
	}

	/**
	 * Get Type.
	 *
	 * @return Element Type (account or user defined)
	 */
	@JsonProperty("ElementType")
	public I_AD_Ref_ListInput ElementType() {
		return mElementType;
	}
}
