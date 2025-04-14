package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_HR_Department;
import org.eevolution.model.X_HR_Job;

import java.sql.ResultSet;

/**
 * Generated Model for HR_Job - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_HR_JobInput extends X_HR_Job implements I_HR_JobInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mHR_Department;
	private ForeignEntityInput mNext_Job;
	private ForeignEntityInput mSupervisor;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The HR_Job_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_HR_JobInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
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
	 * Set Payroll Department.
	 *
	 * @param HR_Department Payroll Department
	 */
	@JsonProperty("HR_Department")
	public void setHR_DepartmentInput(ForeignEntityInput HR_Department) {
		this.mHR_Department = HR_Department;
		if (HR_Department != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_Department foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_Department", "HR_Department_UU=?", get_TrxName())
							.setParameters(HR_Department.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setHR_Department_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Department with UU " + HR_Department.getUU());
			}
		} else {
			this.setHR_Department_ID(0);
		}
	}

	/**
	 * Get Payroll Department.
	 *
	 * @return Payroll Department
	 */
	@JsonProperty("HR_Department")
	public ForeignEntityInput HR_Department() {
		return mHR_Department;
	}
	/**
	 * Set Payroll Job.
	 *
	 * @param HR_Job_ID Payroll Job
	 */
	@JsonProperty("HR_Job_ID")
	public void setHR_Job_IDFromJson(int HR_Job_ID) {
		if (get_ID() == 0) {
			super.setHR_Job_ID(HR_Job_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setHR_Job_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getHR_Job_UU();
	}

	/**
	 * Set Next Job.
	 *
	 * @param Next_Job Next Job
	 */
	@JsonProperty("Next_Job")
	public void setNext_JobInput(ForeignEntityInput Next_Job) {
		this.mNext_Job = Next_Job;
		if (Next_Job != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_Job foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_Job", "HR_Job_UU=?", get_TrxName())
							.setParameters(Next_Job.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setNext_Job_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Job with UU " + Next_Job.getUU());
			}
		} else {
			this.setNext_Job_ID(0);
		}
	}

	/**
	 * Get Next Job.
	 *
	 * @return Next Job
	 */
	@JsonProperty("Next_Job")
	public ForeignEntityInput Next_Job() {
		return mNext_Job;
	}

	/**
	 * Set Supervisor.
	 *
	 * @param Supervisor Supervisor for this user/organization - used for escalation and approval
	 */
	@JsonProperty("Supervisor")
	public void setSupervisorInput(ForeignEntityInput Supervisor) {
		this.mSupervisor = Supervisor;
		if (Supervisor != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(Supervisor.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setSupervisor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + Supervisor.getUU());
			}
		} else {
			this.setSupervisor_ID(0);
		}
	}

	/**
	 * Get Supervisor.
	 *
	 * @return Supervisor for this user/organization - used for escalation and approval
	 */
	@JsonProperty("Supervisor")
	public ForeignEntityInput Supervisor() {
		return mSupervisor;
	}
}
