package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPaymentTerm;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_PaymentTerm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentTermInput extends MPaymentTerm implements I_C_PaymentTermInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mNetDay;
	private I_AD_Ref_ListInput mPaymentTermUsage;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_PaymentTerm_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_PaymentTermInput(@JsonProperty("UUID") String UUID) {
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * Set Payment Term.
	 *
	 * @param C_PaymentTerm_ID The terms of Payment (timing, discount)
	 */

	public void setC_PaymentTerm_ID(int C_PaymentTerm_ID) {
		if (get_ID() == 0) {
			super.setC_PaymentTerm_ID(C_PaymentTerm_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_PaymentTerm_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_PaymentTerm_UU();
	}

	/**
	 * Set Net Day.
	 *
	 * @param NetDay Day when payment is due net
	 */
	@JsonProperty("NetDay")
	public void setNetDayInput(I_AD_Ref_ListInput NetDay) {
		this.mNetDay = NetDay;
		if (NetDay != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(NetDay.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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

	/**
	 * Set Payment Term Usage.
	 *
	 * @param PaymentTermUsage Payment term usage indicates if this payment term is used for sales, purchases or both.
	 */
	@JsonProperty("PaymentTermUsage")
	public void setPaymentTermUsageInput(I_AD_Ref_ListInput PaymentTermUsage) {
		this.mPaymentTermUsage = PaymentTermUsage;
		if (PaymentTermUsage != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PaymentTermUsage.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPaymentTermUsage(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + PaymentTermUsage.getUUID());
			}
		} else {
			this.setPaymentTermUsage(null);
		}
	}

	/**
	 * Get Payment Term Usage.
	 *
	 * @return Payment term usage indicates if this payment term is used for sales, purchases or both.
	 */
	@JsonProperty("PaymentTermUsage")
	public I_AD_Ref_ListInput PaymentTermUsage() {
		return mPaymentTermUsage;
	}
}
