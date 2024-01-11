package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFormatDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_MailTextDataLoader;
import org.compiere.model.MMailText;
import org.compiere.model.X_AD_PrintForm;
import org.compiere.model.X_AD_PrintFormat;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_PrintForm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintFormResolver extends POResolver<X_AD_PrintForm> implements GraphQLResolver<X_AD_PrintForm> {



	/**
	 * Get Distribution Order Mail Text.
	 *
	 * @return Email text used for sending Distribution Order
	 */
	public CompletableFuture<MMailText> Distrib_Order_MailText(X_AD_PrintForm entity, DataFetchingEnvironment environment) {
		if (entity.getDistrib_Order_MailText_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMailText> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_MailTextDataLoader.R_MailText_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getDistrib_Order_MailText_ID());
	}


	/**
	 * Get Distribution Order Print Format.
	 *
	 * @return Print Format for printing Distribution Order
	 */
	public CompletableFuture<X_AD_PrintFormat> Distrib_Order_PrintFormat(X_AD_PrintForm entity, DataFetchingEnvironment environment) {
		if (entity.getDistrib_Order_PrintFormat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.AD_PrintFormat_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getDistrib_Order_PrintFormat_ID());
	}


	/**
	 * Get Invoice Mail Text.
	 *
	 * @return Email text used for sending invoices
	 */
	public CompletableFuture<MMailText> Invoice_MailText(X_AD_PrintForm entity, DataFetchingEnvironment environment) {
		if (entity.getInvoice_MailText_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMailText> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_MailTextDataLoader.R_MailText_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getInvoice_MailText_ID());
	}


	/**
	 * Get Invoice Print Format.
	 *
	 * @return Print Format for printing Invoices
	 */
	public CompletableFuture<X_AD_PrintFormat> Invoice_PrintFormat(X_AD_PrintForm entity, DataFetchingEnvironment environment) {
		if (entity.getInvoice_PrintFormat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.AD_PrintFormat_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getInvoice_PrintFormat_ID());
	}


	/**
	 * Get Manufacturing Order Mail Text.
	 *
	 * @return Email text used for sending Manufacturing Order
	 */
	public CompletableFuture<MMailText> Manuf_Order_MailText(X_AD_PrintForm entity, DataFetchingEnvironment environment) {
		if (entity.getManuf_Order_MailText_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMailText> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_MailTextDataLoader.R_MailText_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getManuf_Order_MailText_ID());
	}


	/**
	 * Get Manufacturing Order Print Format.
	 *
	 * @return Print Format for printing Manufacturing Order
	 */
	public CompletableFuture<X_AD_PrintFormat> Manuf_Order_PrintFormat(X_AD_PrintForm entity, DataFetchingEnvironment environment) {
		if (entity.getManuf_Order_PrintFormat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.AD_PrintFormat_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getManuf_Order_PrintFormat_ID());
	}


	/**
	 * Get Order Mail Text.
	 *
	 * @return Email text used for sending order acknowledgements or quotations
	 */
	public CompletableFuture<MMailText> Order_MailText(X_AD_PrintForm entity, DataFetchingEnvironment environment) {
		if (entity.getOrder_MailText_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMailText> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_MailTextDataLoader.R_MailText_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getOrder_MailText_ID());
	}


	/**
	 * Get Order Print Format.
	 *
	 * @return Print Format for Orders, Quotes, Offers
	 */
	public CompletableFuture<X_AD_PrintFormat> Order_PrintFormat(X_AD_PrintForm entity, DataFetchingEnvironment environment) {
		if (entity.getOrder_PrintFormat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.AD_PrintFormat_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getOrder_PrintFormat_ID());
	}


	/**
	 * Get Project Mail Text.
	 *
	 * @return Standard text for Project EMails
	 */
	public CompletableFuture<MMailText> Project_MailText(X_AD_PrintForm entity, DataFetchingEnvironment environment) {
		if (entity.getProject_MailText_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMailText> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_MailTextDataLoader.R_MailText_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getProject_MailText_ID());
	}


	/**
	 * Get Project Print Format.
	 *
	 * @return Standard Project Print Format
	 */
	public CompletableFuture<X_AD_PrintFormat> Project_PrintFormat(X_AD_PrintForm entity, DataFetchingEnvironment environment) {
		if (entity.getProject_PrintFormat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.AD_PrintFormat_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getProject_PrintFormat_ID());
	}


	/**
	 * Get Remittance Mail Text.
	 *
	 * @return Email text used for sending payment remittances
	 */
	public CompletableFuture<MMailText> Remittance_MailText(X_AD_PrintForm entity, DataFetchingEnvironment environment) {
		if (entity.getRemittance_MailText_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMailText> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_MailTextDataLoader.R_MailText_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getRemittance_MailText_ID());
	}


	/**
	 * Get Remittance Print Format.
	 *
	 * @return Print Format for separate Remittances
	 */
	public CompletableFuture<X_AD_PrintFormat> Remittance_PrintFormat(X_AD_PrintForm entity, DataFetchingEnvironment environment) {
		if (entity.getRemittance_PrintFormat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.AD_PrintFormat_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getRemittance_PrintFormat_ID());
	}


	/**
	 * Get Shipment Mail Text.
	 *
	 * @return Email text used for sending delivery notes
	 */
	public CompletableFuture<MMailText> Shipment_MailText(X_AD_PrintForm entity, DataFetchingEnvironment environment) {
		if (entity.getShipment_MailText_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MMailText> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_R_MailTextDataLoader.R_MailText_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getShipment_MailText_ID());
	}


	/**
	 * Get Shipment Print Format.
	 *
	 * @return Print Format for Shipments, Receipts, Pick Lists
	 */
	public CompletableFuture<X_AD_PrintFormat> Shipment_PrintFormat(X_AD_PrintForm entity, DataFetchingEnvironment environment) {
		if (entity.getShipment_PrintFormat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFormatDataLoader.AD_PrintFormat_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getShipment_PrintFormat_ID());
	}

}
