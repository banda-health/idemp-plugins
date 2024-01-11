package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MXIFAJournal;

/**
 * Data Loader for I_FAJournal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_FAJournalDataLoader extends PODataLoader<MXIFAJournal> {
	public static String I_FAJournal_BY_ID_DATA_LOADER = "I_FAJournalByIdDataLoader";
	public static String I_FAJournal_BY_UUID_DATA_LOADER = "I_FAJournalByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MXIFAJournal.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return I_FAJournal_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return I_FAJournal_BY_UUID_DATA_LOADER;
	}
}
