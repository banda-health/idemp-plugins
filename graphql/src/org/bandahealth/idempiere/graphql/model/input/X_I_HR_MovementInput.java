package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.X_HR_Concept;
import org.eevolution.model.X_HR_Movement;
import org.eevolution.model.X_HR_Process;
import org.eevolution.model.X_I_HR_Movement;

import java.sql.ResultSet;

/**
 * Generated Model for I_HR_Movement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_I_HR_MovementInput extends X_I_HR_Movement implements I_I_HR_MovementInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mHR_Concept;
	private ForeignEntityInput mHR_Movement;
	private ForeignEntityInput mHR_Process;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The I_HR_Movement_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_I_HR_MovementInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_I_HR_Movement(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
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
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		if (C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_BPartner.getUUID());
			}
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set Payroll Concept.
	 *
	 * @param HR_Concept Payroll Concept
	 */
	@JsonProperty("HR_Concept")
	public void setHR_ConceptInput(ForeignEntityInput HR_Concept) {
		this.mHR_Concept = HR_Concept;
		if (HR_Concept != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_Concept foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_Concept", "HR_Concept_UU=?", get_TrxName())
							.setParameters(HR_Concept.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setHR_Concept_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Concept with UUID " + HR_Concept.getUUID());
			}
		} else {
			this.setHR_Concept_ID(0);
		}
	}

	/**
	 * Get Payroll Concept.
	 *
	 * @return Payroll Concept
	 */
	@JsonProperty("HR_Concept")
	public ForeignEntityInput HR_Concept() {
		return mHR_Concept;
	}

	/**
	 * Set Payroll Movement.
	 *
	 * @param HR_Movement Payroll Movement
	 */
	@JsonProperty("HR_Movement")
	public void setHR_MovementInput(ForeignEntityInput HR_Movement) {
		this.mHR_Movement = HR_Movement;
		if (HR_Movement != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_Movement foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_Movement", "HR_Movement_UU=?", get_TrxName())
							.setParameters(HR_Movement.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setHR_Movement_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Movement with UUID " + HR_Movement.getUUID());
			}
		} else {
			this.setHR_Movement_ID(0);
		}
	}

	/**
	 * Get Payroll Movement.
	 *
	 * @return Payroll Movement
	 */
	@JsonProperty("HR_Movement")
	public ForeignEntityInput HR_Movement() {
		return mHR_Movement;
	}

	/**
	 * Set Payroll Process.
	 *
	 * @param HR_Process Payroll Process
	 */
	@JsonProperty("HR_Process")
	public void setHR_ProcessInput(ForeignEntityInput HR_Process) {
		this.mHR_Process = HR_Process;
		if (HR_Process != null) {
			// Since an entity was passed, make sure it's in the DB
			X_HR_Process foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "HR_Process", "HR_Process_UU=?", get_TrxName())
							.setParameters(HR_Process.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setHR_Process_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table HR_Process with UUID " + HR_Process.getUUID());
			}
		} else {
			this.setHR_Process_ID(0);
		}
	}

	/**
	 * Get Payroll Process.
	 *
	 * @return Payroll Process
	 */
	@JsonProperty("HR_Process")
	public ForeignEntityInput HR_Process() {
		return mHR_Process;
	}
	/**
	 * Set Payroll Movement Import.
	 *
	 * @param I_HR_Movement_ID Payroll Movement Import
	 */

	public void setI_HR_Movement_ID(int I_HR_Movement_ID) {
		if (get_ID() == 0) {
			super.setI_HR_Movement_ID(I_HR_Movement_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setI_HR_Movement_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getI_HR_Movement_UU();
	}
}
