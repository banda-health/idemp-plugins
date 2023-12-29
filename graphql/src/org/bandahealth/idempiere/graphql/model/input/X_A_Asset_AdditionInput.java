package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MConversionType;
import org.compiere.model.MCurrency;
import org.compiere.model.MIFixedAsset;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MJournalBatch;
import org.compiere.model.MLocator;
import org.compiere.model.MMatchInv;
import org.compiere.model.MOrg;
import org.compiere.model.MProject;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_A_Asset_Addition;
import org.compiere.util.Env;

/**
 * Generated Model for A_Asset_Addition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_AdditionInput extends X_A_Asset_Addition implements I_A_Asset_AdditionInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput A_CapvsExp_RL;
	 private I_AD_Ref_ListInput A_SourceType_RL;
	 private I_AD_Ref_ListInput DocAction_RL;
	 private I_AD_Ref_ListInput DocStatus_RL;
	 private I_AD_Ref_ListInput PostingType_RL;
	 private I_A_AssetInput A_Asset;
	 private I_C_ChargeInput C_Charge;
	 private I_C_ConversionTypeInput C_ConversionType;
	 private I_C_CurrencyInput C_Currency;
	 private I_C_DocTypeInput C_DocType;
	 private I_C_InvoiceInput C_Invoice;
	 private I_C_InvoiceLineInput C_InvoiceLine;
	 private I_C_ProjectInput C_Project;
	 private I_GL_JournalBatchInput GL_JournalBatch;
	 private I_I_FixedAssetInput I_FixedAsset;
	 private I_M_AttributeSetInstanceInput M_AttributeSetInstance;
	 private I_M_InOutLineInput M_InOutLine;
	 private I_M_LocatorInput M_Locator;
	 private I_M_MatchInvInput M_MatchInv;
	 private I_M_ProductInput M_Product;

	/**
	 * Standard constructor
	 */
	public X_A_Asset_AdditionInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}
	/**
	 * Set Asset Addition.
	 *
	 * @param A_Asset_Addition_ID Asset Addition
	 */

	public void setA_Asset_Addition_ID(int A_Asset_Addition_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Addition_ID(A_Asset_Addition_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Asset_Addition_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Asset_Addition_UU();
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
	 * Set Capital/Expense.
	 *
	 * @param A_CapvsExp_RL Capital/Expense
	 */
	public void setA_CapvsExp_RL(I_AD_Ref_ListInput A_CapvsExp_RL) {
		this.A_CapvsExp_RL = A_CapvsExp_RL;
		MRefList foreignEntity;
		if (A_CapvsExp_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_CapvsExp_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_CapvsExp(foreignEntity.getValue());
		} else {
			this.setA_CapvsExp(null);
		}
	}

	/**
	 * Get Capital/Expense.
	 *
	 * @return Capital/Expense
	 */
	public I_AD_Ref_ListInput getA_CapvsExp_RL() {
		return A_CapvsExp_RL;
	}

	/**
	 * Set Source Type.
	 *
	 * @param A_SourceType_RL Source Type
	 */
	public void setA_SourceType_RL(I_AD_Ref_ListInput A_SourceType_RL) {
		this.A_SourceType_RL = A_SourceType_RL;
		MRefList foreignEntity;
		if (A_SourceType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_SourceType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_SourceType(foreignEntity.getValue());
		} else {
			this.setA_SourceType(null);
		}
	}

	/**
	 * Get Source Type.
	 *
	 * @return Source Type
	 */
	public I_AD_Ref_ListInput getA_SourceType_RL() {
		return A_SourceType_RL;
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
	 * Set Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	public void setC_Charge(I_C_ChargeInput C_Charge) {
		this.C_Charge = C_Charge;
		MCharge_BH foreignEntity;
		if (C_Charge != null &&
				(foreignEntity = new Query(getCtx(), MCharge_BH.Table_Name, MCharge_BH.COLUMNNAME_C_Charge_UU + "=?", get_TrxName())
						.setParameters(C_Charge.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Charge_ID(foreignEntity.get_ID());
		} else {
			this.setC_Charge_ID(0);
		}
	}

	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	public I_C_ChargeInput getC_Charge() {
		return C_Charge;
	}

	/**
	 * Set Currency Type.
	 *
	 * @param C_ConversionType Currency Conversion Rate Type
	 */
	public void setC_ConversionType(I_C_ConversionTypeInput C_ConversionType) {
		this.C_ConversionType = C_ConversionType;
		MConversionType foreignEntity;
		if (C_ConversionType != null &&
				(foreignEntity = new Query(getCtx(), MConversionType.Table_Name, MConversionType.COLUMNNAME_C_ConversionType_UU + "=?", get_TrxName())
						.setParameters(C_ConversionType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_ConversionType_ID(foreignEntity.get_ID());
		} else {
			this.setC_ConversionType_ID(0);
		}
	}

	/**
	 * Get Currency Type.
	 *
	 * @return Currency Conversion Rate Type
	 */
	public I_C_ConversionTypeInput getC_ConversionType() {
		return C_ConversionType;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	public void setC_Currency(I_C_CurrencyInput C_Currency) {
		this.C_Currency = C_Currency;
		MCurrency foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), MCurrency.Table_Name, MCurrency.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			this.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public I_C_CurrencyInput getC_Currency() {
		return C_Currency;
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
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	public void setC_Project(I_C_ProjectInput C_Project) {
		this.C_Project = C_Project;
		MProject foreignEntity;
		if (C_Project != null &&
				(foreignEntity = new Query(getCtx(), MProject.Table_Name, MProject.COLUMNNAME_C_Project_UU + "=?", get_TrxName())
						.setParameters(C_Project.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Project_ID(foreignEntity.get_ID());
		} else {
			this.setC_Project_ID(0);
		}
	}

	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public I_C_ProjectInput getC_Project() {
		return C_Project;
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
	 * Set Journal Batch.
	 *
	 * @param GL_JournalBatch General Ledger Journal Batch
	 */
	public void setGL_JournalBatch(I_GL_JournalBatchInput GL_JournalBatch) {
		this.GL_JournalBatch = GL_JournalBatch;
		MJournalBatch foreignEntity;
		if (GL_JournalBatch != null &&
				(foreignEntity = new Query(getCtx(), MJournalBatch.Table_Name, MJournalBatch.COLUMNNAME_GL_JournalBatch_UU + "=?", get_TrxName())
						.setParameters(GL_JournalBatch.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setGL_JournalBatch_ID(foreignEntity.get_ID());
		} else {
			this.setGL_JournalBatch_ID(0);
		}
	}

	/**
	 * Get Journal Batch.
	 *
	 * @return General Ledger Journal Batch
	 */
	public I_GL_JournalBatchInput getGL_JournalBatch() {
		return GL_JournalBatch;
	}

	/**
	 * Set Imported Fixed Asset.
	 *
	 * @param I_FixedAsset Imported Fixed Asset
	 */
	public void setI_FixedAsset(I_I_FixedAssetInput I_FixedAsset) {
		this.I_FixedAsset = I_FixedAsset;
		MIFixedAsset foreignEntity;
		if (I_FixedAsset != null &&
				(foreignEntity = new Query(getCtx(), MIFixedAsset.Table_Name, MIFixedAsset.COLUMNNAME_I_FixedAsset_UU + "=?", get_TrxName())
						.setParameters(I_FixedAsset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setI_FixedAsset_ID(foreignEntity.get_ID());
		} else {
			this.setI_FixedAsset_ID(0);
		}
	}

	/**
	 * Get Imported Fixed Asset.
	 *
	 * @return Imported Fixed Asset
	 */
	public I_I_FixedAssetInput getI_FixedAsset() {
		return I_FixedAsset;
	}

	/**
	 * Set Attribute Set Instance.
	 *
	 * @param M_AttributeSetInstance Product Attribute Set Instance
	 */
	public void setM_AttributeSetInstance(I_M_AttributeSetInstanceInput M_AttributeSetInstance) {
		this.M_AttributeSetInstance = M_AttributeSetInstance;
		MAttributeSetInstance_BH foreignEntity;
		if (M_AttributeSetInstance != null &&
				(foreignEntity = new Query(getCtx(), MAttributeSetInstance_BH.Table_Name, MAttributeSetInstance_BH.COLUMNNAME_M_AttributeSetInstance_UU + "=?", get_TrxName())
						.setParameters(M_AttributeSetInstance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_AttributeSetInstance_ID(foreignEntity.get_ID());
		} else {
			this.setM_AttributeSetInstance_ID(0);
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
		if (M_InOutLine != null &&
				(foreignEntity = new Query(getCtx(), MInOutLine.Table_Name, MInOutLine.COLUMNNAME_M_InOutLine_UU + "=?", get_TrxName())
						.setParameters(M_InOutLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_InOutLine_ID(foreignEntity.get_ID());
		} else {
			this.setM_InOutLine_ID(0);
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
	 * Set Locator.
	 *
	 * @param M_Locator Warehouse Locator
	 */
	public void setM_Locator(I_M_LocatorInput M_Locator) {
		this.M_Locator = M_Locator;
		MLocator foreignEntity;
		if (M_Locator != null &&
				(foreignEntity = new Query(getCtx(), MLocator.Table_Name, MLocator.COLUMNNAME_M_Locator_UU + "=?", get_TrxName())
						.setParameters(M_Locator.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Locator_ID(foreignEntity.get_ID());
		} else {
			this.setM_Locator_ID(0);
		}
	}

	/**
	 * Get Locator.
	 *
	 * @return Warehouse Locator
	 */
	public I_M_LocatorInput getM_Locator() {
		return M_Locator;
	}

	/**
	 * Set Match Invoice.
	 *
	 * @param M_MatchInv Match Shipment/Receipt to Invoice
	 */
	public void setM_MatchInv(I_M_MatchInvInput M_MatchInv) {
		this.M_MatchInv = M_MatchInv;
		MMatchInv foreignEntity;
		if (M_MatchInv != null &&
				(foreignEntity = new Query(getCtx(), MMatchInv.Table_Name, MMatchInv.COLUMNNAME_M_MatchInv_UU + "=?", get_TrxName())
						.setParameters(M_MatchInv.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_MatchInv_ID(foreignEntity.get_ID());
		} else {
			this.setM_MatchInv_ID(0);
		}
	}

	/**
	 * Get Match Invoice.
	 *
	 * @return Match Shipment/Receipt to Invoice
	 */
	public I_M_MatchInvInput getM_MatchInv() {
		return M_MatchInv;
	}
	/**
	 * Set Match Invoice.
	 *
	 * @param M_MatchInv_ID Match Shipment/Receipt to Invoice
	 */

	public void setM_MatchInv_ID(int M_MatchInv_ID) {
		if (get_ID() == 0) {
			super.setM_MatchInv_ID(M_MatchInv_ID);
		}
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	public void setM_Product(I_M_ProductInput M_Product) {
		this.M_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_UU + "=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Product_ID(foreignEntity.get_ID());
		} else {
			this.setM_Product_ID(0);
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
	 * Set Product/Service.
	 *
	 * @param M_Product_ID Product, Service, Item
	 */

	public void setM_Product_ID(int M_Product_ID) {
		if (get_ID() == 0) {
			super.setM_Product_ID(M_Product_ID);
		}
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
