package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_Job;
import org.compiere.model.X_M_OperationResource;
import org.compiere.model.X_M_ProductOperation;

import java.sql.ResultSet;

/**
 * Generated Model for M_OperationResource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_OperationResourceInput extends X_M_OperationResource implements I_M_OperationResourceInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mC_Job;
	private ForeignEntityInput mM_ProductOperation;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_OperationResourceInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_M_OperationResource(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public void setA_AssetInput(ForeignEntityInput A_Asset) {
		this.mA_Asset = A_Asset;
		MAsset foreignEntity;
		if (A_Asset != null &&
				(foreignEntity = new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
						.setParameters(A_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_ID(foreignEntity.get_ID());
		} else {
			super.setA_Asset_ID(0);
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
	 * Set Position.
	 *
	 * @param C_Job Job Position
	 */
	@JsonProperty("C_Job")
	public void setC_JobInput(ForeignEntityInput C_Job) {
		this.mC_Job = C_Job;
		X_C_Job foreignEntity;
		if (C_Job != null &&
				(foreignEntity = new Query(getCtx(), "C_Job", "C_Job_UU=?", get_TrxName())
						.setParameters(C_Job.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Job_ID(foreignEntity.get_ID());
		} else {
			super.setC_Job_ID(0);
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

	public void setM_OperationResource_ID(int M_OperationResource_ID) {
		if (get_ID() == 0) {
			super.setM_OperationResource_ID(M_OperationResource_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_OperationResource_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		X_M_ProductOperation foreignEntity;
		if (get_ID() == 0 && M_ProductOperation != null &&
				(foreignEntity = new Query(getCtx(), "M_ProductOperation", "M_ProductOperation_UU=?", get_TrxName())
						.setParameters(M_ProductOperation.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ProductOperation_ID(foreignEntity.get_ID());
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
