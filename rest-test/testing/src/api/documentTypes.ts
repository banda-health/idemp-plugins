import { DocumentType } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class DocumentTypeApi extends BaseApi<DocumentType> {
	entityName = 'document-types';
}

export const documentTypeApi = new DocumentTypeApi();
