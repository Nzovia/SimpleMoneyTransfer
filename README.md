# SimpleMoneyTransfer
Task 1 for Pezesha technical tests

The api allows customers to transfer funds from one account to another.

### Entity Relationship
In the simple money transfer we have four entities
1. Base Entity which all other entities inherits common properties.
2. CustomerTransaction entity, a stand alone entity that helps in documenting transaction details
3. Customer and Accounts entity they relate in Many to One Bidirection relationship where a Customer can have one or more accounts.
Customer Entity has customer details whereas Accounts entity hold account details.

### Fig 1. Entity Relationship Diagram

![EntityRelationship](https://github.com/Nzovia/SimpleMoneyTransfer/assets/52350637/bad64ba4-5e95-4d6b-a774-fff7406ea7a6)

### To allow simple money transfer the following end points were implemented.
1. POST http://localhost:8090/api/v1/account/customer - add customer
2. POST http://localhost:8090/api/v1/account          - add customer Account
3. GET http://localhost:8090/api/v1/account/{{accountId}} - get A/C details
4. POST http://localhost:8090/api/v1/transfers            - Make Transfer Request.

The Simple Transfer API has been built in 
        MYSQL 8 database
        Java <java.version>17</java.version>
        SpringBoot <version>3.3.1</version>

#### Running The Code
1. Getting The source Code git clone git@github.com:Nzovia/SimpleMoneyTransfer.git or git clone https://github.com/Nzovia/SimpleMoneyTransfer.git 
2. Wait for some minutes after pull the code for dependencies to update.
3. Open your terminal and execute -> mvn clean, mvn spring-boot:run
4.  package App into deployable jar and skip Tests -> by executing, mvn clean package -DskipTests

### Post Test Results
##### Fig 1. Customer Onboarding
![customer customer](https://github.com/Nzovia/SimpleMoneyTransfer/assets/52350637/daff4f06-9d0b-4750-b0e7-49745d2948f8)
##### Fig 2 Account Creation
![accoun creation](https://github.com/Nzovia/SimpleMoneyTransfer/assets/52350637/558ad1b9-7444-4f31-9e87-278c0c6da7d6)

##### Fig 3 Transfer Processing, Funds evaluation
![more money](https://github.com/Nzovia/SimpleMoneyTransfer/assets/52350637/7ae3d332-f43d-4cba-bdbc-1ad5400ba8a7)

##### Fig 3 Transfer Processing success
![TransactionSuccess](https://github.com/Nzovia/SimpleMoneyTransfer/assets/52350637/ce183515-fcdf-43dd-b209-6c641910d519)



        
