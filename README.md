[![Maven - >=3.8.5](https://img.shields.io/badge/Maven->=3.8.5-blue?logo=Apache+Maven)](https://maven.apache.org/)
[![Tomcat - >=3.8.5](https://img.shields.io/badge/Tomcat->=10-blue?logo=Apache+Tomcat&logoColor=F8DC75)](https://tomcat.apache.org/)
[![](https://gitlab.com/fu-kiennt-fall22/se1627-net_swp391/g6/badges/main/pipeline.svg)](https://gitlab.com/fu-kiennt-fall22/se1627-net_swp391/g6/-/pipelines)
## Trainning support system
Online education support system and course management

## Description
This is a project for SE1627 - Software Engineering Practice course at FPT University. The project is a web application that supports online education and course management.


## Installation

### Prerequisites
- [Maven](https://maven.apache.org/)
- [Tomcat](https://tomcat.apache.org/)
- [MySQL](https://www.mysql.com/)
- [Git](https://git-scm.com/)

### Clone the repository
Make sure you have generated ssh key and added it to your gitlab account. Then clone the project to your local machine.
```
git clone git@gitlab.com:fu-kiennt-fall22/se1627-net_swp391/g6.git
git checkout main
```

### Setup database
- Import the database from `/training_support_system.sql` to your MySQL server.
- Open the project in your IDE and edit the database connection in `src/main/resources/db.properties` file.

### Build and run
- Build and run the project with maven

Make sure you have installed maven and added it to your environment variables. Then run the following command in the project directory.

Edit tomcat username and password in pom.xml
```
mvn clean package
mvn tomcat7:deploy
```
- Build and run the project with Apache Netbeans 13
```
Right click on the project -> Run
```

## Usage
- Open your browser and go to `http://localhost:8080`

## Roadmap
- [x] Login and register
- [x] Role and permission
- [x] Course management
- [x] User management
- [x] Quiz management

## Contributing
For major changes, please open an issue first to discuss what you would like to change.
Don't forget to update tests as appropriate.

## Authors and acknowledgment
- [Nguyễn Văn Cao Kỳ](https://gitlab.com/nguyenvancaokyfpt) - Team leader
- [Lại Thế Đạt](https://gitlab.com/datlthe161533)
- [Nguyễn Hữu Đại](https://gitlab.com/dainhhe161719)
- [Phạm Tuấn Anh](https://gitlab.com/anhpthe141213)
- [Lê Hoàng](https://gitlab.com/hoanglhe140496)


## License
[Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)

## Project status
This project is still in development.
