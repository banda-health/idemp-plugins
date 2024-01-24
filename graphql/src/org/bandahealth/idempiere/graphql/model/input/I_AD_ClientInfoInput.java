package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_ClientInfo;

/**
 * Generated Interface for AD_ClientInfo - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_ClientInfoInput extends I_AD_ClientInfo {

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
	 * Set AD_StorageProvider.
	 *
	 * @param AD_StorageProvider AD_StorageProvider
	 */
	void setAD_StorageProviderInput(ForeignEntityInput AD_StorageProvider);

	/**
	 * Get AD_StorageProvider.
	 *
	 * @return AD_StorageProvider
	 */
	ForeignEntityInput AD_StorageProvider();

	/**
	 * Set AD_Tree_Activity.
	 *
	 * @param AD_Tree_Activity Trees are used for (financial) reporting
	 */
	void setAD_Tree_ActivityInput(ForeignEntityInput AD_Tree_Activity);

	/**
	 * Get AD_Tree_Activity.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	ForeignEntityInput AD_Tree_Activity();

	/**
	 * Set AD_Tree_BPartner.
	 *
	 * @param AD_Tree_BPartner Trees are used for (financial) reporting
	 */
	void setAD_Tree_BPartnerInput(ForeignEntityInput AD_Tree_BPartner);

	/**
	 * Get AD_Tree_BPartner.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	ForeignEntityInput AD_Tree_BPartner();

	/**
	 * Set AD_Tree_Campaign.
	 *
	 * @param AD_Tree_Campaign Trees are used for (financial) reporting
	 */
	void setAD_Tree_CampaignInput(ForeignEntityInput AD_Tree_Campaign);

	/**
	 * Get AD_Tree_Campaign.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	ForeignEntityInput AD_Tree_Campaign();

	/**
	 * Set AD_Tree_Menu.
	 *
	 * @param AD_Tree_Menu Tree of the menu
	 */
	void setAD_Tree_MenuInput(ForeignEntityInput AD_Tree_Menu);

	/**
	 * Get AD_Tree_Menu.
	 *
	 * @return Tree of the menu
	 */
	ForeignEntityInput AD_Tree_Menu();

	/**
	 * Set AD_Tree_Org.
	 *
	 * @param AD_Tree_Org Trees are used for (financial) reporting and security access (via role)
	 */
	void setAD_Tree_OrgInput(ForeignEntityInput AD_Tree_Org);

	/**
	 * Get AD_Tree_Org.
	 *
	 * @return Trees are used for (financial) reporting and security access (via role)
	 */
	ForeignEntityInput AD_Tree_Org();

	/**
	 * Set AD_Tree_Product.
	 *
	 * @param AD_Tree_Product Trees are used for (financial) reporting
	 */
	void setAD_Tree_ProductInput(ForeignEntityInput AD_Tree_Product);

	/**
	 * Get AD_Tree_Product.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	ForeignEntityInput AD_Tree_Product();

	/**
	 * Set AD_Tree_Project.
	 *
	 * @param AD_Tree_Project Trees are used for (financial) reporting
	 */
	void setAD_Tree_ProjectInput(ForeignEntityInput AD_Tree_Project);

	/**
	 * Get AD_Tree_Project.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	ForeignEntityInput AD_Tree_Project();

	/**
	 * Set AD_Tree_SalesRegion.
	 *
	 * @param AD_Tree_SalesRegion Trees are used for (financial) reporting
	 */
	void setAD_Tree_SalesRegionInput(ForeignEntityInput AD_Tree_SalesRegion);

	/**
	 * Get AD_Tree_SalesRegion.
	 *
	 * @return Trees are used for (financial) reporting
	 */
	ForeignEntityInput AD_Tree_SalesRegion();

	/**
	 * Set C_AcctSchema1.
	 *
	 * @param C_AcctSchema1 Primary rules for accounting
	 */
	void setC_AcctSchema1Input(ForeignEntityInput C_AcctSchema1);

	/**
	 * Get C_AcctSchema1.
	 *
	 * @return Primary rules for accounting
	 */
	ForeignEntityInput C_AcctSchema1();

	/**
	 * Set C_BPartnerCashTrx.
	 *
	 * @param C_BPartnerCashTrx Business Partner used for creating new Business Partners on the fly
	 */
	void setC_BPartnerCashTrxInput(ForeignEntityInput C_BPartnerCashTrx);

	/**
	 * Get C_BPartnerCashTrx.
	 *
	 * @return Business Partner used for creating new Business Partners on the fly
	 */
	ForeignEntityInput C_BPartnerCashTrx();

	/**
	 * Set C_Calendar.
	 *
	 * @param C_Calendar Accounting Calendar Name
	 */
	void setC_CalendarInput(ForeignEntityInput C_Calendar);

	/**
	 * Get C_Calendar.
	 *
	 * @return Accounting Calendar Name
	 */
	ForeignEntityInput C_Calendar();

	/**
	 * Set C_ChargeFreight.
	 *
	 * @param C_ChargeFreight C_ChargeFreight
	 */
	void setC_ChargeFreightInput(ForeignEntityInput C_ChargeFreight);

	/**
	 * Get C_ChargeFreight.
	 *
	 * @return C_ChargeFreight
	 */
	ForeignEntityInput C_ChargeFreight();

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
	 * Set C_UOM_Time.
	 *
	 * @param C_UOM_Time Standard Unit of Measure for Time
	 */
	void setC_UOM_TimeInput(ForeignEntityInput C_UOM_Time);

	/**
	 * Get C_UOM_Time.
	 *
	 * @return Standard Unit of Measure for Time
	 */
	ForeignEntityInput C_UOM_Time();

	/**
	 * Set C_UOM_Volume.
	 *
	 * @param C_UOM_Volume Standard Unit of Measure for Volume
	 */
	void setC_UOM_VolumeInput(ForeignEntityInput C_UOM_Volume);

	/**
	 * Get C_UOM_Volume.
	 *
	 * @return Standard Unit of Measure for Volume
	 */
	ForeignEntityInput C_UOM_Volume();

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
	 * Set AD_Image.
	 *
	 * @param AD_Image AD_Image
	 */
	void setAD_ImageInput(ForeignEntityInput AD_Image);

	/**
	 * Get AD_Image.
	 *
	 * @return AD_Image
	 */
	ForeignEntityInput AD_Image();

	/**
	 * Set M_ProductFreight.
	 *
	 * @param M_ProductFreight M_ProductFreight
	 */
	void setM_ProductFreightInput(ForeignEntityInput M_ProductFreight);

	/**
	 * Get M_ProductFreight.
	 *
	 * @return M_ProductFreight
	 */
	ForeignEntityInput M_ProductFreight();

	/**
	 * Set StorageArchive.
	 *
	 * @param StorageArchive StorageArchive
	 */
	void setStorageArchiveInput(ForeignEntityInput StorageArchive);

	/**
	 * Get StorageArchive.
	 *
	 * @return StorageArchive
	 */
	ForeignEntityInput StorageArchive();

	/**
	 * Set StorageImage.
	 *
	 * @param StorageImage Storage provider for Image
	 */
	void setStorageImageInput(ForeignEntityInput StorageImage);

	/**
	 * Get StorageImage.
	 *
	 * @return Storage provider for Image
	 */
	ForeignEntityInput StorageImage();
}
