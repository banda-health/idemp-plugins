package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_AD_PrintFormatItemResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MOrg;
import org.compiere.model.MStyle;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.model.X_AD_PrintFont;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_AD_PrintFormatItem;
import org.compiere.model.X_AD_PrintGraph;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_PrintFormatItem - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_PrintFormatItemInput extends X_AD_PrintFormatItem implements I_AD_PrintFormatItemInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_FieldStyle;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PrintColor;
	private ForeignEntityInput mAD_PrintFont;
	private ForeignEntityInput mAD_PrintFormat;
	private ForeignEntityInput mAD_PrintFormatChild;
	private ForeignEntityInput mAD_PrintGraph;
	private ForeignEntityInput mBarcodeType;
	private ForeignEntityInput mFieldAlignmentType;
	private ForeignEntityInput mLineAlignmentType;
	private ForeignEntityInput mPrintAreaType;
	private ForeignEntityInput mPrintFormatType;
	private ForeignEntityInput mShapeType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_PrintFormatItem_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_PrintFormatItemInput(@JsonProperty("UU") String UU) {
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
	 * Set Field Style.
	 *
	 * @param AD_FieldStyle Field CSS Style 
	 */
	@JsonProperty("AD_FieldStyle")
	public void setAD_FieldStyleInput(ForeignEntityInput AD_FieldStyle) {
		this.mAD_FieldStyle = AD_FieldStyle;
		if (AD_FieldStyle != null) {
			// Since an entity was passed, make sure it's in the DB
			MStyle foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Style", "AD_Style_UU=?", get_TrxName())
							.setParameters(AD_FieldStyle.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_FieldStyle_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Style with UU " + AD_FieldStyle.getUU());
			}
		} else {
			this.setAD_FieldStyle_ID(0);
		}
	}

	/**
	 * Get Field Style.
	 *
	 * @return Field CSS Style 
	 */
	@JsonProperty("AD_FieldStyle")
	public ForeignEntityInput AD_FieldStyle() {
		return mAD_FieldStyle;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
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
	 * Set Print Color.
	 *
	 * @param AD_PrintColor Color used for printing and display
	 */
	@JsonProperty("AD_PrintColor")
	public void setAD_PrintColorInput(ForeignEntityInput AD_PrintColor) {
		this.mAD_PrintColor = AD_PrintColor;
		if (AD_PrintColor != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintColor foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
							.setParameters(AD_PrintColor.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_PrintColor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintColor with UU " + AD_PrintColor.getUU());
			}
		} else {
			this.setAD_PrintColor_ID(0);
		}
	}

	/**
	 * Get Print Color.
	 *
	 * @return Color used for printing and display
	 */
	@JsonProperty("AD_PrintColor")
	public ForeignEntityInput AD_PrintColor() {
		return mAD_PrintColor;
	}

	/**
	 * Set Print Font.
	 *
	 * @param AD_PrintFont Maintain Print Font
	 */
	@JsonProperty("AD_PrintFont")
	public void setAD_PrintFontInput(ForeignEntityInput AD_PrintFont) {
		this.mAD_PrintFont = AD_PrintFont;
		if (AD_PrintFont != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFont foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFont", "AD_PrintFont_UU=?", get_TrxName())
							.setParameters(AD_PrintFont.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_PrintFont_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFont with UU " + AD_PrintFont.getUU());
			}
		} else {
			this.setAD_PrintFont_ID(0);
		}
	}

	/**
	 * Get Print Font.
	 *
	 * @return Maintain Print Font
	 */
	@JsonProperty("AD_PrintFont")
	public ForeignEntityInput AD_PrintFont() {
		return mAD_PrintFont;
	}

	/**
	 * Set Print Format.
	 *
	 * @param AD_PrintFormat Data Print Format
	 */
	@JsonProperty("AD_PrintFormat")
	public void setAD_PrintFormatInput(ForeignEntityInput AD_PrintFormat) {
		this.mAD_PrintFormat = AD_PrintFormat;
		if (get_ID() != 0) {
			return;
		}
		if (AD_PrintFormat != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFormat foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
							.setParameters(AD_PrintFormat.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_PrintFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormat with UU " + AD_PrintFormat.getUU());
			}
		} else {
			this.setAD_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Print Format.
	 *
	 * @return Data Print Format
	 */
	@JsonProperty("AD_PrintFormat")
	public ForeignEntityInput AD_PrintFormat() {
		return mAD_PrintFormat;
	}

	/**
	 * Set Included Print Format.
	 *
	 * @param AD_PrintFormatChild Print format that is included here.
	 */
	@JsonProperty("AD_PrintFormatChild")
	public void setAD_PrintFormatChildInput(ForeignEntityInput AD_PrintFormatChild) {
		this.mAD_PrintFormatChild = AD_PrintFormatChild;
		if (AD_PrintFormatChild != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintFormat foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
							.setParameters(AD_PrintFormatChild.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_PrintFormatChild_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormat with UU " + AD_PrintFormatChild.getUU());
			}
		} else {
			this.setAD_PrintFormatChild_ID(0);
		}
	}

	/**
	 * Get Included Print Format.
	 *
	 * @return Print format that is included here.
	 */
	@JsonProperty("AD_PrintFormatChild")
	public ForeignEntityInput AD_PrintFormatChild() {
		return mAD_PrintFormatChild;
	}
	/**
	 * Set Print Format Item.
	 *
	 * @param AD_PrintFormatItem_ID Item/Column in the Print format
	 */
	@JsonProperty("AD_PrintFormatItem_ID")
	public void setAD_PrintFormatItem_IDFromJson(int AD_PrintFormatItem_ID) {
		if (get_ID() == 0) {
			super.setAD_PrintFormatItem_ID(AD_PrintFormatItem_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_PrintFormatItem_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_PrintFormatItem_UU();
	}

	/**
	 * Set Graph.
	 *
	 * @param AD_PrintGraph Graph included in Reports
	 */
	@JsonProperty("AD_PrintGraph")
	public void setAD_PrintGraphInput(ForeignEntityInput AD_PrintGraph) {
		this.mAD_PrintGraph = AD_PrintGraph;
		if (AD_PrintGraph != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_PrintGraph foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintGraph", "AD_PrintGraph_UU=?", get_TrxName())
							.setParameters(AD_PrintGraph.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_PrintGraph_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintGraph with UU " + AD_PrintGraph.getUU());
			}
		} else {
			this.setAD_PrintGraph_ID(0);
		}
	}

	/**
	 * Get Graph.
	 *
	 * @return Graph included in Reports
	 */
	@JsonProperty("AD_PrintGraph")
	public ForeignEntityInput AD_PrintGraph() {
		return mAD_PrintGraph;
	}

	/**
	 * Set Barcode Type.
	 *
	 * @param BarcodeType Type of barcode
	 */
	@JsonProperty("BarcodeType")
	public void setBarcodeTypeInput(ForeignEntityInput BarcodeType) {
		this.mBarcodeType = BarcodeType;
		if (BarcodeType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_PrintFormatItemResolver.BARCODETYPE_UUIDS_BY_VALUE.containsValue(BarcodeType.getUU())) {
				throw new AdempiereException("The reference list UU of " + BarcodeType.getUU() +
						" is not in the list defined for the BarcodeType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BarcodeType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBarcodeType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + BarcodeType.getUU());
			}
		} else {
			this.setBarcodeType(null);
		}
	}

	/**
	 * Get Barcode Type.
	 *
	 * @return Type of barcode
	 */
	@JsonProperty("BarcodeType")
	public ForeignEntityInput BarcodeType() {
		return mBarcodeType;
	}

	/**
	 * Set Field Alignment.
	 *
	 * @param FieldAlignmentType Field Text Alignment
	 */
	@JsonProperty("FieldAlignmentType")
	public void setFieldAlignmentTypeInput(ForeignEntityInput FieldAlignmentType) {
		this.mFieldAlignmentType = FieldAlignmentType;
		if (FieldAlignmentType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_PrintFormatItemResolver.FIELDALIGNMENTTYPE_UUIDS_BY_VALUE.containsValue(FieldAlignmentType.getUU())) {
				throw new AdempiereException("The reference list UU of " + FieldAlignmentType.getUU() +
						" is not in the list defined for the FieldAlignmentType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(FieldAlignmentType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setFieldAlignmentType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + FieldAlignmentType.getUU());
			}
		} else {
			this.setFieldAlignmentType(null);
		}
	}

	/**
	 * Get Field Alignment.
	 *
	 * @return Field Text Alignment
	 */
	@JsonProperty("FieldAlignmentType")
	public ForeignEntityInput FieldAlignmentType() {
		return mFieldAlignmentType;
	}

	/**
	 * Set Line Alignment.
	 *
	 * @param LineAlignmentType Line Alignment
	 */
	@JsonProperty("LineAlignmentType")
	public void setLineAlignmentTypeInput(ForeignEntityInput LineAlignmentType) {
		this.mLineAlignmentType = LineAlignmentType;
		if (LineAlignmentType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_PrintFormatItemResolver.LINEALIGNMENTTYPE_UUIDS_BY_VALUE.containsValue(LineAlignmentType.getUU())) {
				throw new AdempiereException("The reference list UU of " + LineAlignmentType.getUU() +
						" is not in the list defined for the LineAlignmentType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(LineAlignmentType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setLineAlignmentType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + LineAlignmentType.getUU());
			}
		} else {
			this.setLineAlignmentType(null);
		}
	}

	/**
	 * Get Line Alignment.
	 *
	 * @return Line Alignment
	 */
	@JsonProperty("LineAlignmentType")
	public ForeignEntityInput LineAlignmentType() {
		return mLineAlignmentType;
	}

	/**
	 * Set Area.
	 *
	 * @param PrintAreaType Print Area
	 */
	@JsonProperty("PrintAreaType")
	public void setPrintAreaTypeInput(ForeignEntityInput PrintAreaType) {
		this.mPrintAreaType = PrintAreaType;
		if (PrintAreaType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_PrintFormatItemResolver.PRINTAREATYPE_UUIDS_BY_VALUE.containsValue(PrintAreaType.getUU())) {
				throw new AdempiereException("The reference list UU of " + PrintAreaType.getUU() +
						" is not in the list defined for the PrintAreaType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PrintAreaType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPrintAreaType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + PrintAreaType.getUU());
			}
		} else {
			this.setPrintAreaType(null);
		}
	}

	/**
	 * Get Area.
	 *
	 * @return Print Area
	 */
	@JsonProperty("PrintAreaType")
	public ForeignEntityInput PrintAreaType() {
		return mPrintAreaType;
	}

	/**
	 * Set Format Type.
	 *
	 * @param PrintFormatType Print Format Type
	 */
	@JsonProperty("PrintFormatType")
	public void setPrintFormatTypeInput(ForeignEntityInput PrintFormatType) {
		this.mPrintFormatType = PrintFormatType;
		if (PrintFormatType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_PrintFormatItemResolver.PRINTFORMATTYPE_UUIDS_BY_VALUE.containsValue(PrintFormatType.getUU())) {
				throw new AdempiereException("The reference list UU of " + PrintFormatType.getUU() +
						" is not in the list defined for the PrintFormatType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PrintFormatType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPrintFormatType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + PrintFormatType.getUU());
			}
		} else {
			this.setPrintFormatType(null);
		}
	}

	/**
	 * Get Format Type.
	 *
	 * @return Print Format Type
	 */
	@JsonProperty("PrintFormatType")
	public ForeignEntityInput PrintFormatType() {
		return mPrintFormatType;
	}

	/**
	 * Set Shape Type.
	 *
	 * @param ShapeType Type of the shape to be painted
	 */
	@JsonProperty("ShapeType")
	public void setShapeTypeInput(ForeignEntityInput ShapeType) {
		this.mShapeType = ShapeType;
		if (ShapeType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_AD_PrintFormatItemResolver.SHAPETYPE_UUIDS_BY_VALUE.containsValue(ShapeType.getUU())) {
				throw new AdempiereException("The reference list UU of " + ShapeType.getUU() +
						" is not in the list defined for the ShapeType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ShapeType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setShapeType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + ShapeType.getUU());
			}
		} else {
			this.setShapeType(null);
		}
	}

	/**
	 * Get Shape Type.
	 *
	 * @return Type of the shape to be painted
	 */
	@JsonProperty("ShapeType")
	public ForeignEntityInput ShapeType() {
		return mShapeType;
	}
}
