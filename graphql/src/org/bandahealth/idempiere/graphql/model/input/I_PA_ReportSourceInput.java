package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_ReportSource;

/**
 * Generated Interface for PA_ReportSource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PA_ReportSourceInput extends I_PA_ReportSource {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set C_Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	void setC_Activity(I_C_ActivityInput C_Activity);

	/**
	 * Get C_Activity.
	 *
	 * @return Business Activity
	 */
	I_C_ActivityInput getC_Activity();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartner(I_C_BPartnerInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	I_C_BPartnerInput getC_BPartner();

	/**
	 * Set C_Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	void setC_Campaign(I_C_CampaignInput C_Campaign);

	/**
	 * Get C_Campaign.
	 *
	 * @return Marketing Campaign
	 */
	I_C_CampaignInput getC_Campaign();

	/**
	 * Set C_ElementValue.
	 *
	 * @param C_ElementValue Account Element
	 */
	void setC_ElementValue(I_C_ElementValueInput C_ElementValue);

	/**
	 * Get C_ElementValue.
	 *
	 * @return Account Element
	 */
	I_C_ElementValueInput getC_ElementValue();

	/**
	 * Set C_Location.
	 *
	 * @param C_Location Location or Address
	 */
	void setC_Location(I_C_LocationInput C_Location);

	/**
	 * Get C_Location.
	 *
	 * @return Location or Address
	 */
	I_C_LocationInput getC_Location();

	/**
	 * Set C_Project.
	 *
	 * @param C_Project Financial Project
	 */
	void setC_Project(I_C_ProjectInput C_Project);

	/**
	 * Get C_Project.
	 *
	 * @return Financial Project
	 */
	I_C_ProjectInput getC_Project();

	/**
	 * Set C_SalesRegion.
	 *
	 * @param C_SalesRegion Sales coverage region
	 */
	void setC_SalesRegion(I_C_SalesRegionInput C_SalesRegion);

	/**
	 * Get C_SalesRegion.
	 *
	 * @return Sales coverage region
	 */
	I_C_SalesRegionInput getC_SalesRegion();

	/**
	 * Set ElementType_RL.
	 *
	 * @param ElementType_RL Element Type (account or user defined)
	 */
	void setElementType_RL(I_AD_Ref_ListInput ElementType_RL);

	/**
	 * Get ElementType_RL.
	 *
	 * @return Element Type (account or user defined)
	 */
	I_AD_Ref_ListInput getElementType_RL();

	/**
	 * Set M_Product.
	 *
	 * @param M_Product Product, Service, Item
	 */
	void setM_Product(I_M_ProductInput M_Product);

	/**
	 * Get M_Product.
	 *
	 * @return Product, Service, Item
	 */
	I_M_ProductInput getM_Product();

	/**
	 * Set PA_ReportLine.
	 *
	 * @param PA_ReportLine PA_ReportLine
	 */
	void setPA_ReportLine(I_PA_ReportLineInput PA_ReportLine);

	/**
	 * Get PA_ReportLine.
	 *
	 * @return PA_ReportLine
	 */
	I_PA_ReportLineInput getPA_ReportLine();

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
