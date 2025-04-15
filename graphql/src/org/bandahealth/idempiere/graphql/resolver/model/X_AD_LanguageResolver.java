package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintPaperDataLoader;
import org.compiere.model.MLanguage;
import org.compiere.model.X_AD_PrintPaper;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_Language - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_LanguageResolver extends POResolver<MLanguage> implements GraphQLResolver<MLanguage> {



	/**
	 * Get Print Paper.
	 *
	 * @return Printer paper definition
	 */
	public CompletableFuture<X_AD_PrintPaper> AD_PrintPaper(MLanguage entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintPaper_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintPaper> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintPaperDataLoader.DATALOADER_AD_PrintPaper_BY_ID);
		return dataLoader.load(entity.getAD_PrintPaper_ID());
	}

	public Boolean IsBaseLanguage(MLanguage entity, DataFetchingEnvironment environment) {
		return entity.isBaseLanguage();
	}

	public Boolean IsDecimalPoint(MLanguage entity, DataFetchingEnvironment environment) {
		return entity.isDecimalPoint();
	}

	public Boolean IsLoginLocale(MLanguage entity, DataFetchingEnvironment environment) {
		return entity.isLoginLocale();
	}

	public Boolean IsSystemLanguage(MLanguage entity, DataFetchingEnvironment environment) {
		return entity.isSystemLanguage();
	}

	public Boolean Processing(MLanguage entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
