package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_GL_Budget;
import org.compiere.report.MReportLine;
import org.compiere.report.MReportLineSet;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for PA_ReportLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportLineInput extends MReportLine implements I_PA_ReportLineInput {

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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The PA_ReportLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PA_ReportLineInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
		if (CalculationType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(CalculationType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setCalculationType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + CalculationType.getUUID());
			}
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
		if (GL_Budget != null) {
			// Since an entity was passed, make sure it's in the DB
			X_GL_Budget foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "GL_Budget", "GL_Budget_UU=?", get_TrxName())
							.setParameters(GL_Budget.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setGL_Budget_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table GL_Budget with UUID " + GL_Budget.getUUID());
			}
		} else {
			this.setGL_Budget_ID(0);
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
		if (LineType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(LineType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setLineType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + LineType.getUUID());
			}
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
		if (Oper_1 != null) {
			// Since an entity was passed, make sure it's in the DB
			MReportLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_ReportLine", "PA_ReportLine_UU=?", get_TrxName())
							.setParameters(Oper_1.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setOper_1_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_ReportLine with UUID " + Oper_1.getUUID());
			}
		} else {
			this.setOper_1_ID(0);
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
		if (Oper_2 != null) {
			// Since an entity was passed, make sure it's in the DB
			MReportLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_ReportLine", "PA_ReportLine_UU=?", get_TrxName())
							.setParameters(Oper_2.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setOper_2_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_ReportLine with UUID " + Oper_2.getUUID());
			}
		} else {
			this.setOper_2_ID(0);
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
		if (OverlineStrokeType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(OverlineStrokeType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setOverlineStrokeType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + OverlineStrokeType.getUUID());
			}
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setPA_ReportLine_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (get_ID() != 0) {
			return;
		}
		if (PA_ReportLineSet != null) {
			// Since an entity was passed, make sure it's in the DB
			MReportLineSet foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_ReportLineSet", "PA_ReportLineSet_UU=?", get_TrxName())
							.setParameters(PA_ReportLineSet.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPA_ReportLineSet_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_ReportLineSet with UUID " + PA_ReportLineSet.getUUID());
			}
		} else {
			this.setPA_ReportLineSet_ID(0);
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
		if (PAAmountType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PAAmountType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPAAmountType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + PAAmountType.getUUID());
			}
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
		if (PAPeriodType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PAPeriodType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPAPeriodType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + PAPeriodType.getUUID());
			}
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
		if (PostingType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
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
	 * Set Underline Stroke Type.
	 *
	 * @param UnderlineStrokeType Underline Stroke Type
	 */
	@JsonProperty("UnderlineStrokeType")
	public void setUnderlineStrokeTypeInput(I_AD_Ref_ListInput UnderlineStrokeType) {
		this.mUnderlineStrokeType = UnderlineStrokeType;
		if (UnderlineStrokeType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(UnderlineStrokeType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setUnderlineStrokeType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + UnderlineStrokeType.getUUID());
			}
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
