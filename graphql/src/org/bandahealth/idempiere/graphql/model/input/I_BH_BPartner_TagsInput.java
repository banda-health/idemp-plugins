package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_BPartner_Tags;

/**
 * Generated Interface for BH_BPartner_Tags - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_BH_BPartner_TagsInput extends I_BH_BPartner_Tags {

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
	 * Set BH_Tags.
	 *
	 * @param BH_Tags BH_Tags
	 */
	void setBH_TagsInput(ForeignEntityInput BH_Tags);

	/**
	 * Get BH_Tags.
	 *
	 * @return BH_Tags
	 */
	ForeignEntityInput BH_Tags();

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
}
