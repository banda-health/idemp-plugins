package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
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
 * @version Release 8.2 - $Id$
 */
public class X_C_PeriodControlInput extends MPeriodControl implements I_C_PeriodControlInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Period;
	private I_AD_Ref_ListInput mDocBaseType;
	private I_AD_Ref_ListInput mPeriodAction;
	private I_AD_Ref_ListInput mPeriodStatus;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_PeriodControl_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_PeriodControlInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MPeriodControl(null, (ResultSet) null, null),
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
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
	 * Set Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	@JsonProperty("C_Period")
	public void setC_PeriodInput(ForeignEntityInput C_Period) {
		this.mC_Period = C_Period;
		MPeriod foreignEntity;
		if (get_ID() == 0 && C_Period != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Period", "C_Period_UU=?", get_TrxName())
							.setParameters(C_Period.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Period_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Period with UUID " + C_Period.getUUID());
			}
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

	public void setC_PeriodControl_ID(int C_PeriodControl_ID) {
		if (get_ID() == 0) {
			super.setC_PeriodControl_ID(C_PeriodControl_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_PeriodControl_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_PeriodControl_UU();
	}

	/**
	 * Set Document BaseType.
	 *
	 * @param DocBaseType Logical type of document
	 */
	@JsonProperty("DocBaseType")
	public void setDocBaseTypeInput(I_AD_Ref_ListInput DocBaseType) {
		this.mDocBaseType = DocBaseType;
		MRefList_BH foreignEntity;
		if (get_ID() == 0 &&DocBaseType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocBaseType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDocBaseType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DocBaseType.getUUID());
			}
		}
	}

	/**
	 * Get Document BaseType.
	 *
	 * @return Logical type of document
	 */
	@JsonProperty("DocBaseType")
	public I_AD_Ref_ListInput DocBaseType() {
		return mDocBaseType;
	}

	/**
	 * Set Period Action.
	 *
	 * @param PeriodAction Action taken for this period
	 */
	@JsonProperty("PeriodAction")
	public void setPeriodActionInput(I_AD_Ref_ListInput PeriodAction) {
		this.mPeriodAction = PeriodAction;
		MRefList_BH foreignEntity;
		if (PeriodAction != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PeriodAction.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPeriodAction(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + PeriodAction.getUUID());
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
	public I_AD_Ref_ListInput PeriodAction() {
		return mPeriodAction;
	}

	/**
	 * Set Period Status.
	 *
	 * @param PeriodStatus Current state of this period
	 */
	@JsonProperty("PeriodStatus")
	public void setPeriodStatusInput(I_AD_Ref_ListInput PeriodStatus) {
		this.mPeriodStatus = PeriodStatus;
		MRefList_BH foreignEntity;
		if (get_ID() == 0 &&PeriodStatus != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PeriodStatus.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPeriodStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + PeriodStatus.getUUID());
			}
		}
	}

	/**
	 * Get Period Status.
	 *
	 * @return Current state of this period
	 */
	@JsonProperty("PeriodStatus")
	public I_AD_Ref_ListInput PeriodStatus() {
		return mPeriodStatus;
	}
}
