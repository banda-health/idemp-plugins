import { initialLoginData, query } from '../api';
import { RoleName } from '../types/roleName';
import { getDateOffset } from '../utils';
import {
	Ad_Ref_ListGetQuery,
	Bh_VisitGetQuery,
	Bh_VisitSaveMutation,
	C_AcctSchemaGetQuery,
	C_BankAccountGetQuery,
	C_BPartnerGetQuery,
	C_BPartnerSaveWithLocationMutation,
	C_ChargeSaveMutation,
	C_DocTypeGetDocument,
	C_DocTypeGetQuery,
	C_InvoiceGetQuery,
	C_InvoiceSaveWithInvoiceLinesMutation,
	C_LocationGetQuery,
	C_OrderGetQuery,
	C_OrderSaveWithOrderLinesMutation,
	C_PaymentSaveMutation,
	M_AttributeSetInstanceSaveMutation,
	M_InventorySaveWithInventoryLinesMutation,
	M_ProductSaveMutation,
	ProcessInfoParameterInput,
	ReportOutput,
	SignInDocument,
	SignInQuery,
	SignInQueryVariables,
} from '../__generated__/graphql';
import { documentAction } from './documentEngine';

export class ValueObject {
	client?: SignInQuery['SignIn']['AD_Clients'][0];
	organization?: SignInQuery['SignIn']['AD_Clients'][0]['AD_Orgs'][0];
	user?: any; //User;
	warehouse?: NonNullable<SignInQuery['SignIn']['AD_Clients'][0]['AD_Orgs'][0]['M_Warehouses']>[0];
	role?: NonNullable<SignInQuery['SignIn']['AD_Clients'][0]['AD_Orgs'][0]['AD_Roles']>[0];
	language?: string;
	date?: Date;
	dateInitial?: Date;
	datePriceList?: Date;
	scenarioName?: string;
	stepName?: string;
	isIncludeRandom: boolean = true;
	businessPartner?: C_BPartnerGetQuery['C_BPartnerGet']['Results'][0];
	businessPartnerLocation?: C_BPartnerSaveWithLocationMutation['C_BPartner_LocationSave'];
	country?: C_LocationGetQuery['C_LocationGet']['Results'][0]['C_Country'];
	region?: C_LocationGetQuery['C_LocationGet']['Results'][0]['C_Region'];
	city?: string;
	currency?: C_AcctSchemaGetQuery['C_AcctSchemaGet']['Results'][0]['C_Currency'];
	contact?: any; //User;
	// MPriceList priceListSO = null;
	// MPriceList priceListPO = null;
	product?: M_ProductSaveMutation['M_ProductSave'];
	charge?: C_ChargeSaveMutation['C_ChargeSave'];
	salesLimitPrice?: number;
	salesStandardPrice?: number;
	salesListPrice?: number;
	purchaseLimitPrice?: number;
	purchaseStandardPrice?: number;
	purchaseListPrice?: number;
	quantity?: number;
	documentType?: C_DocTypeGetQuery['C_DocTypeGet']['Results'][0];
	documentAction?: string;
	attributeSetInstance?: M_AttributeSetInstanceSaveMutation['M_AttributeSetInstanceSave'];
	visit?: Bh_VisitGetQuery['BH_VisitGet']['Results'][0];
	order?: C_OrderGetQuery['C_OrderGet']['Results'][0];
	orderLine?: C_OrderSaveWithOrderLinesMutation['C_OrderLineSave'];
	// MInOut m_inOut = null;
	// MInOutLine m_inOutLine = null;
	invoice?: C_InvoiceGetQuery['C_InvoiceGet']['Results'][0];
	invoiceLine?: C_InvoiceSaveWithInvoiceLinesMutation['C_InvoiceLineSave'];
	inventory?: M_InventorySaveWithInventoryLinesMutation['M_InventorySave'];
	inventoryLine?: M_InventorySaveWithInventoryLinesMutation['M_InventoryLineSave'];
	payment?: C_PaymentSaveMutation['C_PaymentSave'];
	tenderType?: Ad_Ref_ListGetQuery['AD_Ref_ListGet']['Results'][0];
	paymentAmount?: number;
	bankAccount?: C_BankAccountGetQuery['C_BankAccountGet']['Results'][0];
	// MBankStatement m_bs = null;
	// MBankStatementLine m_bsLine = null;
	random: number = 0;
	errorMessage?: string;
	isError: boolean = false;
	separator = ' - ';
	prompt = ': ';
	get AD_Window_AccessMap():
		| { [windowUuid: string]: NonNullable<NonNullable<SignInQuery['SignIn']['AD_Role']>['AD_Window_AccessList']>[0] }
		| undefined {
		return this.loginInfo?.AD_Role?.AD_Window_AccessList?.reduce((map, windowAccess) => {
			map[windowAccess.AD_Window.UU] = windowAccess;
			return map;
		}, {} as { [windowUuid: string]: NonNullable<NonNullable<SignInQuery['SignIn']['AD_Role']>['AD_Window_AccessList']>[0] });
	}

