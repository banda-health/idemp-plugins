package org.bandahealth.idempiere.base.model;
import java.sql.ResultSet; import java.util.Properties;
public class MBHVisitFamilyPlanning extends X_BH_Visit_Family_Planning {
	public MBHVisitFamilyPlanning(Properties ctx, int id, String trxName) { super(ctx, id, trxName); }
	public MBHVisitFamilyPlanning(Properties ctx, int id, String trxName, String... virtualColumns) { super(ctx, id, trxName, virtualColumns); }
	public MBHVisitFamilyPlanning(Properties ctx, String uu, String trxName) { super(ctx, uu, trxName); }
	public MBHVisitFamilyPlanning(Properties ctx, String uu, String trxName, String... virtualColumns) { super(ctx, uu, trxName, virtualColumns); }
	public MBHVisitFamilyPlanning(Properties ctx, ResultSet rs, String trxName) { super(ctx, rs, trxName); }
}
