package org.bandahealth.idempiere.base.model;
import java.sql.ResultSet; import java.util.Properties;
public class MBHVisitFamilyPlanningProduct extends X_BH_Visit_Family_Planning_Product {
	public MBHVisitFamilyPlanningProduct(Properties ctx, int id, String trxName) { super(ctx, id, trxName); }
	public MBHVisitFamilyPlanningProduct(Properties ctx, int id, String trxName, String... virtualColumns) { super(ctx, id, trxName, virtualColumns); }
	public MBHVisitFamilyPlanningProduct(Properties ctx, String uu, String trxName) { super(ctx, uu, trxName); }
	public MBHVisitFamilyPlanningProduct(Properties ctx, String uu, String trxName, String... virtualColumns) { super(ctx, uu, trxName, virtualColumns); }
	public MBHVisitFamilyPlanningProduct(Properties ctx, ResultSet rs, String trxName) { super(ctx, rs, trxName); }
}
