import { v4 } from 'uuid';
import {
	Ad_OrgInfoGetDocument,
	Ad_ProcessRunAndExportDocument,
	Ad_Ref_ListGetDocument,
	Bh_VisitGetDocument,
	Bh_VisitSaveDocument,
	C_BankAccountGetDocument,
	C_Bp_GroupGetDocument,
	C_BPartnerGetDocument,
	C_BPartnerSaveDocument,
	C_BPartnerSaveWithLocationAndContactDocument,
	C_ChargeSaveDocument,
	C_InvoiceGetDocument,
	C_InvoiceProcessDocument,
	C_InvoiceSaveWithInvoiceLinesDocument,
	C_OrderGetDocument,
	C_OrderLineGetDocument,
	C_OrderProcessDocument,
	C_OrderSaveWithOrderLinesDocument,
	C_PaymentProcessDocument,
	C_PaymentSaveDocument,
	C_TaxCategoryGetDocument,
	C_UomGetDefaultDocument,
	M_AttributeSetInstanceGetDocument,
	M_DiscountSchemaGetDocument,
	M_InOutLineSaveDocument,
	M_InOutProcessDocument,
	M_InOutSaveDocument,
	M_InventoryProcessDocument,
	M_InventorySaveWithInventoryLinesDocument,
	M_LocatorSaveDocument,
	M_PriceList_VersionGetDocument,
	M_PriceList_VersionSaveDocument,
	M_PriceListSaveDocument,
	M_Product_CategoryGetDocument,
	M_ProductPriceSaveManyDocument,
	M_ProductSaveDocument,
	M_StorageOnHandGetDocument,
	M_WarehouseGetDocument,
	M_WarehouseSaveDocument,
	ReportOutput,
} from '../__generated__/graphql';
import { mutate, query } from '../api';
import { documentAction, documentStatus, referenceUuid, tenderTypeName, ValueObject } from '../models';
import { formatApiDate } from './DateUtil';

export async function loadBankAccount(valueObject: ValueObject) {
	if (valueObject.bankAccount) {
		return;
	}
	valueObject.bankAccount = (await getBankAccountOfOrganization(valueObject)) || undefined;

	if (!valueObject.bankAccount) {
		valueObject.errorMessage += 'No Bank Account for Org';
		return;
	}
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
		const businessPartnerUuid = v4();
		const locationUuid = v4();
		const salesPriceListUuid = valueObject.salesPriceList?.UU || v4();
		const purchasePriceListUuid = valueObject.purchasePriceList?.UU || v4();
		const saveResult = (
			await mutate(valueObject)({
				mutation: C_BPartnerSaveWithLocationAndContactDocument,
				variables: {
					C_BPartner: {
						UU: businessPartnerUuid,
						Name: valueObject.getDynamicStepMessage(),
						Description: valueObject.getStepMessageLong(),
						BH_Birthday: formatApiDate(valueObject.date),
						bh_gender: { UU: '73c2b736-830b-430e-bc43-571c6372ba22' }, // male
						IsCustomer: true,
						IsVendor: true,
						M_PriceList: {
							UU:
								valueObject.salesPriceList?.UU ||
								(
									await mutate(valueObject)({
										mutation: M_PriceListSaveDocument,
										variables: {
											Entity: {
												UU: salesPriceListUuid,
												Name: 'SO_During' + valueObject.stepName + valueObject.random,
												Description: valueObject.getStepMessageLong(),
												IsSOPriceList: true,
												C_Currency: { UU: valueObject.currency?.UU! },
											},
										},
									})
								).data?.M_PriceListSave.UU!,
						},
						PO_PriceList: {
							UU:
								valueObject.purchasePriceList?.UU ||
								(
									await mutate(valueObject)({
										mutation: M_PriceListSaveDocument,
										variables: {
											Entity: {
												UU: purchasePriceListUuid,
												Name: 'PO_During' + valueObject.stepName + valueObject.random,
												Description: valueObject.getStepMessageLong(),
												IsSOPriceList: false,
												C_Currency: { UU: valueObject.currency?.UU! },
											},
										},
									})
								).data?.M_PriceListSave.UU!,
						},
					},
					C_Location: {
						UU: locationUuid,
						C_Region: valueObject.region
							? {
									UU: valueObject.region.UU,
							  }
							: undefined,
						C_Country: valueObject.country
							? {
									UU: valueObject.country.UU,
							  }
							: undefined,
						City: 'Test',
					},
					C_BPartner_Location: {
						C_BPartner: {
							UU: businessPartnerUuid,
						},
						C_Location: {
							UU: locationUuid,
						},
						Name: valueObject.city + ' ' + valueObject.region?.Name,
					},
					AD_User: {
						C_BPartner: { UU: businessPartnerUuid },
						Name: valueObject.getDynamicStepMessage(),
						NotificationType: { UU: 'ca78475e-7191-402b-9d15-7244e87620f1' }, // NOTIFICATIONTYPE_None
						Description: valueObject.getStepMessageLong(),
					},
				},
			})
		).data;
		valueObject.businessPartner = (
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { Size: 1, Filter: JSON.stringify({ c_bpartner_uu: businessPartnerUuid }) },
			})
		).data.C_BPartnerGet.Results[0];
		valueObject.businessPartnerLocation = saveResult?.C_BPartner_LocationSave;
		valueObject.salesPriceList = { UU: salesPriceListUuid };
		valueObject.purchasePriceList = { UU: purchasePriceListUuid };

		if (!valueObject.businessPartner) {
			throw new Error('Business partner not created');
		}
	}
}

