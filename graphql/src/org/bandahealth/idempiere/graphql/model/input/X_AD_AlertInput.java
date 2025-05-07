package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAlert;
import org.compiere.model.MAlertProcessor;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Alert - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_AlertInput extends MAlert implements I_AD_AlertInput {

	private ForeignEntityInput mAD_AlertProcessor;
	private ForeignEntityInput mAD_Org;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The AD_Alert_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_AlertInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}
	/**
	 * Set Alert.
	 *
	 * @param AD_Alert_ID iDempiere Alert
	 */
	@JsonProperty("AD_Alert_ID")
	public void setAD_Alert_IDFromJson(int AD_Alert_ID) {
		if (get_ID() == 0) {
			super.setAD_Alert_ID(AD_Alert_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setAD_Alert_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getAD_Alert_UU();
	}

	/**
	 * Set Alert Processor.
	 *
	 * @param AD_AlertProcessor Alert Processor/Server Parameter
	 */
	@JsonProperty("AD_AlertProcessor")
	public void setAD_AlertProcessorInput(ForeignEntityInput AD_AlertProcessor) {
		this.mAD_AlertProcessor = AD_AlertProcessor;
		if (AD_AlertProcessor != null) {
			// Since an entity was passed, make sure it's in the DB
			MAlertProcessor foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_AlertProcessor", "AD_AlertProcessor_UU=?", get_TrxName())
							.setParameters(AD_AlertProcessor.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_AlertProcessor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_AlertProcessor with UU " + AD_AlertProcessor.getUU());
			}
		} else {
			this.setAD_AlertProcessor_ID(0);
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
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (!is_new()) {
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
}
