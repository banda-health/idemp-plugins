package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_ProjectLine;

/**
 * Generated Interface for C_ProjectLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_ProjectLineInput extends I_C_ProjectLine {

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
	 * Set C_OrderPO.
	 *
	 * @param C_OrderPO Purchase Order
	 */
	void setC_OrderPOInput(ForeignEntityInput C_OrderPO);

	/**
	 * Get C_OrderPO.
	 *
	 * @return Purchase Order
	 */
	ForeignEntityInput C_OrderPO();

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
	 * Set C_ProjectIssue.
	 *
	 * @param C_ProjectIssue Project Issues (Material, Labor)
	 */
	void setC_ProjectIssueInput(ForeignEntityInput C_ProjectIssue);

	/**
	 * Get C_ProjectIssue.
	 *
	 * @return Project Issues (Material, Labor)
	 */
	ForeignEntityInput C_ProjectIssue();

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
	 * Set C_ProjectTask.
	 *
	 * @param C_ProjectTask Actual Project Task in a Phase
	 */
	void setC_ProjectTaskInput(ForeignEntityInput C_ProjectTask);

	/**
	 * Get C_ProjectTask.
	 *
	 * @return Actual Project Task in a Phase
	 */
	ForeignEntityInput C_ProjectTask();

	/**
	 * Set M_Product_Category.
	 *
	 * @param M_Product_Category Category of a Product
	 */
	void setM_Product_CategoryInput(ForeignEntityInput M_Product_Category);

	/**
	 * Get M_Product_Category.
	 *
	 * @return Category of a Product
	 */
	ForeignEntityInput M_Product_Category();

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
	 * Set M_Production.
	 *
	 * @param M_Production Plan for producing a product
	 */
	void setM_ProductionInput(ForeignEntityInput M_Production);

	/**
	 * Get M_Production.
	 *
	 * @return Plan for producing a product
	 */
	ForeignEntityInput M_Production();
}
