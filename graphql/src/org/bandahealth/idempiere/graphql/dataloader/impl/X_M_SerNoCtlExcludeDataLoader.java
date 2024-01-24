package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_SerNoCtlExclude;

/**
 * Data Loader for M_SerNoCtlExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_SerNoCtlExcludeDataLoader extends PODataLoader<X_M_SerNoCtlExclude> {
	public static String DATALOADER_M_SerNoCtlExclude_BY_ID = "M_SerNoCtlExcludeByIdDataLoader";
	public static String DATALOADER_M_SerNoCtlExclude_BY_UUID = "M_SerNoCtlExcludeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_SerNoCtlExclude.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_SerNoCtlExclude_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_SerNoCtlExclude_BY_UUID;
	}
}
