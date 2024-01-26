package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MElementValue;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_I_ReportLine;
import org.compiere.report.MReportLine;
import org.compiere.report.MReportLineSet;
import org.compiere.report.MReportSource;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for I_ReportLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_ReportLineInput extends X_I_ReportLine implements I_I_ReportLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_ElementValue;
	private ForeignEntityInput mPA_ReportLine;
	private ForeignEntityInput mPA_ReportLineSet;
	private ForeignEntityInput mPA_ReportSource;
	private I_AD_Ref_ListInput mCalculationType;
	private I_AD_Ref_ListInput mLineType;
	private I_AD_Ref_ListInput mPAAmountType;
	private I_AD_Ref_ListInput mPAPeriodType;
	private I_AD_Ref_ListInput mPostingType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The I_ReportLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_I_ReportLineInput(@JsonProperty("UUID") String UUID) {
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
	 * Set Account Element.
	 *
	 * @param C_ElementValue Account Element
	 */
	@JsonProperty("C_ElementValue")
	public void setC_ElementValueInput(ForeignEntityInput C_ElementValue) {
		this.mC_ElementValue = C_ElementValue;
		if (C_ElementValue != null) {
			// Since an entity was passed, make sure it's in the DB
			MElementValue foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
							.setParameters(C_ElementValue.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_ElementValue_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UUID " + C_ElementValue.getUUID());
			}
		} else {
			this.setC_ElementValue_ID(0);
		}
	}

	/**
	 * Get Account Element.
	 *
	 * @return Account Element
	 */
	@JsonProperty("C_ElementValue")
	public ForeignEntityInput C_ElementValue() {
		return mC_ElementValue;
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
	 * Set Import Report Line Set.
	 *
	 * @param I_ReportLine_ID Import Report Line Set values
	 */

	public void setI_ReportLine_ID(int I_ReportLine_ID) {
		if (get_ID() == 0) {
			super.setI_ReportLine_ID(I_ReportLine_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setI_ReportLine_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getI_ReportLine_UU();
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
	 * Set Report Line.
	 *
	 * @param PA_ReportLine Report Line
	 */
	@JsonProperty("PA_ReportLine")
	public void setPA_ReportLineInput(ForeignEntityInput PA_ReportLine) {
		this.mPA_ReportLine = PA_ReportLine;
		if (PA_ReportLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MReportLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_ReportLine", "PA_ReportLine_UU=?", get_TrxName())
							.setParameters(PA_ReportLine.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPA_ReportLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_ReportLine with UUID " + PA_ReportLine.getUUID());
			}
		} else {
			this.setPA_ReportLine_ID(0);
		}
	}

	/**
	 * Get Report Line.
	 *
	 * @return Report Line
	 */
	@JsonProperty("PA_ReportLine")
	public ForeignEntityInput PA_ReportLine() {
		return mPA_ReportLine;
	}

	/**
	 * Set Report Line Set.
	 *
	 * @param PA_ReportLineSet Report Line Set
	 */
	@JsonProperty("PA_ReportLineSet")
	public void setPA_ReportLineSetInput(ForeignEntityInput PA_ReportLineSet) {
		this.mPA_ReportLineSet = PA_ReportLineSet;
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
	 * Set Report Source.
	 *
	 * @param PA_ReportSource Restriction of what will be shown in Report Line
	 */
	@JsonProperty("PA_ReportSource")
	public void setPA_ReportSourceInput(ForeignEntityInput PA_ReportSource) {
		this.mPA_ReportSource = PA_ReportSource;
		if (PA_ReportSource != null) {
			// Since an entity was passed, make sure it's in the DB
			MReportSource foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_ReportSource", "PA_ReportSource_UU=?", get_TrxName())
							.setParameters(PA_ReportSource.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPA_ReportSource_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_ReportSource with UUID " + PA_ReportSource.getUUID());
			}
		} else {
			this.setPA_ReportSource_ID(0);
		}
	}

	/**
	 * Get Report Source.
	 *
	 * @return Restriction of what will be shown in Report Line
	 */
	@JsonProperty("PA_ReportSource")
	public ForeignEntityInput PA_ReportSource() {
		return mPA_ReportSource;
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
}
