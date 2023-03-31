package org.bandahealth.idempiere.base.model;

import org.compiere.model.MProcess;

import java.sql.ResultSet;
import java.util.Properties;

public class MProcess_BH extends MProcess {
	public static final int PROCESSID_PROCESS_ORDERS = 104;
	public static final int PROCESSID_PROCESS_INVENTORY_COUNT = 107;
	public static final int PROCESSID_PROCESS_SHIPMENT = 109;
	public static final int PROCESSID_PROCESS_INVOICE = 111;
	public static final int PROCESSID_PROCESS_MOVEMENTS = 122;
	public static final int PROCESSID_PROCESS_CASH = 144;
	public static final int PROCESSID_PROCESS_STATEMENT = 147;
	public static final int PROCESSID_PROCESS_PAYMENT = 149;
	public static final int PROCESSID_PROCESS_ALLOCATION = 150;
	public static final int PROCESSID_PROCESS_JOURNAL = 169;
	public static final int PROCESSID_PROCESS_EXPENSES = 184;
	public static final int PROCESSID_PROCESS_BATCH = 188;
	public static final int PROCESSID_PROCESS_REQUISITION = 273;
	public static final int PROCESSID_PROCESS_RMA = 283;
	public static final int PROCESSID_PROCESS_MANUFACTURING_ORDER = 53026;
	public static final int PROCESSID_PROCESS_COST_COLLECTOR = 53038;
	public static final int PROCESSID_PROCESS_DISTRIBUTION_ORDER = 53042;
	public static final int PROCESSID_PROCESS_PAYROLL = 53076;
	public static final int PROCESSID_PROCESS_ENTRY = 53095;
	public static final int PROCESSID_PROCESS_DEPRECIATION_EXPENSE = 53211;
	public static final int PROCESSID_PROCESS_DEPRECIATION_ENTRY = 53214;
	public static final int PROCESSID_PROCESS_SHIPMENT_ONLINE = 200024;
	public static final int PROCESSID_PROCESS_PRODUCTION = 200068;

	public MProcess_BH(Properties ctx, int AD_Process_ID, String trxName) {
		super(ctx, AD_Process_ID, trxName);
	}

	public MProcess_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
}
