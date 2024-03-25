package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_RMALine;

/**
 * Generated Interface for M_RMALine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_M_RMALineInput extends I_M_RMALine {

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
	 * Set C_Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	void setC_ChargeInput(ForeignEntityInput C_Charge);

	/**
	 * Get C_Charge.
	 *
	 * @return Additional document charges
	 */
	ForeignEntityInput C_Charge();

	/**
	 * Set C_Tax.
	 *
	 * @param C_Tax Tax identifier
	 */
	void setC_TaxInput(ForeignEntityInput C_Tax);

	/**
	 * Get C_Tax.
	 *
	 * @return Tax identifier
	 */
	ForeignEntityInput C_Tax();

	/**
	 * Set M_InOutLine.
	 *
	 * @param M_InOutLine Line on Shipment or Receipt document
	 */
	void setM_InOutLineInput(ForeignEntityInput M_InOutLine);

	/**
	 * Get M_InOutLine.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	ForeignEntityInput M_InOutLine();

	/**
	 * Set M_Product.
	 *
	 * @param M_Product Product, Service, Item
	 */
	void setM_ProductInput(ForeignEntityInput M_Product);

	/**
	 * Get M_Product.
	 *
	 * @return Product, Service, Item
	 */
	ForeignEntityInput M_Product();

	/**
	 * Set M_RMA.
	 *
	 * @param M_RMA Return Material Authorization
	 */
	void setM_RMAInput(ForeignEntityInput M_RMA);

	/**
	 * Get M_RMA.
	 *
	 * @return Return Material Authorization
	 */
	ForeignEntityInput M_RMA();

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	void setUUID(String UUID);

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	String getUUID();

	/**
	 * Set Ref_RMALine.
	 *
	 * @param Ref_RMALine Ref_RMALine
	 */
	void setRef_RMALineInput(ForeignEntityInput Ref_RMALine);

	/**
	 * Get Ref_RMALine.
	 *
	 * @return Ref_RMALine
	 */
	ForeignEntityInput Ref_RMALine();
}
