package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Payer_Info_Fld;

/**
 * Generated Interface for BH_Payer_Info_Fld - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_BH_Payer_Info_FldInput extends I_BH_Payer_Info_Fld {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within tenant
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set BH_Payer.
	 *
	 * @param BH_Payer BH_Payer
	 */
	void setBH_PayerInput(ForeignEntityInput BH_Payer);

	/**
	 * Get BH_Payer.
	 *
	 * @return BH_Payer
	 */
	ForeignEntityInput BH_Payer();

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	void setUU(String UU);

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	String getUU();

	/**
	 * Set BH_PayerInfoFieldDataType.
	 *
	 * @param BH_PayerInfoFieldDataType BH_PayerInfoFieldDataType
	 */
	void setBH_PayerInfoFieldDataTypeInput(ForeignEntityInput BH_PayerInfoFieldDataType);

	/**
	 * Get BH_PayerInfoFieldDataType.
	 *
	 * @return BH_PayerInfoFieldDataType
	 */
	ForeignEntityInput BH_PayerInfoFieldDataType();
}
