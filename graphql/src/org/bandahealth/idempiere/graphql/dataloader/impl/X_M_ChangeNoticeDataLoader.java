package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MChangeNotice;

/**
 * Data Loader for M_ChangeNotice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ChangeNoticeDataLoader extends PODataLoader<MChangeNotice> {
	public static String M_ChangeNotice_BY_ID_DATA_LOADER = "M_ChangeNoticeByIdDataLoader";
	public static String M_ChangeNotice_BY_UUID_DATA_LOADER = "M_ChangeNoticeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MChangeNotice.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_ChangeNotice_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_ChangeNotice_BY_UUID_DATA_LOADER;
	}
}
