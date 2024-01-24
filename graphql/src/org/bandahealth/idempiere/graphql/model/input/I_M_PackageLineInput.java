package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_PackageLine;

/**
 * Generated Interface for M_PackageLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_PackageLineInput extends I_M_PackageLine {

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
	 * Set M_InOutLine.
	 *
	 * @param M_InOutLine Line on Shipment or Receipt document
	 */
	void setM_InOutLineInput(ForeignEntityInput M_InOutLine);

	/**
	 * Get M_InOutLine.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	ForeignEntityInput M_InOutLine();

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
	 * Set M_PackageMPS.
	 *
	 * @param M_PackageMPS M_PackageMPS
	 */
	void setM_PackageMPSInput(ForeignEntityInput M_PackageMPS);

	/**
	 * Get M_PackageMPS.
	 *
	 * @return M_PackageMPS
	 */
	ForeignEntityInput M_PackageMPS();

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
}
