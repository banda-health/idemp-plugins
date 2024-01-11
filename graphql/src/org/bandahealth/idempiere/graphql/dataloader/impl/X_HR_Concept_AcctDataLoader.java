package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_Concept_Acct;

/**
 * Data Loader for HR_Concept_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_Concept_AcctDataLoader extends PODataLoader<X_HR_Concept_Acct> {
	public static String HR_Concept_Acct_BY_ID_DATA_LOADER = "HR_Concept_AcctByIdDataLoader";
	public static String HR_Concept_Acct_BY_UUID_DATA_LOADER = "HR_Concept_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_Concept_Acct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return HR_Concept_Acct_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return HR_Concept_Acct_BY_UUID_DATA_LOADER;
	}
}
