package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_PrintForm;

/**
 * Generated Interface for AD_PrintForm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_AD_PrintFormInput extends I_AD_PrintForm {

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
	 * Set Distrib_Order_MailText.
	 *
	 * @param Distrib_Order_MailText Email text used for sending Distribution Order
	 */
	void setDistrib_Order_MailTextInput(ForeignEntityInput Distrib_Order_MailText);

	/**
	 * Get Distrib_Order_MailText.
	 *
	 * @return Email text used for sending Distribution Order
	 */
	ForeignEntityInput Distrib_Order_MailText();

	/**
	 * Set Distrib_Order_PrintFormat.
	 *
	 * @param Distrib_Order_PrintFormat Print Format for printing Distribution Order
	 */
	void setDistrib_Order_PrintFormatInput(ForeignEntityInput Distrib_Order_PrintFormat);

	/**
	 * Get Distrib_Order_PrintFormat.
	 *
	 * @return Print Format for printing Distribution Order
	 */
	ForeignEntityInput Distrib_Order_PrintFormat();

	/**
	 * Set Invoice_MailText.
	 *
	 * @param Invoice_MailText Email text used for sending invoices
	 */
	void setInvoice_MailTextInput(ForeignEntityInput Invoice_MailText);

	/**
	 * Get Invoice_MailText.
	 *
	 * @return Email text used for sending invoices
	 */
	ForeignEntityInput Invoice_MailText();

	/**
	 * Set Invoice_PrintFormat.
	 *
	 * @param Invoice_PrintFormat Print Format for printing Invoices
	 */
	void setInvoice_PrintFormatInput(ForeignEntityInput Invoice_PrintFormat);

	/**
	 * Get Invoice_PrintFormat.
	 *
	 * @return Print Format for printing Invoices
	 */
	ForeignEntityInput Invoice_PrintFormat();

	/**
	 * Set Manuf_Order_MailText.
	 *
	 * @param Manuf_Order_MailText Email text used for sending Manufacturing Order
	 */
	void setManuf_Order_MailTextInput(ForeignEntityInput Manuf_Order_MailText);

	/**
	 * Get Manuf_Order_MailText.
	 *
	 * @return Email text used for sending Manufacturing Order
	 */
	ForeignEntityInput Manuf_Order_MailText();

	/**
	 * Set Manuf_Order_PrintFormat.
	 *
	 * @param Manuf_Order_PrintFormat Print Format for printing Manufacturing Order
	 */
	void setManuf_Order_PrintFormatInput(ForeignEntityInput Manuf_Order_PrintFormat);

	/**
	 * Get Manuf_Order_PrintFormat.
	 *
	 * @return Print Format for printing Manufacturing Order
	 */
	ForeignEntityInput Manuf_Order_PrintFormat();

	/**
	 * Set Order_MailText.
	 *
	 * @param Order_MailText Email text used for sending order acknowledgements or quotations
	 */
	void setOrder_MailTextInput(ForeignEntityInput Order_MailText);

	/**
	 * Get Order_MailText.
	 *
	 * @return Email text used for sending order acknowledgements or quotations
	 */
	ForeignEntityInput Order_MailText();

	/**
	 * Set Order_PrintFormat.
	 *
	 * @param Order_PrintFormat Print Format for Orders, Quotes, Offers
	 */
	void setOrder_PrintFormatInput(ForeignEntityInput Order_PrintFormat);

	/**
	 * Get Order_PrintFormat.
	 *
	 * @return Print Format for Orders, Quotes, Offers
	 */
	ForeignEntityInput Order_PrintFormat();

	/**
	 * Set Project_MailText.
	 *
	 * @param Project_MailText Standard text for Project EMails
	 */
	void setProject_MailTextInput(ForeignEntityInput Project_MailText);

	/**
	 * Get Project_MailText.
	 *
	 * @return Standard text for Project EMails
	 */
	ForeignEntityInput Project_MailText();

	/**
	 * Set Project_PrintFormat.
	 *
	 * @param Project_PrintFormat Standard Project Print Format
	 */
	void setProject_PrintFormatInput(ForeignEntityInput Project_PrintFormat);

	/**
	 * Get Project_PrintFormat.
	 *
	 * @return Standard Project Print Format
	 */
	ForeignEntityInput Project_PrintFormat();

	/**
	 * Set Remittance_MailText.
	 *
	 * @param Remittance_MailText Email text used for sending payment remittances
	 */
	void setRemittance_MailTextInput(ForeignEntityInput Remittance_MailText);

	/**
	 * Get Remittance_MailText.
	 *
	 * @return Email text used for sending payment remittances
	 */
	ForeignEntityInput Remittance_MailText();

	/**
	 * Set Remittance_PrintFormat.
	 *
	 * @param Remittance_PrintFormat Print Format for separate Remittances
	 */
	void setRemittance_PrintFormatInput(ForeignEntityInput Remittance_PrintFormat);

	/**
	 * Get Remittance_PrintFormat.
	 *
	 * @return Print Format for separate Remittances
	 */
	ForeignEntityInput Remittance_PrintFormat();

	/**
	 * Set Shipment_MailText.
	 *
	 * @param Shipment_MailText Email text used for sending delivery notes
	 */
	void setShipment_MailTextInput(ForeignEntityInput Shipment_MailText);

	/**
	 * Get Shipment_MailText.
	 *
	 * @return Email text used for sending delivery notes
	 */
	ForeignEntityInput Shipment_MailText();

	/**
	 * Set Shipment_PrintFormat.
	 *
	 * @param Shipment_PrintFormat Print Format for Shipments, Receipts, Pick Lists
	 */
	void setShipment_PrintFormatInput(ForeignEntityInput Shipment_PrintFormat);

	/**
	 * Get Shipment_PrintFormat.
	 *
	 * @return Print Format for Shipments, Receipts, Pick Lists
	 */
	ForeignEntityInput Shipment_PrintFormat();
}
