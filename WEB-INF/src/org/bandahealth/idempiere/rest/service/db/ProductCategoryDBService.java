package org.bandahealth.idempiere.rest.service.db;

import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MChargeType_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.rest.model.BaseListResponse;
import org.bandahealth.idempiere.rest.model.ExpenseCategory;
import org.bandahealth.idempiere.rest.model.Paging;
import org.bandahealth.idempiere.rest.model.ProductCategory;
import org.bandahealth.idempiere.rest.utils.DateUtil;
import org.bandahealth.idempiere.rest.utils.StringUtil;
import org.compiere.model.MProduct;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Expense Category (charge) related db operations
 *
 * @author andrew
 */
public class ProductCategoryDBService {

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
}
