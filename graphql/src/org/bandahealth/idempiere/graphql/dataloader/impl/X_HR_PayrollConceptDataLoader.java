package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_PayrollConcept;

/**
 * Data Loader for HR_PayrollConcept - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_HR_PayrollConceptDataLoader extends PODataLoader<X_HR_PayrollConcept> {
	public static String DATALOADER_HR_PayrollConcept_BY_ID = "HR_PayrollConceptByIdDataLoader";
	public static String DATALOADER_HR_PayrollConcept_BY_UUID = "HR_PayrollConceptByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_PayrollConcept.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_HR_PayrollConcept_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_HR_PayrollConcept_BY_UUID;
	}
}
