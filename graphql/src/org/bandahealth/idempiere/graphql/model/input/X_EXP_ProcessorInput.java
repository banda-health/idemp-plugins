package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MEXPProcessor;
import org.compiere.model.MEXPProcessorType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for EXP_Processor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_EXP_ProcessorInput extends MEXPProcessor implements I_EXP_ProcessorInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_EXP_Processor_TypeInput mEXP_Processor_Type;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_EXP_ProcessorInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Export Processor Type.
	 *
	 * @param EXP_Processor_Type Export Processor Type
	 */
	@JsonProperty("EXP_Processor_Type")
	public void setEXP_Processor_TypeInput(I_EXP_Processor_TypeInput EXP_Processor_Type) {
		this.mEXP_Processor_Type = EXP_Processor_Type;
		MEXPProcessorType foreignEntity;
		if (EXP_Processor_Type != null &&
				(foreignEntity = new Query(getCtx(), MEXPProcessorType.Table_Name, MEXPProcessorType.COLUMNNAME_EXP_Processor_Type_UU + "=?", get_TrxName())
						.setParameters(EXP_Processor_Type.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setEXP_Processor_Type_ID(foreignEntity.get_ID());
		} else {
			super.setEXP_Processor_Type_ID(0);
		}
	}

	/**
	 * Get Export Processor Type.
	 *
	 * @return Export Processor Type
	 */
	@JsonProperty("EXP_Processor_Type")
	public I_EXP_Processor_TypeInput EXP_Processor_Type() {
		return mEXP_Processor_Type;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setEXP_Processor_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getEXP_Processor_UU();
	}
}
