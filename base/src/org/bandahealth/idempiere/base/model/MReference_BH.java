package org.bandahealth.idempiere.base.model;

import org.compiere.model.MReference;

import java.sql.ResultSet;
import java.util.Properties;

public class MReference_BH extends MReference {
	public static final String USER_TYPE_AD_REFERENCE_UU = "5b41f508-5ce5-4b42-80de-713e10580d51";
	public static final String NON_PATIENT_PAYER_AD_REFERENCE_UU = "b313a870-0826-4c1d-a9af-f9ec990b4375";
	public static final String PAYER_INFORMATION_FIELD_DATA_TYPE_AD_REFERENCE_UU = "15b3f5d7-205a-4d91-84c0" +
			"-5e38ec36b6c6";
	public static final String PAYROLL_AUDIT_ACTION_AD_REFERENCE_UU = "585d06a8-a4b5-4fd6-8991-55a11653c15d";
	public static final String TENDER_TYPE_AD_REFERENCE_UU = "9d124599-d720-436b-a609-011bcf2eff8e";
	public static final String REPORT_TENDER_TYPE_AD_REFERENCE_UU = "7eca6283-86b9-4dff-9c40-786162a8be7a";
	public static final String STOCK_UPDATE_REASONS_AD_REFERENCE_UU = "dcdc79d7-8e55-428f-a8a5-e7a6f562404f";
	public static final String ENCOUNTER_TYPES = "ced05cde-f4e6-4d72-9134-c16e27eb963f";
	public static final String TAGS_PARAMETER = "Tags";
	/**
	 * Reference suffix for IDs
	 * TODO: Remove this when all reports use UUIDs instead of IDs
	 */
	public static final String SUFFIX_ID = "id";
	private static final long serialVersionUID = 1L;

	public MReference_BH(Properties ctx, String AD_Reference_UU, String trxName) {
		super(ctx, AD_Reference_UU, trxName);
	}

	public MReference_BH(Properties ctx, int AD_Reference_ID, String trxName) {
		super(ctx, AD_Reference_ID, trxName);
	}

	public MReference_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MReference_BH(MReference copy) {
		super(copy);
	}

	public MReference_BH(Properties ctx, MReference copy) {
		super(ctx, copy);
	}

	public MReference_BH(Properties ctx, MReference copy, String trxName) {
		super(ctx, copy, trxName);
	}
}
