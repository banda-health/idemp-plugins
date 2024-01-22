package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MUOM;
import org.compiere.model.MUOMConversion;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_UOM_Conversion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_UOM_ConversionInput extends MUOMConversion implements I_C_UOM_ConversionInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_UOM;
	private ForeignEntityInput mC_UOM_To;
	private ForeignEntityInput mM_Product;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_UOM_ConversionInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MUOMConversion(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
	 * Set UOM Conversion.
	 *
	 * @param C_UOM_Conversion_ID Unit of Measure Conversion
	 */

	public void setC_UOM_Conversion_ID(int C_UOM_Conversion_ID) {
		if (get_ID() == 0) {
			super.setC_UOM_Conversion_ID(C_UOM_Conversion_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_UOM_Conversion_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_UOM_Conversion_UU();
	}

	/**
	 * Set UOM.
	 *
	 * @param C_UOM Unit of Measure
	 */
	@JsonProperty("C_UOM")
	public void setC_UOMInput(ForeignEntityInput C_UOM) {
		this.mC_UOM = C_UOM;
		MUOM foreignEntity;
		if (C_UOM != null &&
				(foreignEntity = new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
						.setParameters(C_UOM.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_UOM_ID(foreignEntity.get_ID());
		} else {
			super.setC_UOM_ID(0);
		}
	}

	/**
	 * Get UOM.
	 *
	 * @return Unit of Measure
	 */
	@JsonProperty("C_UOM")
	public ForeignEntityInput C_UOM() {
		return mC_UOM;
	}

	/**
	 * Set UoM To.
	 *
	 * @param C_UOM_To Target or destination Unit of Measure
	 */
	@JsonProperty("C_UOM_To")
	public void setC_UOM_ToInput(ForeignEntityInput C_UOM_To) {
		this.mC_UOM_To = C_UOM_To;
		MUOM foreignEntity;
		if (C_UOM_To != null &&
				(foreignEntity = new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
						.setParameters(C_UOM_To.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_UOM_To_ID(foreignEntity.get_ID());
		} else {
			super.setC_UOM_To_ID(0);
		}
	}

	/**
	 * Get UoM To.
	 *
	 * @return Target or destination Unit of Measure
	 */
	@JsonProperty("C_UOM_To")
	public ForeignEntityInput C_UOM_To() {
		return mC_UOM_To;
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
}
