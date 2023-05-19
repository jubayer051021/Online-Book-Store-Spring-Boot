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
##  User End Point
### 1. Register User
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

### 2. Login  User
**Access**:`EVERYONE`
**URL**: `/user/login`
**Method** :`POST`

**Output**:

![2](https://github.com/jubayer051021/Online-Book-Store-Spring-Boot/assets/131146334/9507c8cf-60f5-4970-93dc-180846e9d9f0)

## Book End point
### 3. creat Book
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
![3](https://github.com/jubayer051021/Online-Book-Store-Spring-Boot/assets/131146334/7ebcb56c-fdab-4d28-ad7b-570f471bcafb)

### 4. delete Book
**Access**:`Admin`
**URL**: `/books/delete/{id}`
**Method** :`DELETE`

**Output**:
![8](https://github.com/jubayer051021/Online-Book-Store-Spring-Boot/assets/131146334/e47f437d-4c5e-4127-ad68-fcf83f447a94)

### 5. update Book
**Access**:`Admin`
**URL**: `/books/update/{id}`
**Method** :`PUT`

**Output**:
![9](https://github.com/jubayer051021/Online-Book-Store-Spring-Boot/assets/131146334/4e76312c-f1b3-45d1-84fc-c280efc27be3)

### 6. Gets All Books
**Access**:`Admin`, `CUSTOMER`
**URL**: `/books/all`
**Method** :`GET`

**Output**:
![5](https://github.com/jubayer051021/Online-Book-Store-Spring-Boot/assets/131146334/d797c5e2-73ad-4a0d-b38a-f3080f87dfe1)

### 7. search book using authorName and bookName
**Access**:`Admin`, `CUSTOMER`
**URL**: `/books/author/{authorName}/{bookName}`
**Method** :`GET`

**Output**:
![6](https://github.com/jubayer051021/Online-Book-Store-Spring-Boot/assets/131146334/3d300743-3067-4083-b308-ac266021f4ef)

### 8. search book using bookId
**Access**:`Admin`, `CUSTOMER`
**URL**: `/books/id/{bookId}`
**Method** :`GET`

**Output**:
![4](https://github.com/jubayer051021/Online-Book-Store-Spring-Boot/assets/131146334/247fc175-7e01-418e-b47c-ba9bf53fa2d5)

### 9. get book List using authorName
**Access**:`Admin`, `CUSTOMER`
**URL**: `/books/author/{authorName}`
**Method** :`GET`

**Output**:
![7](https://github.com/jubayer051021/Online-Book-Store-Spring-Boot/assets/131146334/a8f8eb3d-2531-4997-b4fb-0f7474b7e16b)

## Contributors
| Name | Email | Phone| 
| ------ | ------ | ------|
| jubayer Bin hedayet |jubayer.hedayet@bjitacademy.com | 01601006802

