package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MJournalBatch;

/**
 * Data Loader for GL_JournalBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_GL_JournalBatchDataLoader extends PODataLoader<MJournalBatch> {
	public static String DATALOADER_GL_JournalBatch_BY_ID = "GL_JournalBatchByIdDataLoader";
	public static String DATALOADER_GL_JournalBatch_BY_UUID = "GL_JournalBatchByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MJournalBatch.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_GL_JournalBatch_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_GL_JournalBatch_BY_UUID;
	}
}
