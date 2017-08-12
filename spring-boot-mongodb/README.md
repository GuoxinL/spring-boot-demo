# Spring boot MongoDB

```
use mongo-test
db.createUser({
    user: "mongo",
    pwd: "mongo",
    roles:[
        { role: "readWrite", db: "mongo-test" }
    ]
})
```
