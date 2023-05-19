# Online Book Library Application
My goal is to design and develop an Online Book Library application. This application will be a back-end only application. So no front-end is required. Just creating the REST end-points.
### Entity
##### BookEntity
-  bookId
- bookName
- authorName
 - price
 - quantity
 ##### userEntity
- userId
- firstName
- lastName
- email
- password
- address
- role
## User End Point
### Register User
**Access**:`EVERYONE`
**URL**: `/user/register`
**Method** :`POST`
**Required Body**:
```json
{
    "firstName":"jubayer",
    "lastName":"bin Hedayet",
    "email":"talhajuabyer678@gmail.com",
    "password":"1234",
    "address":"cumilla",
    "role":"ADMIN"
}
```
![1](https://github.com/jubayer051021/Online-Book-Store-Spring-Boot/assets/131146334/712281a3-6a25-4d3c-aebf-028f4cf9e4e0)

### Login  User
**Access**:`EVERYONE`
**URL**: `/user/login`
**Method** :`POST`
**Output**:
## Book End point
### creat Book
**Access**:`Admin`
**URL**: `/books/create`
**Method** :`POST`
**Required Body**:
```json
{
    "bookId":"book-1",
    "bookName":"jubayer-book",
    "authorName":"jubayer",
    "price":1200,
    "quantity":10
}
```
### delete Book
**Access**:`Admin`
**URL**: `/books/delete/{id}`
**Method** :`DELETE`
**Output**:
### update Book
**Access**:`Admin`
**URL**: `/books/update/{id}`
**Method** :`PUT`
**Output**:
### Gets All Books
**Access**:`Admin`, `CUSTOMER`
**URL**: `/books/all`
**Method** :`GET`
**Output**:
### search book using authorName and bookName
**Access**:`Admin`, `CUSTOMER`
**URL**: `/books/author/{authorName}/{bookName}`
**Method** :`GET`
**Output**:
### search book using bookId
**Access**:`Admin`, `CUSTOMER`
**URL**: `/books/id/{bookId}`
**Method** :`GET`
**Output**:

### get book List using authorName
**Access**:`Admin`, `CUSTOMER`
**URL**: `/books/author/{authorName}`
**Method** :`GET`
**Output**:

## Contributors
Thank you to the following contributors who have helped to improve this project:

| Name | Email | Phone| 
| ------ | ------ | ------|
| jubayer Bin hedayet |jubayer.hedayet@bjitacademy.com | 01601006802

