package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_ShippingTransactionLine;

/**
 * Generated Interface for M_ShippingTransactionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_ShippingTransactionLineInput extends I_M_ShippingTransactionLine {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

	/**
	 * Set C_UOM_Length.
	 *
	 * @param C_UOM_Length Standard Unit of Measure for Length
	 */
	void setC_UOM_LengthInput(I_C_UOMInput C_UOM_Length);

	/**
	 * Get C_UOM_Length.
	 *
	 * @return Standard Unit of Measure for Length
	 */
	I_C_UOMInput C_UOM_Length();

	/**
	 * Set C_UOM_Weight.
	 *
	 * @param C_UOM_Weight Standard Unit of Measure for Weight
	 */
	void setC_UOM_WeightInput(I_C_UOMInput C_UOM_Weight);

	/**
	 * Get C_UOM_Weight.
	 *
	 * @return Standard Unit of Measure for Weight
	 */
	I_C_UOMInput C_UOM_Weight();

	/**
	 * Set M_PackageMPS.
	 *
	 * @param M_PackageMPS M_PackageMPS
	 */
	void setM_PackageMPSInput(I_M_PackageMPSInput M_PackageMPS);

	/**
	 * Get M_PackageMPS.
	 *
	 * @return M_PackageMPS
	 */
	I_M_PackageMPSInput M_PackageMPS();

	/**
	 * Set M_ShippingTransaction.
	 *
	 * @param M_ShippingTransaction M_ShippingTransaction
	 */
	void setM_ShippingTransactionInput(I_M_ShippingTransactionInput M_ShippingTransaction);

	/**
	 * Get M_ShippingTransaction.
	 *
	 * @return M_ShippingTransaction
	 */
	I_M_ShippingTransactionInput M_ShippingTransaction();

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();
}
