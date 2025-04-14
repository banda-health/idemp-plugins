package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_LandedCost;

/**
 * Generated Interface for C_LandedCost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_C_LandedCostInput extends I_C_LandedCost {

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
	 * Set C_InvoiceLine.
	 *
	 * @param C_InvoiceLine Invoice Detail Line
	 */
	void setC_InvoiceLineInput(ForeignEntityInput C_InvoiceLine);

	/**
	 * Get C_InvoiceLine.
	 *
	 * @return Invoice Detail Line
	 */
	ForeignEntityInput C_InvoiceLine();

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
	 * Set LandedCostDistribution.
	 *
	 * @param LandedCostDistribution Landed Cost Distribution
	 */
	void setLandedCostDistributionInput(ForeignEntityInput LandedCostDistribution);

	/**
	 * Get LandedCostDistribution.
	 *
	 * @return Landed Cost Distribution
	 */
	ForeignEntityInput LandedCostDistribution();

	/**
	 * Set M_CostElement.
	 *
	 * @param M_CostElement Product Cost Element
	 */
	void setM_CostElementInput(ForeignEntityInput M_CostElement);

	/**
	 * Get M_CostElement.
	 *
	 * @return Product Cost Element
	 */
	ForeignEntityInput M_CostElement();

	/**
	 * Set M_InOut.
	 *
	 * @param M_InOut Material Shipment Document
	 */
	void setM_InOutInput(ForeignEntityInput M_InOut);

	/**
	 * Get M_InOut.
	 *
	 * @return Material Shipment Document
	 */
	ForeignEntityInput M_InOut();

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
}
