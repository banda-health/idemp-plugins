package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MInvoiceLine_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInOutConfirm;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInOutLineConfirm;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for M_InOutLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_InOutLineConfirmInput extends MInOutLineConfirm implements I_M_InOutLineConfirmInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_InvoiceLine;
	private ForeignEntityInput mM_InOutConfirm;
	private ForeignEntityInput mM_InOutLine;
	private ForeignEntityInput mM_InventoryLine;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_InOutLineConfirm_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_InOutLineConfirmInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
	 * Set Invoice Line.
	 *
	 * @param C_InvoiceLine Invoice Detail Line
	 */
	@JsonProperty("C_InvoiceLine")
	public void setC_InvoiceLineInput(ForeignEntityInput C_InvoiceLine) {
		this.mC_InvoiceLine = C_InvoiceLine;
		if (C_InvoiceLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MInvoiceLine_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_InvoiceLine", "C_InvoiceLine_UU=?", get_TrxName())
							.setParameters(C_InvoiceLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_InvoiceLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_InvoiceLine with UUID " + C_InvoiceLine.getUUID());
			}
		} else {
			this.setC_InvoiceLine_ID(0);
		}
	}

	/**
	 * Get Invoice Line.
	 *
	 * @return Invoice Detail Line
	 */
	@JsonProperty("C_InvoiceLine")
	public ForeignEntityInput C_InvoiceLine() {
		return mC_InvoiceLine;
	}

	/**
	 * Set Ship/Receipt Confirmation.
	 *
	 * @param M_InOutConfirm Material Shipment or Receipt Confirmation
	 */
	@JsonProperty("M_InOutConfirm")
	public void setM_InOutConfirmInput(ForeignEntityInput M_InOutConfirm) {
		this.mM_InOutConfirm = M_InOutConfirm;
		if (get_ID() != 0) {
			return;
		}
		if (M_InOutConfirm != null) {
			// Since an entity was passed, make sure it's in the DB
			MInOutConfirm foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_InOutConfirm", "M_InOutConfirm_UU=?", get_TrxName())
							.setParameters(M_InOutConfirm.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_InOutConfirm_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_InOutConfirm with UUID " + M_InOutConfirm.getUUID());
			}
		} else {
			this.setM_InOutConfirm_ID(0);
		}
	}

	/**
	 * Get Ship/Receipt Confirmation.
	 *
	 * @return Material Shipment or Receipt Confirmation
	 */
	@JsonProperty("M_InOutConfirm")
	public ForeignEntityInput M_InOutConfirm() {
		return mM_InOutConfirm;
	}

	/**
	 * Set Shipment/Receipt Line.
	 *
	 * @param M_InOutLine Line on Shipment or Receipt document
	 */
	@JsonProperty("M_InOutLine")
	public void setM_InOutLineInput(ForeignEntityInput M_InOutLine) {
		this.mM_InOutLine = M_InOutLine;
		if (get_ID() != 0) {
			return;
		}
		if (M_InOutLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MInOutLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_InOutLine", "M_InOutLine_UU=?", get_TrxName())
							.setParameters(M_InOutLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_InOutLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_InOutLine with UUID " + M_InOutLine.getUUID());
			}
		} else {
			this.setM_InOutLine_ID(0);
		}
	}

	/**
	 * Get Shipment/Receipt Line.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	@JsonProperty("M_InOutLine")
	public ForeignEntityInput M_InOutLine() {
		return mM_InOutLine;
	}
	/**
	 * Set Ship/Receipt Confirmation Line.
	 *
	 * @param M_InOutLineConfirm_ID Material Shipment or Receipt Confirmation Line
	 */

	public void setM_InOutLineConfirm_ID(int M_InOutLineConfirm_ID) {
		if (get_ID() == 0) {
			super.setM_InOutLineConfirm_ID(M_InOutLineConfirm_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_InOutLineConfirm_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_InOutLineConfirm_UU();
	}

	/**
	 * Set Phys.Inventory Line.
	 *
	 * @param M_InventoryLine Unique line in an Inventory document
	 */
	@JsonProperty("M_InventoryLine")
	public void setM_InventoryLineInput(ForeignEntityInput M_InventoryLine) {
		this.mM_InventoryLine = M_InventoryLine;
		if (M_InventoryLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MInventoryLine_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_InventoryLine", "M_InventoryLine_UU=?", get_TrxName())
							.setParameters(M_InventoryLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_InventoryLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_InventoryLine with UUID " + M_InventoryLine.getUUID());
			}
		} else {
			this.setM_InventoryLine_ID(0);
		}
	}

	/**
	 * Get Phys.Inventory Line.
	 *
	 * @return Unique line in an Inventory document
	 */
	@JsonProperty("M_InventoryLine")
	public ForeignEntityInput M_InventoryLine() {
		return mM_InventoryLine;
	}
	/**
	 * Set Target Quantity.
	 *
	 * @param TargetQty Target Movement Quantity
	 */

	public void setTargetQty(BigDecimal TargetQty) {
		if (get_ID() == 0) {
			super.setTargetQty(TargetQty);
		}
	}
}
