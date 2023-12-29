package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_ChargeType_DocType;
import org.compiere.util.Env;

/**
 * Generated Model for C_ChargeType_DocType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ChargeType_DocTypeInput extends X_C_ChargeType_DocType implements I_C_ChargeType_DocTypeInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_ChargeTypeInput C_ChargeType;
	 private I_C_DocTypeInput C_DocType;

	/**
	 * Standard constructor
	 */
	public X_C_ChargeType_DocTypeInput(String ID) {
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
		setC_ChargeType_DocType_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_ChargeType_DocType_UU();
	}

	/**
	 * Set Charge Type.
	 *
	 * @param C_ChargeType Charge Type
	 */
	public void setC_ChargeType(I_C_ChargeTypeInput C_ChargeType) {
		this.C_ChargeType = C_ChargeType;
		MChargeType_BH foreignEntity;
		if (get_ID() == 0 &&C_ChargeType != null &&
				(foreignEntity = new Query(getCtx(), MChargeType_BH.Table_Name, MChargeType_BH.COLUMNNAME_C_ChargeType_UU + "=?", get_TrxName())
						.setParameters(C_ChargeType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_ChargeType_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Charge Type.
	 *
	 * @return Charge Type
	 */
	public I_C_ChargeTypeInput getC_ChargeType() {
		return C_ChargeType;
	}
	/**
	 * Set Charge Type.
	 *
	 * @param C_ChargeType_ID Charge Type
	 */

	public void setC_ChargeType_ID(int C_ChargeType_ID) {
		if (get_ID() == 0) {
			super.setC_ChargeType_ID(C_ChargeType_ID);
		}
	}

	/**
	 * Set Document Type.
	 *
	 * @param C_DocType Document type or rules
	 */
	public void setC_DocType(I_C_DocTypeInput C_DocType) {
		this.C_DocType = C_DocType;
		MDocType_BH foreignEntity;
		if (get_ID() == 0 &&C_DocType != null &&
				(foreignEntity = new Query(getCtx(), MDocType_BH.Table_Name, MDocType_BH.COLUMNNAME_C_DocType_UU + "=?", get_TrxName())
						.setParameters(C_DocType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_DocType_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public I_C_DocTypeInput getC_DocType() {
		return C_DocType;
	}
	/**
	 * Set Document Type.
	 *
	 * @param C_DocType_ID Document type or rules
	 */

	public void setC_DocType_ID(int C_DocType_ID) {
		if (get_ID() == 0) {
			super.setC_DocType_ID(C_DocType_ID);
		}
	}
}
