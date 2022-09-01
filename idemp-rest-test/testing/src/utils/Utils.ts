import {
	invoiceApi,
	patientApi,
	paymentApi,
	productApi,
	productCategoryApi,
	referenceListApi,
	visitApi,
	warehouseApi,
} from '../api';
import { referenceUuid, tenderTypeName, ValueObject } from '../models';
import {
	Invoice,
	InvoiceLine,
	OrderLine,
	Patient,
	Payment,
	PaymentType,
	Product,
	ProductCategory,
	Visit,
} from '../types/org.bandahealth.idempiere.rest';
import { waitFor } from './waitFor';

/**
 * Create a patient. If a business partner already exists on the value object, this won't do anything.
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function createPatient(valueObject: ValueObject) {
	valueObject.validate();

	if (!valueObject.businessPartner) {
		const patient: Partial<Patient> = {
			name: valueObject.getDynamicStepMessage(),
			description: valueObject.getStepMessageLong(),
			dateOfBirth: valueObject.date?.toISOString(),
			gender: 'male',
		};
		valueObject.businessPartner = await patientApi.save(valueObject, patient as Patient);
		if (!valueObject.businessPartner) {
			throw new Error('Business partner not created');
		}
		delete (valueObject.businessPartner as Partial<Patient>).approximateDateOfBirth;
	}
}

/**
 * Create a business partner (don't really have an ideal method for this at the moment - have to go through patients).
 * If a business partner already exists on the value object, this won't do anything.
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function createBusinessPartner(valueObject: ValueObject) {
	await createPatient(valueObject);
}

/**
 * Create a product (don't really have an ideal method for this at the moment - have to go through items).
 * If a product already exists on the value object, this won't do anything.
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function createProduct(valueObject: ValueObject) {
	valueObject.validate();

	if (!valueObject.product) {
		const product: Partial<Product> = {
			orgId: 0,
			description: valueObject.getStepMessageLong(),
			name: valueObject.getDynamicScenarioName(),
			productCategoryUuid: '',
			totalQuantity: valueObject.quantity,
			buyPrice: valueObject.purchaseStandardPrice ?? 1,
			sellPrice: valueObject.salesStandardPrice ?? 1,
		};
		valueObject.product = await productApi.save(valueObject, product as Product);
		if (!valueObject.product) {
			throw new Error('Product not created');
		}
	}
}

/**
 * Create an order (don't really have an ideal method for this at the moment - have to go through visits).
 * This requires a document type, a business partner, and a warehouse be selected on the value object.
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function createVisit(valueObject: ValueObject) {
	valueObject.validate();

	//perform further validation if needed based on business logic
	if (!valueObject.businessPartner) {
		throw new Error('Business Partner is Null');
	} else if (!valueObject.warehouse) {
		throw new Error('Warehouse is Null');
	}

	const visit: Partial<Visit> = {
		description: valueObject.getStepMessageLong(),
		dateOrdered: valueObject.date?.toISOString(),
		patient: valueObject.businessPartner as Patient | undefined,
		warehouse: valueObject.warehouse,
		orderLines: [],
	};
	const line: Partial<OrderLine> = {
		description: valueObject.getStepMessageLong(),
		product: valueObject.product,
		quantity: valueObject.quantity || 1,
	};
	line.price = (line.quantity || 0) * (line.product?.sellPrice || 0);
	visit.orderLines?.push(line as OrderLine);
	valueObject.order = await visitApi.save(valueObject, visit as Visit);
	if (!valueObject.order) {
		throw new Error('Order not created');
	}
	valueObject.orderLine = valueObject.order!.orderLines[0];

	if (valueObject.documentAction) {
		valueObject.order = await visitApi.process(valueObject, valueObject.order!.uuid, valueObject.documentAction!);
		if (!valueObject.order) {
			throw new Error('Order not processed');
		}
	}
}

/**
 * Create an order (don't really have an ideal method for this at the moment - have to go through visits).
 * This requires a document type, a business partner, and a warehouse be selected on the value object.
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function createOrder(valueObject: ValueObject) {
	await createVisit(valueObject);
}

/**
 * Create an invoice. This requires a document type, a business partner, and a completed order be selected on the value object.
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function createInvoice(valueObject: ValueObject) {
	valueObject.validate();

	if (!valueObject.businessPartner) {
		throw new Error('Business Partner is Null');
	} else if (valueObject.order?.docStatus !== 'CO') {
		throw new Error('Order Not Completed');
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
	invoiceLine.price = (invoiceLine.quantity || 0) * (invoiceLine.product?.sellPrice || 0);
	invoice.invoiceLines?.push(invoiceLine as unknown as InvoiceLine);

	valueObject.invoice = await invoiceApi.save(valueObject, invoice as Invoice);
	if (!valueObject.invoice) {
		throw new Error('Invoice not created');
	}
	valueObject.invoiceLine = valueObject.invoice!.invoiceLines[0];

	if (valueObject.documentAction) {
		valueObject.invoice = await invoiceApi.process(valueObject, valueObject.invoice!.uuid, valueObject.documentAction);
		if (!valueObject.invoice) {
			throw new Error('Invoice not processed');
		}
	}
}

/**
 * Create a payment. This requires a document type and a business partner be selected on the value object.
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function createPayment(valueObject: ValueObject) {
	valueObject.validate();

	if (!valueObject.businessPartner) {
		throw new Error('Business Partner is Null');
	}

	const payment: Partial<Payment> = {
		orgId: 0,
		patient: valueObject.businessPartner as unknown as Patient,
		description: valueObject.getStepMessageLong(),
		payAmount: valueObject.invoice?.grandTotal || 1,
		paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
			(tenderType) => tenderType.name === tenderTypeName.CASH,
		) as PaymentType,
	};
	valueObject.payment = await paymentApi.save(valueObject, payment as Payment);
	if (!valueObject.payment) {
		throw new Error('Payment not created');
	}

	if (valueObject.documentAction) {
		valueObject.payment = await paymentApi.process(valueObject, valueObject.payment!.uuid, valueObject.documentAction);
		if (!valueObject.payment) {
			throw new Error('Payment not processed');
		}
	}
}

/**
 * This gets the default product category to assign to items (not services).
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function getDefaultProductCategory(valueObject: ValueObject): Promise<ProductCategory | undefined> {
	valueObject.validate();

	return (await productCategoryApi.getAll(valueObject)).find(
		(productCategory) => productCategory.productCategoryType === 'Product',
	);
}

/**
 * Change the warehouse from what is currently selected on the value object to another one, if one is assigned to the client
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function changeWarehouse(valueObject: ValueObject) {
	const differentWarehouse = (await warehouseApi.get(valueObject)).results.find(
		(warehouse) => warehouse.uuid !== valueObject.warehouse?.uuid,
	);
	valueObject.warehouse = differentWarehouse || valueObject.warehouse;
	if (!valueObject.warehouse) {
		throw new Error('Warehouse not switched');
	}
}

/**
 * Add (or subtract) days from a given date
 * @param initialDate The initial date to offset from
 * @param days The number of days to offset
 * @returns The new date with the offset
 */
export function getDateOffset(initialDate: Date, days: number): Date {
	const newDate = new Date(initialDate);
	newDate.setDate(newDate.getDate() + days);
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

export async function waitForVisitToComplete(valueObject: ValueObject) {
	await waitFor(async () => {
		valueObject.order = await visitApi.getByUuid(valueObject, valueObject.order!.uuid);
		return expect(valueObject.order!.docStatus).toBe('CO');
	});
}
