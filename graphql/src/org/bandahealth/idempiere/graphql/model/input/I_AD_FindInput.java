package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Find;

/**
 * Generated Interface for AD_Find - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
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
	 * Set AndOr.
	 *
	 * @param AndOr Logical operation: AND or OR
	 */
	void setAndOrInput(ForeignEntityInput AndOr);

	/**
	 * Get AndOr.
	 *
	 * @return Logical operation: AND or OR
	 */
	ForeignEntityInput AndOr();

	/**
	 * Set Operation.
	 *
	 * @param Operation Compare Operation
	 */
	void setOperationInput(ForeignEntityInput Operation);

	/**
	 * Get Operation.
	 *
	 * @return Compare Operation
	 */
	ForeignEntityInput Operation();
}
