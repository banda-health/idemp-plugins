export const tenderTypeName = {
	CASH: 'Cash',
	CHEQUE: 'Cheque',
	CREDIT_OR_DEBIT_CARD: 'Credit or Debit Card',
	MOBILE_MONEY: 'Mobile Money',
} as const;

export const paymentRuleValue = {
	CASH: 'B',
	CREDIT_CARD: 'K',
	DIRECT_DEPOSIT: 'T',
	CHECK: 'S',
	ON_CREDIT: 'P',
	DIRECT_DEBIT: 'D',
	MIXED_POS: 'M',
	MOBILE_ACCOUNT: 'A',
	CASH_DRAWER: 'b'
};

