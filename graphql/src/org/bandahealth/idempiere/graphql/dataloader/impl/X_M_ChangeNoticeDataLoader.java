package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MChangeNotice;

/**
 * Data Loader for M_ChangeNotice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ChangeNoticeDataLoader extends PODataLoader<MChangeNotice> {
	public static String DATALOADER_M_ChangeNotice_BY_ID = "M_ChangeNoticeByIdDataLoader";
	public static String DATALOADER_M_ChangeNotice_BY_UUID = "M_ChangeNoticeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MChangeNotice.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_ChangeNotice_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_ChangeNotice_BY_UUID;
	}
}
