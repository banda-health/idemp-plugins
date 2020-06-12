# idemp-rest
Exposes iDempiere services via REST (JSON). 

# USAGE: 
 - Generate session token: http://localhost:8080/BHGO/services/rs/auth/session
 - Every request should pass a session token in the Authorization header (i.e Bearer *token*).
 - REST services should have URLS prefixed with /rs/auth/ e.g http://localhost:8080/BHGO/services/rs/auth/patients
 
 If running iDempiere version >= 6.2, run `mvn validate` from the root project to fetch the java-gwt library.
 
 For those running legacy iDempiere versions, download and copy [java-gwt library](https://mvnrepository.com/artifact/com.auth0/java-jwt) to /WEB-INF/lib

