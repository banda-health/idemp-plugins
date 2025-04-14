package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_ProjectTask;

/**
 * Generated Interface for C_ProjectTask - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_C_ProjectTaskInput extends I_C_ProjectTask {

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
	void setProjInvoiceRuleInput(ForeignEntityInput ProjInvoiceRule);

	/**
	 * Get ProjInvoiceRule.
	 *
	 * @return Invoice Rule for the project
	 */
	ForeignEntityInput ProjInvoiceRule();
}
