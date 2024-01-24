package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_Subscription;
import org.compiere.model.X_C_SubscriptionType;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_Subscription - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_SubscriptionInput extends X_C_Subscription implements I_C_SubscriptionInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_SubscriptionType;
	private ForeignEntityInput mM_Product;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_Subscription_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_SubscriptionInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_C_Subscription(null, (ResultSet) null, null),
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
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_BPartner.getUUID());
			}
		} else {
			super.setC_BPartner_ID(0);
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
	 * Set Subscription.
	 *
	 * @param C_Subscription_ID Subscription of a Business Partner of a Product to renew
	 */

	public void setC_Subscription_ID(int C_Subscription_ID) {
		if (get_ID() == 0) {
			super.setC_Subscription_ID(C_Subscription_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_Subscription_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_Subscription_UU();
	}

	/**
	 * Set Subscription Type.
	 *
	 * @param C_SubscriptionType Type of subscription
	 */
	@JsonProperty("C_SubscriptionType")
	public void setC_SubscriptionTypeInput(ForeignEntityInput C_SubscriptionType) {
		this.mC_SubscriptionType = C_SubscriptionType;
		X_C_SubscriptionType foreignEntity;
		if (C_SubscriptionType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_SubscriptionType", "C_SubscriptionType_UU=?", get_TrxName())
							.setParameters(C_SubscriptionType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_SubscriptionType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_SubscriptionType with UUID " + C_SubscriptionType.getUUID());
			}
		} else {
			super.setC_SubscriptionType_ID(0);
		}
	}

	/**
	 * Get Subscription Type.
	 *
	 * @return Type of subscription
	 */
	@JsonProperty("C_SubscriptionType")
	public ForeignEntityInput C_SubscriptionType() {
		return mC_SubscriptionType;
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		MProduct_BH foreignEntity;
		if (M_Product != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UUID " + M_Product.getUUID());
			}
		} else {
			super.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public ForeignEntityInput M_Product() {
		return mM_Product;
	}
}
