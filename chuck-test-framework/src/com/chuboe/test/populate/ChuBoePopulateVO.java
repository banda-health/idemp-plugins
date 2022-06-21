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
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MBankAccount;
import org.compiere.model.MBankStatement;
import org.compiere.model.MBankStatementLine;
import org.compiere.model.MClient;
import org.compiere.model.MCountry;
import org.compiere.model.MCurrency;
import org.compiere.model.MDocType;
import org.compiere.model.MInOut;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MOrg;
import org.compiere.model.MPayment;
import org.compiere.model.MPriceList;
import org.compiere.model.MProduct;
import org.compiere.model.MRegion;
import org.compiere.model.MUser;
import org.compiere.model.MWarehouse;
import org.compiere.model.X_C_Order;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.TimeUtil;

public class ChuBoePopulateVO {
	private MClient m_client = null;
	private MOrg m_org = null;
	private MUser m_user = null;
	private MWarehouse m_warehouse = null;
	private Timestamp m_date = null;
	private Timestamp m_dateInitial =  null;
	private Timestamp m_datePriceList = null;
	private String m_scenarioName = null;
	private String m_stepName = null;
	private boolean m_isIncludeRandom = true;
	private MBPartner m_bp = null;
	private MBPartnerLocation m_bpLoc = null;
	private MCountry m_country = null;
	private MRegion m_region = null;
	private String m_city = null;
	private MCurrency m_currency = null;
	private MUser m_contact = null;
	private MPriceList m_priceListSO = null;
	private MPriceList m_priceListPO = null;
	private MProduct m_product = null;
	private BigDecimal m_limitPriceSO = null;
	private BigDecimal m_stdPriceSO = null;
	private BigDecimal m_listPriceSO = null;
	private BigDecimal m_limitPricePO = null;
	private BigDecimal m_stdPricePO = null;
	private BigDecimal m_listPricePO = null;
	private BigDecimal m_qty = null;
	private MDocType m_docType = null;
	private String m_docAction = null;
	private MOrder m_order = null;
	private MOrderLine m_orderLine = null;
	private MInOut m_inOut = null;
	private MInOutLine m_inOutLine = null;
	private MInvoice m_invoice = null;
	private MInvoiceLine m_invoiceLine = null;
	private MPayment m_payment = null;
	private MBankAccount m_bankAcct = null;
	private MBankStatement m_bs = null;
	private MBankStatementLine m_bsLine = null;
	private int m_random = 0;
	private Properties m_ctx = null;
	private String m_trxName = null;
	private boolean m_isError = false;
	private String m_errorMsg = null;
	private Random m_rand = null;
	private String m_separator = " - ";
	private String m_prompt = ": ";
	
	private String m_process_UU = null;
	private List<ProcessInfoParameter> m_processInfoParams = new ArrayList<ProcessInfoParameter>();
	private int m_processTable_ID = 0;
	private int m_processRecord_ID = 0;
	
	protected CLogger m_log = CLogger.getCLogger (getClass());
	
	//TODO
	//Create entries for Production, Movement, Physical Inventory, etc...

	public ChuBoePopulateVO() {
	
	}
	
	public String prepareIt(String m_scenarioName, boolean m_isIncludeRandom, String trx) {
		return prepareIt(m_scenarioName, 
				m_isIncludeRandom,
				Env.getContextAsInt(Env.getCtx(), "#AD_Client_ID"), 
				Env.getContextAsInt(Env.getCtx(), "#AD_Org_ID"), 
				Env.getContextAsInt(Env.getCtx(), "#AD_User"), 
				Env.getContextAsInt(Env.getCtx(), "#M_Warehouse_ID"), 
				Env.getContextAsDate(Env.getCtx(), "#Date"), 
				Env.getCtx(), 
				trx);
	}
	
