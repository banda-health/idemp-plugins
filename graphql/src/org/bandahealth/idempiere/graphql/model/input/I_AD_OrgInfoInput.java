package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_OrgInfo;

/**
 * Generated Interface for AD_OrgInfo - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_AD_OrgInfoInput extends I_AD_OrgInfo {

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
	 * Set AD_OrgType.
	 *
	 * @param AD_OrgType Organization Type
	 */
	void setAD_OrgTypeInput(ForeignEntityInput AD_OrgType);

	/**
	 * Get AD_OrgType.
	 *
	 * @return Organization Type
	 */
	ForeignEntityInput AD_OrgType();

	/**
	 * Set BH_Affiliation.
	 *
	 * @param BH_Affiliation BH_Affiliation
	 */
	void setBH_AffiliationInput(ForeignEntityInput BH_Affiliation);

	/**
	 * Get BH_Affiliation.
	 *
	 * @return BH_Affiliation
	 */
	ForeignEntityInput BH_Affiliation();

	/**
	 * Column name BH_ExtraInfo
	 */
	static final String COLUMNNAME_BH_ExtraInfo = "BH_ExtraInfo";

	/**
	 * Set Extra Information.
	 *
	 * @param BH_ExtraInfo Enter additional information for this organization
	 */
	void setBH_ExtraInfo(String BH_ExtraInfo);

	/**
	 * Get Extra Information.
	 *
	 * @return Enter additional information for this organization
	 */
	String getBH_ExtraInfo();

	/**
	 * Column name BH_FacilityNumber
	 */
	static final String COLUMNNAME_BH_FacilityNumber = "BH_FacilityNumber";

	/**
	 * Set Facility Number.
	 *
	 * @param BH_FacilityNumber Facility Number (MFL No.)
	 */
	void setBH_FacilityNumber(String BH_FacilityNumber);

	/**
	 * Get Facility Number.
	 *
	 * @return Facility Number (MFL No.)
	 */
	String getBH_FacilityNumber();

	/**
	 * Column name BH_Header
	 */
	static final String COLUMNNAME_BH_Header = "BH_Header";

	/**
	 * Set Header.
	 *
	 * @param BH_Header Header information e.g address, phone number etc.
	 */
	void setBH_Header(String BH_Header);

	/**
	 * Get Header.
	 *
	 * @return Header information e.g address, phone number etc.
	 */
	String getBH_Header();

	/**
	 * Column name BH_PaymentInformation
	 */
	static final String COLUMNNAME_BH_PaymentInformation = "BH_PaymentInformation";

	/**
	 * Set Payment Information.
	 *
	 * @param BH_PaymentInformation Payment Information
	 */
	void setBH_PaymentInformation(String BH_PaymentInformation);

	/**
	 * Get Payment Information.
	 *
	 * @return Payment Information
	 */
	String getBH_PaymentInformation();

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
	 * Set C_Location.
	 *
	 * @param C_Location Location or Address
	 */
	void setC_LocationInput(ForeignEntityInput C_Location);

	/**
	 * Get C_Location.
	 *
	 * @return Location or Address
	 */
	ForeignEntityInput C_Location();

	/**
	 * Set DropShip_Warehouse.
	 *
	 * @param DropShip_Warehouse The (logical) warehouse to use for recording drop ship receipts and shipments.
	 */
	void setDropShip_WarehouseInput(ForeignEntityInput DropShip_Warehouse);

	/**
	 * Get DropShip_Warehouse.
	 *
	 * @return The (logical) warehouse to use for recording drop ship receipts and shipments.
	 */
	ForeignEntityInput DropShip_Warehouse();

	/**
	 * Set Logo.
	 *
	 * @param Logo Logo
	 */
	void setLogoInput(ForeignEntityInput Logo);

	/**
	 * Get Logo.
	 *
	 * @return Logo
	 */
	ForeignEntityInput Logo();

	/**
	 * Set M_Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	void setM_WarehouseInput(ForeignEntityInput M_Warehouse);

	/**
	 * Get M_Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	ForeignEntityInput M_Warehouse();

	/**
	 * Set Supervisor.
	 *
	 * @param Supervisor Supervisor for this user/organization - used for escalation and approval
	 */
	void setSupervisorInput(ForeignEntityInput Supervisor);

	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	ForeignEntityInput Supervisor();

	/**
	 * Set TransferBank.
	 *
	 * @param TransferBank Bank account depending on currency will be used from this bank for doing transfers
	 */
	void setTransferBankInput(ForeignEntityInput TransferBank);

	/**
	 * Get TransferBank.
	 *
	 * @return Bank account depending on currency will be used from this bank for doing transfers
	 */
	ForeignEntityInput TransferBank();

	/**
	 * Set TransferCashBook.
	 *
	 * @param TransferCashBook TransferCashBook
	 */
	void setTransferCashBookInput(ForeignEntityInput TransferCashBook);

	/**
	 * Get TransferCashBook.
	 *
	 * @return TransferCashBook
	 */
	ForeignEntityInput TransferCashBook();
}