// Our reports require specific BP groups assigned to patients, so we'll create a special method to handle this
export async function createPatient(valueObject: ValueObject) {
	await createBusinessPartner(valueObject);
	const patientBusinessPartnerGroup = (
		await query(valueObject)({
			query: C_Bp_GroupGetDocument,
			variables: { Filter: JSON.stringify({ Name: 'Patients - DO NOT CHANGE' }) },
		})
	).data.C_BP_GroupGet.Results[0];
	if (patientBusinessPartnerGroup == null) {
		throw new Error('Patient BP Group is not present');
	}
	await mutate(valueObject)({
		mutation: C_BPartnerSaveDocument,
		variables: { Entity: { C_BP_Group: { UU: patientBusinessPartnerGroup.UU }, UU: valueObject.businessPartner!.UU } },
	});
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
					Entity: {
						BH_BuyPrice: valueObject.purchaseStandardPrice ?? 1,
						BH_SellPrice: valueObject.salesStandardPrice ?? 1,
						C_TaxCategory: { UU: (await getDefaultTaxCategory(valueObject)).UU },
						C_UOM: { UU: (await query(valueObject)({ query: C_UomGetDefaultDocument })).data.C_UOMGetDefault.UU },
						Description: valueObject.getStepMessageLong(),
						M_Product_Category: { UU: (await getDefaultProductCategory(valueObject)).UU },
						Name: valueObject.getDynamicScenarioName(),
						ProductType: { UU: '59dcc5c9-ab37-4f5c-9987-6e2347f50093' }, // Items
					},
				},
			})
		).data?.M_ProductSave;
		if (!valueObject.product) {
			throw new Error('Product not created');
		}

		if (valueObject.businessPartner) {
			// create PO and SO price list entries
			const priceListDate = new Date();
			priceListDate.setFullYear(priceListDate.getFullYear() - 1);

			let salesPriceListVersion = (
				await query(valueObject)({
					query: M_PriceList_VersionGetDocument,
					variables: {
						Filter: JSON.stringify({
							m_pricelist: { m_pricelist_uu: valueObject.businessPartner.M_PriceList?.UU! },
							validfrom: { $lte: priceListDate.getTime() },
						}),
					},
				})
			).data.M_PriceList_VersionGet.Results[0];
			if (!salesPriceListVersion) {
				// get bogus price list schema - required field
				const schema = (
					await query(valueObject)({
						query: M_DiscountSchemaGetDocument,
						variables: { Filter: JSON.stringify({ discounttype: 'P' }) },
					})
				).data.M_DiscountSchemaGet.Results[0];
				//
				const uuid = v4();
				await mutate(valueObject)({
					mutation: M_PriceList_VersionSaveDocument,
					variables: {
						Entity: {
							UU: uuid,
							Name: priceListDate + '; IsSOTrx=Y; ' + Math.floor(Math.random() * 1000000),
							Description: 'Create sales price list version',
							M_PriceList: { UU: valueObject.businessPartner.M_PriceList?.UU! },
							ValidFrom: formatApiDate(priceListDate),
							M_DiscountSchema: { UU: schema.UU },
						},
					},
				});
				salesPriceListVersion = { UU: uuid };
			}

			let purchasePriceListVersion = (
				await query(valueObject)({
					query: M_PriceList_VersionGetDocument,
					variables: {
						Filter: JSON.stringify({
							m_pricelist: { m_pricelist_uu: valueObject.businessPartner.PO_PriceList?.UU! },
							validfrom: { $lte: priceListDate.getTime() },
						}),
					},
				})
			).data.M_PriceList_VersionGet.Results[0];
			if (!purchasePriceListVersion) {
				// get bogus price list schema - required field
				const schema = (
					await query(valueObject)({
						query: M_DiscountSchemaGetDocument,
						variables: { Filter: JSON.stringify({ discounttype: 'P' }) },
					})
				).data.M_DiscountSchemaGet.Results[0];
				//
				const uuid = v4();
				await mutate(valueObject)({
					mutation: M_PriceList_VersionSaveDocument,
					variables: {
						Entity: {
							UU: uuid,
							Name: priceListDate + '; IsSOTrx=Y; ' + Math.floor(Math.random() * 1000000),
							Description: 'Create sales price list version',
							M_PriceList: { UU: valueObject.businessPartner.M_PriceList?.UU! },
							ValidFrom: formatApiDate(priceListDate),
							M_DiscountSchema: { UU: schema.UU },
						},
					},
				});
				purchasePriceListVersion = { UU: uuid };
			}

			// Now set the product prices
			await mutate(valueObject)({
				mutation: M_ProductPriceSaveManyDocument,
				variables: {
					Entities: [
						{
							M_PriceList_Version: { UU: purchasePriceListVersion.UU },
							M_Product: { UU: valueObject.product.UU },
							PriceLimit: valueObject.purchaseLimitPrice,
							PriceStd: valueObject.purchaseStandardPrice,
							PriceList: valueObject.purchaseListPrice,
						},
						{
							M_PriceList_Version: { UU: salesPriceListVersion.UU },
							M_Product: { UU: valueObject.product.UU },
							PriceLimit: valueObject.salesLimitPrice,
							PriceStd: valueObject.salesStandardPrice,
							PriceList: valueObject.salesListPrice,
						},
					],
				},
			});
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
					Entity: {
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

	const visitUuid = (
		await mutate(valueObject)({
			mutation: Bh_VisitSaveDocument,
			variables: {
				Entity: {
					Description: valueObject.getStepMessageLong(),
					Patient: { UU: valueObject.businessPartner.UU },
					BH_VisitDate: valueObject.date?.getTime(),
				},
			},
		})
	).data?.BH_VisitSave.UU;
	valueObject.visit = (
		await query(valueObject)({
			query: Bh_VisitGetDocument,
			variables: { Filter: JSON.stringify({ bh_visit_uu: visitUuid }) },
		})
	).data.BH_VisitGet.Results[0];
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
					UU: orderUuid,
					BH_Visit: valueObject.visit ? { UU: valueObject.visit.UU } : undefined,
					C_BPartner: { UU: valueObject.businessPartner.UU },
					C_DocTypeTarget: { UU: valueObject.documentType.UU },
					DateOrdered: formatApiDate(valueObject.date),
					Description: valueObject.getStepMessageLong(),
					IsSOTrx: valueObject.documentType.IsSOTrx,
					M_Warehouse: { UU: valueObject.warehouse.UU },
					SalesRep: { UU: valueObject.user?.UU! },
				},
				C_OrderLine: {
					C_Order: { UU: orderUuid },
					Description: valueObject.getStepMessageLong(),
					M_Product: { UU: valueObject.product!.UU },
					Qty: valueObject.quantity || 1,
					Price: valueObject.documentType.IsSOTrx
						? valueObject.salesStandardPrice || valueObject.product?.BH_SellPrice || 0
						: valueObject.purchaseStandardPrice || valueObject.product?.BH_BuyPrice || 0,
					M_AttributeSetInstance: valueObject.attributeSetInstance
						? { UU: valueObject.attributeSetInstance.UU }
						: undefined,
				},
			},
		})
	).data;

	valueObject.order = (
		await query(valueObject)({
			query: C_OrderGetDocument,
			variables: { Filter: JSON.stringify({ c_order_uu: orderUuid }) },
		})
	).data.C_OrderGet.Results[0];
	valueObject.orderLine = savedData?.C_OrderLineSave;

	if (valueObject.documentAction) {
		valueObject.order =
			(
				await mutate(valueObject)({
					mutation: C_OrderProcessDocument,
					variables: { UU: valueObject.order!.UU, DocumentAction: valueObject.documentAction },
				})
			).data?.C_OrderProcess || undefined;
		if (!valueObject.order) {
			throw new Error('Order not processed');
		}
	}
}

