package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_IMP_Processor;
import org.compiere.model.X_IMP_ProcessorParameter;

import java.sql.ResultSet;

/**
 * Generated Model for IMP_ProcessorParameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_IMP_ProcessorParameterInput extends X_IMP_ProcessorParameter implements I_IMP_ProcessorParameterInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mIMP_Processor;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_IMP_ProcessorParameterInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_IMP_ProcessorParameter(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Import Processor.
	 *
	 * @param IMP_Processor Import Processor
	 */
	@JsonProperty("IMP_Processor")
	public void setIMP_ProcessorInput(ForeignEntityInput IMP_Processor) {
		this.mIMP_Processor = IMP_Processor;
		X_IMP_Processor foreignEntity;
		if (get_ID() == 0 && IMP_Processor != null &&
				(foreignEntity = new Query(getCtx(), "IMP_Processor", "IMP_Processor_UU=?", get_TrxName())
						.setParameters(IMP_Processor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setIMP_Processor_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Import Processor.
	 *
	 * @return Import Processor
	 */
	@JsonProperty("IMP_Processor")
	public ForeignEntityInput IMP_Processor() {
		return mIMP_Processor;
	}
	/**
	 * Set Import Processor Parameter.
	 *
	 * @param IMP_ProcessorParameter_ID Import Processor Parameter
	 */

	public void setIMP_ProcessorParameter_ID(int IMP_ProcessorParameter_ID) {
		if (get_ID() == 0) {
			super.setIMP_ProcessorParameter_ID(IMP_ProcessorParameter_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setIMP_ProcessorParameter_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getIMP_ProcessorParameter_UU();
	}
}
