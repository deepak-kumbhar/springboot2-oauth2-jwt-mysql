# springboot2-oauth2-jwt-mysql
Springboot 2, Oauth 2.0, JWT, MySQL example


## Steps to Run

1. Clone the repository

```
git clone https://github.com/deepak-kumbhar/springboot2-oauth2-jwt-mysql.git
```

2. Run the program using maven

```
cd springboot2-oauth2-jwt-mysql
mvn package
java -jar target/springboot2-oauth2-jwt-mysql-0.0.1-SNAPSHOT.jar 
```


## Request and response

1. User springboot2-oauth2.sql to create DB and tables.
2. Admin credentials: 
   - Username: admin
   - Password: password
3. Get access token API.

  - Valid request and user is active.
  
  ```
  URL: http://localhost:8080/oauth/token
  Headers: Basic header. (User: Username - USER_CLIENT_APP ; Password - password)
  Body:
    - grant_type: password
    - username: admin
    - password: password
  Response:
    {
    "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiVVNFUl9DTElFTlRfUkVTT1VSQ0UiLCJVU0VSX0FETUlOX1JFU09VUkNFIl0sInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsicm9sZV9hZG1pbiJdLCJleHAiOjE1ODgwNTI2NzksImF1dGhvcml0aWVzIjpbInJvbGVfYWRtaW4iLCJjYW5fdXBkYXRlX3VzZXIiLCJjYW5fcmVhZF91c2VyIiwiY2FuX2NyZWF0ZV91c2VyIiwiY2FuX2RlbGV0ZV91c2VyIl0sImp0aSI6ImU0MjQyYjRmLTkyZDQtNDcwZC1iYTkyLWE1YzM2ODE2MWE1YSIsImVtYWlsIjoiZGcxMmt1bWJoYXJAZ21haWwuY29tIiwiY2xpZW50X2lkIjoiVVNFUl9DTElFTlRfQVBQIn0.T512tMiVwpukbmOc0Ecwc_36IUI_-X4Z7MvTaE9OGKj9Ux8a7UYrCv2jFgY0zVEi3zntO4rMniG6O467HgGwUOB-9lfXNgqEpsZb9aOaO1MNXZFudowfRknyOdzLUdRC45ISF7gPbah8YgClab6_Z8iuoND5buFNjPFySfv4TJUmCPaHwj-safeEO0lSLCjWya5SpiaxZRHu2QxuqRXASRGyJXAR6P5qbwP5mhlugYB3UU8uYH768PfdIC6-X5P8Lyc42dYMAfEAAnLbkNzsCj5l_FfkRURH3uqrkzw_cNLFfIuUwrHDtfZt6sTugnaHLDhQccPgAoEQuG8KFfpY9g",
    "token_type": "bearer",
    "refresh_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiVVNFUl9DTElFTlRfUkVTT1VSQ0UiLCJVU0VSX0FETUlOX1JFU09VUkNFIl0sInVzZXJfbmFtZSI6ImFkbWluIiwic2NvcGUiOlsicm9sZV9hZG1pbiJdLCJhdGkiOiJlNDI0MmI0Zi05MmQ0LTQ3MGQtYmE5Mi1hNWMzNjgxNjFhNWEiLCJleHAiOjE1ODgwNTUzNzksImF1dGhvcml0aWVzIjpbInJvbGVfYWRtaW4iLCJjYW5fdXBkYXRlX3VzZXIiLCJjYW5fcmVhZF91c2VyIiwiY2FuX2NyZWF0ZV91c2VyIiwiY2FuX2RlbGV0ZV91c2VyIl0sImp0aSI6ImIzOTEyMTdkLTdlZjktNDM2MS1hMmMxLWY4YzMyOGI2NmIwNyIsImVtYWlsIjoiZGcxMmt1bWJoYXJAZ21haWwuY29tIiwiY2xpZW50X2lkIjoiVVNFUl9DTElFTlRfQVBQIn0.cVQ6a5rgtjmJ13bDq-tfanxKzgZvink59z69axBYSuEjUDu5Zi9Hn-N5vXfUWCZweeKKgUzAs5tQ9jTZzqRI-TZClkjNGmSCXgyX9UJQZoziq81ahD_xGi3TQM1QaM4h1j0iAMkxCaVSR6S2Ai9TPmVDDkxCnzHbb2wV99Ami1qEVPz2LH-w9YFK5J8Rb76PsGsMsQQW83XfJguxmSD2Zn_m-rDsdL2gdukvhpOJnz_JPg_ojYVECdIsgxymFW0EJ4vufxtX6e3QiBz-EMnUMJS3jmOcf1WrPGJU4FwrZqH1LjLWeNkNDqpau_BiwMmxO_ajc6WiFXbezRcSGXsYqw",
    "expires_in": 899,
    "scope": "role_admin",
    "email": "dg12kumbhar@gmail.com",
    "jti": "e4242b4f-92d4-470d-ba92-a5c368161a5a"
  }
  ```

  - User account is loacked.
  ```
  {
    "error": "unauthorized",
    "error_description": "User account is locked"
  }
  ```
  - User credentials is expired
  ```
  {
    "error": "unauthorized",
    "error_description": "User credentials have expired"
  }
  ```
  - User account is locked.
  ```
  {
    "error": "unauthorized",
    "error_description": "User account has expired"
  }
  ```
  - User is disabled.
  ```
  {
    "error": "unauthorized",
    "error_description": "User is disabled"
  }
  ```

