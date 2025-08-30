\# Day 3 - User Registration with Database \& Response Codes



\## 🔨 What I Implemented

1\. \*\*UserRepository\*\*  

&nbsp;  - Introduced `UserRepository` interface extending `JpaRepository` for database operations.  

&nbsp;  - Moved from in-memory HashMap storage to PostgreSQL database.  



2\. \*\*Endpoints with Response Codes\*\*  

&nbsp;  - Converted all controller methods to return `ResponseEntity` with proper HTTP status codes.  

&nbsp;    - `POST /api/users/register` → `201 CREATED`  

&nbsp;    - `GET /api/users/{id}` → `200 OK`  

&nbsp;    - `GET /api/users` → `200 OK`  

&nbsp;    - `POST /api/users/login` → `200 OK` / `401 UNAUTHORIZED`  

&nbsp;    - `GET /api/users/profile/{id}` → `200 OK`  



3\. \*\*Custom Exceptions\*\*  

&nbsp;  - `UserAlreadyExistsException` for duplicate users.  

&nbsp;  - Basic exception handling (to be improved in later days).  



---



\## 📚 What I Learned

\- How to use \*\*Spring Data JPA\*\* (`JpaRepository`) for persistence.  

\- Difference between returning `DTO` vs `ResponseEntity<DTO>`.  

\- Importance of HTTP status codes (`201`, `200`, `401`, etc.).  

\- Why custom exceptions are needed and how to define them.  



---



\## ✅ Next Steps (Day 4 Ideas)

\- Implement \*\*Global Exception Handling\*\* using `@ControllerAdvice`.  

\- Add \*\*validation\*\* for user input (`@NotNull`, `@Email`, etc.).  

\- Encrypt user password before saving (e.g., `BCryptPasswordEncoder`).  

\- Explore `ResponseWrapper` class for consistent API responses.



