package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_LabelPrinterFunction;
import org.compiere.model.X_AD_PrintLabel;
import org.compiere.model.X_AD_PrintLabelLine;

import java.sql.ResultSet;

/**
 * Generated Model for AD_PrintLabelLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_PrintLabelLineInput extends X_AD_PrintLabelLine implements I_AD_PrintLabelLineInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_LabelPrinterFunction;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PrintLabel;
	private I_AD_Ref_ListInput mLabelFormatType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_PrintLabelLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_PrintLabelLine(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Column.
	 *
	 * @param AD_Column Column in the table
	 */
	@JsonProperty("AD_Column")
	public void setAD_ColumnInput(ForeignEntityInput AD_Column) {
		this.mAD_Column = AD_Column;
		MColumn foreignEntity;
		if (AD_Column != null &&
				(foreignEntity = new Query(getCtx(), "AD_Column", "AD_Column_UU=?", get_TrxName())
						.setParameters(AD_Column.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Column_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Column_ID(0);
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
		X_AD_LabelPrinterFunction foreignEntity;
		if (AD_LabelPrinterFunction != null &&
				(foreignEntity = new Query(getCtx(), "AD_LabelPrinterFunction", "AD_LabelPrinterFunction_UU=?", get_TrxName())
						.setParameters(AD_LabelPrinterFunction.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_LabelPrinterFunction_ID(foreignEntity.get_ID());
		} else {
			super.setAD_LabelPrinterFunction_ID(0);
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
	 * Set Print Label.
	 *
	 * @param AD_PrintLabel Label Format to print
	 */
	@JsonProperty("AD_PrintLabel")
	public void setAD_PrintLabelInput(ForeignEntityInput AD_PrintLabel) {
		this.mAD_PrintLabel = AD_PrintLabel;
		X_AD_PrintLabel foreignEntity;
		if (get_ID() == 0 && AD_PrintLabel != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintLabel", "AD_PrintLabel_UU=?", get_TrxName())
						.setParameters(AD_PrintLabel.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PrintLabel_ID(foreignEntity.get_ID());
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

	public void setAD_PrintLabelLine_ID(int AD_PrintLabelLine_ID) {
		if (get_ID() == 0) {
			super.setAD_PrintLabelLine_ID(AD_PrintLabelLine_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_PrintLabelLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getAD_PrintLabelLine_UU();
	}

	/**
	 * Set Label Format Type.
	 *
	 * @param LabelFormatType Label Format Type
	 */
	@JsonProperty("LabelFormatType")
	public void setLabelFormatTypeInput(I_AD_Ref_ListInput LabelFormatType) {
		this.mLabelFormatType = LabelFormatType;
		MRefList_BH foreignEntity;
		if (LabelFormatType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(LabelFormatType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setLabelFormatType(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput LabelFormatType() {
		return mLabelFormatType;
	}
}
