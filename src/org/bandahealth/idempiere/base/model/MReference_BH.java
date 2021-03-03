package org.bandahealth.idempiere.base.model;

import org.compiere.model.MReference;

import java.sql.ResultSet;
import java.util.Properties;

public class MReference_BH extends MReference {
	public static final String USER_TYPE_AD_REFERENCE_UU = "5b41f508-5ce5-4b42-80de-713e10580d51";
	/**
	 * This represents the reference IDs for all document actions in the system
	 */
	public static final int DOCUMENT_ACTION_AD_REFERENCE_ID = 135;

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
