package org.bandahealth.idempiere.graphql.model.input;

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

	 private I_AD_OrgInput AD_Org;
	 private I_C_ChargeInput C_Charge;
	 private I_C_TaxInput C_Tax;
	 private I_M_InOutLineInput M_InOutLine;
	 private I_M_ProductInput M_Product;
	 private I_M_RMAInput M_RMA;
	 private I_M_RMALineInput Ref_RMALine;

	/**
	 * Standard constructor
	 */
	public X_M_RMALineInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	public void setC_Charge(I_C_ChargeInput C_Charge) {
		this.C_Charge = C_Charge;
		MCharge_BH foreignEntity;
		if (C_Charge != null &&
				(foreignEntity = new Query(getCtx(), MCharge_BH.Table_Name, MCharge_BH.COLUMNNAME_C_Charge_UU + "=?", get_TrxName())
						.setParameters(C_Charge.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Charge_ID(foreignEntity.get_ID());
		} else {
			this.setC_Charge_ID(0);
		}
	}

	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	public I_C_ChargeInput getC_Charge() {
		return C_Charge;
	}

	/**
	 * Set Tax.
	 *
	 * @param C_Tax Tax identifier
	 */
	public void setC_Tax(I_C_TaxInput C_Tax) {
		this.C_Tax = C_Tax;
		MTax foreignEntity;
		if (C_Tax != null &&
				(foreignEntity = new Query(getCtx(), MTax.Table_Name, MTax.COLUMNNAME_C_Tax_UU + "=?", get_TrxName())
						.setParameters(C_Tax.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Tax_ID(foreignEntity.get_ID());
		} else {
			this.setC_Tax_ID(0);
		}
	}

	/**
	 * Get Tax.
	 *
	 * @return Tax identifier
	 */
	public I_C_TaxInput getC_Tax() {
		return C_Tax;
	}

	/**
	 * Set Shipment/Receipt Line.
	 *
	 * @param M_InOutLine Line on Shipment or Receipt document
	 */
	public void setM_InOutLine(I_M_InOutLineInput M_InOutLine) {
		this.M_InOutLine = M_InOutLine;
		MInOutLine foreignEntity;
		if (M_InOutLine != null &&
				(foreignEntity = new Query(getCtx(), MInOutLine.Table_Name, MInOutLine.COLUMNNAME_M_InOutLine_UU + "=?", get_TrxName())
						.setParameters(M_InOutLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_InOutLine_ID(foreignEntity.get_ID());
		} else {
			this.setM_InOutLine_ID(0);
		}
	}

	/**
	 * Get Shipment/Receipt Line.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	public I_M_InOutLineInput getM_InOutLine() {
		return M_InOutLine;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	public void setM_Product(I_M_ProductInput M_Product) {
		this.M_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null &&
				(foreignEntity = new Query(getCtx(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_UU + "=?", get_TrxName())
						.setParameters(M_Product.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_Product_ID(foreignEntity.get_ID());
		} else {
			this.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public I_M_ProductInput getM_Product() {
		return M_Product;
	}

	/**
	 * Set RMA.
	 *
	 * @param M_RMA Return Material Authorization
	 */
	public void setM_RMA(I_M_RMAInput M_RMA) {
		this.M_RMA = M_RMA;
		MRMA foreignEntity;
		if (get_ID() == 0 &&M_RMA != null &&
				(foreignEntity = new Query(getCtx(), MRMA.Table_Name, MRMA.COLUMNNAME_M_RMA_UU + "=?", get_TrxName())
						.setParameters(M_RMA.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_RMA_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get RMA.
	 *
	 * @return Return Material Authorization
	 */
	public I_M_RMAInput getM_RMA() {
		return M_RMA;
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
	public void setRef_RMALine(I_M_RMALineInput Ref_RMALine) {
		this.Ref_RMALine = Ref_RMALine;
		MRMALine foreignEntity;
		if (Ref_RMALine != null &&
				(foreignEntity = new Query(getCtx(), MRMALine.Table_Name, MRMALine.COLUMNNAME_M_RMALine_UU + "=?", get_TrxName())
						.setParameters(Ref_RMALine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setRef_RMALine_ID(foreignEntity.get_ID());
		} else {
			this.setRef_RMALine_ID(0);
		}
	}

	/**
	 * Get Referenced RMA Line.
	 *
	 * @return Referenced RMA Line
	 */
	public I_M_RMALineInput getRef_RMALine() {
		return Ref_RMALine;
	}
}
