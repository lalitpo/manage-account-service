<a name="readme-top"></a>

<br />
<div style="text-align: center;">
  <h3 align="center">Manage-Account</h3>
  <p align="center">
    Manage-Account is a java based implementation of a backend of financial account management system.
    <br />
    <a href="https://github.com/lalitpo/manage-account-service/issues">Report Bug</a> 
  </p>
</div>


<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li><a href="#built-with">Built With</a></li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

The project is a backend of a financial account management system. The users of the system can perform the following

1. As a non-user, client can create a new user account.
2. As a user, client can retrieve the account balance for an existing user. 
3. As a user, client can transfer the money from one user to another user.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Built With

[![My Skills](https://skillicons.dev/icons?i=java)](https://www.oracle.com/java/)
[![My Skills](https://skillicons.dev/icons?i=spring)](https://www.spring.io/)
[![My Skills](https://skillicons.dev/icons?i=maven)](https://maven.apache.org/)
[![My Skills](https://skillicons.dev/icons?i=postgres)](https://www.postgresql.org/)
[![My Skills](https://skillicons.dev/icons?i=docker)](https://www.docker.com/)


<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Getting Started
To correctly import and run this project locally, please follow below guidelines and instructions for smooth development process.

### Prerequisites
As mentioned above in the "Built with" section, please have Java installed on your system.
You can use [homebrew](https://brew.sh) or straightforward Installation from their respective website's homepage.

You can use any IDE like [IntelliJ](https://www.jetbrains.com/idea/), [VS Code](https://code.visualstudio.com), etc.

### Installation

Below is an example of how you can set up the project on your local machine.

1. In your favourite IDE, import/clone the project.
2. Build the project using the following command

    ```
    mvn clean install
    ```
3. Run docker containers for PostgreSQL database.
   Docker containers for each of them are configured in docker-compose.yml file at
   manage-account-infra/docker/docker-compose.yml location.

    ```
    docker-compose -f manage-account-infra/docker/docker-compose.yml up
    ```

4. Install [PostgreSQL](https://www.postgresql.org) on your machine for the database. You don't need an altogether a
   different UI to run queries because your IDE(IntelliJ, VS Code, etc.) will directly give you plugins to access them
   directly from the IDE.
   However, in case, you want a separate UI for it, use [pgAdmin](https://www.pgadmin.org)

5. Run the application by running file : ManageAccountApplication.java located at
   manage-account-app/src/main/java/com/finmid/manageaccountapp/ManageAccountApplication.java

    1. In your favourite REST API client, like [Postman](https://www.postman.com/), you can test below REST APIs to test
       the functionalities of the application.
    2. Sample Requests and detailed information is documented for each REST API in a swagger file manage-account-service.yaml in the root directory. You can access it using Swagger UI or any other Swagger UI compatible tool.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Improvements

An integration testing mechanism to with the calling application (or front end of the messaging application).

## Contact
### Developer :

[Lalit Poddar](mailto:lalit.poddar@gmail.com)  
[![LinkedIn][linkedin-shield]][linkedin-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links --> 
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/lalit-poddar/

