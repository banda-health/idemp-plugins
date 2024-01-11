package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_OrgInfo;

/**
 * Generated Interface for AD_OrgInfo - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_AD_OrgInfoInput extends I_AD_OrgInfo {

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
