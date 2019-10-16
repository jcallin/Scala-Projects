# Boundaries
#### _Designing a functional core with an imperative shell_

This project models a database of users, some of whose subscriptions to our service have expired. The `Sweeper` conducts an audit of the database and emails users whose subscriptions have expired.

### The "functional core" of the system consists of the `ExpiredUsers` functions which make all the decisions about the data.
* These functions can be quickly unit tested because it has no external dependencies and works with basic case class data

### The "imperative shell" of the system consists of the `Sweeper` and to a lesser extent the `UserMailer` objects which have all the dependencies
* These objects are integration tested because they isolate all dependencies
* For the integration test, I have created an internal class `UserDatabase` for simplicity, but it would work the same as any external service
* If I hadn't made a the simple internal database, these tests would deal with a real external database such as Postgres and not mock them