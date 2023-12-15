package org.bandahealth.idempiere.graphql.dataloader;

import org.bandahealth.idempiere.graphql.dataloader.impl.AccountDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.AttributeSetDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.AttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.BusinessPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.ChargeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.ChargeTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.ClientDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.FormDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.InvoiceLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.LocationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.LocatorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.M_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.M_BH_VisitDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.M_C_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.OrderLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.OrganizationDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.PaymentDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.ProcessDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.ProcessParameterDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.ProductCategoryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.ReferenceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.ReferenceListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.ReportViewDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.RoleDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.RoleIncludedDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.StorageOnHandDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.WarehouseDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.WorkflowDataLoader;
import org.dataloader.DataLoaderRegistry;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * This class is responsible for containing all data loaders that need to be registered for each query. It holds a list
 * of available data loaders and, when a new query comes in, it registers them for that query.
 */
public class BandaDataLoaderComposer {
	/**
	 * This list of data loaders available for each query.
	 */
	private final List<DataLoaderRegisterer> dataLoaders;

	/**
	 * The dataloaders are initialized in the constructor so that they are injected anew each request, which helps
	 * in hot-swapping in development without having to restart iDempiere
	 */
	public BandaDataLoaderComposer() {
		dataLoaders = Arrays.asList(
				new AccountDataLoader(),
				new AttributeSetDataLoader(),
				new AttributeSetInstanceDataLoader(),
				new BusinessPartnerDataLoader(),
				new ChargeDataLoader(),
				new ChargeTypeDataLoader(),
				new ClientDataLoader(),
				new FormDataLoader(),
				new InvoiceDataLoader(),
				new InvoiceLineDataLoader(),
				new LocationDataLoader(),
				new LocatorDataLoader(),
				new M_AD_Ref_ListDataLoader(),
				new M_BH_VisitDataLoader(),
				new M_C_OrderDataLoader(),
				new OrderDataLoader(),
				new OrderLineDataLoader(),
				new OrganizationDataLoader(),
				new PaymentDataLoader(),
				new ProcessDataLoader(),
				new ProcessParameterDataLoader(),
				new ProductCategoryDataLoader(),
				new ProductDataLoader(),
				new ReferenceDataLoader(),
				new ReferenceListDataLoader(),
				new ReportViewDataLoader(),
				new RoleDataLoader(),
				new RoleIncludedDataLoader(),
				new StorageOnHandDataLoader(),
				new UserDataLoader(),
				new WarehouseDataLoader(),
				new WorkflowDataLoader()
		);
	}

	/**
	 * This method adds the data loaders when a new request comes in. Note, this is not a static method so hot-swaps
	 * will work if code changes are made to the data loaders.
	 *
	 * @param registry         The registry object that can register each data loader
	 * @param idempiereContext The context since Env.getCtx() isn't thread-safe
	 */
	public void addDataLoaders(DataLoaderRegistry registry, Properties idempiereContext) {
		dataLoaders.forEach(dataLoader -> dataLoader.register(registry, idempiereContext));
	}
}
