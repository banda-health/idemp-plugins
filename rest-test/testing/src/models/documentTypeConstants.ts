export const documentBaseType = {
	AdReferenceId: 183,
	GLJournal: 'GLJ',
	GLDocument: 'GLD',
	APInvoice: 'API',
	APPayment: 'APP',
	ARInvoice: 'ARI',
	ARReceipt: 'ARR',
	SalesOrder: 'SOO',
	ARProFormaInvoice: 'ARF',
	MaterialDelivery: 'MMS',
	MaterialReceipt: 'MMR',
	MaterialMovement: 'MMM',
	PurchaseOrder: 'POO',
	PurchaseRequisition: 'POR',
	MaterialPhysicalInventory: 'MMI',
	APCreditMemo: 'APC',
	ARCreditMemo: 'ARC',
	BankStatement: 'CMB',
	CashJournal: 'CMC',
	PaymentAllocation: 'CMA',
	MaterialProduction: 'MMP',
	MatchInvoice: 'MXI',
	MatchPO: 'MXP',
	ProjectIssue: 'PJI',
	MaintenanceOrder: 'MOF',
	ManufacturingOrder: 'MOP',
	QualityOrder: 'MQO',
	Payroll: 'HRP',
	DistributionOrder: 'DOO',
	ManufacturingCostCollector: 'MCC',
	FixedAssetsAddition: 'FAA',
	FixedAssetsDisposal: 'FAD',
	FixedAssetsDepreciation: 'FDP',
} as const;

export type DocumentBaseType = (typeof documentBaseType)[keyof typeof documentBaseType];

export const documentSubTypeInventory = {
	AdReferenceId: 200068,
	PhysicalInventory: 'PI',
	InternalUseInventory: 'IU',
	CostAdjustment: 'CA',
};

export type DocumentSubTypeInventory = (typeof documentSubTypeInventory)[keyof typeof documentSubTypeInventory];

export const documentSubTypeSalesOrder = {
	AdReferenceId: 148,
	OnCreditOrder: 'WI',
	POSOrder: 'WR',
	WarehouseOrder: 'WP',
	StandardOrder: 'SO',
	Proposal: 'ON',
	Quotation: 'OB',
	ReturnMaterial: 'RM',
	PrepayOrder: 'PR',
};

export type DocumentSubTypeSalesOrder = (typeof documentSubTypeSalesOrder)[keyof typeof documentSubTypeSalesOrder];
