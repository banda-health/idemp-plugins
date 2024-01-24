package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MSequence_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MGLCategory;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_DocType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_DocTypeInput extends MDocType_BH implements I_C_DocTypeInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PrintFormat;
	private ForeignEntityInput mC_DocTypeDifference;
	private ForeignEntityInput mC_DocTypeInvoice;
	private ForeignEntityInput mC_DocTypeProforma;
	private ForeignEntityInput mC_DocTypeShipment;
	private ForeignEntityInput mDefiniteSequence;
	private ForeignEntityInput mDocNoSequence;
	private ForeignEntityInput mGL_Category;
	private I_AD_Ref_ListInput mDocBaseType;
	private I_AD_Ref_ListInput mDocSubTypeInv;
	private I_AD_Ref_ListInput mDocSubTypeSO;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_DocType_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_DocTypeInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MDocType_BH(null, (ResultSet) null, null),
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
	 * Set Print Format.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	@JsonProperty("AD_PrintFormat")
	public void setAD_PrintFormatInput(ForeignEntityInput AD_PrintFormat) {
		this.mAD_PrintFormat = AD_PrintFormat;
		X_AD_PrintFormat foreignEntity;
		if (AD_PrintFormat != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
							.setParameters(AD_PrintFormat.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_PrintFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormat with UUID " + AD_PrintFormat.getUUID());
			}
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
	public ForeignEntityInput AD_PrintFormat() {
		return mAD_PrintFormat;
	}
	/**
	 * Set Document Type.
	 *
	 * @param C_DocType_ID Document type or rules
	 */

	public void setC_DocType_ID(int C_DocType_ID) {
		if (get_ID() == 0) {
			super.setC_DocType_ID(C_DocType_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_DocType_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_DocType_UU();
	}

	/**
	 * Set Difference Document.
	 *
	 * @param C_DocTypeDifference Document type for generating in dispute Shipments
	 */
	@JsonProperty("C_DocTypeDifference")
	public void setC_DocTypeDifferenceInput(ForeignEntityInput C_DocTypeDifference) {
		this.mC_DocTypeDifference = C_DocTypeDifference;
		MDocType_BH foreignEntity;
		if (C_DocTypeDifference != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
							.setParameters(C_DocTypeDifference.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_DocTypeDifference_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DocType with UUID " + C_DocTypeDifference.getUUID());
			}
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
	public ForeignEntityInput C_DocTypeDifference() {
		return mC_DocTypeDifference;
	}

	/**
	 * Set Document Type for Invoice.
	 *
	 * @param C_DocTypeInvoice Document type used for invoices generated from this sales document
	 */
	@JsonProperty("C_DocTypeInvoice")
	public void setC_DocTypeInvoiceInput(ForeignEntityInput C_DocTypeInvoice) {
		this.mC_DocTypeInvoice = C_DocTypeInvoice;
		MDocType_BH foreignEntity;
		if (C_DocTypeInvoice != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
							.setParameters(C_DocTypeInvoice.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_DocTypeInvoice_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DocType with UUID " + C_DocTypeInvoice.getUUID());
			}
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
	public ForeignEntityInput C_DocTypeInvoice() {
		return mC_DocTypeInvoice;
	}

	/**
	 * Set Document Type for ProForma.
	 *
	 * @param C_DocTypeProforma Document type used for pro forma invoices generated from this sales document
	 */
	@JsonProperty("C_DocTypeProforma")
	public void setC_DocTypeProformaInput(ForeignEntityInput C_DocTypeProforma) {
		this.mC_DocTypeProforma = C_DocTypeProforma;
		MDocType_BH foreignEntity;
		if (C_DocTypeProforma != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
							.setParameters(C_DocTypeProforma.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_DocTypeProforma_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DocType with UUID " + C_DocTypeProforma.getUUID());
			}
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
	public ForeignEntityInput C_DocTypeProforma() {
		return mC_DocTypeProforma;
	}

	/**
	 * Set Document Type for Shipment.
	 *
	 * @param C_DocTypeShipment Document type used for shipments generated from this sales document
	 */
	@JsonProperty("C_DocTypeShipment")
	public void setC_DocTypeShipmentInput(ForeignEntityInput C_DocTypeShipment) {
		this.mC_DocTypeShipment = C_DocTypeShipment;
		MDocType_BH foreignEntity;
		if (C_DocTypeShipment != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
							.setParameters(C_DocTypeShipment.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_DocTypeShipment_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DocType with UUID " + C_DocTypeShipment.getUUID());
			}
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
	public ForeignEntityInput C_DocTypeShipment() {
		return mC_DocTypeShipment;
	}

	/**
	 * Set Definite Sequence.
	 *
	 * @param DefiniteSequence Definite Sequence
	 */
	@JsonProperty("DefiniteSequence")
	public void setDefiniteSequenceInput(ForeignEntityInput DefiniteSequence) {
		this.mDefiniteSequence = DefiniteSequence;
		MSequence_BH foreignEntity;
		if (DefiniteSequence != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Sequence", "AD_Sequence_UU=?", get_TrxName())
							.setParameters(DefiniteSequence.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDefiniteSequence_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Sequence with UUID " + DefiniteSequence.getUUID());
			}
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
	public ForeignEntityInput DefiniteSequence() {
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
		if (DocBaseType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocBaseType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDocBaseType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DocBaseType.getUUID());
			}
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
	public void setDocNoSequenceInput(ForeignEntityInput DocNoSequence) {
		this.mDocNoSequence = DocNoSequence;
		MSequence_BH foreignEntity;
		if (DocNoSequence != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Sequence", "AD_Sequence_UU=?", get_TrxName())
							.setParameters(DocNoSequence.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDocNoSequence_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Sequence with UUID " + DocNoSequence.getUUID());
			}
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
	public ForeignEntityInput DocNoSequence() {
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
		if (DocSubTypeInv != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocSubTypeInv.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDocSubTypeInv(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DocSubTypeInv.getUUID());
			}
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
		if (DocSubTypeSO != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocSubTypeSO.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDocSubTypeSO(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DocSubTypeSO.getUUID());
			}
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
	public void setGL_CategoryInput(ForeignEntityInput GL_Category) {
		this.mGL_Category = GL_Category;
		MGLCategory foreignEntity;
		if (GL_Category != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "GL_Category", "GL_Category_UU=?", get_TrxName())
							.setParameters(GL_Category.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setGL_Category_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table GL_Category with UUID " + GL_Category.getUUID());
			}
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
	public ForeignEntityInput GL_Category() {
		return mGL_Category;
	}
}
