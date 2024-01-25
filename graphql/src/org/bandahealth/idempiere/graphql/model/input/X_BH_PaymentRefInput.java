package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHPaymentRef;
import org.bandahealth.idempiere.base.model.MReference_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_PaymentRef - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_PaymentRefInput extends MBHPaymentRef implements I_BH_PaymentRefInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Reference;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_PaymentRef_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_PaymentRefInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MBHPaymentRef(null, (ResultSet) null, null),
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
	 * Set Reference.
	 *
	 * @param AD_Reference System Reference and Validation
	 */
	@JsonProperty("AD_Reference")
	public void setAD_ReferenceInput(ForeignEntityInput AD_Reference) {
		this.mAD_Reference = AD_Reference;
		if (AD_Reference != null) {
			// Since an entity was passed, make sure it's in the DB
			MReference_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Reference", "AD_Reference_UU=?", get_TrxName())
							.setParameters(AD_Reference.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Reference_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Reference with UUID " + AD_Reference.getUUID());
			}
		} else {
			this.setAD_Reference_ID(0);
		}
	}

	/**
	 * Get Reference.
	 *
	 * @return System Reference and Validation
	 */
	@JsonProperty("AD_Reference")
	public ForeignEntityInput AD_Reference() {
		return mAD_Reference;
	}
	/**
	 * Set BH_PaymentRef.
	 *
	 * @param BH_PaymentRef_ID BH_PaymentRef
	 */

	public void setBH_PaymentRef_ID(int BH_PaymentRef_ID) {
		if (get_ID() == 0) {
			super.setBH_PaymentRef_ID(BH_PaymentRef_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setBH_PaymentRef_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getBH_PaymentRef_UU();
	}
}
