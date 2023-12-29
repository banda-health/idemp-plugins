package org.bandahealth.idempiere.graphql.model.input;

import java.math.BigDecimal;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAsset;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_A_Asset_Transfer;
import org.compiere.util.Env;

/**
 * Generated Model for A_Asset_Transfer - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_TransferInput extends X_A_Asset_Transfer implements I_A_Asset_TransferInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput A_CapvsExp_RL;
	 private I_AD_Ref_ListInput DocAction_RL;
	 private I_AD_Ref_ListInput DocStatus_RL;
	 private I_AD_Ref_ListInput PostingType_RL;
	 private I_A_AssetInput A_Asset;
	 private I_C_AcctSchemaInput C_AcctSchema;
	 private I_C_PeriodInput C_Period;
	 private I_C_ValidCombinationInput A_Accumdepreciation_A;
	 private I_C_ValidCombinationInput A_Accumdepreciation_New_A;
	 private I_C_ValidCombinationInput A_Asset_A;
	 private I_C_ValidCombinationInput A_Asset_New_A;
	 private I_C_ValidCombinationInput A_Depreciation_A;
	 private I_C_ValidCombinationInput A_Depreciation_New_A;
	 private I_C_ValidCombinationInput A_Disposal_Loss_A;
	 private I_C_ValidCombinationInput A_Disposal_Loss_New_A;
	 private I_C_ValidCombinationInput A_Disposal_Revenue_A;
	 private I_C_ValidCombinationInput A_Disposal_Revenue_New_A;

	/**
	 * Standard constructor
	 */
	public X_A_Asset_TransferInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Accumulated Depreciation Account.
	 *
	 * @param A_Accumdepreciation_A Accumulated Depreciation Account
	 */
	public void setA_Accumdepreciation_A(I_C_ValidCombinationInput A_Accumdepreciation_A) {
		this.A_Accumdepreciation_A = A_Accumdepreciation_A;
		MAccount foreignEntity;
		if (get_ID() == 0 &&A_Accumdepreciation_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Accumdepreciation_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Accumdepreciation_Acct(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Accumulated Depreciation Account.
	 *
	 * @return Accumulated Depreciation Account
	 */
	public I_C_ValidCombinationInput getA_Accumdepreciation_A() {
		return A_Accumdepreciation_A;
	}
	/**
	 * Set Accumulated Depreciation Account.
	 *
	 * @param A_Accumdepreciation_Acct Accumulated Depreciation Account
	 */

	public void setA_Accumdepreciation_Acct(int A_Accumdepreciation_Acct) {
		if (get_ID() == 0) {
			super.setA_Accumdepreciation_Acct(A_Accumdepreciation_Acct);
		}
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
	public void setA_Accumdepreciation_New_A(I_C_ValidCombinationInput A_Accumdepreciation_New_A) {
		this.A_Accumdepreciation_New_A = A_Accumdepreciation_New_A;
		MAccount foreignEntity;
		if (A_Accumdepreciation_New_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Accumdepreciation_New_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Accumdepreciation_New_Acct(foreignEntity.get_ID());
		} else {
			this.setA_Accumdepreciation_New_Acct(0);
		}
	}

	/**
	 * Get Accumulated Depreciation Account (new).
	 *
	 * @return Accumulated Depreciation Account (new)
	 */
	public I_C_ValidCombinationInput getA_Accumdepreciation_New_A() {
		return A_Accumdepreciation_New_A;
	}

	/**
	 * Set Asset Acct.
	 *
	 * @param A_Asset_A Asset Acct
	 */
	public void setA_Asset_A(I_C_ValidCombinationInput A_Asset_A) {
		this.A_Asset_A = A_Asset_A;
		MAccount foreignEntity;
		if (get_ID() == 0 &&A_Asset_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Asset_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_Acct(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Asset Acct.
	 *
	 * @return Asset Acct
	 */
	public I_C_ValidCombinationInput getA_Asset_A() {
		return A_Asset_A;
	}
	/**
	 * Set Asset Acct.
	 *
	 * @param A_Asset_Acct Asset Acct
	 */

	public void setA_Asset_Acct(int A_Asset_Acct) {
		if (get_ID() == 0) {
			super.setA_Asset_Acct(A_Asset_Acct);
		}
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
	public void setA_Asset(I_A_AssetInput A_Asset) {
		this.A_Asset = A_Asset;
		MAsset foreignEntity;
		if (get_ID() == 0 &&A_Asset != null &&
				(foreignEntity = new Query(getCtx(), MAsset.Table_Name, MAsset.COLUMNNAME_A_Asset_UU + "=?", get_TrxName())
						.setParameters(A_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_ID(foreignEntity.get_ID());
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
	 * Set Asset.
	 *
	 * @param A_Asset_ID Asset used internally or by customers
	 */

	public void setA_Asset_ID(int A_Asset_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_ID(A_Asset_ID);
		}
	}

	/**
	 * Set Asset Acct (new).
	 *
	 * @param A_Asset_New_A Asset Acct (new)
	 */
	public void setA_Asset_New_A(I_C_ValidCombinationInput A_Asset_New_A) {
		this.A_Asset_New_A = A_Asset_New_A;
		MAccount foreignEntity;
		if (A_Asset_New_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Asset_New_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_New_Acct(foreignEntity.get_ID());
		} else {
			this.setA_Asset_New_Acct(0);
		}
	}

	/**
	 * Get Asset Acct (new).
	 *
	 * @return Asset Acct (new)
	 */
	public I_C_ValidCombinationInput getA_Asset_New_A() {
		return A_Asset_New_A;
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
	 * Set Depreciation Account.
	 *
	 * @param A_Depreciation_A Depreciation Account
	 */
	public void setA_Depreciation_A(I_C_ValidCombinationInput A_Depreciation_A) {
		this.A_Depreciation_A = A_Depreciation_A;
		MAccount foreignEntity;
		if (get_ID() == 0 &&A_Depreciation_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Depreciation_Acct(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Depreciation Account.
	 *
	 * @return Depreciation Account
	 */
	public I_C_ValidCombinationInput getA_Depreciation_A() {
		return A_Depreciation_A;
	}
	/**
	 * Set Depreciation Account.
	 *
	 * @param A_Depreciation_Acct Depreciation Account
	 */

	public void setA_Depreciation_Acct(int A_Depreciation_Acct) {
		if (get_ID() == 0) {
			super.setA_Depreciation_Acct(A_Depreciation_Acct);
		}
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
	public void setA_Depreciation_New_A(I_C_ValidCombinationInput A_Depreciation_New_A) {
		this.A_Depreciation_New_A = A_Depreciation_New_A;
		MAccount foreignEntity;
		if (A_Depreciation_New_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_New_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Depreciation_New_Acct(foreignEntity.get_ID());
		} else {
			this.setA_Depreciation_New_Acct(0);
		}
	}

	/**
	 * Get Depreciation Acct (new).
	 *
	 * @return Depreciation Acct (new)
	 */
	public I_C_ValidCombinationInput getA_Depreciation_New_A() {
		return A_Depreciation_New_A;
	}

	/**
	 * Set Disposal Loss Acct.
	 *
	 * @param A_Disposal_Loss_A Disposal Loss Acct
	 */
	public void setA_Disposal_Loss_A(I_C_ValidCombinationInput A_Disposal_Loss_A) {
		this.A_Disposal_Loss_A = A_Disposal_Loss_A;
		MAccount foreignEntity;
		if (get_ID() == 0 &&A_Disposal_Loss_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Disposal_Loss_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Disposal_Loss_Acct(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Disposal Loss Acct.
	 *
	 * @return Disposal Loss Acct
	 */
	public I_C_ValidCombinationInput getA_Disposal_Loss_A() {
		return A_Disposal_Loss_A;
	}
	/**
	 * Set Disposal Loss Acct.
	 *
	 * @param A_Disposal_Loss_Acct Disposal Loss Acct
	 */

	public void setA_Disposal_Loss_Acct(int A_Disposal_Loss_Acct) {
		if (get_ID() == 0) {
			super.setA_Disposal_Loss_Acct(A_Disposal_Loss_Acct);
		}
	}

	/**
	 * Set Disposal Loss Acct (new).
	 *
	 * @param A_Disposal_Loss_New_A Disposal Loss Acct (new)
	 */
	public void setA_Disposal_Loss_New_A(I_C_ValidCombinationInput A_Disposal_Loss_New_A) {
		this.A_Disposal_Loss_New_A = A_Disposal_Loss_New_A;
		MAccount foreignEntity;
		if (A_Disposal_Loss_New_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Disposal_Loss_New_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Disposal_Loss_New_Acct(foreignEntity.get_ID());
		} else {
			this.setA_Disposal_Loss_New_Acct(0);
		}
	}

	/**
	 * Get Disposal Loss Acct (new).
	 *
	 * @return Disposal Loss Acct (new)
	 */
	public I_C_ValidCombinationInput getA_Disposal_Loss_New_A() {
		return A_Disposal_Loss_New_A;
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
	public void setA_Disposal_Revenue_A(I_C_ValidCombinationInput A_Disposal_Revenue_A) {
		this.A_Disposal_Revenue_A = A_Disposal_Revenue_A;
		MAccount foreignEntity;
		if (get_ID() == 0 &&A_Disposal_Revenue_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Disposal_Revenue_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Disposal_Revenue_Acct(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Disposal Revenue Acct.
	 *
	 * @return Disposal Revenue Acct
	 */
	public I_C_ValidCombinationInput getA_Disposal_Revenue_A() {
		return A_Disposal_Revenue_A;
	}
	/**
	 * Set Disposal Revenue Acct.
	 *
	 * @param A_Disposal_Revenue_Acct Disposal Revenue Acct
	 */

	public void setA_Disposal_Revenue_Acct(int A_Disposal_Revenue_Acct) {
		if (get_ID() == 0) {
			super.setA_Disposal_Revenue_Acct(A_Disposal_Revenue_Acct);
		}
	}

	/**
	 * Set Disposal Revenue Acct (new).
	 *
	 * @param A_Disposal_Revenue_New_A Disposal Revenue Acct (new)
	 */
	public void setA_Disposal_Revenue_New_A(I_C_ValidCombinationInput A_Disposal_Revenue_New_A) {
		this.A_Disposal_Revenue_New_A = A_Disposal_Revenue_New_A;
		MAccount foreignEntity;
		if (A_Disposal_Revenue_New_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Disposal_Revenue_New_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Disposal_Revenue_New_Acct(foreignEntity.get_ID());
		} else {
			this.setA_Disposal_Revenue_New_Acct(0);
		}
	}

	/**
	 * Get Disposal Revenue Acct (new).
	 *
	 * @return Disposal Revenue Acct (new)
	 */
	public I_C_ValidCombinationInput getA_Disposal_Revenue_New_A() {
		return A_Disposal_Revenue_New_A;
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	public void setC_AcctSchema(I_C_AcctSchemaInput C_AcctSchema) {
		this.C_AcctSchema = C_AcctSchema;
		MAcctSchema foreignEntity;
		if (get_ID() == 0 &&C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), MAcctSchema.Table_Name, MAcctSchema.COLUMNNAME_C_AcctSchema_UU + "=?", get_TrxName())
						.setParameters(C_AcctSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_AcctSchema_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public I_C_AcctSchemaInput getC_AcctSchema() {
		return C_AcctSchema;
	}
	/**
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema_ID Rules for accounting
	 */

	public void setC_AcctSchema_ID(int C_AcctSchema_ID) {
		if (get_ID() == 0) {
			super.setC_AcctSchema_ID(C_AcctSchema_ID);
		}
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
	 * Set Period.
	 *
	 * @param C_Period_ID Period of the Calendar
	 */

	public void setC_Period_ID(int C_Period_ID) {
		if (get_ID() == 0) {
			super.setC_Period_ID(C_Period_ID);
		}
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
