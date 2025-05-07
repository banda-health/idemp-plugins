package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHBPartnerTags;

/**
 * Data Loader for BH_BPartner_Tags - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_BPartner_TagsDataLoader extends PODataLoader<MBHBPartnerTags> {
	public static String DATALOADER_BH_BPartner_Tags_BY_ID = "BH_BPartner_TagsByIdDataLoader";
	public static String DATALOADER_BH_BPartner_Tags_BY_UUID = "BH_BPartner_TagsByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHBPartnerTags.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_BPartner_Tags_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_BPartner_Tags_BY_UUID;
	}
}
