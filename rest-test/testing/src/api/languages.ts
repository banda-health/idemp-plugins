import { BaseApi } from '.';
import { Language } from '../types/org.bandahealth.idempiere.rest';

class LanguageApi extends BaseApi<Language> {
	entityName = 'languages';
}

export const languageApi = new LanguageApi();
