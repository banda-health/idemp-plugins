import { v4 } from 'uuid';
import { mutate, query } from '../api';
import { documentStatus, ValueObject } from '../models';
import {
	Bh_VisitSaveDocument,
	C_BPartnerGetDocument,
	C_BPartnerSaveWithLocationDocument,
	C_ChargeSaveDocument,
	C_LocationGetDocument,
	C_OrderProcessDocument,
	C_OrderSaveWithOrderLinesDocument,
	C_TaxCategoryGetDocument,
	C_UomGetDefaultDocument,
	M_ProductSaveDocument,
	M_Product_CategoryGetDocument,
} from '../__generated__/graphql';

export async function loadRegionAndCountry(valueObject: ValueObject) {
	if (valueObject.country && valueObject.region) {
		return;
	}
	const location = (
		await query(valueObject)({
			query: C_LocationGetDocument,
			variables: {
				page: 0,
				size: 0,
				filter: JSON.stringify({ c_bpartner_location: { c_bpartner: { name: 'Standard' } } }),
			},
		})
	).data.C_LocationGet.results[0];
	valueObject.region = location.C_Region;
	valueObject.country = location.C_Country;
}

/**
 * Create a business partner (don't really have an ideal method for this at the moment - have to go through patients).
 * If a business partner already exists on the value object, this won't do anything.
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function createBusinessPartner(valueObject: ValueObject) {
	valueObject.validate();

	if (!valueObject.businessPartner) {
		await loadRegionAndCountry(valueObject);

		const businessPartnerUuid = v4();
		const locationUuid = v4();
		const saveResult = (
			await mutate(valueObject)({
				mutation: C_BPartnerSaveWithLocationDocument,
				variables: {
					C_BPartner: {
						UUID: businessPartnerUuid,
						Name: valueObject.getDynamicStepMessage(),
						Description: valueObject.getStepMessageLong(),
						BH_Birthday: valueObject.date?.getTime(),
						bh_gender: { UUID: '73c2b736-830b-430e-bc43-571c6372ba22' }, // male
						IsCustomer: true,
						IsVendor: true,
					},
					C_Location: {
						UUID: locationUuid,
						C_Region: valueObject.region
							? {
									UUID: valueObject.region.UUID,
							  }
							: undefined,
						C_Country: valueObject.country
							? {
									UUID: valueObject.country.UUID,
							  }
							: undefined,
						City: 'Test',
					},
					C_BPartner_Location: {
						C_BPartner: {
							UUID: businessPartnerUuid,
						},
						C_Location: {
							UUID: locationUuid,
						},
						Name: valueObject.city + ' ' + valueObject.region?.Name,
					},
				},
			})
		).data;
		valueObject.businessPartner = (
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { size: 1, filter: JSON.stringify({ c_bpartner_uu: businessPartnerUuid }) },
			})
		).data.C_BPartnerGet.results[0];
		valueObject.businessPartnerLocation = saveResult?.C_BPartner_LocationSave;

		if (!valueObject.businessPartner) {
			throw new Error('Business partner not created');
		}
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

	if (!valueObject.product) {
		valueObject.product = (
			await mutate(valueObject)({
				mutation: M_ProductSaveDocument,
				variables: {
					entity: {
						BH_BuyPrice: valueObject.purchaseStandardPrice ?? 1,
						BH_SellPrice: valueObject.salesStandardPrice ?? 1,
						C_TaxCategory: { UUID: (await getDefaultTaxCategory(valueObject)).UUID },
						C_UOM: { UUID: (await query(valueObject)({ query: C_UomGetDefaultDocument })).data.C_UOMGetDefault.UUID },
						Description: valueObject.getStepMessageLong(),
						M_Product_Category: { UUID: (await getDefaultProductCategory(valueObject)).UUID },
						Name: valueObject.getDynamicScenarioName(),
						ProductType: { UUID: '59dcc5c9-ab37-4f5c-9987-6e2347f50093' }, // Items
					},
				},
			})
		).data?.M_ProductSave;
		if (!valueObject.product) {
			throw new Error('Product not created');
		}
	}
}

/**
 * Create a charge. If a charge already exists on the value object, this won't do anything.
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function createCharge(valueObject: ValueObject) {
	valueObject.validate();

	//use valueObject.clearCharge() to create new charge
	if (!valueObject.charge) {
		valueObject.charge = (
			await mutate(valueObject)({
				mutation: C_ChargeSaveDocument,
				variables: {
					entity: {
						Description: valueObject.getStepMessageLong(),
						Name: `${valueObject.random}_${valueObject.scenarioName}`,
					},
				},
			})
		).data?.C_ChargeSave;
	}
}

/**
 * Create a visit. This requires a document type and a business partner be selected on the value object.
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function createVisit(valueObject: ValueObject) {
	valueObject.validate();

	//perform further validation if needed based on business logic
	if (!valueObject.businessPartner) {
		throw new Error('Business Partner is Null');
	}

	valueObject.visit = (
		await mutate(valueObject)({
			mutation: Bh_VisitSaveDocument,
			variables: {
				entity: {
					Description: valueObject.getStepMessageLong(),
					Patient: { UUID: valueObject.businessPartner.UUID },
					BH_VisitDate: valueObject.date?.getTime(),
				},
			},
		})
	).data?.BH_VisitSave;
	if (!valueObject.visit) {
		throw new Error('Visit not created');
	}
}

/**
 * Create an order. This requires a document type, a business partner, and a warehouse be selected on the value object.
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function createOrder(valueObject: ValueObject) {
	valueObject.validate();

	//perform further validation if needed based on business logic
	if (!valueObject.documentType) {
		throw new Error('Document Type is Null');
	} else if (!valueObject.businessPartner) {
		throw new Error('Business Partner is Null');
	} else if (!valueObject.warehouse) {
		throw new Error('Warehouse is Null');
	}

	const orderUuid = v4();
	const savedData = (
		await mutate(valueObject)({
			mutation: C_OrderSaveWithOrderLinesDocument,
			variables: {
				C_Order: {
					UUID: orderUuid,
					Description: valueObject.getStepMessageLong(),
					DateOrdered: valueObject.date?.getTime(),
					C_BPartner: { UUID: valueObject.businessPartner.UUID },
					M_Warehouse: { UUID: valueObject.warehouse.UUID },
					IsSOTrx: valueObject.documentType.IsSOTrx,
					C_DocTypeTarget: { UUID: valueObject.documentType.UUID },
					BH_Visit: valueObject.visit ? { UUID: valueObject.visit.UUID } : undefined,
				},
				C_OrderLine: {
					C_Order: { UUID: orderUuid },
					Description: valueObject.getStepMessageLong(),
					M_Product: { UUID: valueObject.product!.UUID },
					Qty: valueObject.quantity || 1,
					Price:
						(valueObject.documentType.IsSOTrx
							? valueObject.salesStandardPrice || valueObject.product?.BH_SellPrice || 0
							: valueObject.purchaseStandardPrice || valueObject.product?.BH_BuyPrice || 0) *
						(valueObject.quantity || 1),
					M_AttributeSetInstance: valueObject.attributeSetInstance
						? { UUID: valueObject.attributeSetInstance.UUID }
						: undefined,
				},
			},
		})
	).data;

	valueObject.order = savedData?.C_OrderSave;
	valueObject.orderLine = savedData?.C_OrderLineSave;

	if (valueObject.documentAction) {
		valueObject.order =
			(
				await mutate(valueObject)({
					mutation: C_OrderProcessDocument,
					variables: { uuid: valueObject.order!.UUID, documentAction: valueObject.documentAction },
				})
			).data?.C_OrderProcess || undefined;
		if (!valueObject.order) {
			throw new Error('Order not processed');
		}
	}
	// valueObject.visit?.orders?.push(valueObject.order!);
}

/**
 * Create an invoice. This requires a document type, a business partner, and either no order or a completed order
 * be selected on the value object.
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function createInvoice(valueObject: ValueObject) {
	valueObject.validate();

	if (!valueObject.documentType) {
		throw new Error('Document Type is Null');
	} else if (!valueObject.businessPartner) {
		throw new Error('Business Partner is Null');
	} else if (
		valueObject.order &&
		valueObject.order.DocStatus.Value !== documentStatus.Completed &&
		!valueObject.visit
	) {
		throw new Error('Order Not Completed');
	}

	const invoice: Partial<any /*Invoice*/> = {
		orgUUID: 0,
		description: valueObject.getStepMessageLong(),
		businessPartner: valueObject.businessPartner,
		dateInvoiced: valueObject.date?.toISOString(),
		invoiceLines: [],
		documentTypeTarget: valueObject.documentType,
		isSalesOrderTransaction: valueObject.documentType!.IsSOTrx,
	};
	const invoiceLine: Partial<any /*InvoiceLine*/> = {
		description: valueObject.getStepMessageLong(),
		quantity: valueObject.quantity || 1,
	};
	if (valueObject.product) {
		invoiceLine.product = valueObject.product;
	} else if (valueObject.charge) {
		invoiceLine.charge = valueObject.charge;
	}
	invoiceLine.price =
		valueObject.salesStandardPrice || (invoiceLine.quantity || 0) * (invoiceLine.product?.sellPrice || 0);
	invoice.invoiceLines?.push(invoiceLine as unknown as any /*InvoiceLine*/);

	// valueObject.invoice = await invoiceApi.save(valueObject, invoice as Invoice);
	// if (!valueObject.invoice) {
	// 	throw new Error('Invoice not created');
	// }
	valueObject.invoiceLine = valueObject.invoice!.invoiceLines[0];

	// if (valueObject.documentAction) {
	// 	valueObject.invoice = await invoiceApi.process(valueObject, valueObject.invoice!.uuid, valueObject.documentAction);
	// 	if (!valueObject.invoice) {
	// 		throw new Error('Invoice not processed');
	// 	}
	// }
	// valueObject.visit?.invoices?.push(valueObject.invoice!);
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

	const payment: Partial<any /*Payment*/> = {
		orgUUID: 0,
		businessPartner: valueObject.businessPartner,
		description: valueObject.getStepMessageLong(),
		payAmount: valueObject.paymentAmount || valueObject.invoice?.grandTotal || valueObject.order?.GrandTotal || 1,
		paymentType: valueObject.tenderType, // ||
		// ((await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
		// 	(tenderType) => tenderType.name === tenderTypeName.CASH,
		// ) as PaymentType),
		documentType: valueObject.documentType,
	};
	// valueObject.payment = await paymentApi.save(valueObject, payment as Payment);
	// if (!valueObject.payment) {
	// 	throw new Error('Payment not created');
	// }

	// if (valueObject.documentAction) {
	// 	valueObject.payment = await paymentApi.process(valueObject, valueObject.payment!.uuid, valueObject.documentAction);
	// 	if (!valueObject.payment) {
	// 		throw new Error('Payment not processed');
	// 	}
	// }
	// valueObject.visit?.payments?.push(valueObject.payment!);
}

