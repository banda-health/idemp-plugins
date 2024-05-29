package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BP_GroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CampaignDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CurrencyDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoicePayScheduleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.compiere.model.MActivity;
import org.compiere.model.MAging;
import org.compiere.model.MCampaign;
import org.compiere.model.MInvoicePaySchedule;
import org.compiere.model.MPInstance;
import org.compiere.model.MProject;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for T_Aging - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_T_AgingResolver extends POResolver<MAging> implements GraphQLResolver<MAging> {



	/**
	 * Get Process Instance.
	 *
	 * @return Instance of the process
	 */
	public CompletableFuture<MPInstance> AD_PInstance(MAging entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PInstance_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MPInstance> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PInstanceDataLoader.DATALOADER_AD_PInstance_BY_ID);
		return dataLoader.load(entity.getAD_PInstance_ID());
	}


	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public CompletableFuture<MActivity> C_Activity(MAging entity, DataFetchingEnvironment environment) {
		if (entity.getC_Activity_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MActivity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ActivityDataLoader.DATALOADER_C_Activity_BY_ID);
		return dataLoader.load(entity.getC_Activity_ID());
	}


	/**
	 * Get Business Partner Group.
	 *
	 * @return Business Partner Group
	 */
	public CompletableFuture<MBPGroup_BH> C_BP_Group(MAging entity, DataFetchingEnvironment environment) {
		if (entity.getC_BP_Group_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBPGroup_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BP_GroupDataLoader.DATALOADER_C_BP_Group_BY_ID);
		return dataLoader.load(entity.getC_BP_Group_ID());
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MAging entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public CompletableFuture<MCampaign> C_Campaign(MAging entity, DataFetchingEnvironment environment) {
		if (entity.getC_Campaign_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MCampaign> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CampaignDataLoader.DATALOADER_C_Campaign_BY_ID);
		return dataLoader.load(entity.getC_Campaign_ID());
	}


	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public CompletableFuture<MCurrency_BH> C_Currency(MAging entity, DataFetchingEnvironment environment) {
		if (entity.getC_Currency_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getC_Currency_ID());
	}


	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> C_Invoice(MAging entity, DataFetchingEnvironment environment) {
		if (entity.getC_Invoice_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.DATALOADER_C_Invoice_BY_ID);
		return dataLoader.load(entity.getC_Invoice_ID());
	}


	/**
	 * Get Invoice Payment Schedule.
	 *
	 * @return Invoice Payment Schedule
	 */
	public CompletableFuture<MInvoicePaySchedule> C_InvoicePaySchedule(MAging entity, DataFetchingEnvironment environment) {
		if (entity.getC_InvoicePaySchedule_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MInvoicePaySchedule> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoicePayScheduleDataLoader.DATALOADER_C_InvoicePaySchedule_BY_ID);
		return dataLoader.load(entity.getC_InvoicePaySchedule_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(MAging entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.DATALOADER_C_Project_BY_ID);
		return dataLoader.load(entity.getC_Project_ID());
	}


	/**
	 * Get Convert Amounts in Currency.
	 *
	 * @return Convert Amounts in Currency
	 */
	public CompletableFuture<MCurrency_BH> ConvertAmountsInCurrency(MAging entity, DataFetchingEnvironment environment) {
		if (entity.getConvertAmountsInCurrency_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MCurrency_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_CurrencyDataLoader.DATALOADER_C_Currency_BY_ID);
		return dataLoader.load(entity.getConvertAmountsInCurrency_ID());
	}

	public Boolean DateAcct(MAging entity, DataFetchingEnvironment environment) {
		return entity.isDateAcct();
	}

	public Boolean IsListInvoices(MAging entity, DataFetchingEnvironment environment) {
		return entity.isListInvoices();
	}

	public Boolean IsSOTrx(MAging entity, DataFetchingEnvironment environment) {
		return entity.isSOTrx();
	}

}
