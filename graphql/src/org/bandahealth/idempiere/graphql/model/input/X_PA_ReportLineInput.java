package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_GL_Budget;
import org.compiere.model.X_PA_ReportLine;
import org.compiere.model.X_PA_ReportLineSet;

import java.sql.ResultSet;

/**
 * Generated Model for PA_ReportLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportLineInput extends X_PA_ReportLine implements I_PA_ReportLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mGL_Budget;
	private ForeignEntityInput mOper_1;
	private ForeignEntityInput mOper_2;
	private ForeignEntityInput mPA_ReportLineSet;
	private I_AD_Ref_ListInput mCalculationType;
	private I_AD_Ref_ListInput mLineType;
	private I_AD_Ref_ListInput mOverlineStrokeType;
	private I_AD_Ref_ListInput mPAAmountType;
	private I_AD_Ref_ListInput mPAPeriodType;
	private I_AD_Ref_ListInput mPostingType;
	private I_AD_Ref_ListInput mUnderlineStrokeType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PA_ReportLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_PA_ReportLine(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
	 * Set Calculation.
	 *
	 * @param CalculationType Calculation
	 */
	@JsonProperty("CalculationType")
	public void setCalculationTypeInput(I_AD_Ref_ListInput CalculationType) {
		this.mCalculationType = CalculationType;
		MRefList_BH foreignEntity;
		if (CalculationType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CalculationType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setCalculationType(foreignEntity.getValue());
		} else {
			this.setCalculationType(null);
		}
	}

	/**
	 * Get Calculation.
	 *
	 * @return Calculation
	 */
	@JsonProperty("CalculationType")
	public I_AD_Ref_ListInput CalculationType() {
		return mCalculationType;
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
		if (GL_Budget != null &&
				(foreignEntity = new Query(getCtx(), "GL_Budget", "GL_Budget_UU=?", get_TrxName())
						.setParameters(GL_Budget.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setGL_Budget_ID(foreignEntity.get_ID());
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
	 * Set Line Type.
	 *
	 * @param LineType Line Type
	 */
	@JsonProperty("LineType")
	public void setLineTypeInput(I_AD_Ref_ListInput LineType) {
		this.mLineType = LineType;
		MRefList_BH foreignEntity;
		if (LineType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(LineType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setLineType(foreignEntity.getValue());
		} else {
			this.setLineType(null);
		}
	}

	/**
	 * Get Line Type.
	 *
	 * @return Line Type
	 */
	@JsonProperty("LineType")
	public I_AD_Ref_ListInput LineType() {
		return mLineType;
	}

	/**
	 * Set Operand 1.
	 *
	 * @param Oper_1 First operand for calculation
	 */
	@JsonProperty("Oper_1")
	public void setOper_1Input(ForeignEntityInput Oper_1) {
		this.mOper_1 = Oper_1;
		X_PA_ReportLine foreignEntity;
		if (Oper_1 != null &&
				(foreignEntity = new Query(getCtx(), "PA_ReportLine", "PA_ReportLine_UU=?", get_TrxName())
						.setParameters(Oper_1.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setOper_1_ID(foreignEntity.get_ID());
		} else {
			super.setOper_1_ID(0);
		}
	}

	/**
	 * Get Operand 1.
	 *
	 * @return First operand for calculation
	 */
	@JsonProperty("Oper_1")
	public ForeignEntityInput Oper_1() {
		return mOper_1;
	}

	/**
	 * Set Operand 2.
	 *
	 * @param Oper_2 Second operand for calculation
	 */
	@JsonProperty("Oper_2")
	public void setOper_2Input(ForeignEntityInput Oper_2) {
		this.mOper_2 = Oper_2;
		X_PA_ReportLine foreignEntity;
		if (Oper_2 != null &&
				(foreignEntity = new Query(getCtx(), "PA_ReportLine", "PA_ReportLine_UU=?", get_TrxName())
						.setParameters(Oper_2.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setOper_2_ID(foreignEntity.get_ID());
		} else {
			super.setOper_2_ID(0);
		}
	}

	/**
	 * Get Operand 2.
	 *
	 * @return Second operand for calculation
	 */
	@JsonProperty("Oper_2")
	public ForeignEntityInput Oper_2() {
		return mOper_2;
	}

	/**
	 * Set Overline Stroke Type.
	 *
	 * @param OverlineStrokeType Overline Stroke Type
	 */
	@JsonProperty("OverlineStrokeType")
	public void setOverlineStrokeTypeInput(I_AD_Ref_ListInput OverlineStrokeType) {
		this.mOverlineStrokeType = OverlineStrokeType;
		MRefList_BH foreignEntity;
		if (OverlineStrokeType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(OverlineStrokeType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setOverlineStrokeType(foreignEntity.getValue());
		} else {
			this.setOverlineStrokeType(null);
		}
	}

	/**
	 * Get Overline Stroke Type.
	 *
	 * @return Overline Stroke Type
	 */
	@JsonProperty("OverlineStrokeType")
	public I_AD_Ref_ListInput OverlineStrokeType() {
		return mOverlineStrokeType;
	}
	/**
	 * Set Report Line.
	 *
	 * @param PA_ReportLine_ID Report Line
	 */

	public void setPA_ReportLine_ID(int PA_ReportLine_ID) {
		if (get_ID() == 0) {
			super.setPA_ReportLine_ID(PA_ReportLine_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPA_ReportLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPA_ReportLine_UU();
	}

	/**
	 * Set Report Line Set.
	 *
	 * @param PA_ReportLineSet Report Line Set
	 */
	@JsonProperty("PA_ReportLineSet")
	public void setPA_ReportLineSetInput(ForeignEntityInput PA_ReportLineSet) {
		this.mPA_ReportLineSet = PA_ReportLineSet;
		X_PA_ReportLineSet foreignEntity;
		if (get_ID() == 0 && PA_ReportLineSet != null &&
				(foreignEntity = new Query(getCtx(), "PA_ReportLineSet", "PA_ReportLineSet_UU=?", get_TrxName())
						.setParameters(PA_ReportLineSet.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPA_ReportLineSet_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Report Line Set.
	 *
	 * @return Report Line Set
	 */
	@JsonProperty("PA_ReportLineSet")
	public ForeignEntityInput PA_ReportLineSet() {
		return mPA_ReportLineSet;
	}

	/**
	 * Set Amount Type.
	 *
	 * @param PAAmountType PA Amount Type for reporting
	 */
	@JsonProperty("PAAmountType")
	public void setPAAmountTypeInput(I_AD_Ref_ListInput PAAmountType) {
		this.mPAAmountType = PAAmountType;
		MRefList_BH foreignEntity;
		if (PAAmountType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PAAmountType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPAAmountType(foreignEntity.getValue());
		} else {
			this.setPAAmountType(null);
		}
	}

	/**
	 * Get Amount Type.
	 *
	 * @return PA Amount Type for reporting
	 */
	@JsonProperty("PAAmountType")
	public I_AD_Ref_ListInput PAAmountType() {
		return mPAAmountType;
	}

	/**
	 * Set Period Type.
	 *
	 * @param PAPeriodType PA Period Type
	 */
	@JsonProperty("PAPeriodType")
	public void setPAPeriodTypeInput(I_AD_Ref_ListInput PAPeriodType) {
		this.mPAPeriodType = PAPeriodType;
		MRefList_BH foreignEntity;
		if (PAPeriodType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PAPeriodType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPAPeriodType(foreignEntity.getValue());
		} else {
			this.setPAPeriodType(null);
		}
	}

	/**
	 * Get Period Type.
	 *
	 * @return PA Period Type
	 */
	@JsonProperty("PAPeriodType")
	public I_AD_Ref_ListInput PAPeriodType() {
		return mPAPeriodType;
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
	 * Set Underline Stroke Type.
	 *
	 * @param UnderlineStrokeType Underline Stroke Type
	 */
	@JsonProperty("UnderlineStrokeType")
	public void setUnderlineStrokeTypeInput(I_AD_Ref_ListInput UnderlineStrokeType) {
		this.mUnderlineStrokeType = UnderlineStrokeType;
		MRefList_BH foreignEntity;
		if (UnderlineStrokeType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(UnderlineStrokeType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setUnderlineStrokeType(foreignEntity.getValue());
		} else {
			this.setUnderlineStrokeType(null);
		}
	}

	/**
	 * Get Underline Stroke Type.
	 *
	 * @return Underline Stroke Type
	 */
	@JsonProperty("UnderlineStrokeType")
	public I_AD_Ref_ListInput UnderlineStrokeType() {
		return mUnderlineStrokeType;
	}
}
