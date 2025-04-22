package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MSerNoCtlExclude;

/**
 * Data Loader for M_SerNoCtlExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_SerNoCtlExcludeDataLoader extends PODataLoader<MSerNoCtlExclude> {
	public static String DATALOADER_M_SerNoCtlExclude_BY_ID = "M_SerNoCtlExcludeByIdDataLoader";
	public static String DATALOADER_M_SerNoCtlExclude_BY_UUID = "M_SerNoCtlExcludeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSerNoCtlExclude.Table_Name;
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
