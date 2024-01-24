package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MInvoiceLine_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInOutLine;
import org.compiere.model.MMatchPO;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for M_MatchPO - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_MatchPOInput extends MMatchPO implements I_M_MatchPOInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_InvoiceLine;
	private ForeignEntityInput mC_OrderLine;
	private ForeignEntityInput mM_AttributeSetInstance;
	private ForeignEntityInput mM_InOutLine;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mRef_MatchPO;
	private ForeignEntityInput mReversal;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_MatchPO_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_MatchPOInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MMatchPO(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
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
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
		MInvoiceLine_BH foreignEntity;
		if (get_ID() == 0 && C_InvoiceLine != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_InvoiceLine", "C_InvoiceLine_UU=?", get_TrxName())
							.setParameters(C_InvoiceLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_InvoiceLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_InvoiceLine with UUID " + C_InvoiceLine.getUUID());
			}
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
	 * Set Sales Order Line.
	 *
	 * @param C_OrderLine Sales Order Line
	 */
	@JsonProperty("C_OrderLine")
	public void setC_OrderLineInput(ForeignEntityInput C_OrderLine) {
		this.mC_OrderLine = C_OrderLine;
		MOrderLine_BH foreignEntity;
		if (get_ID() == 0 && C_OrderLine != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_OrderLine", "C_OrderLine_UU=?", get_TrxName())
							.setParameters(C_OrderLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_OrderLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_OrderLine with UUID " + C_OrderLine.getUUID());
			}
		}
	}

	/**
	 * Get Sales Order Line.
	 *
	 * @return Sales Order Line
	 */
	@JsonProperty("C_OrderLine")
	public ForeignEntityInput C_OrderLine() {
		return mC_OrderLine;
	}
	/**
	 * Set Transaction Date.
	 *
	 * @param DateTrx Transaction Date
	 */

	public void setDateTrx(Timestamp DateTrx) {
		if (get_ID() == 0) {
			super.setDateTrx(DateTrx);
		}
	}

	/**
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public void setM_AttributeSetInstanceInput(ForeignEntityInput M_AttributeSetInstance) {
		this.mM_AttributeSetInstance = M_AttributeSetInstance;
		MAttributeSetInstance_BH foreignEntity;
		if (get_ID() == 0 && M_AttributeSetInstance != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_AttributeSetInstance", "M_AttributeSetInstance_UU=?", get_TrxName())
							.setParameters(M_AttributeSetInstance.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_AttributeSetInstance with UUID " + M_AttributeSetInstance.getUUID());
			}
		}
	}

	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public ForeignEntityInput M_AttributeSetInstance() {
		return mM_AttributeSetInstance;
	}

	/**
	 * Set Shipment/Receipt Line.
	 *
	 * @param M_InOutLine Line on Shipment or Receipt document
	 */
	@JsonProperty("M_InOutLine")
	public void setM_InOutLineInput(ForeignEntityInput M_InOutLine) {
		this.mM_InOutLine = M_InOutLine;
		MInOutLine foreignEntity;
		if (get_ID() == 0 && M_InOutLine != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_InOutLine", "M_InOutLine_UU=?", get_TrxName())
							.setParameters(M_InOutLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_InOutLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_InOutLine with UUID " + M_InOutLine.getUUID());
			}
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
	 * Set Match PO.
	 *
	 * @param M_MatchPO_ID Match Purchase Order to Shipment/Receipt and Invoice
	 */

	public void setM_MatchPO_ID(int M_MatchPO_ID) {
		if (get_ID() == 0) {
			super.setM_MatchPO_ID(M_MatchPO_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_MatchPO_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_MatchPO_UU();
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		MProduct_BH foreignEntity;
		if (get_ID() == 0 && M_Product != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UUID " + M_Product.getUUID());
			}
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public ForeignEntityInput M_Product() {
		return mM_Product;
	}
	/**
	 * Set Posted.
	 *
	 * @param Posted Posting status
	 */

	public void setPosted(boolean Posted) {
		if (get_ID() == 0) {
			super.setPosted(Posted);
		}
	}
	/**
	 * Set Processed.
	 *
	 * @param Processed The document has been processed
	 */

	public void setProcessed(boolean Processed) {
		if (get_ID() == 0) {
			super.setProcessed(Processed);
		}
	}
	/**
	 * Set Quantity.
	 *
	 * @param Qty Quantity
	 */

	public void setQty(BigDecimal Qty) {
		if (get_ID() == 0) {
			super.setQty(Qty);
		}
	}

	/**
	 * Set Referenced Match PO.
	 *
	 * @param Ref_MatchPO Referenced Match PO
	 */
	@JsonProperty("Ref_MatchPO")
	public void setRef_MatchPOInput(ForeignEntityInput Ref_MatchPO) {
		this.mRef_MatchPO = Ref_MatchPO;
		MMatchPO foreignEntity;
		if (Ref_MatchPO != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_MatchPO", "M_MatchPO_UU=?", get_TrxName())
							.setParameters(Ref_MatchPO.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setRef_MatchPO_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_MatchPO with UUID " + Ref_MatchPO.getUUID());
			}
		} else {
			super.setRef_MatchPO_ID(0);
		}
	}

	/**
	 * Get Referenced Match PO.
	 *
	 * @return Referenced Match PO
	 */
	@JsonProperty("Ref_MatchPO")
	public ForeignEntityInput Ref_MatchPO() {
		return mRef_MatchPO;
	}

	/**
	 * Set Reversal ID.
	 *
	 * @param Reversal ID of document reversal
	 */
	@JsonProperty("Reversal")
	public void setReversalInput(ForeignEntityInput Reversal) {
		this.mReversal = Reversal;
		MMatchPO foreignEntity;
		if (Reversal != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_MatchPO", "M_MatchPO_UU=?", get_TrxName())
							.setParameters(Reversal.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setReversal_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_MatchPO with UUID " + Reversal.getUUID());
			}
		} else {
			super.setReversal_ID(0);
		}
	}

	/**
	 * Get Reversal ID.
	 *
	 * @return ID of document reversal
	 */
	@JsonProperty("Reversal")
	public ForeignEntityInput Reversal() {
		return mReversal;
	}
}
