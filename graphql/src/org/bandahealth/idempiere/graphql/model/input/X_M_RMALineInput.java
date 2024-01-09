package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInOutLine;
import org.compiere.model.MOrg;
import org.compiere.model.MRMA;
import org.compiere.model.MRMALine;
import org.compiere.model.MTax;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for M_RMALine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_RMALineInput extends MRMALine implements I_M_RMALineInput {

	 private ForeignEntityInput mAD_Org;
	 private ForeignEntityInput mC_Charge;
	 private ForeignEntityInput mC_Tax;
	 private ForeignEntityInput mM_InOutLine;
	 private ForeignEntityInput mM_Product;
	 private ForeignEntityInput mM_RMA;
	 private ForeignEntityInput mRef_RMALine;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_RMALineInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
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
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	 * Set Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	@JsonProperty("C_Charge")
	public void setC_ChargeInput(ForeignEntityInput C_Charge) {
		this.mC_Charge = C_Charge;
		MCharge_BH foreignEntity;
		if (C_Charge != null &&
				(foreignEntity = new Query(getCtx(), MCharge_BH.Table_Name, MCharge_BH.COLUMNNAME_C_Charge_UU + "=?", get_TrxName())
						.setParameters(C_Charge.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Charge_ID(foreignEntity.get_ID());
		} else {
			super.setC_Charge_ID(0);
		}
	}

	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	@JsonProperty("C_Charge")
	public ForeignEntityInput C_Charge() {
		return mC_Charge;
	}

	/**
	 * Set Tax.
	 *
	 * @param C_Tax Tax identifier
	 */
	@JsonProperty("C_Tax")
	public void setC_TaxInput(ForeignEntityInput C_Tax) {
		this.mC_Tax = C_Tax;
		MTax foreignEntity;
		if (C_Tax != null &&
				(foreignEntity = new Query(getCtx(), MTax.Table_Name, MTax.COLUMNNAME_C_Tax_UU + "=?", get_TrxName())
						.setParameters(C_Tax.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Tax_ID(foreignEntity.get_ID());
		} else {
			super.setC_Tax_ID(0);
		}
	}

	/**
	 * Get Tax.
	 *
	 * @return Tax identifier
	 */
	@JsonProperty("C_Tax")
	public ForeignEntityInput C_Tax() {
		return mC_Tax;
	}

	/**
	 * Set Shipment/Receipt Line.
	 *
	 * @param M_InOutLine Line on Shipment or Receipt document
	 */
	@JsonProperty("M_InOutLine")
	public void setM_InOutLineInput(ForeignEntityInput M_InOutLine) {
		this.mM_InOutLine = M_InOutLine;
		MInOutLine foreignEntity;
		if (M_InOutLine != null &&
				(foreignEntity = new Query(getCtx(), MInOutLine.Table_Name, MInOutLine.COLUMNNAME_M_InOutLine_UU + "=?", get_TrxName())
						.setParameters(M_InOutLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_InOutLine_ID(foreignEntity.get_ID());
		} else {
			super.setM_InOutLine_ID(0);
		}
	}

	/**
	 * Get Shipment/Receipt Line.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	@JsonProperty("M_InOutLine")
	public ForeignEntityInput M_InOutLine() {
		return mM_InOutLine;
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
				(foreignEntity = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_UU + "=?", get_TrxName())
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
	 * Set RMA.
	 *
	 * @param M_RMA Return Material Authorization
	 */
	@JsonProperty("M_RMA")
	public void setM_RMAInput(ForeignEntityInput M_RMA) {
		this.mM_RMA = M_RMA;
		MRMA foreignEntity;
		if (get_ID() == 0 &&M_RMA != null &&
				(foreignEntity = new Query(getCtx(), MRMA.Table_Name, MRMA.COLUMNNAME_M_RMA_UU + "=?", get_TrxName())
						.setParameters(M_RMA.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_RMA_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get RMA.
	 *
	 * @return Return Material Authorization
	 */
	@JsonProperty("M_RMA")
	public ForeignEntityInput M_RMA() {
		return mM_RMA;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_RMALine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_RMALine_UU();
	}

	/**
	 * Set Referenced RMA Line.
	 *
	 * @param Ref_RMALine Referenced RMA Line
	 */
	@JsonProperty("Ref_RMALine")
	public void setRef_RMALineInput(ForeignEntityInput Ref_RMALine) {
		this.mRef_RMALine = Ref_RMALine;
		MRMALine foreignEntity;
		if (Ref_RMALine != null &&
				(foreignEntity = new Query(getCtx(), MRMALine.Table_Name, MRMALine.COLUMNNAME_M_RMALine_UU + "=?", get_TrxName())
						.setParameters(Ref_RMALine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setRef_RMALine_ID(foreignEntity.get_ID());
		} else {
			super.setRef_RMALine_ID(0);
		}
	}

	/**
	 * Get Referenced RMA Line.
	 *
	 * @return Referenced RMA Line
	 */
	@JsonProperty("Ref_RMALine")
	public ForeignEntityInput Ref_RMALine() {
		return mRef_RMALine;
	}
}
