package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAssetGroup;
import org.compiere.model.MDepreciation;
import org.compiere.model.MDepreciationConvention;
import org.compiere.model.MDepreciationMethod;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_A_Asset_Group_Acct;
import org.compiere.model.X_A_Depreciation_Table_Header;
import org.compiere.util.Env;

/**
 * Generated Model for A_Asset_Group_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_Group_AcctInput extends X_A_Asset_Group_Acct implements I_A_Asset_Group_AcctInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput A_Depreciation_Manual_Period_RL;
	 private I_AD_Ref_ListInput A_Reval_Cal_Method_RL;
	 private I_AD_Ref_ListInput PostingType_RL;
	 private I_A_Asset_GroupInput A_Asset_Group;
	 private I_A_DepreciationInput A_Depreciation;
	 private I_A_DepreciationInput A_Depreciation_F;
	 private I_A_Depreciation_ConventionInput A_Depreciation_Conv;
	 private I_A_Depreciation_ConventionInput A_Depreciation_Conv_F;
	 private I_A_Depreciation_MethodInput A_Depreciation_Method;
	 private I_A_Depreciation_MethodInput A_Depreciation_Method_F;
	 private I_A_Depreciation_Table_HeaderInput A_Depreciation_Table_Header;
	 private I_C_AcctSchemaInput C_AcctSchema;
	 private I_C_ValidCombinationInput A_Accumdepreciation_A;
	 private I_C_ValidCombinationInput A_Asset_A;
	 private I_C_ValidCombinationInput A_Depreciation_A;
	 private I_C_ValidCombinationInput A_Disposal_Gain_A;
	 private I_C_ValidCombinationInput A_Disposal_Loss_A;
	 private I_C_ValidCombinationInput A_Disposal_Revenue_A;
	 private I_C_ValidCombinationInput A_Reval_Adep_Offset_Cur_A;
	 private I_C_ValidCombinationInput A_Reval_Adep_Offset_Prior_A;
	 private I_C_ValidCombinationInput A_Reval_Cost_Offset_A;
	 private I_C_ValidCombinationInput A_Reval_Cost_Offset_Prior_A;
	 private I_C_ValidCombinationInput A_Reval_Depexp_Offset_A;

	/**
	 * Standard constructor
	 */
	public X_A_Asset_Group_AcctInput(String ID) {
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
		if (A_Accumdepreciation_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Accumdepreciation_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Accumdepreciation_Acct(foreignEntity.get_ID());
		} else {
			this.setA_Accumdepreciation_Acct(0);
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
	 * Set Asset Acct.
	 *
	 * @param A_Asset_A Asset Acct
	 */
	public void setA_Asset_A(I_C_ValidCombinationInput A_Asset_A) {
		this.A_Asset_A = A_Asset_A;
		MAccount foreignEntity;
		if (A_Asset_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Asset_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_Acct(foreignEntity.get_ID());
		} else {
			this.setA_Asset_Acct(0);
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
	 * Set Asset Group Accounting.
	 *
	 * @param A_Asset_Group_Acct_ID Asset Group Accounting
	 */

	public void setA_Asset_Group_Acct_ID(int A_Asset_Group_Acct_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Group_Acct_ID(A_Asset_Group_Acct_ID);
		}
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
	public void setA_Asset_Group(I_A_Asset_GroupInput A_Asset_Group) {
		this.A_Asset_Group = A_Asset_Group;
		MAssetGroup foreignEntity;
		if (get_ID() == 0 &&A_Asset_Group != null &&
				(foreignEntity = new Query(getCtx(), MAssetGroup.Table_Name, MAssetGroup.COLUMNNAME_A_Asset_Group_UU + "=?", get_TrxName())
						.setParameters(A_Asset_Group.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_Group_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Asset Group.
	 *
	 * @return Group of Assets
	 */
	public I_A_Asset_GroupInput getA_Asset_Group() {
		return A_Asset_Group;
	}
	/**
	 * Set Asset Group.
	 *
	 * @param A_Asset_Group_ID Group of Assets
	 */

	public void setA_Asset_Group_ID(int A_Asset_Group_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Group_ID(A_Asset_Group_ID);
		}
	}

	/**
	 * Set Depreciation Account.
	 *
	 * @param A_Depreciation_A Depreciation Account
	 */
	public void setA_Depreciation_A(I_C_ValidCombinationInput A_Depreciation_A) {
		this.A_Depreciation_A = A_Depreciation_A;
		MAccount foreignEntity;
		if (A_Depreciation_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Depreciation_Acct(foreignEntity.get_ID());
		} else {
			this.setA_Depreciation_Acct(0);
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
	 * Set Depreciation Convention (fiscal).
	 *
	 * @param A_Depreciation_Conv_F Depreciation Convention (fiscal)
	 */
	public void setA_Depreciation_Conv_F(I_A_Depreciation_ConventionInput A_Depreciation_Conv_F) {
		this.A_Depreciation_Conv_F = A_Depreciation_Conv_F;
		MDepreciationConvention foreignEntity;
		if (A_Depreciation_Conv_F != null &&
				(foreignEntity = new Query(getCtx(), MDepreciationConvention.Table_Name, MDepreciationConvention.COLUMNNAME_A_Depreciation_Convention_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_Conv_F.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Depreciation_Conv_F_ID(foreignEntity.get_ID());
		} else {
			this.setA_Depreciation_Conv_F_ID(0);
		}
	}

	/**
	 * Get Depreciation Convention (fiscal).
	 *
	 * @return Depreciation Convention (fiscal)
	 */
	public I_A_Depreciation_ConventionInput getA_Depreciation_Conv_F() {
		return A_Depreciation_Conv_F;
	}
	/**
	 * Set Depreciation Convention (fiscal).
	 *
	 * @param A_Depreciation_Conv_F_ID Depreciation Convention (fiscal)
	 */

	public void setA_Depreciation_Conv_F_ID(int A_Depreciation_Conv_F_ID) {
		if (get_ID() == 0) {
			super.setA_Depreciation_Conv_F_ID(A_Depreciation_Conv_F_ID);
		}
	}

	/**
	 * Set Convention Type.
	 *
	 * @param A_Depreciation_Conv Convention Type
	 */
	public void setA_Depreciation_Conv(I_A_Depreciation_ConventionInput A_Depreciation_Conv) {
		this.A_Depreciation_Conv = A_Depreciation_Conv;
		MDepreciationConvention foreignEntity;
		if (A_Depreciation_Conv != null &&
				(foreignEntity = new Query(getCtx(), MDepreciationConvention.Table_Name, MDepreciationConvention.COLUMNNAME_A_Depreciation_Convention_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_Conv.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Depreciation_Conv_ID(foreignEntity.get_ID());
		} else {
			this.setA_Depreciation_Conv_ID(0);
		}
	}

	/**
	 * Get Convention Type.
	 *
	 * @return Convention Type
	 */
	public I_A_Depreciation_ConventionInput getA_Depreciation_Conv() {
		return A_Depreciation_Conv;
	}
	/**
	 * Set Convention Type.
	 *
	 * @param A_Depreciation_Conv_ID Convention Type
	 */

	public void setA_Depreciation_Conv_ID(int A_Depreciation_Conv_ID) {
		if (get_ID() == 0) {
			super.setA_Depreciation_Conv_ID(A_Depreciation_Conv_ID);
		}
	}

	/**
	 * Set Depreciation (fiscal).
	 *
	 * @param A_Depreciation_F Depreciation (fiscal)
	 */
	public void setA_Depreciation_F(I_A_DepreciationInput A_Depreciation_F) {
		this.A_Depreciation_F = A_Depreciation_F;
		MDepreciation foreignEntity;
		if (A_Depreciation_F != null &&
				(foreignEntity = new Query(getCtx(), MDepreciation.Table_Name, MDepreciation.COLUMNNAME_A_Depreciation_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_F.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Depreciation_F_ID(foreignEntity.get_ID());
		} else {
			this.setA_Depreciation_F_ID(0);
		}
	}

	/**
	 * Get Depreciation (fiscal).
	 *
	 * @return Depreciation (fiscal)
	 */
	public I_A_DepreciationInput getA_Depreciation_F() {
		return A_Depreciation_F;
	}
	/**
	 * Set Depreciation (fiscal).
	 *
	 * @param A_Depreciation_F_ID Depreciation (fiscal)
	 */

	public void setA_Depreciation_F_ID(int A_Depreciation_F_ID) {
		if (get_ID() == 0) {
			super.setA_Depreciation_F_ID(A_Depreciation_F_ID);
		}
	}

	/**
	 * Set Depreciation.
	 *
	 * @param A_Depreciation Depreciation
	 */
	public void setA_Depreciation(I_A_DepreciationInput A_Depreciation) {
		this.A_Depreciation = A_Depreciation;
		MDepreciation foreignEntity;
		if (A_Depreciation != null &&
				(foreignEntity = new Query(getCtx(), MDepreciation.Table_Name, MDepreciation.COLUMNNAME_A_Depreciation_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Depreciation_ID(foreignEntity.get_ID());
		} else {
			this.setA_Depreciation_ID(0);
		}
	}

	/**
	 * Get Depreciation.
	 *
	 * @return Depreciation
	 */
	public I_A_DepreciationInput getA_Depreciation() {
		return A_Depreciation;
	}
	/**
	 * Set Depreciation.
	 *
	 * @param A_Depreciation_ID Depreciation
	 */

	public void setA_Depreciation_ID(int A_Depreciation_ID) {
		if (get_ID() == 0) {
			super.setA_Depreciation_ID(A_Depreciation_ID);
		}
	}

	/**
	 * Set A_Depreciation_Manual_Period.
	 *
	 * @param A_Depreciation_Manual_Period_RL A_Depreciation_Manual_Period
	 */
	public void setA_Depreciation_Manual_Period_RL(I_AD_Ref_ListInput A_Depreciation_Manual_Period_RL) {
		this.A_Depreciation_Manual_Period_RL = A_Depreciation_Manual_Period_RL;
		MRefList foreignEntity;
		if (A_Depreciation_Manual_Period_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_Manual_Period_RL.getID())
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
	public I_AD_Ref_ListInput getA_Depreciation_Manual_Period_RL() {
		return A_Depreciation_Manual_Period_RL;
	}

	/**
	 * Set Depreciation Method (fiscal).
	 *
	 * @param A_Depreciation_Method_F Depreciation Method (fiscal)
	 */
	public void setA_Depreciation_Method_F(I_A_Depreciation_MethodInput A_Depreciation_Method_F) {
		this.A_Depreciation_Method_F = A_Depreciation_Method_F;
		MDepreciationMethod foreignEntity;
		if (A_Depreciation_Method_F != null &&
				(foreignEntity = new Query(getCtx(), MDepreciationMethod.Table_Name, MDepreciationMethod.COLUMNNAME_A_Depreciation_Method_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_Method_F.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Depreciation_Method_F_ID(foreignEntity.get_ID());
		} else {
			this.setA_Depreciation_Method_F_ID(0);
		}
	}

	/**
	 * Get Depreciation Method (fiscal).
	 *
	 * @return Depreciation Method (fiscal)
	 */
	public I_A_Depreciation_MethodInput getA_Depreciation_Method_F() {
		return A_Depreciation_Method_F;
	}
	/**
	 * Set Depreciation Method (fiscal).
	 *
	 * @param A_Depreciation_Method_F_ID Depreciation Method (fiscal)
	 */

	public void setA_Depreciation_Method_F_ID(int A_Depreciation_Method_F_ID) {
		if (get_ID() == 0) {
			super.setA_Depreciation_Method_F_ID(A_Depreciation_Method_F_ID);
		}
	}

	/**
	 * Set Depreciation Method.
	 *
	 * @param A_Depreciation_Method Depreciation Method
	 */
	public void setA_Depreciation_Method(I_A_Depreciation_MethodInput A_Depreciation_Method) {
		this.A_Depreciation_Method = A_Depreciation_Method;
		MDepreciationMethod foreignEntity;
		if (A_Depreciation_Method != null &&
				(foreignEntity = new Query(getCtx(), MDepreciationMethod.Table_Name, MDepreciationMethod.COLUMNNAME_A_Depreciation_Method_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_Method.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Depreciation_Method_ID(foreignEntity.get_ID());
		} else {
			this.setA_Depreciation_Method_ID(0);
		}
	}

	/**
	 * Get Depreciation Method.
	 *
	 * @return Depreciation Method
	 */
	public I_A_Depreciation_MethodInput getA_Depreciation_Method() {
		return A_Depreciation_Method;
	}
	/**
	 * Set Depreciation Method.
	 *
	 * @param A_Depreciation_Method_ID Depreciation Method
	 */

	public void setA_Depreciation_Method_ID(int A_Depreciation_Method_ID) {
		if (get_ID() == 0) {
			super.setA_Depreciation_Method_ID(A_Depreciation_Method_ID);
		}
	}

	/**
	 * Set A_Depreciation_Table_Header_ID.
	 *
	 * @param A_Depreciation_Table_Header A_Depreciation_Table_Header_ID
	 */
	public void setA_Depreciation_Table_Header(I_A_Depreciation_Table_HeaderInput A_Depreciation_Table_Header) {
		this.A_Depreciation_Table_Header = A_Depreciation_Table_Header;
		X_A_Depreciation_Table_Header foreignEntity;
		if (A_Depreciation_Table_Header != null &&
				(foreignEntity = new Query(getCtx(), X_A_Depreciation_Table_Header.Table_Name, X_A_Depreciation_Table_Header.COLUMNNAME_A_Depreciation_Table_Header_UU + "=?", get_TrxName())
						.setParameters(A_Depreciation_Table_Header.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Depreciation_Table_Header_ID(foreignEntity.get_ID());
		} else {
			this.setA_Depreciation_Table_Header_ID(0);
		}
	}

	/**
	 * Get A_Depreciation_Table_Header_ID.
	 *
	 * @return A_Depreciation_Table_Header_ID
	 */
	public I_A_Depreciation_Table_HeaderInput getA_Depreciation_Table_Header() {
		return A_Depreciation_Table_Header;
	}
	/**
	 * Set A_Depreciation_Table_Header_ID.
	 *
	 * @param A_Depreciation_Table_Header_ID A_Depreciation_Table_Header_ID
	 */

	public void setA_Depreciation_Table_Header_ID(int A_Depreciation_Table_Header_ID) {
		if (get_ID() == 0) {
			super.setA_Depreciation_Table_Header_ID(A_Depreciation_Table_Header_ID);
		}
	}

	/**
	 * Set Disposal Gain Acct.
	 *
	 * @param A_Disposal_Gain_A Disposal Gain Acct
	 */
	public void setA_Disposal_Gain_A(I_C_ValidCombinationInput A_Disposal_Gain_A) {
		this.A_Disposal_Gain_A = A_Disposal_Gain_A;
		MAccount foreignEntity;
		if (A_Disposal_Gain_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Disposal_Gain_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Disposal_Gain_Acct(foreignEntity.get_ID());
		} else {
			this.setA_Disposal_Gain_Acct(0);
		}
	}

	/**
	 * Get Disposal Gain Acct.
	 *
	 * @return Disposal Gain Acct
	 */
	public I_C_ValidCombinationInput getA_Disposal_Gain_A() {
		return A_Disposal_Gain_A;
	}

	/**
	 * Set Disposal Loss Acct.
	 *
	 * @param A_Disposal_Loss_A Disposal Loss Acct
	 */
	public void setA_Disposal_Loss_A(I_C_ValidCombinationInput A_Disposal_Loss_A) {
		this.A_Disposal_Loss_A = A_Disposal_Loss_A;
		MAccount foreignEntity;
		if (A_Disposal_Loss_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Disposal_Loss_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Disposal_Loss_Acct(foreignEntity.get_ID());
		} else {
			this.setA_Disposal_Loss_Acct(0);
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
	 * Set Disposal Revenue Acct.
	 *
	 * @param A_Disposal_Revenue_A Disposal Revenue Acct
	 */
	public void setA_Disposal_Revenue_A(I_C_ValidCombinationInput A_Disposal_Revenue_A) {
		this.A_Disposal_Revenue_A = A_Disposal_Revenue_A;
		MAccount foreignEntity;
		if (A_Disposal_Revenue_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Disposal_Revenue_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Disposal_Revenue_Acct(foreignEntity.get_ID());
		} else {
			this.setA_Disposal_Revenue_Acct(0);
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
	 * Set A_Reval_Accumdep_Offset_Cur.
	 *
	 * @param A_Reval_Adep_Offset_Cur_A A_Reval_Accumdep_Offset_Cur
	 */
	public void setA_Reval_Adep_Offset_Cur_A(I_C_ValidCombinationInput A_Reval_Adep_Offset_Cur_A) {
		this.A_Reval_Adep_Offset_Cur_A = A_Reval_Adep_Offset_Cur_A;
		MAccount foreignEntity;
		if (A_Reval_Adep_Offset_Cur_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Reval_Adep_Offset_Cur_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Reval_Adep_Offset_Cur_Acct(foreignEntity.get_ID());
		} else {
			this.setA_Reval_Adep_Offset_Cur_Acct(0);
		}
	}

	/**
	 * Get A_Reval_Accumdep_Offset_Cur.
	 *
	 * @return A_Reval_Accumdep_Offset_Cur
	 */
	public I_C_ValidCombinationInput getA_Reval_Adep_Offset_Cur_A() {
		return A_Reval_Adep_Offset_Cur_A;
	}

	/**
	 * Set A_Reval_Accumdep_Offset_Prior.
	 *
	 * @param A_Reval_Adep_Offset_Prior_A A_Reval_Accumdep_Offset_Prior
	 */
	public void setA_Reval_Adep_Offset_Prior_A(I_C_ValidCombinationInput A_Reval_Adep_Offset_Prior_A) {
		this.A_Reval_Adep_Offset_Prior_A = A_Reval_Adep_Offset_Prior_A;
		MAccount foreignEntity;
		if (A_Reval_Adep_Offset_Prior_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Reval_Adep_Offset_Prior_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Reval_Adep_Offset_Prior_Acct(foreignEntity.get_ID());
		} else {
			this.setA_Reval_Adep_Offset_Prior_Acct(0);
		}
	}

	/**
	 * Get A_Reval_Accumdep_Offset_Prior.
	 *
	 * @return A_Reval_Accumdep_Offset_Prior
	 */
	public I_C_ValidCombinationInput getA_Reval_Adep_Offset_Prior_A() {
		return A_Reval_Adep_Offset_Prior_A;
	}

	/**
	 * Set A_Reval_Cal_Method.
	 *
	 * @param A_Reval_Cal_Method_RL A_Reval_Cal_Method
	 */
	public void setA_Reval_Cal_Method_RL(I_AD_Ref_ListInput A_Reval_Cal_Method_RL) {
		this.A_Reval_Cal_Method_RL = A_Reval_Cal_Method_RL;
		MRefList foreignEntity;
		if (A_Reval_Cal_Method_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Reval_Cal_Method_RL.getID())
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
	public I_AD_Ref_ListInput getA_Reval_Cal_Method_RL() {
		return A_Reval_Cal_Method_RL;
	}

	/**
	 * Set Reval Cost Offset Acct.
	 *
	 * @param A_Reval_Cost_Offset_A Reval Cost Offset Acct
	 */
	public void setA_Reval_Cost_Offset_A(I_C_ValidCombinationInput A_Reval_Cost_Offset_A) {
		this.A_Reval_Cost_Offset_A = A_Reval_Cost_Offset_A;
		MAccount foreignEntity;
		if (A_Reval_Cost_Offset_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Reval_Cost_Offset_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Reval_Cost_Offset_Acct(foreignEntity.get_ID());
		} else {
			this.setA_Reval_Cost_Offset_Acct(0);
		}
	}

	/**
	 * Get Reval Cost Offset Acct.
	 *
	 * @return Reval Cost Offset Acct
	 */
	public I_C_ValidCombinationInput getA_Reval_Cost_Offset_A() {
		return A_Reval_Cost_Offset_A;
	}

	/**
	 * Set Reval Cost Offset Prior Acct.
	 *
	 * @param A_Reval_Cost_Offset_Prior_A Reval Cost Offset Prior Acct
	 */
	public void setA_Reval_Cost_Offset_Prior_A(I_C_ValidCombinationInput A_Reval_Cost_Offset_Prior_A) {
		this.A_Reval_Cost_Offset_Prior_A = A_Reval_Cost_Offset_Prior_A;
		MAccount foreignEntity;
		if (A_Reval_Cost_Offset_Prior_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Reval_Cost_Offset_Prior_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Reval_Cost_Offset_Prior_Acct(foreignEntity.get_ID());
		} else {
			this.setA_Reval_Cost_Offset_Prior_Acct(0);
		}
	}

	/**
	 * Get Reval Cost Offset Prior Acct.
	 *
	 * @return Reval Cost Offset Prior Acct
	 */
	public I_C_ValidCombinationInput getA_Reval_Cost_Offset_Prior_A() {
		return A_Reval_Cost_Offset_Prior_A;
	}

	/**
	 * Set Reval Depexp Offset Acct.
	 *
	 * @param A_Reval_Depexp_Offset_A Reval Depexp Offset Acct
	 */
	public void setA_Reval_Depexp_Offset_A(I_C_ValidCombinationInput A_Reval_Depexp_Offset_A) {
		this.A_Reval_Depexp_Offset_A = A_Reval_Depexp_Offset_A;
		MAccount foreignEntity;
		if (A_Reval_Depexp_Offset_A != null &&
				(foreignEntity = new Query(getCtx(), MAccount.Table_Name, MAccount.COLUMNNAME_C_ValidCombination_UU + "=?", get_TrxName())
						.setParameters(A_Reval_Depexp_Offset_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Reval_Depexp_Offset_Acct(foreignEntity.get_ID());
		} else {
			this.setA_Reval_Depexp_Offset_Acct(0);
		}
	}

	/**
	 * Get Reval Depexp Offset Acct.
	 *
	 * @return Reval Depexp Offset Acct
	 */
	public I_C_ValidCombinationInput getA_Reval_Depexp_Offset_A() {
		return A_Reval_Depexp_Offset_A;
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
		if (C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), MAcctSchema.Table_Name, MAcctSchema.COLUMNNAME_C_AcctSchema_UU + "=?", get_TrxName())
						.setParameters(C_AcctSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_AcctSchema_ID(foreignEntity.get_ID());
		} else {
			this.setC_AcctSchema_ID(0);
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
