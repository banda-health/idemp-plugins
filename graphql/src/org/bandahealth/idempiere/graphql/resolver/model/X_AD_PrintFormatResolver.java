package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintColorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFontDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintPaperDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintTableFormatDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ReportViewDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WindowDataLoader;
import org.compiere.model.MReportView;
import org.compiere.model.MTable;
import org.compiere.model.MWindow;
import org.compiere.model.X_AD_PrintColor;
import org.compiere.model.X_AD_PrintFont;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_AD_PrintPaper;
import org.compiere.model.X_AD_PrintTableFormat;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_PrintFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PrintFormatResolver extends POResolver<X_AD_PrintFormat> implements GraphQLResolver<X_AD_PrintFormat> {



	/**
	 * Get Print Color.
	 *
	 * @return Color used for printing and display
	 */
	public CompletableFuture<X_AD_PrintColor> AD_PrintColor(X_AD_PrintFormat entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintColor_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintColor> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintColorDataLoader.AD_PrintColor_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_PrintColor_ID());
	}


	/**
	 * Get Print Font.
	 *
	 * @return Maintain Print Font
	 */
	public CompletableFuture<X_AD_PrintFont> AD_PrintFont(X_AD_PrintFormat entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintFont_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintFont> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintFontDataLoader.AD_PrintFont_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_PrintFont_ID());
	}


	/**
	 * Get Print Paper.
	 *
	 * @return Printer paper definition
	 */
	public CompletableFuture<X_AD_PrintPaper> AD_PrintPaper(X_AD_PrintFormat entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintPaper_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintPaper> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintPaperDataLoader.AD_PrintPaper_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_PrintPaper_ID());
	}


	/**
	 * Get Print Table Format.
	 *
	 * @return Table Format in Reports
	 */
	public CompletableFuture<X_AD_PrintTableFormat> AD_PrintTableFormat(X_AD_PrintFormat entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PrintTableFormat_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_PrintTableFormat> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PrintTableFormatDataLoader.AD_PrintTableFormat_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_PrintTableFormat_ID());
	}


	/**
	 * Get Report View.
	 *
	 * @return View used to generate this report
	 */
	public CompletableFuture<MReportView> AD_ReportView(X_AD_PrintFormat entity, DataFetchingEnvironment environment) {
		if (entity.getAD_ReportView_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MReportView> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ReportViewDataLoader.AD_ReportView_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_ReportView_ID());
	}


	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	public CompletableFuture<MTable> AD_Table(X_AD_PrintFormat entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Table_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MTable> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_TableDataLoader.AD_Table_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Table_ID());
	}


	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	public CompletableFuture<MWindow> AD_Window(X_AD_PrintFormat entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Window_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWindow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WindowDataLoader.AD_Window_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Window_ID());
	}


	/**
	 * Get Jasper Process.
	 *
	 * @return The Jasper Process used by the printengine if any process defined
	 */
	public CompletableFuture<MProcess_BH> JasperProcess(X_AD_PrintFormat entity, DataFetchingEnvironment environment) {
		if (entity.getJasperProcess_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProcess_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_ProcessDataLoader.AD_Process_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getJasperProcess_ID());
	}

}
