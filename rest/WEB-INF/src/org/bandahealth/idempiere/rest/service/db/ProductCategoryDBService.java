package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.rest.model.ProductCategory;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Expense Category (charge) related db operations
 *
 * @author andrew
 */
@Component
public class ProductCategoryDBService extends BaseDBService<ProductCategory, MProductCategory_BH> {

	public List<ProductCategory> get() {
		List<MProductCategory_BH> productCategories = new Query(
				Env.getCtx(),
				MProductCategory_BH.Table_Name,
				MProductCategory_BH.COLUMNNAME_BH_Product_Category_Type + " IS NOT NULL",
				null
		)
				.setOnlyActiveRecords(true)
				.setClient_ID()
				.list();
		return productCategories.stream().map(ProductCategory::new).collect(Collectors.toList());
	}

	@Override
	public ProductCategory saveEntity(ProductCategory entity) {
		return null;
	}

	@Override
	public Boolean deleteEntity(String entityUuid) {
		return null;
	}

	@Override
	protected ProductCategory createInstanceWithDefaultFields(MProductCategory_BH instance) {
		return new ProductCategory(instance);
	}

	@Override
	protected ProductCategory createInstanceWithAllFields(MProductCategory_BH instance) {
		return createInstanceWithDefaultFields(instance);
	}

	@Override
	protected ProductCategory createInstanceWithSearchFields(MProductCategory_BH instance) {
		return createInstanceWithDefaultFields(instance);
	}

	@Override
	protected MProductCategory_BH getModelInstance() {
		return new MProductCategory_BH(Env.getCtx(), 0, null);
	}
}
