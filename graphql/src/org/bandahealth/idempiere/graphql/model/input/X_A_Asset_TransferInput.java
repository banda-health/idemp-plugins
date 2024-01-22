package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetTransfer;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
import org.compiere.model.Query;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for A_Asset_Transfer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_TransferInput extends MAssetTransfer implements I_A_Asset_TransferInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Accumdepreciation_A;
	private ForeignEntityInput mA_Accumdepreciation_New_A;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mA_Asset_A;
	private ForeignEntityInput mA_Asset_New_A;
	private ForeignEntityInput mA_Depreciation_A;
	private ForeignEntityInput mA_Depreciation_New_A;
	private ForeignEntityInput mA_Disposal_Loss_A;
	private ForeignEntityInput mA_Disposal_Loss_New_A;
	private ForeignEntityInput mA_Disposal_Revenue_A;
	private ForeignEntityInput mA_Disposal_Revenue_New_A;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_Period;
	private I_AD_Ref_ListInput mA_CapvsExp;
	private I_AD_Ref_ListInput mDocAction;
	private I_AD_Ref_ListInput mDocStatus;
	private I_AD_Ref_ListInput mPostingType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_A_Asset_TransferInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MAssetTransfer(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Accumulated Depreciation Account.
	 *
	 * @param A_Accumdepreciation_A Accumulated Depreciation Account
	 */
	@JsonProperty("A_Accumdepreciation_A")
	public void setA_Accumdepreciation_AInput(ForeignEntityInput A_Accumdepreciation_A) {
		this.mA_Accumdepreciation_A = A_Accumdepreciation_A;
		MAccount foreignEntity;
		if (get_ID() == 0 && A_Accumdepreciation_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(A_Accumdepreciation_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Accumdepreciation_Acct(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Accumulated Depreciation Account.
	 *
	 * @return Accumulated Depreciation Account
	 */
	@JsonProperty("A_Accumdepreciation_A")
	public ForeignEntityInput A_Accumdepreciation_A() {
		return mA_Accumdepreciation_A;
	}
	/**
	 * Set Old Asset Cost Acct.
	 *
	 * @param A_Accumdepreciation_Acct_Str Old Asset Cost Acct
	 */

	public void setA_Accumdepreciation_Acct_Str(String A_Accumdepreciation_Acct_Str) {
		if (get_ID() == 0) {
			super.setA_Accumdepreciation_Acct_Str(A_Accumdepreciation_Acct_Str);
		}
	}

	/**
	 * Set Accumulated Depreciation Account (new).
	 *
	 * @param A_Accumdepreciation_New_A Accumulated Depreciation Account (new)
	 */
	@JsonProperty("A_Accumdepreciation_New_A")
	public void setA_Accumdepreciation_New_AInput(ForeignEntityInput A_Accumdepreciation_New_A) {
		this.mA_Accumdepreciation_New_A = A_Accumdepreciation_New_A;
		MAccount foreignEntity;
		if (A_Accumdepreciation_New_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(A_Accumdepreciation_New_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Accumdepreciation_New_Acct(foreignEntity.get_ID());
		} else {
			super.setA_Accumdepreciation_New_Acct(0);
		}
	}

	/**
	 * Get Accumulated Depreciation Account (new).
	 *
	 * @return Accumulated Depreciation Account (new)
	 */
	@JsonProperty("A_Accumdepreciation_New_A")
	public ForeignEntityInput A_Accumdepreciation_New_A() {
		return mA_Accumdepreciation_New_A;
	}

	/**
	 * Set Asset Acct.
	 *
	 * @param A_Asset_A Asset Acct
	 */
	@JsonProperty("A_Asset_A")
	public void setA_Asset_AInput(ForeignEntityInput A_Asset_A) {
		this.mA_Asset_A = A_Asset_A;
		MAccount foreignEntity;
		if (get_ID() == 0 && A_Asset_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(A_Asset_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_Acct(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Asset Acct.
	 *
	 * @return Asset Acct
	 */
	@JsonProperty("A_Asset_A")
	public ForeignEntityInput A_Asset_A() {
		return mA_Asset_A;
	}
	/**
	 * Set A_Asset_Acct_Str.
	 *
	 * @param A_Asset_Acct_Str A_Asset_Acct_Str
	 */

	public void setA_Asset_Acct_Str(String A_Asset_Acct_Str) {
		if (get_ID() == 0) {
			super.setA_Asset_Acct_Str(A_Asset_Acct_Str);
		}
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public void setA_AssetInput(ForeignEntityInput A_Asset) {
		this.mA_Asset = A_Asset;
		MAsset foreignEntity;
		if (get_ID() == 0 && A_Asset != null &&
				(foreignEntity = new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
						.setParameters(A_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_ID(foreignEntity.get_ID());
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
	 * Set Asset Acct (new).
	 *
	 * @param A_Asset_New_A Asset Acct (new)
	 */
	@JsonProperty("A_Asset_New_A")
	public void setA_Asset_New_AInput(ForeignEntityInput A_Asset_New_A) {
		this.mA_Asset_New_A = A_Asset_New_A;
		MAccount foreignEntity;
		if (A_Asset_New_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(A_Asset_New_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_New_Acct(foreignEntity.get_ID());
		} else {
			super.setA_Asset_New_Acct(0);
		}
	}

	/**
	 * Get Asset Acct (new).
	 *
	 * @return Asset Acct (new)
	 */
	@JsonProperty("A_Asset_New_A")
	public ForeignEntityInput A_Asset_New_A() {
		return mA_Asset_New_A;
	}
	/**
	 * Set A_Asset_Transfer_ID.
	 *
	 * @param A_Asset_Transfer_ID A_Asset_Transfer_ID
	 */

	public void setA_Asset_Transfer_ID(int A_Asset_Transfer_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Transfer_ID(A_Asset_Transfer_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Asset_Transfer_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Asset_Transfer_UU();
	}

	/**
	 * Set Capital/Expense.
	 *
	 * @param A_CapvsExp Capital/Expense
	 */
	@JsonProperty("A_CapvsExp")
	public void setA_CapvsExpInput(I_AD_Ref_ListInput A_CapvsExp) {
		this.mA_CapvsExp = A_CapvsExp;
		MRefList_BH foreignEntity;
		if (A_CapvsExp != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_CapvsExp.getID())
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
	@JsonProperty("A_CapvsExp")
	public I_AD_Ref_ListInput A_CapvsExp() {
		return mA_CapvsExp;
	}

	/**
	 * Set Depreciation Account.
	 *
	 * @param A_Depreciation_A Depreciation Account
	 */
	@JsonProperty("A_Depreciation_A")
	public void setA_Depreciation_AInput(ForeignEntityInput A_Depreciation_A) {
		this.mA_Depreciation_A = A_Depreciation_A;
		MAccount foreignEntity;
		if (get_ID() == 0 && A_Depreciation_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(A_Depreciation_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Depreciation_Acct(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Depreciation Account.
	 *
	 * @return Depreciation Account
	 */
	@JsonProperty("A_Depreciation_A")
	public ForeignEntityInput A_Depreciation_A() {
		return mA_Depreciation_A;
	}
	/**
	 * Set A_Depreciation_Acct_Str.
	 *
	 * @param A_Depreciation_Acct_Str A_Depreciation_Acct_Str
	 */

	public void setA_Depreciation_Acct_Str(String A_Depreciation_Acct_Str) {
		if (get_ID() == 0) {
			super.setA_Depreciation_Acct_Str(A_Depreciation_Acct_Str);
		}
	}

	/**
	 * Set Depreciation Acct (new).
	 *
	 * @param A_Depreciation_New_A Depreciation Acct (new)
	 */
	@JsonProperty("A_Depreciation_New_A")
	public void setA_Depreciation_New_AInput(ForeignEntityInput A_Depreciation_New_A) {
		this.mA_Depreciation_New_A = A_Depreciation_New_A;
		MAccount foreignEntity;
		if (A_Depreciation_New_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(A_Depreciation_New_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Depreciation_New_Acct(foreignEntity.get_ID());
		} else {
			super.setA_Depreciation_New_Acct(0);
		}
	}

	/**
	 * Get Depreciation Acct (new).
	 *
	 * @return Depreciation Acct (new)
	 */
	@JsonProperty("A_Depreciation_New_A")
	public ForeignEntityInput A_Depreciation_New_A() {
		return mA_Depreciation_New_A;
	}

	/**
	 * Set Disposal Loss Acct.
	 *
	 * @param A_Disposal_Loss_A Disposal Loss Acct
	 */
	@JsonProperty("A_Disposal_Loss_A")
	public void setA_Disposal_Loss_AInput(ForeignEntityInput A_Disposal_Loss_A) {
		this.mA_Disposal_Loss_A = A_Disposal_Loss_A;
		MAccount foreignEntity;
		if (get_ID() == 0 && A_Disposal_Loss_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(A_Disposal_Loss_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Disposal_Loss_Acct(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Disposal Loss Acct.
	 *
	 * @return Disposal Loss Acct
	 */
	@JsonProperty("A_Disposal_Loss_A")
	public ForeignEntityInput A_Disposal_Loss_A() {
		return mA_Disposal_Loss_A;
	}

	/**
	 * Set Disposal Loss Acct (new).
	 *
	 * @param A_Disposal_Loss_New_A Disposal Loss Acct (new)
	 */
	@JsonProperty("A_Disposal_Loss_New_A")
	public void setA_Disposal_Loss_New_AInput(ForeignEntityInput A_Disposal_Loss_New_A) {
		this.mA_Disposal_Loss_New_A = A_Disposal_Loss_New_A;
		MAccount foreignEntity;
		if (A_Disposal_Loss_New_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(A_Disposal_Loss_New_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Disposal_Loss_New_Acct(foreignEntity.get_ID());
		} else {
			super.setA_Disposal_Loss_New_Acct(0);
		}
	}

	/**
	 * Get Disposal Loss Acct (new).
	 *
	 * @return Disposal Loss Acct (new)
	 */
	@JsonProperty("A_Disposal_Loss_New_A")
	public ForeignEntityInput A_Disposal_Loss_New_A() {
		return mA_Disposal_Loss_New_A;
	}
	/**
	 * Set Disposal Loss Str.
	 *
	 * @param A_Disposal_Loss_Str Disposal Loss Str
	 */

	public void setA_Disposal_Loss_Str(String A_Disposal_Loss_Str) {
		if (get_ID() == 0) {
			super.setA_Disposal_Loss_Str(A_Disposal_Loss_Str);
		}
	}

	/**
	 * Set Disposal Revenue Acct.
	 *
	 * @param A_Disposal_Revenue_A Disposal Revenue Acct
	 */
	@JsonProperty("A_Disposal_Revenue_A")
	public void setA_Disposal_Revenue_AInput(ForeignEntityInput A_Disposal_Revenue_A) {
		this.mA_Disposal_Revenue_A = A_Disposal_Revenue_A;
		MAccount foreignEntity;
		if (get_ID() == 0 && A_Disposal_Revenue_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(A_Disposal_Revenue_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Disposal_Revenue_Acct(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Disposal Revenue Acct.
	 *
	 * @return Disposal Revenue Acct
	 */
	@JsonProperty("A_Disposal_Revenue_A")
	public ForeignEntityInput A_Disposal_Revenue_A() {
		return mA_Disposal_Revenue_A;
	}

	/**
	 * Set Disposal Revenue Acct (new).
	 *
	 * @param A_Disposal_Revenue_New_A Disposal Revenue Acct (new)
	 */
	@JsonProperty("A_Disposal_Revenue_New_A")
	public void setA_Disposal_Revenue_New_AInput(ForeignEntityInput A_Disposal_Revenue_New_A) {
		this.mA_Disposal_Revenue_New_A = A_Disposal_Revenue_New_A;
		MAccount foreignEntity;
		if (A_Disposal_Revenue_New_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(A_Disposal_Revenue_New_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Disposal_Revenue_New_Acct(foreignEntity.get_ID());
		} else {
			super.setA_Disposal_Revenue_New_Acct(0);
		}
	}

	/**
	 * Get Disposal Revenue Acct (new).
	 *
	 * @return Disposal Revenue Acct (new)
	 */
	@JsonProperty("A_Disposal_Revenue_New_A")
	public ForeignEntityInput A_Disposal_Revenue_New_A() {
		return mA_Disposal_Revenue_New_A;
	}
	/**
	 * Set Disposal Revenue Str.
	 *
	 * @param A_Disposal_Revenue_Str Disposal Revenue Str
	 */

	public void setA_Disposal_Revenue_Str(String A_Disposal_Revenue_Str) {
		if (get_ID() == 0) {
			super.setA_Disposal_Revenue_Str(A_Disposal_Revenue_Str);
		}
	}
	/**
	 * Set A_Period_End.
	 *
	 * @param A_Period_End A_Period_End
	 */

	public void setA_Period_End(int A_Period_End) {
		if (get_ID() == 0) {
			super.setA_Period_End(A_Period_End);
		}
	}
	/**
	 * Set A_Period_Start.
	 *
	 * @param A_Period_Start A_Period_Start
	 */

	public void setA_Period_Start(int A_Period_Start) {
		if (get_ID() == 0) {
			super.setA_Period_Start(A_Period_Start);
		}
	}
	/**
	 * Set Split Percent.
	 *
	 * @param A_Split_Percent Split Percent
	 */

	public void setA_Split_Percent(BigDecimal A_Split_Percent) {
		if (get_ID() == 0) {
			super.setA_Split_Percent(A_Split_Percent);
		}
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
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
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
		if (get_ID() == 0 && C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
						.setParameters(C_AcctSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_AcctSchema_ID(foreignEntity.get_ID());
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
	 * Set Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	@JsonProperty("C_Period")
	public void setC_PeriodInput(ForeignEntityInput C_Period) {
		this.mC_Period = C_Period;
		MPeriod foreignEntity;
		if (C_Period != null &&
				(foreignEntity = new Query(getCtx(), "C_Period", "C_Period_UU=?", get_TrxName())
						.setParameters(C_Period.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Period_ID(foreignEntity.get_ID());
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
		if (DocAction != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocAction.getID())
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
		if (DocStatus != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocStatus.getID())
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
	@JsonProperty("DocStatus")
	public I_AD_Ref_ListInput DocStatus() {
		return mDocStatus;
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
		if (PostingType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PostingType.getID())
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
	@JsonProperty("PostingType")
	public I_AD_Ref_ListInput PostingType() {
		return mPostingType;
	}
}
