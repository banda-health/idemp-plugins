package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHPayrollAudit;

/**
 * Data Loader for BH_Payroll_Audit - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Payroll_AuditDataLoader extends PODataLoader<MBHPayrollAudit> {
	public static String DATALOADER_BH_Payroll_Audit_BY_ID = "BH_Payroll_AuditByIdDataLoader";
	public static String DATALOADER_BH_Payroll_Audit_BY_UUID = "BH_Payroll_AuditByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHPayrollAudit.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Payroll_Audit_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Payroll_Audit_BY_UUID;
	}
}
