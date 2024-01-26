package org.bandahealth.idempiere.base.model;

import org.compiere.model.MReplicationRun;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

/**
 * Since this parent class doesn't expose an ID constructor, we're adding one. Remove this in the future if that
 * changes.
 */
public class MReplicationRun_BH extends MReplicationRun {
	public MReplicationRun_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MReplicationRun_BH (Properties ctx, int AD_Replication_Run_ID, String trxName)
	{
		super (ctx, 0, new Timestamp(System.currentTimeMillis()), trxName);
	}
}