	public String prepareIt(String m_scenarioName, boolean m_isIncludeRandom,
			int client_id, int org_id, 
			int user_id, int warehouse_id, 
			Timestamp date, Properties ctx, String trx) {
		if (trx == null) {
			//validation will set error below
		}
		else if (ctx == null) {
			//validation will set error below
		}
		else {
			setCtx(ctx);
			set_trxName(trx);
			m_client = new MClient(getCtx(), client_id, get_trxName());
			m_org = new MOrg(getCtx(), org_id, get_trxName());
			if (m_org.get_ID() == 0) 
				ChuBoeCreateEntity.changeOrg(this);
			m_user = new MUser(getCtx(), user_id, get_trxName());
			//warehouse could have been set during changeOrg();
			if (m_warehouse == null) 
				m_warehouse = new MWarehouse(getCtx(), warehouse_id, get_trxName());
			//user could have forgotten to choose a warehouse during login
			if (m_warehouse == null) 
				ChuBoeCreateEntity.changeWarehouse(this);
			m_date = TimeUtil.trunc(date, TimeUtil.TRUNC_DAY);
			m_dateInitial = m_date;
			setCurrency(new MCurrency(getCtx(), 100, get_trxName())); //default to USD
			setCountry(new MCountry(getCtx(), 100, get_trxName())); //default to US
			setRegion(new MRegion(getCtx(), 132, get_trxName())); //default to TX
			setCity("Austin"); //default to Austin
			setIsIncludeRandom(m_isIncludeRandom);
			if (m_isIncludeRandom)
				setRandom();
			setScenarioName(m_scenarioName);
			setDocAction(X_C_Order.DOCACTION_Complete);
			setQty(ChuBoeCreateEntity.BD_ONE);
			setPricePO(ChuBoeCreateEntity.BD_ONE);
			setPriceSO(ChuBoeCreateEntity.BD_ONE);
		}
		return validate();
	}
	
	public void resetIt() {
		//TODO: implement this
	}
	
//	public ChuBoePopulateVO(String m_scenarioName, boolean m_isIncludeRandom, String trx) {
//
//		this(m_scenarioName, 
//					m_isIncludeRandom,
//					Env.getContextAsInt(Env.getCtx(), "#AD_Client_ID"), 
//					Env.getContextAsInt(Env.getCtx(), "#AD_Org_ID"), 
//					Env.getContextAsInt(Env.getCtx(), "#AD_User"), 
//					Env.getContextAsInt(Env.getCtx(), "#M_Warehouse_ID"), 
//					Env.getContextAsDate(Env.getCtx(), "#Date"), 
//					Env.getCtx(), 
//					trx);
//	}
//	
//	public ChuBoePopulateVO(String m_scenarioName, boolean m_isIncludeRandom,
//			int client_id, int org_id, 
//			int user_id, int warehouse_id, 
//			Timestamp date, Properties ctx, String trx)
//	{
//		if (trx == null) {
//			//validation will set error below
//		}
//		else if (ctx == null) {
//			//validation will set error below
//		}
//		else {
//			setCtx(ctx);
//			set_trxName(trx);
//			m_client = new MClient(getCtx(), client_id, get_trxName());
//			m_org = new MOrg(getCtx(), org_id, get_trxName());
//			m_user = new MUser(getCtx(), user_id, get_trxName());
//			m_warehouse = new MWarehouse(getCtx(), warehouse_id, get_trxName());
//			m_date = date;
//			setCurrency(new MCurrency(getCtx(), 100, get_trxName())); //default to USD
//			setCountry(new MCountry(getCtx(), 100, get_trxName())); //default to US
//			setRegion(new MRegion(getCtx(), 132, get_trxName())); //default to TX
//			setCity("Austin"); //default to Austin
//			setIsIncludeRandom(m_isIncludeRandom);
//			if (m_isIncludeRandom)
//				setRandom();
//			setScenarioName(m_scenarioName);
//		}
//		
//		validate();
//	}

	public MClient getClient() {
		return m_client;
	}

	public void setClient(MClient m_client) {
		this.m_client = m_client;
	}

	public MOrg getOrg() {
		return m_org;
	}

	public void setOrg(MOrg m_org) {
		this.m_org = m_org;
	}

	public MUser getUser() {
		return m_user;
	}

	public void setUser(MUser m_user) {
		this.m_user = m_user;
	}

