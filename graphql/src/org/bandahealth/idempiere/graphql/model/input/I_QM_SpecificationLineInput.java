package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_QM_SpecificationLine;

/**
 * Generated Interface for QM_SpecificationLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_QM_SpecificationLineInput extends I_QM_SpecificationLine {

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
	 * Set M_Attribute.
	 *
	 * @param M_Attribute Product Attribute
	 */
	void setM_AttributeInput(ForeignEntityInput M_Attribute);

	/**
	 * Get M_Attribute.
	 *
	 * @return Product Attribute
	 */
	ForeignEntityInput M_Attribute();

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

	/**
	 * Set QM_Specification.
	 *
	 * @param QM_Specification QM_Specification
	 */
	void setQM_SpecificationInput(ForeignEntityInput QM_Specification);

	/**
	 * Get QM_Specification.
	 *
	 * @return QM_Specification
	 */
	ForeignEntityInput QM_Specification();

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
}
