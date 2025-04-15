package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_Subscription;
import org.compiere.model.X_C_Subscription_Delivery;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_Subscription_Delivery - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_Subscription_DeliveryInput extends X_C_Subscription_Delivery implements I_C_Subscription_DeliveryInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Subscription;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_Subscription_Delivery_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_Subscription_DeliveryInput(@JsonProperty("UU") String UU) {
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
	 * Set Subscription Delivery.
	 *
	 * @param C_Subscription_Delivery_ID Optional Delivery Record for a Subscription
	 */
	@JsonProperty("C_Subscription_Delivery_ID")
	public void setC_Subscription_Delivery_IDFromJson(int C_Subscription_Delivery_ID) {
		if (get_ID() == 0) {
			super.setC_Subscription_Delivery_ID(C_Subscription_Delivery_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_Subscription_Delivery_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_Subscription_Delivery_UU();
	}

	/**
	 * Set Subscription.
	 *
	 * @param C_Subscription Subscription of a Business Partner of a Product to renew
	 */
	@JsonProperty("C_Subscription")
	public void setC_SubscriptionInput(ForeignEntityInput C_Subscription) {
		this.mC_Subscription = C_Subscription;
		if (get_ID() != 0) {
			return;
		}
		if (C_Subscription != null) {
			// Since an entity was passed, make sure it's in the DB
			X_C_Subscription foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Subscription", "C_Subscription_UU=?", get_TrxName())
							.setParameters(C_Subscription.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Subscription_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Subscription with UU " + C_Subscription.getUU());
			}
		} else {
			this.setC_Subscription_ID(0);
		}
	}

	/**
	 * Get Subscription.
	 *
	 * @return Subscription of a Business Partner of a Product to renew
	 */
	@JsonProperty("C_Subscription")
	public ForeignEntityInput C_Subscription() {
		return mC_Subscription;
	}
}