	public MWarehouse getWarehouse() {
		return m_warehouse;
	}

	public void setWarehouse(MWarehouse m_warehouse) {
		this.m_warehouse = m_warehouse;
	}

	public Timestamp getDate() {
		return m_date;
	}

	public void setDate(Timestamp m_date) {
		this.m_date = m_date;
	}
	
	public Timestamp getDateInitial() {
		return m_dateInitial;
	}

	public void setDateInitial(Timestamp m_date) {
		this.m_dateInitial = m_date;
	}

	public void setDateOffset(int days) {
		setDate(ChuBoeCreateEntity.getDateOffset(getDate(), days));
	}

	public Timestamp getDatePriceList() {
		return m_datePriceList;
	}

	public void setDatePriceList(Timestamp datePriceList) {
		this.m_datePriceList = datePriceList;
	}

	public MBPartner getBP() {
		return m_bp;
	}

	public void setBP(MBPartner m_bp) {
		this.m_bp = m_bp;
	}

	public MBPartnerLocation getBPLoc() {
		return m_bpLoc;
	}

	public void setBPLoc(MBPartnerLocation m_bpLoc) {
		this.m_bpLoc = m_bpLoc;
	}

	public MProduct getProduct() {
		return m_product;
	}

	public void setProduct(MProduct m_product) {
		this.m_product = m_product;
	}

	public MOrder getOrder() {
		return m_order;
	}

	public void setOrder(MOrder m_po) {
		this.m_order = m_po;
	}

	public MOrderLine getOrderLine() {
		return m_orderLine;
	}

	public void setOrderLine(MOrderLine m_poLine) {
		this.m_orderLine = m_poLine;
	}

	public MInOut getInOut() {
		return m_inOut;
	}

	public void setInOut(MInOut m_mr) {
		this.m_inOut = m_mr;
	}

	public MInOutLine getInOutLine() {
		return m_inOutLine;
	}

	public void setInOutLine(MInOutLine m_mrLine) {
		this.m_inOutLine = m_mrLine;
	}

	public MInvoice getInvoice() {
		return m_invoice;
	}

	public void setInvoice(MInvoice m_vi) {
		this.m_invoice = m_vi;
	}

	public MInvoiceLine getInvoiceLine() {
		return m_invoiceLine;
	}

	public void setInvoiceLine(MInvoiceLine m_viLine) {
		this.m_invoiceLine = m_viLine;
	}

	public MPayment getPayment() {
		return m_payment;
	}

	public void setPayment(MPayment m_payment) {
		this.m_payment = m_payment;
	}

	public MBankStatement getBS() {
		return m_bs;
	}

	public void setBS(MBankStatement m_bs) {
		this.m_bs = m_bs;
	}

	public MBankStatementLine getBSLine() {
		return m_bsLine;
	}

	public void setM_BSLine(MBankStatementLine m_bsLine) {
		this.m_bsLine = m_bsLine;
	}
	public BigDecimal getQty() {
		return m_qty;
	}

	public void setQty(BigDecimal m_qty) {
		this.m_qty = m_qty;
	}

	public void setPriceSO(BigDecimal m_price) {
		this.m_limitPriceSO = m_price;
		this.m_listPriceSO = m_price;
		this.m_stdPriceSO = m_price;
	}

	public BigDecimal getLimitPriceSO() {
		return m_limitPriceSO;
	}

	public void setLimitPriceSO(BigDecimal m_limitPrice) {
		this.m_limitPriceSO = m_limitPrice;
	}

	public BigDecimal getStdPriceSO() {
		return m_stdPriceSO;
	}

	public void setStdPriceSO(BigDecimal m_stdPrice) {
		this.m_stdPriceSO = m_stdPrice;
	}

	public BigDecimal getListPriceSO() {
		return m_listPriceSO;
	}

	public void setListPriceSO(BigDecimal m_listPrice) {
		this.m_listPriceSO = m_listPrice;
	}

	public void setPricePO(BigDecimal m_price) {
		this.m_limitPricePO = m_price;
		this.m_listPricePO = m_price;
		this.m_stdPricePO = m_price;
	}

