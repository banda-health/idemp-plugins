package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MMatchInv;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for M_MatchInv - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_MatchInvInput extends MMatchInv implements I_M_MatchInvInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput Posted_RL;
	 private I_C_InvoiceLineInput C_InvoiceLine;
	 private I_M_AttributeSetInstanceInput M_AttributeSetInstance;
	 private I_M_InOutLineInput M_InOutLine;
	 private I_M_MatchInvInput Ref_MatchInv;
	 private I_M_MatchInvInput Reversal;
	 private I_M_ProductInput M_Product;

	/**
	 * Standard constructor
	 */
	public X_M_MatchInvInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Invoice Line.
	 *
	 * @param C_InvoiceLine Invoice Detail Line
	 */
	public void setC_InvoiceLine(I_C_InvoiceLineInput C_InvoiceLine) {
		this.C_InvoiceLine = C_InvoiceLine;
		MInvoiceLine foreignEntity;
		if (get_ID() == 0 &&C_InvoiceLine != null &&
				(foreignEntity = new Query(getCtx(), MInvoiceLine.Table_Name, MInvoiceLine.COLUMNNAME_C_InvoiceLine_UU + "=?", get_TrxName())
						.setParameters(C_InvoiceLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_InvoiceLine_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Invoice Line.
	 *
	 * @return Invoice Detail Line
	 */
	public I_C_InvoiceLineInput getC_InvoiceLine() {
		return C_InvoiceLine;
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
	 * Set Active.
	 *
	 * @param IsActive The record is active in the system
	 */
	public void setIsActive(boolean IsActive) {
		if (get_ID() == 0) {
			super.setIsActive(IsActive);
		}
	}

	/**
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	public void setM_AttributeSetInstance(I_M_AttributeSetInstanceInput M_AttributeSetInstance) {
		this.M_AttributeSetInstance = M_AttributeSetInstance;
		MAttributeSetInstance_BH foreignEntity;
		if (get_ID() == 0 &&M_AttributeSetInstance != null &&
				(foreignEntity = new Query(getCtx(), MAttributeSetInstance_BH.Table_Name, MAttributeSetInstance_BH.COLUMNNAME_M_AttributeSetInstance_UU + "=?", get_TrxName())
						.setParameters(M_AttributeSetInstance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public I_M_AttributeSetInstanceInput getM_AttributeSetInstance() {
		return M_AttributeSetInstance;
	}

	/**
	 * Set Shipment/Receipt Line.
	 *
	 * @param M_InOutLine Line on Shipment or Receipt document
	 */
	public void setM_InOutLine(I_M_InOutLineInput M_InOutLine) {
		this.M_InOutLine = M_InOutLine;
		MInOutLine foreignEntity;
		if (get_ID() == 0 &&M_InOutLine != null &&
				(foreignEntity = new Query(getCtx(), MInOutLine.Table_Name, MInOutLine.COLUMNNAME_M_InOutLine_UU + "=?", get_TrxName())
						.setParameters(M_InOutLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_InOutLine_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Shipment/Receipt Line.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	public I_M_InOutLineInput getM_InOutLine() {
		return M_InOutLine;
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
	public void setM_Product(I_M_ProductInput M_Product) {
		this.M_Product = M_Product;
		MProduct_BH foreignEntity;
		if (get_ID() == 0 &&M_Product != null &&
				(foreignEntity = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_UU + "=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Product_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public I_M_ProductInput getM_Product() {
		return M_Product;
	}

	/**
	 * Set Posted.
	 *
	 * @param Posted_RL Posting status
	 */
	public void setPosted_RL(I_AD_Ref_ListInput Posted_RL) {
		this.Posted_RL = Posted_RL;
		MRefList foreignEntity;
		if (get_ID() == 0 &&Posted_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(Posted_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPosted(foreignEntity.getValue());
		}
	}

	/**
	 * Get Posted.
	 *
	 * @return Posting status
	 */
	public I_AD_Ref_ListInput getPosted_RL() {
		return Posted_RL;
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
	public void setRef_MatchInv(I_M_MatchInvInput Ref_MatchInv) {
		this.Ref_MatchInv = Ref_MatchInv;
		MMatchInv foreignEntity;
		if (Ref_MatchInv != null &&
				(foreignEntity = new Query(getCtx(), MMatchInv.Table_Name, MMatchInv.COLUMNNAME_M_MatchInv_UU + "=?", get_TrxName())
						.setParameters(Ref_MatchInv.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setRef_MatchInv_ID(foreignEntity.get_ID());
		} else {
			this.setRef_MatchInv_ID(0);
		}
	}

	/**
	 * Get Referenced Match Invoice.
	 *
	 * @return Referenced Match Invoice
	 */
	public I_M_MatchInvInput getRef_MatchInv() {
		return Ref_MatchInv;
	}

	/**
	 * Set Reversal ID.
	 *
	 * @param Reversal ID of document reversal
	 */
	public void setReversal(I_M_MatchInvInput Reversal) {
		this.Reversal = Reversal;
		MMatchInv foreignEntity;
		if (Reversal != null &&
				(foreignEntity = new Query(getCtx(), MMatchInv.Table_Name, MMatchInv.COLUMNNAME_M_MatchInv_UU + "=?", get_TrxName())
						.setParameters(Reversal.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setReversal_ID(foreignEntity.get_ID());
		} else {
			this.setReversal_ID(0);
		}
	}

	/**
	 * Get Reversal ID.
	 *
	 * @return ID of document reversal
	 */
	public I_M_MatchInvInput getReversal() {
		return Reversal;
	}
}
