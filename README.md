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


Certainly! Here’s the section specifically for "Using Kafka on Windows":

---

## Using Kafka on Windows

### Issue with Local Language Detection

I encountered a problem with Kafka on Windows where it appeared to detect the local language as Turkish during startup, which affected its operation. This issue was observed with Kafka version 3.8.0 and previous ones (Also on MacOS, but little bit different error messages)

### Solution

To resolve this issue:

1. **Edit the Kafka Startup Script**

    - Open the `kafka-server-start.bat` file located in the `.bin/windows` directory using Notepad.
    - Add the following line at the beginning of the file, just above the lines:
      ```batch
      set "JAVA_OPTS=-Duser.language=en -Duser.country=US"
      ```
    - This should be placed above the line:
      ```batch
      "%~dp0kafka-run-class.bat" kafka.Kafka %*
      ```

2. **Set Environment Variable**

   If editing the `.bat` file does not resolve the issue, set an environment variable:

    - Open Environment Variables settings.
    - Add a new environment variable:
        - **Variable name:** `JAVA_TOOL_OPTIONS`
        - **Variable value:** `-Duser.language=en -Duser.country=US`

3. **Apply Changes**

    - Close and reopen Command Prompt as an administrator.
    - Navigate to the Kafka directory and start Kafka again.

This solution resolved the issue for me and allowed Kafka to start properly.










