package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_ProjectTask;

/**
 * Generated Interface for C_ProjectTask - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_ProjectTaskInput extends I_C_ProjectTask {

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
	 * Set C_ProjectPhase.
	 *
	 * @param C_ProjectPhase Phase of a Project
	 */
	void setC_ProjectPhaseInput(ForeignEntityInput C_ProjectPhase);

	/**
	 * Get C_ProjectPhase.
	 *
	 * @return Phase of a Project
	 */
	ForeignEntityInput C_ProjectPhase();

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
	 * Set C_Task.
	 *
	 * @param C_Task Standard Project Type Task
	 */
	void setC_TaskInput(ForeignEntityInput C_Task);

	/**
	 * Get C_Task.
	 *
	 * @return Standard Project Type Task
	 */
	ForeignEntityInput C_Task();

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
