package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MLotCtlExclude;

/**
 * Data Loader for M_LotCtlExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_LotCtlExcludeDataLoader extends PODataLoader<MLotCtlExclude> {
	public static String M_LotCtlExclude_BY_ID_DATA_LOADER = "M_LotCtlExcludeByIdDataLoader";
	public static String M_LotCtlExclude_BY_UUID_DATA_LOADER = "M_LotCtlExcludeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MLotCtlExclude.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_LotCtlExclude_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_LotCtlExclude_BY_UUID_DATA_LOADER;
	}
}
