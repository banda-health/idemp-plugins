package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MLotCtlExclude;

/**
 * Data Loader for M_LotCtlExclude - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_LotCtlExcludeDataLoader extends PODataLoader<MLotCtlExclude> {
	public static String DATALOADER_M_LotCtlExclude_BY_ID = "M_LotCtlExcludeByIdDataLoader";
	public static String DATALOADER_M_LotCtlExclude_BY_UUID = "M_LotCtlExcludeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MLotCtlExclude.Table_Name;
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