	public BigDecimal getLimitPricePO() {
		return m_limitPricePO;
	}

	public void setLimitPricePO(BigDecimal m_limitPrice) {
		this.m_limitPricePO = m_limitPrice;
	}

	public BigDecimal getStdPricePO() {
		return m_stdPricePO;
	}

	public void setStdPricePO(BigDecimal m_stdPrice) {
		this.m_stdPricePO = m_stdPrice;
	}

	public BigDecimal getListPricePO() {
		return m_listPricePO;
	}

	public void setListPricePO(BigDecimal m_listPrice) {
		this.m_listPricePO = m_listPrice;
	}

	public String getScenarioName() {
		if (isIncludeRandom())
		{
			return m_scenarioName + "_" + getRandom();
		}
		else return m_scenarioName;
	}

	public void setScenarioName(String m_scenarioName) {
		this.m_scenarioName = m_scenarioName;
	}
	
	public int getRandom() {
		return m_random;
	}

	public void setRandom() {
		this.m_random = randInt(100, 100000000);
	}

	
	public int randInt(int min, int max) {

	    if (m_rand == null)
	    	m_rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = m_rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}

	public Properties getCtx() {
		return m_ctx;
	}

	public void setCtx(Properties m_ctx) {
		this.m_ctx = m_ctx;
	}

	public String get_trxName() {
		return m_trxName;
	}

	public void set_trxName(String m_trxName) {
		this.m_trxName = m_trxName;
	}

	public boolean isError() {
		return m_isError;
	}

	public void setIsError(boolean m_isError) {
		this.m_isError = m_isError;
	}

	public String getErrorMsg() {
		return m_errorMsg;
	}

	public String getErrorMsgLong() {
		return "ERROR!!!!  Scenario" + getPrompt() + getScenarioName() + getSeparator()+ "Step" + getPrompt() + getStepName() + getSeparator() + "Error " + getSeparator() + getErrorMsg();
	}

	public void setErrorMsg(String m_errorMsg) {
		this.m_errorMsg = m_errorMsg;
		setIsError(true);
	}
	
	public void appendErrorMsg(String m_errorMsg) {
		if (getErrorMsg() != null)
			this.m_errorMsg = this.m_errorMsg + " + " + m_errorMsg;
		else this.m_errorMsg = m_errorMsg;
		setIsError(true);
	}


	public String validate() {
		if (m_ctx == null){
			appendErrorMsg("No Context");
		}
		if (m_trxName == null){
			appendErrorMsg("No Transaction Name");
		}
		if (m_client == null){
			appendErrorMsg("No Client");
		}
		if (m_org == null){
			appendErrorMsg("No Org");
		}
		if (m_user == null){
			appendErrorMsg("NO User");
		}
		if (m_warehouse == null){
			appendErrorMsg("No Warehouse");
		}
		if (m_date == null){
			appendErrorMsg("No Date");
		}
		if (m_currency == null){
			appendErrorMsg("No Currency");
		}
		if (m_region == null){
			appendErrorMsg("No Region");
		}
		if (m_city == null){
			appendErrorMsg("No City");
		}
		if (m_org == null || m_org.get_ID() == 0)
			appendErrorMsg("Cannot Use null or * Org");
		if (m_stepName == null)
			setStepName("No Step Name Provided");
		return getErrorMsg();
	}

	public boolean isIncludeRandom() {
		return m_isIncludeRandom;
	}

	public void setIsIncludeRandom(boolean m_isIncludeRandom) {
		this.m_isIncludeRandom = m_isIncludeRandom;
	}

	public MUser getContact() {
		return m_contact;
	}

	public void setContact(MUser m_contact) {
		this.m_contact = m_contact;
	}

	public MCurrency getCurrency() {
		return m_currency;
	}

	public void setCurrency(MCurrency m_currency) {
		this.m_currency = m_currency;
	}

	public MCountry getCountry() {
		return m_country;
	}

	public void setCountry(MCountry m_country) {
		this.m_country = m_country;
	}

