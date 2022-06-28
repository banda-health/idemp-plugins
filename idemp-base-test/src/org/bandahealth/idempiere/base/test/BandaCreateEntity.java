package org.bandahealth.idempiere.base.test;

import com.chuboe.test.populate.ChuBoeCreateEntity;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MPriceList;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.Query;
import org.compiere.model.X_M_DiscountSchema;

import java.sql.Timestamp;

public class BandaCreateEntity extends ChuBoeCreateEntity {

	/**
	 * An override of Chuck's createBP to add some additional steps we need, such as making the price list default
	 *
	 * @param valueObject The value object used to store all information
	 */
	public static void createBusinessPartner(BandaValueObjectWrapper valueObject) {
		BandaCreateEntity.createDefaultPriceLists(valueObject);

		ChuBoeCreateEntity.createBP(valueObject);
		valueObject.getBusinessPartnerBH().setIsCustomer(true);
		valueObject.getBusinessPartnerBH().setBH_IsPatient(true); // the BP model event currently uses this
		valueObject.getBusinessPartnerBH().saveEx();
	}

	/**
	 * This creates and/or sets the default purchase and sales price lists on the value object
	 *
	 * @param valueObject The value object used to store all information
	 */
	public static void createDefaultPriceLists(BandaValueObjectWrapper valueObject) {
		MPriceList defaultSalesPriceList = new Query(valueObject.getCtx(), MPriceList.Table_Name,
				MPriceList.COLUMNNAME_IsDefault + "=? AND " + MPriceList.COLUMNNAME_IsSOPriceList + "=?",
				valueObject.get_trxName()).setParameters("Y", "Y").setOnlyActiveRecords(true).setClient_ID()
				.setOrderBy("ORDER BY " + MPriceList.COLUMNNAME_Created).first();

		MPriceList defaultPurchasePriceList = new Query(valueObject.getCtx(), MPriceList.Table_Name,
				MPriceList.COLUMNNAME_IsDefault + "=? AND " + MPriceList.COLUMNNAME_IsSOPriceList + "=?",
				valueObject.get_trxName()).setParameters("Y", "N").setOnlyActiveRecords(true).setClient_ID()
				.setOrderBy("ORDER BY " + MPriceList.COLUMNNAME_Created).first();

		// We'll temporarily override the step name
		String originalStepName = valueObject.getStepName();
		valueObject.setStepName("Create Default Price Lists");

		if (defaultSalesPriceList == null) {
			defaultSalesPriceList = new MPriceList(valueObject.getCtx(), 0, valueObject.get_trxName());
			defaultSalesPriceList.setName("SO_During: " + valueObject.getStepName() + valueObject.getRandom());
			defaultSalesPriceList.setDescription(valueObject.getStepMsgLong());
			defaultSalesPriceList.setAD_Org_ID(0);
			defaultSalesPriceList.setIsSOPriceList(true);
			defaultSalesPriceList.setC_Currency_ID(valueObject.getCurrency().get_ID());
			defaultSalesPriceList.setIsDefault(true);
			defaultSalesPriceList.saveEx();
		}
		valueObject.setPriceListSO(defaultSalesPriceList);

		if (defaultPurchasePriceList == null) {
			defaultPurchasePriceList = new MPriceList(valueObject.getCtx(), 0, valueObject.get_trxName());
			defaultPurchasePriceList.setName("PO_During: " + valueObject.getStepName() + valueObject.getRandom());
			defaultPurchasePriceList.setDescription(valueObject.getStepMsgLong());
			defaultPurchasePriceList.setAD_Org_ID(0);
			defaultPurchasePriceList.setIsSOPriceList(false);
			defaultPurchasePriceList.setC_Currency_ID(valueObject.getCurrency().get_ID());
			defaultPurchasePriceList.setIsDefault(true);
			defaultPurchasePriceList.saveEx();
			defaultSalesPriceList.saveEx();
		}
		valueObject.setPriceListPO(defaultPurchasePriceList);

		// Now handle the price list versions, if need be
		Timestamp datePL = valueObject.getDatePriceList();
		if (datePL == null)
			datePL = ChuBoeCreateEntity.getDateOffset(valueObject.getDate(), -365);

		//see if price list version already exists
		String sqlWhere = "M_PriceList_ID = ? and ValidFrom = ?";

		MPriceListVersion salesPriceListVersion =
				new Query(valueObject.getCtx(), MPriceListVersion.Table_Name, sqlWhere, valueObject.get_trxName())
						.setClient_ID()
						.setParameters(defaultSalesPriceList.get_ID(), datePL)
						.first();

		MPriceListVersion purchasePriceListVersion =
				new Query(valueObject.getCtx(), MPriceListVersion.Table_Name, sqlWhere, valueObject.get_trxName())
						.setClient_ID()
						.setParameters(defaultPurchasePriceList.get_ID(), datePL)
						.first();

		if (purchasePriceListVersion == null) {
			//get bogus price list schema - required field
			MDiscountSchema schema = new Query(valueObject.getCtx(),
					X_M_DiscountSchema.Table_Name,
					"discounttype = '" + X_M_DiscountSchema.DISCOUNTTYPE_Pricelist + "'",
					valueObject.get_trxName())
					.setClient_ID()
					.first();

			purchasePriceListVersion = new MPriceListVersion(valueObject.getCtx(), 0, valueObject.get_trxName());
			purchasePriceListVersion.setAD_Org_ID(0);
			purchasePriceListVersion.setName(datePL + "; IsSOTrx=N; " + valueObject.getRandom());
			purchasePriceListVersion.setDescription(valueObject.getStepMsgLong());
			purchasePriceListVersion.setM_PriceList_ID(defaultPurchasePriceList.get_ID());
			purchasePriceListVersion.setValidFrom(datePL);
			purchasePriceListVersion.setM_DiscountSchema_ID(schema.get_ID());
			purchasePriceListVersion.saveEx();
		}

		if (salesPriceListVersion == null) {
			//get bogus price list schema - required field
			MDiscountSchema schema = new Query(valueObject.getCtx(),
					X_M_DiscountSchema.Table_Name,
					"discounttype = '" + X_M_DiscountSchema.DISCOUNTTYPE_Pricelist + "'",
					valueObject.get_trxName())
					.setClient_ID()
					.first();

			salesPriceListVersion = new MPriceListVersion(valueObject.getCtx(), 0, valueObject.get_trxName());
			salesPriceListVersion.setAD_Org_ID(0);
			salesPriceListVersion.setName(datePL + "; IsSOTrx=Y; " + valueObject.getRandom());
			salesPriceListVersion.setDescription(valueObject.getStepMsgLong());
			salesPriceListVersion.setM_PriceList_ID(defaultSalesPriceList.get_ID());
			salesPriceListVersion.setValidFrom(datePL);
			salesPriceListVersion.setM_DiscountSchema_ID(schema.get_ID());
			salesPriceListVersion.saveEx();
		}

		valueObject.setStepName(originalStepName);
	}
}
