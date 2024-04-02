package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.rest.model.ProductCategory;
import org.compiere.util.Env;

/**
 * Expense Category (charge) related db operations
 *
 * @author andrew
 */
public class ProductCategoryDBService extends BaseDBService<ProductCategory, MProductCategory_BH> {

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
	protected MProductCategory_BH getModelInstance() {
		return new MProductCategory_BH(Env.getCtx(), 0, null);
	}
}
