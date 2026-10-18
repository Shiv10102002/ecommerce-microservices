# 🚀 Spring Kafka Microservices

This project demonstrates a real-world microservices architecture built with **Spring Boot** and **Apache Kafka**, focusing on **event-driven communication**, **scalability**, and **service decoupling**.

---

## 🏗️ Architecture

The system is composed of multiple independent microservices:

- 🧑‍💼 Customer Service
- 📦 Product Service
- 🛒 Order Service
- 💰 Billing Service
- 🚚 Logistics Service

All services communicate asynchronously through **Apache Kafka**, ensuring loose coupling and high scalability.

> 📌 Event-driven architecture using Kafka topics for inter-service communication.

---

## 🖼️ Architecture Diagram

<!-- Coloque sua imagem aqui -->
![desenho+de+solucao](https://github.com/user-attachments/assets/71a3e6da-9c1a-4fef-aa57-1dfe7048de50)

---

## ⚙️ Tech Stack

- Java 17
- Spring Boot
- Apache Kafka
- Docker & Docker Compose
- PostgreSQL
- MinIO (S3 compatible storage)
- JasperReports

---

## 🚀 How to Run

### Prerequisites

- Docker
- Docker Compose
- Java 17

---

## 🔁 Event Flow Example

1. Order is created in Order Service
2. Event is published to Kafka
3. Billing Service consumes the event
4. Logistics Service processes delivery
5. System remains loosely coupled and scalable

---

## 📌 Features

- Event-driven architecture with Kafka
- Microservices with independent databases
- Asynchronous communication
- File storage with MinIO
- Report generation with JasperReports

---

## 🧪 API Documentation

Swagger UI available at:

http://localhost:{port}/swagger-ui.html

---

## 💡 Key Concepts Applied

- Microservices Architecture
- Event-Driven Design
- Database per Service
- Asynchronous Messaging
- Containerization with Docker

---

## 📈 Future Improvements

- Add authentication (OAuth2 / JWT)
- Implement API Gateway
- Add observability (Prometheus + Grafana)
- Deploy to cloud (AWS / Kubernetes)

---

## 👨‍💻 Author

Developed by Harlan Goyana
- GitHub: https://github.com/hvalmer
- LinkedIn: https://www.linkedin.com/in/harlan-goyana-83ba42125/


### Steps

```bash
# Clone repository
git clone https://github.com/hvalmer/spring-kafka-microservices.git

# Enter project
cd spring-kafka-microservices

# Run infrastructure (Kafka, DB, etc.)
docker-compose up -d

# Run services (via IDE or Maven)
# -spring-kafka-microservices
Arquitetura orientanda a eventos, robusta e preparada para o mundo real.


