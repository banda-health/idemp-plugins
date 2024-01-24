package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
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
 * @version Release 7.1 - $Id$
 */
public class X_C_PayScheduleInput extends MPaySchedule implements I_C_PayScheduleInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_PaymentTerm;
	private I_AD_Ref_ListInput mNetDay;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_PaySchedule_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_PayScheduleInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MPaySchedule(null, (ResultSet) null, null),
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
	 * Set Payment Term.
	 *
	 * @param C_PaymentTerm The terms of Payment (timing, discount)
	 */
	@JsonProperty("C_PaymentTerm")
	public void setC_PaymentTermInput(ForeignEntityInput C_PaymentTerm) {
		this.mC_PaymentTerm = C_PaymentTerm;
		MPaymentTerm foreignEntity;
		if (get_ID() == 0 && C_PaymentTerm != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_PaymentTerm", "C_PaymentTerm_UU=?", get_TrxName())
							.setParameters(C_PaymentTerm.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_PaymentTerm_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_PaymentTerm with UUID " + C_PaymentTerm.getUUID());
			}
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

	public void setC_PaySchedule_ID(int C_PaySchedule_ID) {
		if (get_ID() == 0) {
			super.setC_PaySchedule_ID(C_PaySchedule_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_PaySchedule_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_PaySchedule_UU();
	}

	/**
	 * Set Net Day.
	 *
	 * @param NetDay Day when payment is due net
	 */
	@JsonProperty("NetDay")
	public void setNetDayInput(I_AD_Ref_ListInput NetDay) {
		this.mNetDay = NetDay;
		MRefList_BH foreignEntity;
		if (NetDay != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(NetDay.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setNetDay(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + NetDay.getUUID());
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
	public I_AD_Ref_ListInput NetDay() {
		return mNetDay;
	}
}
