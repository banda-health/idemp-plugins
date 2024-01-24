package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MMailText;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintForm;
import org.compiere.model.X_AD_PrintFormat;

import java.sql.ResultSet;

/**
 * Generated Model for AD_PrintForm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_PrintFormInput extends X_AD_PrintForm implements I_AD_PrintFormInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mDistrib_Order_MailText;
	private ForeignEntityInput mDistrib_Order_PrintFormat;
	private ForeignEntityInput mInvoice_MailText;
	private ForeignEntityInput mInvoice_PrintFormat;
	private ForeignEntityInput mManuf_Order_MailText;
	private ForeignEntityInput mManuf_Order_PrintFormat;
	private ForeignEntityInput mOrder_MailText;
	private ForeignEntityInput mOrder_PrintFormat;
	private ForeignEntityInput mProject_MailText;
	private ForeignEntityInput mProject_PrintFormat;
	private ForeignEntityInput mRemittance_MailText;
	private ForeignEntityInput mRemittance_PrintFormat;
	private ForeignEntityInput mShipment_MailText;
	private ForeignEntityInput mShipment_PrintFormat;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_PrintFormInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_PrintForm(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}
	/**
	 * Set Print Form.
	 *
	 * @param AD_PrintForm_ID Form
	 */

	public void setAD_PrintForm_ID(int AD_PrintForm_ID) {
		if (get_ID() == 0) {
			super.setAD_PrintForm_ID(AD_PrintForm_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_PrintForm_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_PrintForm_UU();
	}

	/**
	 * Set Distribution Order Mail Text.
	 *
	 * @param Distrib_Order_MailText Email text used for sending Distribution Order
	 */
	@JsonProperty("Distrib_Order_MailText")
	public void setDistrib_Order_MailTextInput(ForeignEntityInput Distrib_Order_MailText) {
		this.mDistrib_Order_MailText = Distrib_Order_MailText;
		MMailText foreignEntity;
		if (Distrib_Order_MailText != null &&
				(foreignEntity = new Query(getCtx(), "R_MailText", "R_MailText_UU=?", get_TrxName())
						.setParameters(Distrib_Order_MailText.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setDistrib_Order_MailText_ID(foreignEntity.get_ID());
		} else {
			super.setDistrib_Order_MailText_ID(0);
		}
	}

	/**
	 * Get Distribution Order Mail Text.
	 *
	 * @return Email text used for sending Distribution Order
	 */
	@JsonProperty("Distrib_Order_MailText")
	public ForeignEntityInput Distrib_Order_MailText() {
		return mDistrib_Order_MailText;
	}

	/**
	 * Set Distribution Order Print Format.
	 *
	 * @param Distrib_Order_PrintFormat Print Format for printing Distribution Order
	 */
	@JsonProperty("Distrib_Order_PrintFormat")
	public void setDistrib_Order_PrintFormatInput(ForeignEntityInput Distrib_Order_PrintFormat) {
		this.mDistrib_Order_PrintFormat = Distrib_Order_PrintFormat;
		X_AD_PrintFormat foreignEntity;
		if (Distrib_Order_PrintFormat != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
						.setParameters(Distrib_Order_PrintFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setDistrib_Order_PrintFormat_ID(foreignEntity.get_ID());
		} else {
			super.setDistrib_Order_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Distribution Order Print Format.
	 *
	 * @return Print Format for printing Distribution Order
	 */
	@JsonProperty("Distrib_Order_PrintFormat")
	public ForeignEntityInput Distrib_Order_PrintFormat() {
		return mDistrib_Order_PrintFormat;
	}

	/**
	 * Set Invoice Mail Text.
	 *
	 * @param Invoice_MailText Email text used for sending invoices
	 */
	@JsonProperty("Invoice_MailText")
	public void setInvoice_MailTextInput(ForeignEntityInput Invoice_MailText) {
		this.mInvoice_MailText = Invoice_MailText;
		MMailText foreignEntity;
		if (Invoice_MailText != null &&
				(foreignEntity = new Query(getCtx(), "R_MailText", "R_MailText_UU=?", get_TrxName())
						.setParameters(Invoice_MailText.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setInvoice_MailText_ID(foreignEntity.get_ID());
		} else {
			super.setInvoice_MailText_ID(0);
		}
	}

	/**
	 * Get Invoice Mail Text.
	 *
	 * @return Email text used for sending invoices
	 */
	@JsonProperty("Invoice_MailText")
	public ForeignEntityInput Invoice_MailText() {
		return mInvoice_MailText;
	}

	/**
	 * Set Invoice Print Format.
	 *
	 * @param Invoice_PrintFormat Print Format for printing Invoices
	 */
	@JsonProperty("Invoice_PrintFormat")
	public void setInvoice_PrintFormatInput(ForeignEntityInput Invoice_PrintFormat) {
		this.mInvoice_PrintFormat = Invoice_PrintFormat;
		X_AD_PrintFormat foreignEntity;
		if (Invoice_PrintFormat != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
						.setParameters(Invoice_PrintFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setInvoice_PrintFormat_ID(foreignEntity.get_ID());
		} else {
			super.setInvoice_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Invoice Print Format.
	 *
	 * @return Print Format for printing Invoices
	 */
	@JsonProperty("Invoice_PrintFormat")
	public ForeignEntityInput Invoice_PrintFormat() {
		return mInvoice_PrintFormat;
	}

	/**
	 * Set Manufacturing Order Mail Text.
	 *
	 * @param Manuf_Order_MailText Email text used for sending Manufacturing Order
	 */
	@JsonProperty("Manuf_Order_MailText")
	public void setManuf_Order_MailTextInput(ForeignEntityInput Manuf_Order_MailText) {
		this.mManuf_Order_MailText = Manuf_Order_MailText;
		MMailText foreignEntity;
		if (Manuf_Order_MailText != null &&
				(foreignEntity = new Query(getCtx(), "R_MailText", "R_MailText_UU=?", get_TrxName())
						.setParameters(Manuf_Order_MailText.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setManuf_Order_MailText_ID(foreignEntity.get_ID());
		} else {
			super.setManuf_Order_MailText_ID(0);
		}
	}

	/**
	 * Get Manufacturing Order Mail Text.
	 *
	 * @return Email text used for sending Manufacturing Order
	 */
	@JsonProperty("Manuf_Order_MailText")
	public ForeignEntityInput Manuf_Order_MailText() {
		return mManuf_Order_MailText;
	}

	/**
	 * Set Manufacturing Order Print Format.
	 *
	 * @param Manuf_Order_PrintFormat Print Format for printing Manufacturing Order
	 */
	@JsonProperty("Manuf_Order_PrintFormat")
	public void setManuf_Order_PrintFormatInput(ForeignEntityInput Manuf_Order_PrintFormat) {
		this.mManuf_Order_PrintFormat = Manuf_Order_PrintFormat;
		X_AD_PrintFormat foreignEntity;
		if (Manuf_Order_PrintFormat != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
						.setParameters(Manuf_Order_PrintFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setManuf_Order_PrintFormat_ID(foreignEntity.get_ID());
		} else {
			super.setManuf_Order_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Manufacturing Order Print Format.
	 *
	 * @return Print Format for printing Manufacturing Order
	 */
	@JsonProperty("Manuf_Order_PrintFormat")
	public ForeignEntityInput Manuf_Order_PrintFormat() {
		return mManuf_Order_PrintFormat;
	}

	/**
	 * Set Order Mail Text.
	 *
	 * @param Order_MailText Email text used for sending order acknowledgements or quotations
	 */
	@JsonProperty("Order_MailText")
	public void setOrder_MailTextInput(ForeignEntityInput Order_MailText) {
		this.mOrder_MailText = Order_MailText;
		MMailText foreignEntity;
		if (Order_MailText != null &&
				(foreignEntity = new Query(getCtx(), "R_MailText", "R_MailText_UU=?", get_TrxName())
						.setParameters(Order_MailText.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setOrder_MailText_ID(foreignEntity.get_ID());
		} else {
			super.setOrder_MailText_ID(0);
		}
	}

	/**
	 * Get Order Mail Text.
	 *
	 * @return Email text used for sending order acknowledgements or quotations
	 */
	@JsonProperty("Order_MailText")
	public ForeignEntityInput Order_MailText() {
		return mOrder_MailText;
	}

	/**
	 * Set Order Print Format.
	 *
	 * @param Order_PrintFormat Print Format for Orders, Quotes, Offers
	 */
	@JsonProperty("Order_PrintFormat")
	public void setOrder_PrintFormatInput(ForeignEntityInput Order_PrintFormat) {
		this.mOrder_PrintFormat = Order_PrintFormat;
		X_AD_PrintFormat foreignEntity;
		if (Order_PrintFormat != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
						.setParameters(Order_PrintFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setOrder_PrintFormat_ID(foreignEntity.get_ID());
		} else {
			super.setOrder_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Order Print Format.
	 *
	 * @return Print Format for Orders, Quotes, Offers
	 */
	@JsonProperty("Order_PrintFormat")
	public ForeignEntityInput Order_PrintFormat() {
		return mOrder_PrintFormat;
	}

	/**
	 * Set Project Mail Text.
	 *
	 * @param Project_MailText Standard text for Project EMails
	 */
	@JsonProperty("Project_MailText")
	public void setProject_MailTextInput(ForeignEntityInput Project_MailText) {
		this.mProject_MailText = Project_MailText;
		MMailText foreignEntity;
		if (Project_MailText != null &&
				(foreignEntity = new Query(getCtx(), "R_MailText", "R_MailText_UU=?", get_TrxName())
						.setParameters(Project_MailText.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setProject_MailText_ID(foreignEntity.get_ID());
		} else {
			super.setProject_MailText_ID(0);
		}
	}

	/**
	 * Get Project Mail Text.
	 *
	 * @return Standard text for Project EMails
	 */
	@JsonProperty("Project_MailText")
	public ForeignEntityInput Project_MailText() {
		return mProject_MailText;
	}

	/**
	 * Set Project Print Format.
	 *
	 * @param Project_PrintFormat Standard Project Print Format
	 */
	@JsonProperty("Project_PrintFormat")
	public void setProject_PrintFormatInput(ForeignEntityInput Project_PrintFormat) {
		this.mProject_PrintFormat = Project_PrintFormat;
		X_AD_PrintFormat foreignEntity;
		if (Project_PrintFormat != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
						.setParameters(Project_PrintFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setProject_PrintFormat_ID(foreignEntity.get_ID());
		} else {
			super.setProject_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Project Print Format.
	 *
	 * @return Standard Project Print Format
	 */
	@JsonProperty("Project_PrintFormat")
	public ForeignEntityInput Project_PrintFormat() {
		return mProject_PrintFormat;
	}

	/**
	 * Set Remittance Mail Text.
	 *
	 * @param Remittance_MailText Email text used for sending payment remittances
	 */
	@JsonProperty("Remittance_MailText")
	public void setRemittance_MailTextInput(ForeignEntityInput Remittance_MailText) {
		this.mRemittance_MailText = Remittance_MailText;
		MMailText foreignEntity;
		if (Remittance_MailText != null &&
				(foreignEntity = new Query(getCtx(), "R_MailText", "R_MailText_UU=?", get_TrxName())
						.setParameters(Remittance_MailText.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setRemittance_MailText_ID(foreignEntity.get_ID());
		} else {
			super.setRemittance_MailText_ID(0);
		}
	}

	/**
	 * Get Remittance Mail Text.
	 *
	 * @return Email text used for sending payment remittances
	 */
	@JsonProperty("Remittance_MailText")
	public ForeignEntityInput Remittance_MailText() {
		return mRemittance_MailText;
	}

	/**
	 * Set Remittance Print Format.
	 *
	 * @param Remittance_PrintFormat Print Format for separate Remittances
	 */
	@JsonProperty("Remittance_PrintFormat")
	public void setRemittance_PrintFormatInput(ForeignEntityInput Remittance_PrintFormat) {
		this.mRemittance_PrintFormat = Remittance_PrintFormat;
		X_AD_PrintFormat foreignEntity;
		if (Remittance_PrintFormat != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
						.setParameters(Remittance_PrintFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setRemittance_PrintFormat_ID(foreignEntity.get_ID());
		} else {
			super.setRemittance_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Remittance Print Format.
	 *
	 * @return Print Format for separate Remittances
	 */
	@JsonProperty("Remittance_PrintFormat")
	public ForeignEntityInput Remittance_PrintFormat() {
		return mRemittance_PrintFormat;
	}

	/**
	 * Set Shipment Mail Text.
	 *
	 * @param Shipment_MailText Email text used for sending delivery notes
	 */
	@JsonProperty("Shipment_MailText")
	public void setShipment_MailTextInput(ForeignEntityInput Shipment_MailText) {
		this.mShipment_MailText = Shipment_MailText;
		MMailText foreignEntity;
		if (Shipment_MailText != null &&
				(foreignEntity = new Query(getCtx(), "R_MailText", "R_MailText_UU=?", get_TrxName())
						.setParameters(Shipment_MailText.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setShipment_MailText_ID(foreignEntity.get_ID());
		} else {
			super.setShipment_MailText_ID(0);
		}
	}

	/**
	 * Get Shipment Mail Text.
	 *
	 * @return Email text used for sending delivery notes
	 */
	@JsonProperty("Shipment_MailText")
	public ForeignEntityInput Shipment_MailText() {
		return mShipment_MailText;
	}

	/**
	 * Set Shipment Print Format.
	 *
	 * @param Shipment_PrintFormat Print Format for Shipments, Receipts, Pick Lists
	 */
	@JsonProperty("Shipment_PrintFormat")
	public void setShipment_PrintFormatInput(ForeignEntityInput Shipment_PrintFormat) {
		this.mShipment_PrintFormat = Shipment_PrintFormat;
		X_AD_PrintFormat foreignEntity;
		if (Shipment_PrintFormat != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
						.setParameters(Shipment_PrintFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setShipment_PrintFormat_ID(foreignEntity.get_ID());
		} else {
			super.setShipment_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Shipment Print Format.
	 *
	 * @return Print Format for Shipments, Receipts, Pick Lists
	 */
	@JsonProperty("Shipment_PrintFormat")
	public ForeignEntityInput Shipment_PrintFormat() {
		return mShipment_PrintFormat;
	}
}
