package org.bandahealth.idempiere.base.model;

import org.compiere.model.MDocType;

import java.sql.ResultSet;
import java.util.Properties;

public class MDocType_BH extends MDocType {
	public static final int DOCTYPEID_NEW = 0;

	public MDocType_BH(Properties ctx, int C_DocType_ID, String trxName) {
		super(ctx, C_DocType_ID, trxName);
	}

	public MDocType_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MDocType_BH(Properties ctx, String DocBaseType, String Name, String trxName) {
		super(ctx, DocBaseType, Name, trxName);
	}

	public MDocType_BH(MDocType copy) {
		super(copy);
	}

	public MDocType_BH(Properties ctx, MDocType copy) {
		super(ctx, copy);
	}

	public MDocType_BH(Properties ctx, MDocType copy, String trxName) {
		super(ctx, copy, trxName);
	}
}
