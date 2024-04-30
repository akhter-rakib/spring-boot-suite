### What is GraphQL?

GraphQL is a modern query language and a runtime for APIs
It is built around the concept of **"get exactly what you asked for".**


GraphQL makes it easier to **aggregate data from multiple sources,** and **uses a type system to describe data rather than multiple endpoints**.

In summation, the 3 key characteristics of what makes GraphQL a dream syntax are:
1. Clients can specify exactly what data they need
2. Aggregating data from multiple sources is easy, and
3. GraphQL uses a type system to describe data rather than endpoints.

**_Over the last few years, REST has been used to make new APIs, while the focus of GraphQL has been to optimize for performance and flexibility._**


### **Query & Mutation Type**

GraphQL provides a Query type that can be used whenever you want to query data from your data source.
`type Query {
getAllUsers: [User]
}`
Here the getAllUsers query outputs an array of User objects.

Mutation:
Mutation type that defines entry points for write operations on your GraphQLl server.

`
type Mutation {
addUser(name: String, email: String): User
}`

This GraphQL schema defines a Mutation type that has a single field named addUser.

GraphQL accepts only **one root Query and one root Mutation types,** so we need to bring all the query and mutation operations into the root Types

NOTE: The **“!”** at the end of some fields indicates non-nullable type. If we don’t use it, GraphQL accepts null value in the response.