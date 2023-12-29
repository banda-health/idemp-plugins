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
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set C_Order.
	 *
	 * @param C_Order Order
	 */
	void setC_Order(I_C_OrderInput C_Order);

	/**
	 * Get C_Order.
	 *
	 * @return Order
	 */
	I_C_OrderInput getC_Order();

	/**
	 * Set C_Phase.
	 *
	 * @param C_Phase Standard Phase of the Project Type
	 */
	void setC_Phase(I_C_PhaseInput C_Phase);

	/**
	 * Get C_Phase.
	 *
	 * @return Standard Phase of the Project Type
	 */
	I_C_PhaseInput getC_Phase();

	/**
	 * Set C_Project.
	 *
	 * @param C_Project Financial Project
	 */
	void setC_Project(I_C_ProjectInput C_Project);

	/**
	 * Get C_Project.
	 *
	 * @return Financial Project
	 */
	I_C_ProjectInput getC_Project();

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
	 * Set ProjInvoiceRule_RL.
	 *
	 * @param ProjInvoiceRule_RL Invoice Rule for the project
	 */
	void setProjInvoiceRule_RL(I_AD_Ref_ListInput ProjInvoiceRule_RL);

	/**
	 * Get ProjInvoiceRule_RL.
	 *
	 * @return Invoice Rule for the project
	 */
	I_AD_Ref_ListInput getProjInvoiceRule_RL();
}
