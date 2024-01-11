package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_ClassDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_Group_TrlDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_TypeDataLoader;
import org.compiere.model.MAssetClass;
import org.compiere.model.MAssetGroup;
import org.compiere.model.MAssetType;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for A_Asset_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_GroupResolver extends POResolver<MAssetGroup> implements GraphQLResolver<MAssetGroup> {



	/**
	 * Get Asset class.
	 *
	 * @return Asset class
	 */
	public CompletableFuture<MAssetClass> A_Asset_Class(MAssetGroup entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Class_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAssetClass> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Asset_ClassDataLoader.A_Asset_Class_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Asset_Class_ID());
	}


	/**
	 * Get Asset Type.
	 *
	 * @return Asset Type
	 */
	public CompletableFuture<MAssetType> A_Asset_Type(MAssetGroup entity, DataFetchingEnvironment environment) {
		if (entity.getA_Asset_Type_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAssetType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_A_Asset_TypeDataLoader.A_Asset_Type_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getA_Asset_Type_ID());
	}

	/**
	 * Get Description.
	 *
	 * @return Optional short description of the record
	 */
	public CompletableFuture<String> Description(MAssetGroup entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getDescription);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Asset_Group_TrlDataLoader.A_Asset_Group_Trl_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MAssetGroup.COLUMNNAME_Description));
	}

	/**
	 * Get Comment/Help.
	 *
	 * @return Comment or Hint
	 */
	public CompletableFuture<String> Help(MAssetGroup entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getHelp);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Asset_Group_TrlDataLoader.A_Asset_Group_Trl_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MAssetGroup.COLUMNNAME_Help));
	}

	public Boolean IsCreateAsActive(MAssetGroup entity, DataFetchingEnvironment environment) {
		return entity.isCreateAsActive();
	}

	public Boolean IsDefault(MAssetGroup entity, DataFetchingEnvironment environment) {
		return entity.isDefault();
	}

	public Boolean IsDepreciated(MAssetGroup entity, DataFetchingEnvironment environment) {
		return entity.isDepreciated();
	}

	public Boolean IsFixedAsset(MAssetGroup entity, DataFetchingEnvironment environment) {
		return entity.isFixedAsset();
	}

	public Boolean IsOneAssetPerUOM(MAssetGroup entity, DataFetchingEnvironment environment) {
		return entity.isOneAssetPerUOM();
	}

	public Boolean IsOwned(MAssetGroup entity, DataFetchingEnvironment environment) {
		return entity.isOwned();
	}

	public Boolean IsTrackIssues(MAssetGroup entity, DataFetchingEnvironment environment) {
		return entity.isTrackIssues();
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MAssetGroup entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Asset_Group_TrlDataLoader.A_Asset_Group_Trl_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation.get_ValueAsString(MAssetGroup.COLUMNNAME_Name));
	}

}
