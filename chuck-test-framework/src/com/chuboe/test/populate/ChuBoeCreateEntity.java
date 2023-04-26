/**********************************************************************
 * This file is part of iDempiere ERP Open Source and ERP Academy      *
 * http://www.idempiere.org                                            *
 * http://www.chuckboecking.com                                        *
 *                                                                     *
 * Copyright (C) Contributors                                          *
 *                                                                     *
 * This program is provided to current and former participants of      *
 * ERP Academy (erp-academy.chuckboecking.com). Once you have joined   *
 * the ERP Academy, you may use and modify it under the terms of       *
 * the GNU General Public License as published by the Free Software    *
 * Foundation; either version 2 of the License, or (at your option)    *
 * any later version.                                                  *
 *                                                                     *
 * This program is distributed in the hope that it will be useful,     *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of      *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the        *
 * GNU General Public License for more details.                        *
 *                                                                     *
 * You should have received a copy of the GNU General Public License   *
 * along with this program; if not, write to the Free Software         *
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,          *
 * MA 02110-1301, USA.                                                 *
 *                                                                     *
 * Contributors:                                                       *
 * - Chuck Boecking                                                    *
 **********************************************************************/

package com.chuboe.test.populate;

import org.adempiere.base.Core;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MBankAccount;
import org.compiere.model.MCalendar;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MDocType;
import org.compiere.model.MInOut;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MLocation;
import org.compiere.model.MLocator;
import org.compiere.model.MOrderLine;
import org.compiere.model.MOrg;
import org.compiere.model.MOrgInfo;
import org.compiere.model.MPInstance;
import org.compiere.model.MPeriodControl;
import org.compiere.model.MPriceList;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MProcess;
import org.compiere.model.MProduct;
import org.compiere.model.MProductBOM;
import org.compiere.model.MProductCategory;
import org.compiere.model.MProductPrice;
import org.compiere.model.MSession;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.MTaxCategory;
import org.compiere.model.MUOM;
import org.compiere.model.MYear;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Org;
import org.compiere.model.X_AD_Process;
import org.compiere.model.X_C_AcctSchema;
import org.compiere.model.X_C_BankAccount;
import org.compiere.model.X_C_Calendar;
import org.compiere.model.X_C_Order;
import org.compiere.model.X_C_PeriodControl;
import org.compiere.model.X_C_Year;
import org.compiere.model.X_M_DiscountSchema;
import org.compiere.model.X_M_InOut;
import org.compiere.model.X_M_Product;
import org.compiere.model.X_M_Warehouse;
import org.compiere.process.ProcessCall;
import org.compiere.process.ProcessInfo;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.ServerProcessCtl;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ChuBoeCreateEntity {

	static final public BigDecimal BD_ZERO = BigDecimal.valueOf(0.0);
	static final public BigDecimal BD_ONE = BigDecimal.valueOf(1.0);
	static final public BigDecimal BD_TWO = BigDecimal.valueOf(2.0);
	static final public BigDecimal BD_TEN = BigDecimal.valueOf(10.0);
	static final public BigDecimal BD_THIRTYTHREE = BigDecimal.valueOf(33.0);
	static final public BigDecimal BD_FIFTY = BigDecimal.valueOf(50.0);
	static final public BigDecimal BD_ONEHUNDRED = BigDecimal.valueOf(100.0);
	static final public BigDecimal BD_TWOHUNDRED = BigDecimal.valueOf(200.0);

	//create your BP first
	public static void createBusinessPartner(ChuBoePopulateVO valueObject) {
		valueObject.validate();
		if (valueObject.isError()) {
			return;
		}

		createDefaultPriceLists(valueObject);

		//perform further validation if needed based on business logic
		//NONE

		//use valueObject.clearBP() to create a new BP or replace a new one
		if (valueObject.getBusinessPartner() == null) {
			//create businessPartner
			MBPartner_BH businessPartner = new MBPartner_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
			businessPartner.setAD_Org_ID(0);
			businessPartner.setName(valueObject.getStepMessage());
			businessPartner.setDescription(valueObject.getStepMessageLong());
			businessPartner.setIsCustomer(true);
			businessPartner.setIsVendor(true);
			businessPartner.saveEx();
			valueObject.setBusinessPartner(businessPartner);

			//create SO pricelist if not already created from previous BP - used later in document creation
			MPriceList salesPriceList;
			if (valueObject.getSalesPriceList() == null) {
				salesPriceList = new MPriceList(valueObject.getContext(), 0, valueObject.getTransactionName());
				salesPriceList.setName("SO_During: " + valueObject.getStepName() + valueObject.getRandomNumber());
				salesPriceList.setDescription(valueObject.getStepMessageLong());
				salesPriceList.setAD_Org_ID(0);
				salesPriceList.setIsSOPriceList(true);
				salesPriceList.setC_Currency_ID(valueObject.getCurrency().get_ID());
				salesPriceList.saveEx();
				valueObject.setSalesPriceList(salesPriceList);
			}
			businessPartner.setM_PriceList_ID(valueObject.getSalesPriceList().get_ID());

			//create PO priceList if not already created from previous BP - used later in document creation
			MPriceList purchasePriceList;
			if (valueObject.getPurchasePriceList() == null) {
				purchasePriceList = new MPriceList(valueObject.getContext(), 0, valueObject.getTransactionName());
				purchasePriceList.setName("PO_During: " + valueObject.getStepName() + valueObject.getRandomNumber());
				purchasePriceList.setDescription(valueObject.getStepMessageLong());
				purchasePriceList.setAD_Org_ID(0);
				purchasePriceList.setIsSOPriceList(false);
				purchasePriceList.setC_Currency_ID(valueObject.getCurrency().get_ID());
				purchasePriceList.saveEx();
				valueObject.setPurchasePriceList(purchasePriceList);
			}
			businessPartner.setPO_PriceList_ID(valueObject.getPurchasePriceList().get_ID());

			businessPartner.saveEx();

			// Currently, the location is created automatically on BP save
//			//create loc
//			MBPartnerLocation businessPartnerLocation =
//					new MBPartnerLocation(valueObject.getContext(), 0, valueObject.getTransactionName());
//			businessPartnerLocation.setAD_Org_ID(0);
//			businessPartnerLocation.setC_BPartner_ID(businessPartner.get_ID());
//			MLocation loc =
//					new MLocation(valueObject.getContext(), valueObject.getCountry().get_ID(), valueObject.getRegion()
//					.get_ID(),
//							valueObject.getCity(), valueObject.getTransactionName());
//			loc.saveEx();
//			businessPartnerLocation.setC_Location_ID(loc.get_ID());
//			businessPartnerLocation.setName(valueObject.getCity() + " " + valueObject.getRegion().getName());
//			businessPartnerLocation.saveEx();
			valueObject.setBusinessPartnerLocation(businessPartner.getLocations(false)[0]);

			//create contact
			List<MUser_BH> users =
					new Query(valueObject.getContext(), MUser_BH.Table_Name, MUser_BH.COLUMNNAME_C_BPartner_ID + "=?",
							valueObject.getTransactionName()).setParameters(valueObject.getBusinessPartner().get_ID())
							.setOnlyActiveRecords(true).list();
//			MUser_BH user;
//			if (users != null && users.size() == 1) {
//				user = users.get(0);
//			} else {
//				user = new MUser_BH(valueObject.getBusinessPartner());
//			}
//			user.setNotificationType(X_AD_User.NOTIFICATIONTYPE_None);
//			user.setDescription(valueObject.getStepMessageLong());
//			user.saveEx();
//			valueObject.setUser(user);
			valueObject.setUser(users.get(0));

			businessPartner.setIsCustomer(true);
			businessPartner.setBH_IsPatient(true); // the BP model event currently uses this
			businessPartner.saveEx();
		}
	} //create BP

	//create product second
	public static void createProduct(ChuBoePopulateVO valueObject) {
		valueObject.validate();
		if (valueObject.isError()) {
			return;
		}

		//perform further validation if needed based on business logic

		//use valueObject.clearProduct() to create new product
		if (valueObject.getProduct() == null) {
			MProduct_BH product = new MProduct_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
			product.setAD_Org_ID(0);
			product.setDescription(valueObject.getStepMessageLong());
			product.setC_UOM_ID(MUOM.getDefault_UOM_ID(valueObject.getContext()));
			product.setM_Product_Category_ID(getDefaultProductCategoryId(valueObject));
			product.setC_TaxCategory_ID(getDefaultTaxCategoryId(valueObject));
			product.setName(valueObject.getScenarioName());
			product.setProductType(X_M_Product.PRODUCTTYPE_Item);
			product.saveEx();
			valueObject.setProduct(product);

			if (valueObject.getBusinessPartner() != null) {
				//create PO and SO price list entries
				MPriceList salesPriceList =
						new MPriceList(valueObject.getContext(), valueObject.getBusinessPartner().getM_PriceList_ID(),
								valueObject.getTransactionName());
				MPriceList purchasePriceList =
						new MPriceList(valueObject.getContext(), valueObject.getBusinessPartner().getPO_PriceList_ID(),
								valueObject.getTransactionName());

				Timestamp datePriceList = valueObject.getDatePriceList();
				if (datePriceList == null) {
					datePriceList = ChuBoeCreateEntity.getDateOffset(valueObject.getDate(), -365);
				}

				//see if price list version already exists
				String sqlWhere = "M_PriceList_ID = ? and ValidFrom = ?";

				MPriceListVersion salesPriceListVersion =
						new Query(valueObject.getContext(), MPriceListVersion.Table_Name, sqlWhere,
								valueObject.getTransactionName())
								.setClient_ID()
								.setParameters(salesPriceList.get_ID(), datePriceList)
								.first();

				MPriceListVersion purchasePriceListVersion =
						new Query(valueObject.getContext(), MPriceListVersion.Table_Name, sqlWhere,
								valueObject.getTransactionName())
								.setClient_ID()
								.setParameters(purchasePriceList.get_ID(), datePriceList)
								.first();

				if (purchasePriceListVersion == null) {
					//get bogus price list schema - required field
					MDiscountSchema schema = new Query(valueObject.getContext(),
							X_M_DiscountSchema.Table_Name,
							"discounttype = '" + X_M_DiscountSchema.DISCOUNTTYPE_Pricelist + "'",
							valueObject.getTransactionName())
							.setClient_ID()
							.first();

					purchasePriceListVersion =
							new MPriceListVersion(valueObject.getContext(), 0, valueObject.getTransactionName());
					purchasePriceListVersion.setAD_Org_ID(0);
					purchasePriceListVersion.setName(datePriceList + "; IsSOTrx=N; " + valueObject.getRandomNumber());
					purchasePriceListVersion.setDescription(valueObject.getStepMessageLong());
					purchasePriceListVersion.setM_PriceList_ID(purchasePriceList.get_ID());
					purchasePriceListVersion.setValidFrom(datePriceList);
					purchasePriceListVersion.setM_DiscountSchema_ID(schema.get_ID());
					purchasePriceListVersion.saveEx();
				}

				if (salesPriceListVersion == null) {
					//get bogus price list schema - required field
					MDiscountSchema schema = new Query(valueObject.getContext(),
							X_M_DiscountSchema.Table_Name,
							"discounttype = '" + X_M_DiscountSchema.DISCOUNTTYPE_Pricelist + "'",
							valueObject.getTransactionName())
							.setClient_ID()
							.first();

					salesPriceListVersion = new MPriceListVersion(valueObject.getContext(), 0, valueObject.getTransactionName());
					salesPriceListVersion.setAD_Org_ID(0);
					salesPriceListVersion.setName(datePriceList + "; IsSOTrx=Y; " + valueObject.getRandomNumber());
					salesPriceListVersion.setDescription(valueObject.getStepMessageLong());
					salesPriceListVersion.setM_PriceList_ID(salesPriceList.get_ID());
					salesPriceListVersion.setValidFrom(datePriceList);
					salesPriceListVersion.setM_DiscountSchema_ID(schema.get_ID());
					salesPriceListVersion.saveEx();
				}

				MProductPrice productPurchasePrice = new Query(valueObject.getContext(), MProductPrice.Table_Name,
						MProductPrice.COLUMNNAME_M_Product_ID + "=? AND " + MProductPrice.COLUMNNAME_M_PriceList_Version_ID + "=?",
						valueObject.getTransactionName()).setParameters(product.get_ID(), purchasePriceListVersion.get_ID())
						.setOnlyActiveRecords(true).first();
				if (productPurchasePrice == null) {
					productPurchasePrice = new MProductPrice(valueObject.getContext(), purchasePriceListVersion.get_ID(),
							valueObject.getProduct().get_ID(), valueObject.getTransactionName());
				}
				productPurchasePrice.setPriceLimit(valueObject.getPurchaseLimitPrice());
				productPurchasePrice.setPriceStd(valueObject.getPurchaseStandardPrice());
				productPurchasePrice.setPriceList(valueObject.getPurchaseListPrice());
				productPurchasePrice.saveEx();

				MProductPrice productSalesPrice = new Query(valueObject.getContext(), MProductPrice.Table_Name,
						MProductPrice.COLUMNNAME_M_Product_ID + "=? AND " + MProductPrice.COLUMNNAME_M_PriceList_Version_ID + "=?",
						valueObject.getTransactionName()).setParameters(product.get_ID(), salesPriceListVersion.get_ID())
						.setOnlyActiveRecords(true).first();
				if (productSalesPrice == null) {
					productSalesPrice = new MProductPrice(valueObject.getContext(), salesPriceListVersion.get_ID(),
							valueObject.getProduct().get_ID(), valueObject.getTransactionName());
				}
				productSalesPrice.setPriceLimit(valueObject.getSalesLimitPrice());
				productSalesPrice.setPriceStd(valueObject.getSalesStandardPrice());
				productSalesPrice.setPriceList(valueObject.getSalesListPrice());
				productSalesPrice.saveEx();
			}
		}
	} //create product

	//create charge
	public static void createCharge(ChuBoePopulateVO valueObject) {
		valueObject.validate();
		if (valueObject.isError()) {
			return;
		}

		//use valueObject.clearCharge() to create new charge
		if (valueObject.getCharge() == null) {
			MCharge_BH charge = new MCharge_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
			charge.setAD_Org_ID(0);
			charge.setDescription(valueObject.getStepMessageLong());
			charge.setC_TaxCategory_ID(getDefaultTaxCategoryId(valueObject));
			charge.setName(valueObject.getRandomNumber() + "_" + valueObject.getScenarioName());
			charge.saveEx();
			valueObject.setCharge(charge);
		}
	}

	public static void createProductBOM(ChuBoePopulateVO valueObject, BigDecimal quantity, MProduct parentProduct) {
		valueObject.validate();
		if (valueObject.isError()) {
			return;
		}

		//valueObject, Qty, parentProd
		MProductBOM bom = new MProductBOM(valueObject.getContext(), 0, valueObject.getTransactionName());
		bom.setAD_Org_ID(0);
		bom.setDescription(valueObject.getStepMessageLong());
		bom.setBOMQty(quantity);
		bom.setBOMType(MProductBOM.BOMTYPE_StandardPart);
		bom.setIsActive(true);
		bom.setM_ProductBOM_ID(valueObject.getProduct().get_ID());
		bom.setM_Product_ID(parentProduct.get_ID());

		//find next line number
		int newLine = new Query(valueObject.getContext(), MProductBOM.Table_Name, "M_Product_ID = ?",
				valueObject.getTransactionName())
				.setParameters(parentProduct.get_ID())
				.setClient_ID()
				.aggregate("Line", Query.AGGREGATE_MAX).intValue() + 10;
		bom.setLine(newLine);

		bom.saveEx();

		if (!parentProduct.isVerified()) {
			parentProduct.setIsManufactured(true);
			parentProduct.setIsBOM(true);
			parentProduct.setIsVerified(true); //we know it will be ok :)
			parentProduct.saveEx();
		}
	}

	public static void createOrder(ChuBoePopulateVO valueObject) {
		valueObject.validate();
		if (valueObject.isError()) {
			return;
		}

		//perform further validation if needed based on business logic
		if (valueObject.getDocumentType() == null) {
			valueObject.appendErrorMessage("DocType is Null");
			return;
		} else if (valueObject.getBusinessPartner() == null) {
			valueObject.appendErrorMessage("BP is Null");
			return;
		} else if (valueObject.getWarehouse() == null) {
			valueObject.appendErrorMessage("Warehouse is Null");
			return;
		}

		//create order header
		MOrder_BH order = new MOrder_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		order.setAD_Org_ID(valueObject.getOrg().get_ID());
		order.setDescription(valueObject.getStepMessageLong());
		order.setC_DocTypeTarget_ID(valueObject.getDocumentType().get_ID());
		order.setDateOrdered(valueObject.getDate());
		order.setDatePromised(valueObject.getDate());
		order.setIsSOTrx(valueObject.getDocumentType().isSOTrx());
		if (valueObject.getDocumentType().isSOTrx() && valueObject.getVisit() != null) {
			order.setBH_Visit_ID(valueObject.getVisit().get_ID());
		}
		order.setBPartner(valueObject.getBusinessPartner());
		order.setM_PriceList_ID(
				valueObject.getDocumentType().isSOTrx() ? valueObject.getBusinessPartner().getM_PriceList_ID() :
						valueObject.getBusinessPartner().getPO_PriceList_ID());
		order.setM_Warehouse_ID(valueObject.getWarehouse().get_ID());
		order.saveEx();
		valueObject.setOrder(order);

		//create order line
		MOrderLine_BH orderLine = new MOrderLine_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		orderLine.setAD_Org_ID(valueObject.getOrg().get_ID());
		orderLine.setDescription(valueObject.getStepMessageLong());
		orderLine.setC_Order_ID(order.get_ID());
		orderLine.setM_Product_ID(valueObject.getProduct().get_ID());
		orderLine.setC_UOM_ID(valueObject.getProduct().getC_UOM_ID());
		orderLine.setM_AttributeSetInstance_ID(
				valueObject.getAttributeSetInstance() == null ? 0 : valueObject.getAttributeSetInstance().get_ID());
		if (valueObject.getQuantity() == null || valueObject.getQuantity().compareTo(Env.ZERO) == 0) {
			orderLine.setQty(Env.ONE);
		} else {
			orderLine.setQty(valueObject.getQuantity());
		}
		orderLine.setHeaderInfo(order);
		orderLine.setPrice();

		orderLine.saveEx();
		valueObject.setOrderLine(orderLine);

		if (valueObject.getDocumentAction() != null) {
			if (valueObject.getLogger() != null) {
				valueObject.getLogger().fine("Starting DocAction: " + valueObject.getDocumentAction());
			}
			order.setDocAction(valueObject.getDocumentAction());
			order.processIt(valueObject.getDocumentAction());
		}
		if (valueObject.getLogger() != null) {
			valueObject.getLogger().fine("Saving order after completion. Doc Status: " + order.getDocStatus());
		}
		order.saveEx();

	} //create order

	public static void createVisit(ChuBoePopulateVO valueObject) {
		valueObject.validate();
		if (valueObject.isError()) {
			return;
		}

		//perform further validation if needed based on business logic
		if (valueObject.getBusinessPartner() == null) {
			valueObject.appendErrorMessage("BP is Null");
			return;
		}

		MBHVisit visit = new MBHVisit(valueObject.getContext(), 0, valueObject.getTransactionName());
		visit.setPatient_ID(valueObject.getBusinessPartner().get_ID());
		visit.setBH_VisitDate(valueObject.getDate());
		visit.saveEx();
		valueObject.setVisit(visit);
	} //create visit

	public static void createInOut(ChuBoePopulateVO valueObject) {
		valueObject.validate();
		if (valueObject.isError()) {
			return;
		}

		//perform further validation if needed based on business logic
		if (valueObject.getDocumentType() == null) {
			valueObject.appendErrorMessage("DocType is Null");
			return;
		} else if (valueObject.getBusinessPartner() == null) {
			valueObject.appendErrorMessage("BP is Null");
			return;
		} else if (valueObject.getWarehouse() == null) {
			valueObject.appendErrorMessage("Warehouse is Null");
			return;
		} else if (!valueObject.getOrder().getDocStatus().equals(X_C_Order.DOCSTATUS_Completed)) {
			valueObject.appendErrorMessage("Order Not Completed");
			return;
		}

		//create inout header
		MInOut_BH inOut = new MInOut_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		inOut.setAD_Org_ID(valueObject.getOrg().get_ID());
		inOut.setDescription(valueObject.getStepMessageLong());
		inOut.setC_BPartner_ID(valueObject.getBusinessPartner().get_ID());
		inOut.setC_BPartner_Location_ID(valueObject.getBusinessPartnerLocation().get_ID());
		inOut.setAD_User_ID(valueObject.getUser().get_ID());
		inOut.setC_DocType_ID(valueObject.getDocumentType().get_ID());
		inOut.setC_Order_ID(valueObject.getOrder().get_ID());
		inOut.setM_Warehouse_ID(valueObject.getWarehouse().get_ID());
		inOut.setMovementDate(valueObject.getDate());
		inOut.setDateAcct(valueObject.getDate());
		inOut.setIsSOTrx(valueObject.getDocumentType().isSOTrx());
		if (valueObject.getDocumentType().isSOTrx() && valueObject.getVisit() != null) {
			inOut.setBH_Visit_ID(valueObject.getVisit().get_ID());
		}
		inOut.setMovementType(valueObject.getDocumentType().isSOTrx() ? X_M_InOut.MOVEMENTTYPE_CustomerShipment :
				X_M_InOut.MOVEMENTTYPE_VendorReceipts);

		inOut.saveEx();
		valueObject.setInOut(inOut);

		//create inout line
		MInOutLine inOutLine = new MInOutLine(valueObject.getContext(), 0, valueObject.getTransactionName());
		inOutLine.setAD_Org_ID(valueObject.getOrg().get_ID());
		inOutLine.setDescription(valueObject.getStepMessageLong());
		inOutLine.setM_InOut_ID(valueObject.getInOut().get_ID());
		inOutLine.setM_Product_ID(valueObject.getProduct().get_ID());
		inOutLine.setM_AttributeSetInstance_ID(
				valueObject.getAttributeSetInstance() == null ? 0 : valueObject.getAttributeSetInstance().get_ID());
		inOutLine.setM_Warehouse_ID(valueObject.getWarehouse().get_ID());
		inOutLine.setM_Locator_ID(valueObject.getWarehouse().getDefaultLocator().get_ID());
		inOutLine.setC_OrderLine_ID(valueObject.getOrderLine().get_ID());
		inOutLine.setC_UOM_ID(valueObject.getProduct().getC_UOM_ID());
		if (valueObject.getQuantity() == null || valueObject.getQuantity().compareTo(Env.ZERO) == 0) {
			inOutLine.setQty(Env.ONE);
		} else {
			inOutLine.setQty(valueObject.getQuantity());
		}

		inOutLine.saveEx();
		valueObject.setInOutLine(inOutLine);

		if (valueObject.getDocumentAction() != null) {
			inOut.setDocAction(valueObject.getDocumentAction());
			inOut.processIt(valueObject.getDocumentAction());
		}
		inOut.saveEx();
	} //create inout

	public static void createInvoice(ChuBoePopulateVO valueObject) {
		valueObject.validate();
		if (valueObject.isError())
			return;

		//perform further validation if needed based on business logic
		if (valueObject.getDocumentType() == null) {
			valueObject.appendErrorMessage("DocType is Null");
			return;
		} else if (valueObject.getBusinessPartner() == null) {
			valueObject.appendErrorMessage("BP is Null");
			return;
		} else if (valueObject.getOrder() != null &&
				!valueObject.getOrder().getDocStatus().equals(X_C_Order.DOCSTATUS_Completed)) {
			valueObject.appendErrorMessage("Order Not Completed");
			return;
		}

		//create invoice header
		MInvoice_BH invoice = new MInvoice_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		invoice.setAD_Org_ID(valueObject.getOrg().get_ID());
		invoice.setDescription(valueObject.getStepMessageLong());
		invoice.setC_BPartner_ID(valueObject.getBusinessPartner().get_ID());
		invoice.setC_BPartner_Location_ID(valueObject.getBusinessPartnerLocation().get_ID());
		invoice.setAD_User_ID(valueObject.getUser().get_ID());
		invoice.setM_PriceList_ID(
				valueObject.getDocumentType().isSOTrx() ? valueObject.getBusinessPartner().getM_PriceList_ID() :
						valueObject.getBusinessPartner().getPO_PriceList_ID());
		invoice.setC_DocType_ID(valueObject.getDocumentType().get_ID());
		invoice.setDateInvoiced(valueObject.getDate());
		invoice.setIsSOTrx(valueObject.getDocumentType().isSOTrx());
		if (valueObject.getDocumentType().isSOTrx() && valueObject.getVisit() != null) {
			invoice.setBH_Visit_ID(valueObject.getVisit().get_ID());
		}
		if (valueObject.getOrder() != null) {
			invoice.setC_Order_ID(valueObject.getOrder().get_ID());
		}

		invoice.saveEx();
		valueObject.setInvoice(invoice);

		//create invoice line
		MInvoiceLine invoiceLine = new MInvoiceLine(valueObject.getContext(), 0, valueObject.getTransactionName());
		invoiceLine.setC_Invoice_ID(valueObject.getInvoice().get_ID());
		invoiceLine.setDescription(valueObject.getStepMessageLong());
		invoiceLine.setAD_Org_ID(valueObject.getOrg().get_ID());
		if (valueObject.getCharge() != null) {
			invoiceLine.setC_Charge_ID(valueObject.getCharge().get_ID());
		} else if (valueObject.getProduct() != null) {
			invoiceLine.setM_Product_ID(valueObject.getProduct().get_ID());
			invoiceLine.setC_UOM_ID(valueObject.getProduct().getC_UOM_ID());
		}
		invoiceLine.setM_AttributeSetInstance_ID(
				valueObject.getAttributeSetInstance() == null ? 0 : valueObject.getAttributeSetInstance().get_ID());
		if (valueObject.getQuantity() == null || valueObject.getQuantity().compareTo(Env.ZERO) == 0) {
			invoiceLine.setQty(Env.ONE);
		} else {
			invoiceLine.setQty(valueObject.getQuantity());
		}
		if (valueObject.getOrderLine() != null) {
			invoiceLine.setC_OrderLine_ID(valueObject.getOrderLine().get_ID());
		}
		if (valueObject.getCharge() != null && valueObject.getSalesStandardPrice() != null &&
				valueObject.getSalesStandardPrice().compareTo(Env.ZERO) != 0) {
			invoiceLine.setPrice(valueObject.getSalesStandardPrice());
		} else {
			invoiceLine.setPrice();
		}

		invoiceLine.saveEx();
		valueObject.setInvoiceLine(invoiceLine);

		if (valueObject.getDocumentAction() != null) {
			invoice.setDocAction(valueObject.getDocumentAction());
			invoice.processIt(valueObject.getDocumentAction());
		}
		invoice.saveEx();
	} //create invoice

	public static void createPayment(ChuBoePopulateVO valueObject) {
		valueObject.validate();
		if (valueObject.isError()) {
			return;
		}

		//perform further validation if needed based on business logic
		if (valueObject.getDocumentType() == null) {
			valueObject.appendErrorMessage("DocType is Null");
			return;
		} else if (valueObject.getBusinessPartner() == null) {
			valueObject.appendErrorMessage("BP is Null");
			return;
		} else if (valueObject.getPaymentAmount() == null && valueObject.getInvoice() == null &&
				valueObject.getOrder() == null) {
			valueObject.appendErrorMessage("Need Payment Amount is Null");
			return;
		}

		//create payment
		MPayment_BH payment = new MPayment_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		payment.setAD_Org_ID(valueObject.getOrg().get_ID());
		payment.setC_DocType_ID(valueObject.getDocumentType().get_ID());
		payment.setIsReceipt(valueObject.getDocumentType().isSOTrx());
		payment.setDateTrx(valueObject.getDate());
		payment.setDateAcct(valueObject.getDate());
		payment.setC_BPartner_ID(valueObject.getBusinessPartner().get_ID());
		payment.setDescription(valueObject.getStepMessageLong());
		if (valueObject.getBankAccount() == null) {
			valueObject.setBankAccount(getBankAccountOfOrganization(valueObject));
		}
		if (valueObject.getBankAccount() == null) {
			valueObject.appendErrorMessage("No Bank Account for Org");
			return;
		}
		payment.setC_BankAccount_ID(valueObject.getBankAccount().get_ID());
		if (valueObject.getTenderType() != null) {
			payment.setTenderType(valueObject.getTenderType());
		} else {
			payment.setTenderType(MPayment_BH.TENDERTYPE_Cash);
		}
		if (valueObject.getVisit() != null) {
			payment.setBH_Visit_ID(valueObject.getVisit().get_ID());
		}

		BigDecimal paymentTotal = null;
		BigDecimal tenderAmount = null;
		if (valueObject.getInvoice() != null) {
			payment.setC_Invoice_ID(valueObject.getInvoice().get_ID());
			payment.setC_Currency_ID(valueObject.getInvoice().getC_Currency_ID());
			if (valueObject.getPaymentAmount() != null) {
				tenderAmount = valueObject.getPaymentAmount();
				paymentTotal = tenderAmount.compareTo(valueObject.getInvoice().getGrandTotal()) > 0 ?
						valueObject.getInvoice().getGrandTotal() : tenderAmount;
			} else {
				tenderAmount = valueObject.getInvoice().getGrandTotal();
				paymentTotal = tenderAmount;
			}
		} else {
			payment.setC_Invoice_ID(0);
			if (valueObject.getOrder() != null) {
				payment.setC_Currency_ID(valueObject.getOrder().getC_Currency_ID());
				if (valueObject.getPaymentAmount() != null) {
					tenderAmount = valueObject.getPaymentAmount();
					paymentTotal = tenderAmount.compareTo(valueObject.getOrder().getGrandTotal()) > 0 ?
							valueObject.getOrder().getGrandTotal() : tenderAmount;
				} else {
					tenderAmount = valueObject.getOrder().getGrandTotal();
					paymentTotal = tenderAmount;
				}
			} else {
				payment.setC_Currency_ID(valueObject.getCurrency().get_ID());
				tenderAmount = valueObject.getPaymentAmount();
				paymentTotal = tenderAmount;
			}
		}
		payment.setPayAmt(paymentTotal);
		payment.setBH_TenderAmount(tenderAmount);

		payment.saveEx();
		valueObject.setPayment(payment);

		if (valueObject.getDocumentAction() != null) {
			payment.setDocAction(valueObject.getDocumentAction());
			payment.processIt(valueObject.getDocumentAction());
		}
		payment.saveEx();
	}

	//***********************************
	//utils
	//***********************************
	public static int getDefaultProductCategoryId(ChuBoePopulateVO valueObject) {
		valueObject.validate();
		if (valueObject.isError()) {
			return 0;
		}

		MProductCategory prodCat = new Query(valueObject.getContext(), MProductCategory.Table_Name, "isDefault = 'Y' ",
				valueObject.getTransactionName()).setClient_ID().first();
		if (prodCat != null) {
			return prodCat.get_ID();
		}
		return 0;
	}

	public static int getDefaultTaxCategoryId(ChuBoePopulateVO valueObject) {
		valueObject.validate();
		if (valueObject.isError()) {
			return 0;
		}

		MTaxCategory taxCategory = new Query(valueObject.getContext(), MTaxCategory.Table_Name, "isDefault = 'Y'",
				valueObject.getTransactionName()).setClient_ID().first();
		if (taxCategory != null) {
			return taxCategory.get_ID();
		}
		return 0;
	}

	public static MDocType getDocumentType(ChuBoePopulateVO valueObject, String documentBaseType,
			String salesDocumentSubType, boolean isSalesTransaction, boolean isShipmentConfirm, boolean isPickQAConfirm) {
		String isSalesTransactionString = isSalesTransaction ? "Y" : "N";
		String isShipmentConfirmString = isShipmentConfirm ? "Y" : "N";
		String isPickQAConfirmString = isPickQAConfirm ? "Y" : "N";
		String where = "(docbasetype = '" + documentBaseType + "' and docsubtypeso = '" + salesDocumentSubType +
				"' and issotrx = '" + isSalesTransactionString + "' and isshipconfirm = '" + isShipmentConfirmString +
				"' and ispickqaconfirm = '" + isPickQAConfirmString + "') " +
				" or (docbasetype = '" + documentBaseType + "' and docsubtypeso is null " +
				" and issotrx = '" + isSalesTransactionString + "' and isshipconfirm = '" + isShipmentConfirmString +
				"' and ispickqaconfirm = '" + isPickQAConfirmString + "') ";
		return new Query(valueObject.getContext(), MDocType.Table_Name, where,
				valueObject.getTransactionName()).setClient_ID().first();
	}

	public static MBankAccount getBankAccountOfOrganization(ChuBoePopulateVO valueObject) {
		valueObject.validate();
		if (valueObject.isError()) {
			return null;
		}

		String where = "ad_org_id = " + valueObject.getOrg().get_ID();
		return new Query(valueObject.getContext(), X_C_BankAccount.Table_Name, where,
				valueObject.getTransactionName()).setOnlyActiveRecords(true).setOrderBy("name").setClient_ID().first();
	}

	public static void changeOrganization(ChuBoePopulateVO valueObject) {
		//do not validate this method. It is used to update the VO so that it can pass validation
		//vo.validate();
		//if (vo.isError())
		//	return;

		String where = "ad_org_id <> " + valueObject.getOrg().get_ID() + " and issummary = 'N'";
		MOrg organization = new Query(valueObject.getContext(), X_AD_Org.Table_Name, where,
				valueObject.getTransactionName()).setOnlyActiveRecords(true).setOrderBy("AD_Org_ID").setClient_ID().first();

		if (organization == null) {
			createOrganization(valueObject);
		} else {
			valueObject.setOrg(organization);
			changeWarehouse(valueObject);
		}
	}

	public static void createOrganization(ChuBoePopulateVO valueObject) {
		//do not validate this method. It is used to update the VO so that it can pass validation
		//valueObject.validate();
		//if (valueObject.isError())
		//	return;

		MOrg organization = new MOrg(valueObject.getContext(), 0, valueObject.getTransactionName());
		organization.setName(valueObject.getStepMessage());
		organization.setDescription(valueObject.getStepMessageLong());
		organization.saveEx();
		valueObject.setOrg(organization);

		//find orgInfo record and set location
		MLocation location =
				new MLocation(valueObject.getContext(), valueObject.getCountry().get_ID(), valueObject.getRegion().get_ID(),
						valueObject.getCity(), valueObject.getTransactionName());
		location.saveEx();
		MOrgInfo organizationInformation = organization.getInfo();
		organizationInformation.setC_Location_ID(location.get_ID());
		organizationInformation.saveEx();

		// create a new warehouse
		createWarehouse(valueObject);
		organizationInformation.setM_Warehouse_ID(valueObject.getWarehouse().get_ID());
		organizationInformation.saveEx();

	}

	public static void changeWarehouse(ChuBoePopulateVO valueObject) {
		//do not validate this method. It is used to update the VO so that it can pass validation
		//valueObject.validate();
		//if (valueObject.isError())
		//	return;

		String where = (valueObject.getWarehouse() == null ? "" :
				" m_warehouse_id <> " + valueObject.getWarehouse().get_ID() + " and ") + " ad_org_id = " +
				valueObject.getOrg().get_ID() + " and IsInTransit = 'N' ";
		MWarehouse_BH warehouse = new Query(valueObject.getContext(), X_M_Warehouse.Table_Name, where,
				valueObject.getTransactionName()).setOnlyActiveRecords(true).setOrderBy("M_Warehouse_ID").setClient_ID()
				.first();

		if (warehouse == null) {
			createWarehouse(valueObject);
		} else {
			valueObject.setWarehouse(warehouse);
		}
	}

	public static void createWarehouse(ChuBoePopulateVO valueObject) {
		//do not validate this method. It is used to update the VO so that it can pass validation
		//valueObject.validate();
		//if (valueObject.isError())
		//	return;

		MWarehouse_BH warehouse = new MWarehouse_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		warehouse.setAD_Org_ID(valueObject.getOrg().get_ID());
		warehouse.setName(valueObject.getStepMessage());
		warehouse.setDescription(valueObject.getStepMessageLong());
		if (valueObject.getOrg().getInfo() != null) {
			warehouse.setC_Location_ID(valueObject.getOrg().getInfo().getC_Location_ID());
		}
		warehouse.saveEx();
		valueObject.setWarehouse(warehouse);
		MLocator loc = new MLocator(valueObject.getWarehouse(), String.valueOf(valueObject.getRandomNumber()));
		loc.setIsDefault(true);
		loc.saveEx();
	}

	public static void createAndOpenAllFiscalYears(ChuBoePopulateVO valueObject) {
		valueObject.validate();
		if (valueObject.isError()) {
			return;
		}

		//create years for next and past to support broad date ranges
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(valueObject.getDate());
		int currentYear = cal.get(Calendar.YEAR);
		List<MCalendar> calendars = new Query(valueObject.getContext(), X_C_Calendar.Table_Name, null,
				valueObject.getTransactionName()).setOnlyActiveRecords(true).setClient_ID().list();
		for (MCalendar calendar : calendars) {
			String where = " fiscalyear::int in (" + currentYear + "," + (currentYear - 1) + ", " + (currentYear + 1) +
					") and C_Calendar_ID = " + calendar.get_ID();
			List<MYear> years = new Query(valueObject.getContext(), X_C_Year.Table_Name, where,
					valueObject.getTransactionName()).setOnlyActiveRecords(true).setClient_ID().list();
			Set<String> fiscalYears = years.stream().map(MYear::getFiscalYear).collect(Collectors.toSet());

			//create a set of all three years
			List<String> neededYears = new ArrayList<>();
			if (!fiscalYears.contains(String.valueOf(currentYear))) {
				neededYears.add(String.valueOf(currentYear));
			}
			if (!fiscalYears.contains(String.valueOf(currentYear + 1))) {
				neededYears.add(String.valueOf(currentYear + 1));
			}
			if (!fiscalYears.contains(String.valueOf(currentYear - 1))) {
				neededYears.add(String.valueOf(currentYear - 1));
			}

			//iterate across the set to create the years that remain
			for (String neededYear : neededYears) {
				MYear newYear = new MYear(valueObject.getContext(), 0, valueObject.getTransactionName());
				newYear.setC_Calendar_ID(calendar.get_ID());
				newYear.setFiscalYear(neededYear);
				newYear.setAD_Org_ID(0);
				newYear.saveEx();
				newYear.createStdPeriods(valueObject.getClient().getLocale());
			}
		}

		//open all non-open periods for this client
		changePeriodControlStatus(valueObject, MPeriodControl.PERIODSTATUS_Open);

		//remove automatic period control
		List<MAcctSchema> accountingSchemaList =
				new Query(valueObject.getContext(), X_C_AcctSchema.Table_Name, " AutoPeriodControl = 'Y' ",
						valueObject.getTransactionName()).setOnlyActiveRecords(true).setClient_ID().list();
		for (MAcctSchema accountingSchema : accountingSchemaList) {
			accountingSchema.setAutoPeriodControl(false);
			accountingSchema.saveEx();
		}
	}

	public static void changePeriodControlStatus(ChuBoePopulateVO valueObject, String newStatus) {
		valueObject.validate();
		if (valueObject.isError()) {
			return;
		}

		String where = " PeriodStatus <> '" + newStatus + "'";
		List<MPeriodControl> periodControlList = new Query(valueObject.getContext(), X_C_PeriodControl.Table_Name, where,
				valueObject.getTransactionName()).setOnlyActiveRecords(true).setClient_ID().list();
		for (MPeriodControl periodControl : periodControlList) {
			periodControl.setPeriodStatus(newStatus);
			periodControl.saveEx();
		}
	}

	public static Timestamp getDateOffset(Timestamp initialDate, int days) {
		GregorianCalendar baseCal = new GregorianCalendar();
		baseCal.setTime(initialDate);
		baseCal.add(Calendar.DAY_OF_MONTH, days);
		return new Timestamp(baseCal.getTimeInMillis());
	}

	//Instructions
	// Step 1: setProcess_UU
	// Step 2: setProcessTable_ID and setProcessRecord_ID if needed
	//		used when running a process against a given record - as opposed to 0,0 from the menu.
	// Step 3: addProcessInfoParam see example below
	public static void runProcess(ChuBoePopulateVO valueObject) {
		valueObject.validate();
		if (valueObject.isError()) {
			return;
		}

		//further validation
		if (valueObject.getProcessInformationParameters() == null) {
			valueObject.appendErrorMessage("Parameter List is null - It should at least be an empty List");
		} else if (valueObject.getProcessUuid() == null) {
			valueObject.appendErrorMessage("Process UU is null - cannot look up process");
		}
		if (valueObject.isError()) {
			return;
		}

		MProcess process = new Query(Env.getCtx(), X_AD_Process.Table_Name, "AD_Process_UU=?",
				valueObject.getTransactionName()).setParameters(valueObject.getProcessUuid()).first();

		// Create an instance of the process I want to run
		ProcessCall processCall = null;
		boolean procSuccess = false;

		processCall = Core.getProcess(process.getClassname());

		// Create a process info instance. This is a composite class containing the parameters.
		ProcessInfo processInformation =
				new ProcessInfo("", process.get_ID(), valueObject.getProcessTableId(), valueObject.getProcessRecordId());


		//how to set parameters....
		//ProcessInfoParameter piClient = new ProcessInfoParameter("AD_Client_ID", getAD_Client_ID(), "", "", "");
		//ProcessInfoParameter piOrg = new ProcessInfoParameter("AD_Org_ID", 0, "", "", "");
		//valueObject.addProcessInfoParam(piClient);
		//...
		List<ProcessInfoParameter> processInformationParameters = valueObject.getProcessInformationParameters();
		if (!processInformationParameters.isEmpty()) {
			processInformation.setParameter(valueObject.getProcessInformationParameters()
					.toArray(new ProcessInfoParameter[processInformationParameters.size()]));
		}

		// Create process instance (mainly for logging/sync purpose)
		MPInstance processInstance = new MPInstance(Env.getCtx(), process.get_ID(), valueObject.getProcessRecordId());
		processInstance.saveEx();

		// Connect the process to the process instance.
		processInformation.setAD_PInstance_ID(processInstance.get_ID());

		procSuccess = processCall.startProcess(Env.getCtx(), processInformation, null);

		if (!procSuccess) {
			valueObject.appendErrorMessage("Process Failed: " + process.getClassname());
		}

		clearProcess(valueObject);
	}

	public static void clearProcess(ChuBoePopulateVO valueObject) {
		valueObject.setProcessUuid(null);
		valueObject.setProcessInformationParameters(new ArrayList<ProcessInfoParameter>());
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
	}

	/**
	 * This creates and/or sets the default purchase and sales price lists on the value object
	 *
	 * @param valueObject The value object used to store all information
	 */
	public static void createDefaultPriceLists(ChuBoePopulateVO valueObject) {
		MPriceList defaultSalesPriceList = new Query(valueObject.getContext(), MPriceList.Table_Name,
				MPriceList.COLUMNNAME_IsDefault + "=? AND " + MPriceList.COLUMNNAME_IsSOPriceList + "=?",
				valueObject.getTransactionName()).setParameters("Y", "Y").setOnlyActiveRecords(true).setClient_ID()
				.setOrderBy("ORDER BY " + MPriceList.COLUMNNAME_Created).first();

		MPriceList defaultPurchasePriceList = new Query(valueObject.getContext(), MPriceList.Table_Name,
				MPriceList.COLUMNNAME_IsDefault + "=? AND " + MPriceList.COLUMNNAME_IsSOPriceList + "=?",
				valueObject.getTransactionName()).setParameters("Y", "N").setOnlyActiveRecords(true).setClient_ID()
				.setOrderBy("ORDER BY " + MPriceList.COLUMNNAME_Created).first();

		// We'll temporarily override the step name
		String originalStepName = valueObject.getStepName();
		valueObject.setStepName("Create Default Price Lists");

		if (defaultSalesPriceList == null) {
			defaultSalesPriceList = new MPriceList(valueObject.getContext(), 0, valueObject.getTransactionName());
			defaultSalesPriceList.setName("SO_During: " + valueObject.getStepName() + valueObject.getRandomNumber());
			defaultSalesPriceList.setDescription(valueObject.getStepMessageLong());
			defaultSalesPriceList.setAD_Org_ID(0);
			defaultSalesPriceList.setIsSOPriceList(true);
			defaultSalesPriceList.setC_Currency_ID(valueObject.getCurrency().get_ID());
			defaultSalesPriceList.setIsDefault(true);
			defaultSalesPriceList.saveEx();
		}
		valueObject.setSalesPriceList(defaultSalesPriceList);

		if (defaultPurchasePriceList == null) {
			defaultPurchasePriceList = new MPriceList(valueObject.getContext(), 0, valueObject.getTransactionName());
			defaultPurchasePriceList.setName("PO_During: " + valueObject.getStepName() + valueObject.getRandomNumber());
			defaultPurchasePriceList.setDescription(valueObject.getStepMessageLong());
			defaultPurchasePriceList.setAD_Org_ID(0);
			defaultPurchasePriceList.setIsSOPriceList(false);
			defaultPurchasePriceList.setC_Currency_ID(valueObject.getCurrency().get_ID());
			defaultPurchasePriceList.setIsDefault(true);
			defaultPurchasePriceList.saveEx();
			defaultSalesPriceList.saveEx();
		}
		valueObject.setPurchasePriceList(defaultPurchasePriceList);

		// Now handle the price list versions, if need be
		Timestamp datePL = valueObject.getDatePriceList();
		if (datePL == null)
			datePL = ChuBoeCreateEntity.getDateOffset(valueObject.getDate(), -365);

		//see if price list version already exists
		String sqlWhere = "M_PriceList_ID = ? and ValidFrom = ?";

		MPriceListVersion salesPriceListVersion =
				new Query(valueObject.getContext(), MPriceListVersion.Table_Name, sqlWhere, valueObject.getTransactionName())
						.setClient_ID()
						.setParameters(defaultSalesPriceList.get_ID(), datePL)
						.first();

		MPriceListVersion purchasePriceListVersion =
				new Query(valueObject.getContext(), MPriceListVersion.Table_Name, sqlWhere, valueObject.getTransactionName())
						.setClient_ID()
						.setParameters(defaultPurchasePriceList.get_ID(), datePL)
						.first();

		if (purchasePriceListVersion == null) {
			//get bogus price list schema - required field
			MDiscountSchema schema = new Query(valueObject.getContext(),
					X_M_DiscountSchema.Table_Name,
					"discounttype = '" + X_M_DiscountSchema.DISCOUNTTYPE_Pricelist + "'",
					valueObject.getTransactionName())
					.setClient_ID()
					.first();

			purchasePriceListVersion = new MPriceListVersion(valueObject.getContext(), 0, valueObject.getTransactionName());
			purchasePriceListVersion.setAD_Org_ID(0);
			purchasePriceListVersion.setName(datePL + "; IsSOTrx=N; " + valueObject.getRandomNumber());
			purchasePriceListVersion.setDescription(valueObject.getStepMessageLong());
			purchasePriceListVersion.setM_PriceList_ID(defaultPurchasePriceList.get_ID());
			purchasePriceListVersion.setValidFrom(datePL);
			purchasePriceListVersion.setM_DiscountSchema_ID(schema.get_ID());
			purchasePriceListVersion.saveEx();
		}

		if (salesPriceListVersion == null) {
			//get bogus price list schema - required field
			MDiscountSchema schema = new Query(valueObject.getContext(),
					X_M_DiscountSchema.Table_Name,
					"discounttype = '" + X_M_DiscountSchema.DISCOUNTTYPE_Pricelist + "'",
					valueObject.getTransactionName())
					.setClient_ID()
					.first();

			salesPriceListVersion = new MPriceListVersion(valueObject.getContext(), 0, valueObject.getTransactionName());
			salesPriceListVersion.setAD_Org_ID(0);
			salesPriceListVersion.setName(datePL + "; IsSOTrx=Y; " + valueObject.getRandomNumber());
			salesPriceListVersion.setDescription(valueObject.getStepMessageLong());
			salesPriceListVersion.setM_PriceList_ID(defaultSalesPriceList.get_ID());
			salesPriceListVersion.setValidFrom(datePL);
			salesPriceListVersion.setM_DiscountSchema_ID(schema.get_ID());
			salesPriceListVersion.saveEx();
		}

		valueObject.setStepName(originalStepName);
	}

	/**
	 * Some methods need to be run as the System user, even though that may not be what the user is signed in as. This
	 * method allows that to happen and ensure the context will be reset after execution.
	 *
	 * @param valueObject The value object used to store all information
	 */
	public static void runProcessAsSystem(ChuBoePopulateVO valueObject) {
		String sessionContextKey = "#AD_Session_ID"; // TODO: Replace with sessionContextKey when iDempiere 8.2+
		// We also have to update the session, so get it first before the context changes
		// Update the client & org
		int currentClientId = Env.getAD_Client_ID(Env.getCtx());
		int currentOrgId = Env.getAD_Org_ID(Env.getCtx());
		int currentRoleId = Env.getAD_Role_ID(Env.getCtx());
		int currentSessionId = Env.getContextAsInt(Env.getCtx(), sessionContextKey);
		Env.setContext(Env.getCtx(), Env.AD_CLIENT_ID, 0);
		Env.setContext(Env.getCtx(), Env.AD_ORG_ID, 0);
		Env.setContext(Env.getCtx(), Env.AD_ROLE_ID, 0);

		int currentValueObjectClientId = Env.getAD_Client_ID(valueObject.getContext());
		int currentValueObjectOrgId = Env.getAD_Org_ID(valueObject.getContext());
		int currentValueObjectRoleId = Env.getAD_Role_ID(valueObject.getContext());
		int currentValueObjectSessionId = Env.getContextAsInt(valueObject.getContext(), sessionContextKey);
		Env.setContext(valueObject.getContext(), Env.AD_CLIENT_ID, 0);
		Env.setContext(valueObject.getContext(), Env.AD_ORG_ID, 0);
		Env.setContext(valueObject.getContext(), Env.AD_ROLE_ID, 0);

		// Handle the session
		Env.setContext(valueObject.getContext(), sessionContextKey, 0);
		MSession session = MSession.get(Env.getCtx(), true);
		session.saveEx();
		Env.setContext(Env.getCtx(), sessionContextKey, session.get_ID());
		Env.setContext(valueObject.getContext(), sessionContextKey, session.get_ID());

		try {
			ChuBoeCreateEntity.runProcess(valueObject);
		} finally {
			// Logout before resetting the context
			session.logout();

			// First, reset the value object's context (avoids overwriting the Env.getCtx() sometimes)
			Env.setContext(valueObject.getContext(), Env.AD_CLIENT_ID, currentValueObjectClientId);
			Env.setContext(valueObject.getContext(), Env.AD_ORG_ID, currentValueObjectOrgId);
			Env.setContext(valueObject.getContext(), Env.AD_ROLE_ID, currentValueObjectRoleId);
			Env.setContext(valueObject.getContext(), sessionContextKey, currentValueObjectSessionId);

			// Now reset the actual environment
			Env.setContext(Env.getCtx(), Env.AD_CLIENT_ID, currentClientId);
			Env.setContext(Env.getCtx(), Env.AD_ORG_ID, currentOrgId);
			Env.setContext(Env.getCtx(), Env.AD_ROLE_ID, currentRoleId);
			// Now restore the old session
			Env.setContext(Env.getCtx(), sessionContextKey, currentSessionId);
			session = MSession.get(Env.getCtx(), true);
			session.save();
		}
	}

	/**
	 * This is the same as the {@link #runProcess(ChuBoePopulateVO)}, except that it sets a file to the value object
	 * and doesn't clear the process. You must run {@link #clearReport(ChuBoePopulateVO)} after retrieving the
	 * generated report file.
	 * <br/><br/>
	 * Instructions:
	 * <ul>
	 *   <li>Step 1: setProcess_UU</li>
	 *   <li>Step 2: setProcessTable_ID and setProcessRecord_ID if needed used when running a process against a given
	 *   record - as opposed to 0,0 from the menu.</li>
	 *   <li>Step 3: addProcessInfoParam see example below</li>
	 * </ul>
	 *
	 * @param valueObject The value object used to store all information
	 */
	public static void runReport(ChuBoePopulateVO valueObject) {
		valueObject.validate();
		if (valueObject.isError()) {
			return;
		}

		//further validation
		if (valueObject.getProcessInformationParameters() == null)
			valueObject.appendErrorMessage("Parameter List is null - It should at least be an empty List");
		else if (valueObject.getProcessUuid() == null)
			valueObject.appendErrorMessage("Process UU is null - cannot look up process");
		if (valueObject.isError())
			return;

		MProcess process = new Query(Env.getCtx(), X_AD_Process.Table_Name,
				"AD_Process_UU=?", valueObject.getTransactionName()).setParameters(valueObject.getProcessUuid()).first();

		// Create a process info instance. This is a composite class containing the parameters.
		ProcessInfo processInfo =
				new ProcessInfo("", process.get_ID(), valueObject.getProcessTableId(), valueObject.getProcessRecordId());
		processInfo.setIsBatch(true);
		processInfo.setExport(true);
		String reportTypeToUse = valueObject.getReportType() == null ? "pdf" : valueObject.getReportType();
		processInfo.setReportType(reportTypeToUse.toUpperCase());
		processInfo.setExportFileExtension(reportTypeToUse.toLowerCase());

		List<ProcessInfoParameter> params = valueObject.getProcessInformationParameters();
		if (!params.isEmpty()) {
			processInfo.setParameter(
					valueObject.getProcessInformationParameters().toArray(new ProcessInfoParameter[params.size()]));
		}

		// Create process instance (mainly for logging/sync purpose)
		MPInstance mpi = new MPInstance(Env.getCtx(), process.get_ID(), valueObject.getProcessRecordId());
		mpi.saveEx();

		// Connect the process to the process instance.
		processInfo.setAD_PInstance_ID(mpi.get_ID());

		ServerProcessCtl.process(processInfo, null);

		if (processInfo.getExportFile() == null) {
			valueObject.appendErrorMessage("Report Generation Failed: " + process.getClassname());
		}

		valueObject.setReport(processInfo.getExportFile());
	}

	public static void clearReport(ChuBoePopulateVO valueObject) {
		valueObject.setProcessUuid(null);
		valueObject.setProcessInformationParameters(new ArrayList<>());
		valueObject.setProcessRecordId(0);
		valueObject.setProcessTableId(0);
		valueObject.setReport(null);
	}

	/**
	 * Create an inventory record
	 *
	 * @param valueObject The value object used to store all information
	 */
	public static void createInventory(ChuBoePopulateVO valueObject) {
		valueObject.validate();
		if (valueObject.isError()) {
			return;
		}

		// perform further validation if needed based on business logic
		if (valueObject.getDocumentType() == null) {
			valueObject.appendErrorMessage("DocType is Null");
			return;
		} else if (valueObject.getBusinessPartner() == null) {
			valueObject.appendErrorMessage("BP is Null");
			return;
		} else if (valueObject.getWarehouse() == null) {
			valueObject.appendErrorMessage("Warehouse is Null");
			return;
		}

		// create inventory header
		MInventory_BH inventory = new MInventory_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		inventory.setAD_Org_ID(valueObject.getOrg().get_ID());
		inventory.setDescription(valueObject.getStepMessageLong());
		inventory.setC_DocType_ID(valueObject.getDocumentType().get_ID());
		inventory.setM_Warehouse_ID(valueObject.getWarehouse().get_ID());
		inventory.setMovementDate(valueObject.getDate());
		inventory.saveEx();
		valueObject.setInventory(inventory);

		// create inventory line
		MInventoryLine_BH inventoryLine =
				new MInventoryLine_BH(valueObject.getContext(), 0, valueObject.getTransactionName());
		inventoryLine.setAD_Org_ID(valueObject.getOrg().get_ID());
		inventoryLine.setDescription(valueObject.getStepMessageLong());
		inventoryLine.setM_Inventory_ID(inventory.get_ID());
		inventoryLine.setM_Product_ID(valueObject.getProduct().get_ID());
		inventoryLine.setM_AttributeSetInstance_ID(
				valueObject.getAttributeSetInstance() == null ? 0 : valueObject.getAttributeSetInstance().get_ID());
		inventoryLine.setM_Locator_ID(valueObject.getWarehouse().getDefaultLocator().get_ID());
		if (valueObject.getQuantity() == null || valueObject.getQuantity().compareTo(Env.ZERO) == 0) {
			inventoryLine.setQtyCount(Env.ONE);
		} else {
			inventoryLine.setQtyCount(valueObject.getQuantity());
		}

		// Set the quantity on the book from m_storageonhand
		List<Object> parameters = new ArrayList<>();
		String whereClause =
				MStorageOnHand.COLUMNNAME_M_Product_ID + "=? AND " + MStorageOnHand.COLUMNNAME_M_Locator_ID + "=?";
		parameters.add(valueObject.getProduct().get_ID());
		parameters.add(inventoryLine.getM_Locator_ID());
		if (valueObject.getAttributeSetInstance() != null) {
			whereClause += " AND " + MStorageOnHand.COLUMNNAME_M_AttributeSetInstance_ID + "=?";
			parameters.add(valueObject.getAttributeSetInstance().get_ID());
		}
		inventoryLine.setQtyBook(new Query(valueObject.getContext(), MStorageOnHand.Table_Name, whereClause,
				valueObject.getTransactionName()).setOnlyActiveRecords(true).setParameters(parameters)
				.sum(MStorageOnHand.COLUMNNAME_QtyOnHand));

		inventoryLine.saveEx();
		valueObject.setInventoryLine(inventoryLine);

		if (valueObject.getDocumentAction() != null) {
			if (valueObject.getLogger() != null) {
				valueObject.getLogger().fine("Starting DocAction: " + valueObject.getDocumentAction());
			}
			inventory.setDocAction(valueObject.getDocumentAction());
			inventory.processIt(valueObject.getDocumentAction());
		}
		if (valueObject.getLogger() != null) {
			valueObject.getLogger().fine("Saving inventory after completion. Doc Status: " + inventory.getDocStatus());
		}
		inventory.saveEx();
	}

	/**
	 * This creates an InOut record based on the order. This will not call
	 * {@link ChuBoePopulateVO#setInOutLine(MInOutLine)} since an order might have several lines
	 *
	 * @param valueObject The value object used to store all information
	 */
	public static void createInOutFromOrder(ChuBoePopulateVO valueObject) {
		valueObject.validate();
		if (valueObject.isError()) {
			return;
		}

		//perform further validation if needed based on business logic
		if (valueObject.getDocumentType() == null) {
			valueObject.appendErrorMessage("DocType is Null");
			return;
		} else if (valueObject.getBusinessPartner() == null) {
			valueObject.appendErrorMessage("BP is Null");
			return;
		} else if (valueObject.getWarehouse() == null) {
			valueObject.appendErrorMessage("Warehouse is Null");
			return;
		} else if (!valueObject.getOrder().getDocStatus().equals(X_C_Order.DOCSTATUS_Completed)) {
			valueObject.appendErrorMessage("Order Not Completed");
			return;
		}

		MInOut inOut = new MInOut(valueObject.getOrder(), valueObject.getDocumentType().get_ID(), valueObject.getDate());

		inOut.setMovementType(valueObject.getDocumentType().isSOTrx() ? X_M_InOut.MOVEMENTTYPE_CustomerShipment :
				X_M_InOut.MOVEMENTTYPE_VendorReceipts);
		inOut.saveEx();
		valueObject.setInOut(new MInOut_BH(valueObject.getContext(), inOut.get_ID(), valueObject.getTransactionName()));

		// add lines if any
		MOrderLine[] orderLines = valueObject.getOrder().getLines(true, "M_Product_ID");
		for (MOrderLine orderLine : orderLines) {
			MInOutLine line = new MInOutLine(inOut);
			line.setOrderLine(orderLine, valueObject.getWarehouse().getDefaultLocator().get_ID(), Env.ZERO);
			line.setQty(orderLine.getQtyOrdered());
			line.saveEx(valueObject.getTransactionName());
		}

		if (valueObject.getDocumentAction() != null) {
			inOut.setDocAction(valueObject.getDocumentAction());
			inOut.processIt(valueObject.getDocumentAction());
		}
		inOut.saveEx();
	}
}
