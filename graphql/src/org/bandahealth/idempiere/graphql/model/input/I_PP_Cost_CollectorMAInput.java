package org.bandahealth.idempiere.graphql.model.input;

import org.eevolution.model.I_PP_Cost_CollectorMA;

/**
 * Generated Interface for PP_Cost_CollectorMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PP_Cost_CollectorMAInput extends I_PP_Cost_CollectorMA {

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
	 * Set M_AttributeSetInstance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	void setM_AttributeSetInstanceInput(ForeignEntityInput M_AttributeSetInstance);

	/**
	 * Get M_AttributeSetInstance.
	 *
	 * @return Product Attribute Set Instance
	 */
	ForeignEntityInput M_AttributeSetInstance();

	/**
	 * Set PP_Cost_Collector.
	 *
	 * @param PP_Cost_Collector PP_Cost_Collector
	 */
	void setPP_Cost_CollectorInput(ForeignEntityInput PP_Cost_Collector);

	/**
	 * Get PP_Cost_Collector.
	 *
	 * @return PP_Cost_Collector
	 */
	ForeignEntityInput PP_Cost_Collector();

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
