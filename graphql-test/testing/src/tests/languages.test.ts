import { Ad_LanguageGetDocument, SignInDocument } from '../__generated__/graphql';
import { initialLoginData, mutate, query } from '../api';

test('Portuguese (pt_BR) is available as a login language', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const { data } = await query(valueObject)({
		query: Ad_LanguageGetDocument,
	});

	const languages = data.AD_LanguageGet.Results;
	const portuguese = languages.find((lang) => lang.AD_Language === 'pt_BR');

	expect(portuguese).toBeTruthy();
	expect(portuguese?.AD_Language).toBe('pt_BR');
	expect(portuguese?.IsLoginLocale).toBe(true);
	expect(portuguese?.IsSystemLanguage).toBe(true);
});

test('can sign in with Portuguese (pt_BR) language', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const signInResult = await mutate(valueObject)({
		mutation: SignInDocument,
		variables: {
			Credentials: { ...initialLoginData, AD_Language: 'pt_BR' },
		},
	});

	expect(signInResult.data?.SignIn?.AD_User).toBeTruthy();
});
