package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
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
 * @version Release 7.1 - $Id$
 */
public class X_AD_PrintLabelLineInput extends X_AD_PrintLabelLine implements I_AD_PrintLabelLineInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_LabelPrinterFunction;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PrintLabel;
	private I_AD_Ref_ListInput mLabelFormatType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_PrintLabelLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_PrintLabelLineInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_AD_PrintLabelLine(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
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
							.setParameters(AD_Column.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Column_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Column with UUID " + AD_Column.getUUID());
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
							.setParameters(AD_LabelPrinterFunction.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_LabelPrinterFunction_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_LabelPrinterFunction with UUID " + AD_LabelPrinterFunction.getUUID());
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
	 * Set Print Label.
	 *
	 * @param AD_PrintLabel Label Format to print
	 */
	@JsonProperty("AD_PrintLabel")
	public void setAD_PrintLabelInput(ForeignEntityInput AD_PrintLabel) {
		this.mAD_PrintLabel = AD_PrintLabel;
		if (get_ID() != 0) {
			return;
		}
		if (AD_PrintLabel != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintLabel foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintLabel", "AD_PrintLabel_UU=?", get_TrxName())
							.setParameters(AD_PrintLabel.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_PrintLabel_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintLabel with UUID " + AD_PrintLabel.getUUID());
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

	public void setAD_PrintLabelLine_ID(int AD_PrintLabelLine_ID) {
		if (get_ID() == 0) {
			super.setAD_PrintLabelLine_ID(AD_PrintLabelLine_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_PrintLabelLine_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (LabelFormatType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(LabelFormatType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setLabelFormatType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + LabelFormatType.getUUID());
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
	public I_AD_Ref_ListInput LabelFormatType() {
		return mLabelFormatType;
	}
}
