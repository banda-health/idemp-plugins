package org.bandahealth.idempiere.base.model;

import org.compiere.model.MReference;

import java.sql.ResultSet;
import java.util.Properties;

public class MReference_BH extends MReference {
	public static final String USER_TYPE_AD_REFERENCE_UU = "5b41f508-5ce5-4b42-80de-713e10580d51";
	public static final String NON_PATIENT_PAYMENT_AD_REFERENCE_UU = "b313a870-0826-4c1d-a9af-f9ec990b4375";
	public static final String CHARGE_INFORMATION_DATA_TYPE_AD_REFERENCE_UU = "15b3f5d7-205a-4d91-84c0-5e38ec36b6c6";
	public static final String TENDER_TYPE_AD_REFERENCE_UU = "9d124599-d720-436b-a609-011bcf2eff8e";
	public static final String STOCK_UPDATE_REASONS_AD_REFERENCE_UU = "dcdc79d7-8e55-428f-a8a5-e7a6f562404f";
	/**
	 * This represents the reference IDs for all document actions in the system
	 */
	public static final int DOCUMENT_ACTION_AD_REFERENCE_ID = 135;
	/**
	 * This represents the reference ID for date types in the system
	 */
	public static final int DATE_AD_REFERENCE_ID = 15;
	/**
	 * This represents the reference ID for date/time types in the system
	 */
	public static final int DATETIME_AD_REFERENCE_ID = 16;
	/**
	 * This represents the reference ID for list types in the system
	 */
	public static final int LIST_AD_REFERENCE_ID = 17;
	/**
	 * Reference suffix for IDs
	 * TODO: Remove this when all reports use UUIDs instead of IDs
	 */
	public static final String SUFFIX_ID = "id";
	private static final long serialVersionUID = 1L;

	public MReference_BH(Properties ctx, int AD_Reference_ID, String trxName) {
		super(ctx, AD_Reference_ID, trxName);
	}

	public MReference_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
