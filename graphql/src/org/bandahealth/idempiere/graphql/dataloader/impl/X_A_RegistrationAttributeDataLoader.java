package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRegistrationAttribute;

/**
 * Data Loader for A_RegistrationAttribute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_RegistrationAttributeDataLoader extends PODataLoader<MRegistrationAttribute> {
	public static String A_RegistrationAttribute_BY_ID_DATA_LOADER = "A_RegistrationAttributeByIdDataLoader";
	public static String A_RegistrationAttribute_BY_UUID_DATA_LOADER = "A_RegistrationAttributeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRegistrationAttribute.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_RegistrationAttribute_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_RegistrationAttribute_BY_UUID_DATA_LOADER;
	}
}
