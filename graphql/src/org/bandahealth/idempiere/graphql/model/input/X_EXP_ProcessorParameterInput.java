package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEXPProcessor;
import org.compiere.model.MEXPProcessorParameter;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for EXP_ProcessorParameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_EXP_ProcessorParameterInput extends MEXPProcessorParameter implements I_EXP_ProcessorParameterInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mEXP_Processor;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_EXP_ProcessorParameterInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MEXPProcessorParameter(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
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
	 * Set Export Processor.
	 *
	 * @param EXP_Processor Export Processor
	 */
	@JsonProperty("EXP_Processor")
	public void setEXP_ProcessorInput(ForeignEntityInput EXP_Processor) {
		this.mEXP_Processor = EXP_Processor;
		MEXPProcessor foreignEntity;
		if (get_ID() == 0 && EXP_Processor != null &&
				(foreignEntity = new Query(getCtx(), "EXP_Processor", "EXP_Processor_UU=?", get_TrxName())
						.setParameters(EXP_Processor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setEXP_Processor_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Export Processor.
	 *
	 * @return Export Processor
	 */
	@JsonProperty("EXP_Processor")
	public ForeignEntityInput EXP_Processor() {
		return mEXP_Processor;
	}
	/**
	 * Set Processor Parameter.
	 *
	 * @param EXP_ProcessorParameter_ID Processor Parameter
	 */

	public void setEXP_ProcessorParameter_ID(int EXP_ProcessorParameter_ID) {
		if (get_ID() == 0) {
			super.setEXP_ProcessorParameter_ID(EXP_ProcessorParameter_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setEXP_ProcessorParameter_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getEXP_ProcessorParameter_UU();
	}
}
