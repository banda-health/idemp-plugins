package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_CategoryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_JournalGeneratorLineDataLoader;
import org.compiere.model.MElementValue;
import org.compiere.model.MGLCategory;
import org.compiere.model.MJournalGeneratorLine;
import org.compiere.model.MJournalGeneratorSource;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for GL_JournalGeneratorSource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_JournalGeneratorSourceResolver extends POResolver<MJournalGeneratorSource> implements GraphQLResolver<MJournalGeneratorSource> {



	/**
	 * Get Account Element.
	 *
	 * @return Account Element
	 */
	public CompletableFuture<MElementValue> C_ElementValue(MJournalGeneratorSource entity, DataFetchingEnvironment environment) {
		if (entity.getC_ElementValue_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getC_ElementValue_ID());
	}


	/**
	 * Get GL Category.
	 *
	 * @return General Ledger Category
	 */
	public CompletableFuture<MGLCategory> GL_Category(MJournalGeneratorSource entity, DataFetchingEnvironment environment) {
		if (entity.getGL_Category_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MGLCategory> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_GL_CategoryDataLoader.DATALOADER_GL_Category_BY_ID);
		return dataLoader.load(entity.getGL_Category_ID());
	}


	/**
	 * Get Generator Line.
	 *
	 * @return Generator Line
	 */
	public CompletableFuture<MJournalGeneratorLine> GL_JournalGeneratorLine(MJournalGeneratorSource entity, DataFetchingEnvironment environment) {
		if (entity.getGL_JournalGeneratorLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MJournalGeneratorLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_GL_JournalGeneratorLineDataLoader.DATALOADER_GL_JournalGeneratorLine_BY_ID);
		return dataLoader.load(entity.getGL_JournalGeneratorLine_ID());
	}

}
