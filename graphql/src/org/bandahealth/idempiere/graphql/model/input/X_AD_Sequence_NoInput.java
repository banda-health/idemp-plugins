package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MSequence_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Sequence_No;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for AD_Sequence_No - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_Sequence_NoInput extends X_AD_Sequence_No implements I_AD_Sequence_NoInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Sequence;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Sequence_No_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_AD_Sequence_NoInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_AD_Sequence_No(null, (ResultSet) null, null),
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

	/**
	 * Set Sequence.
	 *
	 * @param AD_Sequence Document Sequence
	 */
	@JsonProperty("AD_Sequence")
	public void setAD_SequenceInput(ForeignEntityInput AD_Sequence) {
		this.mAD_Sequence = AD_Sequence;
		MSequence_BH foreignEntity;
		if (get_ID() == 0 && AD_Sequence != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Sequence", "AD_Sequence_UU=?", get_TrxName())
							.setParameters(AD_Sequence.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Sequence_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Sequence with UUID " + AD_Sequence.getUUID());
			}
		}
	}

	/**
	 * Get Sequence.
	 *
	 * @return Document Sequence
	 */
	@JsonProperty("AD_Sequence")
	public ForeignEntityInput AD_Sequence() {
		return mAD_Sequence;
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setAD_Sequence_No_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getAD_Sequence_No_UU();
	}
	/**
	 * Set YearMonth.
	 *
	 * @param CalendarYearMonth YYYYMM
	 */

	public void setCalendarYearMonth(String CalendarYearMonth) {
		if (get_ID() == 0) {
			super.setCalendarYearMonth(CalendarYearMonth);
		}
	}
}
