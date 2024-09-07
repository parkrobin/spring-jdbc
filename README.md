# Spring JDBC Demo

## 1. Overview

This is a demo code using Spring JDBC to connect MySQL database and execute CRUD operations.

## 2. Table Schema 

```sql
CREATE TABLE `test`.`employees`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `age` int NOT NULL,
  PRIMARY KEY (`id`)
);
```

```
mysql> desc employees;
+-------+-------------+------+-----+---------+----------------+
| Field | Type        | Null | Key | Default | Extra          |
+-------+-------------+------+-----+---------+----------------+
| id    | int         | NO   | PRI | NULL    | auto_increment |
| name  | varchar(30) | NO   |     | NULL    |                |
| age   | int         | NO   |     | NULL    |                |
+-------+-------------+------+-----+---------+----------------+
```

## 3. Run

```
 mvn spring-boot:run
```

## 4. Swagger

```
http://localhost:8080/spring/jdbc/swagger-ui/index.html
```

