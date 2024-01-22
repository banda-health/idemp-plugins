package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRevenueRecognition;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_RevenueRecognition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_RevenueRecognitionInput extends MRevenueRecognition implements I_C_RevenueRecognitionInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mRecognitionFrequency;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_RevenueRecognitionInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MRevenueRecognition(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Revenue Recognition.
	 *
	 * @param C_RevenueRecognition_ID Method for recording revenue
	 */

	public void setC_RevenueRecognition_ID(int C_RevenueRecognition_ID) {
		if (get_ID() == 0) {
			super.setC_RevenueRecognition_ID(C_RevenueRecognition_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_RevenueRecognition_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_RevenueRecognition_UU();
	}

	/**
	 * Set Recognition frequency.
	 *
	 * @param RecognitionFrequency Recognition frequency
	 */
	@JsonProperty("RecognitionFrequency")
	public void setRecognitionFrequencyInput(I_AD_Ref_ListInput RecognitionFrequency) {
		this.mRecognitionFrequency = RecognitionFrequency;
		MRefList_BH foreignEntity;
		if (RecognitionFrequency != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(RecognitionFrequency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setRecognitionFrequency(foreignEntity.getValue());
		} else {
			this.setRecognitionFrequency(null);
		}
	}

	/**
	 * Get Recognition frequency.
	 *
	 * @return Recognition frequency
	 */
	@JsonProperty("RecognitionFrequency")
	public I_AD_Ref_ListInput RecognitionFrequency() {
		return mRecognitionFrequency;
	}
}
