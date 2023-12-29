package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetDisposed;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for A_Asset_Disposed - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_DisposedInput extends MAssetDisposed implements I_A_Asset_DisposedInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput A_Activation_Method_RL;
	 private I_AD_Ref_ListInput A_Asset_Status_RL;
	 private I_AD_Ref_ListInput A_Disposed_Method_RL;
	 private I_AD_Ref_ListInput A_Disposed_Reason_RL;
	 private I_AD_Ref_ListInput DocAction_RL;
	 private I_AD_Ref_ListInput DocStatus_RL;
	 private I_AD_Ref_ListInput Posted_RL;
	 private I_AD_Ref_ListInput PostingType_RL;
	 private I_A_AssetInput A_Asset;
	 private I_A_AssetInput A_Asset_Trade;
	 private I_C_DocTypeInput C_DocType;
	 private I_C_InvoiceInput C_Invoice;
	 private I_C_InvoiceLineInput C_InvoiceLine;
	 private I_C_PeriodInput C_Period;

	/**
	 * Standard constructor
	 */
	public X_A_Asset_DisposedInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Activation Method.
	 *
	 * @param A_Activation_Method_RL Activation Method
	 */
	public void setA_Activation_Method_RL(I_AD_Ref_ListInput A_Activation_Method_RL) {
		this.A_Activation_Method_RL = A_Activation_Method_RL;
		MRefList foreignEntity;
		if (A_Activation_Method_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Activation_Method_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Activation_Method(foreignEntity.getValue());
		} else {
			this.setA_Activation_Method(null);
		}
	}

	/**
	 * Get Activation Method.
	 *
	 * @return Activation Method
	 */
	public I_AD_Ref_ListInput getA_Activation_Method_RL() {
		return A_Activation_Method_RL;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Asset_Disposed_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Asset_Disposed_UU();
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	public void setA_Asset(I_A_AssetInput A_Asset) {
		this.A_Asset = A_Asset;
		MAsset foreignEntity;
		if (A_Asset != null &&
				(foreignEntity = new Query(getCtx(), MAsset.Table_Name, MAsset.COLUMNNAME_A_Asset_UU + "=?", get_TrxName())
						.setParameters(A_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_ID(foreignEntity.get_ID());
		} else {
			this.setA_Asset_ID(0);
		}
	}

	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public I_A_AssetInput getA_Asset() {
		return A_Asset;
	}

	/**
	 * Set Asset Status.
	 *
	 * @param A_Asset_Status_RL Asset Status
	 */
	public void setA_Asset_Status_RL(I_AD_Ref_ListInput A_Asset_Status_RL) {
		this.A_Asset_Status_RL = A_Asset_Status_RL;
		MRefList foreignEntity;
		if (A_Asset_Status_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Status_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_Status(foreignEntity.getValue());
		} else {
			this.setA_Asset_Status(null);
		}
	}

	/**
	 * Get Asset Status.
	 *
	 * @return Asset Status
	 */
	public I_AD_Ref_ListInput getA_Asset_Status_RL() {
		return A_Asset_Status_RL;
	}

	/**
	 * Set Asset Trade.
	 *
	 * @param A_Asset_Trade Asset Trade
	 */
	public void setA_Asset_Trade(I_A_AssetInput A_Asset_Trade) {
		this.A_Asset_Trade = A_Asset_Trade;
		MAsset foreignEntity;
		if (A_Asset_Trade != null &&
				(foreignEntity = new Query(getCtx(), MAsset.Table_Name, MAsset.COLUMNNAME_A_Asset_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Trade.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_Trade_ID(foreignEntity.get_ID());
		} else {
			this.setA_Asset_Trade_ID(0);
		}
	}

	/**
	 * Get Asset Trade.
	 *
	 * @return Asset Trade
	 */
	public I_A_AssetInput getA_Asset_Trade() {
		return A_Asset_Trade;
	}

	/**
	 * Set Disposed Method.
	 *
	 * @param A_Disposed_Method_RL Disposed Method
	 */
	public void setA_Disposed_Method_RL(I_AD_Ref_ListInput A_Disposed_Method_RL) {
		this.A_Disposed_Method_RL = A_Disposed_Method_RL;
		MRefList foreignEntity;
		if (A_Disposed_Method_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Disposed_Method_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Disposed_Method(foreignEntity.getValue());
		} else {
			this.setA_Disposed_Method(null);
		}
	}

	/**
	 * Get Disposed Method.
	 *
	 * @return Disposed Method
	 */
	public I_AD_Ref_ListInput getA_Disposed_Method_RL() {
		return A_Disposed_Method_RL;
	}

	/**
	 * Set Disposed Reason.
	 *
	 * @param A_Disposed_Reason_RL Disposed Reason
	 */
	public void setA_Disposed_Reason_RL(I_AD_Ref_ListInput A_Disposed_Reason_RL) {
		this.A_Disposed_Reason_RL = A_Disposed_Reason_RL;
		MRefList foreignEntity;
		if (A_Disposed_Reason_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Disposed_Reason_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Disposed_Reason(foreignEntity.getValue());
		} else {
			this.setA_Disposed_Reason(null);
		}
	}

	/**
	 * Get Disposed Reason.
	 *
	 * @return Disposed Reason
	 */
	public I_AD_Ref_ListInput getA_Disposed_Reason_RL() {
		return A_Disposed_Reason_RL;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Org_ID(0);
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
	 * Set Document Type.
	 *
	 * @param C_DocType Document type or rules
	 */
	public void setC_DocType(I_C_DocTypeInput C_DocType) {
		this.C_DocType = C_DocType;
		MDocType_BH foreignEntity;
		if (C_DocType != null &&
				(foreignEntity = new Query(getCtx(), MDocType_BH.Table_Name, MDocType_BH.COLUMNNAME_C_DocType_UU + "=?", get_TrxName())
						.setParameters(C_DocType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_DocType_ID(foreignEntity.get_ID());
		} else {
			this.setC_DocType_ID(0);
		}
	}

	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public I_C_DocTypeInput getC_DocType() {
		return C_DocType;
	}

	/**
	 * Set Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	public void setC_Invoice(I_C_InvoiceInput C_Invoice) {
		this.C_Invoice = C_Invoice;
		MInvoice_BH foreignEntity;
		if (C_Invoice != null &&
				(foreignEntity = new Query(getCtx(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Invoice_UU + "=?", get_TrxName())
						.setParameters(C_Invoice.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Invoice_ID(foreignEntity.get_ID());
		} else {
			this.setC_Invoice_ID(0);
		}
	}

	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public I_C_InvoiceInput getC_Invoice() {
		return C_Invoice;
	}

	/**
	 * Set Invoice Line.
	 *
	 * @param C_InvoiceLine Invoice Detail Line
	 */
	public void setC_InvoiceLine(I_C_InvoiceLineInput C_InvoiceLine) {
		this.C_InvoiceLine = C_InvoiceLine;
		MInvoiceLine foreignEntity;
		if (C_InvoiceLine != null &&
				(foreignEntity = new Query(getCtx(), MInvoiceLine.Table_Name, MInvoiceLine.COLUMNNAME_C_InvoiceLine_UU + "=?", get_TrxName())
						.setParameters(C_InvoiceLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_InvoiceLine_ID(foreignEntity.get_ID());
		} else {
			this.setC_InvoiceLine_ID(0);
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
	 * Set Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	public void setC_Period(I_C_PeriodInput C_Period) {
		this.C_Period = C_Period;
		MPeriod foreignEntity;
		if (C_Period != null &&
				(foreignEntity = new Query(getCtx(), MPeriod.Table_Name, MPeriod.COLUMNNAME_C_Period_UU + "=?", get_TrxName())
						.setParameters(C_Period.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Period_ID(foreignEntity.get_ID());
		} else {
			this.setC_Period_ID(0);
		}
	}

	/**
	 * Get Period.
	 *
	 * @return Period of the Calendar
	 */
	public I_C_PeriodInput getC_Period() {
		return C_Period;
	}

	/**
	 * Set Document Action.
	 *
	 * @param DocAction_RL The targeted status of the document
	 */
	public void setDocAction_RL(I_AD_Ref_ListInput DocAction_RL) {
		this.DocAction_RL = DocAction_RL;
		MRefList foreignEntity;
		if (DocAction_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocAction_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDocAction(foreignEntity.getValue());
		} else {
			this.setDocAction(null);
		}
	}

	/**
	 * Get Document Action.
	 *
	 * @return The targeted status of the document
	 */
	public I_AD_Ref_ListInput getDocAction_RL() {
		return DocAction_RL;
	}

	/**
	 * Set Document Status.
	 *
	 * @param DocStatus_RL The current status of the document
	 */
	public void setDocStatus_RL(I_AD_Ref_ListInput DocStatus_RL) {
		this.DocStatus_RL = DocStatus_RL;
		MRefList foreignEntity;
		if (DocStatus_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocStatus_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDocStatus(foreignEntity.getValue());
		} else {
			this.setDocStatus(null);
		}
	}

	/**
	 * Get Document Status.
	 *
	 * @return The current status of the document
	 */
	public I_AD_Ref_ListInput getDocStatus_RL() {
		return DocStatus_RL;
	}
	/**
	 * Set Document No.
	 *
	 * @param DocumentNo Document sequence number of the document
	 */
	public void setDocumentNo(String DocumentNo) {
		if (get_ID() == 0) {
			super.setDocumentNo(DocumentNo);
		}
	}

	/**
	 * Set Posted.
	 *
	 * @param Posted_RL Posting status
	 */
	public void setPosted_RL(I_AD_Ref_ListInput Posted_RL) {
		this.Posted_RL = Posted_RL;
		MRefList foreignEntity;
		if (Posted_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(Posted_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPosted(foreignEntity.getValue());
		} else {
			this.setPosted(null);
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
	 * Set PostingType.
	 *
	 * @param PostingType_RL The type of posted amount for the transaction
	 */
	public void setPostingType_RL(I_AD_Ref_ListInput PostingType_RL) {
		this.PostingType_RL = PostingType_RL;
		MRefList foreignEntity;
		if (PostingType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PostingType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPostingType(foreignEntity.getValue());
		} else {
			this.setPostingType(null);
		}
	}

	/**
	 * Get PostingType.
	 *
	 * @return The type of posted amount for the transaction
	 */
	public I_AD_Ref_ListInput getPostingType_RL() {
		return PostingType_RL;
	}
}
