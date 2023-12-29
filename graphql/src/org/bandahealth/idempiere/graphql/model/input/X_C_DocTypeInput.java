package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MSequence_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MGLCategory;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
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

	 private I_AD_OrgInput AD_Org;
	 private I_AD_PrintFormatInput AD_PrintFormat;
	 private I_AD_Ref_ListInput DocBaseType_RL;
	 private I_AD_Ref_ListInput DocSubTypeInv_RL;
	 private I_AD_Ref_ListInput DocSubTypeSO_RL;
	 private I_AD_SequenceInput DefiniteSequence;
	 private I_AD_SequenceInput DocNoSequence;
	 private I_C_DocTypeInput C_DocTypeDifference;
	 private I_C_DocTypeInput C_DocTypeInvoice;
	 private I_C_DocTypeInput C_DocTypeProforma;
	 private I_C_DocTypeInput C_DocTypeShipment;
	 private I_GL_CategoryInput GL_Category;

	/**
	 * Standard constructor
	 */
	public X_C_DocTypeInput(String ID) {
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
	 * Set Print Format.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	public void setAD_PrintFormat(I_AD_PrintFormatInput AD_PrintFormat) {
		this.AD_PrintFormat = AD_PrintFormat;
		X_AD_PrintFormat foreignEntity;
		if (AD_PrintFormat != null &&
				(foreignEntity = new Query(getCtx(), X_AD_PrintFormat.Table_Name, X_AD_PrintFormat.COLUMNNAME_AD_PrintFormat_UU + "=?", get_TrxName())
						.setParameters(AD_PrintFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_PrintFormat_ID(foreignEntity.get_ID());
		} else {
			this.setAD_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	public I_AD_PrintFormatInput getAD_PrintFormat() {
		return AD_PrintFormat;
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
	public void setC_DocTypeDifference(I_C_DocTypeInput C_DocTypeDifference) {
		this.C_DocTypeDifference = C_DocTypeDifference;
		MDocType_BH foreignEntity;
		if (C_DocTypeDifference != null &&
				(foreignEntity = new Query(getCtx(), MDocType_BH.Table_Name, MDocType_BH.COLUMNNAME_C_DocType_UU + "=?", get_TrxName())
						.setParameters(C_DocTypeDifference.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_DocTypeDifference_ID(foreignEntity.get_ID());
		} else {
			this.setC_DocTypeDifference_ID(0);
		}
	}

	/**
	 * Get Difference Document.
	 *
	 * @return Document type for generating in dispute Shipments
	 */
	public I_C_DocTypeInput getC_DocTypeDifference() {
		return C_DocTypeDifference;
	}

	/**
	 * Set Document Type for Invoice.
	 *
	 * @param C_DocTypeInvoice Document type used for invoices generated from this sales document
	 */
	public void setC_DocTypeInvoice(I_C_DocTypeInput C_DocTypeInvoice) {
		this.C_DocTypeInvoice = C_DocTypeInvoice;
		MDocType_BH foreignEntity;
		if (C_DocTypeInvoice != null &&
				(foreignEntity = new Query(getCtx(), MDocType_BH.Table_Name, MDocType_BH.COLUMNNAME_C_DocType_UU + "=?", get_TrxName())
						.setParameters(C_DocTypeInvoice.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_DocTypeInvoice_ID(foreignEntity.get_ID());
		} else {
			this.setC_DocTypeInvoice_ID(0);
		}
	}

	/**
	 * Get Document Type for Invoice.
	 *
	 * @return Document type used for invoices generated from this sales document
	 */
	public I_C_DocTypeInput getC_DocTypeInvoice() {
		return C_DocTypeInvoice;
	}

	/**
	 * Set Document Type for ProForma.
	 *
	 * @param C_DocTypeProforma Document type used for pro forma invoices generated from this sales document
	 */
	public void setC_DocTypeProforma(I_C_DocTypeInput C_DocTypeProforma) {
		this.C_DocTypeProforma = C_DocTypeProforma;
		MDocType_BH foreignEntity;
		if (C_DocTypeProforma != null &&
				(foreignEntity = new Query(getCtx(), MDocType_BH.Table_Name, MDocType_BH.COLUMNNAME_C_DocType_UU + "=?", get_TrxName())
						.setParameters(C_DocTypeProforma.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_DocTypeProforma_ID(foreignEntity.get_ID());
		} else {
			this.setC_DocTypeProforma_ID(0);
		}
	}

	/**
	 * Get Document Type for ProForma.
	 *
	 * @return Document type used for pro forma invoices generated from this sales document
	 */
	public I_C_DocTypeInput getC_DocTypeProforma() {
		return C_DocTypeProforma;
	}

	/**
	 * Set Document Type for Shipment.
	 *
	 * @param C_DocTypeShipment Document type used for shipments generated from this sales document
	 */
	public void setC_DocTypeShipment(I_C_DocTypeInput C_DocTypeShipment) {
		this.C_DocTypeShipment = C_DocTypeShipment;
		MDocType_BH foreignEntity;
		if (C_DocTypeShipment != null &&
				(foreignEntity = new Query(getCtx(), MDocType_BH.Table_Name, MDocType_BH.COLUMNNAME_C_DocType_UU + "=?", get_TrxName())
						.setParameters(C_DocTypeShipment.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_DocTypeShipment_ID(foreignEntity.get_ID());
		} else {
			this.setC_DocTypeShipment_ID(0);
		}
	}

	/**
	 * Get Document Type for Shipment.
	 *
	 * @return Document type used for shipments generated from this sales document
	 */
	public I_C_DocTypeInput getC_DocTypeShipment() {
		return C_DocTypeShipment;
	}

	/**
	 * Set Definite Sequence.
	 *
	 * @param DefiniteSequence Definite Sequence
	 */
	public void setDefiniteSequence(I_AD_SequenceInput DefiniteSequence) {
		this.DefiniteSequence = DefiniteSequence;
		MSequence_BH foreignEntity;
		if (DefiniteSequence != null &&
				(foreignEntity = new Query(getCtx(), MSequence_BH.Table_Name, MSequence_BH.COLUMNNAME_AD_Sequence_UU + "=?", get_TrxName())
						.setParameters(DefiniteSequence.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDefiniteSequence_ID(foreignEntity.get_ID());
		} else {
			this.setDefiniteSequence_ID(0);
		}
	}

	/**
	 * Get Definite Sequence.
	 *
	 * @return Definite Sequence
	 */
	public I_AD_SequenceInput getDefiniteSequence() {
		return DefiniteSequence;
	}

	/**
	 * Set Document BaseType.
	 *
	 * @param DocBaseType_RL Logical type of document
	 */
	public void setDocBaseType_RL(I_AD_Ref_ListInput DocBaseType_RL) {
		this.DocBaseType_RL = DocBaseType_RL;
		MRefList foreignEntity;
		if (DocBaseType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocBaseType_RL.getID())
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
	public I_AD_Ref_ListInput getDocBaseType_RL() {
		return DocBaseType_RL;
	}

	/**
	 * Set Document Sequence.
	 *
	 * @param DocNoSequence Document sequence determines the numbering of documents
	 */
	public void setDocNoSequence(I_AD_SequenceInput DocNoSequence) {
		this.DocNoSequence = DocNoSequence;
		MSequence_BH foreignEntity;
		if (DocNoSequence != null &&
				(foreignEntity = new Query(getCtx(), MSequence_BH.Table_Name, MSequence_BH.COLUMNNAME_AD_Sequence_UU + "=?", get_TrxName())
						.setParameters(DocNoSequence.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDocNoSequence_ID(foreignEntity.get_ID());
		} else {
			this.setDocNoSequence_ID(0);
		}
	}

	/**
	 * Get Document Sequence.
	 *
	 * @return Document sequence determines the numbering of documents
	 */
	public I_AD_SequenceInput getDocNoSequence() {
		return DocNoSequence;
	}

	/**
	 * Set Inv Sub Type.
	 *
	 * @param DocSubTypeInv_RL Inventory Sub Type
	 */
	public void setDocSubTypeInv_RL(I_AD_Ref_ListInput DocSubTypeInv_RL) {
		this.DocSubTypeInv_RL = DocSubTypeInv_RL;
		MRefList foreignEntity;
		if (DocSubTypeInv_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocSubTypeInv_RL.getID())
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
	public I_AD_Ref_ListInput getDocSubTypeInv_RL() {
		return DocSubTypeInv_RL;
	}

	/**
	 * Set SO Sub Type.
	 *
	 * @param DocSubTypeSO_RL Sales Order Sub Type
	 */
	public void setDocSubTypeSO_RL(I_AD_Ref_ListInput DocSubTypeSO_RL) {
		this.DocSubTypeSO_RL = DocSubTypeSO_RL;
		MRefList foreignEntity;
		if (DocSubTypeSO_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocSubTypeSO_RL.getID())
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
	public I_AD_Ref_ListInput getDocSubTypeSO_RL() {
		return DocSubTypeSO_RL;
	}

	/**
	 * Set GL Category.
	 *
	 * @param GL_Category General Ledger Category
	 */
	public void setGL_Category(I_GL_CategoryInput GL_Category) {
		this.GL_Category = GL_Category;
		MGLCategory foreignEntity;
		if (GL_Category != null &&
				(foreignEntity = new Query(getCtx(), MGLCategory.Table_Name, MGLCategory.COLUMNNAME_GL_Category_UU + "=?", get_TrxName())
						.setParameters(GL_Category.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setGL_Category_ID(foreignEntity.get_ID());
		} else {
			this.setGL_Category_ID(0);
		}
	}

	/**
	 * Get GL Category.
	 *
	 * @return General Ledger Category
	 */
	public I_GL_CategoryInput getGL_Category() {
		return GL_Category;
	}
}
