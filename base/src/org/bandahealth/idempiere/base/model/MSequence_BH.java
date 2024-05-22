package org.bandahealth.idempiere.base.model;

import org.compiere.model.MSequence;

import java.sql.ResultSet;
import java.util.Properties;

public class MSequence_BH extends MSequence {

	private static final long serialVersionUID = 1L;

	public static final String GENERATE_PATIENT_NUMBER_SEQUENCE_TABLE_NAME_WITHOUT_PREFIX = "BH_PatientID_C_BPartner";

	public static final String GENERATE_PATIENT_NUMBER_SEQUENCE_TABLE_NAME_WITH_PREFIX =
			"DocumentNo_" + GENERATE_PATIENT_NUMBER_SEQUENCE_TABLE_NAME_WITHOUT_PREFIX;

	public MSequence_BH(Properties ctx, String AD_Sequence_UU, String trxName) {
		super(ctx, AD_Sequence_UU, trxName);
	}

	public MSequence_BH(Properties ctx, int AD_Sequence_ID, String trxName) {
		super(ctx, AD_Sequence_ID, trxName);
	}

	public MSequence_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MSequence_BH(Properties ctx, int AD_Client_ID, String tableName, String trxName) {
		super(ctx, AD_Client_ID, tableName, trxName);
	}

	public MSequence_BH(Properties ctx, int AD_Client_ID, String sequenceName, int StartNo, String trxName) {
		super(ctx, AD_Client_ID, sequenceName, StartNo, trxName);
	}
}
