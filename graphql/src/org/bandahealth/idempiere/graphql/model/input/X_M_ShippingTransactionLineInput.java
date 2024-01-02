package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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

	 private I_AD_OrgInput mAD_Org;
	 private I_C_UOMInput mC_UOM_Length;
	 private I_C_UOMInput mC_UOM_Weight;
	 private I_M_PackageMPSInput mM_PackageMPS;
	 private I_M_ShippingTransactionInput mM_ShippingTransaction;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_ShippingTransactionLineInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
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
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set UOM for Length.
	 *
	 * @param C_UOM_Length Standard Unit of Measure for Length
	 */
	@JsonProperty("C_UOM_Length")
	public void setC_UOM_LengthInput(I_C_UOMInput C_UOM_Length) {
		this.mC_UOM_Length = C_UOM_Length;
		MUOM foreignEntity;
		if (C_UOM_Length != null &&
				(foreignEntity = new Query(getCtx(), MUOM.Table_Name, MUOM.COLUMNNAME_C_UOM_UU + "=?", get_TrxName())
						.setParameters(C_UOM_Length.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_UOM_Length_ID(foreignEntity.get_ID());
		} else {
			super.setC_UOM_Length_ID(0);
		}
	}

	/**
	 * Get UOM for Length.
	 *
	 * @return Standard Unit of Measure for Length
	 */
	@JsonProperty("C_UOM_Length")
	public I_C_UOMInput C_UOM_Length() {
		return mC_UOM_Length;
	}

	/**
	 * Set UOM for Weight.
	 *
	 * @param C_UOM_Weight Standard Unit of Measure for Weight
	 */
	@JsonProperty("C_UOM_Weight")
	public void setC_UOM_WeightInput(I_C_UOMInput C_UOM_Weight) {
		this.mC_UOM_Weight = C_UOM_Weight;
		MUOM foreignEntity;
		if (C_UOM_Weight != null &&
				(foreignEntity = new Query(getCtx(), MUOM.Table_Name, MUOM.COLUMNNAME_C_UOM_UU + "=?", get_TrxName())
						.setParameters(C_UOM_Weight.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_UOM_Weight_ID(foreignEntity.get_ID());
		} else {
			super.setC_UOM_Weight_ID(0);
		}
	}

	/**
	 * Get UOM for Weight.
	 *
	 * @return Standard Unit of Measure for Weight
	 */
	@JsonProperty("C_UOM_Weight")
	public I_C_UOMInput C_UOM_Weight() {
		return mC_UOM_Weight;
	}

	/**
	 * Set Package MPS.
	 *
	 * @param M_PackageMPS Package MPS
	 */
	@JsonProperty("M_PackageMPS")
	public void setM_PackageMPSInput(I_M_PackageMPSInput M_PackageMPS) {
		this.mM_PackageMPS = M_PackageMPS;
		MPackageMPS foreignEntity;
		if (M_PackageMPS != null &&
				(foreignEntity = new Query(getCtx(), MPackageMPS.Table_Name, MPackageMPS.COLUMNNAME_M_PackageMPS_UU + "=?", get_TrxName())
						.setParameters(M_PackageMPS.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_PackageMPS_ID(foreignEntity.get_ID());
		} else {
			super.setM_PackageMPS_ID(0);
		}
	}

	/**
	 * Get Package MPS.
	 *
	 * @return Package MPS
	 */
	@JsonProperty("M_PackageMPS")
	public I_M_PackageMPSInput M_PackageMPS() {
		return mM_PackageMPS;
	}

	/**
	 * Set Shipping Transaction.
	 *
	 * @param M_ShippingTransaction Shipping Transaction
	 */
	@JsonProperty("M_ShippingTransaction")
	public void setM_ShippingTransactionInput(I_M_ShippingTransactionInput M_ShippingTransaction) {
		this.mM_ShippingTransaction = M_ShippingTransaction;
		MShippingTransaction foreignEntity;
		if (get_ID() == 0 &&M_ShippingTransaction != null &&
				(foreignEntity = new Query(getCtx(), MShippingTransaction.Table_Name, MShippingTransaction.COLUMNNAME_M_ShippingTransaction_UU + "=?", get_TrxName())
						.setParameters(M_ShippingTransaction.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ShippingTransaction_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Shipping Transaction.
	 *
	 * @return Shipping Transaction
	 */
	@JsonProperty("M_ShippingTransaction")
	public I_M_ShippingTransactionInput M_ShippingTransaction() {
		return mM_ShippingTransaction;
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
