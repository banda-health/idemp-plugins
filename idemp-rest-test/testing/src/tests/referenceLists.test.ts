import { referenceListApi } from '../api';
import { referenceUuid, tenderTypeName } from '../models';

test('tender type names to be correct', async () => {
	globalThis.__VALUE_OBJECT__.login();

	const tenderTypes = await referenceListApi.getByReference(
		globalThis.__VALUE_OBJECT__,
		referenceUuid.TENDER_TYPES,
		false,
	);

	// Ensure these exist
	expect(tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.CASH)).not.toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.CHEQUE)).not.toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.CREDIT_OR_DEBIT_CARD)).not.toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.MOBILE_MONEY)).not.toBeUndefined();

	// Ensure these don't exist
	expect(tenderTypes.find((tenderType) => tenderType.name === 'Account')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'Bill Waiver')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'CCC')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'Check')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'Credit Card')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'Debit Card2')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'Jubilee insurance')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'Liason insurance')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'Linda Mama')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'M-Pesa')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'M-TIBA')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'MCH')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'NHIF')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'Outreach')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'PesaPal')).toBeUndefined();

	// Not sure about 'Direct Debit' & 'Debit Card' - should those show up?
});
