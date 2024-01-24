package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_PrintFormatItemInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_PrintFormatItem(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Print Color.
	 *
	 * @param AD_PrintColor Color used for printing and display
	 */
	@JsonProperty("AD_PrintColor")
	public void setAD_PrintColorInput(ForeignEntityInput AD_PrintColor) {
		this.mAD_PrintColor = AD_PrintColor;
		X_AD_PrintColor foreignEntity;
		if (AD_PrintColor != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintColor", "AD_PrintColor_UU=?", get_TrxName())
						.setParameters(AD_PrintColor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PrintColor_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PrintColor_ID(0);
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
		X_AD_PrintFont foreignEntity;
		if (AD_PrintFont != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintFont", "AD_PrintFont_UU=?", get_TrxName())
						.setParameters(AD_PrintFont.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PrintFont_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PrintFont_ID(0);
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
		X_AD_PrintFormat foreignEntity;
		if (get_ID() == 0 && AD_PrintFormat != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
						.setParameters(AD_PrintFormat.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PrintFormat_ID(foreignEntity.get_ID());
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
		X_AD_PrintFormat foreignEntity;
		if (AD_PrintFormatChild != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
						.setParameters(AD_PrintFormatChild.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PrintFormatChild_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PrintFormatChild_ID(0);
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_PrintFormatItem_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		X_AD_PrintGraph foreignEntity;
		if (AD_PrintGraph != null &&
				(foreignEntity = new Query(getCtx(), "AD_PrintGraph", "AD_PrintGraph_UU=?", get_TrxName())
						.setParameters(AD_PrintGraph.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PrintGraph_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PrintGraph_ID(0);
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
		MRefList_BH foreignEntity;
		if (BarcodeType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BarcodeType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBarcodeType(foreignEntity.getValue());
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
		MRefList_BH foreignEntity;
		if (FieldAlignmentType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(FieldAlignmentType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setFieldAlignmentType(foreignEntity.getValue());
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
		MRefList_BH foreignEntity;
		if (LineAlignmentType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(LineAlignmentType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setLineAlignmentType(foreignEntity.getValue());
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
		MRefList_BH foreignEntity;
		if (PrintAreaType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PrintAreaType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPrintAreaType(foreignEntity.getValue());
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
		MRefList_BH foreignEntity;
		if (PrintFormatType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PrintFormatType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPrintFormatType(foreignEntity.getValue());
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
		MRefList_BH foreignEntity;
		if (ShapeType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ShapeType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setShapeType(foreignEntity.getValue());
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
