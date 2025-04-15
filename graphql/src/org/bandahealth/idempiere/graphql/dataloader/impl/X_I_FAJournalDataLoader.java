package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MXIFAJournal;

/**
 * Data Loader for I_FAJournal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_I_FAJournalDataLoader extends PODataLoader<MXIFAJournal> {
	public static String DATALOADER_I_FAJournal_BY_ID = "I_FAJournalByIdDataLoader";
	public static String DATALOADER_I_FAJournal_BY_UUID = "I_FAJournalByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MXIFAJournal.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_I_FAJournal_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_I_FAJournal_BY_UUID;
	}
}
