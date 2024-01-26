import { initialLoginData, query } from '../api';
import { RoleName } from '../types/roleName';
import { getDateOffset } from '../utils';
import {
	Ad_Ref_ListGetQuery,
	Bh_VisitSaveMutation,
	C_AcctSchemaGetQuery,
	C_BankAccountGetQuery,
	C_BPartnerSaveWithLocationMutation,
	C_ChargeSaveMutation,
	C_DocTypeGetDocument,
	C_DocTypeGetQuery,
	C_InvoiceSaveWithInvoiceLinesMutation,
	C_LocationGetQuery,
	C_OrderSaveWithOrderLinesMutation,
	C_PaymentSaveMutation,
	M_ProductSaveMutation,
	ProcessInfoParameterInput,
	ReportOutput,
	SignInDocument,
	SignInQuery,
	SignInQueryVariables,
} from '../__generated__/graphql';
import { documentAction } from './documentEngine';

export class ValueObject {
	client?: SignInQuery['signIn']['AD_Clients'][0];
	organization?: SignInQuery['signIn']['AD_Clients'][0]['AD_Orgs'][0];
	user?: any; //User;
	warehouse?: NonNullable<SignInQuery['signIn']['AD_Clients'][0]['AD_Orgs'][0]['M_Warehouses']>[0];
	role?: NonNullable<SignInQuery['signIn']['AD_Clients'][0]['AD_Orgs'][0]['AD_Roles']>[0];
	language?: string;
	date?: Date;
	dateInitial?: Date;
	datePriceList?: Date;
	scenarioName?: string;
	stepName?: string;
	isIncludeRandom: boolean = true;
	businessPartner?: C_BPartnerSaveWithLocationMutation['C_BPartnerSave'];
	businessPartnerLocation?: C_BPartnerSaveWithLocationMutation['C_BPartner_LocationSave'];
	country?: C_LocationGetQuery['C_LocationGet']['results'][0]['C_Country'];
	region?: C_LocationGetQuery['C_LocationGet']['results'][0]['C_Region'];
	city?: string;
	currency?: C_AcctSchemaGetQuery['C_AcctSchemaGet']['results'][0]['C_Currency'];
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
	documentType?: C_DocTypeGetQuery['C_DocTypeGet']['results'][0];
	documentAction?: string;
	attributeSetInstance?: any; //AttributeSetInstance;
	visit?: Bh_VisitSaveMutation['BH_VisitSave'];
	order?: C_OrderSaveWithOrderLinesMutation['C_OrderSave'];
	orderLine?: C_OrderSaveWithOrderLinesMutation['C_OrderLineSave'];
	// MInOut m_inOut = null;
	// MInOutLine m_inOutLine = null;
	invoice?: C_InvoiceSaveWithInvoiceLinesMutation['C_InvoiceSave'];
	invoiceLine?: C_InvoiceSaveWithInvoiceLinesMutation['C_InvoiceLineSave'];
	inventory?: any; //Inventory;
	inventoryLine?: any; //InventoryLine;
	payment?: C_PaymentSaveMutation['C_PaymentSave'];
	tenderType?: Ad_Ref_ListGetQuery['AD_Ref_ListGet']['results'][0];
	paymentAmount?: number;
	bankAccount?: C_BankAccountGetQuery['C_BankAccountGet']['results'][0];
	// MBankStatement m_bs = null;
	// MBankStatementLine m_bsLine = null;
	random: number = 0;
	errorMessage?: string;
	isError: boolean = false;
	separator = ' - ';
	prompt = ': ';
	// get windowAccess(): AuthResponse['windowAccessLevel'] | undefined {
	// 	return this.loginInfo?.windowAccessLevel;
	// }

	processUuid?: string;
	processInformationParameters?: ProcessInfoParameterInput[];
	reportType: ReportOutput = ReportOutput.Pdf;
	report?: Buffer;

	sessionToken?: string;

	constructor(
		private loginInfo: SignInQuery['signIn'] & {
			AD_Client: SignInQuery['signIn']['AD_Clients'][0];
			organizationId?: string | null;
			roleId?: string | null;
			warehouseId?: string | null;
		},
	) {
		this.prepareIt(loginInfo);
	}

	private prepareIt(
		loginInfo: SignInQuery['signIn'] & {
			AD_Client: SignInQuery['signIn']['AD_Clients'][0];
			organizationUuid?: string | null;
			roleUuid?: string | null;
			warehouseUuid?: string | null;
		},
	) {
		this.client = loginInfo.AD_Client;
		this.organization = this.client?.AD_Orgs.find((organization) => organization.UUID === loginInfo.organizationUuid);
		this.role = this.organization?.AD_Roles?.find((role) => role.UUID === loginInfo.roleUuid);
		this.warehouse = this.organization?.M_Warehouses?.find((warehouse) => warehouse.UUID === loginInfo.warehouseUuid);
		this.sessionToken = loginInfo.token || undefined;

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

		const baseLoginData: SignInQueryVariables['credentials'] = {
			...initialLoginData,
			clientUuid: this.client?.UUID,
			organizationUuid: this.organization?.UUID,
			roleUuid: roleToUse?.UUID,
			warehouseUuid: this.warehouse?.UUID,
		};
		if (this.language) {
			baseLoginData.language = this.language;
		}
		const {
			data: { signIn: loginInfo },
		} = await query(this)({ query: SignInDocument, variables: { credentials: baseLoginData } });
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
		documentSalesSubType: string | null,
		isSalesTransaction: boolean,
		isShipmentConfirm: boolean,
		isPickQAConfirm: boolean,
	) {
		this.documentType = (
			await query(this)({
				query: C_DocTypeGetDocument,
				variables: {
					page: 0,
					size: 100,
					filter: JSON.stringify({
						docbasetype: documentBaseType,
						issotrx: isSalesTransaction,
						isshipconfirm: isShipmentConfirm,
						ispickqaconfirm: isPickQAConfirm,
						docsubtypeso: documentSalesSubType ? documentSalesSubType : { $null: true },
					}),
				},
				context: { valueObject: this },
			})
		).data.C_DocTypeGet.results[0];
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
