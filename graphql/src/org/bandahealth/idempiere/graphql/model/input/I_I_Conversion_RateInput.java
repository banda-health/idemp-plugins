package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_I_Conversion_Rate;

/**
 * Generated Interface for I_Conversion_Rate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_I_Conversion_RateInput extends I_I_Conversion_Rate {

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
	 * Set C_Conversion_Rate.
	 *
	 * @param C_Conversion_Rate Rate used for converting currencies
	 */
	void setC_Conversion_RateInput(ForeignEntityInput C_Conversion_Rate);

	/**
	 * Get C_Conversion_Rate.
	 *
	 * @return Rate used for converting currencies
	 */
	ForeignEntityInput C_Conversion_Rate();

	/**
	 * Set C_ConversionType.
	 *
	 * @param C_ConversionType Currency Conversion Rate Type
	 */
	void setC_ConversionTypeInput(ForeignEntityInput C_ConversionType);

	/**
	 * Get C_ConversionType.
	 *
	 * @return Currency Conversion Rate Type
	 */
	ForeignEntityInput C_ConversionType();

	/**
	 * Set C_Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	void setC_CurrencyInput(ForeignEntityInput C_Currency);

	/**
	 * Get C_Currency.
	 *
	 * @return The Currency for this record
	 */
	ForeignEntityInput C_Currency();

	/**
	 * Set C_Currency_To.
	 *
	 * @param C_Currency_To Target currency
	 */
	void setC_Currency_ToInput(ForeignEntityInput C_Currency_To);

	/**
	 * Get C_Currency_To.
	 *
	 * @return Target currency
	 */
	ForeignEntityInput C_Currency_To();

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
}
