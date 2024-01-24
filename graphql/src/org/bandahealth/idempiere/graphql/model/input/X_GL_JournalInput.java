package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MConversionType;
import org.compiere.model.MGLCategory;
import org.compiere.model.MJournal;
import org.compiere.model.MJournalBatch;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
import org.compiere.model.Query;
import org.compiere.model.X_GL_Budget;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for GL_Journal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_GL_JournalInput extends MJournal implements I_GL_JournalInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_ConversionType;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_DocType;
	private ForeignEntityInput mC_Period;
	private ForeignEntityInput mGL_Budget;
	private ForeignEntityInput mGL_Category;
	private ForeignEntityInput mGL_JournalBatch;
	private ForeignEntityInput mReversal;
	private I_AD_Ref_ListInput mDocAction;
	private I_AD_Ref_ListInput mDocStatus;
	private I_AD_Ref_ListInput mPostingType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The GL_Journal_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_GL_JournalInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MJournal(null, (ResultSet) null, null),
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		MAcctSchema foreignEntity;
		if (get_ID() == 0 && C_AcctSchema != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
							.setParameters(C_AcctSchema.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_AcctSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AcctSchema with UUID " + C_AcctSchema.getUUID());
			}
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public ForeignEntityInput C_AcctSchema() {
		return mC_AcctSchema;
	}

	/**
	 * Set Currency Type.
	 *
	 * @param C_ConversionType Currency Conversion Rate Type
	 */
	@JsonProperty("C_ConversionType")
	public void setC_ConversionTypeInput(ForeignEntityInput C_ConversionType) {
		this.mC_ConversionType = C_ConversionType;
		MConversionType foreignEntity;
		if (C_ConversionType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_ConversionType", "C_ConversionType_UU=?", get_TrxName())
							.setParameters(C_ConversionType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_ConversionType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ConversionType with UUID " + C_ConversionType.getUUID());
			}
		} else {
			super.setC_ConversionType_ID(0);
		}
	}

	/**
	 * Get Currency Type.
	 *
	 * @return Currency Conversion Rate Type
	 */
	@JsonProperty("C_ConversionType")
	public ForeignEntityInput C_ConversionType() {
		return mC_ConversionType;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(ForeignEntityInput C_Currency) {
		this.mC_Currency = C_Currency;
		MCurrency_BH foreignEntity;
		if (C_Currency != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(C_Currency.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UUID " + C_Currency.getUUID());
			}
		} else {
			super.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public ForeignEntityInput C_Currency() {
		return mC_Currency;
	}

	/**
	 * Set Document Type.
	 *
	 * @param C_DocType Document type or rules
	 */
	@JsonProperty("C_DocType")
	public void setC_DocTypeInput(ForeignEntityInput C_DocType) {
		this.mC_DocType = C_DocType;
		MDocType_BH foreignEntity;
		if (C_DocType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
							.setParameters(C_DocType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_DocType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DocType with UUID " + C_DocType.getUUID());
			}
		} else {
			super.setC_DocType_ID(0);
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
	 * Set Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	@JsonProperty("C_Period")
	public void setC_PeriodInput(ForeignEntityInput C_Period) {
		this.mC_Period = C_Period;
		MPeriod foreignEntity;
		if (C_Period != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Period", "C_Period_UU=?", get_TrxName())
							.setParameters(C_Period.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Period_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Period with UUID " + C_Period.getUUID());
			}
		} else {
			super.setC_Period_ID(0);
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
	public void setDocActionInput(I_AD_Ref_ListInput DocAction) {
		this.mDocAction = DocAction;
		MRefList_BH foreignEntity;
		if (DocAction != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocAction.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDocAction(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DocAction.getUUID());
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
	public I_AD_Ref_ListInput DocAction() {
		return mDocAction;
	}

	/**
	 * Set Document Status.
	 *
	 * @param DocStatus The current status of the document
	 */
	@JsonProperty("DocStatus")
	public void setDocStatusInput(I_AD_Ref_ListInput DocStatus) {
		this.mDocStatus = DocStatus;
		MRefList_BH foreignEntity;
		if (DocStatus != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocStatus.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDocStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DocStatus.getUUID());
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
	public I_AD_Ref_ListInput DocStatus() {
		return mDocStatus;
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
	 * Set Budget.
	 *
	 * @param GL_Budget General Ledger Budget
	 */
	@JsonProperty("GL_Budget")
	public void setGL_BudgetInput(ForeignEntityInput GL_Budget) {
		this.mGL_Budget = GL_Budget;
		X_GL_Budget foreignEntity;
		if (GL_Budget != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "GL_Budget", "GL_Budget_UU=?", get_TrxName())
							.setParameters(GL_Budget.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setGL_Budget_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table GL_Budget with UUID " + GL_Budget.getUUID());
			}
		} else {
			super.setGL_Budget_ID(0);
		}
	}

	/**
	 * Get Budget.
	 *
	 * @return General Ledger Budget
	 */
	@JsonProperty("GL_Budget")
	public ForeignEntityInput GL_Budget() {
		return mGL_Budget;
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
	/**
	 * Set Journal.
	 *
	 * @param GL_Journal_ID General Ledger Journal
	 */

	public void setGL_Journal_ID(int GL_Journal_ID) {
		if (get_ID() == 0) {
			super.setGL_Journal_ID(GL_Journal_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setGL_Journal_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getGL_Journal_UU();
	}

	/**
	 * Set Journal Batch.
	 *
	 * @param GL_JournalBatch General Ledger Journal Batch
	 */
	@JsonProperty("GL_JournalBatch")
	public void setGL_JournalBatchInput(ForeignEntityInput GL_JournalBatch) {
		this.mGL_JournalBatch = GL_JournalBatch;
		MJournalBatch foreignEntity;
		if (get_ID() == 0 && GL_JournalBatch != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "GL_JournalBatch", "GL_JournalBatch_UU=?", get_TrxName())
							.setParameters(GL_JournalBatch.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setGL_JournalBatch_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table GL_JournalBatch with UUID " + GL_JournalBatch.getUUID());
			}
		}
	}

	/**
	 * Get Journal Batch.
	 *
	 * @return General Ledger Journal Batch
	 */
	@JsonProperty("GL_JournalBatch")
	public ForeignEntityInput GL_JournalBatch() {
		return mGL_JournalBatch;
	}
	/**
	 * Set Approved.
	 *
	 * @param IsApproved Indicates if this document requires approval
	 */

	public void setIsApproved(boolean IsApproved) {
		if (get_ID() == 0) {
			super.setIsApproved(IsApproved);
		}
	}
	/**
	 * Set Printed.
	 *
	 * @param IsPrinted Indicates if this document / line is printed
	 */

	public void setIsPrinted(boolean IsPrinted) {
		if (get_ID() == 0) {
			super.setIsPrinted(IsPrinted);
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
	 * @param PostingType The type of posted amount for the transaction
	 */
	@JsonProperty("PostingType")
	public void setPostingTypeInput(I_AD_Ref_ListInput PostingType) {
		this.mPostingType = PostingType;
		MRefList_BH foreignEntity;
		if (PostingType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PostingType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPostingType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + PostingType.getUUID());
			}
		} else {
			this.setPostingType(null);
		}
	}

	/**
	 * Get PostingType.
	 *
	 * @return The type of posted amount for the transaction
	 */
	@JsonProperty("PostingType")
	public I_AD_Ref_ListInput PostingType() {
		return mPostingType;
	}

	/**
	 * Set Reversal ID.
	 *
	 * @param Reversal ID of document reversal
	 */
	@JsonProperty("Reversal")
	public void setReversalInput(ForeignEntityInput Reversal) {
		this.mReversal = Reversal;
		MJournal foreignEntity;
		if (Reversal != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "GL_Journal", "GL_Journal_UU=?", get_TrxName())
							.setParameters(Reversal.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setReversal_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table GL_Journal with UUID " + Reversal.getUUID());
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
	/**
	 * Set Total Credit.
	 *
	 * @param TotalCr Total Credit in document currency
	 */

	public void setTotalCr(BigDecimal TotalCr) {
		if (get_ID() == 0) {
			super.setTotalCr(TotalCr);
		}
	}
	/**
	 * Set Total Debit.
	 *
	 * @param TotalDr Total debit in document currency
	 */

	public void setTotalDr(BigDecimal TotalDr) {
		if (get_ID() == 0) {
			super.setTotalDr(TotalDr);
		}
	}
}
