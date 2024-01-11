package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MSerNoCtlExclude;

/**
 * Data Loader for M_SerNoCtlExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_SerNoCtlExcludeDataLoader extends PODataLoader<MSerNoCtlExclude> {
	public static String M_SerNoCtlExclude_BY_ID_DATA_LOADER = "M_SerNoCtlExcludeByIdDataLoader";
	public static String M_SerNoCtlExclude_BY_UUID_DATA_LOADER = "M_SerNoCtlExcludeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSerNoCtlExclude.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_SerNoCtlExclude_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_SerNoCtlExclude_BY_UUID_DATA_LOADER;
	}
}
