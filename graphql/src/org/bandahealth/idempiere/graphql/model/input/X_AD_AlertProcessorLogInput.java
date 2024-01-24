package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAlertProcessor;
import org.compiere.model.MAlertProcessorLog;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_AlertProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_AlertProcessorLogInput extends MAlertProcessorLog implements I_AD_AlertProcessorLogInput {

	private ForeignEntityInput mAD_AlertProcessor;
	private ForeignEntityInput mAD_Org;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_AlertProcessorLog_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_AlertProcessorLogInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MAlertProcessorLog(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Alert Processor.
	 *
	 * @param AD_AlertProcessor Alert Processor/Server Parameter
	 */
	@JsonProperty("AD_AlertProcessor")
	public void setAD_AlertProcessorInput(ForeignEntityInput AD_AlertProcessor) {
		this.mAD_AlertProcessor = AD_AlertProcessor;
		MAlertProcessor foreignEntity;
		if (get_ID() == 0 && AD_AlertProcessor != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_AlertProcessor", "AD_AlertProcessor_UU=?", get_TrxName())
							.setParameters(AD_AlertProcessor.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_AlertProcessor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_AlertProcessor with UUID " + AD_AlertProcessor.getUUID());
			}
		}
	}

	/**
	 * Get Alert Processor.
	 *
	 * @return Alert Processor/Server Parameter
	 */
	@JsonProperty("AD_AlertProcessor")
	public ForeignEntityInput AD_AlertProcessor() {
		return mAD_AlertProcessor;
	}
	/**
	 * Set Alert Processor Log.
	 *
	 * @param AD_AlertProcessorLog_ID Result of the execution of the Alert Processor
	 */

	public void setAD_AlertProcessorLog_ID(int AD_AlertProcessorLog_ID) {
		if (get_ID() == 0) {
			super.setAD_AlertProcessorLog_ID(AD_AlertProcessorLog_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_AlertProcessorLog_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_AlertProcessorLog_UU();
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
}
