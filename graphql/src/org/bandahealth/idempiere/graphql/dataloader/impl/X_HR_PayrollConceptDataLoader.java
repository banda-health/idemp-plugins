package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_PayrollConcept;

/**
 * Data Loader for HR_PayrollConcept - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_PayrollConceptDataLoader extends PODataLoader<X_HR_PayrollConcept> {
	public static String HR_PayrollConcept_BY_ID_DATA_LOADER = "HR_PayrollConceptByIdDataLoader";
	public static String HR_PayrollConcept_BY_UUID_DATA_LOADER = "HR_PayrollConceptByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_PayrollConcept.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return HR_PayrollConcept_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return HR_PayrollConcept_BY_UUID_DATA_LOADER;
	}
}
