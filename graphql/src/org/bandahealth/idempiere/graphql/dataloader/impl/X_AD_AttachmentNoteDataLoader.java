package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAttachmentNote;

/**
 * Data Loader for AD_AttachmentNote - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_AttachmentNoteDataLoader extends PODataLoader<MAttachmentNote> {
	public static String AD_AttachmentNote_BY_ID_DATA_LOADER = "AD_AttachmentNoteByIdDataLoader";
	public static String AD_AttachmentNote_BY_UUID_DATA_LOADER = "AD_AttachmentNoteByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAttachmentNote.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_AttachmentNote_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_AttachmentNote_BY_UUID_DATA_LOADER;
	}
}
