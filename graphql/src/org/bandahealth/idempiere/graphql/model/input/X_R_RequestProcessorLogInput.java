package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRequestProcessor;
import org.compiere.model.MRequestProcessorLog;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for R_RequestProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_RequestProcessorLogInput extends MRequestProcessorLog implements I_R_RequestProcessorLogInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mR_RequestProcessor;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The R_RequestProcessorLog_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_R_RequestProcessorLogInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MRequestProcessorLog(null, (ResultSet) null, null),
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
	 * Set Request Processor.
	 *
	 * @param R_RequestProcessor Processor for Requests
	 */
	@JsonProperty("R_RequestProcessor")
	public void setR_RequestProcessorInput(ForeignEntityInput R_RequestProcessor) {
		this.mR_RequestProcessor = R_RequestProcessor;
		if (get_ID() != 0) {
			return;
		}
		if (R_RequestProcessor != null) {
			// Since an entity was passed, make sure it's in the DB
			MRequestProcessor foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "R_RequestProcessor", "R_RequestProcessor_UU=?", get_TrxName())
							.setParameters(R_RequestProcessor.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_RequestProcessor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table R_RequestProcessor with UUID " + R_RequestProcessor.getUUID());
			}
		} else {
			this.setR_RequestProcessor_ID(0);
		}
	}

	/**
	 * Get Request Processor.
	 *
	 * @return Processor for Requests
	 */
	@JsonProperty("R_RequestProcessor")
	public ForeignEntityInput R_RequestProcessor() {
		return mR_RequestProcessor;
	}
	/**
	 * Set Request Processor Log.
	 *
	 * @param R_RequestProcessorLog_ID Result of the execution of the Request Processor
	 */

	public void setR_RequestProcessorLog_ID(int R_RequestProcessorLog_ID) {
		if (get_ID() == 0) {
			super.setR_RequestProcessorLog_ID(R_RequestProcessorLog_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setR_RequestProcessorLog_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getR_RequestProcessorLog_UU();
	}
}
