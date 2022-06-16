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

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.adempiere.base.Core;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MBankAccount;
import org.compiere.model.MCalendar;
import org.compiere.model.MDiscountSchema;
import org.compiere.model.MDocType;
import org.compiere.model.MInOut;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MLocation;
import org.compiere.model.MLocator;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MOrg;
import org.compiere.model.MOrgInfo;
import org.compiere.model.MPInstance;
import org.compiere.model.MPayment;
import org.compiere.model.MPeriodControl;
import org.compiere.model.MPriceList;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MProcess;
import org.compiere.model.MProduct;
import org.compiere.model.MProductBOM;
import org.compiere.model.MProductCategory;
import org.compiere.model.MProductPrice;
import org.compiere.model.MTaxCategory;
import org.compiere.model.MUOM;
import org.compiere.model.MUser;
import org.compiere.model.MWarehouse;
import org.compiere.model.MYear;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Org;
import org.compiere.model.X_AD_Process;
import org.compiere.model.X_AD_User;
import org.compiere.model.X_C_AcctSchema;
import org.compiere.model.X_C_BankAccount;
import org.compiere.model.X_C_Calendar;
import org.compiere.model.X_C_DocType;
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
import org.compiere.util.Env;

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
	public static void createBP(ChuBoePopulateVO vo) {
		vo.validate();
		if (vo.isError())
			return;
		
		//perform further validation if needed based on business logic
		//NONE
		
		//use vo.clearBP() to create a new BP or replace a new one
		if (vo.getBP() == null)
		{
			//create bp
			MBPartner bp = new MBPartner(vo.getCtx(), 0, vo.get_trxName());
			bp.setAD_Org_ID(0);
			bp.setName(vo.getStepMsg());
			bp.setDescription(vo.getStepMsgLong());
			bp.setIsCustomer(true);
			bp.setIsVendor(true);
			bp.saveEx();
			vo.setBP(bp);
			
			//create SO pricelist if not already created from previous BP - used later in document creation
			MPriceList spl = null;
			if (vo.getPriceListSO() == null) {
				spl = new MPriceList(vo.getCtx(), 0, vo.get_trxName());
				spl.setName("SO_During: " + vo.getStepName()+vo.getRandom());
				spl.setDescription(vo.getStepMsgLong());
				spl.setAD_Org_ID(0);
				spl.setIsSOPriceList(true);
				spl.setC_Currency_ID(vo.getCurrency().get_ID());
				spl.saveEx();
				vo.setPriceListSO(spl);
			}
			bp.setM_PriceList_ID(vo.getPriceListSO().get_ID());
			
			//create PO priceList if not already created from previous BP - used later in document creation
			MPriceList ppl = null;
			if (vo.getPriceListPO() == null) {
				ppl = new MPriceList(vo.getCtx(), 0, vo.get_trxName());
				ppl.setName("PO_During: " + vo.getStepName()+vo.getRandom());
				ppl.setDescription(vo.getStepMsgLong());
				ppl.setAD_Org_ID(0);
				ppl.setIsSOPriceList(false);
				ppl.setC_Currency_ID(vo.getCurrency().get_ID());
				ppl.saveEx();
				vo.setPriceListPO(ppl);
			}	
			bp.setPO_PriceList_ID(vo.getPriceListPO().get_ID());
			
			bp.saveEx();
			
			//create loc
			MBPartnerLocation bploc = new MBPartnerLocation(vo.getCtx(), 0, vo.get_trxName());
			bploc.setAD_Org_ID(0);
			bploc.setC_BPartner_ID(bp.get_ID());
			MLocation loc = new MLocation(vo.getCtx(), vo.getCountry().get_ID(), vo.getRegion().get_ID(), vo.getCity(), vo.get_trxName());
			loc.saveEx();
			bploc.setC_Location_ID(loc.get_ID());
			bploc.setName(vo.getCity() + " " + vo.getRegion().getName());
			bploc.saveEx();
			vo.setBPLoc(bploc);
			
			//create contact
			MUser user = new MUser(vo.getBP());
			user.setNotificationType(X_AD_User.NOTIFICATIONTYPE_None);
			user.setDescription(vo.getStepMsgLong());
			user.saveEx();
			vo.setUser(user);
			
		}
	} //create BP
	
	//create product second
	public static void createProduct(ChuBoePopulateVO vo) {
		vo.validate();
		if (vo.isError())
			return;
		
		//perform further validation if needed based on business logic

		
		//use vo.clearProduct() to create new product
		if (vo.getProduct() == null) {
			MProduct product = new MProduct(vo.getCtx(), 0, vo.get_trxName());
			product.setAD_Org_ID(0);
			product.setDescription(vo.getStepMsgLong());
			product.setC_UOM_ID(MUOM.getDefault_UOM_ID(vo.getCtx()));
			product.setM_Product_Category_ID(getDefaultMProductCategoryID(vo));
			product.setC_TaxCategory_ID(getDefaultMTaxCategoryID(vo));
			product.setName(vo.getScenarioName());
			product.setProductType(X_M_Product.PRODUCTTYPE_Item);
			product.saveEx();
			vo.setProduct(product);
			
			if (vo.getBP() != null) {
				//create PO and SO price list entries
				MPriceList spl = new MPriceList(vo.getCtx(), vo.getBP().getM_PriceList_ID(), vo.get_trxName());
				MPriceList ppl = new MPriceList(vo.getCtx(), vo.getBP().getPO_PriceList_ID(), vo.get_trxName());

				Timestamp datePL = vo.getDatePriceList();
				if (datePL == null)
					datePL = ChuBoeCreateEntity.getDateOffset(vo.getDate(), -365);
				
				//see if price list version already exists
				String sqlWhere = "M_PriceList_ID = ? and ValidFrom = ?";
				
				MPriceListVersion splv = new Query(vo.getCtx(), MPriceListVersion.Table_Name, sqlWhere, vo.get_trxName())
					.setClient_ID()
					.setParameters(spl.get_ID(), datePL)
					.first();
				
				MPriceListVersion pplv = new Query(vo.getCtx(), MPriceListVersion.Table_Name, sqlWhere, vo.get_trxName())
					.setClient_ID()
					.setParameters(ppl.get_ID(), datePL)
					.first();
				
				if (pplv == null) {
					//get bogus price list schema - required field
					MDiscountSchema schema = new Query(vo.getCtx(), 
							X_M_DiscountSchema.Table_Name, 
							"discounttype = '"+X_M_DiscountSchema.DISCOUNTTYPE_Pricelist+"'", 
							vo.get_trxName())
						.setClient_ID()
						.first();

					pplv = new MPriceListVersion(vo.getCtx(), 0, vo.get_trxName());
					pplv.setAD_Org_ID(0);
					pplv.setName(datePL + "; IsSOTrx=N; " + vo.getRandom());
					pplv.setDescription(vo.getStepMsgLong());
					pplv.setM_PriceList_ID(ppl.get_ID());
					pplv.setValidFrom(datePL);
					pplv.setM_DiscountSchema_ID(schema.get_ID());
					pplv.saveEx();
				}

				if (splv == null) {
					//get bogus price list schema - required field
					MDiscountSchema schema = new Query(vo.getCtx(), 
							X_M_DiscountSchema.Table_Name, 
							"discounttype = '"+X_M_DiscountSchema.DISCOUNTTYPE_Pricelist+"'", 
							vo.get_trxName())
						.setClient_ID()
						.first();
					
					splv = new MPriceListVersion(vo.getCtx(), 0, vo.get_trxName());
					splv.setAD_Org_ID(0);
					splv.setName(datePL + "; IsSOTrx=Y; " + vo.getRandom());
					splv.setDescription(vo.getStepMsgLong());
					splv.setM_PriceList_ID(spl.get_ID());
					splv.setValidFrom(datePL);
					splv.setM_DiscountSchema_ID(schema.get_ID());
					splv.saveEx();
				}

				MProductPrice pprice = new MProductPrice(vo.getCtx(), pplv.get_ID(), vo.getProduct().get_ID(), vo.get_trxName());
				pprice.setPriceLimit(vo.getLimitPricePO());
				pprice.setPriceStd(vo.getStdPricePO());
				pprice.setPriceList(vo.getListPricePO());
				pprice.saveEx();
				
				MProductPrice sprice = new MProductPrice(vo.getCtx(), splv.get_ID(), vo.getProduct().get_ID(), vo.get_trxName());
				sprice.setPriceLimit(vo.getLimitPriceSO());
				sprice.setPriceStd(vo.getStdPriceSO());
				sprice.setPriceList(vo.getListPriceSO());
				sprice.saveEx();
			}
		}
	} //create product
	
	public static void createProductBOM(ChuBoePopulateVO vo, BigDecimal qty, MProduct parentProduct) {
		vo.validate();
		if (vo.isError())
			return;
		
		//vo, Qty, parentProd
		MProductBOM bom = new MProductBOM(vo.getCtx(), 0, vo.get_trxName());
		bom.setAD_Org_ID(0);
		bom.setDescription(vo.getStepMsgLong());
		bom.setBOMQty(qty);
		bom.setBOMType(MProductBOM.BOMTYPE_StandardPart);
		bom.setIsActive(true);
		bom.setM_ProductBOM_ID(vo.getProduct().get_ID());
		bom.setM_Product_ID(parentProduct.get_ID());

		//find next line number
		int newLine = new Query(vo.getCtx(), MProductBOM.Table_Name, "M_Product_ID = ?", vo.get_trxName())
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
	
	public static void createOrder(ChuBoePopulateVO vo) {
		vo.validate();
		if (vo.isError())
			return;
		
		//perform further validation if needed based on business logic
		if (vo.getDocType() == null) {
			vo.appendErrorMsg("DocType is Null");
			return;
		}
		else if (vo.getBP() == null) {
			vo.appendErrorMsg("BP is Null");
			return;
		}
		else if (vo.getWarehouse() == null) {
			vo.appendErrorMsg("Warehouse is Null");
			return;
		}
		
		//create order header
		MOrder order = new MOrder(vo.getCtx(), 0, vo.get_trxName());
		order.setAD_Org_ID(vo.getOrg().get_ID());
		order.setDescription(vo.getStepMsgLong());
		order.setC_DocTypeTarget_ID(vo.getDocType().get_ID());
		order.setDateOrdered(vo.getDate());
		order.setDatePromised(vo.getDate());
		order.setIsSOTrx(vo.getDocType().isSOTrx());
		order.setBPartner(vo.getBP());
		order.setM_PriceList_ID(vo.getDocType().isSOTrx() ? vo.getBP().getM_PriceList_ID() : vo.getBP().getPO_PriceList_ID());
		order.setM_Warehouse_ID(vo.getWarehouse().get_ID());
		order.saveEx();
		vo.setOrder(order);
		
		//create order line
		MOrderLine line = new MOrderLine(vo.getCtx(), 0, vo.get_trxName());
		line.setAD_Org_ID(vo.getOrg().get_ID());
		line.setDescription(vo.getStepMsgLong());
		line.setC_Order_ID(order.get_ID());
		line.setM_Product_ID(vo.getProduct().get_ID());
		line.setC_UOM_ID(vo.getProduct().getC_UOM_ID());
		line.setM_AttributeSetInstance_ID(0);
		if(vo.getQty() == null || vo.getQty().compareTo(Env.ZERO) == 0)
			line.setQty(Env.ONE);
		else
			line.setQty(vo.getQty());
		line.setHeaderInfo(order);
		line.setPrice();

		line.saveEx();
		vo.setOrderLine(line);
		
		if(vo.getDocAction() != null) {
			if (vo.getLog() != null) vo.getLog().fine("Starting DocAction: " + vo.getDocAction());
			order.setDocAction(vo.getDocAction());
			order.processIt(vo.getDocAction());
		}
		if (vo.getLog() != null) vo.getLog().fine("Saving order after completion. Doc Status: " + order.getDocStatus());
		order.saveEx();

	} //create order
	
	public static void createInOut(ChuBoePopulateVO vo) {
		vo.validate();
		if (vo.isError())
			return;
		
		//perform further validation if needed based on business logic
		if (vo.getDocType() == null) {
			vo.appendErrorMsg("DocType is Null");
			return;
		}
		else if (vo.getBP() == null) {
			vo.appendErrorMsg("BP is Null");
			return;
		}
		else if (vo.getWarehouse() == null) {
			vo.appendErrorMsg("Warehouse is Null");
			return;
		}
		else if (!vo.getOrder().getDocStatus().equals(X_C_Order.DOCSTATUS_Completed)){
			vo.appendErrorMsg("Order Not Completed");
			return;
		}
		
		//create inout header
		MInOut io = new MInOut(vo.getCtx(), 0, vo.get_trxName());
		io.setAD_Org_ID(vo.getOrg().get_ID());
		io.setDescription(vo.getStepMsgLong());
		io.setC_BPartner_ID(vo.getBP().get_ID());
		io.setC_BPartner_Location_ID(vo.getBPLoc().get_ID());
		io.setAD_User_ID(vo.getUser().get_ID());
		io.setC_DocType_ID(vo.getDocType().get_ID());
		io.setC_Order_ID(vo.getOrder().get_ID());
		io.setM_Warehouse_ID(vo.getWarehouse().get_ID());
		io.setMovementDate(vo.getDate());
		io.setDateAcct(vo.getDate());
		io.setIsSOTrx(vo.getDocType().isSOTrx());
		io.setMovementType(vo.getDocType().isSOTrx() ? X_M_InOut.MOVEMENTTYPE_CustomerShipment : X_M_InOut.MOVEMENTTYPE_VendorReceipts);
		
		io.saveEx();
		vo.setInOut(io);
		
		//create inout line
		MInOutLine iol = new MInOutLine(vo.getCtx(), 0, vo.get_trxName());
		iol.setAD_Org_ID(vo.getOrg().get_ID());
		iol.setDescription(vo.getStepMsgLong());
		iol.setM_InOut_ID(vo.getInOut().get_ID());
		iol.setM_Product_ID(vo.getProduct().get_ID());
		iol.setM_AttributeSetInstance_ID(0);
		iol.setM_Warehouse_ID(vo.getWarehouse().get_ID());
		iol.setM_Locator_ID(vo.getWarehouse().getDefaultLocator().get_ID());
		iol.setC_OrderLine_ID(vo.getOrderLine().get_ID());
		iol.setC_UOM_ID(vo.getProduct().getC_UOM_ID());
		if(vo.getQty() == null || vo.getQty().compareTo(Env.ZERO) == 0)
			iol.setQty(Env.ONE);
		else
			iol.setQty(vo.getQty());

		iol.saveEx();
		vo.setInOutLine(iol);
		
		if(vo.getDocAction() != null) {
			io.setDocAction(vo.getDocAction());
			io.processIt(vo.getDocAction());
		}
		io.saveEx();
	} //create inout
	
	public static void createInvoice(ChuBoePopulateVO vo) {
		vo.validate();
		if (vo.isError())
			return;
		
		//perform further validation if needed based on business logic
		if (vo.getDocType() == null) {
			vo.appendErrorMsg("DocType is Null");
			return;
		}
		else if (vo.getBP() == null) {
			vo.appendErrorMsg("BP is Null");
			return;
		}
		else if (!vo.getOrder().getDocStatus().equals(X_C_Order.DOCSTATUS_Completed)){
			vo.appendErrorMsg("Order Not Completed");
			return;
		}

		
		//create invoice header
		MInvoice inv = new MInvoice(vo.getCtx(), 0, vo.get_trxName());
		inv.setAD_Org_ID(vo.getOrg().get_ID());
		inv.setDescription(vo.getStepMsgLong());
		inv.setC_BPartner_ID(vo.getBP().get_ID());
		inv.setC_BPartner_Location_ID(vo.getBPLoc().get_ID());
		inv.setAD_User_ID(vo.getUser().get_ID());
		inv.setM_PriceList_ID(vo.getDocType().isSOTrx() ? vo.getBP().getM_PriceList_ID() : vo.getBP().getPO_PriceList_ID());
		inv.setC_DocType_ID(vo.getDocType().get_ID());
		inv.setDateInvoiced(vo.getDate());
		inv.setIsSOTrx(vo.getDocType().isSOTrx());
		inv.setC_Order_ID(vo.getOrder().get_ID());
		
		inv.saveEx();
		vo.setInvoice(inv);
		
		//create invoice line
		MInvoiceLine il = new MInvoiceLine(vo.getCtx(), 0, vo.get_trxName());
		il.setC_Invoice_ID(vo.getInvoice().get_ID());
		il.setDescription(vo.getStepMsgLong());
		il.setAD_Org_ID(vo.getOrg().get_ID());
		il.setM_Product_ID(vo.getProduct().get_ID());
		il.setC_UOM_ID(vo.getProduct().getC_UOM_ID());
		il.setM_AttributeSetInstance_ID(0);
		if(vo.getQty() == null || vo.getQty().compareTo(Env.ZERO) == 0)
			il.setQty(Env.ONE);
		else
			il.setQty(vo.getQty());
		il.setC_OrderLine_ID(vo.getOrderLine().get_ID());
		il.setPrice();
		
		il.saveEx();
		vo.setInvoiceLine(il);
		
		if(vo.getDocAction() != null) {
			inv.setDocAction(vo.getDocAction());
			inv.processIt(vo.getDocAction());
		}
		inv.saveEx();
		
	} //create invoice
	
	public static void createPayment(ChuBoePopulateVO vo) {
		vo.validate();
		if (vo.isError())
			return;
		
		//perform further validation if needed based on business logic
		if (vo.getDocType() == null) {
			vo.appendErrorMsg("DocType is Null");
			return;
		}
		else if (vo.getBP() == null) {
			vo.appendErrorMsg("BP is Null");
			return;
		}
		
		//create payment
		MPayment pay = new MPayment(vo.getCtx(), 0, vo.get_trxName());
		pay.setAD_Org_ID(vo.getOrg().get_ID());
		pay.setC_DocType_ID(vo.getDocType().get_ID());
		pay.setIsReceipt(vo.getDocType().isSOTrx());
		pay.setDateTrx(vo.getDate());
		pay.setC_BPartner_ID(vo.getBP().get_ID());
		pay.setDescription(vo.getStepMsgLong());
		pay.setC_Invoice_ID(vo.getInvoice().get_ID());
		if (vo.getBankAcct() == null)
			vo.setBankAcct(getBankAccountOfOrg(vo));
		if (vo.getBankAcct() == null) {
			vo.appendErrorMsg("No Bank Account for Org");
			return;
		}
		pay.setC_BankAccount_ID(vo.getBankAcct().get_ID());
		
		pay.setC_Currency_ID(vo.getInvoice().getC_Currency_ID());
		pay.setPayAmt(vo.getInvoice().getGrandTotal());
		
		pay.saveEx();
		vo.setPayment(pay);
		
		if(vo.getDocAction() != null) {
			pay.setDocAction(vo.getDocAction());
			pay.processIt(vo.getDocAction());
		}
		pay.saveEx();

	}
	
	//***********************************
	//utils
	//***********************************
	protected static int getDefaultMProductCategoryID(ChuBoePopulateVO vo) {
		vo.validate();
		if (vo.isError())
			return 0;

		MProductCategory prodCat = new Query(vo.getCtx(), 
				MProductCategory.Table_Name, 
				"isDefault = 'Y' ", 
				vo.get_trxName())
			.setClient_ID()
			.first();
		if (prodCat != null)
			return prodCat.get_ID();
		else return 0;
	}

	protected static int getDefaultMTaxCategoryID(ChuBoePopulateVO vo) {
		vo.validate();
		if (vo.isError())
			return 0;

		MTaxCategory taxCat = new Query(vo.getCtx(), MTaxCategory.Table_Name, "isDefault = 'Y'", vo.get_trxName())
			.setClient_ID()
			.first();
		if (taxCat != null)
			return taxCat.get_ID();
		else return 0;
	}
	
	protected static MDocType getDocType(ChuBoePopulateVO vo, String docBaseType, 
			String docSubTypeSO, boolean issotrx, boolean isshipconfirm, boolean ispickqaconfirm) {
		String issotrxString = issotrx ? "Y" : "N";
		String isshipconfirmString = isshipconfirm ? "Y":"N";
		String ispickqaconfirmString = ispickqaconfirm ? "Y":"N";
		String where = "(docbasetype = '" + docBaseType + "' and docsubtypeso = '" + docSubTypeSO + 
						"' and issotrx = '"+issotrxString+"' and isshipconfirm = '"+isshipconfirmString+"' and ispickqaconfirm = '"+ispickqaconfirmString+"') " +
				" or (docbasetype = '" + docBaseType + "' and docsubtypeso is null " +
						" and issotrx = '"+issotrxString+"' and isshipconfirm = '"+isshipconfirmString+"' and ispickqaconfirm = '"+ispickqaconfirmString+"') ";
		return new Query(vo.getCtx(), X_C_DocType.Table_Name, where, vo.get_trxName()).setClient_ID().first();
	}

	public static MBankAccount getBankAccountOfOrg(ChuBoePopulateVO vo) {
		vo.validate();
		if (vo.isError())
			return null;

		String where = "ad_org_id = " + vo.getOrg().get_ID();
		return new Query(vo.getCtx(), X_C_BankAccount.Table_Name, where, vo.get_trxName())
					.setOnlyActiveRecords(true)
					.setOrderBy("name")
					.setClient_ID()
					.first();
	}
	
	public static void changeOrg(ChuBoePopulateVO vo) {
		//do not validate this method. It is used to update the VO so that it can pass validation
		//vo.validate();
		//if (vo.isError())
		//	return;

		String where = "ad_org_id <> " + vo.getOrg().get_ID() 
				+ " and issummary = 'N'";
		MOrg org = new Query(vo.getCtx(), X_AD_Org.Table_Name, where, vo.get_trxName())
		.setOnlyActiveRecords(true)
		.setOrderBy("AD_Org_ID")
		.setClient_ID()
		.first();
		
		if (org == null) {
			createOrg(vo);
		}
		else {
			vo.setOrg(org);
			changeWarehouse(vo);
		}
	}
	
	public static void createOrg(ChuBoePopulateVO vo) {
		//do not validate this method. It is used to update the VO so that it can pass validation
		//vo.validate();
		//if (vo.isError())
		//	return;

		MOrg org = new MOrg(vo.getCtx(), 0, vo.get_trxName());
		org.setName(vo.getStepMsg());
		org.setDescription(vo.getStepMsgLong());
		org.saveEx();
		vo.setOrg(org);
		
		//find orgInfo record and set location
		MLocation loc = new MLocation(vo.getCtx(), vo.getCountry().get_ID(), vo.getRegion().get_ID(), vo.getCity(), vo.get_trxName());
		loc.saveEx();
		MOrgInfo oInfo = org.getInfo();
		oInfo.setC_Location_ID(loc.get_ID());
		oInfo.saveEx();
		
		// create a new warehouse
		createWarehouse(vo);
		oInfo.setM_Warehouse_ID(vo.getWarehouse().get_ID());
		oInfo.saveEx();

	}
	
	public static void changeWarehouse(ChuBoePopulateVO vo) {
		//do not validate this method. It is used to update the VO so that it can pass validation
		//vo.validate();
		//if (vo.isError())
		//	return;

		String where = (vo.getWarehouse() == null ? "" : " m_warehouse_id <> " + vo.getWarehouse().get_ID() + " and ")
				+ " ad_org_id = " + vo.getOrg().get_ID()
				+ " and IsInTransit = 'N' ";
		MWarehouse wh = new Query(vo.getCtx(), X_M_Warehouse.Table_Name, where, vo.get_trxName())
		.setOnlyActiveRecords(true)
		.setOrderBy("M_Warehouse_ID")
		.setClient_ID()
		.first();
		
		if (wh == null) {
			createWarehouse(vo);
		}
		else {
			vo.setWarehouse(wh);
		}
	}
	
	public static void createWarehouse(ChuBoePopulateVO vo) {
		//do not validate this method. It is used to update the VO so that it can pass validation
		//vo.validate();
		//if (vo.isError())
		//	return;

		MWarehouse wh = new MWarehouse(vo.getCtx(), 0 , vo.get_trxName());
		wh.setAD_Org_ID(vo.getOrg().get_ID());
		wh.setName(vo.getStepMsg());
		wh.setDescription(vo.getStepMsgLong());
		if (vo.getOrg().getInfo() != null)
			wh.setC_Location_ID(vo.getOrg().getInfo().getC_Location_ID());
		wh.saveEx();
		vo.setWarehouse(wh);
		MLocator loc = new MLocator(vo.getWarehouse(), String.valueOf(vo.getRandom()));
		loc.setIsDefault(true);
		loc.saveEx();
	}
	
	public static void createAndOpenAllFiscalYears(ChuBoePopulateVO vo) {
		vo.validate();
		if (vo.isError())
			return;

		//create years for next and past to support broad date ranges
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(vo.getDate());
		int currentYear = cal.get(Calendar.YEAR);
		List<MCalendar> mcals = new Query(vo.getCtx(), X_C_Calendar.Table_Name, null, vo.get_trxName())
		.setOnlyActiveRecords(true)
		.setClient_ID()
		.list();
		for (MCalendar mcal : mcals) {
			String where = " fiscalyear::int in (" + currentYear + "," + (currentYear-1) + ", " + (currentYear+1) + ") and C_Calendar_ID = " + mcal.get_ID();
			List<MYear> myears = new Query(vo.getCtx(), X_C_Year.Table_Name, where, vo.get_trxName())
			.setOnlyActiveRecords(true)
			.setClient_ID()
			.list();
			
			//create a set of all three years
			List<String> neededYears = new ArrayList<String>();
			neededYears.add(String.valueOf(currentYear));
			neededYears.add(String.valueOf(currentYear+1));
			neededYears.add(String.valueOf(currentYear-1));

			//iterate across years and remove present from set
			for (MYear myear : myears) {
				neededYears.remove(myear.getFiscalYear());
			}
			
			//iterate across the set to create the years that remain
			for (String neededYear : neededYears) {
				MYear newYear = new MYear(vo.getCtx(), 0, vo.get_trxName());
				newYear.setC_Calendar_ID(mcal.get_ID());
				newYear.setFiscalYear(neededYear);
				newYear.setAD_Org_ID(0);
				newYear.saveEx();
				newYear.createStdPeriods(vo.getClient().getLocale());
			}
		}
		
		//open all non-open periods for this client
		changePeriodControlStatus(vo, MPeriodControl.PERIODSTATUS_Open);
		
		//remove automatic period control
		List<MAcctSchema> acschs = new Query(vo.getCtx(), X_C_AcctSchema.Table_Name, " AutoPeriodControl = 'Y' ", vo.get_trxName())
			.setOnlyActiveRecords(true)
			.setClient_ID()
			.list();
		for (MAcctSchema acsch : acschs) {
			acsch.setAutoPeriodControl(false);
			acsch.saveEx();
		}
	}
	
	public static void changePeriodControlStatus (ChuBoePopulateVO vo, String newStatus) {
		vo.validate();
		if (vo.isError())
			return;

		String where = " PeriodStatus <> '" + newStatus + "'";
		List<MPeriodControl> pcs = new Query(vo.getCtx(), X_C_PeriodControl.Table_Name, where, vo.get_trxName())
			.setOnlyActiveRecords(true)
			.setClient_ID()
			.list();
		for (MPeriodControl pc : pcs) {
			pc.setPeriodStatus(newStatus);
			pc.saveEx();
		}
	}
	
	public static Timestamp getDateOffset(Timestamp initDate, int days) {
		GregorianCalendar baseCal = new GregorianCalendar();
		baseCal.setTime(initDate);
		baseCal.add(Calendar.DAY_OF_MONTH, days); 
		return (new Timestamp(baseCal.getTimeInMillis()));
	}
	
	//Instructions
	// Step 1: setProcess_UU
	// Step 2: setProcessTable_ID and setProcessRecord_ID if needed
	//		used when running a process against a given record - as opposed to 0,0 from the menu.
	// Step 3: addProcessInfoParam see example below
	public static void runProcess(ChuBoePopulateVO vo) {
		vo.validate();
		if (vo.isError())
			return;

		//further validation
		if (vo.getProcessInfoParams() == null)
			vo.appendErrorMsg("Parameter List is null - It should at least be an empty List");
		else if (vo.getProcess_UU() == null)
			vo.appendErrorMsg("Process UU is null - cannot look up process");
		if (vo.isError())
			return;

		MProcess pr = new Query(Env.getCtx(), X_AD_Process.Table_Name, 
				"AD_Process_UU=?", vo.get_trxName()).setParameters(vo.getProcess_UU()).first();
		
		// Create an instance of the process I want to run
		ProcessCall processCall = null;
		boolean procSuccess = false;

		processCall = Core.getProcess(pr.getClassname());
		
		// Create a process info instance. This is a composite class containing the parameters.
		ProcessInfo pi = new ProcessInfo("", pr.get_ID(), vo.getProcessTable_ID(),vo.getProcessRecord_ID());


		//how to set parameters....
		//ProcessInfoParameter piClient = new ProcessInfoParameter("AD_Client_ID", getAD_Client_ID(), "", "", "");
		//ProcessInfoParameter piOrg = new ProcessInfoParameter("AD_Org_ID", 0, "", "", "");
		//vo.addProcessInfoParam(piClient);
		//...
		List<ProcessInfoParameter> params = vo.getProcessInfoParams();
		if (!params.isEmpty()) {
			pi.setParameter(vo.getProcessInfoParams().toArray(new ProcessInfoParameter[params.size()]));
		}

		// Create process instance (mainly for logging/sync purpose)
		MPInstance mpi = new MPInstance(Env.getCtx(), pr.get_ID(), vo.getProcessRecord_ID());
		mpi.saveEx();
		
		// Connect the process to the process instance.
		pi.setAD_PInstance_ID(mpi.get_ID());
		
		procSuccess = processCall.startProcess(Env.getCtx(), pi, null);
		
		if (!procSuccess)
			vo.appendErrorMsg("Process Failed: " + pr.getClassname());
		
		clearProcess(vo);
	}
	
	public static void clearProcess(ChuBoePopulateVO vo) {
		vo.setProcess_UU(null);
		vo.setProcessInfoParams(new ArrayList<ProcessInfoParameter>());
		vo.setProcessRecord_ID(0);
		vo.setProcessTable_ID(0);
	}
}
