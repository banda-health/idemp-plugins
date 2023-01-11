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

import java.io.File;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MClient_BH;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MBankAccount;
import org.compiere.model.MBankStatement;
import org.compiere.model.MBankStatementLine;
import org.compiere.model.MCountry;
import org.compiere.model.MCurrency;
import org.compiere.model.MDocType;
import org.compiere.model.MInOut;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MOrg;
import org.compiere.model.MPriceList;
import org.compiere.model.MRegion;
import org.compiere.model.Query;
import org.compiere.model.X_C_Order;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.TimeUtil;

public class ChuBoePopulateVO {
	protected CLogger logger = CLogger.getCLogger(getClass());
	private MClient_BH client = null;
	private MOrg organization = null;
	private MUser_BH user = null;
	private MWarehouse_BH warehouse = null;
	private Timestamp date = null;
	private Timestamp dateInitial = null;
	private Timestamp datePriceList = null;
	private String scenarioName = null;
	private String stepName = null;
	private boolean isIncludeRandom = true;
	private MBPartner_BH businessPartner = null;
	private MBPartnerLocation businessPartnerLocation = null;
	private MCountry country = null;
	private MRegion region = null;
	private String city = null;
	private MCurrency currency = null;
	private MUser_BH contact = null;
	private MPriceList salesPriceList = null;
	private MPriceList purchasePriceList = null;
	private MProduct_BH product = null;
	private MCharge_BH charge = null;
	private BigDecimal salesLimitPrice = null;
	private BigDecimal salesStandardPrice = null;
	private BigDecimal salesListPrice = null;
	private BigDecimal purchaseLimitPrice = null;
	private BigDecimal purchaseStandardPrice = null;
	private BigDecimal purchaseListPrice = null;
	private BigDecimal quantity = null;
	private MDocType documentType = null;
	private String documentAction = null;
	private MAttributeSetInstance_BH attributeSetInstance = null;
	private MOrder_BH order = null;
	private MOrderLine_BH orderLine = null;
	private MInOut inOut = null;
	private MInOutLine inOutLine = null;
	private MInvoice_BH invoice = null;
	private MInvoiceLine invoiceLine = null;
	private MInventory_BH inventory = null;
	private MInventoryLine_BH inventoryLine = null;
	private MPayment_BH payment = null;
	private MBankAccount bankAccount = null;
	private MBankStatement bankStatement = null;
	private MBankStatementLine bankStatementLine = null;
	private int randomNumber = 0;
	private Properties context = null;
	private String transactionName = null;
	private boolean isError = false;
	private String errorMessage = null;
	private Random random = null;
	private String separator = " - ";
	private String prompt = ": ";
	private String processUuid = null;
	private List<ProcessInfoParameter> processInformationParameters = new ArrayList<ProcessInfoParameter>();
	private String tenderType = null;
	private BigDecimal paymentAmount = null;
	private int processTableId = 0;
	private int processRecordId = 0;

	private File report;
	private String reportType = "pdf";

	//TODO
	//Create entries for Production, Movement, etc...

	public ChuBoePopulateVO() {

	}

	public String prepareIt(String scenarioName, boolean isIncludeRandom, String transactionName) {
		return prepareIt(scenarioName, isIncludeRandom, Env.getAD_Client_ID(Env.getCtx()), Env.getAD_Org_ID(Env.getCtx()),
				Env.getAD_User_ID(Env.getCtx()), Env.getContextAsInt(Env.getCtx(), Env.M_WAREHOUSE_ID),
				Env.getContextAsDate(Env.getCtx(), "#Date"), Env.getCtx(), transactionName);
	}

	public String prepareIt(String scenarioName, boolean isIncludeRandom, int clientId, int organizationId, int userId,
			int warehouseId, Timestamp date, Properties context, String transactionName) {
		if (transactionName != null && context != null) {
			setContext(context);
			setTransactionName(transactionName);
			client = new MClient_BH(getContext(), clientId, getTransactionName());
			organization = new MOrg(getContext(), organizationId, getTransactionName());
			if (organization.get_ID() == 0) {
				ChuBoeCreateEntity.changeOrganization(this);
			}
			user = new MUser_BH(getContext(), userId, getTransactionName());
			//warehouse could have been set during changeOrg();
			if (warehouse == null) {
				warehouse = new MWarehouse_BH(getContext(), warehouseId, getTransactionName());
			}
			//user could have forgotten to choose a warehouse during login
			if (warehouse == null) {
				ChuBoeCreateEntity.changeWarehouse(this);
			}
			this.date = TimeUtil.trunc(date, TimeUtil.TRUNC_DAY);
			dateInitial = this.date;
			setCurrency(new MCurrency(getContext(), 100, getTransactionName())); //default to USD
			setCountry(new MCountry(getContext(), 100, getTransactionName())); //default to US
			setRegion(new MRegion(getContext(), 132, getTransactionName())); //default to TX
			setCity("Nairobi"); //default to Nairobi
			setIsIncludeRandom(isIncludeRandom);
			if (isIncludeRandom) {
				setRandom();
			}
			setScenarioName(scenarioName);
			setDocumentAction(X_C_Order.DOCACTION_Complete);
			setQuantity(ChuBoeCreateEntity.BD_ONE);
			setPurchasePrice(ChuBoeCreateEntity.BD_ONE);
			setSalesPrice(ChuBoeCreateEntity.BD_ONE);
		}
		return validate();
	}

