//Employee Table
CREATE TABLE Employee (
  employeeId INT PRIMARY KEY,
  email VARCHAR(255) UNIQUE NOT NULL ,
  firstName VARCHAR(50) NOT NULL ,
  lastName VARCHAR(50),
  password VARCHAR(255),
  title VARCHAR(100)
);

//if we want to add primary key after table creation
-- ALTER TABLE employees ADD CONSTRAINT employeeId PRIMARY KEY (Employee);



//Inserting data into Employee table
INSERT INTO Employee (employeeId, email, firstName, lastName, password, title)
VALUES
    (1, 'john.doe@example.com', 'John', 'Doe', 'password123', 'Software Engineer'),
    (2, 'jane.smith@example.com', 'Jane', 'Smith', 'securepass', 'Project Manager'),
    (3, 'bob.jones@example.com', 'Bob', 'Jones', 'pass123', 'Data Analyst');



//Course Table
CREATE TABLE Course (
        courseId INT PRIMARY KEY,
        capacity INT NOT NULL ,
        courseCode VARCHAR(20) UNIQUE NOT NULL ,
        credits INT NOT NULL ,
        description VARCHAR(20),
        name VARCHAR(100) NOT NULL ,
        term VARCHAR(10) NOT NULL ,
        year INT NOT NULL ,
        employeeID INT,
        FOREIGN KEY (employeeID) REFERENCES Employee(employeeId)
);

//Inserting data into Course table
INSERT INTO Course (courseId, capacity, courseCode, credits, description, name, term, year, employeeID)
VALUES
    (1, 30, 'CS101', 3, 'Introduction to Programming', 'Programming Fundamentals', 'Fall', 2023, 1),
    (2, 25, 'MATH202', 4, 'Advanced Statistics', 'Statistical Analysis', 'Spring', 2024, 2),
    (3, 20, 'ART105', 3, 'History of Art', 'Art Through the Ages', 'Fall', 2023, 3);


//alter forign key
ALTER TABLE Course
ADD CONSTRAINT fk_constraint_name
FOREIGN KEY (employeeID)
REFERENCES Employee(employeeId);



//CourseSchedule Table
CREATE TABLE CourseSchedule (
    courseScheduleID INT PRIMARY KEY,
    building VARCHAR(50),
    room VARCHAR(20) NOT NULL ,
    courseCode VARCHAR(20),
    day VARCHAR(10) NOT NULL ,
    time TIME NOT NULL ,
    FOREIGN KEY (courseCode) REFERENCES Course(courseCode)
);

//Inserting data into CourseSchedule table
INSERT INTO CourseSchedule (courseScheduleID, building, room, courseCode, day, time)
VALUES
    (1, 'Science Building', 'Room 101', 'CS101', 'Monday', '10:00:00'),
    (2, 'Mathematics Building', 'Room 201', 'MATH202', 'Wednesday', '14:30:00'),
    (3, 'Art Building', 'Room 105', 'ART105', 'Friday', '13:00:00');



//Specialization Table
CREATE TABLE Specialization (
    specializationID INT PRIMARY KEY,
    code VARCHAR(20) UNIQUE NOT NULL ,
    creditRequired INT NOT NULL ,
    description TEXT,
    name VARCHAR(100) NOT NULL ,
    year INT NOT NULL
);

//Inserting data into Specialization table
INSERT INTO Specialization (specializationID, code, creditRequired, description, name, year)
VALUES
    (1, 'CS', 120, 'Computer Science Specialization', 'Computer Science', 2023),
    (2, 'STAT', 110, 'Statistics Specialization', 'Statistics', 2022),
    (3, 'ART', 100, 'Fine Arts Specialization', 'Fine Arts', 2024);



//Student Table
CREATE TABLE Student (
     studentID INT PRIMARY KEY,
     cgpa FLOAT DEFAULT (0.0) NOT NULL ,
     firstName VARCHAR(50) NOT NULL ,
     lastName VARCHAR(50),
     graduationYear INT,
     email VARCHAR(50) UNIQUE NOT NULL,
     rollNumber VARCHAR(20) UNIQUE NOT NULL ,
     totalCredits INT NOT NULL ,
     specialization_specializationID INT,
     FOREIGN KEY (specialization_specializationID) REFERENCES Specialization(specializationID)
);

//Inserting data into Student table
INSERT INTO Student (studentID, cgpa, firstName, lastName, graduationYear, rollNumber, totalCredits, specialization_specializationID)
VALUES
    (1, 3.75, 'John', 'Doe', 2023, 'CS2023001', 90, 1),
    (2, 3.90, 'Jane', 'Smith', 2022, 'STAT2022001', 100, 2),
    (3, 3.60, 'Bob', 'Jones', 2024, 'ART2024001', 80, 3);



//SpecializationCourse Table
CREATE TABLE SpecializationCourse (
      specializationCourseID INT PRIMARY KEY,
      courseCode INT,
      specializationID INT,
      FOREIGN KEY (courseCode) REFERENCES Course(courseCode),
      FOREIGN KEY (specializationID) REFERENCES Specialization(specializationID)
);


//Inserting data into SpecializationCourse table
INSERT INTO SpecializationCourse (specializationCourseID, courseCode, specializationID)
VALUES
    (1, 1, 1),
    (2, 2, 2),
    (3, 3, 3);



//query to give student for particular course

SELECT s.firstName, s.lastName, s.rollNumber
FROM StudentCourses cs
JOIN Student s ON cs.studentID = s.studentID
JOIN Course c ON cs.courseCode = c.courseCode
WHERE c.employeeID = :employeeId;


//query to give Faculty timetable
select Course.name,courseId,room,time,day,
Specialization.name from Course,Employee,
CourseSchedule,SpecializationCourse,Specialization
where Employee.employeeId=Course.employeeID and
CourseSchedule.coursecourseCode=Course.courseId and
Employee.employeeId=1 and SpecializationCourse.coursecourseCode=Course.courseId and
SpecializationCourse.specializationID=Specialization.SpecializationID;






