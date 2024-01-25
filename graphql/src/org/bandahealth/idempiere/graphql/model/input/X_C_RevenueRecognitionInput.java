package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MRevenueRecognition;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_RevenueRecognition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RevenueRecognitionInput extends MRevenueRecognition implements I_C_RevenueRecognitionInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mRecognitionFrequency;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_RevenueRecognition_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_RevenueRecognitionInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MRevenueRecognition(null, (ResultSet) null, null),
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_RevenueRecognition_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (RecognitionFrequency != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(RecognitionFrequency.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setRecognitionFrequency(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + RecognitionFrequency.getUUID());
			}
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
