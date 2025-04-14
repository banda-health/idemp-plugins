package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_ShippingTransactionLine;

/**
 * Generated Interface for M_ShippingTransactionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_M_ShippingTransactionLineInput extends I_M_ShippingTransactionLine {

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
	 * Set C_UOM_Length.
	 *
	 * @param C_UOM_Length Standard Unit of Measure for Length
	 */
	void setC_UOM_LengthInput(ForeignEntityInput C_UOM_Length);

	/**
	 * Get C_UOM_Length.
	 *
	 * @return Standard Unit of Measure for Length
	 */
	ForeignEntityInput C_UOM_Length();

	/**
	 * Set C_UOM_Weight.
	 *
	 * @param C_UOM_Weight Standard Unit of Measure for Weight
	 */
	void setC_UOM_WeightInput(ForeignEntityInput C_UOM_Weight);

	/**
	 * Get C_UOM_Weight.
	 *
	 * @return Standard Unit of Measure for Weight
	 */
	ForeignEntityInput C_UOM_Weight();

	/**
	 * Set M_PackageMPS.
	 *
	 * @param M_PackageMPS M_PackageMPS
	 */
	void setM_PackageMPSInput(ForeignEntityInput M_PackageMPS);

	/**
	 * Get M_PackageMPS.
	 *
	 * @return M_PackageMPS
	 */
	ForeignEntityInput M_PackageMPS();

	/**
	 * Set M_ShippingTransaction.
	 *
	 * @param M_ShippingTransaction M_ShippingTransaction
	 */
	void setM_ShippingTransactionInput(ForeignEntityInput M_ShippingTransaction);

	/**
	 * Get M_ShippingTransaction.
	 *
	 * @return M_ShippingTransaction
	 */
	ForeignEntityInput M_ShippingTransaction();

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
