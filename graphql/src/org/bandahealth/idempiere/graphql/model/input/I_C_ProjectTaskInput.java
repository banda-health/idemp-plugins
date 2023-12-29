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
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set C_ProjectPhase.
	 *
	 * @param C_ProjectPhase Phase of a Project
	 */
	void setC_ProjectPhase(I_C_ProjectPhaseInput C_ProjectPhase);

	/**
	 * Get C_ProjectPhase.
	 *
	 * @return Phase of a Project
	 */
	I_C_ProjectPhaseInput getC_ProjectPhase();

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
	void setC_Task(I_C_TaskInput C_Task);

	/**
	 * Get C_Task.
	 *
	 * @return Standard Project Type Task
	 */
	I_C_TaskInput getC_Task();

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
