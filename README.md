<a id="readme-top"></a>

# Lost Pets Website

<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#contributors">Contributors</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

## About The Project

![project-image](_docs/title.png)

This project helps users to efficiently find and report lost pets. The platform allows pet owners and finders to connect through a user-friendly interface.

### Built With

- [Spring Boot 3.4.1](https://spring.io) - Framework for building Java-based applications  
- [MySQL 9.0](https://www.mysql.com/) - Relational Database Management System  
- [OpenJDK 17](https://openjdk.java.net/) - Java Development Kit  
- [Spring Boot Security 3.4.1](https://spring.io/projects/spring-security) - Security framework for authentication and authorization  
- [Spring Boot DevTools 3.4.1](https://spring.io) - Tools for development and debugging  
- [Spring Reactive Web 3.4.1](https://spring.io/projects/spring-webflux) - Web framework for reactive programming  
- [Spring Web 3.4.1](https://spring.io/projects/spring-web) - Web framework for RESTful APIs  
- [Thymeleaf 3.1.1](https://www.thymeleaf.org/) - Server-side template engine for web applications  
- [Lombok 1.18.28](https://projectlombok.org/) - Library for reducing boilerplate code  
- [Spring Data JPA 3.4.1](https://spring.io/projects/spring-data-jpa) - Data access abstraction layer  
- [MySQL Connector Java 8.0.33](https://dev.mysql.com/downloads/connector/j/) - JDBC driver for MySQL  

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Getting Started

### Prerequisites

- Open JDK [Download](https://www.oracle.com/kr/java/technologies/downloads/)
- MySQL Server 9.0 [Download](https://dev.mysql.com/downloads/)

<!-- INSTALLATION -->
### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/DireRaven22075/lost-pets-website.git
   cd lost-pets-website
   ```
2. Install dependencies:
   ```bash
   ./gradlew build
   ```
3. Run the application:
   ```bash
   java -jar build/libs/lost-pets-0.0.1-SNAPSHOT.jar
   ```
4. Open a browser and navigate to:
   ```
   http://localhost:8080
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTRIBUTORS -->
## Contributors

- [김민성(kongkang123123)](https://github.com/kongkang123123)
  - Role: Team Leader
  - Depart: Back-END
    1. Develop Interceptor
    2. Develop Comment API
    3. Debugging API System
- [한윤수(DireRaven22075)](https://github.com/DireRaven22075)
  - Role: Develop Manager
  - Depart: Full-Stack
    1. Manage Git Repository
    2. Develop Database
    3. Develop Security Core System
    4. Develop JPA, JDBC
    5. Debugging FILE IO
- [이예호(yecongE)](https://github.com/yecongE)
  - Design Manager
  - Depart: Front-END
    1. Develop HTTP REST REQUEST
    2. Convert pages to Thymeleaf Template
    3. Design builtin board & accounts (login / sign up) Page
- [박상인(C0BlA)](https://github.com/C0BlA)
  - Depart: Back-END
    1. Develop Board Posting Rest API
    2. Develop File IO System
    3. Develop Posting & Reply API
- [김다민(kdm0927)](https://github.com/kdm0927)
  - Depart: Front-END
    1. Design and Develop pages
    2. Design Error Page
- [이예솔(ieeyesoi)](https://github.com/ieeyesoi)
  - Depart: Front-END
    1. Design and Develop pages
    2. Design Post & Main Page

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- LICENSE -->
## License

This project is developed using the following libraries and programs. Each library adheres to its respective license terms.

### Libraries and Programs Used with Their Licenses:
- **MySQL**: [GPL v2 with FOSS License Exception](https://www.mysql.com/about/legal/licensing/foss-exception/)
- **Spring Boot**: [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)
- **OpenJDK 17**: [GPL v2 with Classpath Exception](https://openjdk.java.net/legal/gplv2+ce.html)
- **Spring Boot Security**: [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)
- **Spring Boot DevTools**: [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)
- **Spring Reactive Web**: [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)
- **Spring Web**: [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)
- **Thymeleaf**: [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)
- **Lombok**: [MIT License](https://github.com/projectlombok/lombok/blob/master/LICENSE)
- **Spring Data JPA**: [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)
- **MySQL Connector Java**: [GPL v2 with FOSS License Exception](https://www.mysql.com/about/legal/licensing/foss-exception/)

The license of this project itself can be chosen freely. However, when using this project, you must comply with the individual licenses of the libraries listed above.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTACTS -->
## Contacts

- 김민성 - 팀장 : [rjaehno2@naver.com](mailto:rjaehno2@naver.com)
- 한윤수 - DB : [direraven22075@gmail.com](mailto:direraven22075@gmail.com), [gskids053@chungbuk.ac.kr](mailto:gskids053@chungbuk.ac.kr)
- 박상인 - Back-END : [cobia9e@gmail.com](mailto:cobia9e@gmail.com), [2021041009@chungbuk.ac.kr](mailto:2021041009@chungbuk.ac.kr)
- 이예호 - Front-END : [yeho0821@naver.com](mailto:yeho0821@naver.com), [yeconge0821@gmail.com](mailto:yeconge0821@gmail.com)
- 김다민 - Front-END : [kimdm5112@gmail.com](mailto:kimdm5112@gmail.com), [rlaekals585@chunguk.ac.kr](mailto:rlaekals585@chunguk.ac.kr)
- 이예솔 - Front-END : [yesol4138@naver.com](mailto:yesol4138@naver.com), [yesol4138@chungbuk.ac.krÏ](mailto:yesol4138@chungbuk.ac.krÏ)
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ACKNOWLEDGEMENTS -->
## Acknowledgments

- Do it! 점프 투 스프링부트3, 박응용, 이지스퍼블리싱
- Java의 정석, 남궁성, 도우출판
- Do it! HTML+CSS+자바스크립트 웹 표준의 정석 ━ 전면 개정판, 고경희, 이지스퍼블리싱
- Do it! MySQL로 배우는 SQL 입문, 강성욱, 이지스퍼블리싱
- 처음부터 제대로 배우는 스프링 부트, 마크 헤클러, 오서영(번역), 한빛미디어

<p align="right">(<a href="#readme-top">back to top</a>)</p>
