package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for C_UOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_UOMInput extends MUOM implements I_C_UOMInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput UOMType_RL;

	/**
	 * Standard constructor
	 */
	public X_C_UOMInput(String ID) {
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_UOM_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_UOM_UU();
	}

	/**
	 * Set UOM Type.
	 *
	 * @param UOMType_RL UOM Type
	 */
	public void setUOMType_RL(I_AD_Ref_ListInput UOMType_RL) {
		this.UOMType_RL = UOMType_RL;
		MRefList foreignEntity;
		if (UOMType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(UOMType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setUOMType(foreignEntity.getValue());
		} else {
			this.setUOMType(null);
		}
	}

	/**
	 * Get UOM Type.
	 *
	 * @return UOM Type
	 */
	public I_AD_Ref_ListInput getUOMType_RL() {
		return UOMType_RL;
	}
}
