# Spring Boot and Kafka Integration

This project demonstrates how to integrate Apache Kafka with a Spring Boot application. It covers Kafka producer, consumer, and topic configuration. Below is a brief overview of the key components and their roles.

## Components

### 1. **Kafka Producer**

**`ProducerConfiguration`**

- Configures Kafka producer settings.
- Sets the Kafka broker address (`kafka.server`) and serializers for key and value.

**`Publisher`**

- Provides functionality to send messages to a Kafka topic.
- Uses `KafkaTemplate` to send messages to the topic named `"addTopic"`.

### 2. **Kafka Consumer**

**`ConsumerConfiguration`**

- Configures Kafka consumer settings.
- Sets the Kafka broker address (`kafka.server`) and deserializers for key and value.
- Defines the Kafka consumer group ID as `"group1"`.

**`Consumer`**

- Listens to messages from the Kafka topic `"addTopic"`.
- Prints received messages to the console.

### 3. **Kafka Topic Configuration**

**`KafkaConfig`**

- Configures KafkaAdmin with the broker address (`kafka.server`).
- Defines a new Kafka topic named `"appTopic"` with 1 partition and 1 replication factor.

### 4. **Spring Boot Application**

**`DemoApplication`**

- The entry point of the Spring Boot application.
- Uses `ApplicationRunner` to send a test message ("Hello") to Kafka on application startup.

## Configuration

- **Kafka Server:** Set the Kafka broker address in `application.properties` as `kafka.server=localhost:9092`.
- **Topic Names:** Ensure that the topic names used in `Consumer` and `Publisher` are consistent (`"addTopic"`).

## Usage

1. **Run the Application:** Start the Spring Boot application.
2. **Send a Message:** The `ApplicationRunner` bean sends a test message to the Kafka topic.
3. **Consume Messages:** The `Consumer` listens to messages from the specified topic and prints them to the console.

## Notes

- Make sure that the Kafka broker is running and accessible at `localhost:9092`.
- Check Kafka and application logs for any issues with message production or consumption.
