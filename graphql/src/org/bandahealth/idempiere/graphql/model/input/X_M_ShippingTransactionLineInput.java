package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPackageMPS;
import org.compiere.model.MShippingTransaction;
import org.compiere.model.MShippingTransactionLine;
import org.compiere.model.MUOM;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_ShippingTransactionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShippingTransactionLineInput extends MShippingTransactionLine implements I_M_ShippingTransactionLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_UOM_Length;
	private ForeignEntityInput mC_UOM_Weight;
	private ForeignEntityInput mM_PackageMPS;
	private ForeignEntityInput mM_ShippingTransaction;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_ShippingTransactionLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_ShippingTransactionLineInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
	 * Set UOM for Length.
	 *
	 * @param C_UOM_Length Standard Unit of Measure for Length
	 */
	@JsonProperty("C_UOM_Length")
	public void setC_UOM_LengthInput(ForeignEntityInput C_UOM_Length) {
		this.mC_UOM_Length = C_UOM_Length;
		if (C_UOM_Length != null) {
			// Since an entity was passed, make sure it's in the DB
			MUOM foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
							.setParameters(C_UOM_Length.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_UOM_Length_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_UOM with UUID " + C_UOM_Length.getUUID());
			}
		} else {
			this.setC_UOM_Length_ID(0);
		}
	}

	/**
	 * Get UOM for Length.
	 *
	 * @return Standard Unit of Measure for Length
	 */
	@JsonProperty("C_UOM_Length")
	public ForeignEntityInput C_UOM_Length() {
		return mC_UOM_Length;
	}

	/**
	 * Set UOM for Weight.
	 *
	 * @param C_UOM_Weight Standard Unit of Measure for Weight
	 */
	@JsonProperty("C_UOM_Weight")
	public void setC_UOM_WeightInput(ForeignEntityInput C_UOM_Weight) {
		this.mC_UOM_Weight = C_UOM_Weight;
		if (C_UOM_Weight != null) {
			// Since an entity was passed, make sure it's in the DB
			MUOM foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_UOM", "C_UOM_UU=?", get_TrxName())
							.setParameters(C_UOM_Weight.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_UOM_Weight_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_UOM with UUID " + C_UOM_Weight.getUUID());
			}
		} else {
			this.setC_UOM_Weight_ID(0);
		}
	}

	/**
	 * Get UOM for Weight.
	 *
	 * @return Standard Unit of Measure for Weight
	 */
	@JsonProperty("C_UOM_Weight")
	public ForeignEntityInput C_UOM_Weight() {
		return mC_UOM_Weight;
	}

	/**
	 * Set Package MPS.
	 *
	 * @param M_PackageMPS Package MPS
	 */
	@JsonProperty("M_PackageMPS")
	public void setM_PackageMPSInput(ForeignEntityInput M_PackageMPS) {
		this.mM_PackageMPS = M_PackageMPS;
		if (M_PackageMPS != null) {
			// Since an entity was passed, make sure it's in the DB
			MPackageMPS foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_PackageMPS", "M_PackageMPS_UU=?", get_TrxName())
							.setParameters(M_PackageMPS.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_PackageMPS_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_PackageMPS with UUID " + M_PackageMPS.getUUID());
			}
		} else {
			this.setM_PackageMPS_ID(0);
		}
	}

	/**
	 * Get Package MPS.
	 *
	 * @return Package MPS
	 */
	@JsonProperty("M_PackageMPS")
	public ForeignEntityInput M_PackageMPS() {
		return mM_PackageMPS;
	}

	/**
	 * Set Shipping Transaction.
	 *
	 * @param M_ShippingTransaction Shipping Transaction
	 */
	@JsonProperty("M_ShippingTransaction")
	public void setM_ShippingTransactionInput(ForeignEntityInput M_ShippingTransaction) {
		this.mM_ShippingTransaction = M_ShippingTransaction;
		if (get_ID() != 0) {
			return;
		}
		if (M_ShippingTransaction != null) {
			// Since an entity was passed, make sure it's in the DB
			MShippingTransaction foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ShippingTransaction", "M_ShippingTransaction_UU=?", get_TrxName())
							.setParameters(M_ShippingTransaction.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_ShippingTransaction_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ShippingTransaction with UUID " + M_ShippingTransaction.getUUID());
			}
		} else {
			this.setM_ShippingTransaction_ID(0);
		}
	}

	/**
	 * Get Shipping Transaction.
	 *
	 * @return Shipping Transaction
	 */
	@JsonProperty("M_ShippingTransaction")
	public ForeignEntityInput M_ShippingTransaction() {
		return mM_ShippingTransaction;
	}
	/**
	 * Set Shipping Transaction Line.
	 *
	 * @param M_ShippingTransactionLine_ID Shipping Transaction Line
	 */

	public void setM_ShippingTransactionLine_ID(int M_ShippingTransactionLine_ID) {
		if (get_ID() == 0) {
			super.setM_ShippingTransactionLine_ID(M_ShippingTransactionLine_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_ShippingTransactionLine_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_ShippingTransactionLine_UU();
	}
}
