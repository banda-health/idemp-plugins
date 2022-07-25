import { authenticationApi, initialLoginData } from '../api';
import {
	Authentication,
	AuthResponse,
	BusinessPartner,
	Client,
	Invoice,
	InvoiceLine,
	Order,
	OrderLine,
	Org,
	Payment,
	Product,
	Role,
	User,
	Warehouse,
} from '../types/org.bandahealth.idempiere.rest';
import { getDateOffset } from '../utils';

export class ValueObject {
	client?: Client;
	organization?: Org;
	user?: User;
	warehouse?: Warehouse;
	role?: Role;
	date?: Date;
	dateInitial?: Date;
	datePriceList?: Date;
	scenarioName?: string;
	stepName?: string;
	isIncludeRandom: boolean = true;
	businessPartner?: BusinessPartner;
	// MBPartnerLocation m_bpLoc = null;
	// MCountry m_country = null;
	// MRegion m_region = null;
	city?: string;
	// MCurrency m_currency = null;
	contact?: User;
	// MPriceList priceListSO = null;
	// MPriceList priceListPO = null;
	product?: Product;
	salesLimitPrice?: number;
	salesStandardPrice?: number;
	salesListPrice?: number;
	purchaseLimitPrice?: number;
	purchaseStandardPrice?: number;
	purchaseListPrice?: number;
	quantity?: number;
	documentType?: string;
	documentAction?: string;
	order?: Order;
	orderLine?: OrderLine;
	// MInOut m_inOut = null;
	// MInOutLine m_inOutLine = null;
	invoice?: Invoice;
	invoiceLine?: InvoiceLine;
	payment?: Payment;
	// private MBankAccount m_bankAcct = null;
	// MBankStatement m_bs = null;
	// MBankStatementLine m_bsLine = null;
	random: number = 0;
	errorMessage?: string;
	isError: boolean = false;
	separator = ' - ';
	prompt = ': ';
	get windowAccess(): AuthResponse['windowAccessLevel'] | undefined {
		return this.loginInfo?.windowAccessLevel;
	}

	// String m_process_UU = null;
	// List<ProcessInfoParameter> m_processInfoParams = new ArrayList<ProcessInfoParameter>();
	// int m_processTable_ID = 0;
	// int m_processRecord_ID = 0;

	sessionToken?: string;
	isSales = true;

	constructor(private loginInfo: AuthResponse & { client: Client }) {
		this.prepareIt(loginInfo);
	}

	private prepareIt(loginInfo: AuthResponse & { client?: Client }) {
		this.client = loginInfo.client;
		this.organization = this.client?.orgs.find((organization) => organization.id === loginInfo.orgId);
		this.role = this.organization?.roles.find((role) => role.uuid === loginInfo.roleUuid);
		this.warehouse = this.organization?.warehouses.find((warehouse) => warehouse.uuid === loginInfo.warehouseUuid);
		this.sessionToken = loginInfo.token;

		this.date = new Date();
		this.dateInitial = new Date();
		if (this.isIncludeRandom) {
			this.setRandom();
		}

		this.documentAction = 'CO';
		this.quantity = 1;
		this.setPurchasePrice(1);
		this.setSalesPrice(1);
		this.loginInfo = { ...loginInfo, client: this.client! };
	}

	async login(roleName?: string) {
		roleName ||= 'Admin';

		// Find the role ending with that role name
		const roleToUse = this.client?.orgs
			.flatMap((organization) => organization.roles)
			.find((role) => role.name.endsWith(roleName!));

		const baseLoginData: Partial<Authentication> = {
			...initialLoginData,
			clientUuid: this.client?.uuid,
			organizationId: this.organization?.id,
			roleUuid: roleToUse?.uuid,
			warehouseUuid: this.warehouse?.uuid,
		};
		const loginInfo = await authenticationApi.login(baseLoginData);
		this.prepareIt({ ...loginInfo, client: this.client });

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

	// public void setDocBaseType(String m_docBaseType, String m_docSubTypeSO,
	// 		boolean issotrx, boolean isshipconfirm, boolean ispickqaconfirm) {
	// 	setDocType(ChuBoeCreateEntity.getDocType(this,m_docBaseType, m_docSubTypeSO,
	// 			issotrx, isshipconfirm, ispickqaconfirm));
	// }

	getDynamicStepMessage() {
		return `Scenario${this.prompt}${this.isIncludeRandom ? this.random : this.getDynamicScenarioName()}${
			this.separator
		}Step${this.prompt}${this.stepName}`;
	}

	getStepMessageLong() {
		//please note the below string can be very long
		return `Scenario${this.prompt}${this.getDynamicScenarioName()}${this.separator}Step${this.prompt}${this.stepName}`;
	}

	//used to clear the current BP
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

	clearProduct() {
		this.product = undefined;
		this.setRandom();
	}
}
