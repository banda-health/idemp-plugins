package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetAddition;
import org.compiere.model.MAssetDisposed;
import org.compiere.model.MDepreciationEntry;
import org.compiere.model.MDepreciationExp;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for A_Depreciation_Exp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_ExpInput extends MDepreciationExp implements I_A_Depreciation_ExpInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mA_Entry_Type;
	 private I_AD_Ref_ListInput mPostingType;
	 private I_A_AssetInput mA_Asset;
	 private I_A_Asset_AdditionInput mA_Asset_Addition;
	 private I_A_Asset_DisposedInput mA_Asset_Disposed;
	 private I_A_Depreciation_EntryInput mA_Depreciation_Entry;
	 private I_C_AcctSchemaInput mC_AcctSchema;
	 private I_C_ValidCombinationInput mA_Account_Number_A;
	 private I_C_ValidCombinationInput mCR_Account;
	 private I_C_ValidCombinationInput mDR_Account;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_A_Depreciation_ExpInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set A_Account_Number_Acct.
	 *
	 * @param A_Account_Number_A A_Account_Number_Acct
	 */
	@JsonProperty("A_Account_Number_A")
	public void setA_Account_Number_AInput(I_C_ValidCombinationInput A_Account_Number_A) {
		this.mA_Account_Number_A = A_Account_Number_A;
		MAccount foreignEntity;
		if (A_Account_Number_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Account_Number_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Account_Number_Acct(foreignEntity.get_ID());
		} else {
			super.setA_Account_Number_Acct(0);
		}
	}

	/**
	 * Get A_Account_Number_Acct.
	 *
	 * @return A_Account_Number_Acct
	 */
	@JsonProperty("A_Account_Number_A")
	public I_C_ValidCombinationInput A_Account_Number_A() {
		return mA_Account_Number_A;
	}

	/**
	 * Set Asset Addition.
	 *
	 * @param A_Asset_Addition Asset Addition
	 */
	@JsonProperty("A_Asset_Addition")
	public void setA_Asset_AdditionInput(I_A_Asset_AdditionInput A_Asset_Addition) {
		this.mA_Asset_Addition = A_Asset_Addition;
		MAssetAddition foreignEntity;
		if (A_Asset_Addition != null &&
				(foreignEntity = new Query(getCtx(), MAssetAddition.Table_Name, MAssetAddition.COLUMNNAME_A_Asset_Addition_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Addition.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_Addition_ID(foreignEntity.get_ID());
		} else {
			super.setA_Asset_Addition_ID(0);
		}
	}

	/**
	 * Get Asset Addition.
	 *
	 * @return Asset Addition
	 */
	@JsonProperty("A_Asset_Addition")
	public I_A_Asset_AdditionInput A_Asset_Addition() {
		return mA_Asset_Addition;
	}

	/**
	 * Set Asset Disposed.
	 *
	 * @param A_Asset_Disposed Asset Disposed
	 */
	@JsonProperty("A_Asset_Disposed")
	public void setA_Asset_DisposedInput(I_A_Asset_DisposedInput A_Asset_Disposed) {
		this.mA_Asset_Disposed = A_Asset_Disposed;
		MAssetDisposed foreignEntity;
		if (A_Asset_Disposed != null &&
				(foreignEntity = new Query(getCtx(), MAssetDisposed.Table_Name, MAssetDisposed.COLUMNNAME_A_Asset_Disposed_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Disposed.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_Disposed_ID(foreignEntity.get_ID());
		} else {
			super.setA_Asset_Disposed_ID(0);
		}
	}

	/**
	 * Get Asset Disposed.
	 *
	 * @return Asset Disposed
	 */
	@JsonProperty("A_Asset_Disposed")
	public I_A_Asset_DisposedInput A_Asset_Disposed() {
		return mA_Asset_Disposed;
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public void setA_AssetInput(I_A_AssetInput A_Asset) {
		this.mA_Asset = A_Asset;
		MAsset foreignEntity;
		if (A_Asset != null &&
				(foreignEntity = new Query(getCtx(), MAsset.Table_Name, MAsset.COLUMNNAME_A_Asset_UU + "=?", get_TrxName())
						.setParameters(A_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_ID(foreignEntity.get_ID());
		} else {
			super.setA_Asset_ID(0);
		}
	}

	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public I_A_AssetInput A_Asset() {
		return mA_Asset;
	}

	/**
	 * Set Depreciation Entry.
	 *
	 * @param A_Depreciation_Entry Depreciation Entry
	 */
	@JsonProperty("A_Depreciation_Entry")
	public void setA_Depreciation_EntryInput(I_A_Depreciation_EntryInput A_Depreciation_Entry) {
		this.mA_Depreciation_Entry = A_Depreciation_Entry;
		MDepreciationEntry foreignEntity;
		if (A_Depreciation_Entry != null &&
				(foreignEntity = new Query(getCtx(), MDepreciationEntry.Table_Name, MDepreciationEntry.COLUMNNAME_A_Depreciation_Entry_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_Entry.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Depreciation_Entry_ID(foreignEntity.get_ID());
		} else {
			super.setA_Depreciation_Entry_ID(0);
		}
	}

	/**
	 * Get Depreciation Entry.
	 *
	 * @return Depreciation Entry
	 */
	@JsonProperty("A_Depreciation_Entry")
	public I_A_Depreciation_EntryInput A_Depreciation_Entry() {
		return mA_Depreciation_Entry;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Depreciation_Exp_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Depreciation_Exp_UU();
	}

	/**
	 * Set Entry Type.
	 *
	 * @param A_Entry_Type Entry Type
	 */
	@JsonProperty("A_Entry_Type")
	public void setA_Entry_TypeInput(I_AD_Ref_ListInput A_Entry_Type) {
		this.mA_Entry_Type = A_Entry_Type;
		MRefList_BH foreignEntity;
		if (A_Entry_Type != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Entry_Type.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Entry_Type(foreignEntity.getValue());
		} else {
			this.setA_Entry_Type(null);
		}
	}

	/**
	 * Get Entry Type.
	 *
	 * @return Entry Type
	 */
	@JsonProperty("A_Entry_Type")
	public I_AD_Ref_ListInput A_Entry_Type() {
		return mA_Entry_Type;
	}
	/**
	 * Set Asset Period.
	 *
	 * @param A_Period Asset Period
	 */

	public void setA_Period(int A_Period) {
		if (get_ID() == 0) {
			super.setA_Period(A_Period);
		}
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
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Org_ID(0);
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(I_C_AcctSchemaInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		MAcctSchema foreignEntity;
		if (get_ID() == 0 &&C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), MAcctSchema.Table_Name, MAcctSchema.COLUMNNAME_C_AcctSchema_UU + "=?", get_TrxName())
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
	public I_C_AcctSchemaInput C_AcctSchema() {
		return mC_AcctSchema;
	}

	/**
	 * Set Account (credit).
	 *
	 * @param CR_Account Account used
	 */
	@JsonProperty("CR_Account")
	public void setCR_AccountInput(I_C_ValidCombinationInput CR_Account) {
		this.mCR_Account = CR_Account;
		MAccount foreignEntity;
		if (CR_Account != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(CR_Account.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setCR_Account_ID(foreignEntity.get_ID());
		} else {
			super.setCR_Account_ID(0);
		}
	}

	/**
	 * Get Account (credit).
	 *
	 * @return Account used
	 */
	@JsonProperty("CR_Account")
	public I_C_ValidCombinationInput CR_Account() {
		return mCR_Account;
	}

	/**
	 * Set Account (debit).
	 *
	 * @param DR_Account Account used
	 */
	@JsonProperty("DR_Account")
	public void setDR_AccountInput(I_C_ValidCombinationInput DR_Account) {
		this.mDR_Account = DR_Account;
		MAccount foreignEntity;
		if (DR_Account != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(DR_Account.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setDR_Account_ID(foreignEntity.get_ID());
		} else {
			super.setDR_Account_ID(0);
		}
	}

	/**
	 * Get Account (debit).
	 *
	 * @return Account used
	 */
	@JsonProperty("DR_Account")
	public I_C_ValidCombinationInput DR_Account() {
		return mDR_Account;
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