/**
 * This gets the default product category to assign to items (not services).
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function getDefaultProductCategory(valueObject: ValueObject) {
	valueObject.validate();
	return (
		await query(valueObject)({
			query: M_Product_CategoryGetDocument,
			variables: { size: 1, filter: JSON.stringify({ bh_product_category_type: 'P' }) },
		})
	).data.M_Product_CategoryGet.results[0];
}

/**
 * This gets the default tax category to assign to items (not services).
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function getDefaultTaxCategory(valueObject: ValueObject) {
	valueObject.validate();
	return (
		await query(valueObject)({
			query: C_TaxCategoryGetDocument,
			variables: { size: 1, filter: JSON.stringify({ isdefault: true }) },
		})
	).data.C_TaxCategoryGet.results[0];
}

/**
 * Change the warehouse from what is currently selected on the value object to another one, if one is assigned to the client
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function changeWarehouse(valueObject: ValueObject) {
	// const differentWarehouse = (await warehouseApi.get(valueObject)).results.find(
	// 	(warehouse) => warehouse.uuid !== valueObject.warehouse?.uuid,
	// );
	// valueObject.warehouse = differentWarehouse || valueObject.warehouse;
	// if (!valueObject.warehouse) {
	// 	throw new Error('Warehouse not switched');
	// }
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

export function clearProcess(valueObject: ValueObject) {
	valueObject.processUuid = undefined;
	valueObject.processInformationParameters = [];
}

/**
 * This is the same as the {@link #runProcess(ValueObject)}, except that it sets a file to the value object
 * and doesn't clear the process. You must run {@link #clearReport(ValueObject)} after retrieving the
 * generated report file.
 * <br/><br/>
 * Instructions:
 * <ul>
 *   <li>Step 1: Set processUuid</li>
 *   <li>Step 2: Add parameters: see example below</li>
 * </ul>
 *
 * @param valueObject The value object used to store all information
 */
