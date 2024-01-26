package org.bandahealth.idempiere.base.model;

import org.compiere.model.MReplicationLog;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Since this parent class doesn't expose an ID constructor, we're adding one. Remove this in the future if that
 * changes.
 */
public class MReplicationLog_BH extends MReplicationLog {
	public MReplicationLog_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MReplicationLog_BH(Properties ctx, int AD_Replication_Log_ID, String trxName) {
		super(ctx, 0, 0, null, trxName);
	}
}
