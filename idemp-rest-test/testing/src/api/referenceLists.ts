import { DocumentAction, DocumentStatus, DocumentType, ValueObject } from '../models';
import { ReferenceList } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi, IDEMPIERE_ENDPOINT } from './baseApi';

class ReferenceListApi extends BaseApi<ReferenceList> {
	entityName = 'reference-lists';

	async getDocumentStatusActionMap(valueObject: ValueObject) {
		const response = await fetch(`${IDEMPIERE_ENDPOINT}/${this.entityName}/documentStatusActionMap`, {
			method: 'GET',
			headers: this.getAuthorizationHeaders(valueObject),
		});
		if (!response.ok) {
			console.log(response);
			throw new Error(`could not get single ${this.entityName}`);
		}
		const result = await (response.json() as Promise<{
			[documentType in DocumentType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
		}>);
		return result;
	}
}

export const referenceListApi = new ReferenceListApi();
