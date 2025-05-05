package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_PrintLabelLineResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_LabelPrinterFunction;
import org.compiere.model.X_AD_PrintLabel;
import org.compiere.model.X_AD_PrintLabelLine;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_PrintLabelLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_PrintLabelLineInput extends X_AD_PrintLabelLine implements I_AD_PrintLabelLineInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_LabelPrinterFunction;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PrintLabel;
	private ForeignEntityInput mLabelFormatType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_PrintLabelLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_PrintLabelLineInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Column.
	 *
	 * @param AD_Column Column in the table
	 */
	@JsonProperty("AD_Column")
	public void setAD_ColumnInput(ForeignEntityInput AD_Column) {
		this.mAD_Column = AD_Column;
		if (AD_Column != null) {
			// Since an entity was passed, make sure it's in the DB
			MColumn foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Column", "AD_Column_UU=?", get_TrxName())
							.setParameters(AD_Column.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Column_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Column with UU " + AD_Column.getUU());
			}
		} else {
			this.setAD_Column_ID(0);
		}
	}

	/**
	 * Get Column.
	 *
	 * @return Column in the table
	 */
	@JsonProperty("AD_Column")
	public ForeignEntityInput AD_Column() {
		return mAD_Column;
	}

	/**
	 * Set Label printer Function.
	 *
	 * @param AD_LabelPrinterFunction Function of Label Printer
	 */
	@JsonProperty("AD_LabelPrinterFunction")
	public void setAD_LabelPrinterFunctionInput(ForeignEntityInput AD_LabelPrinterFunction) {
		this.mAD_LabelPrinterFunction = AD_LabelPrinterFunction;
		if (AD_LabelPrinterFunction != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_LabelPrinterFunction foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_LabelPrinterFunction", "AD_LabelPrinterFunction_UU=?", get_TrxName())
							.setParameters(AD_LabelPrinterFunction.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_LabelPrinterFunction_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_LabelPrinterFunction with UU " + AD_LabelPrinterFunction.getUU());
			}
		} else {
			this.setAD_LabelPrinterFunction_ID(0);
		}
	}

	/**
	 * Get Label printer Function.
	 *
	 * @return Function of Label Printer
	 */
	@JsonProperty("AD_LabelPrinterFunction")
	public ForeignEntityInput AD_LabelPrinterFunction() {
		return mAD_LabelPrinterFunction;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (!is_new()) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Print Label.
	 *
	 * @param AD_PrintLabel Label Format to print
	 */
	@JsonProperty("AD_PrintLabel")
	public void setAD_PrintLabelInput(ForeignEntityInput AD_PrintLabel) {
		this.mAD_PrintLabel = AD_PrintLabel;
		if (!is_new()) {
			return;
		}
		if (AD_PrintLabel != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintLabel foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintLabel", "AD_PrintLabel_UU=?", get_TrxName())
							.setParameters(AD_PrintLabel.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_PrintLabel_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintLabel with UU " + AD_PrintLabel.getUU());
			}
		} else {
			this.setAD_PrintLabel_ID(0);
		}
	}

	/**
	 * Get Print Label.
	 *
	 * @return Label Format to print
	 */
	@JsonProperty("AD_PrintLabel")
	public ForeignEntityInput AD_PrintLabel() {
		return mAD_PrintLabel;
	}
	/**
	 * Set Print Label Line.
	 *
	 * @param AD_PrintLabelLine_ID Print Label Line Format
	 */
	@JsonProperty("AD_PrintLabelLine_ID")
	public void setAD_PrintLabelLine_IDFromJson(int AD_PrintLabelLine_ID) {
		if (get_ID() == 0) {
			super.setAD_PrintLabelLine_ID(AD_PrintLabelLine_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_PrintLabelLine_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_PrintLabelLine_UU();
	}

	/**
	 * Set Label Format Type.
	 *
	 * @param LabelFormatType Label Format Type
	 */
	@JsonProperty("LabelFormatType")
	public void setLabelFormatTypeInput(ForeignEntityInput LabelFormatType) {
		this.mLabelFormatType = LabelFormatType;
		if (LabelFormatType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_PrintLabelLineResolver.LABELFORMATTYPE_UUIDS_BY_VALUE.containsValue(LabelFormatType.getUU())) {
				throw new AdempiereException("The reference list UU of " + LabelFormatType.getUU() +
						" is not in the list defined for the LabelFormatType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(LabelFormatType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setLabelFormatType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + LabelFormatType.getUU());
			}
		} else {
			this.setLabelFormatType(null);
		}
	}

	/**
	 * Get Label Format Type.
	 *
	 * @return Label Format Type
	 */
	@JsonProperty("LabelFormatType")
	public ForeignEntityInput LabelFormatType() {
		return mLabelFormatType;
	}
}
