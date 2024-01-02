package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MInvoiceLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInOutLine;
import org.compiere.model.MMatchInv;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for M_MatchInv - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_MatchInvInput extends MMatchInv implements I_M_MatchInvInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_C_InvoiceLineInput mC_InvoiceLine;
	 private I_M_AttributeSetInstanceInput mM_AttributeSetInstance;
	 private I_M_InOutLineInput mM_InOutLine;
	 private I_M_MatchInvInput mRef_MatchInv;
	 private I_M_MatchInvInput mReversal;
	 private I_M_ProductInput mM_Product;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_MatchInvInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Invoice Line.
	 *
	 * @param C_InvoiceLine Invoice Detail Line
	 */
	@JsonProperty("C_InvoiceLine")
	public void setC_InvoiceLineInput(I_C_InvoiceLineInput C_InvoiceLine) {
		this.mC_InvoiceLine = C_InvoiceLine;
		MInvoiceLine_BH foreignEntity;
		if (get_ID() == 0 &&C_InvoiceLine != null &&
				(foreignEntity = new Query(getCtx(), MInvoiceLine_BH.Table_Name, MInvoiceLine_BH.COLUMNNAME_C_InvoiceLine_UU + "=?", get_TrxName())
						.setParameters(C_InvoiceLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_InvoiceLine_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Invoice Line.
	 *
	 * @return Invoice Detail Line
	 */
	@JsonProperty("C_InvoiceLine")
	public I_C_InvoiceLineInput C_InvoiceLine() {
		return mC_InvoiceLine;
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
	public void setM_AttributeSetInstanceInput(I_M_AttributeSetInstanceInput M_AttributeSetInstance) {
		this.mM_AttributeSetInstance = M_AttributeSetInstance;
		MAttributeSetInstance_BH foreignEntity;
		if (get_ID() == 0 &&M_AttributeSetInstance != null &&
				(foreignEntity = new Query(getCtx(), MAttributeSetInstance_BH.Table_Name, MAttributeSetInstance_BH.COLUMNNAME_M_AttributeSetInstance_UU + "=?", get_TrxName())
						.setParameters(M_AttributeSetInstance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	@JsonProperty("M_AttributeSetInstance")
	public I_M_AttributeSetInstanceInput M_AttributeSetInstance() {
		return mM_AttributeSetInstance;
	}

	/**
	 * Set Shipment/Receipt Line.
	 *
	 * @param M_InOutLine Line on Shipment or Receipt document
	 */
	@JsonProperty("M_InOutLine")
	public void setM_InOutLineInput(I_M_InOutLineInput M_InOutLine) {
		this.mM_InOutLine = M_InOutLine;
		MInOutLine foreignEntity;
		if (get_ID() == 0 &&M_InOutLine != null &&
				(foreignEntity = new Query(getCtx(), MInOutLine.Table_Name, MInOutLine.COLUMNNAME_M_InOutLine_UU + "=?", get_TrxName())
						.setParameters(M_InOutLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_InOutLine_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Shipment/Receipt Line.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	@JsonProperty("M_InOutLine")
	public I_M_InOutLineInput M_InOutLine() {
		return mM_InOutLine;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_MatchInv_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_MatchInv_UU();
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(I_M_ProductInput M_Product) {
		this.mM_Product = M_Product;
		MProduct_BH foreignEntity;
		if (get_ID() == 0 &&M_Product != null &&
				(foreignEntity = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_UU + "=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public I_M_ProductInput M_Product() {
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
	 * Set Referenced Match Invoice.
	 *
	 * @param Ref_MatchInv Referenced Match Invoice
	 */
	@JsonProperty("Ref_MatchInv")
	public void setRef_MatchInvInput(I_M_MatchInvInput Ref_MatchInv) {
		this.mRef_MatchInv = Ref_MatchInv;
		MMatchInv foreignEntity;
		if (Ref_MatchInv != null &&
				(foreignEntity = new Query(getCtx(), MMatchInv.Table_Name, MMatchInv.COLUMNNAME_M_MatchInv_UU + "=?", get_TrxName())
						.setParameters(Ref_MatchInv.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setRef_MatchInv_ID(foreignEntity.get_ID());
		} else {
			super.setRef_MatchInv_ID(0);
		}
	}

	/**
	 * Get Referenced Match Invoice.
	 *
	 * @return Referenced Match Invoice
	 */
	@JsonProperty("Ref_MatchInv")
	public I_M_MatchInvInput Ref_MatchInv() {
		return mRef_MatchInv;
	}

	/**
	 * Set Reversal ID.
	 *
	 * @param Reversal ID of document reversal
	 */
	@JsonProperty("Reversal")
	public void setReversalInput(I_M_MatchInvInput Reversal) {
		this.mReversal = Reversal;
		MMatchInv foreignEntity;
		if (Reversal != null &&
				(foreignEntity = new Query(getCtx(), MMatchInv.Table_Name, MMatchInv.COLUMNNAME_M_MatchInv_UU + "=?", get_TrxName())
						.setParameters(Reversal.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setReversal_ID(foreignEntity.get_ID());
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
	public I_M_MatchInvInput Reversal() {
		return mReversal;
	}
}
