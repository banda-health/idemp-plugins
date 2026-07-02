package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.compiere.util.Env;

public class MBHSickOffPrintLogInput extends X_BH_SickOff_Print_LogInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_SickOff_Print_Log_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHSickOffPrintLogInput(@JsonProperty("UU") String UU) {
		super(UU);
		// PrintedBy is never client-settable -- always the authenticated user making the request,
		// so a reprint log can't be spoofed by whatever the frontend happens to send.
		if (is_new()) {
			setPrintedBy(Env.getAD_User_ID(getCtx()));
		}
	}
}
