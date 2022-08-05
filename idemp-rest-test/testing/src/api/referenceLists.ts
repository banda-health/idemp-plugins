import axios from 'axios';
import { DocumentAction, DocumentStatus, DocumentType, ValueObject } from '../models';
import { ReferenceList } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi, IDEMPIERE_ENDPOINT } from './base';

class ReferenceListApi extends BaseApi<ReferenceList> {
	entityName = 'reference-lists';

	async getDocumentStatusActionMap(valueObject: ValueObject) {
		return (
			await axios.get<{
				[documentType in DocumentType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
			}>(`${IDEMPIERE_ENDPOINT}/${this.entityName}/documentStatusActionMap`, this.getAuthorizationHeaders(valueObject))
		).data;
	}
}

export const referenceListApi = new ReferenceListApi();
