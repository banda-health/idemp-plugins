package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_LotCtlExclude;

/**
 * Data Loader for M_LotCtlExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_LotCtlExcludeDataLoader extends PODataLoader<X_M_LotCtlExclude> {
	public static String DATALOADER_M_LotCtlExclude_BY_ID = "M_LotCtlExcludeByIdDataLoader";
	public static String DATALOADER_M_LotCtlExclude_BY_UUID = "M_LotCtlExcludeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_LotCtlExclude.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_LotCtlExclude_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_LotCtlExclude_BY_UUID;
	}
}