export async function runReport(valueObject: ValueObject) {
	valueObject.validate();
	if (valueObject.isError) {
		return;
	}

	//further validation
	if (!valueObject.processInformationParameters) {
		valueObject.errorMessage += 'Parameter List is null - It should at least be an empty List';
	} else if (!valueObject.processUuid) {
		valueObject.errorMessage += 'Process UU is null - cannot look up process';
	}
	if (valueObject.isError) {
		return;
	}

	// const process = await processApi.getByUuid(valueObject, valueObject.processUuid!);

	// // Create a process info instance. This is a composite class containing the parameters.
	// valueObject.reportType ||= 'pdf';

	// // Map parameter names to their actual parameters
	// if (valueObject.processInformationParameters!.length) {
	// 	valueObject.processInformationParameters = valueObject.processInformationParameters!.map(
	// 		(processInformationParameter) => {
	// 			const specifiedParameter = process.parameters.find(
	// 				(parameter) =>
	// 					processInformationParameter.uuid === parameter.uuid ||
	// 					processInformationParameter.parameterName === parameter.name,
	// 			);
	// 			if (specifiedParameter) {
	// 				return {
	// 					...processInformationParameter,
	// 					processParameterUuUUID: specifiedParameter.uuid,
	// 				} as ProcessInfoParameter;
	// 			}
	// 			return processInformationParameter;
	// 		},
	// 	);
	// }

	// valueObject.report = Buffer.from(await processApi.runAndExport(valueObject));
}

