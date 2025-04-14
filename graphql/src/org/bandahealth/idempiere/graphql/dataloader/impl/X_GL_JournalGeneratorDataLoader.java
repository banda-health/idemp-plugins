package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MJournalGenerator;

/**
 * Data Loader for GL_JournalGenerator - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_GL_JournalGeneratorDataLoader extends PODataLoader<MJournalGenerator> {
	public static String DATALOADER_GL_JournalGenerator_BY_ID = "GL_JournalGeneratorByIdDataLoader";
	public static String DATALOADER_GL_JournalGenerator_BY_UUID = "GL_JournalGeneratorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MJournalGenerator.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_GL_JournalGenerator_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_GL_JournalGenerator_BY_UUID;
	}
}