	public void resetIt() {
		//TODO: implement this
	}


	public MClient_BH getClient() {
		return client;
	}

	public void setClient(MClient_BH client) {
		this.client = client;
	}

	public MOrg getOrg() {
		return organization;
	}

	public void setOrg(MOrg organization) {
		this.organization = organization;
	}

	public MUser_BH getUser() {
		return user;
	}

	public void setUser(MUser_BH user) {
		this.user = user;
	}

	public MWarehouse_BH getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(MWarehouse_BH warehouse) {
		this.warehouse = warehouse;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Timestamp getDateInitial() {
		return dateInitial;
	}

	public void setDateInitial(Timestamp date) {
		this.dateInitial = date;
	}

	public void setDateOffset(int days) {
		setDate(ChuBoeCreateEntity.getDateOffset(getDate(), days));
	}

	public Timestamp getDatePriceList() {
		return datePriceList;
	}

	public void setDatePriceList(Timestamp datePriceList) {
		this.datePriceList = datePriceList;
	}

	public MBPartner_BH getBusinessPartner() {
		return businessPartner;
	}

	public void setBusinessPartner(MBPartner_BH m_bp) {
		this.businessPartner = m_bp;
	}

	public MBPartnerLocation getBusinessPartnerLocation() {
		return businessPartnerLocation;
	}

	public void setBusinessPartnerLocation(MBPartnerLocation businessPartnerLocation) {
		this.businessPartnerLocation = businessPartnerLocation;
	}

	public MProduct_BH getProduct() {
		return product;
	}

	public void setProduct(MProduct_BH product) {
		this.product = product;
	}

	public MAttributeSetInstance_BH getAttributeSetInstance() {
		return attributeSetInstance;
	}

	public void setAttributeSetInstance(MAttributeSetInstance_BH attributeSetInstance) {
		this.attributeSetInstance = attributeSetInstance;
	}

	public MOrder_BH getOrder() {
		return order;
	}

	public void setOrder(MOrder_BH order) {
		this.order = order;
	}

	public MOrderLine_BH getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(MOrderLine_BH orderLine) {
		this.orderLine = orderLine;
	}

	public MInOut getInOut() {
		return inOut;
	}

	public void setInOut(MInOut inOut) {
		this.inOut = inOut;
	}

	public MInOutLine getInOutLine() {
		return inOutLine;
	}

	public void setInOutLine(MInOutLine inOutLine) {
		this.inOutLine = inOutLine;
	}

	public MInvoice_BH getInvoice() {
		return invoice;
	}

	public void setInvoice(MInvoice_BH invoice) {
		this.invoice = invoice;
	}

	public MInvoiceLine getInvoiceLine() {
		return invoiceLine;
	}

	public void setInvoiceLine(MInvoiceLine invoiceLine) {
		this.invoiceLine = invoiceLine;
	}

	public MPayment_BH getPayment() {
		return payment;
	}

	public void setPayment(MPayment_BH payment) {
		this.payment = payment;
	}

	public MBankStatement getBankStatement() {
		return bankStatement;
	}

	public void setBankStatement(MBankStatement bankStatement) {
		this.bankStatement = bankStatement;
	}

	public MBankStatementLine getBankStatementLine() {
		return bankStatementLine;
	}

	public void setBankStatementLine(MBankStatementLine bankStatementLine) {
		this.bankStatementLine = bankStatementLine;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public void setSalesPrice(BigDecimal salesPrice) {
		this.salesLimitPrice = salesPrice;
		this.salesListPrice = salesPrice;
		this.salesStandardPrice = salesPrice;
	}

	public BigDecimal getSalesLimitPrice() {
		return salesLimitPrice;
	}

	public void setSalesLimitPrice(BigDecimal salesLimitPrice) {
		this.salesLimitPrice = salesLimitPrice;
	}

	public BigDecimal getSalesStandardPrice() {
		return salesStandardPrice;
	}

	public void setSalesStandardPrice(BigDecimal salesStandardPrice) {
		this.salesStandardPrice = salesStandardPrice;
	}

	public BigDecimal getSalesListPrice() {
		return salesListPrice;
	}

	public void setSalesListPrice(BigDecimal salesListPrice) {
		this.salesListPrice = salesListPrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchaseLimitPrice = purchasePrice;
		this.purchaseListPrice = purchasePrice;
		this.purchaseStandardPrice = purchasePrice;
	}

	public BigDecimal getPurchaseLimitPrice() {
		return purchaseLimitPrice;
	}

	public void setPurchaseLimitPrice(BigDecimal purchaseLimitPrice) {
		this.purchaseLimitPrice = purchaseLimitPrice;
	}

	public BigDecimal getPurchaseStandardPrice() {
		return purchaseStandardPrice;
	}

	public void setPurchaseStandardPrice(BigDecimal purchaseStandardPrice) {
		this.purchaseStandardPrice = purchaseStandardPrice;
	}

	public BigDecimal getPurchaseListPrice() {
		return purchaseListPrice;
	}

	public void setPurchaseListPrice(BigDecimal purchaseListPrice) {
		this.purchaseListPrice = purchaseListPrice;
	}

	public String getScenarioName() {
		if (isIncludeRandom()) {
			return scenarioName + "_" + getRandomNumber();
		}
		return scenarioName;
	}

	public void setScenarioName(String scenarioName) {
		this.scenarioName = scenarioName;
	}

	public int getRandomNumber() {
		return randomNumber;
	}

	public void setRandom() {
		this.randomNumber = randInt(100, 100000000);
	}

	public int randInt(int min, int max) {
		if (random == null) {
			random = new Random();
		}

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		return random.nextInt((max - min) + 1) + min;
	}

	public Properties getContext() {
		return context;
	}

	public void setContext(Properties context) {
		this.context = context;
	}

	public String getTransactionName() {
		return transactionName;
	}

	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}

	public boolean isError() {
		return isError;
	}

	public void setIsError(boolean isError) {
		this.isError = isError;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		setIsError(true);
	}

	public String getErrorMessageLong() {
		return "ERROR!!!!  Scenario" + getPrompt() + getScenarioName() + getSeparator() + "Step" + getPrompt() +
				getStepName() + getSeparator() + "Error " + getSeparator() + getErrorMessage();
	}

	public void appendErrorMessage(String errorMessage) {
		if (getErrorMessage() != null) {
			this.errorMessage = this.errorMessage + " + " + errorMessage;
		} else {
			this.errorMessage = errorMessage;
		}
		setIsError(true);
	}

	public String validate() {
		if (context == null) {
			appendErrorMessage("No Context");
		}
		if (transactionName == null) {
			appendErrorMessage("No Transaction Name");
		}
		if (client == null) {
			appendErrorMessage("No Client");
		}
		if (organization == null) {
			appendErrorMessage("No Org");
		}
		if (user == null) {
			appendErrorMessage("NO User");
		}
		if (warehouse == null) {
			appendErrorMessage("No Warehouse");
		}
		if (date == null) {
			appendErrorMessage("No Date");
		}
		if (currency == null) {
			appendErrorMessage("No Currency");
		}
		if (region == null) {
			appendErrorMessage("No Region");
		}
		if (city == null) {
			appendErrorMessage("No City");
		}
		if (organization == null || organization.get_ID() == 0)
			appendErrorMessage("Cannot Use null or * Org");
		if (stepName == null)
			setStepName("No Step Name Provided");
		return getErrorMessage();
	}

	public boolean isIncludeRandom() {
		return isIncludeRandom;
	}

	public void setIsIncludeRandom(boolean isIncludeRandom) {
		this.isIncludeRandom = isIncludeRandom;
	}

	public MUser_BH getContact() {
		return contact;
	}

	public void setContact(MUser_BH contact) {
		this.contact = contact;
	}

	public MCurrency getCurrency() {
		return currency;
	}

	public void setCurrency(MCurrency m_currency) {
		this.currency = m_currency;
	}

	public MCountry getCountry() {
		return country;
	}

	public void setCountry(MCountry m_country) {
		this.country = m_country;
	}

	public MRegion getRegion() {
		return region;
	}

	public void setRegion(MRegion m_region) {
		this.region = m_region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String m_city) {
		this.city = m_city;
	}

	public MDocType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(MDocType m_dodocumentTypeType) {
		this.documentType = m_dodocumentTypeType;
	}

	public void setDocBaseType(String documentBaseType, String salesDocumentBaseType, boolean isSalesTransaction,
			boolean isShipmentConfirm, boolean isPickQAConfirm) {
		setDocumentType(
				ChuBoeCreateEntity.getDocumentType(this, documentBaseType, salesDocumentBaseType, isSalesTransaction,
						isShipmentConfirm, isPickQAConfirm));
	}

	public String getDocumentAction() {
		return documentAction;
	}

	public void setDocumentAction(String documentAction) {
		this.documentAction = documentAction;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public String getStepMessage() {
		if (isIncludeRandom()) {
			return "Scenario" + getPrompt() + getRandomNumber() + getSeparator() + "Step" + getPrompt() + getStepName();
		}
		return "Scenario" + getPrompt() + getScenarioName() + getSeparator() + "Step" + getPrompt() + getStepName();
	}

	public String getStepMessageLong() {
		//please note the below string can be very long
		return "Scenario" + getPrompt() + getScenarioName() + getSeparator() + "Step" + getPrompt() + getStepName();
	}

	//only used when changing BPs
	public MPriceList getSalesPriceList() {
		return salesPriceList;
	}

	//only used when changing BPs
	protected void setSalesPriceList(MPriceList m_priceListSO) {
		this.salesPriceList = m_priceListSO;
	}

	//only used when changing BPs
	public MPriceList getPurchasePriceList() {
		return purchasePriceList;
	}

	//only used when changing BPs
	protected void setPurchasePriceList(MPriceList m_priceListPO) {
		this.purchasePriceList = m_priceListPO;
	}

	//used to clear the current BP
	public void clearBusinessPartner() {
		setBusinessPartner(null);
		setBusinessPartnerLocation(null);
		setContact(null);
		setRandom();
	}

	//used to clear the current BP
	public void clearPriceLists() {
		setPurchasePriceList(null);
		setSalesPriceList(null);
	}

	//used to clear the current product
	public void clearProduct() {
		setProduct(null);
		setRandom();
	}

	//used to clear the current charge
	public void clearCharge() {
		setCharge(null);
		setRandom();
	}

	public MBankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(MBankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public CLogger getLogger() {
		return logger;
	}

	public String getProcessUuid() {
		return processUuid;
	}

	public void setProcessUuid(String m_process_UU) {
		this.processUuid = m_process_UU;
	}

	public List<ProcessInfoParameter> getProcessInformationParameters() {
		return processInformationParameters;
	}

	public void setProcessInformationParameters(List<ProcessInfoParameter> processInformationParameters) {
		this.processInformationParameters = processInformationParameters;
	}

	public void addProcessInformationParameter(ProcessInfoParameter processInformationParameter) {
		getProcessInformationParameters().add(processInformationParameter);
	}

	public int getProcessTableId() {
		return processTableId;
	}

	public void setProcessTableId(int processTableId) {
		this.processTableId = processTableId;
	}

	public int getProcessRecordId() {
		return processRecordId;
	}

	public void setProcessRecordId(int processRecordId) {
		this.processRecordId = processRecordId;
	}

	/**
	 * A method to refresh a few properties on the value object.
	 */
	public void refresh() {
		if (getOrder() != null) {
			order = new Query(getContext(), MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_C_Order_ID + "=?",
					getTransactionName()).setParameters(getOrder().get_ID()).first();
		}
		if (getOrderLine() != null) {
			orderLine = new Query(getContext(), MOrderLine_BH.Table_Name, MOrderLine_BH.COLUMNNAME_C_OrderLine_ID + "=?",
					getTransactionName()).setParameters(getOrderLine().get_ID()).first();
		}
		if (getPayment() != null) {
			payment = new Query(getContext(), MPayment_BH.Table_Name, MPayment_BH.COLUMNNAME_C_Payment_ID + "=?",
					getTransactionName()).setParameters(getPayment().get_ID()).first();
		}
		if (getInvoice() != null) {
			invoice = new Query(getContext(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Invoice_ID + "=?",
					getTransactionName()).setParameters(getInvoice().get_ID()).first();
		}
		if (getBusinessPartner() != null) {
			businessPartner = new Query(getContext(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_ID + "=?",
					getTransactionName()).setParameters(getBusinessPartner().get_ID()).first();
		}
		if (getProduct() != null) {
			product = new Query(getContext(), MProduct_BH.Table_Name, MProduct_BH.COLUMNNAME_M_Product_ID + "=?",
					getTransactionName()).setParameters(getProduct().get_ID()).first();
		}
	}

	public File getReport() {
		return report;
	}

	public void setReport(File report) {
		this.report = report;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public MInventory_BH getInventory() {
		return inventory;
	}

	public void setInventory(MInventory_BH inventory) {
		this.inventory = inventory;
	}

	public MInventoryLine_BH getInventoryLine() {
		return inventoryLine;
	}

	public void setInventoryLine(MInventoryLine_BH inventoryLine) {
		this.inventoryLine = inventoryLine;
	}

	public String getTenderType() {
		return tenderType;
	}

	public void setTenderType(String tenderType) {
		this.tenderType = tenderType;
	}

	public MCharge_BH getCharge() {
		return charge;
	}

	public void setCharge(MCharge_BH charge) {
		this.charge = charge;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
}