/**
 * Create an inventory record
 *
 * @param valueObject The value object used to store all information
 */
export async function createInventory(valueObject: ValueObject) {
	valueObject.validate();

	// perform further validation if needed based on business logic
	if (!valueObject.businessPartner) {
		throw new Error('Business Partner is Null');
	} else if (!valueObject.warehouse) {
		throw new Error('Warehouse is Null');
	}

	const inventory = {
		orgUUID: 0,
		description: valueObject.getStepMessageLong(),
		warehouse: valueObject.warehouse,
	} as any; /*Inventory*/
	const inventoryLine = {
		orgUUID: 0,
		description: valueObject.getStepMessageLong(),
		product: valueObject.product,
		attributeSetInstance: valueObject.attributeSetInstance,
		locator: valueObject.warehouse.M_Locators?.[0],
		quantityCount: valueObject.quantity || 1,
		line: 10,
	}; // as InventoryLine;
	inventory.inventoryLines = [inventoryLine];
	// valueObject.inventory = await inventoryApi.save(valueObject, inventory);
	// if (!valueObject.inventory) {
	// 	throw new Error('Inventory not created');
	// }
	valueObject.inventoryLine = valueObject.inventory!.inventoryLines[0];

	// if (valueObject.documentAction) {
	// 	valueObject.inventory = await inventoryApi.process(
	// 		valueObject,
	// 		valueObject.inventory!.uuid,
	// 		valueObject.documentAction!,
	// 	);
	// 	if (!valueObject.inventory) {
	// 		throw new Error('Inventory not processed');
	// 	}
	// }
}
