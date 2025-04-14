package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_MailText_TrlDataLoader;
import org.compiere.model.MMailText;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for R_MailText - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_R_MailTextResolver extends POResolver<MMailText> implements GraphQLResolver<MMailText> {


	public Boolean IsHtml(MMailText entity, DataFetchingEnvironment environment) {
		return entity.isHtml();
	}

	/**
	 * Get Subject.
	 *
	 * @return Mail Header (Subject)
	 */
	public CompletableFuture<String> MailHeader(MMailText entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getMailHeader);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_MailText_TrlDataLoader.DATALOADER_R_MailText_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MMailText.COLUMNNAME_MailHeader) :
						entity.getMailHeader());
	}

	/**
	 * Get Mail Text.
	 *
	 * @return Text used for Mail message
	 */
	public CompletableFuture<String> MailText(MMailText entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getMailText);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_MailText_TrlDataLoader.DATALOADER_R_MailText_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MMailText.COLUMNNAME_MailText) :
						entity.getMailText());
	}

	/**
	 * Get Mail Text 2.
	 *
	 * @return Optional second text part used for Mail message
	 */
	public CompletableFuture<String> MailText2(MMailText entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getMailText2);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_MailText_TrlDataLoader.DATALOADER_R_MailText_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MMailText.COLUMNNAME_MailText2) :
						entity.getMailText2());
	}

	/**
	 * Get Mail Text 3.
	 *
	 * @return Optional third text part used for Mail message
	 */
	public CompletableFuture<String> MailText3(MMailText entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getMailText3);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_MailText_TrlDataLoader.DATALOADER_R_MailText_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MMailText.COLUMNNAME_MailText3) :
						entity.getMailText3());
	}

	/**
	 * Get Name.
	 *
	 * @return Alphanumeric identifier of the entity
	 */
	public CompletableFuture<String> Name(MMailText entity, DataFetchingEnvironment environment) {
		if (Language.isBaseLanguage(Env.getAD_Language(BandaGraphQLContext.getCtx(environment)))) {
			return CompletableFuture.supplyAsync(entity::getName);
		}
		DataLoader<Integer, PO> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_MailText_TrlDataLoader.DATALOADER_R_MailText_Trl_BY_ID);
		return dataLoader.load(entity.get_ID())
				.thenApply(translation -> translation != null ? translation.get_ValueAsString(MMailText.COLUMNNAME_Name) :
						entity.getName());
	}

}
