package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MSequence_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Sequence_No;

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
	 * Standard constructor
	 */
	@JsonCreator
	public X_AD_Sequence_NoInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_AD_Sequence_No(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Sequence.
	 *
	 * @param AD_Sequence Document Sequence
	 */
	@JsonProperty("AD_Sequence")
	public void setAD_SequenceInput(ForeignEntityInput AD_Sequence) {
		this.mAD_Sequence = AD_Sequence;
		MSequence_BH foreignEntity;
		if (get_ID() == 0 && AD_Sequence != null &&
				(foreignEntity = new Query(getCtx(), "AD_Sequence", "AD_Sequence_UU=?", get_TrxName())
						.setParameters(AD_Sequence.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Sequence_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setAD_Sequence_No_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
