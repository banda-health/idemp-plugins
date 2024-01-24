package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetAcct;
import org.compiere.model.MDepreciation;
import org.compiere.model.MDepreciationConvention;
import org.compiere.model.MDepreciationMethod;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_A_Depreciation_Table_Header;

import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for A_Asset_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_AcctInput extends MAssetAcct implements I_A_Asset_AcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Accumdepreciation_A;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mA_Asset_A;
	private ForeignEntityInput mA_Depreciation;
	private ForeignEntityInput mA_Depreciation_A;
	private ForeignEntityInput mA_Depreciation_Conv;
	private ForeignEntityInput mA_Depreciation_Conv_F;
	private ForeignEntityInput mA_Depreciation_F;
	private ForeignEntityInput mA_Depreciation_Method;
	private ForeignEntityInput mA_Depreciation_Method_F;
	private ForeignEntityInput mA_Depreciation_Table_Header;
	private ForeignEntityInput mA_Disposal_Gain_A;
	private ForeignEntityInput mA_Disposal_Loss_A;
	private ForeignEntityInput mA_Disposal_Revenue_A;
	private ForeignEntityInput mA_Reval_Adep_Offset_Cur_A;
	private ForeignEntityInput mA_Reval_Adep_Offset_Prior_A;
	private ForeignEntityInput mA_Reval_Cost_Offset_A;
	private ForeignEntityInput mA_Reval_Cost_Offset_Prior_A;
	private ForeignEntityInput mA_Reval_Depexp_Offset_A;
	private ForeignEntityInput mC_AcctSchema;
	private I_AD_Ref_ListInput mA_Depreciation_Manual_Period;
	private I_AD_Ref_ListInput mA_Reval_Cal_Method;
	private I_AD_Ref_ListInput mPostingType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_A_Asset_AcctInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MAssetAcct(null, (ResultSet) null, null), null, Table_Name, ID),
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
		if (A_Accumdepreciation_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
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
	public ForeignEntityInput A_Accumdepreciation_A() {
		return mA_Accumdepreciation_A;
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
		if (A_Asset_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
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
	public ForeignEntityInput A_Asset_A() {
		return mA_Asset_A;
	}
	/**
	 * Set A_Asset_Acct_ID.
	 *
	 * @param A_Asset_Acct_ID A_Asset_Acct_ID
	 */

	public void setA_Asset_Acct_ID(int A_Asset_Acct_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Acct_ID(A_Asset_Acct_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Asset_Acct_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Asset_Acct_UU();
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
	 * Set Depreciation Account.
	 *
	 * @param A_Depreciation_A Depreciation Account
	 */
	@JsonProperty("A_Depreciation_A")
	public void setA_Depreciation_AInput(ForeignEntityInput A_Depreciation_A) {
		this.mA_Depreciation_A = A_Depreciation_A;
		MAccount foreignEntity;
		if (A_Depreciation_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
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
	public ForeignEntityInput A_Depreciation_A() {
		return mA_Depreciation_A;
	}

	/**
	 * Set Depreciation Convention (fiscal).
	 *
	 * @param A_Depreciation_Conv_F Depreciation Convention (fiscal)
	 */
	@JsonProperty("A_Depreciation_Conv_F")
	public void setA_Depreciation_Conv_FInput(ForeignEntityInput A_Depreciation_Conv_F) {
		this.mA_Depreciation_Conv_F = A_Depreciation_Conv_F;
		MDepreciationConvention foreignEntity;
		if (A_Depreciation_Conv_F != null &&
				(foreignEntity = new Query(getCtx(), "A_Depreciation_Convention", "A_Depreciation_Convention_UU=?", get_TrxName())
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
	public ForeignEntityInput A_Depreciation_Conv_F() {
		return mA_Depreciation_Conv_F;
	}

	/**
	 * Set Convention Type.
	 *
	 * @param A_Depreciation_Conv Convention Type
	 */
	@JsonProperty("A_Depreciation_Conv")
	public void setA_Depreciation_ConvInput(ForeignEntityInput A_Depreciation_Conv) {
		this.mA_Depreciation_Conv = A_Depreciation_Conv;
		MDepreciationConvention foreignEntity;
		if (A_Depreciation_Conv != null &&
				(foreignEntity = new Query(getCtx(), "A_Depreciation_Convention", "A_Depreciation_Convention_UU=?", get_TrxName())
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
	public ForeignEntityInput A_Depreciation_Conv() {
		return mA_Depreciation_Conv;
	}

	/**
	 * Set Depreciation (fiscal).
	 *
	 * @param A_Depreciation_F Depreciation (fiscal)
	 */
	@JsonProperty("A_Depreciation_F")
	public void setA_Depreciation_FInput(ForeignEntityInput A_Depreciation_F) {
		this.mA_Depreciation_F = A_Depreciation_F;
		MDepreciation foreignEntity;
		if (A_Depreciation_F != null &&
				(foreignEntity = new Query(getCtx(), "A_Depreciation", "A_Depreciation_UU=?", get_TrxName())
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
	public ForeignEntityInput A_Depreciation_F() {
		return mA_Depreciation_F;
	}

	/**
	 * Set Depreciation.
	 *
	 * @param A_Depreciation Depreciation
	 */
	@JsonProperty("A_Depreciation")
	public void setA_DepreciationInput(ForeignEntityInput A_Depreciation) {
		this.mA_Depreciation = A_Depreciation;
		MDepreciation foreignEntity;
		if (A_Depreciation != null &&
				(foreignEntity = new Query(getCtx(), "A_Depreciation", "A_Depreciation_UU=?", get_TrxName())
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
	public ForeignEntityInput A_Depreciation() {
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
	public void setA_Depreciation_Method_FInput(ForeignEntityInput A_Depreciation_Method_F) {
		this.mA_Depreciation_Method_F = A_Depreciation_Method_F;
		MDepreciationMethod foreignEntity;
		if (A_Depreciation_Method_F != null &&
				(foreignEntity = new Query(getCtx(), "A_Depreciation_Method", "A_Depreciation_Method_UU=?", get_TrxName())
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
	public ForeignEntityInput A_Depreciation_Method_F() {
		return mA_Depreciation_Method_F;
	}

	/**
	 * Set Depreciation Method.
	 *
	 * @param A_Depreciation_Method Depreciation Method
	 */
	@JsonProperty("A_Depreciation_Method")
	public void setA_Depreciation_MethodInput(ForeignEntityInput A_Depreciation_Method) {
		this.mA_Depreciation_Method = A_Depreciation_Method;
		MDepreciationMethod foreignEntity;
		if (A_Depreciation_Method != null &&
				(foreignEntity = new Query(getCtx(), "A_Depreciation_Method", "A_Depreciation_Method_UU=?", get_TrxName())
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
	public ForeignEntityInput A_Depreciation_Method() {
		return mA_Depreciation_Method;
	}

	/**
	 * Set A_Depreciation_Table_Header_ID.
	 *
	 * @param A_Depreciation_Table_Header A_Depreciation_Table_Header_ID
	 */
	@JsonProperty("A_Depreciation_Table_Header")
	public void setA_Depreciation_Table_HeaderInput(ForeignEntityInput A_Depreciation_Table_Header) {
		this.mA_Depreciation_Table_Header = A_Depreciation_Table_Header;
		X_A_Depreciation_Table_Header foreignEntity;
		if (A_Depreciation_Table_Header != null &&
				(foreignEntity = new Query(getCtx(), "A_Depreciation_Table_Header", "A_Depreciation_Table_Header_UU=?", get_TrxName())
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
	public ForeignEntityInput A_Depreciation_Table_Header() {
		return mA_Depreciation_Table_Header;
	}

	/**
	 * Set Disposal Gain Acct.
	 *
	 * @param A_Disposal_Gain_A Disposal Gain Acct
	 */
	@JsonProperty("A_Disposal_Gain_A")
	public void setA_Disposal_Gain_AInput(ForeignEntityInput A_Disposal_Gain_A) {
		this.mA_Disposal_Gain_A = A_Disposal_Gain_A;
		MAccount foreignEntity;
		if (A_Disposal_Gain_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
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
	public ForeignEntityInput A_Disposal_Gain_A() {
		return mA_Disposal_Gain_A;
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
		if (A_Disposal_Loss_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
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
	public ForeignEntityInput A_Disposal_Loss_A() {
		return mA_Disposal_Loss_A;
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
		if (A_Disposal_Revenue_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
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
	public ForeignEntityInput A_Disposal_Revenue_A() {
		return mA_Disposal_Revenue_A;
	}

	/**
	 * Set A_Reval_Accumdep_Offset_Cur.
	 *
	 * @param A_Reval_Adep_Offset_Cur_A A_Reval_Accumdep_Offset_Cur
	 */
	@JsonProperty("A_Reval_Adep_Offset_Cur_A")
	public void setA_Reval_Adep_Offset_Cur_AInput(ForeignEntityInput A_Reval_Adep_Offset_Cur_A) {
		this.mA_Reval_Adep_Offset_Cur_A = A_Reval_Adep_Offset_Cur_A;
		MAccount foreignEntity;
		if (A_Reval_Adep_Offset_Cur_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
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
	public ForeignEntityInput A_Reval_Adep_Offset_Cur_A() {
		return mA_Reval_Adep_Offset_Cur_A;
	}

	/**
	 * Set A_Reval_Accumdep_Offset_Prior.
	 *
	 * @param A_Reval_Adep_Offset_Prior_A A_Reval_Accumdep_Offset_Prior
	 */
	@JsonProperty("A_Reval_Adep_Offset_Prior_A")
	public void setA_Reval_Adep_Offset_Prior_AInput(ForeignEntityInput A_Reval_Adep_Offset_Prior_A) {
		this.mA_Reval_Adep_Offset_Prior_A = A_Reval_Adep_Offset_Prior_A;
		MAccount foreignEntity;
		if (A_Reval_Adep_Offset_Prior_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
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
	public ForeignEntityInput A_Reval_Adep_Offset_Prior_A() {
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
	public void setA_Reval_Cost_Offset_AInput(ForeignEntityInput A_Reval_Cost_Offset_A) {
		this.mA_Reval_Cost_Offset_A = A_Reval_Cost_Offset_A;
		MAccount foreignEntity;
		if (A_Reval_Cost_Offset_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
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
	public ForeignEntityInput A_Reval_Cost_Offset_A() {
		return mA_Reval_Cost_Offset_A;
	}

	/**
	 * Set Reval Cost Offset Prior Acct.
	 *
	 * @param A_Reval_Cost_Offset_Prior_A Reval Cost Offset Prior Acct
	 */
	@JsonProperty("A_Reval_Cost_Offset_Prior_A")
	public void setA_Reval_Cost_Offset_Prior_AInput(ForeignEntityInput A_Reval_Cost_Offset_Prior_A) {
		this.mA_Reval_Cost_Offset_Prior_A = A_Reval_Cost_Offset_Prior_A;
		MAccount foreignEntity;
		if (A_Reval_Cost_Offset_Prior_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
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
	public ForeignEntityInput A_Reval_Cost_Offset_Prior_A() {
		return mA_Reval_Cost_Offset_Prior_A;
	}

	/**
	 * Set Reval Depexp Offset Acct.
	 *
	 * @param A_Reval_Depexp_Offset_A Reval Depexp Offset Acct
	 */
	@JsonProperty("A_Reval_Depexp_Offset_A")
	public void setA_Reval_Depexp_Offset_AInput(ForeignEntityInput A_Reval_Depexp_Offset_A) {
		this.mA_Reval_Depexp_Offset_A = A_Reval_Depexp_Offset_A;
		MAccount foreignEntity;
		if (A_Reval_Depexp_Offset_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
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
	public ForeignEntityInput A_Reval_Depexp_Offset_A() {
		return mA_Reval_Depexp_Offset_A;
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
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
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
		if (C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
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
	public ForeignEntityInput C_AcctSchema() {
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
	/**
	 * Set Valid from.
	 *
	 * @param ValidFrom Valid from including this date (first day)
	 */

	public void setValidFrom(Timestamp ValidFrom) {
		if (get_ID() == 0) {
			super.setValidFrom(ValidFrom);
		}
	}
}
