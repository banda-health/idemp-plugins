package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_GLJournal;

/**
 * Data Loader for I_GLJournal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_I_GLJournalDataLoader extends PODataLoader<X_I_GLJournal> {
	public static String DATALOADER_I_GLJournal_BY_ID = "I_GLJournalByIdDataLoader";
	public static String DATALOADER_I_GLJournal_BY_UUID = "I_GLJournalByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_GLJournal.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_I_GLJournal_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_I_GLJournal_BY_UUID;
	}
}
