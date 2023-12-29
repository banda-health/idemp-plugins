package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEntityType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Ref_List;
import org.compiere.util.Env;

/**
 * Generated Model for AD_Ref_List - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Ref_ListInput extends X_AD_Ref_List implements I_AD_Ref_ListInput {

	 private I_AD_EntityTypeInput AD_EntityType;
	 private I_AD_OrgInput AD_Org;
	 private I_AD_ReferenceInput AD_Reference;

	/**
	 * Standard constructor
	 */
	public X_AD_Ref_ListInput(String ID) {
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
	 * Set Reference List.
	 *
	 * @param AD_Ref_List_ID Reference List based on Table
	 */

	public void setAD_Ref_List_ID(int AD_Ref_List_ID) {
		if (get_ID() == 0) {
			super.setAD_Ref_List_ID(AD_Ref_List_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Ref_List_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_Ref_List_UU();
	}

	/**
	 * Set Reference.
	 *
	 * @param AD_Reference System Reference and Validation
	 */
	public void setAD_Reference(I_AD_ReferenceInput AD_Reference) {
		this.AD_Reference = AD_Reference;
		MReference_BH foreignEntity;
		if (get_ID() == 0 &&AD_Reference != null &&
				(foreignEntity = new Query(getCtx(), MReference_BH.Table_Name, MReference_BH.COLUMNNAME_AD_Reference_UU + "=?", get_TrxName())
						.setParameters(AD_Reference.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Reference_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	public I_AD_ReferenceInput getAD_Reference() {
		return AD_Reference;
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
	 * Set Add All Access.
	 *
	 * @param BH_Add_All Add All Access
	 */
	public void setBH_Add_All(String BH_Add_All) {
		set_Value(COLUMNNAME_BH_Add_All, BH_Add_All);
	}


	/**
	 * Get Add All Access.
	 *
	 * @return Add All Access
	 */
	public String getBH_Add_All() {
 		return (String) get_Value(COLUMNNAME_BH_Add_All);
	}


	/**
	 * Set Update Existing.
	 *
	 * @param BH_Update_Existing Update Existing
	 */
	public void setBH_Update_Existing(String BH_Update_Existing) {
		set_Value(COLUMNNAME_BH_Update_Existing, BH_Update_Existing);
	}


	/**
	 * Get Update Existing.
	 *
	 * @return Update Existing
	 */
	public String getBH_Update_Existing() {
 		return (String) get_Value(COLUMNNAME_BH_Update_Existing);
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
}