export async function createInOut(valueObject: ValueObject) {
	valueObject.validate();

	//perform further validation if needed based on business logic
	if (!valueObject.documentType) {
		throw new Error('DocType is Null');
	} else if (!valueObject.businessPartner) {
		throw new Error('BP is Null');
	} else if (!valueObject.warehouse) {
		throw new Error('Warehouse is Null');
	} else if (valueObject.order?.DocStatus.Value !== documentStatus.Completed) {
		throw new Error('Order Not Completed');
	}

	const movementTypes = (
		await query(valueObject)({
			query: Ad_Ref_ListGetDocument,
			variables: { Filter: JSON.stringify({ ad_reference: { ad_reference_uu: referenceUuid.MOVEMENT_TYPES } }) },
		})
	).data.AD_Ref_ListGet.Results;

	//create inout header
	valueObject.inOut = (
		await mutate(valueObject)({
			mutation: M_InOutSaveDocument,
			variables: {
				M_InOut: {
					AD_Org: valueObject.organization ? { UU: valueObject.organization.UU } : undefined,
					AD_User: { UU: valueObject.user!.UU },
					BH_Visit:
						valueObject.documentType.IsSOTrx && valueObject.visit?.UU ? { UU: valueObject.visit.UU } : undefined,
					C_BPartner: { UU: valueObject.businessPartner.UU },
					C_DocType: { UU: valueObject.documentType.UU },
					C_Order: { UU: valueObject.order.UU },
					DateAcct: formatApiDate(valueObject.date),
					Description: valueObject.getStepMessageLong(),
					IsSOTrx: valueObject.documentType.IsSOTrx,
					M_Warehouse: { UU: valueObject.warehouse.UU },
					MovementDate: formatApiDate(valueObject.date),
					MovementType: {
						UU: movementTypes.find(
							(movementType) => movementType.Value === (valueObject.documentType?.IsSOTrx ? 'C+' : 'V+'),
						)?.UU!,
					},
				},
			},
		})
	).data?.M_InOutSave;

	//create inout line
	const locatorToUse = valueObject.warehouse.M_Locators?.[0];
	valueObject.inOutLine = (
		await mutate(valueObject)({
			mutation: M_InOutLineSaveDocument,
			variables: {
				M_InOutLine: {
					AD_Org: valueObject.organization ? { UU: valueObject.organization.UU } : undefined,
					C_OrderLine: { UU: valueObject.orderLine!.UU },
					C_UOM: { UU: (await query(valueObject)({ query: C_UomGetDefaultDocument })).data.C_UOMGetDefault.UU },
					Description: valueObject.getStepMessageLong(),
					M_AttributeSetInstance: valueObject.attributeSetInstance?.UU
						? { UU: valueObject.attributeSetInstance.UU }
						: undefined,
					M_InOut: { UU: valueObject.inOut!.UU },
					M_Locator: locatorToUse?.UU ? { UU: locatorToUse.UU } : undefined,
					M_Product: { UU: valueObject.product!.UU },
					Qty: valueObject.quantity || 1,
				},
			},
		})
	).data?.M_InOutLineSave;

	if (valueObject.documentAction) {
		valueObject.inOut =
			(
				await mutate(valueObject)({
					mutation: M_InOutProcessDocument,
					variables: { UU: valueObject.inOut!.UU, DocumentAction: valueObject.documentAction },
				})
			).data?.M_InOutProcess || undefined;
		if (!valueObject.inOut) {
			throw new Error('InOut not processed');
		}
	}
} //create inout

