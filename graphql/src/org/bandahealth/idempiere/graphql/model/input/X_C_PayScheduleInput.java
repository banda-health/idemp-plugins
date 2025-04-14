package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_C_PayScheduleResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPaySchedule;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_PaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_PayScheduleInput extends MPaySchedule implements I_C_PayScheduleInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_PaymentTerm;
	private ForeignEntityInput mNetDay;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_PaySchedule_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_PayScheduleInput(@JsonProperty("UU") String UU) {
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
	 * Set Payment Term.
	 *
	 * @param C_PaymentTerm The terms of Payment (timing, discount)
	 */
	@JsonProperty("C_PaymentTerm")
	public void setC_PaymentTermInput(ForeignEntityInput C_PaymentTerm) {
		this.mC_PaymentTerm = C_PaymentTerm;
		if (get_ID() != 0) {
			return;
		}
		if (C_PaymentTerm != null) {
			// Since an entity was passed, make sure it's in the DB
			MPaymentTerm foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_PaymentTerm", "C_PaymentTerm_UU=?", get_TrxName())
							.setParameters(C_PaymentTerm.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_PaymentTerm_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_PaymentTerm with UU " + C_PaymentTerm.getUU());
			}
		} else {
			this.setC_PaymentTerm_ID(0);
		}
	}

	/**
	 * Get Payment Term.
	 *
	 * @return The terms of Payment (timing, discount)
	 */
	@JsonProperty("C_PaymentTerm")
	public ForeignEntityInput C_PaymentTerm() {
		return mC_PaymentTerm;
	}
	/**
	 * Set Payment Schedule.
	 *
	 * @param C_PaySchedule_ID Payment Schedule Template
	 */
	@JsonProperty("C_PaySchedule_ID")
	public void setC_PaySchedule_IDFromJson(int C_PaySchedule_ID) {
		if (get_ID() == 0) {
			super.setC_PaySchedule_ID(C_PaySchedule_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_PaySchedule_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_PaySchedule_UU();
	}

	/**
	 * Set Net Day.
	 *
	 * @param NetDay Day when payment is due net
	 */
	@JsonProperty("NetDay")
	public void setNetDayInput(ForeignEntityInput NetDay) {
		this.mNetDay = NetDay;
		if (NetDay != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_PayScheduleResolver.NETDAY_UUIDS_BY_VALUE.containsValue(NetDay.getUU())) {
				throw new AdempiereException("The reference list UU of " + NetDay.getUU() +
						" is not in the list defined for the NetDay column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(NetDay.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setNetDay(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + NetDay.getUU());
			}
		} else {
			this.setNetDay(null);
		}
	}

	/**
	 * Get Net Day.
	 *
	 * @return Day when payment is due net
	 */
	@JsonProperty("NetDay")
	public ForeignEntityInput NetDay() {
		return mNetDay;
	}
}
