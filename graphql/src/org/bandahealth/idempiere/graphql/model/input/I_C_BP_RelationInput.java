package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_BP_Relation;

/**
 * Generated Interface for C_BP_Relation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_BP_RelationInput extends I_C_BP_Relation {

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
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(ForeignEntityInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	ForeignEntityInput C_BPartner();

	/**
	 * Set C_BPartner_Location.
	 *
	 * @param C_BPartner_Location Identifies the (ship to) address for this Business Partner
	 */
	void setC_BPartner_LocationInput(ForeignEntityInput C_BPartner_Location);

	/**
	 * Get C_BPartner_Location.
	 *
	 * @return Identifies the (ship to) address for this Business Partner
	 */
	ForeignEntityInput C_BPartner_Location();

	/**
	 * Set C_BPartnerRelation.
	 *
	 * @param C_BPartnerRelation Related Business Partner
	 */
	void setC_BPartnerRelationInput(ForeignEntityInput C_BPartnerRelation);

	/**
	 * Get C_BPartnerRelation.
	 *
	 * @return Related Business Partner
	 */
	ForeignEntityInput C_BPartnerRelation();

	/**
	 * Set C_BPartnerRelation_Location.
	 *
	 * @param C_BPartnerRelation_Location Location of the related Business Partner
	 */
	void setC_BPartnerRelation_LocationInput(ForeignEntityInput C_BPartnerRelation_Location);

	/**
	 * Get C_BPartnerRelation_Location.
	 *
	 * @return Location of the related Business Partner
	 */
	ForeignEntityInput C_BPartnerRelation_Location();
}
