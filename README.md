# IP Quiz System
developed to help students practice for the ITPEC IP Exam 

## Features
### Two User Types:

- **Admin:**
  - Login securely
  - Manage quiz questions (add, edit, delete, update)
  - View student test histories

- **Student:**
  - Take quizzes
  - View total marks at the end of the test

### Algorithms Used:

- **Merge Sort (Descending Order):**
  - Used to sort students' scores from highest to lowest.

- **Linear Search:**
  - Used to search students by gender, name, semester, class, roll number, and email.

## Tech Stack

- **Programming Language:** Java (using JFrame for GUI)
- **Database:** MySQL
- **IDE:** NetBeans

### Libraries Needed:
- `commons-dbutils-1.8.1-bin.zip`
- `mysql-connector-java-5.1.43.zip`

## How to Run

1. Clone or download the project.
2. Import the project into NetBeans.
3. Add the following libraries to the project:
commons-dbutils-1.8.1
mysql-connector-java-5.1.43
4. Set up your MySQL database using the SQL queries provided below.
5. Configure database connection settings if required.
6. Run the project!

## Database Setup

Run the following SQL queries to set up the database:

```sql
CREATE DATABASE quiz;
USE quiz;

CREATE TABLE question (
    id INT(10),
    name VARCHAR(500),
    opt1 VARCHAR(500),
    opt2 VARCHAR(500),
    opt3 VARCHAR(500),
    opt4 VARCHAR(500),
    answer VARCHAR(500)
);

CREATE TABLE student (
    rollNo VARCHAR(20),
    name VARCHAR(100),
    gender VARCHAR(20),
    section VARCHAR(20),
    semester VARCHAR(20),
    contactNo VARCHAR(20),
    email VARCHAR(100),
    marks INT(5),
    isSubmitted BOOLEAN DEFAULT FALSE
);
