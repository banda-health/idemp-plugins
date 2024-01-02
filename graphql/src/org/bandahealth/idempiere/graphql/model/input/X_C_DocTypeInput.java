package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MSequence_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MGLCategory;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.util.Env;

/**
 * Generated Model for C_DocType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_DocTypeInput extends MDocType_BH implements I_C_DocTypeInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_PrintFormatInput mAD_PrintFormat;
	 private I_AD_Ref_ListInput mDocBaseType;
	 private I_AD_Ref_ListInput mDocSubTypeInv;
	 private I_AD_Ref_ListInput mDocSubTypeSO;
	 private I_AD_SequenceInput mDefiniteSequence;
	 private I_AD_SequenceInput mDocNoSequence;
	 private I_C_DocTypeInput mC_DocTypeDifference;
	 private I_C_DocTypeInput mC_DocTypeInvoice;
	 private I_C_DocTypeInput mC_DocTypeProforma;
	 private I_C_DocTypeInput mC_DocTypeShipment;
	 private I_GL_CategoryInput mGL_Category;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_DocTypeInput(@JsonProperty("ID") String ID) {
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
	 * Set Print Format.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	@JsonProperty("AD_PrintFormat")
	public void setAD_PrintFormatInput(I_AD_PrintFormatInput AD_PrintFormat) {
		this.mAD_PrintFormat = AD_PrintFormat;
		X_AD_PrintFormat foreignEntity;
		if (AD_PrintFormat != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintFormat.Table_Name, X_AD_PrintFormat.COLUMNNAME_AD_PrintFormat_UU + "=?", get_TrxName())
						.setParameters(AD_PrintFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PrintFormat_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	@JsonProperty("AD_PrintFormat")
	public I_AD_PrintFormatInput AD_PrintFormat() {
		return mAD_PrintFormat;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_DocType_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_DocType_UU();
	}

	/**
	 * Set Difference Document.
	 *
	 * @param C_DocTypeDifference Document type for generating in dispute Shipments
	 */
	@JsonProperty("C_DocTypeDifference")
	public void setC_DocTypeDifferenceInput(I_C_DocTypeInput C_DocTypeDifference) {
		this.mC_DocTypeDifference = C_DocTypeDifference;
		MDocType_BH foreignEntity;
		if (C_DocTypeDifference != null &&
				(foreignEntity = new Query(getCtx(), MDocType_BH.Table_Name, MDocType_BH.COLUMNNAME_C_DocType_UU + "=?", get_TrxName())
						.setParameters(C_DocTypeDifference.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_DocTypeDifference_ID(foreignEntity.get_ID());
		} else {
			super.setC_DocTypeDifference_ID(0);
		}
	}

	/**
	 * Get Difference Document.
	 *
	 * @return Document type for generating in dispute Shipments
	 */
	@JsonProperty("C_DocTypeDifference")
	public I_C_DocTypeInput C_DocTypeDifference() {
		return mC_DocTypeDifference;
	}

	/**
	 * Set Document Type for Invoice.
	 *
	 * @param C_DocTypeInvoice Document type used for invoices generated from this sales document
	 */
	@JsonProperty("C_DocTypeInvoice")
	public void setC_DocTypeInvoiceInput(I_C_DocTypeInput C_DocTypeInvoice) {
		this.mC_DocTypeInvoice = C_DocTypeInvoice;
		MDocType_BH foreignEntity;
		if (C_DocTypeInvoice != null &&
				(foreignEntity = new Query(getCtx(), MDocType_BH.Table_Name, MDocType_BH.COLUMNNAME_C_DocType_UU + "=?", get_TrxName())
						.setParameters(C_DocTypeInvoice.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_DocTypeInvoice_ID(foreignEntity.get_ID());
		} else {
			super.setC_DocTypeInvoice_ID(0);
		}
	}

	/**
	 * Get Document Type for Invoice.
	 *
	 * @return Document type used for invoices generated from this sales document
	 */
	@JsonProperty("C_DocTypeInvoice")
	public I_C_DocTypeInput C_DocTypeInvoice() {
		return mC_DocTypeInvoice;
	}

	/**
	 * Set Document Type for ProForma.
	 *
	 * @param C_DocTypeProforma Document type used for pro forma invoices generated from this sales document
	 */
	@JsonProperty("C_DocTypeProforma")
	public void setC_DocTypeProformaInput(I_C_DocTypeInput C_DocTypeProforma) {
		this.mC_DocTypeProforma = C_DocTypeProforma;
		MDocType_BH foreignEntity;
		if (C_DocTypeProforma != null &&
				(foreignEntity = new Query(getCtx(), MDocType_BH.Table_Name, MDocType_BH.COLUMNNAME_C_DocType_UU + "=?", get_TrxName())
						.setParameters(C_DocTypeProforma.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_DocTypeProforma_ID(foreignEntity.get_ID());
		} else {
			super.setC_DocTypeProforma_ID(0);
		}
	}

	/**
	 * Get Document Type for ProForma.
	 *
	 * @return Document type used for pro forma invoices generated from this sales document
	 */
	@JsonProperty("C_DocTypeProforma")
	public I_C_DocTypeInput C_DocTypeProforma() {
		return mC_DocTypeProforma;
	}

	/**
	 * Set Document Type for Shipment.
	 *
	 * @param C_DocTypeShipment Document type used for shipments generated from this sales document
	 */
	@JsonProperty("C_DocTypeShipment")
	public void setC_DocTypeShipmentInput(I_C_DocTypeInput C_DocTypeShipment) {
		this.mC_DocTypeShipment = C_DocTypeShipment;
		MDocType_BH foreignEntity;
		if (C_DocTypeShipment != null &&
				(foreignEntity = new Query(getCtx(), MDocType_BH.Table_Name, MDocType_BH.COLUMNNAME_C_DocType_UU + "=?", get_TrxName())
						.setParameters(C_DocTypeShipment.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_DocTypeShipment_ID(foreignEntity.get_ID());
		} else {
			super.setC_DocTypeShipment_ID(0);
		}
	}

	/**
	 * Get Document Type for Shipment.
	 *
	 * @return Document type used for shipments generated from this sales document
	 */
	@JsonProperty("C_DocTypeShipment")
	public I_C_DocTypeInput C_DocTypeShipment() {
		return mC_DocTypeShipment;
	}

	/**
	 * Set Definite Sequence.
	 *
	 * @param DefiniteSequence Definite Sequence
	 */
	@JsonProperty("DefiniteSequence")
	public void setDefiniteSequenceInput(I_AD_SequenceInput DefiniteSequence) {
		this.mDefiniteSequence = DefiniteSequence;
		MSequence_BH foreignEntity;
		if (DefiniteSequence != null &&
				(foreignEntity = new Query(getCtx(), MSequence_BH.Table_Name, MSequence_BH.COLUMNNAME_AD_Sequence_UU + "=?", get_TrxName())
						.setParameters(DefiniteSequence.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setDefiniteSequence_ID(foreignEntity.get_ID());
		} else {
			super.setDefiniteSequence_ID(0);
		}
	}

	/**
	 * Get Definite Sequence.
	 *
	 * @return Definite Sequence
	 */
	@JsonProperty("DefiniteSequence")
	public I_AD_SequenceInput DefiniteSequence() {
		return mDefiniteSequence;
	}

	/**
	 * Set Document BaseType.
	 *
	 * @param DocBaseType Logical type of document
	 */
	@JsonProperty("DocBaseType")
	public void setDocBaseTypeInput(I_AD_Ref_ListInput DocBaseType) {
		this.mDocBaseType = DocBaseType;
		MRefList_BH foreignEntity;
		if (DocBaseType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocBaseType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDocBaseType(foreignEntity.getValue());
		} else {
			this.setDocBaseType(null);
		}
	}

	/**
	 * Get Document BaseType.
	 *
	 * @return Logical type of document
	 */
	@JsonProperty("DocBaseType")
	public I_AD_Ref_ListInput DocBaseType() {
		return mDocBaseType;
	}

	/**
	 * Set Document Sequence.
	 *
	 * @param DocNoSequence Document sequence determines the numbering of documents
	 */
	@JsonProperty("DocNoSequence")
	public void setDocNoSequenceInput(I_AD_SequenceInput DocNoSequence) {
		this.mDocNoSequence = DocNoSequence;
		MSequence_BH foreignEntity;
		if (DocNoSequence != null &&
				(foreignEntity = new Query(getCtx(), MSequence_BH.Table_Name, MSequence_BH.COLUMNNAME_AD_Sequence_UU + "=?", get_TrxName())
						.setParameters(DocNoSequence.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setDocNoSequence_ID(foreignEntity.get_ID());
		} else {
			super.setDocNoSequence_ID(0);
		}
	}

	/**
	 * Get Document Sequence.
	 *
	 * @return Document sequence determines the numbering of documents
	 */
	@JsonProperty("DocNoSequence")
	public I_AD_SequenceInput DocNoSequence() {
		return mDocNoSequence;
	}

	/**
	 * Set Inv Sub Type.
	 *
	 * @param DocSubTypeInv Inventory Sub Type
	 */
	@JsonProperty("DocSubTypeInv")
	public void setDocSubTypeInvInput(I_AD_Ref_ListInput DocSubTypeInv) {
		this.mDocSubTypeInv = DocSubTypeInv;
		MRefList_BH foreignEntity;
		if (DocSubTypeInv != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocSubTypeInv.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDocSubTypeInv(foreignEntity.getValue());
		} else {
			this.setDocSubTypeInv(null);
		}
	}

	/**
	 * Get Inv Sub Type.
	 *
	 * @return Inventory Sub Type
	 */
	@JsonProperty("DocSubTypeInv")
	public I_AD_Ref_ListInput DocSubTypeInv() {
		return mDocSubTypeInv;
	}

	/**
	 * Set SO Sub Type.
	 *
	 * @param DocSubTypeSO Sales Order Sub Type
	 */
	@JsonProperty("DocSubTypeSO")
	public void setDocSubTypeSOInput(I_AD_Ref_ListInput DocSubTypeSO) {
		this.mDocSubTypeSO = DocSubTypeSO;
		MRefList_BH foreignEntity;
		if (DocSubTypeSO != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocSubTypeSO.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDocSubTypeSO(foreignEntity.getValue());
		} else {
			this.setDocSubTypeSO(null);
		}
	}

	/**
	 * Get SO Sub Type.
	 *
	 * @return Sales Order Sub Type
	 */
	@JsonProperty("DocSubTypeSO")
	public I_AD_Ref_ListInput DocSubTypeSO() {
		return mDocSubTypeSO;
	}

	/**
	 * Set GL Category.
	 *
	 * @param GL_Category General Ledger Category
	 */
	@JsonProperty("GL_Category")
	public void setGL_CategoryInput(I_GL_CategoryInput GL_Category) {
		this.mGL_Category = GL_Category;
		MGLCategory foreignEntity;
		if (GL_Category != null &&
				(foreignEntity = new Query(getCtx(), MGLCategory.Table_Name, MGLCategory.COLUMNNAME_GL_Category_UU + "=?", get_TrxName())
						.setParameters(GL_Category.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setGL_Category_ID(foreignEntity.get_ID());
		} else {
			super.setGL_Category_ID(0);
		}
	}

	/**
	 * Get GL Category.
	 *
	 * @return General Ledger Category
	 */
	@JsonProperty("GL_Category")
	public I_GL_CategoryInput GL_Category() {
		return mGL_Category;
	}
}
