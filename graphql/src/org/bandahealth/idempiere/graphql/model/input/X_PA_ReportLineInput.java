package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_GL_Budget;
import org.compiere.model.X_PA_ReportLine;
import org.compiere.model.X_PA_ReportLineSet;
import org.compiere.util.Env;

/**
 * Generated Model for PA_ReportLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportLineInput extends X_PA_ReportLine implements I_PA_ReportLineInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput CalculationType_RL;
	 private I_AD_Ref_ListInput LineType_RL;
	 private I_AD_Ref_ListInput OverlineStrokeType_RL;
	 private I_AD_Ref_ListInput PAAmountType_RL;
	 private I_AD_Ref_ListInput PAPeriodType_RL;
	 private I_AD_Ref_ListInput PostingType_RL;
	 private I_AD_Ref_ListInput UnderlineStrokeType_RL;
	 private I_GL_BudgetInput GL_Budget;
	 private I_PA_ReportLineInput Oper_1;
	 private I_PA_ReportLineInput Oper_2;
	 private I_PA_ReportLineSetInput PA_ReportLineSet;

	/**
	 * Standard constructor
	 */
	public X_PA_ReportLineInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
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
	 * Set Calculation.
	 *
	 * @param CalculationType_RL Calculation
	 */
	public void setCalculationType_RL(I_AD_Ref_ListInput CalculationType_RL) {
		this.CalculationType_RL = CalculationType_RL;
		MRefList foreignEntity;
		if (CalculationType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CalculationType_RL.getID())
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
	public I_AD_Ref_ListInput getCalculationType_RL() {
		return CalculationType_RL;
	}

	/**
	 * Set Budget.
	 *
	 * @param GL_Budget General Ledger Budget
	 */
	public void setGL_Budget(I_GL_BudgetInput GL_Budget) {
		this.GL_Budget = GL_Budget;
		X_GL_Budget foreignEntity;
		if (GL_Budget != null &&
				(foreignEntity = new Query(getCtx(), X_GL_Budget.Table_Name, X_GL_Budget.COLUMNNAME_GL_Budget_UU + "=?", get_TrxName())
						.setParameters(GL_Budget.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setGL_Budget_ID(foreignEntity.get_ID());
		} else {
			this.setGL_Budget_ID(0);
		}
	}

	/**
	 * Get Budget.
	 *
	 * @return General Ledger Budget
	 */
	public I_GL_BudgetInput getGL_Budget() {
		return GL_Budget;
	}

	/**
	 * Set Line Type.
	 *
	 * @param LineType_RL Line Type
	 */
	public void setLineType_RL(I_AD_Ref_ListInput LineType_RL) {
		this.LineType_RL = LineType_RL;
		MRefList foreignEntity;
		if (LineType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(LineType_RL.getID())
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
	public I_AD_Ref_ListInput getLineType_RL() {
		return LineType_RL;
	}

	/**
	 * Set Operand 1.
	 *
	 * @param Oper_1 First operand for calculation
	 */
	public void setOper_1(I_PA_ReportLineInput Oper_1) {
		this.Oper_1 = Oper_1;
		X_PA_ReportLine foreignEntity;
		if (Oper_1 != null &&
				(foreignEntity = new Query(getCtx(), X_PA_ReportLine.Table_Name, X_PA_ReportLine.COLUMNNAME_PA_ReportLine_UU + "=?", get_TrxName())
						.setParameters(Oper_1.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setOper_1_ID(foreignEntity.get_ID());
		} else {
			this.setOper_1_ID(0);
		}
	}

	/**
	 * Get Operand 1.
	 *
	 * @return First operand for calculation
	 */
	public I_PA_ReportLineInput getOper_1() {
		return Oper_1;
	}
	/**
	 * Set Operand 1.
	 *
	 * @param Oper_1_ID First operand for calculation
	 */

	public void setOper_1_ID(int Oper_1_ID) {
		if (get_ID() == 0) {
			super.setOper_1_ID(Oper_1_ID);
		}
	}

	/**
	 * Set Operand 2.
	 *
	 * @param Oper_2 Second operand for calculation
	 */
	public void setOper_2(I_PA_ReportLineInput Oper_2) {
		this.Oper_2 = Oper_2;
		X_PA_ReportLine foreignEntity;
		if (Oper_2 != null &&
				(foreignEntity = new Query(getCtx(), X_PA_ReportLine.Table_Name, X_PA_ReportLine.COLUMNNAME_PA_ReportLine_UU + "=?", get_TrxName())
						.setParameters(Oper_2.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setOper_2_ID(foreignEntity.get_ID());
		} else {
			this.setOper_2_ID(0);
		}
	}

	/**
	 * Get Operand 2.
	 *
	 * @return Second operand for calculation
	 */
	public I_PA_ReportLineInput getOper_2() {
		return Oper_2;
	}
	/**
	 * Set Operand 2.
	 *
	 * @param Oper_2_ID Second operand for calculation
	 */

	public void setOper_2_ID(int Oper_2_ID) {
		if (get_ID() == 0) {
			super.setOper_2_ID(Oper_2_ID);
		}
	}

	/**
	 * Set Overline Stroke Type.
	 *
	 * @param OverlineStrokeType_RL Overline Stroke Type
	 */
	public void setOverlineStrokeType_RL(I_AD_Ref_ListInput OverlineStrokeType_RL) {
		this.OverlineStrokeType_RL = OverlineStrokeType_RL;
		MRefList foreignEntity;
		if (OverlineStrokeType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(OverlineStrokeType_RL.getID())
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
	public I_AD_Ref_ListInput getOverlineStrokeType_RL() {
		return OverlineStrokeType_RL;
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
	public void setPA_ReportLineSet(I_PA_ReportLineSetInput PA_ReportLineSet) {
		this.PA_ReportLineSet = PA_ReportLineSet;
		X_PA_ReportLineSet foreignEntity;
		if (get_ID() == 0 &&PA_ReportLineSet != null &&
				(foreignEntity = new Query(getCtx(), X_PA_ReportLineSet.Table_Name, X_PA_ReportLineSet.COLUMNNAME_PA_ReportLineSet_UU + "=?", get_TrxName())
						.setParameters(PA_ReportLineSet.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPA_ReportLineSet_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Report Line Set.
	 *
	 * @return Report Line Set
	 */
	public I_PA_ReportLineSetInput getPA_ReportLineSet() {
		return PA_ReportLineSet;
	}
	/**
	 * Set Report Line Set.
	 *
	 * @param PA_ReportLineSet_ID Report Line Set
	 */

	public void setPA_ReportLineSet_ID(int PA_ReportLineSet_ID) {
		if (get_ID() == 0) {
			super.setPA_ReportLineSet_ID(PA_ReportLineSet_ID);
		}
	}

	/**
	 * Set Amount Type.
	 *
	 * @param PAAmountType_RL PA Amount Type for reporting
	 */
	public void setPAAmountType_RL(I_AD_Ref_ListInput PAAmountType_RL) {
		this.PAAmountType_RL = PAAmountType_RL;
		MRefList foreignEntity;
		if (PAAmountType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PAAmountType_RL.getID())
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
	public I_AD_Ref_ListInput getPAAmountType_RL() {
		return PAAmountType_RL;
	}

	/**
	 * Set Period Type.
	 *
	 * @param PAPeriodType_RL PA Period Type
	 */
	public void setPAPeriodType_RL(I_AD_Ref_ListInput PAPeriodType_RL) {
		this.PAPeriodType_RL = PAPeriodType_RL;
		MRefList foreignEntity;
		if (PAPeriodType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PAPeriodType_RL.getID())
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
	public I_AD_Ref_ListInput getPAPeriodType_RL() {
		return PAPeriodType_RL;
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

	/**
	 * Set Underline Stroke Type.
	 *
	 * @param UnderlineStrokeType_RL Underline Stroke Type
	 */
	public void setUnderlineStrokeType_RL(I_AD_Ref_ListInput UnderlineStrokeType_RL) {
		this.UnderlineStrokeType_RL = UnderlineStrokeType_RL;
		MRefList foreignEntity;
		if (UnderlineStrokeType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(UnderlineStrokeType_RL.getID())
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
	public I_AD_Ref_ListInput getUnderlineStrokeType_RL() {
		return UnderlineStrokeType_RL;
	}
}
