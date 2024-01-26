package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRevenueRecogService;
import org.compiere.model.MRevenueRecognition;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_RevenueRecog_Service - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RevenueRecog_ServiceInput extends MRevenueRecogService implements I_C_RevenueRecog_ServiceInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_RevenueRecognition;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_RevenueRecog_Service_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_RevenueRecog_ServiceInput(@JsonProperty("UUID") String UUID) {
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
	 * Set Revenue Recognition Service.
	 *
	 * @param C_RevenueRecog_Service_ID Revenue Recognition Service
	 */

	public void setC_RevenueRecog_Service_ID(int C_RevenueRecog_Service_ID) {
		if (get_ID() == 0) {
			super.setC_RevenueRecog_Service_ID(C_RevenueRecog_Service_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_RevenueRecog_Service_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_RevenueRecog_Service_UU();
	}

	/**
	 * Set Revenue Recognition.
	 *
	 * @param C_RevenueRecognition Method for recording revenue
	 */
	@JsonProperty("C_RevenueRecognition")
	public void setC_RevenueRecognitionInput(ForeignEntityInput C_RevenueRecognition) {
		this.mC_RevenueRecognition = C_RevenueRecognition;
		if (get_ID() != 0) {
			return;
		}
		if (C_RevenueRecognition != null) {
			// Since an entity was passed, make sure it's in the DB
			MRevenueRecognition foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_RevenueRecognition", "C_RevenueRecognition_UU=?", get_TrxName())
							.setParameters(C_RevenueRecognition.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_RevenueRecognition_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_RevenueRecognition with UUID " + C_RevenueRecognition.getUUID());
			}
		} else {
			this.setC_RevenueRecognition_ID(0);
		}
	}

	/**
	 * Get Revenue Recognition.
	 *
	 * @return Method for recording revenue
	 */
	@JsonProperty("C_RevenueRecognition")
	public ForeignEntityInput C_RevenueRecognition() {
		return mC_RevenueRecognition;
	}
}
