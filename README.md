## Uso de servicios

A continuación se describen los endpoints principales disponibles en la API para la gestión de clientes, fondos y suscripciones.

### 1. Servicios

Permite registrar un nuevo cliente en la plataforma.

**Endpoint**
```http
POST /btg-investment-funds/api/v1/clients  Crear Cliente
{
  "name": "Juan Manuel",
  "email": "juan@gmail.com",
  "phone": "0573155081009",
  "notificationPreference": "SMS"
}

GET /btg-investment-funds/api/v1/funds     Consultar Fondos


POST /btg-investment-funds/api/v1/subscriptions/subscribe    Crear Suscripcion 
{
  "clientId": "69b773f022590e4f075ed1c5",
  "fundId": "69b7729822590e4f075ed1c0"
}

POST /btg-investment-funds/api/v1/subscriptions/cancel     Cancelar Suscripcion
{
  "clientId": "69b5d3e155b8cb704448b38d",
  "fundId": "0e439f33-1b47-447b-bd40-dd400520329f"
}

GET /btg-investment-funds/api/v1/transactions/69b773f022590e4f075ed1c5   Consultar Transacciones por idCliente
