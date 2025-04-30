package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_C_RevenueRecognitionResolver;
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
 * @version Release 12 - $Id$
 */
public class X_C_RevenueRecognitionInput extends MRevenueRecognition implements I_C_RevenueRecognitionInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mRecognitionFrequency;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_RevenueRecognition_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_RevenueRecognitionInput(@JsonProperty("UU") String UU) {
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
	/**
	 * Set Revenue Recognition.
	 *
	 * @param C_RevenueRecognition_ID Method for recording revenue
	 */
	@JsonProperty("C_RevenueRecognition_ID")
	public void setC_RevenueRecognition_IDFromJson(int C_RevenueRecognition_ID) {
		if (get_ID() == 0) {
			super.setC_RevenueRecognition_ID(C_RevenueRecognition_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_RevenueRecognition_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_RevenueRecognition_UU();
	}

	/**
	 * Set Recognition frequency.
	 *
	 * @param RecognitionFrequency Recognition frequency
	 */
	@JsonProperty("RecognitionFrequency")
	public void setRecognitionFrequencyInput(ForeignEntityInput RecognitionFrequency) {
		this.mRecognitionFrequency = RecognitionFrequency;
		if (RecognitionFrequency != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_RevenueRecognitionResolver.RECOGNITIONFREQUENCY_UUIDS_BY_VALUE.containsValue(RecognitionFrequency.getUU())) {
				throw new AdempiereException("The reference list UU of " + RecognitionFrequency.getUU() +
						" is not in the list defined for the RecognitionFrequency column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(RecognitionFrequency.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setRecognitionFrequency(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + RecognitionFrequency.getUU());
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
	public ForeignEntityInput RecognitionFrequency() {
		return mRecognitionFrequency;
	}
}
