package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRegistrationAttribute;

/**
 * Data Loader for A_RegistrationAttribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_RegistrationAttributeDataLoader extends PODataLoader<MRegistrationAttribute> {
	public static String DATALOADER_A_RegistrationAttribute_BY_ID = "A_RegistrationAttributeByIdDataLoader";
	public static String DATALOADER_A_RegistrationAttribute_BY_UUID = "A_RegistrationAttributeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRegistrationAttribute.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_RegistrationAttribute_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_RegistrationAttribute_BY_UUID;
	}
}
