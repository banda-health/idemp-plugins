package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHTags;

/**
 * Data Loader for BH_Tags - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_TagsDataLoader extends PODataLoader<MBHTags> {
	public static String DATALOADER_BH_Tags_BY_ID = "BH_TagsByIdDataLoader";
	public static String DATALOADER_BH_Tags_BY_UUID = "BH_TagsByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHTags.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Tags_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Tags_BY_UUID;
	}
}
