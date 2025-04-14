package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ElementValueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxDeclarationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_Fact_AcctDataLoader;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MElementValue;
import org.compiere.model.MFactAcct;
import org.compiere.model.MTax;
import org.compiere.model.MTaxDeclaration;
import org.compiere.model.MTaxDeclarationAcct;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_TaxDeclarationAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_TaxDeclarationAcctResolver extends POResolver<MTaxDeclarationAcct> implements GraphQLResolver<MTaxDeclarationAcct> {



	/**
	 * Get Account.
	 *
	 * @return Account used
	 */
	public CompletableFuture<MElementValue> Account(MTaxDeclarationAcct entity, DataFetchingEnvironment environment) {
		if (entity.getAccount_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MElementValue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ElementValueDataLoader.DATALOADER_C_ElementValue_BY_ID);
		return dataLoader.load(entity.getAccount_ID());
	}


	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(MTaxDeclarationAcct entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MTaxDeclarationAcct entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(MTaxDeclarationAcct entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Tax.
	 *
	 * @return Tax identifier
	 */
	public CompletableFuture<MTax> C_Tax(MTaxDeclarationAcct entity, DataFetchingEnvironment environment) {
		if (entity.getC_Tax_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTax> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxDataLoader.DATALOADER_C_Tax_BY_ID);
		return dataLoader.load(entity.getC_Tax_ID());
	}


	/**
	 * Get Tax Declaration.
	 *
	 * @return Define the declaration to the tax authorities
	 */
	public CompletableFuture<MTaxDeclaration> C_TaxDeclaration(MTaxDeclarationAcct entity, DataFetchingEnvironment environment) {
		if (entity.getC_TaxDeclaration_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTaxDeclaration> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_TaxDeclarationDataLoader.DATALOADER_C_TaxDeclaration_BY_ID);
		return dataLoader.load(entity.getC_TaxDeclaration_ID());
	}


	/**
	 * Get Accounting Fact.
	 *
	 * @return Accounting Fact
	 */
	public CompletableFuture<MFactAcct> Fact_Acct(MTaxDeclarationAcct entity, DataFetchingEnvironment environment) {
		if (entity.getFact_Acct_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MFactAcct> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_Fact_AcctDataLoader.DATALOADER_Fact_Acct_BY_ID);
		return dataLoader.load(entity.getFact_Acct_ID());
	}

}
