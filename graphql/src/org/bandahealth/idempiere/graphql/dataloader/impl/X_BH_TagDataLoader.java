package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHTag;

/**
 * Data Loader for BH_Tag - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_TagDataLoader extends PODataLoader<MBHTag> {
	public static String DATALOADER_BH_Tag_BY_ID = "BH_TagByIdDataLoader";
	public static String DATALOADER_BH_Tag_BY_UUID = "BH_TagByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHTag.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Tag_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Tag_BY_UUID;
	}
}
