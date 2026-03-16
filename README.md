# BTG Investment Funds Microservice

## Descripción
Este proyecto es un microservicio para la gestión de fondos de inversión. Proporciona endpoints para manejar transacciones, suscripciones, fondos y clientes.

## Endpoints y Servicios

URL Ruta de dominio:  https://btg-investment-funds-ms-2.onrender.com/btg-investment-funds/api/v1

### 1. **TransactionController**
   - **IDprueba:** 69b773f022590e4f075ed1c5
   - **Endpoint:** `/transactions/{clientId}`
   - **Método:** `GET`
   - **Descripción:** Obtiene el historial de transacciones de un cliente específico.
   - **Datos necesarios:** `clientId` (ID del cliente).
   - **Entidad involucrada:** `TransactionFundResponseDTO`.

### 2. **FundSubscriptionController**
   - **Endpoint:** `/subscriptions/subscribe`
     - **Método:** `POST`
     - **Descripción:** Crea una nueva suscripción a un fondo.
     - **Datos necesarios:** `SubscriptionRequestDTO`.
     - **Entidad involucrada:** `SubscriptionResponseDTO`.

     **Ejemplo:**
     ```json
     {
       "clientId": "69b773f022590e4f075ed1c5",
       "fundId": "69b7729822590e4f075ed1c0"
     }
     ```

   - **Endpoint:** `/subscriptions/cancel`
     - **Método:** `POST`
     - **Descripción:** Cancela una suscripción existente.
     - **Datos necesarios:** `SubscriptionRequestDTO`.
     - **Entidad involucrada:** `SubscriptionResponseDTO`.

     **Ejemplo:**
     ```json
     {
       "clientId": "69b773f022590e4f075ed1c5",
       "fundId": "69b7729822590e4f075ed1c0"
     }
     ```

### 3. **FundController**
   - **Endpoint:** `/funds`
     - **Método:** `GET`
     - **Descripción:** Obtiene la lista de todos los fondos disponibles.
     - **Datos necesarios:** Ninguno.
     - **Entidad involucrada:** `FundResponseDTO`.
   - **Endpoint:** `/funds/{id}`
     - **Método:** `GET`
     - **Descripción:** Obtiene los detalles de un fondo específico.
     - **Datos necesarios:** `id` (ID del fondo).
     - **Entidad involucrada:** `FundResponseDTO`.

### 4. **ClientController**
   - **Endpoint:** `/clients`
     - **Método:** `POST`
     - **Descripción:** Crea un nuevo cliente.
     - **Datos necesarios:** `ClientRequestDTO`.
     - **Entidad involucrada:** `ClientResponseDTO`.

### Ejemplo de creación de cliente

A continuación, se muestra un ejemplo de los datos necesarios para crear un cliente utilizando el servicio de clientes:

```json
{
  "name": "Juan Manuel",
  "email": "juan@gmail.com",
  "phone": "0573155081009",
  "notificationPreference": "SMS"
}
```

## Modelos

### 1. **Transaction**
   - **Colección:** `transactions`
   - **Atributos:**
     - `id` (String): Identificador único de la transacción.
     - `clientId` (String): Identificador del cliente asociado.
     - `fundId` (String): Identificador del fondo involucrado.
     - `type` (String): Tipo de transacción (e.g., compra, venta).
     - `amount` (Double): Monto de la transacción.
     - `date` (LocalDateTime): Fecha y hora de la transacción.

### 2. **Subscription**
   - **Colección:** `subscriptions`
   - **Atributos:**
     - `id` (String): Identificador único de la suscripción.
     - `clientId` (String): Identificador del cliente asociado.
     - `fundId` (String): Identificador del fondo suscrito.
     - `amount` (Double): Monto de la suscripción.
     - `status` (String): Estado de la suscripción (e.g., activa, cancelada).
     - `openingDate` (LocalDateTime): Fecha de apertura de la suscripción.

### 3. **Fund**
   - **Colección:** `funds`
   - **Atributos:**
     - `id` (String): Identificador único del fondo.
     - `name` (String): Nombre del fondo.
     - `minimumAmount` (Double): Monto mínimo requerido para invertir.
     - `category` (String): Categoría del fondo (e.g., renta fija, renta variable).

### 4. **Client**
   - **Colección:** `clients`
   - **Atributos:**
     - `id` (String): Identificador único del cliente.
     - `name` (String): Nombre del cliente.
     - `email` (String): Correo electrónico del cliente.
     - `phone` (String): Teléfono del cliente.
     - `balance` (Double): Saldo disponible del cliente.
     - `notificationPreference` (String): Preferencia de notificación (e.g., email, SMS).

## Requisitos
- **Java 11 o superior**.
- **Spring Boot**.
- **MongoDB** como base de datos.

## Ejecución
1. Clonar el repositorio.
2. Configurar las credenciales de MongoDB en `application.properties`.
3. Ejecutar el comando:
   ```bash
   ./mvnw spring-boot:run
   ```
