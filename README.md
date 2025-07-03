

# 🚀 Student Management System - Spring Boot + PostgreSQL (Dockerized)

This project is a complete Dockerized Spring Boot backend with PostgreSQL. It includes seed data, a Docker Compose setup, and clear instructions for building, running, and sharing the application.

---

## 📦 Project Structure

```
student-management/
├── src/
├── init-scripts/
│   └── init.sql
├── target/
│   └── student-app.jar
├── Dockerfile
├── docker-compose.yml
├── README.md
```

---

## 🧰 Requirements

* Java 21+
* Docker Desktop
* Maven (optional, for rebuilding JAR)
* Git (for version control)

---

## 🔧 Build and Run the App

### 1️⃣ Build Spring Boot JAR

```bash
./mvnw clean package
# Output: target/student-management-1.0.0.jar
```

### 2️⃣ Dockerfile Setup

```Dockerfile
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/student-management-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### 3️⃣ SQL Seed Data

Create `init-scripts/init.sql`:

```sql
CREATE TABLE IF NOT EXISTS student (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    father_name VARCHAR(100),
    mother_name VARCHAR(100),
    dob DATE
);

INSERT INTO student (id, name, father_name, mother_name, dob) VALUES
(1, 'Narasimha', 'Father1', 'mother1', '2003-10-17'),
(2, 'Narasimha', 'Father1', 'moth1', '2003-10-17');
```

### 4️⃣ Docker Compose Setup

```yaml
services:
  postgres:
    image: postgres
    environment:
      POSTGRES_DB: student_managements
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: XXXXXX
    ports:
      - "5432:5432"
    volumes:
      - pgdata:/var/lib/postgresql/data
      - ./init-scripts:/docker-entrypoint-initdb.d
    networks:
      - app-network

  spring-app:
    build: .
    depends_on:
      - postgres
    ports:
      - "8080:8080"
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://postgres:5432/student_managements
      SPRING_DATASOURCE_USERNAME: postgres
      SPRING_DATASOURCE_PASSWORD: XXXX
    networks:
      - app-network

networks:
  app-network:
    driver: bridge

volumes:
  pgdata:
```

### 5️⃣ Build & Start Services

```bash
docker-compose up --build
```

---

## 💾 Shareable Docker Images (Optional)

### 🔖 Tag Docker Image

```bash
docker tag student_management-spring-app:latest student_management-spring-app:v1.0.0
```

### 📦 Save Docker Images

```bash
docker save -o student-app-v1.0.0.tar student_management-spring-app:v1.0.0
docker save -o postgres.tar postgres:latest
```

### 📤 Share These Files

* `student-app-v1.0.0.tar`
* `postgres.tar`
* `docker-compose.yml`
* `init-scripts/init.sql`
* `README.md`

Then your friend runs:

```bash
docker load -i student-app-v1.0.0.tar
docker load -i postgres.tar
docker-compose up
```

---

## 🧹 Clean Up

```bash
docker-compose down -v
```

---

## 👤 Author

**Narasimha** — Full Stack Java Developer 🚀

