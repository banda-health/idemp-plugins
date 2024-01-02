package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAssetGroup;
import org.compiere.model.MAssetGroupAcct;
import org.compiere.model.MDepreciation;
import org.compiere.model.MDepreciationConvention;
import org.compiere.model.MDepreciationMethod;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_A_Depreciation_Table_Header;
import org.compiere.util.Env;

/**
 * Generated Model for A_Asset_Group_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Group_AcctInput extends MAssetGroupAcct implements I_A_Asset_Group_AcctInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mA_Depreciation_Manual_Period;
	 private I_AD_Ref_ListInput mA_Reval_Cal_Method;
	 private I_AD_Ref_ListInput mPostingType;
	 private I_A_Asset_GroupInput mA_Asset_Group;
	 private I_A_DepreciationInput mA_Depreciation;
	 private I_A_DepreciationInput mA_Depreciation_F;
	 private I_A_Depreciation_ConventionInput mA_Depreciation_Conv;
	 private I_A_Depreciation_ConventionInput mA_Depreciation_Conv_F;
	 private I_A_Depreciation_MethodInput mA_Depreciation_Method;
	 private I_A_Depreciation_MethodInput mA_Depreciation_Method_F;
	 private I_A_Depreciation_Table_HeaderInput mA_Depreciation_Table_Header;
	 private I_C_AcctSchemaInput mC_AcctSchema;
	 private I_C_ValidCombinationInput mA_Accumdepreciation_A;
	 private I_C_ValidCombinationInput mA_Asset_A;
	 private I_C_ValidCombinationInput mA_Depreciation_A;
	 private I_C_ValidCombinationInput mA_Disposal_Gain_A;
	 private I_C_ValidCombinationInput mA_Disposal_Loss_A;
	 private I_C_ValidCombinationInput mA_Disposal_Revenue_A;
	 private I_C_ValidCombinationInput mA_Reval_Adep_Offset_Cur_A;
	 private I_C_ValidCombinationInput mA_Reval_Adep_Offset_Prior_A;
	 private I_C_ValidCombinationInput mA_Reval_Cost_Offset_A;
	 private I_C_ValidCombinationInput mA_Reval_Cost_Offset_Prior_A;
	 private I_C_ValidCombinationInput mA_Reval_Depexp_Offset_A;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_A_Asset_Group_AcctInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Accumulated Depreciation Account.
	 *
	 * @param A_Accumdepreciation_A Accumulated Depreciation Account
	 */
	@JsonProperty("A_Accumdepreciation_A")
	public void setA_Accumdepreciation_AInput(I_C_ValidCombinationInput A_Accumdepreciation_A) {
		this.mA_Accumdepreciation_A = A_Accumdepreciation_A;
		MAccount foreignEntity;
		if (A_Accumdepreciation_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Accumdepreciation_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Accumdepreciation_Acct(foreignEntity.get_ID());
		} else {
			super.setA_Accumdepreciation_Acct(0);
		}
	}

	/**
	 * Get Accumulated Depreciation Account.
	 *
	 * @return Accumulated Depreciation Account
	 */
	@JsonProperty("A_Accumdepreciation_A")
	public I_C_ValidCombinationInput A_Accumdepreciation_A() {
		return mA_Accumdepreciation_A;
	}

	/**
	 * Set Asset Acct.
	 *
	 * @param A_Asset_A Asset Acct
	 */
	@JsonProperty("A_Asset_A")
	public void setA_Asset_AInput(I_C_ValidCombinationInput A_Asset_A) {
		this.mA_Asset_A = A_Asset_A;
		MAccount foreignEntity;
		if (A_Asset_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Asset_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_Acct(foreignEntity.get_ID());
		} else {
			super.setA_Asset_Acct(0);
		}
	}

	/**
	 * Get Asset Acct.
	 *
	 * @return Asset Acct
	 */
	@JsonProperty("A_Asset_A")
	public I_C_ValidCombinationInput A_Asset_A() {
		return mA_Asset_A;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Asset_Group_Acct_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Asset_Group_Acct_UU();
	}

	/**
	 * Set Asset Group.
	 *
	 * @param A_Asset_Group Group of Assets
	 */
	@JsonProperty("A_Asset_Group")
	public void setA_Asset_GroupInput(I_A_Asset_GroupInput A_Asset_Group) {
		this.mA_Asset_Group = A_Asset_Group;
		MAssetGroup foreignEntity;
		if (get_ID() == 0 &&A_Asset_Group != null &&
				(foreignEntity = new Query(getCtx(), MAssetGroup.Table_Name, MAssetGroup.COLUMNNAME_A_Asset_Group_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Group.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_Group_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Asset Group.
	 *
	 * @return Group of Assets
	 */
	@JsonProperty("A_Asset_Group")
	public I_A_Asset_GroupInput A_Asset_Group() {
		return mA_Asset_Group;
	}

	/**
	 * Set Depreciation Account.
	 *
	 * @param A_Depreciation_A Depreciation Account
	 */
	@JsonProperty("A_Depreciation_A")
	public void setA_Depreciation_AInput(I_C_ValidCombinationInput A_Depreciation_A) {
		this.mA_Depreciation_A = A_Depreciation_A;
		MAccount foreignEntity;
		if (A_Depreciation_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Depreciation_Acct(foreignEntity.get_ID());
		} else {
			super.setA_Depreciation_Acct(0);
		}
	}

	/**
	 * Get Depreciation Account.
	 *
	 * @return Depreciation Account
	 */
	@JsonProperty("A_Depreciation_A")
	public I_C_ValidCombinationInput A_Depreciation_A() {
		return mA_Depreciation_A;
	}

	/**
	 * Set Depreciation Convention (fiscal).
	 *
	 * @param A_Depreciation_Conv_F Depreciation Convention (fiscal)
	 */
	@JsonProperty("A_Depreciation_Conv_F")
	public void setA_Depreciation_Conv_FInput(I_A_Depreciation_ConventionInput A_Depreciation_Conv_F) {
		this.mA_Depreciation_Conv_F = A_Depreciation_Conv_F;
		MDepreciationConvention foreignEntity;
		if (A_Depreciation_Conv_F != null &&
				(foreignEntity = new Query(getCtx(), MDepreciationConvention.Table_Name, MDepreciationConvention.COLUMNNAME_A_Depreciation_Convention_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_Conv_F.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Depreciation_Conv_F_ID(foreignEntity.get_ID());
		} else {
			super.setA_Depreciation_Conv_F_ID(0);
		}
	}

	/**
	 * Get Depreciation Convention (fiscal).
	 *
	 * @return Depreciation Convention (fiscal)
	 */
	@JsonProperty("A_Depreciation_Conv_F")
	public I_A_Depreciation_ConventionInput A_Depreciation_Conv_F() {
		return mA_Depreciation_Conv_F;
	}

	/**
	 * Set Convention Type.
	 *
	 * @param A_Depreciation_Conv Convention Type
	 */
	@JsonProperty("A_Depreciation_Conv")
	public void setA_Depreciation_ConvInput(I_A_Depreciation_ConventionInput A_Depreciation_Conv) {
		this.mA_Depreciation_Conv = A_Depreciation_Conv;
		MDepreciationConvention foreignEntity;
		if (A_Depreciation_Conv != null &&
				(foreignEntity = new Query(getCtx(), MDepreciationConvention.Table_Name, MDepreciationConvention.COLUMNNAME_A_Depreciation_Convention_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_Conv.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Depreciation_Conv_ID(foreignEntity.get_ID());
		} else {
			super.setA_Depreciation_Conv_ID(0);
		}
	}

	/**
	 * Get Convention Type.
	 *
	 * @return Convention Type
	 */
	@JsonProperty("A_Depreciation_Conv")
	public I_A_Depreciation_ConventionInput A_Depreciation_Conv() {
		return mA_Depreciation_Conv;
	}

	/**
	 * Set Depreciation (fiscal).
	 *
	 * @param A_Depreciation_F Depreciation (fiscal)
	 */
	@JsonProperty("A_Depreciation_F")
	public void setA_Depreciation_FInput(I_A_DepreciationInput A_Depreciation_F) {
		this.mA_Depreciation_F = A_Depreciation_F;
		MDepreciation foreignEntity;
		if (A_Depreciation_F != null &&
				(foreignEntity = new Query(getCtx(), MDepreciation.Table_Name, MDepreciation.COLUMNNAME_A_Depreciation_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_F.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Depreciation_F_ID(foreignEntity.get_ID());
		} else {
			super.setA_Depreciation_F_ID(0);
		}
	}

	/**
	 * Get Depreciation (fiscal).
	 *
	 * @return Depreciation (fiscal)
	 */
	@JsonProperty("A_Depreciation_F")
	public I_A_DepreciationInput A_Depreciation_F() {
		return mA_Depreciation_F;
	}

	/**
	 * Set Depreciation.
	 *
	 * @param A_Depreciation Depreciation
	 */
	@JsonProperty("A_Depreciation")
	public void setA_DepreciationInput(I_A_DepreciationInput A_Depreciation) {
		this.mA_Depreciation = A_Depreciation;
		MDepreciation foreignEntity;
		if (A_Depreciation != null &&
				(foreignEntity = new Query(getCtx(), MDepreciation.Table_Name, MDepreciation.COLUMNNAME_A_Depreciation_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Depreciation_ID(foreignEntity.get_ID());
		} else {
			super.setA_Depreciation_ID(0);
		}
	}

	/**
	 * Get Depreciation.
	 *
	 * @return Depreciation
	 */
	@JsonProperty("A_Depreciation")
	public I_A_DepreciationInput A_Depreciation() {
		return mA_Depreciation;
	}

	/**
	 * Set A_Depreciation_Manual_Period.
	 *
	 * @param A_Depreciation_Manual_Period A_Depreciation_Manual_Period
	 */
	@JsonProperty("A_Depreciation_Manual_Period")
	public void setA_Depreciation_Manual_PeriodInput(I_AD_Ref_ListInput A_Depreciation_Manual_Period) {
		this.mA_Depreciation_Manual_Period = A_Depreciation_Manual_Period;
		MRefList_BH foreignEntity;
		if (A_Depreciation_Manual_Period != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_Manual_Period.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Depreciation_Manual_Period(foreignEntity.getValue());
		} else {
			this.setA_Depreciation_Manual_Period(null);
		}
	}

	/**
	 * Get A_Depreciation_Manual_Period.
	 *
	 * @return A_Depreciation_Manual_Period
	 */
	@JsonProperty("A_Depreciation_Manual_Period")
	public I_AD_Ref_ListInput A_Depreciation_Manual_Period() {
		return mA_Depreciation_Manual_Period;
	}

	/**
	 * Set Depreciation Method (fiscal).
	 *
	 * @param A_Depreciation_Method_F Depreciation Method (fiscal)
	 */
	@JsonProperty("A_Depreciation_Method_F")
	public void setA_Depreciation_Method_FInput(I_A_Depreciation_MethodInput A_Depreciation_Method_F) {
		this.mA_Depreciation_Method_F = A_Depreciation_Method_F;
		MDepreciationMethod foreignEntity;
		if (A_Depreciation_Method_F != null &&
				(foreignEntity = new Query(getCtx(), MDepreciationMethod.Table_Name, MDepreciationMethod.COLUMNNAME_A_Depreciation_Method_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_Method_F.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Depreciation_Method_F_ID(foreignEntity.get_ID());
		} else {
			super.setA_Depreciation_Method_F_ID(0);
		}
	}

	/**
	 * Get Depreciation Method (fiscal).
	 *
	 * @return Depreciation Method (fiscal)
	 */
	@JsonProperty("A_Depreciation_Method_F")
	public I_A_Depreciation_MethodInput A_Depreciation_Method_F() {
		return mA_Depreciation_Method_F;
	}

	/**
	 * Set Depreciation Method.
	 *
	 * @param A_Depreciation_Method Depreciation Method
	 */
	@JsonProperty("A_Depreciation_Method")
	public void setA_Depreciation_MethodInput(I_A_Depreciation_MethodInput A_Depreciation_Method) {
		this.mA_Depreciation_Method = A_Depreciation_Method;
		MDepreciationMethod foreignEntity;
		if (A_Depreciation_Method != null &&
				(foreignEntity = new Query(getCtx(), MDepreciationMethod.Table_Name, MDepreciationMethod.COLUMNNAME_A_Depreciation_Method_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_Method.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Depreciation_Method_ID(foreignEntity.get_ID());
		} else {
			super.setA_Depreciation_Method_ID(0);
		}
	}

	/**
	 * Get Depreciation Method.
	 *
	 * @return Depreciation Method
	 */
	@JsonProperty("A_Depreciation_Method")
	public I_A_Depreciation_MethodInput A_Depreciation_Method() {
		return mA_Depreciation_Method;
	}

	/**
	 * Set A_Depreciation_Table_Header_ID.
	 *
	 * @param A_Depreciation_Table_Header A_Depreciation_Table_Header_ID
	 */
	@JsonProperty("A_Depreciation_Table_Header")
	public void setA_Depreciation_Table_HeaderInput(I_A_Depreciation_Table_HeaderInput A_Depreciation_Table_Header) {
		this.mA_Depreciation_Table_Header = A_Depreciation_Table_Header;
		X_A_Depreciation_Table_Header foreignEntity;
		if (A_Depreciation_Table_Header != null &&
				(foreignEntity = new Query(getCtx(), X_A_Depreciation_Table_Header.Table_Name, X_A_Depreciation_Table_Header.COLUMNNAME_A_Depreciation_Table_Header_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_Table_Header.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Depreciation_Table_Header_ID(foreignEntity.get_ID());
		} else {
			super.setA_Depreciation_Table_Header_ID(0);
		}
	}

	/**
	 * Get A_Depreciation_Table_Header_ID.
	 *
	 * @return A_Depreciation_Table_Header_ID
	 */
	@JsonProperty("A_Depreciation_Table_Header")
	public I_A_Depreciation_Table_HeaderInput A_Depreciation_Table_Header() {
		return mA_Depreciation_Table_Header;
	}

	/**
	 * Set Disposal Gain Acct.
	 *
	 * @param A_Disposal_Gain_A Disposal Gain Acct
	 */
	@JsonProperty("A_Disposal_Gain_A")
	public void setA_Disposal_Gain_AInput(I_C_ValidCombinationInput A_Disposal_Gain_A) {
		this.mA_Disposal_Gain_A = A_Disposal_Gain_A;
		MAccount foreignEntity;
		if (A_Disposal_Gain_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Disposal_Gain_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Disposal_Gain_Acct(foreignEntity.get_ID());
		} else {
			super.setA_Disposal_Gain_Acct(0);
		}
	}

	/**
	 * Get Disposal Gain Acct.
	 *
	 * @return Disposal Gain Acct
	 */
	@JsonProperty("A_Disposal_Gain_A")
	public I_C_ValidCombinationInput A_Disposal_Gain_A() {
		return mA_Disposal_Gain_A;
	}

	/**
	 * Set Disposal Loss Acct.
	 *
	 * @param A_Disposal_Loss_A Disposal Loss Acct
	 */
	@JsonProperty("A_Disposal_Loss_A")
	public void setA_Disposal_Loss_AInput(I_C_ValidCombinationInput A_Disposal_Loss_A) {
		this.mA_Disposal_Loss_A = A_Disposal_Loss_A;
		MAccount foreignEntity;
		if (A_Disposal_Loss_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Disposal_Loss_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Disposal_Loss_Acct(foreignEntity.get_ID());
		} else {
			super.setA_Disposal_Loss_Acct(0);
		}
	}

	/**
	 * Get Disposal Loss Acct.
	 *
	 * @return Disposal Loss Acct
	 */
	@JsonProperty("A_Disposal_Loss_A")
	public I_C_ValidCombinationInput A_Disposal_Loss_A() {
		return mA_Disposal_Loss_A;
	}

	/**
	 * Set Disposal Revenue Acct.
	 *
	 * @param A_Disposal_Revenue_A Disposal Revenue Acct
	 */
	@JsonProperty("A_Disposal_Revenue_A")
	public void setA_Disposal_Revenue_AInput(I_C_ValidCombinationInput A_Disposal_Revenue_A) {
		this.mA_Disposal_Revenue_A = A_Disposal_Revenue_A;
		MAccount foreignEntity;
		if (A_Disposal_Revenue_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Disposal_Revenue_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Disposal_Revenue_Acct(foreignEntity.get_ID());
		} else {
			super.setA_Disposal_Revenue_Acct(0);
		}
	}

	/**
	 * Get Disposal Revenue Acct.
	 *
	 * @return Disposal Revenue Acct
	 */
	@JsonProperty("A_Disposal_Revenue_A")
	public I_C_ValidCombinationInput A_Disposal_Revenue_A() {
		return mA_Disposal_Revenue_A;
	}

	/**
	 * Set A_Reval_Accumdep_Offset_Cur.
	 *
	 * @param A_Reval_Adep_Offset_Cur_A A_Reval_Accumdep_Offset_Cur
	 */
	@JsonProperty("A_Reval_Adep_Offset_Cur_A")
	public void setA_Reval_Adep_Offset_Cur_AInput(I_C_ValidCombinationInput A_Reval_Adep_Offset_Cur_A) {
		this.mA_Reval_Adep_Offset_Cur_A = A_Reval_Adep_Offset_Cur_A;
		MAccount foreignEntity;
		if (A_Reval_Adep_Offset_Cur_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Reval_Adep_Offset_Cur_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Reval_Adep_Offset_Cur_Acct(foreignEntity.get_ID());
		} else {
			super.setA_Reval_Adep_Offset_Cur_Acct(0);
		}
	}

	/**
	 * Get A_Reval_Accumdep_Offset_Cur.
	 *
	 * @return A_Reval_Accumdep_Offset_Cur
	 */
	@JsonProperty("A_Reval_Adep_Offset_Cur_A")
	public I_C_ValidCombinationInput A_Reval_Adep_Offset_Cur_A() {
		return mA_Reval_Adep_Offset_Cur_A;
	}

	/**
	 * Set A_Reval_Accumdep_Offset_Prior.
	 *
	 * @param A_Reval_Adep_Offset_Prior_A A_Reval_Accumdep_Offset_Prior
	 */
	@JsonProperty("A_Reval_Adep_Offset_Prior_A")
	public void setA_Reval_Adep_Offset_Prior_AInput(I_C_ValidCombinationInput A_Reval_Adep_Offset_Prior_A) {
		this.mA_Reval_Adep_Offset_Prior_A = A_Reval_Adep_Offset_Prior_A;
		MAccount foreignEntity;
		if (A_Reval_Adep_Offset_Prior_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Reval_Adep_Offset_Prior_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Reval_Adep_Offset_Prior_Acct(foreignEntity.get_ID());
		} else {
			super.setA_Reval_Adep_Offset_Prior_Acct(0);
		}
	}

	/**
	 * Get A_Reval_Accumdep_Offset_Prior.
	 *
	 * @return A_Reval_Accumdep_Offset_Prior
	 */
	@JsonProperty("A_Reval_Adep_Offset_Prior_A")
	public I_C_ValidCombinationInput A_Reval_Adep_Offset_Prior_A() {
		return mA_Reval_Adep_Offset_Prior_A;
	}

	/**
	 * Set A_Reval_Cal_Method.
	 *
	 * @param A_Reval_Cal_Method A_Reval_Cal_Method
	 */
	@JsonProperty("A_Reval_Cal_Method")
	public void setA_Reval_Cal_MethodInput(I_AD_Ref_ListInput A_Reval_Cal_Method) {
		this.mA_Reval_Cal_Method = A_Reval_Cal_Method;
		MRefList_BH foreignEntity;
		if (A_Reval_Cal_Method != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Reval_Cal_Method.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Reval_Cal_Method(foreignEntity.getValue());
		} else {
			this.setA_Reval_Cal_Method(null);
		}
	}

	/**
	 * Get A_Reval_Cal_Method.
	 *
	 * @return A_Reval_Cal_Method
	 */
	@JsonProperty("A_Reval_Cal_Method")
	public I_AD_Ref_ListInput A_Reval_Cal_Method() {
		return mA_Reval_Cal_Method;
	}

	/**
	 * Set Reval Cost Offset Acct.
	 *
	 * @param A_Reval_Cost_Offset_A Reval Cost Offset Acct
	 */
	@JsonProperty("A_Reval_Cost_Offset_A")
	public void setA_Reval_Cost_Offset_AInput(I_C_ValidCombinationInput A_Reval_Cost_Offset_A) {
		this.mA_Reval_Cost_Offset_A = A_Reval_Cost_Offset_A;
		MAccount foreignEntity;
		if (A_Reval_Cost_Offset_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Reval_Cost_Offset_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Reval_Cost_Offset_Acct(foreignEntity.get_ID());
		} else {
			super.setA_Reval_Cost_Offset_Acct(0);
		}
	}

	/**
	 * Get Reval Cost Offset Acct.
	 *
	 * @return Reval Cost Offset Acct
	 */
	@JsonProperty("A_Reval_Cost_Offset_A")
	public I_C_ValidCombinationInput A_Reval_Cost_Offset_A() {
		return mA_Reval_Cost_Offset_A;
	}

	/**
	 * Set Reval Cost Offset Prior Acct.
	 *
	 * @param A_Reval_Cost_Offset_Prior_A Reval Cost Offset Prior Acct
	 */
	@JsonProperty("A_Reval_Cost_Offset_Prior_A")
	public void setA_Reval_Cost_Offset_Prior_AInput(I_C_ValidCombinationInput A_Reval_Cost_Offset_Prior_A) {
		this.mA_Reval_Cost_Offset_Prior_A = A_Reval_Cost_Offset_Prior_A;
		MAccount foreignEntity;
		if (A_Reval_Cost_Offset_Prior_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Reval_Cost_Offset_Prior_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Reval_Cost_Offset_Prior_Acct(foreignEntity.get_ID());
		} else {
			super.setA_Reval_Cost_Offset_Prior_Acct(0);
		}
	}

	/**
	 * Get Reval Cost Offset Prior Acct.
	 *
	 * @return Reval Cost Offset Prior Acct
	 */
	@JsonProperty("A_Reval_Cost_Offset_Prior_A")
	public I_C_ValidCombinationInput A_Reval_Cost_Offset_Prior_A() {
		return mA_Reval_Cost_Offset_Prior_A;
	}

	/**
	 * Set Reval Depexp Offset Acct.
	 *
	 * @param A_Reval_Depexp_Offset_A Reval Depexp Offset Acct
	 */
	@JsonProperty("A_Reval_Depexp_Offset_A")
	public void setA_Reval_Depexp_Offset_AInput(I_C_ValidCombinationInput A_Reval_Depexp_Offset_A) {
		this.mA_Reval_Depexp_Offset_A = A_Reval_Depexp_Offset_A;
		MAccount foreignEntity;
		if (A_Reval_Depexp_Offset_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Reval_Depexp_Offset_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Reval_Depexp_Offset_Acct(foreignEntity.get_ID());
		} else {
			super.setA_Reval_Depexp_Offset_Acct(0);
		}
	}

	/**
	 * Get Reval Depexp Offset Acct.
	 *
	 * @return Reval Depexp Offset Acct
	 */
	@JsonProperty("A_Reval_Depexp_Offset_A")
	public I_C_ValidCombinationInput A_Reval_Depexp_Offset_A() {
		return mA_Reval_Depexp_Offset_A;
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(I_C_AcctSchemaInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		MAcctSchema foreignEntity;
		if (C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), MAcctSchema.Table_Name, MAcctSchema.COLUMNNAME_C_AcctSchema_UU + "=?", get_TrxName())
						.setParameters(C_AcctSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_AcctSchema_ID(foreignEntity.get_ID());
		} else {
			super.setC_AcctSchema_ID(0);
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
