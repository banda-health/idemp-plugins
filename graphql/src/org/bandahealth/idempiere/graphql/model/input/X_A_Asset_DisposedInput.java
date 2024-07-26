package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_A_Asset_DisposedResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetDisposed;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for A_Asset_Disposed - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_DisposedInput extends MAssetDisposed implements I_A_Asset_DisposedInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Activation_Method;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mA_Asset_Status;
	private ForeignEntityInput mA_Asset_Trade;
	private ForeignEntityInput mA_Disposed_Method;
	private ForeignEntityInput mA_Disposed_Reason;
	private ForeignEntityInput mC_DocType;
	private ForeignEntityInput mC_Invoice;
	private ForeignEntityInput mC_InvoiceLine;
	private ForeignEntityInput mC_Period;
	private ForeignEntityInput mDocAction;
	private ForeignEntityInput mDocStatus;
	private ForeignEntityInput mPostingType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The A_Asset_Disposed_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_Asset_DisposedInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Activation Method.
	 *
	 * @param A_Activation_Method Activation Method
	 */
	@JsonProperty("A_Activation_Method")
	public void setA_Activation_MethodInput(ForeignEntityInput A_Activation_Method) {
		this.mA_Activation_Method = A_Activation_Method;
		if (A_Activation_Method != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_A_Asset_DisposedResolver.A_ACTIVATION_METHOD_UUIDS_BY_VALUE.containsValue(A_Activation_Method.getUU())) {
				throw new AdempiereException("The reference list UU of " + A_Activation_Method.getUU() +
						" is not in the list defined for the A_Activation_Method column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Activation_Method.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Activation_Method(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + A_Activation_Method.getUU());
			}
		} else {
			this.setA_Activation_Method(null);
		}
	}

	/**
	 * Get Activation Method.
	 *
	 * @return Activation Method
	 */
	@JsonProperty("A_Activation_Method")
	public ForeignEntityInput A_Activation_Method() {
		return mA_Activation_Method;
	}
	/**
	 * Set Asset Disposed.
	 *
	 * @param A_Asset_Disposed_ID Asset Disposed
	 */
	@JsonProperty("A_Asset_Disposed_ID")
	public void setA_Asset_Disposed_IDFromJson(int A_Asset_Disposed_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Disposed_ID(A_Asset_Disposed_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setA_Asset_Disposed_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getA_Asset_Disposed_UU();
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public void setA_AssetInput(ForeignEntityInput A_Asset) {
		this.mA_Asset = A_Asset;
		if (A_Asset != null) {
			// Since an entity was passed, make sure it's in the DB
			MAsset foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
							.setParameters(A_Asset.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Asset_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset with UU " + A_Asset.getUU());
			}
		} else {
			this.setA_Asset_ID(0);
		}
	}

	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public ForeignEntityInput A_Asset() {
		return mA_Asset;
	}

	/**
	 * Set Asset Status.
	 *
	 * @param A_Asset_Status Asset Status
	 */
	@JsonProperty("A_Asset_Status")
	public void setA_Asset_StatusInput(ForeignEntityInput A_Asset_Status) {
		this.mA_Asset_Status = A_Asset_Status;
		if (A_Asset_Status != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_A_Asset_DisposedResolver.A_ASSET_STATUS_UUIDS_BY_VALUE.containsValue(A_Asset_Status.getUU())) {
				throw new AdempiereException("The reference list UU of " + A_Asset_Status.getUU() +
						" is not in the list defined for the A_Asset_Status column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Asset_Status.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Asset_Status(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + A_Asset_Status.getUU());
			}
		} else {
			this.setA_Asset_Status(null);
		}
	}

	/**
	 * Get Asset Status.
	 *
	 * @return Asset Status
	 */
	@JsonProperty("A_Asset_Status")
	public ForeignEntityInput A_Asset_Status() {
		return mA_Asset_Status;
	}

	/**
	 * Set Asset Trade.
	 *
	 * @param A_Asset_Trade Asset Trade
	 */
	@JsonProperty("A_Asset_Trade")
	public void setA_Asset_TradeInput(ForeignEntityInput A_Asset_Trade) {
		this.mA_Asset_Trade = A_Asset_Trade;
		if (A_Asset_Trade != null) {
			// Since an entity was passed, make sure it's in the DB
			MAsset foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
							.setParameters(A_Asset_Trade.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Asset_Trade_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset with UU " + A_Asset_Trade.getUU());
			}
		} else {
			this.setA_Asset_Trade_ID(0);
		}
	}

	/**
	 * Get Asset Trade.
	 *
	 * @return Asset Trade
	 */
	@JsonProperty("A_Asset_Trade")
	public ForeignEntityInput A_Asset_Trade() {
		return mA_Asset_Trade;
	}

	/**
	 * Set Disposed Method.
	 *
	 * @param A_Disposed_Method Disposed Method
	 */
	@JsonProperty("A_Disposed_Method")
	public void setA_Disposed_MethodInput(ForeignEntityInput A_Disposed_Method) {
		this.mA_Disposed_Method = A_Disposed_Method;
		if (A_Disposed_Method != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_A_Asset_DisposedResolver.A_DISPOSED_METHOD_UUIDS_BY_VALUE.containsValue(A_Disposed_Method.getUU())) {
				throw new AdempiereException("The reference list UU of " + A_Disposed_Method.getUU() +
						" is not in the list defined for the A_Disposed_Method column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Disposed_Method.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Disposed_Method(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + A_Disposed_Method.getUU());
			}
		} else {
			this.setA_Disposed_Method(null);
		}
	}

	/**
	 * Get Disposed Method.
	 *
	 * @return Disposed Method
	 */
	@JsonProperty("A_Disposed_Method")
	public ForeignEntityInput A_Disposed_Method() {
		return mA_Disposed_Method;
	}

	/**
	 * Set Disposed Reason.
	 *
	 * @param A_Disposed_Reason Disposed Reason
	 */
	@JsonProperty("A_Disposed_Reason")
	public void setA_Disposed_ReasonInput(ForeignEntityInput A_Disposed_Reason) {
		this.mA_Disposed_Reason = A_Disposed_Reason;
		if (A_Disposed_Reason != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_A_Asset_DisposedResolver.A_DISPOSED_REASON_UUIDS_BY_VALUE.containsValue(A_Disposed_Reason.getUU())) {
				throw new AdempiereException("The reference list UU of " + A_Disposed_Reason.getUU() +
						" is not in the list defined for the A_Disposed_Reason column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Disposed_Reason.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Disposed_Reason(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + A_Disposed_Reason.getUU());
			}
		} else {
			this.setA_Disposed_Reason(null);
		}
	}

	/**
	 * Get Disposed Reason.
	 *
	 * @return Disposed Reason
	 */
	@JsonProperty("A_Disposed_Reason")
	public ForeignEntityInput A_Disposed_Reason() {
		return mA_Disposed_Reason;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
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
	 * Set Document Type.
	 *
	 * @param C_DocType Document type or rules
	 */
	@JsonProperty("C_DocType")
	public void setC_DocTypeInput(ForeignEntityInput C_DocType) {
		this.mC_DocType = C_DocType;
		if (C_DocType != null) {
			// Since an entity was passed, make sure it's in the DB
			MDocType_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
							.setParameters(C_DocType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_DocType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DocType with UU " + C_DocType.getUU());
			}
		} else {
			this.setC_DocType_ID(0);
		}
	}

	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	@JsonProperty("C_DocType")
	public ForeignEntityInput C_DocType() {
		return mC_DocType;
	}

	/**
	 * Set Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public void setC_InvoiceInput(ForeignEntityInput C_Invoice) {
		this.mC_Invoice = C_Invoice;
		if (C_Invoice != null) {
			// Since an entity was passed, make sure it's in the DB
			MInvoice_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Invoice", "C_Invoice_UU=?", get_TrxName())
							.setParameters(C_Invoice.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Invoice_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Invoice with UU " + C_Invoice.getUU());
			}
		} else {
			this.setC_Invoice_ID(0);
		}
	}

	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public ForeignEntityInput C_Invoice() {
		return mC_Invoice;
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
			MInvoiceLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_InvoiceLine", "C_InvoiceLine_UU=?", get_TrxName())
							.setParameters(C_InvoiceLine.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_InvoiceLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_InvoiceLine with UU " + C_InvoiceLine.getUU());
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
	 * Set Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	@JsonProperty("C_Period")
	public void setC_PeriodInput(ForeignEntityInput C_Period) {
		this.mC_Period = C_Period;
		if (C_Period != null) {
			// Since an entity was passed, make sure it's in the DB
			MPeriod foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Period", "C_Period_UU=?", get_TrxName())
							.setParameters(C_Period.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Period_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Period with UU " + C_Period.getUU());
			}
		} else {
			this.setC_Period_ID(0);
		}
	}

	/**
	 * Get Period.
	 *
	 * @return Period of the Calendar
	 */
	@JsonProperty("C_Period")
	public ForeignEntityInput C_Period() {
		return mC_Period;
	}

	/**
	 * Set Document Action.
	 *
	 * @param DocAction The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public void setDocActionInput(ForeignEntityInput DocAction) {
		this.mDocAction = DocAction;
		if (DocAction != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_A_Asset_DisposedResolver.DOCACTION_UUIDS_BY_VALUE.containsValue(DocAction.getUU())) {
				throw new AdempiereException("The reference list UU of " + DocAction.getUU() +
						" is not in the list defined for the DocAction column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocAction.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDocAction(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DocAction.getUU());
			}
		} else {
			this.setDocAction(null);
		}
	}

	/**
	 * Get Document Action.
	 *
	 * @return The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public ForeignEntityInput DocAction() {
		return mDocAction;
	}

	/**
	 * Set Document Status.
	 *
	 * @param DocStatus The current status of the document
	 */
	@JsonProperty("DocStatus")
	public void setDocStatusInput(ForeignEntityInput DocStatus) {
		this.mDocStatus = DocStatus;
		if (DocStatus != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_A_Asset_DisposedResolver.DOCSTATUS_UUIDS_BY_VALUE.containsValue(DocStatus.getUU())) {
				throw new AdempiereException("The reference list UU of " + DocStatus.getUU() +
						" is not in the list defined for the DocStatus column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocStatus.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDocStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DocStatus.getUU());
			}
		} else {
			this.setDocStatus(null);
		}
	}

	/**
	 * Get Document Status.
	 *
	 * @return The current status of the document
	 */
	@JsonProperty("DocStatus")
	public ForeignEntityInput DocStatus() {
		return mDocStatus;
	}
	/**
	 * Set Document No.
	 *
	 * @param DocumentNo Document sequence number of the document
	 */
	@JsonProperty("DocumentNo")
	public void setDocumentNoFromJson(String DocumentNo) {
		if (get_ID() == 0) {
			super.setDocumentNo(DocumentNo);
		}
	}
	/**
	 * Set Posted.
	 *
	 * @param Posted Posting status
	 */
	@JsonProperty("Posted")
	public void setPostedFromJson(boolean Posted) {
		if (get_ID() == 0) {
			super.setPosted(Posted);
		}
	}

	/**
	 * Set Posting Type.
	 *
	 * @param PostingType The type of posted amount for the transaction
	 */
	@JsonProperty("PostingType")
	public void setPostingTypeInput(ForeignEntityInput PostingType) {
		this.mPostingType = PostingType;
		if (PostingType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_A_Asset_DisposedResolver.POSTINGTYPE_UUIDS_BY_VALUE.containsValue(PostingType.getUU())) {
				throw new AdempiereException("The reference list UU of " + PostingType.getUU() +
						" is not in the list defined for the PostingType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PostingType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPostingType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + PostingType.getUU());
			}
		} else {
			this.setPostingType(null);
		}
	}

	/**
	 * Get Posting Type.
	 *
	 * @return The type of posted amount for the transaction
	 */
	@JsonProperty("PostingType")
	public ForeignEntityInput PostingType() {
		return mPostingType;
	}
}