/**
 * Create an InOut record based on the order. This will create both the InOut header and lines
 * from the completed order, matching the Java createInOutFromOrder method exactly.
 * This creates lines for ALL order lines in the order, just like the Java version.
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function createInOutFromOrder(valueObject: ValueObject) {
	valueObject.validate();

	//perform further validation if needed based on business logic
	if (!valueObject.documentType) {
		throw new Error('DocType is Null');
	} else if (!valueObject.businessPartner) {
		throw new Error('BP is Null');
	} else if (!valueObject.warehouse) {
		throw new Error('Warehouse is Null');
	} else if (
		!valueObject.order ||
		(valueObject.order.DocStatus.Value !== documentStatus.Completed &&
			valueObject.documentAction === documentAction.Complete)
	) {
		throw new Error('Order Not Completed');
	}

	// Get all order lines from the order - matching Java behavior
	const orderLines = (
		await query(valueObject)({
			query: C_OrderLineGetDocument,
			variables: {
				Filter: JSON.stringify({ c_order: { c_order_uu: valueObject.order.UU } }),
				Size: 1000, // Get all order lines
			},
		})
	).data.C_OrderLineGet.Results as any[]; // Type assertion until GraphQL types are regenerated

	if (orderLines.length === 0) {
		throw new Error('Order has no lines');
	}

	const movementTypes = (
		await query(valueObject)({
			query: Ad_Ref_ListGetDocument,
			variables: { Filter: JSON.stringify({ ad_reference: { ad_reference_uu: referenceUuid.MOVEMENT_TYPES } }) },
		})
	).data.AD_Ref_ListGet.Results;

	//create inout header
	valueObject.inOut = (
		await mutate(valueObject)({
			mutation: M_InOutSaveDocument,
			variables: {
				M_InOut: {
					AD_Org: valueObject.organization ? { UU: valueObject.organization.UU } : undefined,
					AD_User: { UU: valueObject.user!.UU },
					BH_Visit:
						valueObject.documentType.IsSOTrx && valueObject.visit?.UU ? { UU: valueObject.visit.UU } : undefined,
					C_BPartner: { UU: valueObject.businessPartner.UU },
					C_DocType: { UU: valueObject.documentType.UU },
					C_Order: { UU: valueObject.order.UU },
					DateAcct: formatApiDate(valueObject.date),
					Description: valueObject.getStepMessageLong(),
					IsSOTrx: valueObject.documentType.IsSOTrx,
					M_Warehouse: { UU: valueObject.warehouse.UU },
					MovementDate: formatApiDate(valueObject.date),
					MovementType: {
						UU: movementTypes.find(
							(movementType) => movementType.Value === (valueObject.documentType?.IsSOTrx ? 'C+' : 'V+'),
						)?.UU!,
					},
				},
			},
		})
	).data?.M_InOutSave;

	//create inout lines for all order lines - matching Java behavior exactly
	const locatorToUse = valueObject.warehouse.M_Locators?.[0];
	const defaultUOM = (await query(valueObject)({ query: C_UomGetDefaultDocument })).data.C_UOMGetDefault.UU;

	// Create lines for all remaining order lines (if any)
	for (const orderLine of orderLines) {
		await mutate(valueObject)({
			mutation: M_InOutLineSaveDocument,
			variables: {
				M_InOutLine: {
					AD_Org: valueObject.organization ? { UU: valueObject.organization.UU } : undefined,
					C_OrderLine: { UU: orderLine.UU },
					C_UOM: { UU: defaultUOM },
					Description: valueObject.getStepMessageLong(),
					M_AttributeSetInstance: orderLine.M_AttributeSetInstance?.UU
						? { UU: orderLine.M_AttributeSetInstance.UU }
						: undefined,
					M_InOut: { UU: valueObject.inOut!.UU },
					M_Locator: locatorToUse?.UU ? { UU: locatorToUse.UU } : undefined,
					M_Product: { UU: orderLine.M_Product!.UU },
					Qty: orderLine.QtyOrdered,
				},
			},
		});
	}

	if (valueObject.documentAction) {
		valueObject.inOut =
			(
				await mutate(valueObject)({
					mutation: M_InOutProcessDocument,
					variables: { UU: valueObject.inOut!.UU, DocumentAction: valueObject.documentAction },
				})
			).data?.M_InOutProcess || undefined;
		if (!valueObject.inOut) {
			throw new Error('InOut not processed');
		}
	}
} //create inout from order

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
		valueObject.documentAction === documentAction.Complete &&
		!valueObject.visit
	) {
		throw new Error('Order Not Completed');
	}

	const invoiceUuid = v4();
	const savedData = (
		await mutate(valueObject)({
			mutation: C_InvoiceSaveWithInvoiceLinesDocument,
			variables: {
				C_Invoice: {
					AD_Org: valueObject.organization ? { UU: valueObject.organization.UU } : undefined,
					BH_Visit: valueObject.visit ? { UU: valueObject.visit.UU } : undefined,
					C_BPartner: { UU: valueObject.businessPartner.UU },
					C_DocTypeTarget: { UU: valueObject.documentType.UU },
					C_Order: valueObject.order ? { UU: valueObject.order.UU } : undefined,
					DateInvoiced: formatApiDate(valueObject.date),
					Description: valueObject.getStepMessageLong(),
					IsSOTrx: valueObject.documentType!.IsSOTrx,
					UU: invoiceUuid,
				},
				C_InvoiceLine: {
					AD_Org: valueObject.organization ? { UU: valueObject.organization.UU } : undefined,
					C_Charge: !valueObject.product && valueObject.charge ? { UU: valueObject.charge.UU } : undefined,
					C_Invoice: { UU: invoiceUuid },
					C_OrderLine: valueObject.orderLine ? { UU: valueObject.orderLine.UU } : undefined,
					Description: valueObject.getStepMessageLong(),
					M_Product: valueObject.product ? { UU: valueObject.product.UU } : undefined,
					Qty: valueObject.quantity || 1,
					Price: valueObject.salesStandardPrice || valueObject.product?.BH_SellPrice || 0,
				},
			},
		})
	).data;

	valueObject.invoice = (
		await query(valueObject)({
			query: C_InvoiceGetDocument,
			variables: { Filter: JSON.stringify({ c_invoice_uu: invoiceUuid }) },
		})
	).data.C_InvoiceGet.Results[0];
	valueObject.invoiceLine = savedData?.C_InvoiceLineSave;

	if (valueObject.documentAction) {
		valueObject.invoice =
			(
				await mutate(valueObject)({
					mutation: C_InvoiceProcessDocument,
					variables: { UU: valueObject.invoice!.UU, DocumentAction: valueObject.documentAction },
				})
			).data?.C_InvoiceProcess || undefined;
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
	if (!valueObject.currency) {
		throw new Error('No Currency');
	}
	if (!valueObject.bankAccount) {
		valueObject.bankAccount = (await getBankAccountOfOrganization(valueObject)) || undefined;

		if (!valueObject.bankAccount) {
			valueObject.errorMessage += 'No Bank Account for Org';
			return;
		}
	}
	let tenderAmount = valueObject.paymentAmount;
	let paymentTotal = tenderAmount;
	if (valueObject.invoice) {
		if (valueObject.paymentAmount !== undefined) {
			tenderAmount = valueObject.paymentAmount;
			paymentTotal = tenderAmount > valueObject.invoice.GrandTotal ? valueObject.invoice.GrandTotal : tenderAmount;
		} else {
			tenderAmount = valueObject.invoice.GrandTotal;
			paymentTotal = tenderAmount;
		}
	} else if (valueObject.order) {
		if (valueObject.paymentAmount !== undefined) {
			tenderAmount = valueObject.paymentAmount;
			paymentTotal = tenderAmount > valueObject.order.GrandTotal ? valueObject.order.GrandTotal : tenderAmount;
		} else {
			tenderAmount = valueObject.order.GrandTotal;
			paymentTotal = tenderAmount;
		}
	}

	valueObject.payment = (
		await mutate(valueObject)({
			mutation: C_PaymentSaveDocument,
			variables: {
				Entity: {
					AD_Org: { UU: valueObject.organization!.UU },
					BH_Original_C_Invoice: valueObject.invoice?.UU ? { UU: valueObject.invoice.UU } : undefined,
					BH_tender_amount: tenderAmount || 1,
					BH_Visit: valueObject.visit ? { UU: valueObject.visit.UU } : undefined,
					C_BankAccount: { UU: valueObject.bankAccount.UU },
					C_BPartner: { UU: valueObject.businessPartner.UU },
					C_DocType: valueObject.documentType ? { UU: valueObject.documentType.UU } : undefined,
					C_Invoice: valueObject.invoice ? { UU: valueObject.invoice.UU } : undefined,
					C_Order: !valueObject.invoice && valueObject.order ? { UU: valueObject.order.UU } : undefined,
					C_Currency: {
						UU: valueObject.invoice?.C_Currency.UU || valueObject.order?.C_Currency.UU || valueObject.currency.UU,
					},
					Description: valueObject.getStepMessageLong(),
					PayAmt: paymentTotal || 1,
					TenderType: {
						UU: (
							valueObject.tenderType ||
							(
								await query(valueObject)({
									query: Ad_Ref_ListGetDocument,
									variables: {
										Size: 1,
										Filter: JSON.stringify({
											ad_reference: { ad_reference_uu: referenceUuid.TENDER_TYPES },
											name: tenderTypeName.CASH,
										}),
									},
								})
							).data.AD_Ref_ListGet.Results[0]
						)?.UU,
					},
				},
			},
		})
	).data?.C_PaymentSave;

	if (valueObject.documentAction) {
		valueObject.payment =
			(
				await mutate(valueObject)({
					mutation: C_PaymentProcessDocument,
					variables: { UU: valueObject.payment!.UU, DocumentAction: valueObject.documentAction },
				})
			).data?.C_PaymentProcess || undefined;
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
export async function getDefaultProductCategory(valueObject: ValueObject) {
	valueObject.validate();
	return (
		await query(valueObject)({
			query: M_Product_CategoryGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ bh_product_category_type: 'P' }) },
		})
	).data.M_Product_CategoryGet.Results[0];
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
			variables: { Size: 1, Filter: JSON.stringify({ isdefault: true }) },
		})
	).data.C_TaxCategoryGet.Results[0];
}

/**
 * Change the warehouse from what is currently selected on the value object to another one, if one is assigned to the client
 * @param valueObject The value object containing information to create the entity
 * @returns Nothing
 */
