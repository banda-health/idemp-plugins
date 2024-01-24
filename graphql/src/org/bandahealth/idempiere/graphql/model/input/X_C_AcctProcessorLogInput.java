package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctProcessor;
import org.compiere.model.MAcctProcessorLog;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_AcctProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AcctProcessorLogInput extends MAcctProcessorLog implements I_C_AcctProcessorLogInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AcctProcessor;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_AcctProcessorLogInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MAcctProcessorLog(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Accounting Processor.
	 *
	 * @param C_AcctProcessor Accounting Processor/Server Parameters
	 */
	@JsonProperty("C_AcctProcessor")
	public void setC_AcctProcessorInput(ForeignEntityInput C_AcctProcessor) {
		this.mC_AcctProcessor = C_AcctProcessor;
		MAcctProcessor foreignEntity;
		if (get_ID() == 0 && C_AcctProcessor != null &&
				(foreignEntity = new Query(getCtx(), "C_AcctProcessor", "C_AcctProcessor_UU=?", get_TrxName())
						.setParameters(C_AcctProcessor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_AcctProcessor_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Accounting Processor.
	 *
	 * @return Accounting Processor/Server Parameters
	 */
	@JsonProperty("C_AcctProcessor")
	public ForeignEntityInput C_AcctProcessor() {
		return mC_AcctProcessor;
	}
	/**
	 * Set Accounting Processor Log.
	 *
	 * @param C_AcctProcessorLog_ID Result of the execution of the Accounting Processor
	 */

	public void setC_AcctProcessorLog_ID(int C_AcctProcessorLog_ID) {
		if (get_ID() == 0) {
			super.setC_AcctProcessorLog_ID(C_AcctProcessorLog_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_AcctProcessorLog_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_AcctProcessorLog_UU();
	}
}
