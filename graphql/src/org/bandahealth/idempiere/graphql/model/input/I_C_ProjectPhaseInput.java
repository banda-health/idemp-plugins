package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_ProjectPhase;

/**
 * Generated Interface for C_ProjectPhase - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_ProjectPhaseInput extends I_C_ProjectPhase {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set C_Order.
	 *
	 * @param C_Order Order
	 */
	void setC_OrderInput(ForeignEntityInput C_Order);

	/**
	 * Get C_Order.
	 *
	 * @return Order
	 */
	ForeignEntityInput C_Order();

	/**
	 * Set C_Phase.
	 *
	 * @param C_Phase Standard Phase of the Project Type
	 */
	void setC_PhaseInput(ForeignEntityInput C_Phase);

	/**
	 * Get C_Phase.
	 *
	 * @return Standard Phase of the Project Type
	 */
	ForeignEntityInput C_Phase();

	/**
	 * Set C_Project.
	 *
	 * @param C_Project Financial Project
	 */
	void setC_ProjectInput(ForeignEntityInput C_Project);

	/**
	 * Get C_Project.
	 *
	 * @return Financial Project
	 */
	ForeignEntityInput C_Project();

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
	void setM_ProductInput(ForeignEntityInput M_Product);

	/**
	 * Get M_Product.
	 *
	 * @return Product, Service, Item
	 */
	ForeignEntityInput M_Product();

	/**
	 * Set ProjInvoiceRule.
	 *
	 * @param ProjInvoiceRule Invoice Rule for the project
	 */
	void setProjInvoiceRuleInput(I_AD_Ref_ListInput ProjInvoiceRule);

	/**
	 * Get ProjInvoiceRule.
	 *
	 * @return Invoice Rule for the project
	 */
	I_AD_Ref_ListInput ProjInvoiceRule();
}
