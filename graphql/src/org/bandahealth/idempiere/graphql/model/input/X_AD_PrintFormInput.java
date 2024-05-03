package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MMailText;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintForm;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_PrintForm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_PrintForm_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_PrintFormInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_PrintForm_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (Distrib_Order_MailText != null) {
			// Since an entity was passed, make sure it's in the DB
			MMailText foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_MailText", "R_MailText_UU=?", get_TrxName())
							.setParameters(Distrib_Order_MailText.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDistrib_Order_MailText_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_MailText with UU " + Distrib_Order_MailText.getUU());
			}
		} else {
			this.setDistrib_Order_MailText_ID(0);
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
		if (Distrib_Order_PrintFormat != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFormat foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
							.setParameters(Distrib_Order_PrintFormat.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDistrib_Order_PrintFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormat with UU " + Distrib_Order_PrintFormat.getUU());
			}
		} else {
			this.setDistrib_Order_PrintFormat_ID(0);
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
		if (Invoice_MailText != null) {
			// Since an entity was passed, make sure it's in the DB
			MMailText foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_MailText", "R_MailText_UU=?", get_TrxName())
							.setParameters(Invoice_MailText.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setInvoice_MailText_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_MailText with UU " + Invoice_MailText.getUU());
			}
		} else {
			this.setInvoice_MailText_ID(0);
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
		if (Invoice_PrintFormat != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFormat foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
							.setParameters(Invoice_PrintFormat.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setInvoice_PrintFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormat with UU " + Invoice_PrintFormat.getUU());
			}
		} else {
			this.setInvoice_PrintFormat_ID(0);
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
		if (Manuf_Order_MailText != null) {
			// Since an entity was passed, make sure it's in the DB
			MMailText foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_MailText", "R_MailText_UU=?", get_TrxName())
							.setParameters(Manuf_Order_MailText.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setManuf_Order_MailText_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_MailText with UU " + Manuf_Order_MailText.getUU());
			}
		} else {
			this.setManuf_Order_MailText_ID(0);
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
		if (Manuf_Order_PrintFormat != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFormat foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
							.setParameters(Manuf_Order_PrintFormat.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setManuf_Order_PrintFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormat with UU " + Manuf_Order_PrintFormat.getUU());
			}
		} else {
			this.setManuf_Order_PrintFormat_ID(0);
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
		if (Order_MailText != null) {
			// Since an entity was passed, make sure it's in the DB
			MMailText foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_MailText", "R_MailText_UU=?", get_TrxName())
							.setParameters(Order_MailText.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setOrder_MailText_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_MailText with UU " + Order_MailText.getUU());
			}
		} else {
			this.setOrder_MailText_ID(0);
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
		if (Order_PrintFormat != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFormat foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
							.setParameters(Order_PrintFormat.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setOrder_PrintFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormat with UU " + Order_PrintFormat.getUU());
			}
		} else {
			this.setOrder_PrintFormat_ID(0);
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
		if (Project_MailText != null) {
			// Since an entity was passed, make sure it's in the DB
			MMailText foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_MailText", "R_MailText_UU=?", get_TrxName())
							.setParameters(Project_MailText.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setProject_MailText_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_MailText with UU " + Project_MailText.getUU());
			}
		} else {
			this.setProject_MailText_ID(0);
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
		if (Project_PrintFormat != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFormat foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
							.setParameters(Project_PrintFormat.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setProject_PrintFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormat with UU " + Project_PrintFormat.getUU());
			}
		} else {
			this.setProject_PrintFormat_ID(0);
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
		if (Remittance_MailText != null) {
			// Since an entity was passed, make sure it's in the DB
			MMailText foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_MailText", "R_MailText_UU=?", get_TrxName())
							.setParameters(Remittance_MailText.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setRemittance_MailText_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_MailText with UU " + Remittance_MailText.getUU());
			}
		} else {
			this.setRemittance_MailText_ID(0);
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
		if (Remittance_PrintFormat != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFormat foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
							.setParameters(Remittance_PrintFormat.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setRemittance_PrintFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormat with UU " + Remittance_PrintFormat.getUU());
			}
		} else {
			this.setRemittance_PrintFormat_ID(0);
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
		if (Shipment_MailText != null) {
			// Since an entity was passed, make sure it's in the DB
			MMailText foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_MailText", "R_MailText_UU=?", get_TrxName())
							.setParameters(Shipment_MailText.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setShipment_MailText_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_MailText with UU " + Shipment_MailText.getUU());
			}
		} else {
			this.setShipment_MailText_ID(0);
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
		if (Shipment_PrintFormat != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFormat foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
							.setParameters(Shipment_PrintFormat.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setShipment_PrintFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormat with UU " + Shipment_PrintFormat.getUU());
			}
		} else {
			this.setShipment_PrintFormat_ID(0);
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