	processUuid?: string;
	processInformationParameters?: ProcessInfoParameterInput[];
	reportType: ReportOutput = ReportOutput.Pdf;
	report?: Buffer;

	sessionToken?: string;

	constructor(
		private loginInfo: SignInQuery['SignIn'] & {
			AD_Client: SignInQuery['SignIn']['AD_Clients'][0];
			AD_Org_UU?: string | null;
			AD_Role_UU?: string | null;
			M_Warehouse_UU?: string | null;
		},
	) {
		this.prepareIt(loginInfo);
	}

	private prepareIt(
		loginInfo: SignInQuery['SignIn'] & {
			AD_Client: SignInQuery['SignIn']['AD_Clients'][0];
			AD_Org_UU?: string | null;
			AD_Role_UU?: string | null;
			M_Warehouse_UU?: string | null;
		},
	) {
		this.client = loginInfo.AD_Client;
		this.organization = this.client?.AD_Orgs.find((organization) => organization.UU === loginInfo.AD_Org_UU);
		this.role = this.organization?.AD_Roles?.find((role) => role.UU === loginInfo.AD_Role_UU);
		this.warehouse = this.organization?.M_Warehouses?.find((warehouse) => warehouse.UU === loginInfo.M_Warehouse_UU);
		this.sessionToken = loginInfo.Token || undefined;

		this.date = new Date();
		this.dateInitial = new Date();
		if (this.isIncludeRandom) {
			this.setRandom();
		}

		this.documentAction = documentAction.Complete;
		this.quantity = this.quantity || 1;
		this.setPurchasePrice(1);
		this.setSalesPrice(1);
		this.loginInfo = { ...loginInfo, AD_Client: this.client! };
	}

	async login(roleName?: RoleName) {
		roleName ||= RoleName.Admin;

		// Find the role ending with that role name
		const roleToUse = this.client?.AD_Orgs.flatMap((organization) => organization.AD_Roles || []).find((role) =>
			role.Name.endsWith(roleName!),
		);

		const baseLoginData: SignInQueryVariables['Credentials'] = {
			...initialLoginData,
			AD_Client_UU: this.client?.UU,
			AD_Org_UU: this.organization?.UU,
			AD_Role_UU: roleToUse?.UU,
			M_Warehouse_UU: this.warehouse?.UU,
		};
		if (this.language) {
			baseLoginData.AD_Language = this.language;
		}
		const {
			data: { SignIn: loginInfo },
		} = await query(this)({ query: SignInDocument, variables: { Credentials: baseLoginData } });
		this.prepareIt({ ...baseLoginData, ...loginInfo, AD_Client: this.client! });

		return this.validate();
	}

	logout() {
		this.client = undefined;
		this.organization = undefined;
		this.role = undefined;
		this.warehouse = undefined;
		this.sessionToken = undefined;
	}

	resetIt() {
		//TODO: implement this
	}

	setDateOffset(days: number) {
		this.date = getDateOffset(this.date ?? new Date(), days);
	}

	setSalesPrice(price: number) {
		this.salesLimitPrice = price;
		this.salesListPrice = price;
		this.salesStandardPrice = price;
	}

	setPurchasePrice(price: number) {
		this.purchaseLimitPrice = price;
		this.purchaseListPrice = price;
		this.purchaseStandardPrice = price;
	}

