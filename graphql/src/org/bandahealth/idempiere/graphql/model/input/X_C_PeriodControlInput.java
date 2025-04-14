package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_C_PeriodControlResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
import org.compiere.model.MPeriodControl;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_PeriodControl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_PeriodControlInput extends MPeriodControl implements I_C_PeriodControlInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Period;
	private ForeignEntityInput mDocBaseType;
	private ForeignEntityInput mPeriodAction;
	private ForeignEntityInput mPeriodStatus;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_PeriodControl_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_PeriodControlInput(@JsonProperty("UU") String UU) {
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
	 * Set Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	@JsonProperty("C_Period")
	public void setC_PeriodInput(ForeignEntityInput C_Period) {
		this.mC_Period = C_Period;
		if (get_ID() != 0) {
			return;
		}
		if (C_Period != null) {
			// Since an entity was passed, make sure it's in the DB
			MPeriod foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Period", "C_Period_UU=?", get_TrxName())
							.setParameters(C_Period.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Period_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Period with UU " + C_Period.getUU());
			}
		} else {
			this.setC_Period_ID(0);
		}
	}

	/**
	 * Get Period.
	 *
	 * @return Period of the Calendar
	 */
	@JsonProperty("C_Period")
	public ForeignEntityInput C_Period() {
		return mC_Period;
	}
	/**
	 * Set Period Control.
	 *
	 * @param C_PeriodControl_ID Period Control
	 */
	@JsonProperty("C_PeriodControl_ID")
	public void setC_PeriodControl_IDFromJson(int C_PeriodControl_ID) {
		if (get_ID() == 0) {
			super.setC_PeriodControl_ID(C_PeriodControl_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_PeriodControl_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_PeriodControl_UU();
	}

	/**
	 * Set Document Base Type.
	 *
	 * @param DocBaseType Logical type of document
	 */
	@JsonProperty("DocBaseType")
	public void setDocBaseTypeInput(ForeignEntityInput DocBaseType) {
		this.mDocBaseType = DocBaseType;
		if (get_ID() != 0) {
			return;
		}
		if (DocBaseType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_PeriodControlResolver.DOCBASETYPE_UUIDS_BY_VALUE.containsValue(DocBaseType.getUU())) {
				throw new AdempiereException("The reference list UU of " + DocBaseType.getUU() +
						" is not in the list defined for the DocBaseType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocBaseType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDocBaseType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DocBaseType.getUU());
			}
		} else {
			this.setDocBaseType(null);
		}
	}

	/**
	 * Get Document Base Type.
	 *
	 * @return Logical type of document
	 */
	@JsonProperty("DocBaseType")
	public ForeignEntityInput DocBaseType() {
		return mDocBaseType;
	}

	/**
	 * Set Period Action.
	 *
	 * @param PeriodAction Action taken for this period
	 */
	@JsonProperty("PeriodAction")
	public void setPeriodActionInput(ForeignEntityInput PeriodAction) {
		this.mPeriodAction = PeriodAction;
		if (PeriodAction != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_PeriodControlResolver.PERIODACTION_UUIDS_BY_VALUE.containsValue(PeriodAction.getUU())) {
				throw new AdempiereException("The reference list UU of " + PeriodAction.getUU() +
						" is not in the list defined for the PeriodAction column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PeriodAction.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPeriodAction(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + PeriodAction.getUU());
			}
		} else {
			this.setPeriodAction(null);
		}
	}

	/**
	 * Get Period Action.
	 *
	 * @return Action taken for this period
	 */
	@JsonProperty("PeriodAction")
	public ForeignEntityInput PeriodAction() {
		return mPeriodAction;
	}

	/**
	 * Set Period Status.
	 *
	 * @param PeriodStatus Current state of this period
	 */
	@JsonProperty("PeriodStatus")
	public void setPeriodStatusInput(ForeignEntityInput PeriodStatus) {
		this.mPeriodStatus = PeriodStatus;
		if (get_ID() != 0) {
			return;
		}
		if (PeriodStatus != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_PeriodControlResolver.PERIODSTATUS_UUIDS_BY_VALUE.containsValue(PeriodStatus.getUU())) {
				throw new AdempiereException("The reference list UU of " + PeriodStatus.getUU() +
						" is not in the list defined for the PeriodStatus column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PeriodStatus.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPeriodStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + PeriodStatus.getUU());
			}
		} else {
			this.setPeriodStatus(null);
		}
	}

	/**
	 * Get Period Status.
	 *
	 * @return Current state of this period
	 */
	@JsonProperty("PeriodStatus")
	public ForeignEntityInput PeriodStatus() {
		return mPeriodStatus;
	}
}
