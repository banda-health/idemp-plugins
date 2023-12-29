package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_MatchInv;

/**
 * Generated Interface for M_MatchInv - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_MatchInvInput extends I_M_MatchInv {

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
	 * Set C_InvoiceLine.
	 *
	 * @param C_InvoiceLine Invoice Detail Line
	 */
	void setC_InvoiceLine(I_C_InvoiceLineInput C_InvoiceLine);

	/**
	 * Get C_InvoiceLine.
	 *
	 * @return Invoice Detail Line
	 */
	I_C_InvoiceLineInput getC_InvoiceLine();

	/**
	 * Set M_AttributeSetInstance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	void setM_AttributeSetInstance(I_M_AttributeSetInstanceInput M_AttributeSetInstance);

	/**
	 * Get M_AttributeSetInstance.
	 *
	 * @return Product Attribute Set Instance
	 */
	I_M_AttributeSetInstanceInput getM_AttributeSetInstance();

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
	 * Set Posted_RL.
	 *
	 * @param Posted_RL Posting status
	 */
	void setPosted_RL(I_AD_Ref_ListInput Posted_RL);

	/**
	 * Get Posted_RL.
	 *
	 * @return Posting status
	 */
	I_AD_Ref_ListInput getPosted_RL();

	/**
	 * Set Ref_MatchInv.
	 *
	 * @param Ref_MatchInv Ref_MatchInv
	 */
	void setRef_MatchInv(I_M_MatchInvInput Ref_MatchInv);

	/**
	 * Get Ref_MatchInv.
	 *
	 * @return Ref_MatchInv
	 */
	I_M_MatchInvInput getRef_MatchInv();

	/**
	 * Set Reversal.
	 *
	 * @param Reversal ID of document reversal
	 */
	void setReversal(I_M_MatchInvInput Reversal);

	/**
	 * Get Reversal.
	 *
	 * @return ID of document reversal
	 */
	I_M_MatchInvInput getReversal();
}
