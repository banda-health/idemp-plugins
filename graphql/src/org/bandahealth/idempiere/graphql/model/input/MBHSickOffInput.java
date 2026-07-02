package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class MBHSickOffInput extends X_BH_SickOffInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_SickOff_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHSickOffInput(@JsonProperty("UU") String UU) {
		super(UU);
	}

	/**
	 * BH_SickOff is a snapshot taken when the note is issued — BH_Additional_Clinical_Notes/StartDate/EndDate
	 * are locked once the record exists. Corrections must void this record (IsActive=N) and create a new one.
	 */
	@Override
	public void setBH_Additional_Clinical_Notes(String BH_Additional_Clinical_Notes) {
		if (!is_new()) {
			return;
		}
		super.setBH_Additional_Clinical_Notes(BH_Additional_Clinical_Notes);
	}

	@Override
	public void setStartDate(Timestamp StartDate) {
		if (!is_new()) {
			return;
		}
		super.setStartDate(StartDate);
	}

	@Override
	public void setEndDate(Timestamp EndDate) {
		if (!is_new()) {
			return;
		}
		super.setEndDate(EndDate);
	}
}
