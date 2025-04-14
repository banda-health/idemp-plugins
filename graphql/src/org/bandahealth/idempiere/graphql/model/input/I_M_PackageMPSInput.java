package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_PackageMPS;

/**
 * Generated Interface for M_PackageMPS - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_M_PackageMPSInput extends I_M_PackageMPS {

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
	 * Set C_UOM_Length.
	 *
	 * @param C_UOM_Length Standard Unit of Measure for Length
	 */
	void setC_UOM_LengthInput(ForeignEntityInput C_UOM_Length);

	/**
	 * Get C_UOM_Length.
	 *
	 * @return Standard Unit of Measure for Length
	 */
	ForeignEntityInput C_UOM_Length();

	/**
	 * Set C_UOM_Weight.
	 *
	 * @param C_UOM_Weight Standard Unit of Measure for Weight
	 */
	void setC_UOM_WeightInput(ForeignEntityInput C_UOM_Weight);

	/**
	 * Get C_UOM_Weight.
	 *
	 * @return Standard Unit of Measure for Weight
	 */
	ForeignEntityInput C_UOM_Weight();

	/**
	 * Set M_Package.
	 *
	 * @param M_Package Shipment Package
	 */
	void setM_PackageInput(ForeignEntityInput M_Package);

	/**
	 * Get M_Package.
	 *
	 * @return Shipment Package
	 */
	ForeignEntityInput M_Package();

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
}
