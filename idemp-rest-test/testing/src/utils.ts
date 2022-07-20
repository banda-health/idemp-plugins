import ValueObject from './models/ValueObject';
import {
	Authentication,
	AuthResponse,
	BaseListResponse,
	BusinessPartner,
	Invoice,
	InvoiceLine,
	Order,
	OrderLine,
	Patient,
	Payment,
	Product,
	ProductCategory,
	Warehouse,
} from './types/org.bandahealth.idempiere.rest';

export const IDEMPIERE_ENDPOINT = `${
	process.env.IDEMPIERE_ENDPOINT || 'http://idempiere:8080'
}/BHGO/services/rs/auth`;

export const initialLoginData: Partial<Authentication> = {
	username: process.env.IDEMPIERE_USER || 'SuperUser',
	password: process.env.IDEMPIERE_USER_PASSWORD || 'System',
	language: 'en_US',
} as const;

/**
 * Get the data to send as part of a request, including headers & a method type of `POST`
 * @param loginData What data should be sent in order to log in
 * @returns The request information to send in a fetch request
 */
export function getRequestOptions(
	loginData?: Partial<Authentication>
): RequestInit {
	const myHeaders = new Headers();
	myHeaders.append('Content-Type', 'application/json');
	return {
		method: 'POST',
		headers: myHeaders,
		body: JSON.stringify(loginData ?? initialLoginData),
	};
}

/**
 * Login with a new set of data
 * @param loginData What data should be sent in order to log in
 * @returns The login response
 */
export async function login(
	loginData?: Partial<Authentication>
): Promise<AuthResponse> {
	const loginResponse = await fetch(
		`${IDEMPIERE_ENDPOINT}/session`,
		getRequestOptions(loginData)
	);
	const loginInfo = await (loginResponse.json() as Promise<AuthResponse>);
	if (!loginResponse.ok || loginInfo.status !== 'OK') {
		throw new Error('could not login');
	}

	return loginInfo;
}

/**
 * Get the default headers plus an authorization header (needed for almost all requests)
 * @param valueObject The value object containing the session token
 * @returns Headers to add to a fetch request
 */
function getAuthorizationHeaders(valueObject: ValueObject) {
	const headers = new Headers();
	headers.append('Content-Type', 'application/json');
	headers.append('Authorization', `Bearer ${valueObject.sessionToken}`);
	return headers;
}

