package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MJournalBatch;

/**
 * Data Loader for GL_JournalBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_JournalBatchDataLoader extends PODataLoader<MJournalBatch> {
	public static String GL_JournalBatch_BY_ID_DATA_LOADER = "GL_JournalBatchByIdDataLoader";
	public static String GL_JournalBatch_BY_UUID_DATA_LOADER = "GL_JournalBatchByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MJournalBatch.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return GL_JournalBatch_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return GL_JournalBatch_BY_UUID_DATA_LOADER;
	}
}
