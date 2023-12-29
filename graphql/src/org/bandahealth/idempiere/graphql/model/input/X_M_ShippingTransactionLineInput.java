package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPackageMPS;
import org.compiere.model.MShippingTransaction;
import org.compiere.model.MShippingTransactionLine;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for M_ShippingTransactionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShippingTransactionLineInput extends MShippingTransactionLine implements I_M_ShippingTransactionLineInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_UOMInput C_UOM_Length;
	 private I_C_UOMInput C_UOM_Weight;
	 private I_M_PackageMPSInput M_PackageMPS;
	 private I_M_ShippingTransactionInput M_ShippingTransaction;

	/**
	 * Standard constructor
	 */
	public X_M_ShippingTransactionLineInput(String ID) {
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
	 * Set UOM for Length.
	 *
	 * @param C_UOM_Length Standard Unit of Measure for Length
	 */
	public void setC_UOM_Length(I_C_UOMInput C_UOM_Length) {
		this.C_UOM_Length = C_UOM_Length;
		MUOM foreignEntity;
		if (C_UOM_Length != null &&
				(foreignEntity = new Query(getCtx(), MUOM.Table_Name, MUOM.COLUMNNAME_C_UOM_UU + "=?", get_TrxName())
						.setParameters(C_UOM_Length.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_UOM_Length_ID(foreignEntity.get_ID());
		} else {
			this.setC_UOM_Length_ID(0);
		}
	}

	/**
	 * Get UOM for Length.
	 *
	 * @return Standard Unit of Measure for Length
	 */
	public I_C_UOMInput getC_UOM_Length() {
		return C_UOM_Length;
	}

	/**
	 * Set UOM for Weight.
	 *
	 * @param C_UOM_Weight Standard Unit of Measure for Weight
	 */
	public void setC_UOM_Weight(I_C_UOMInput C_UOM_Weight) {
		this.C_UOM_Weight = C_UOM_Weight;
		MUOM foreignEntity;
		if (C_UOM_Weight != null &&
				(foreignEntity = new Query(getCtx(), MUOM.Table_Name, MUOM.COLUMNNAME_C_UOM_UU + "=?", get_TrxName())
						.setParameters(C_UOM_Weight.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_UOM_Weight_ID(foreignEntity.get_ID());
		} else {
			this.setC_UOM_Weight_ID(0);
		}
	}

	/**
	 * Get UOM for Weight.
	 *
	 * @return Standard Unit of Measure for Weight
	 */
	public I_C_UOMInput getC_UOM_Weight() {
		return C_UOM_Weight;
	}

	/**
	 * Set Package MPS.
	 *
	 * @param M_PackageMPS Package MPS
	 */
	public void setM_PackageMPS(I_M_PackageMPSInput M_PackageMPS) {
		this.M_PackageMPS = M_PackageMPS;
		MPackageMPS foreignEntity;
		if (M_PackageMPS != null &&
				(foreignEntity = new Query(getCtx(), MPackageMPS.Table_Name, MPackageMPS.COLUMNNAME_M_PackageMPS_UU + "=?", get_TrxName())
						.setParameters(M_PackageMPS.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_PackageMPS_ID(foreignEntity.get_ID());
		} else {
			this.setM_PackageMPS_ID(0);
		}
	}

	/**
	 * Get Package MPS.
	 *
	 * @return Package MPS
	 */
	public I_M_PackageMPSInput getM_PackageMPS() {
		return M_PackageMPS;
	}

	/**
	 * Set Shipping Transaction.
	 *
	 * @param M_ShippingTransaction Shipping Transaction
	 */
	public void setM_ShippingTransaction(I_M_ShippingTransactionInput M_ShippingTransaction) {
		this.M_ShippingTransaction = M_ShippingTransaction;
		MShippingTransaction foreignEntity;
		if (get_ID() == 0 &&M_ShippingTransaction != null &&
				(foreignEntity = new Query(getCtx(), MShippingTransaction.Table_Name, MShippingTransaction.COLUMNNAME_M_ShippingTransaction_UU + "=?", get_TrxName())
						.setParameters(M_ShippingTransaction.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_ShippingTransaction_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Shipping Transaction.
	 *
	 * @return Shipping Transaction
	 */
	public I_M_ShippingTransactionInput getM_ShippingTransaction() {
		return M_ShippingTransaction;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_ShippingTransactionLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_ShippingTransactionLine_UU();
	}
}
