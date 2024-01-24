package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MImage;
import org.compiere.model.MOrg;
import org.compiere.model.MPOSKey;
import org.compiere.model.MPOSKeyLayout;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.model.X_AD_PrintFont;

import java.sql.ResultSet;

/**
 * Generated Model for C_POSKey - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_POSKeyInput extends MPOSKey implements I_C_POSKeyInput {

	private ForeignEntityInput mAD_Image;
	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PrintColor;
	private ForeignEntityInput mAD_PrintFont;
	private ForeignEntityInput mC_POSKeyLayout;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mSubKeyLayout;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_POSKeyInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MPOSKey(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Image.
	 *
	 * @param AD_Image Image or Icon
	 */
	@JsonProperty("AD_Image")
	public void setAD_ImageInput(ForeignEntityInput AD_Image) {
		this.mAD_Image = AD_Image;
		MImage foreignEntity;
		if (AD_Image != null &&
				(foreignEntity = new Query(getCtx(), "AD_Image", "AD_Image_UU=?", get_TrxName())
						.setParameters(AD_Image.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Image_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Image_ID(0);
		}
	}

	/**
	 * Get Image.
	 *
	 * @return Image or Icon
	 */
	@JsonProperty("AD_Image")
	public ForeignEntityInput AD_Image() {
		return mAD_Image;
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
	 * Set POS Key.
	 *
	 * @param C_POSKey_ID POS Function Key
	 */

	public void setC_POSKey_ID(int C_POSKey_ID) {
		if (get_ID() == 0) {
			super.setC_POSKey_ID(C_POSKey_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_POSKey_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_POSKey_UU();
	}

	/**
	 * Set POS Key Layout.
	 *
	 * @param C_POSKeyLayout POS Function Key Layout
	 */
	@JsonProperty("C_POSKeyLayout")
	public void setC_POSKeyLayoutInput(ForeignEntityInput C_POSKeyLayout) {
		this.mC_POSKeyLayout = C_POSKeyLayout;
		MPOSKeyLayout foreignEntity;
		if (get_ID() == 0 && C_POSKeyLayout != null &&
				(foreignEntity = new Query(getCtx(), "C_POSKeyLayout", "C_POSKeyLayout_UU=?", get_TrxName())
						.setParameters(C_POSKeyLayout.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_POSKeyLayout_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get POS Key Layout.
	 *
	 * @return POS Function Key Layout
	 */
	@JsonProperty("C_POSKeyLayout")
	public ForeignEntityInput C_POSKeyLayout() {
		return mC_POSKeyLayout;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Product_ID(foreignEntity.get_ID());
		} else {
			super.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public ForeignEntityInput M_Product() {
		return mM_Product;
	}

	/**
	 * Set Key Layout.
	 *
	 * @param SubKeyLayout Key Layout to be displayed when this key is pressed
	 */
	@JsonProperty("SubKeyLayout")
	public void setSubKeyLayoutInput(ForeignEntityInput SubKeyLayout) {
		this.mSubKeyLayout = SubKeyLayout;
		MPOSKeyLayout foreignEntity;
		if (SubKeyLayout != null &&
				(foreignEntity = new Query(getCtx(), "C_POSKeyLayout", "C_POSKeyLayout_UU=?", get_TrxName())
						.setParameters(SubKeyLayout.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setSubKeyLayout_ID(foreignEntity.get_ID());
		} else {
			super.setSubKeyLayout_ID(0);
		}
	}

	/**
	 * Get Key Layout.
	 *
	 * @return Key Layout to be displayed when this key is pressed
	 */
	@JsonProperty("SubKeyLayout")
	public ForeignEntityInput SubKeyLayout() {
		return mSubKeyLayout;
	}
}