export async function changeWarehouse(valueObject: ValueObject) {
	const differentWarehouse = (
		await query(valueObject)({ query: M_WarehouseGetDocument })
	).data.M_WarehouseGet.Results.find((warehouse) => warehouse.UU !== valueObject.warehouse?.UU);

	if (!differentWarehouse) {
		createWarehouse(valueObject);
	} else {
		valueObject.warehouse = differentWarehouse;
	}
}

export async function createWarehouse(valueObject: ValueObject) {
	const warehouseUU = v4();
	await mutate(valueObject)({
		mutation: M_WarehouseSaveDocument,
		variables: {
			M_Warehouse: {
				AD_Org: { UU: valueObject.organization!.UU },
				C_Location: {
					UU: (
						await query(valueObject)({
							query: Ad_OrgInfoGetDocument,
							variables: { Filter: JSON.stringify({ 'ad_org.ad_org_uu': valueObject.organization!.UU }) },
						})
					).data.AD_OrgInfoGet.Results[0].C_Location!.UU,
				},
				Description: valueObject.getStepMessageLong(),
				Name: valueObject.random + valueObject.getStepMessageLong(),
				UU: warehouseUU,
			},
		},
	});
	await mutate(valueObject)({
		mutation: M_LocatorSaveDocument,
		variables: {
			M_Locator: {
				AD_Org: { UU: valueObject.organization!.UU },
				IsDefault: true,
				M_Warehouse: { UU: warehouseUU },
				Value: valueObject.random.toString(),
				X: '0',
				Y: '0',
				Z: '0',
			},
		},
	});
	valueObject.warehouse = (
		await query(valueObject)({
			query: M_WarehouseGetDocument,
			variables: { Filter: JSON.stringify({ m_warehouse_uu: warehouseUU }) },
		})
	).data.M_WarehouseGet.Results[0];
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

	// Create a process info instance. This is a composite class containing the parameters.
	valueObject.reportType ||= ReportOutput.Pdf;

	const reportString = (
		await mutate(valueObject)({
			mutation: Ad_ProcessRunAndExportDocument,
			variables: {
				UU: valueObject.processUuid!,
				ProcessInfoParameterList: valueObject.processInformationParameters,
				ReportType: valueObject.reportType,
			},
		})
	).data?.AD_ProcessRunAndExport;
	if (!reportString || !reportString.includes(',')) {
		throw Error(`report didn't run`);
	}
	valueObject.report = Buffer.from(reportString.split(',')[1], 'base64');
}

