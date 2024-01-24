package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Find;

/**
 * Generated Interface for AD_Find - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_FindInput extends I_AD_Find {

	/**
	 * Set AD_Column.
	 *
	 * @param AD_Column Column in the table
	 */
	void setAD_ColumnInput(ForeignEntityInput AD_Column);

	/**
	 * Get AD_Column.
	 *
	 * @return Column in the table
	 */
	ForeignEntityInput AD_Column();

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
	 * Set AndOr.
	 *
	 * @param AndOr Logical operation: AND or OR
	 */
	void setAndOrInput(I_AD_Ref_ListInput AndOr);

	/**
	 * Get AndOr.
	 *
	 * @return Logical operation: AND or OR
	 */
	I_AD_Ref_ListInput AndOr();

	/**
	 * Set Operation.
	 *
	 * @param Operation Compare Operation
	 */
	void setOperationInput(I_AD_Ref_ListInput Operation);

	/**
	 * Get Operation.
	 *
	 * @return Compare Operation
	 */
	I_AD_Ref_ListInput Operation();
}
