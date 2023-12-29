package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MElementValue;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_SubAcct;
import org.compiere.util.Env;

/**
 * Generated Model for C_SubAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_SubAcctInput extends X_C_SubAcct implements I_C_SubAcctInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_ElementValueInput C_ElementValue;

	/**
	 * Standard constructor
	 */
	public X_C_SubAcctInput(String ID) {
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
	 * Set Account Element.
	 *
	 * @param C_ElementValue Account Element
	 */
	public void setC_ElementValue(I_C_ElementValueInput C_ElementValue) {
		this.C_ElementValue = C_ElementValue;
		MElementValue foreignEntity;
		if (get_ID() == 0 &&C_ElementValue != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(C_ElementValue.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_ElementValue_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Account Element.
	 *
	 * @return Account Element
	 */
	public I_C_ElementValueInput getC_ElementValue() {
		return C_ElementValue;
	}
	/**
	 * Set Account Element.
	 *
	 * @param C_ElementValue_ID Account Element
	 */

	public void setC_ElementValue_ID(int C_ElementValue_ID) {
		if (get_ID() == 0) {
			super.setC_ElementValue_ID(C_ElementValue_ID);
		}
	}
	/**
	 * Set Sub Account.
	 *
	 * @param C_SubAcct_ID Sub account for Element Value
	 */

	public void setC_SubAcct_ID(int C_SubAcct_ID) {
		if (get_ID() == 0) {
			super.setC_SubAcct_ID(C_SubAcct_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_SubAcct_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_SubAcct_UU();
	}
}
