package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MForm;

/**
 * Data Loader for AD_Form - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_FormDataLoader extends PODataLoader<MForm> {
	public static String DATALOADER_AD_Form_BY_ID = "AD_FormByIdDataLoader";
	public static String DATALOADER_AD_Form_BY_UUID = "AD_FormByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MForm.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Form_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Form_BY_UUID;
	}
}
