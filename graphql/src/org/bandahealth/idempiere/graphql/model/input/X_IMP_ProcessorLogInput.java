package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MIMPProcessor;
import org.compiere.model.MIMPProcessorLog;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for IMP_ProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_IMP_ProcessorLogInput extends MIMPProcessorLog implements I_IMP_ProcessorLogInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mIMP_Processor;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The IMP_ProcessorLog_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_IMP_ProcessorLogInput(@JsonProperty("UU") String UU) {
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
	 * Set Import Processor.
	 *
	 * @param IMP_Processor Import Processor
	 */
	@JsonProperty("IMP_Processor")
	public void setIMP_ProcessorInput(ForeignEntityInput IMP_Processor) {
		this.mIMP_Processor = IMP_Processor;
		if (get_ID() != 0) {
			return;
		}
		if (IMP_Processor != null) {
			// Since an entity was passed, make sure it's in the DB
			MIMPProcessor foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "IMP_Processor", "IMP_Processor_UU=?", get_TrxName())
							.setParameters(IMP_Processor.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setIMP_Processor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table IMP_Processor with UU " + IMP_Processor.getUU());
			}
		} else {
			this.setIMP_Processor_ID(0);
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
	 * Set Import Processor Log.
	 *
	 * @param IMP_ProcessorLog_ID Import Processor Log
	 */
	@JsonProperty("IMP_ProcessorLog_ID")
	public void setIMP_ProcessorLog_IDFromJson(int IMP_ProcessorLog_ID) {
		if (get_ID() == 0) {
			super.setIMP_ProcessorLog_ID(IMP_ProcessorLog_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setIMP_ProcessorLog_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getIMP_ProcessorLog_UU();
	}
}
