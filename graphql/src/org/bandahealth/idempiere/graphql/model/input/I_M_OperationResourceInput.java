package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_OperationResource;

/**
 * Generated Interface for M_OperationResource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_OperationResourceInput extends I_M_OperationResource {

	/**
	 * Set A_Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	void setA_AssetInput(ForeignEntityInput A_Asset);

	/**
	 * Get A_Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	ForeignEntityInput A_Asset();

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
	 * Set C_Job.
	 *
	 * @param C_Job Job Position
	 */
	void setC_JobInput(ForeignEntityInput C_Job);

	/**
	 * Get C_Job.
	 *
	 * @return Job Position
	 */
	ForeignEntityInput C_Job();

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
	 * Set M_ProductOperation.
	 *
	 * @param M_ProductOperation Product Manufacturing Operation
	 */
	void setM_ProductOperationInput(ForeignEntityInput M_ProductOperation);

	/**
	 * Get M_ProductOperation.
	 *
	 * @return Product Manufacturing Operation
	 */
	ForeignEntityInput M_ProductOperation();
}
