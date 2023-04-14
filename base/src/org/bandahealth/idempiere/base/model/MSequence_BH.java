package org.bandahealth.idempiere.base.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MSequence;

public class MSequence_BH extends MSequence {

	private static final long serialVersionUID = 1L;
	
	public static final String GENERERATE_PATIENT_NUMBER_SEQUENCE_TABLE_NAME_WITHOUT_PREFIX = "BH_PatientID_C_BPartner";
	
	public static final String GENERERATE_PATIENT_NUMBER_SEQUENCE_TABLE_NAME_WITH_PREFIX = 
			"DocumentNo_" + GENERERATE_PATIENT_NUMBER_SEQUENCE_TABLE_NAME_WITHOUT_PREFIX;

	public MSequence_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MSequence_BH(Properties ctx, int C_BPartner_ID, String trxName) {
		super(ctx, C_BPartner_ID, trxName);
	}
}
