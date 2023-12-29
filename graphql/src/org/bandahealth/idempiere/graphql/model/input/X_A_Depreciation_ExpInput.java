package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetAddition;
import org.compiere.model.MAssetDisposed;
import org.compiere.model.MDepreciationEntry;
import org.compiere.model.MDepreciationExp;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for A_Depreciation_Exp - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_ExpInput extends MDepreciationExp implements I_A_Depreciation_ExpInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput A_Entry_Type_RL;
	 private I_AD_Ref_ListInput A_Period_RL;
	 private I_AD_Ref_ListInput PostingType_RL;
	 private I_A_AssetInput A_Asset;
	 private I_A_Asset_AdditionInput A_Asset_Addition;
	 private I_A_Asset_DisposedInput A_Asset_Disposed;
	 private I_A_Depreciation_EntryInput A_Depreciation_Entry;
	 private I_C_AcctSchemaInput C_AcctSchema;
	 private I_C_ValidCombinationInput A_Account_Number_A;
	 private I_C_ValidCombinationInput CR_Account;
	 private I_C_ValidCombinationInput DR_Account;

	/**
	 * Standard constructor
	 */
	public X_A_Depreciation_ExpInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set A_Account_Number_Acct.
	 *
	 * @param A_Account_Number_A A_Account_Number_Acct
	 */
	public void setA_Account_Number_A(I_C_ValidCombinationInput A_Account_Number_A) {
		this.A_Account_Number_A = A_Account_Number_A;
		MAccount foreignEntity;
		if (A_Account_Number_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Account_Number_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Account_Number_Acct(foreignEntity.get_ID());
		} else {
			this.setA_Account_Number_Acct(0);
		}
	}

	/**
	 * Get A_Account_Number_Acct.
	 *
	 * @return A_Account_Number_Acct
	 */
	public I_C_ValidCombinationInput getA_Account_Number_A() {
		return A_Account_Number_A;
	}

	/**
	 * Set Asset Addition.
	 *
	 * @param A_Asset_Addition Asset Addition
	 */
	public void setA_Asset_Addition(I_A_Asset_AdditionInput A_Asset_Addition) {
		this.A_Asset_Addition = A_Asset_Addition;
		MAssetAddition foreignEntity;
		if (A_Asset_Addition != null &&
				(foreignEntity = new Query(getCtx(), MAssetAddition.Table_Name, MAssetAddition.COLUMNNAME_A_Asset_Addition_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Addition.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_Addition_ID(foreignEntity.get_ID());
		} else {
			this.setA_Asset_Addition_ID(0);
		}
	}

	/**
	 * Get Asset Addition.
	 *
	 * @return Asset Addition
	 */
	public I_A_Asset_AdditionInput getA_Asset_Addition() {
		return A_Asset_Addition;
	}

	/**
	 * Set Asset Disposed.
	 *
	 * @param A_Asset_Disposed Asset Disposed
	 */
	public void setA_Asset_Disposed(I_A_Asset_DisposedInput A_Asset_Disposed) {
		this.A_Asset_Disposed = A_Asset_Disposed;
		MAssetDisposed foreignEntity;
		if (A_Asset_Disposed != null &&
				(foreignEntity = new Query(getCtx(), MAssetDisposed.Table_Name, MAssetDisposed.COLUMNNAME_A_Asset_Disposed_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Disposed.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_Disposed_ID(foreignEntity.get_ID());
		} else {
			this.setA_Asset_Disposed_ID(0);
		}
	}

	/**
	 * Get Asset Disposed.
	 *
	 * @return Asset Disposed
	 */
	public I_A_Asset_DisposedInput getA_Asset_Disposed() {
		return A_Asset_Disposed;
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
	 * Set Depreciation Entry.
	 *
	 * @param A_Depreciation_Entry Depreciation Entry
	 */
	public void setA_Depreciation_Entry(I_A_Depreciation_EntryInput A_Depreciation_Entry) {
		this.A_Depreciation_Entry = A_Depreciation_Entry;
		MDepreciationEntry foreignEntity;
		if (A_Depreciation_Entry != null &&
				(foreignEntity = new Query(getCtx(), MDepreciationEntry.Table_Name, MDepreciationEntry.COLUMNNAME_A_Depreciation_Entry_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_Entry.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Depreciation_Entry_ID(foreignEntity.get_ID());
		} else {
			this.setA_Depreciation_Entry_ID(0);
		}
	}

	/**
	 * Get Depreciation Entry.
	 *
	 * @return Depreciation Entry
	 */
	public I_A_Depreciation_EntryInput getA_Depreciation_Entry() {
		return A_Depreciation_Entry;
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
	 * @param A_Entry_Type_RL Entry Type
	 */
	public void setA_Entry_Type_RL(I_AD_Ref_ListInput A_Entry_Type_RL) {
		this.A_Entry_Type_RL = A_Entry_Type_RL;
		MRefList foreignEntity;
		if (A_Entry_Type_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Entry_Type_RL.getID())
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
	public I_AD_Ref_ListInput getA_Entry_Type_RL() {
		return A_Entry_Type_RL;
	}

	/**
	 * Set Asset Period.
	 *
	 * @param A_Period_RL Asset Period
	 */
	public void setA_Period_RL(I_AD_Ref_ListInput A_Period_RL) {
		this.A_Period_RL = A_Period_RL;
		MRefList foreignEntity;
		if (A_Period_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Period_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Period(foreignEntity.getValue());
		} else {
			this.setA_Period(null);
		}
	}

	/**
	 * Get Asset Period.
	 *
	 * @return Asset Period
	 */
	public I_AD_Ref_ListInput getA_Period_RL() {
		return A_Period_RL;
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
	 * Set Account (credit).
	 *
	 * @param CR_Account Account used
	 */
	public void setCR_Account(I_C_ValidCombinationInput CR_Account) {
		this.CR_Account = CR_Account;
		MAccount foreignEntity;
		if (CR_Account != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(CR_Account.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setCR_Account_ID(foreignEntity.get_ID());
		} else {
			this.setCR_Account_ID(0);
		}
	}

	/**
	 * Get Account (credit).
	 *
	 * @return Account used
	 */
	public I_C_ValidCombinationInput getCR_Account() {
		return CR_Account;
	}

	/**
	 * Set Account (debit).
	 *
	 * @param DR_Account Account used
	 */
	public void setDR_Account(I_C_ValidCombinationInput DR_Account) {
		this.DR_Account = DR_Account;
		MAccount foreignEntity;
		if (DR_Account != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(DR_Account.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDR_Account_ID(foreignEntity.get_ID());
		} else {
			this.setDR_Account_ID(0);
		}
	}

	/**
	 * Get Account (debit).
	 *
	 * @return Account used
	 */
	public I_C_ValidCombinationInput getDR_Account() {
		return DR_Account;
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
