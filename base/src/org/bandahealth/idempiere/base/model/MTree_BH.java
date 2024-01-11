package org.bandahealth.idempiere.base.model;

import org.compiere.model.MTree;

import java.sql.ResultSet;
import java.util.Properties;

public class MTree_BH extends MTree {
	public MTree_BH(Properties ctx, int AD_Tree_ID, String trxName) {
		super(ctx, AD_Tree_ID, trxName);
	}

	public MTree_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, 0, trxName);
	}
}