/**
 * Create an inventory record
 *
 * @param valueObject The value object used to store all information
 */
export async function createInventory(valueObject: ValueObject) {
	valueObject.validate();

	// perform further validation if needed based on business logic
	if (!valueObject.documentType) {
		throw new Error('Document Type is Null');
	} else if (!valueObject.businessPartner) {
		throw new Error('Business Partner is Null');
	} else if (!valueObject.warehouse) {
		throw new Error('Warehouse is Null');
	}

	const attributeSetInstanceToUse =
		valueObject.attributeSetInstance ||
		(
			await query(valueObject)({
				query: M_AttributeSetInstanceGetDocument,
				variables: { Size: 1, Filter: JSON.stringify({ description: '---' }) },
			})
		).data.M_AttributeSetInstanceGet.Results[0];
	const locatorToUse = valueObject.warehouse.M_Locators?.[0];
	const inventoryUuid = v4();
	const savedData = (
		await mutate(valueObject)({
			mutation: M_InventorySaveWithInventoryLinesDocument,
			variables: {
				M_Inventory: {
					UU: inventoryUuid,
					AD_Org: valueObject.organization ? { UU: valueObject.organization.UU } : undefined,
					Description: valueObject.getStepMessageLong(),
					C_DocType: { UU: valueObject.documentType.UU },
					M_Warehouse: { UU: valueObject.warehouse.UU },
					MovementDate: formatApiDate(valueObject.date),
				},
				M_InventoryLine: {
					M_Inventory: { UU: inventoryUuid },
					AD_Org: valueObject.organization ? { UU: valueObject.organization.UU } : undefined,
					Description: valueObject.getStepMessageLong(),
					M_Product: valueObject.product ? { UU: valueObject.product.UU } : undefined,
					M_AttributeSetInstance: { UU: attributeSetInstanceToUse.UU },
					M_Locator: locatorToUse ? { UU: locatorToUse.UU } : undefined,
					QtyCount: valueObject.quantity || 1,
					QtyBook: (
						await query(valueObject)({
							query: M_StorageOnHandGetDocument,
							variables: {
								Filter: JSON.stringify({
									m_locator: locatorToUse ? { m_locator_uu: locatorToUse.UU } : undefined,
									m_product: valueObject.product ? { m_product_uu: valueObject.product.UU } : undefined,
									m_attributesetinstance: { m_attributesetinstance_uu: attributeSetInstanceToUse.UU },
								}),
							},
						})
					).data.M_StorageOnHandGet.Results.reduce(
						(runningTotal, storageOnHand) => runningTotal + storageOnHand.QtyOnHand,
						0,
					),
					Line: 10,
				},
			},
		})
	).data;

	if (!savedData?.M_InventorySave) {
		throw new Error('Inventory not created');
	}

	valueObject.inventory = savedData?.M_InventorySave;
	valueObject.inventoryLine = savedData?.M_InventoryLineSave;

	if (valueObject.documentAction) {
		valueObject.inventory =
			(
				await mutate(valueObject)({
					mutation: M_InventoryProcessDocument,
					variables: { UU: valueObject.inventory!.UU, DocumentAction: valueObject.documentAction },
				})
			).data?.M_InventoryProcess || undefined;
		if (!valueObject.inventory) {
			throw new Error('Inventory not processed');
		}
	}
}

export async function getBankAccountOfOrganization(valueObject: ValueObject) {
	valueObject.validate();
	if (valueObject.isError) {
		return null;
	}

	return (
		await query(valueObject)({
			query: C_BankAccountGetDocument,
			variables: {
				Size: 1,
				Filter: JSON.stringify({ ad_org: { ad_org_uu: valueObject.organization?.UU }, isactive: true }),
			},
		})
	).data.C_BankAccountGet.Results[0];
}
