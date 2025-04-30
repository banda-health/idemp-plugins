package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_Job;
import org.compiere.model.X_M_OperationResource;
import org.compiere.model.X_M_ProductOperation;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_OperationResource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_OperationResourceInput extends X_M_OperationResource implements I_M_OperationResourceInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mC_Job;
	private ForeignEntityInput mM_ProductOperation;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The M_OperationResource_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_OperationResourceInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public void setA_AssetInput(ForeignEntityInput A_Asset) {
		this.mA_Asset = A_Asset;
		if (A_Asset != null) {
			// Since an entity was passed, make sure it's in the DB
			MAsset foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
							.setParameters(A_Asset.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setA_Asset_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset with UU " + A_Asset.getUU());
			}
		} else {
			this.setA_Asset_ID(0);
		}
	}

	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public ForeignEntityInput A_Asset() {
		return mA_Asset;
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
	 * Set Position.
	 *
	 * @param C_Job Job Position
	 */
	@JsonProperty("C_Job")
	public void setC_JobInput(ForeignEntityInput C_Job) {
		this.mC_Job = C_Job;
		if (C_Job != null) {
			// Since an entity was passed, make sure it's in the DB
			X_C_Job foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Job", "C_Job_UU=?", get_TrxName())
							.setParameters(C_Job.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Job_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Job with UU " + C_Job.getUU());
			}
		} else {
			this.setC_Job_ID(0);
		}
	}

	/**
	 * Get Position.
	 *
	 * @return Job Position
	 */
	@JsonProperty("C_Job")
	public ForeignEntityInput C_Job() {
		return mC_Job;
	}
	/**
	 * Set Operation Resource.
	 *
	 * @param M_OperationResource_ID Product Operation Resource
	 */
	@JsonProperty("M_OperationResource_ID")
	public void setM_OperationResource_IDFromJson(int M_OperationResource_ID) {
		if (get_ID() == 0) {
			super.setM_OperationResource_ID(M_OperationResource_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setM_OperationResource_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getM_OperationResource_UU();
	}

	/**
	 * Set Product Operation.
	 *
	 * @param M_ProductOperation Product Manufacturing Operation
	 */
	@JsonProperty("M_ProductOperation")
	public void setM_ProductOperationInput(ForeignEntityInput M_ProductOperation) {
		this.mM_ProductOperation = M_ProductOperation;
		if (!is_new()) {
			return;
		}
		if (M_ProductOperation != null) {
			// Since an entity was passed, make sure it's in the DB
			X_M_ProductOperation foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ProductOperation", "M_ProductOperation_UU=?", get_TrxName())
							.setParameters(M_ProductOperation.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_ProductOperation_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ProductOperation with UU " + M_ProductOperation.getUU());
			}
		} else {
			this.setM_ProductOperation_ID(0);
		}
	}

	/**
	 * Get Product Operation.
	 *
	 * @return Product Manufacturing Operation
	 */
	@JsonProperty("M_ProductOperation")
	public ForeignEntityInput M_ProductOperation() {
		return mM_ProductOperation;
	}
}