	getDynamicScenarioName(): string {
		return `${this.scenarioName}${this.isIncludeRandom ? '_' + this.random : ''}`;
	}

	setRandom() {
		this.random = Math.floor(Math.random() * 99999900) + 100;
	}

	getErrorMsgLong() {
		return `ERROR!!!!  Scenario${this.prompt}${this.getDynamicScenarioName()}${this.separator}Step${this.prompt}${
			this.stepName
		}${this.separator}Error ${this.separator}${this.errorMessage}`;
	}

	setErrorMessage(errorMessage: string) {
		this.errorMessage = errorMessage;
		this.isError = true;
	}

	appendErrorMsg(errorMessage?: string) {
		this.errorMessage = this.errorMessage ? this.errorMessage + ' + ' + errorMessage : errorMessage;
		this.isError = true;
	}

	validate(): void {
		if (this.loginInfo == null) {
			this.appendErrorMsg('No Login Info');
		}
		if (!this.client) {
			this.appendErrorMsg('No Client');
		}
		if (!this.organization) {
			this.appendErrorMsg('No Org');
		}
		// if (m_user == null) {
		// 	this.appendErrorMsg('NO User');
		// }
		if (!this.role) {
			this.appendErrorMsg('No Role');
		}
		if (!this.warehouse) {
			this.appendErrorMsg('No Warehouse');
		}
		if (!this.date) {
			this.appendErrorMsg('No Date');
		}
		if (!this.sessionToken) {
			this.appendErrorMsg('No Session Token');
		}
		// if (m_currency == null) {
		// 	this.appendErrorMsg('No Currency');
		// }
		// if (m_region == null) {
		// 	this.appendErrorMsg('No Region');
		// }
		// if (m_city == null) {
		// 	this.appendErrorMsg('No City');
		// }
		// if (m_org == null || m_org.get_ID() == 0)
		// 	this.appendErrorMsg('Cannot Use null or * Org');
		if (!this.stepName) {
			this.stepName = 'No Step Name Provided';
		}

		if (this.isError) {
			throw new Error(this.errorMessage);
		}
	}

	async setDocumentBaseType(
		documentBaseType: string,
		documentSalesSubType: { sales?: string; inventory?: string } | null,
		isSalesTransaction: boolean,
		isShipmentConfirm: boolean,
		isPickQAConfirm: boolean,
	) {
		this.documentType = (
			await query(this)({
				query: C_DocTypeGetDocument,
				variables: {
					Page: 0,
					Size: 100,
					Filter: JSON.stringify({
						docbasetype: documentBaseType,
						issotrx: isSalesTransaction,
						isshipconfirm: isShipmentConfirm,
						ispickqaconfirm: isPickQAConfirm,
						docsubtypeso: documentSalesSubType?.sales ? documentSalesSubType.sales : { $null: true },
						docsubtypeinv: documentSalesSubType?.inventory ? documentSalesSubType.inventory : { $null: true },
					}),
				},
				context: { valueObject: this },
			})
		).data.C_DocTypeGet.Results[0];
	}

	getDynamicStepMessage() {
		return `Scenario${this.prompt}${this.isIncludeRandom ? this.random : this.getDynamicScenarioName()}${
			this.separator
		}Step${this.prompt}${this.stepName}`;
	}

	getStepMessageLong() {
		//please note the below string can be very long
		return `Scenario${this.prompt}${this.getDynamicScenarioName()}${this.separator}Step${this.prompt}${this.stepName}`;
	}

	/**
	 * Clear the current business partner (and reset the random number)
	 */
	clearBusinessPartner() {
		this.businessPartner = undefined;
		// this.businessPartnerLocation = undefined;
		this.contact = undefined;
		this.setRandom();
	}

	// clearPriceLists() {
	// 	setPriceListPO(null);
	// 	setPriceListSO(null);
	// }

	/**
	 * Clear the current product (and reset the random number)
	 */
	clearProduct() {
		this.product = undefined;
		this.setRandom();
	}

	/**
	 * Clear the current charge (and reset the random number)
	 */
	clearCharge() {
		this.charge = undefined;
		this.setRandom();
	}
}
