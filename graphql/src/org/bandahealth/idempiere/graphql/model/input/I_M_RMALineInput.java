package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_RMALine;

/**
 * Generated Interface for M_RMALine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_RMALineInput extends I_M_RMALine {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set C_Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	void setC_Charge(I_C_ChargeInput C_Charge);

	/**
	 * Get C_Charge.
	 *
	 * @return Additional document charges
	 */
	I_C_ChargeInput getC_Charge();

	/**
	 * Set C_Tax.
	 *
	 * @param C_Tax Tax identifier
	 */
	void setC_Tax(I_C_TaxInput C_Tax);

	/**
	 * Get C_Tax.
	 *
	 * @return Tax identifier
	 */
	I_C_TaxInput getC_Tax();

	/**
	 * Set M_InOutLine.
	 *
	 * @param M_InOutLine Line on Shipment or Receipt document
	 */
	void setM_InOutLine(I_M_InOutLineInput M_InOutLine);

	/**
	 * Get M_InOutLine.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	I_M_InOutLineInput getM_InOutLine();

	/**
	 * Set M_Product.
	 *
	 * @param M_Product Product, Service, Item
	 */
	void setM_Product(I_M_ProductInput M_Product);

	/**
	 * Get M_Product.
	 *
	 * @return Product, Service, Item
	 */
	I_M_ProductInput getM_Product();

	/**
	 * Set M_RMA.
	 *
	 * @param M_RMA Return Material Authorization
	 */
	void setM_RMA(I_M_RMAInput M_RMA);

	/**
	 * Get M_RMA.
	 *
	 * @return Return Material Authorization
	 */
	I_M_RMAInput getM_RMA();

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

	/**
	 * Set Ref_RMALine.
	 *
	 * @param Ref_RMALine Ref_RMALine
	 */
	void setRef_RMALine(I_M_RMALineInput Ref_RMALine);

	/**
	 * Get Ref_RMALine.
	 *
	 * @return Ref_RMALine
	 */
	I_M_RMALineInput getRef_RMALine();
}
