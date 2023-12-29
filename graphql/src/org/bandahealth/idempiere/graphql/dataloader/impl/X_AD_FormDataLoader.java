package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MForm;

/**
 * Data Loader for AD_Form - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_FormDataLoader extends PODataLoader<MForm> {
	public static String AD_Form_BY_ID_DATA_LOADER = "AD_FormByIdDataLoader";
	public static String AD_Form_BY_UUID_DATA_LOADER = "AD_FormByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MForm.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Form_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Form_BY_UUID_DATA_LOADER;
	}
}