	public MRegion getRegion() {
		return m_region;
	}

	public void setRegion(MRegion m_region) {
		this.m_region = m_region;
	}

	public String getCity() {
		return m_city;
	}

	public void setCity(String m_city) {
		this.m_city = m_city;
	}

	public MDocType getDocType() {
		return m_docType;
	}

	public void setDocType(MDocType m_docType) {
		this.m_docType = m_docType;
	}
	
	public void setDocBaseType(String m_docBaseType, String m_docSubTypeSO, 
			boolean issotrx, boolean isshipconfirm, boolean ispickqaconfirm) {
		setDocType(ChuBoeCreateEntity.getDocType(this,m_docBaseType, m_docSubTypeSO, 
				issotrx, isshipconfirm, ispickqaconfirm));
	}

	public String getDocAction() {
		return m_docAction;
	}

	public void setDocAction(String m_docAction) {
		this.m_docAction = m_docAction;
	}

	public String getSeparator() {
		return m_separator;
	}

	public void setSeparator(String m_separator) {
		this.m_separator = m_separator;
	}

	public String getPrompt() {
		return m_prompt;
	}

	public void setPrompt(String m_prompt) {
		this.m_prompt = m_prompt;
	}

	public String getStepName() {
		return m_stepName;
	}

	public String getStepMsg() {
		if (isIncludeRandom())
		{
			return "Scenario" + getPrompt() + getRandom() + getSeparator() + "Step" + getPrompt() + getStepName();
		}
		return "Scenario" + getPrompt() + getScenarioName() + getSeparator() + "Step" + getPrompt() + getStepName();
	}
	
	public String getStepMsgLong() {
		//please note the below string can be very long
		return "Scenario" + getPrompt() + getScenarioName() + getSeparator() + "Step" + getPrompt() + getStepName();
	}
	
	public void setStepName(String m_stepName) {
		this.m_stepName = m_stepName;
	}

	//only used when changing BPs
	public MPriceList getPriceListSO() {
		return m_priceListSO;
	}

	//only used when changing BPs
	protected void setPriceListSO(MPriceList m_priceListSO) {
		this.m_priceListSO = m_priceListSO;
	}

	//only used when changing BPs
	public MPriceList getPriceListPO() {
		return m_priceListPO;
	}

	//only used when changing BPs
	protected void setPriceListPO(MPriceList m_priceListPO) {
		this.m_priceListPO = m_priceListPO;
	}
	
	//used to clear the current BP
	public void clearBP() {
		setBP(null);
		setBPLoc(null);
		setContact(null);
		setRandom(); 
	}

	//used to clear the current BP
	public void clearPriceLists() {
		setPriceListPO(null);
		setPriceListSO(null);
	}

	//used to clear the current BP
	public void clearProduct() {
		setProduct(null);
		setRandom();
	}
	
	public MBankAccount getBankAcct() {
		return m_bankAcct;
	}

	public void setBankAcct(MBankAccount m_bankAcct) {
		this.m_bankAcct = m_bankAcct;
	}

	public CLogger getLog() {
		return m_log;
	}

	public String getProcess_UU() {
		return m_process_UU;
	}

	public void setProcess_UU(String m_process_UU) {
		this.m_process_UU = m_process_UU;
	}

	public List<ProcessInfoParameter> getProcessInfoParams() {
		return m_processInfoParams;
	}

	public void setProcessInfoParams(
			List<ProcessInfoParameter> m_processInfoParams) {
		this.m_processInfoParams = m_processInfoParams;
	}
	
	public void addProcessInfoParam (ProcessInfoParameter procInfoParam) {
		getProcessInfoParams().add(procInfoParam);
	}

	public int getProcessTable_ID() {
		return m_processTable_ID;
	}

	public void setProcessTable_ID(int m_processTable_ID) {
		this.m_processTable_ID = m_processTable_ID;
	}

	public int getProcessRecord_ID() {
		return m_processRecord_ID;
	}

	public void setProcessRecord_ID(int m_processRecord_ID) {
		this.m_processRecord_ID = m_processRecord_ID;
	}


}
