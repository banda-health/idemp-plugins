package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MColumn;
import org.compiere.model.MOrg;
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
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintFormatItemInput extends X_AD_PrintFormatItem implements I_AD_PrintFormatItemInput {

	private ForeignEntityInput mAD_Column;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PrintColor;
	private ForeignEntityInput mAD_PrintFont;
	private ForeignEntityInput mAD_PrintFormat;
	private ForeignEntityInput mAD_PrintFormatChild;
	private ForeignEntityInput mAD_PrintGraph;
	private I_AD_Ref_ListInput mBarcodeType;
	private I_AD_Ref_ListInput mFieldAlignmentType;
	private I_AD_Ref_ListInput mLineAlignmentType;
	private I_AD_Ref_ListInput mPrintAreaType;
	private I_AD_Ref_ListInput mPrintFormatType;
	private I_AD_Ref_ListInput mShapeType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_PrintFormatItem_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_PrintFormatItemInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_AD_PrintFormatItem(null, (ResultSet) null, null),
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
							.setParameters(AD_PrintColor.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_PrintColor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintColor with UUID " + AD_PrintColor.getUUID());
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
							.setParameters(AD_PrintFont.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_PrintFont_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFont with UUID " + AD_PrintFont.getUUID());
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
							.setParameters(AD_PrintFormat.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_PrintFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormat with UUID " + AD_PrintFormat.getUUID());
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
							.setParameters(AD_PrintFormatChild.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_PrintFormatChild_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormat with UUID " + AD_PrintFormatChild.getUUID());
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

	public void setAD_PrintFormatItem_ID(int AD_PrintFormatItem_ID) {
		if (get_ID() == 0) {
			super.setAD_PrintFormatItem_ID(AD_PrintFormatItem_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_PrintFormatItem_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
							.setParameters(AD_PrintGraph.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_PrintGraph_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintGraph with UUID " + AD_PrintGraph.getUUID());
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
	public void setBarcodeTypeInput(I_AD_Ref_ListInput BarcodeType) {
		this.mBarcodeType = BarcodeType;
		if (BarcodeType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BarcodeType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setBarcodeType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + BarcodeType.getUUID());
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
	public I_AD_Ref_ListInput BarcodeType() {
		return mBarcodeType;
	}

	/**
	 * Set Field Alignment.
	 *
	 * @param FieldAlignmentType Field Text Alignment
	 */
	@JsonProperty("FieldAlignmentType")
	public void setFieldAlignmentTypeInput(I_AD_Ref_ListInput FieldAlignmentType) {
		this.mFieldAlignmentType = FieldAlignmentType;
		if (FieldAlignmentType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(FieldAlignmentType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setFieldAlignmentType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + FieldAlignmentType.getUUID());
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
	public I_AD_Ref_ListInput FieldAlignmentType() {
		return mFieldAlignmentType;
	}

	/**
	 * Set Line Alignment.
	 *
	 * @param LineAlignmentType Line Alignment
	 */
	@JsonProperty("LineAlignmentType")
	public void setLineAlignmentTypeInput(I_AD_Ref_ListInput LineAlignmentType) {
		this.mLineAlignmentType = LineAlignmentType;
		if (LineAlignmentType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(LineAlignmentType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setLineAlignmentType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + LineAlignmentType.getUUID());
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
	public I_AD_Ref_ListInput LineAlignmentType() {
		return mLineAlignmentType;
	}

	/**
	 * Set Area.
	 *
	 * @param PrintAreaType Print Area
	 */
	@JsonProperty("PrintAreaType")
	public void setPrintAreaTypeInput(I_AD_Ref_ListInput PrintAreaType) {
		this.mPrintAreaType = PrintAreaType;
		if (PrintAreaType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PrintAreaType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPrintAreaType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + PrintAreaType.getUUID());
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
	public I_AD_Ref_ListInput PrintAreaType() {
		return mPrintAreaType;
	}

	/**
	 * Set Format Type.
	 *
	 * @param PrintFormatType Print Format Type
	 */
	@JsonProperty("PrintFormatType")
	public void setPrintFormatTypeInput(I_AD_Ref_ListInput PrintFormatType) {
		this.mPrintFormatType = PrintFormatType;
		if (PrintFormatType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PrintFormatType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPrintFormatType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + PrintFormatType.getUUID());
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
	public I_AD_Ref_ListInput PrintFormatType() {
		return mPrintFormatType;
	}

	/**
	 * Set Shape Type.
	 *
	 * @param ShapeType Type of the shape to be painted
	 */
	@JsonProperty("ShapeType")
	public void setShapeTypeInput(I_AD_Ref_ListInput ShapeType) {
		this.mShapeType = ShapeType;
		if (ShapeType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ShapeType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setShapeType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + ShapeType.getUUID());
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
	public I_AD_Ref_ListInput ShapeType() {
		return mShapeType;
	}
}
