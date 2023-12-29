package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.M_Element;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Reference;
import org.compiere.util.Env;

/**
 * Generated Model for AD_Reference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ReferenceInput extends X_AD_Reference implements I_AD_ReferenceInput {

	 private I_AD_ElementInput AD_Element;
	 private I_AD_EntityTypeInput AD_EntityType;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput ValidationType_RL;

	/**
	 * Standard constructor
	 */
	public X_AD_ReferenceInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set System Element.
	 *
	 * @param AD_Element System Element enables the central maintenance of column description and help.
	 */
	public void setAD_Element(I_AD_ElementInput AD_Element) {
		this.AD_Element = AD_Element;
		M_Element foreignEntity;
		if (AD_Element != null &&
				(foreignEntity = new Query(getCtx(), M_Element.Table_Name, M_Element.COLUMNNAME_AD_Element_UU + "=?", get_TrxName())
						.setParameters(AD_Element.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Element_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Element_ID(0);
		}
	}

	/**
	 * Get System Element.
	 *
	 * @return System Element enables the central maintenance of column description and help.
	 */
	public I_AD_ElementInput getAD_Element() {
		return AD_Element;
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
	 * Set Reference.
	 *
	 * @param AD_Reference_ID System Reference and Validation
	 */

	public void setAD_Reference_ID(int AD_Reference_ID) {
		if (get_ID() == 0) {
			super.setAD_Reference_ID(AD_Reference_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Reference_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Reference_UU();
	}

	/**
	 * Set Entity Type.
	 *
	 * @param AD_EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */
	public void setAD_EntityType(I_AD_EntityTypeInput AD_EntityType) {
		this.AD_EntityType = AD_EntityType;
		MEntityType foreignEntity;
		if (AD_EntityType != null &&
				(foreignEntity = new Query(getCtx(), MEntityType.Table_Name, MEntityType.COLUMNNAME_AD_EntityType_UU + "=?", get_TrxName())
						.setParameters(AD_EntityType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setEntityType(foreignEntity.getEntityType());
		} else {
			this.setEntityType(null);
		}
	}

	/**
	 * Get Entity Type.
	 *
	 * @return Dictionary Entity Type; Determines ownership and synchronization
	 */
	public I_AD_EntityTypeInput getAD_EntityType() {
		return AD_EntityType;
	}
	/**
	 * Set Entity Type.
	 *
	 * @param EntityType Dictionary Entity Type; Determines ownership and synchronization
	 */

	public void setEntityType(String EntityType) {
		if (get_ID() == 0) {
			super.setEntityType(EntityType);
		}
	}

	/**
	 * Set Validation type.
	 *
	 * @param ValidationType_RL Different method of validating data
	 */
	public void setValidationType_RL(I_AD_Ref_ListInput ValidationType_RL) {
		this.ValidationType_RL = ValidationType_RL;
		MRefList foreignEntity;
		if (ValidationType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ValidationType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setValidationType(foreignEntity.getValue());
		} else {
			this.setValidationType(null);
		}
	}

	/**
	 * Get Validation type.
	 *
	 * @return Different method of validating data
	 */
	public I_AD_Ref_ListInput getValidationType_RL() {
		return ValidationType_RL;
	}
}