/**
 * Create a business partner (don't really have an ideal method for this at the moment - have to go through patients).
 * If a business partner already exists on the value object, this won't do anything.
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function createBusinessPartner(valueObject: ValueObject) {
	valueObject.validate();
	if (valueObject.isError) {
		return;
	}

	if (!valueObject.businessPartner) {
		const businessPartner: Partial<BusinessPartner> = {
			orgId: 0,
			name: valueObject.getDynamicStepMessage(),
			description: valueObject.getStepMessageLong(),
		};
		const headers = getAuthorizationHeaders(valueObject);
		const createBusinessPartnerResponse = await fetch(
			`${IDEMPIERE_ENDPOINT}/patient/save`,
			{
				method: 'POST',
				headers,
				body: JSON.stringify(businessPartner),
			}
		);
		const createdBusinessPartner =
			await (createBusinessPartnerResponse.json() as Promise<BusinessPartner>);
		if (!createBusinessPartnerResponse.ok) {
			throw new Error('could not create business partner');
		}

		valueObject.businessPartner = createdBusinessPartner;
	}
}

/**
 * Create a product (don't really have an ideal method for this at the moment - have to go through items).
 * If a product already exists on the value object, this won't do anything.
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function createProduct(valueObject: ValueObject) {
	valueObject.validate();
	if (valueObject.isError) return;

	if (!valueObject.product) {
		const product: Partial<Product> = {
			orgId: 0,
			description: valueObject.getStepMessageLong(),
			name: valueObject.getDynamicScenarioName(),
			productCategoryUuid: '',
			totalQuantity: 100,
			buyPrice: 10,
			sellPrice: 100,
		};
		const headers = getAuthorizationHeaders(valueObject);
		const createProductResponse = await fetch(
			`${IDEMPIERE_ENDPOINT}/products/save`,
			{
				method: 'POST',
				headers,
				body: JSON.stringify(product),
			}
		);
		const createdProduct =
			await (createProductResponse.json() as Promise<Product>);
		if (!createProductResponse.ok) {
			throw new Error('could not create product');
		}
		valueObject.product = createdProduct;
	}
}

/**
 * Create an order (don't really have an ideal method for this at the moment - have to go through visits).
 * This requires a document type, a business partner, and a warehouse be selected on the value object.
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function createOrder(valueObject: ValueObject) {
	valueObject.validate();
	if (valueObject.isError) return;

	//perform further validation if needed based on business logic
	if (!valueObject.documentType) {
		valueObject.appendErrorMsg('Document Type is Null');
		return;
	} else if (!valueObject.businessPartner) {
		valueObject.appendErrorMsg('Business Partner is Null');
		return;
	} else if (!valueObject.warehouse) {
		valueObject.appendErrorMsg('Warehouse is Null');
		return;
	}

	const order: Partial<Order> = {
		orgId: 0,
		description: valueObject.getStepMessageLong(),
		dateOrdered: valueObject.date?.toISOString(),
		businessPartner: valueObject.businessPartner,
		warehouse: valueObject.warehouse,
		orderLines: [],
	};
	const line: Partial<OrderLine> = {
		orgId: 0,
		description: valueObject.getStepMessageLong(),
		product: valueObject.product,
		quantity: valueObject.quantity || 1,
	};
	line.price = (line.quantity || 0) * (line.product?.sellPrice || 0);
	order.orderLines?.push(line as unknown as OrderLine);
	const headers = getAuthorizationHeaders(valueObject);
	const createOrderResponse = await fetch(`${IDEMPIERE_ENDPOINT}/visits`, {
		method: 'POST',
		headers,
		body: JSON.stringify(order),
	});
	const createdOrder = await (createOrderResponse.json() as Promise<Order>);
	if (!createOrderResponse.ok) {
		throw new Error('could not create order');
	}

	valueObject.order = createdOrder;
	valueObject.orderLine = createdOrder.orderLines[0];

	if (valueObject.documentAction) {
		const processOrderResponse = await fetch(
			`${IDEMPIERE_ENDPOINT}/visits/process/${valueObject.documentAction}`,
			{
				method: 'POST',
				headers,
				body: JSON.stringify(valueObject.order),
			}
		);
		const processedOrder =
			await (processOrderResponse.json() as Promise<Order>);
		if (!processOrderResponse.ok) {
			throw new Error('could not process order');
		}
		valueObject.order = processedOrder;
	}
}

/**
 * Create an invoice. This requires a document type, a business partner, and a completed order be selected on the value object.
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function createInvoice(valueObject: ValueObject) {
	valueObject.validate();
	if (valueObject.isError) return;

	if (!valueObject.documentType) {
		valueObject.appendErrorMsg('Document Type is Null');
		return;
	} else if (!valueObject.businessPartner) {
		valueObject.appendErrorMsg('Business Partner is Null');
		return;
	} else if (valueObject.order?.docStatus !== 'CO') {
		valueObject.appendErrorMsg('Order Not Completed');
		return;
	}

	const invoice: Partial<Invoice> = {
		orgId: 0,
		description: valueObject.getStepMessageLong(),
		businessPartner: valueObject.businessPartner,
		dateInvoiced: valueObject.date?.toISOString(),
		invoiceLines: [],
	};
	const invoiceLine: Partial<InvoiceLine> = {
		description: valueObject.getStepMessageLong(),
		product: valueObject.product,
		quantity: valueObject.quantity || 1,
	};
	invoiceLine.price =
		(invoiceLine.quantity || 0) * (invoiceLine.product?.sellPrice || 0);
	invoice.invoiceLines?.push(invoiceLine as unknown as InvoiceLine);
	const headers = getAuthorizationHeaders(valueObject);
	const createInvoiceResponse = await fetch(`${IDEMPIERE_ENDPOINT}/invoices`, {
		method: 'POST',
		headers,
		body: JSON.stringify(invoice),
	});
	const createdInvoice =
		await (createInvoiceResponse.json() as Promise<Invoice>);
	if (!createInvoiceResponse.ok) {
		throw new Error('could not create invoice');
	}
	valueObject.invoice = createdInvoice;
	valueObject.invoiceLine = createdInvoice.invoiceLines[0];

	if (valueObject.documentAction) {
		const processInvoiceResponse = await fetch(
			`${IDEMPIERE_ENDPOINT}/invoices/process/${valueObject.documentAction}`,
			{
				method: 'POST',
				headers,
				body: JSON.stringify(valueObject.invoice),
			}
		);
		const processedInvoice =
			await (processInvoiceResponse.json() as Promise<Invoice>);
		if (!processInvoiceResponse.ok) {
			throw new Error('could not process invoice');
		}
		valueObject.invoice = processedInvoice;
	}
}

/**
 * Create a payment. This requires a document type and a business partner be selected on the value object.
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function createPayment(valueObject: ValueObject) {
	valueObject.validate();
	if (valueObject.isError) {
		return;
	}

	if (!valueObject.documentType) {
		valueObject.appendErrorMsg('Document Type is Null');
		return;
	} else if (!valueObject.businessPartner) {
		valueObject.appendErrorMsg('Business Partner is Null');
		return;
	}

	const payment: Partial<Payment> = {
		orgId: 0,
		patient: valueObject.businessPartner as unknown as Patient,
		description: valueObject.getStepMessageLong(),
		payAmount: valueObject.invoice?.grandTotal || 1,
	};
	const headers = getAuthorizationHeaders(valueObject);
	const createPaymentResponse = await fetch(`${IDEMPIERE_ENDPOINT}/payments`, {
		method: 'POST',
		headers,
		body: JSON.stringify(payment),
	});
	const createdPayment =
		await (createPaymentResponse.json() as Promise<Payment>);
	if (!createPaymentResponse.ok) {
		throw new Error('could not create payment');
	}
	valueObject.payment = createdPayment;

	if (valueObject.documentAction) {
		const processPaymentResponse = await fetch(
			`${IDEMPIERE_ENDPOINT}/payments/process/${valueObject.documentAction}`,
			{
				method: 'POST',
				headers,
				body: JSON.stringify(valueObject.payment),
			}
		);
		const processedPayment =
			await (processPaymentResponse.json() as Promise<Payment>);
		if (!processPaymentResponse.ok) {
			throw new Error('could not process invoice');
		}
		valueObject.payment = processedPayment;
	}
}

/**
 * This gets the default product category to assign to items (not services).
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function getDefaultProductCategory(
	valueObject: ValueObject
): Promise<ProductCategory | undefined> {
	valueObject.validate();
	if (valueObject.isError) return;

	const headers = getAuthorizationHeaders(valueObject);
	const createInvoiceResponse = await fetch(
		`${IDEMPIERE_ENDPOINT}/productcategories`,
		{
			method: 'POST',
			headers,
		}
	);
	const productCategories = await (createInvoiceResponse.json() as Promise<
		ProductCategory[]
	>);
	if (!createInvoiceResponse.ok) {
		throw new Error('could not fetch product categories');
	}

	return productCategories.find(
		(productCategory) => productCategory.productCategoryType === 'Product'
	);
}

/**
 * Change the warehouse from what is currently selected on the value object to another one, if one is assigned to the client
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function changeWarehouse(valueObject: ValueObject) {
	const headers = getAuthorizationHeaders(valueObject);
	const createInvoiceResponse = await fetch(
		`${IDEMPIERE_ENDPOINT}/warehouses`,
		{
			method: 'GET',
			headers,
		}
	);
	const warehouses = await (createInvoiceResponse.json() as Promise<
		BaseListResponse<Warehouse>
	>);
	if (!createInvoiceResponse.ok) {
		throw new Error('could not fetch warehouses');
	}
	const differentWarehouse = warehouses.results.find(
		(warehouse) => warehouse.uuid !== valueObject.warehouse?.uuid
	);
	valueObject.warehouse = differentWarehouse || valueObject.warehouse;
}

/**
 * Add (or subtract) days from a given date
 * @param initialDate The initial date to offset from
 * @param days The number of days to offset
 * @returns The new date with the offset
 */
