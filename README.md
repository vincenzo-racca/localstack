# LocalStack Demo Application

This application demonstrates how to use **LocalStack**, a fully functional local AWS cloud emulator. It simulates the core AWS services locally, allowing developers to test and debug their applications without requiring real AWS cloud infrastructure.

---

## What is LocalStack?

LocalStack is a powerful tool for local development and testing of AWS applications. It provides a lightweight and fast alternative to interacting with AWS services by emulating their APIs and behaviors locally. Developers can run their applications using LocalStack without the need for actual AWS credentials or internet access.

**Supported AWS Services:**
- Amazon S3
- Amazon SQS
- Amazon DynamoDB
- Amazon SNS
- Lambda
- And many more...

**Use Cases:**
- Debugging and testing cloud-native applications
- CI/CD pipelines for AWS applications
- Offline development with AWS APIs

---

## Features of this Demo

This demo application showcases how to:
1. Create and interact with an **SQS Queue**.
2. Set up and query a **DynamoDB Table**.
3. Use **Spring Cloud AWS** to interact with SQS and DynamoDB seamlessly.

---

## Prerequisites

1. **Install Docker or Podman:**
   LocalStack runs inside a container. Make sure you have either Docker or Podman installed.

2**Java Development Environment:**
    - JDK 21 or higher

---

## How to Start the Application

### Step 1: Clone the Repository
```bash
git clone https://github.com/your-repository/localstack-demo.git
cd localstack
```

### Step 2: Set Up LocalStack
1. Ensure the `docker-compose.yaml` file is present in the root directory.
2. Start LocalStack using Podman Compose:
   ```bash
   podman compose up -d
   ```

### Step 3: Verify LocalStack is Running
Check the logs to ensure LocalStack has started correctly:
```bash
podman logs localstack
```

### Step 4: Run the Initialization Script
The script `init-aws.sh` will create an SQS Queue and a DynamoDB Table in LocalStack:
```bash
chmod +x config/init-aws.sh
./config/init-aws.sh
```

### Step 5: Build and Run the Java Application
Build the Java application using Maven and run it:
```bash
mvn clean install
java -jar target/localstack-demo.jar
```

### Step 6: Test the Application
Use the application to:
- Send messages to the SQS Queue.
- Query or insert data into the DynamoDB Table.

---

## Stopping the Application
To stop LocalStack and clean up resources:
```bash
podman compose down
```

---

## Additional Resources
- [LocalStack Documentation](https://docs.localstack.cloud/)
- [AWS SDK for Java](https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/)
- [Spring Cloud AWS Documentation](https://spring.io/projects/spring-cloud-aws)

---

Happy coding with LocalStack! 🚀