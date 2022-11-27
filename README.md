# digitalBankPracticeProject
This is a practice project with the aim of building a digital bank
The project comprise three five entity classes with three tables
1. The BankAccount class encapsulate two additional entities to form a single table relationship using hibernate
single-table inheritance with SavingAccount and CurrentAccount entity classes.
The BankAccount class has a Many-To-One relationship with both the Customer and AccountOperation class

2. The Customer class has a One-To-Many relationship with the BankAccount class
3. The AccountOperation class has a One-To-Many relationship with the BankAccount class also
4. All the three classes(AccountOperation, BankAccount, Customer) has their own repository interface to easily communicate
with the database through JPA persistence layer.

5. All the classes inherits their ID fields from the AccessMe super class which is an abstract class.
6. All three persisted entity classes has their corresponding DTO classes
7. There's a test class attach for demonstrating this practice project


Coded by Ousmane and Review by Atalib 😍