export function getDateOffset(initialDate: Date, days: number): Date {
	const newDate = new Date(initialDate);
	newDate.setDate(days);
	return newDate;
}

//Instructions
// Step 1: setProcess_UU
// Step 2: setProcessTable_ID and setProcessRecord_ID if needed
//		used when running a process against a given record - as opposed to 0,0 from the menu.
// Step 3: addProcessInfoParam see example below
export async function runProcess(vo: ValueObject) {
	// vo.validate();
	// if (vo.isError)
	// 	return;
	// //further validation
	// if (vo.getProcessInfoParams() == null)
	// 	vo.appendErrorMsg("Parameter List is null - It should at least be an empty List");
	// else if (vo.getProcess_UU() == null)
	// 	vo.appendErrorMsg("Process UU is null - cannot look up process");
	// if (vo.isError())
	// 	return;
	// MProcess pr = new Query(Env.getCtx(), X_AD_Process.Table_Name,
	// 		"AD_Process_UU=?", vo.get_trxName()).setParameters(vo.getProcess_UU()).first();
	// // Create an instance of the process I want to run
	// ProcessCall processCall = null;
	// boolean procSuccess = false;
	// processCall = Core.getProcess(pr.getClassname());
	// // Create a process info instance. This is a composite class containing the parameters.
	// ProcessInfo pi = new ProcessInfo("", pr.get_ID(), vo.getProcessTable_ID(),vo.getProcessRecord_ID());
	// //how to set parameters....
	// //ProcessInfoParameter piClient = new ProcessInfoParameter("AD_Client_ID", getAD_Client_ID(), "", "", "");
	// //ProcessInfoParameter piOrg = new ProcessInfoParameter("AD_Org_ID", 0, "", "", "");
	// //vo.addProcessInfoParam(piClient);
	// //...
	// List<ProcessInfoParameter> params = vo.getProcessInfoParams();
	// if (!params.isEmpty()) {
	// 	pi.setParameter(vo.getProcessInfoParams().toArray(new ProcessInfoParameter[params.size()]));
	// }
	// // Create process instance (mainly for logging/sync purpose)
	// MPInstance mpi = new MPInstance(Env.getCtx(), pr.get_ID(), vo.getProcessRecord_ID());
	// mpi.saveEx();
	// // Connect the process to the process instance.
	// pi.setAD_PInstance_ID(mpi.get_ID());
	// procSuccess = processCall.startProcess(Env.getCtx(), pi, null);
	// if (!procSuccess)
	// 	vo.appendErrorMsg("Process Failed: " + pr.getClassname());
	// clearProcess(vo);
}

export function clearProcess(vo: ValueObject) {
	// vo.setProcess_UU(null);
	// vo.setProcessInfoParams(new ArrayList<ProcessInfoParameter>());
	// vo.setProcessRecord_ID(0);
	// vo.setProcessTable_ID(0);
}
