package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_Concept_Acct;

/**
 * Data Loader for HR_Concept_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_Concept_AcctDataLoader extends PODataLoader<X_HR_Concept_Acct> {
	public static String DATALOADER_HR_Concept_Acct_BY_ID = "HR_Concept_AcctByIdDataLoader";
	public static String DATALOADER_HR_Concept_Acct_BY_UUID = "HR_Concept_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_Concept_Acct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_HR_Concept_Acct_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_HR_Concept_Acct_BY_UUID;
	}
}
