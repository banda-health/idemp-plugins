export const documentStatus = {
	Drafted: 'DR',
	Completed: 'CO',
	Approved: 'AP',
	Invalid: 'IN',
	NotApproved: 'NA',
	Voided: 'VO',
	Reversed: 'RE',
	Closed: 'CL',
	Unknown: '??',
	InProgress: 'IP',
	WaitingPayment: 'WP',
	WaitingConfirmation: 'WC',
} as const;

export type DocumentStatus = typeof documentStatus[keyof typeof documentStatus];

export const documentAction = {
	Complete: 'CO',
	WaitComplete: 'WC',
	Approve: 'AP',
	Reject: 'RJ',
	Post: 'PO',
	Void: 'VO',
	Close: 'CL',
	ReverseCorrect: 'RC',
	ReverseAccrual: 'RA',
	ReActivate: 'RE',
	None: '--',
	Prepare: 'PR',
	Unlock: 'XL',
	Invalidate: 'IN',
} as const;

export type DocumentAction = typeof documentAction[keyof typeof documentAction];
