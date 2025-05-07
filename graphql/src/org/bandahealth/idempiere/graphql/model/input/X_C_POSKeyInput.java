package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MImage;
import org.compiere.model.MOrg;
import org.compiere.model.MPOSKey;
import org.compiere.model.MPOSKeyLayout;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.model.X_AD_PrintFont;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_POSKey - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_POSKey_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_POSKeyInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Image.
	 *
	 * @param AD_Image Image or Icon
	 */
	@JsonProperty("AD_Image")
	public void setAD_ImageInput(ForeignEntityInput AD_Image) {
		this.mAD_Image = AD_Image;
		if (AD_Image != null) {
			// Since an entity was passed, make sure it's in the DB
			MImage foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Image", "AD_Image_UU=?", get_TrxName())
							.setParameters(AD_Image.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Image_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Image with UU " + AD_Image.getUU());
			}
		} else {
			this.setAD_Image_ID(0);
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
	 * Set POS Key.
	 *
	 * @param C_POSKey_ID POS Function Key
	 */
	@JsonProperty("C_POSKey_ID")
	public void setC_POSKey_IDFromJson(int C_POSKey_ID) {
		if (get_ID() == 0) {
			super.setC_POSKey_ID(C_POSKey_ID);
		}
	}

	/**
	 * Set POS Key Layout.
	 *
	 * @param C_POSKeyLayout POS Function Key Layout
	 */
	@JsonProperty("C_POSKeyLayout")
	public void setC_POSKeyLayoutInput(ForeignEntityInput C_POSKeyLayout) {
		this.mC_POSKeyLayout = C_POSKeyLayout;
		if (!is_new()) {
			return;
		}
		if (C_POSKeyLayout != null) {
			// Since an entity was passed, make sure it's in the DB
			MPOSKeyLayout foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_POSKeyLayout", "C_POSKeyLayout_UU=?", get_TrxName())
							.setParameters(C_POSKeyLayout.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_POSKeyLayout_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_POSKeyLayout with UU " + C_POSKeyLayout.getUU());
			}
		} else {
			this.setC_POSKeyLayout_ID(0);
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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_POSKey_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_POSKey_UU();
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		if (M_Product != null) {
			// Since an entity was passed, make sure it's in the DB
			MProduct_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UU " + M_Product.getUU());
			}
		} else {
			this.setM_Product_ID(0);
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
		if (SubKeyLayout != null) {
			// Since an entity was passed, make sure it's in the DB
			MPOSKeyLayout foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_POSKeyLayout", "C_POSKeyLayout_UU=?", get_TrxName())
							.setParameters(SubKeyLayout.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setSubKeyLayout_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_POSKeyLayout with UU " + SubKeyLayout.getUU());
			}
		} else {
			this.setSubKeyLayout_ID(0);
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
