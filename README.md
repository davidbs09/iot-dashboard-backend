# 🚀 IoT Dashboard Backend - Sistema CRUD para Dispositivos IoT

## 📋 Sobre o Projeto

Este é um sistema backend desenvolvido em **Java 21** com **Spring Boot 3.5.4** para gerenciamento completo de dispositivos IoT. O projeto foi criado como parte de um desafio técnico para a **Meta Telecom**, demonstrando habilidades em desenvolvimento backend moderno e arquitetura de sistemas IoT.

### 🎯 Objetivo do Desafio
Desenvolver um CRUD completo para dispositivos IoT com funcionalidades avançadas de dashboard em tempo real, aplicando as melhores práticas de desenvolvimento e arquitetura de software.

## ✨ Funcionalidades Principais

### 📱 **CRUD Completo de Dispositivos IoT**
- ✅ **Criar** dispositivos com validação completa
- ✅ **Listar** todos os dispositivos com paginação
- ✅ **Buscar** dispositivo por ID
- ✅ **Atualizar** informações de dispositivos
- ✅ **Excluir** dispositivos do sistema
- ✅ **Endpoints especializados** para operações IoT

### 📊 **Dashboard Avançado com Estatísticas**
- 📈 **Métricas gerais**: Total, online, offline, ativos, com erro
- 📊 **Distribuição por status**: Análise detalhada dos estados dos dispositivos
- 🔧 **Distribuição por tipos**: Sensores, rastreadores, medidores, etc.
- 🌐 **Conectividade em tempo real**: Uptime, taxa de comunicação, dispositivos irregulares
- 🚨 **Sistema de alertas inteligente**: Detecção automática de problemas

### 🔧 **Recursos Técnicos Avançados**
- 🏗️ **Arquitetura MVC** com separação clara de responsabilidades
- 📝 **Documentação automática** com Swagger/OpenAPI 3
- ✅ **Validação robusta** com Bean Validation
- 🎨 **DTOs bem estruturados** para transferência de dados
- 🔄 **CORS configurado** para integração frontend
- 🗄️ **Banco H2** para desenvolvimento e testes
- 📊 **Console H2** para visualização dos dados

## 🛠️ Tecnologias Utilizadas

### **Backend Core**
- ☕ **Java 21** - LTS mais recente
- 🌱 **Spring Boot 3.5.4** - Framework principal
- 🗃️ **Spring Data JPA** - Persistência de dados
- ✅ **Bean Validation** - Validação de entrada
- 🧰 **Lombok** - Redução de boilerplate

### **Documentação & API**
- 📚 **SpringDoc OpenAPI 2.6.0** - Documentação automática
- 🔧 **Swagger UI** - Interface interativa de testes

### **Banco de Dados**
- 🗄️ **H2 Database** - Banco em memória para desenvolvimento
- 🔧 **H2 Console** - Interface web para gerenciamento

### **Desenvolvimento**
- 🏗️ **Maven** - Gerenciamento de dependências
- 🔄 **Spring Boot DevTools** - Hot reload para desenvolvimento

## 📁 Estrutura do Projeto

```
src/main/java/com/dashboard/crud_iot/
├── 📁 controllers/           # Controladores REST
│   ├── DeviceController.java       # CRUD de dispositivos
│   └── DashboardController.java    # Estatísticas e dashboard
├── 📁 dto/                   # Objetos de Transferência de Dados
│   ├── DeviceCreateDTO.java        # Criação de dispositivos
│   ├── DeviceUpdateDTO.java        # Atualização de dispositivos
│   ├── DeviceResponseDTO.java      # Resposta de dispositivos
│   ├── DashboardStatsDTO.java      # Estatísticas gerais
│   ├── StatusDistributionDTO.java  # Distribuição por status
│   ├── TypeDistributionDTO.java    # Distribuição por tipo
│   ├── ConnectivityStatsDTO.java   # Métricas de conectividade
│   └── DeviceAlertDTO.java         # Alertas do sistema
├── 📁 entities/              # Entidades JPA
│   └── Device.java                 # Entidade principal
├── 📁 enums/                 # Enumerações
│   ├── DeviceType.java             # Tipos de dispositivos
│   └── DeviceStatus.java           # Status dos dispositivos
├── 📁 repositories/          # Camada de dados
│   └── DeviceRepository.java       # Repositório JPA
├── 📁 services/              # Lógica de negócio
│   ├── DeviceService.java          # Serviços de dispositivos
│   └── DashboardService.java       # Serviços de dashboard
├── 📁 config/                # Configurações
│   └── OpenApiConfig.java          # Configuração Swagger
└── CrudLotApplication.java   # Classe principal
```

## 🚀 Como Executar o Projeto

### **Pré-requisitos**
- ☕ **Java 21** instalado
- 🏗️ **Maven 3.8+** instalado
- 🌐 **Navegador web** para acessar documentação

### **1. Clone o Repositório**
```bash
git clone https://github.com/davidbs09/iot-dashboard-backend.git
cd crud-lot__backend
```

### **2. Execute a Aplicação**
```bash
# Compile o projeto
mvn clean compile

# Execute a aplicação
mvn spring-boot:run
```

### **3. Acesse os Recursos**

#### 🌐 **Swagger UI - Documentação Interativa**
```
http://localhost:8080/swagger-ui/index.html
```
- 📚 Documentação completa da API
- 🧪 Teste interativo de todos os endpoints
- 📋 Exemplos de request/response

#### 🗄️ **H2 Console - Gerenciamento do Banco**
```
http://localhost:8080/h2-console
```
**Configurações de conexão:**
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: *(deixe vazio)*

## 📡 Endpoints da API

### **🔧 Dispositivos IoT (DeviceController)**

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/api/devices` | Lista todos os dispositivos |
| `GET` | `/api/devices/{id}` | Busca dispositivo por ID |
| `POST` | `/api/devices` | Cria novo dispositivo |
| `PUT` | `/api/devices/{id}` | Atualiza dispositivo |
| `DELETE` | `/api/devices/{id}` | Remove dispositivo |
| `GET` | `/api/devices/online` | Lista dispositivos online |
| `GET` | `/api/devices/offline` | Lista dispositivos offline |
| `PUT` | `/api/devices/{id}/communication` | Atualiza comunicação |

### **📊 Dashboard e Estatísticas (DashboardController)**

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/api/dashboard/stats/general` | Estatísticas gerais |
| `GET` | `/api/dashboard/stats/by-status` | Distribuição por status |
| `GET` | `/api/dashboard/stats/by-type` | Distribuição por tipo |
| `GET` | `/api/dashboard/stats/connectivity` | Métricas de conectividade |
| `GET` | `/api/dashboard/alerts` | Alertas ativos |

## 🔧 Configurações Importantes

### **application.properties**
```properties
# Configuração do Banco H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Console H2
spring.h2.console.enabled=true

# JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true

# Logging
logging.level.org.hibernate.SQL=DEBUG
logging.level.root=INFO
```

## 📋 Exemplos de Uso

### **1. Criar um Dispositivo**
```json
POST /api/devices
Content-Type: application/json

{
  "deviceName": "Sensor Temperatura - Sala A1",
  "deviceIdentifier": "TEMP-001-A1",
  "deviceType": "TEMPERATURE_SENSOR",
  "description": "Sensor de temperatura para monitoramento da sala A1",
  "location": "Prédio A - Andar 2 - Sala A1",
  "latitude": -23.5505,
  "longitude": -46.6333
}
```

### **2. Obter Estatísticas do Dashboard**
```json
GET /api/dashboard/stats/general

Response:
{
  "totalDevices": 125,
  "onlineDevices": 98,
  "offlineDevices": 27,
  "activeDevices": 112,
  "errorDevices": 3,
  "onlinePercentage": 78.4,
  "availabilityPercentage": 89.6,
  "systemStatus": "HEALTHY",
  "hasCriticalAlerts": false,
  "lastUpdated": "2024-01-15T14:30:00"
}
```

## 🎯 Funcionalidades do Dashboard

### **📊 Métricas Principais**
- **Total de dispositivos** cadastrados
- **Dispositivos online/offline** em tempo real
- **Status dos dispositivos** (ativo, erro, manutenção)
- **Percentuais de disponibilidade** e uptime
- **Status geral do sistema** (Healthy, Warning, Critical)

### **🚨 Sistema de Alertas Inteligente**
- **Detecção automática** de dispositivos offline
- **Classificação por severidade** (Low, Medium, High, Critical)
- **Múltiplos tipos de alerta**:
  - Dispositivo offline
  - Falha de comunicação
  - Erro no dispositivo
  - Manutenção necessária
  - Problema de configuração

### **📈 Análises Avançadas**
- **Distribuição por tipos** de dispositivos
- **Análise de conectividade** (últimos 5 min, 1 hora, hoje)
- **Detecção de comunicação irregular**
- **Métricas de performance** da rede IoT

## 🏗️ Arquitetura e Boas Práticas

### **🎨 Padrões Implementados**
- **MVC (Model-View-Controller)** - Separação clara de responsabilidades
- **DTO Pattern** - Transferência segura de dados
- **Repository Pattern** - Abstração da camada de dados
- **Service Layer** - Lógica de negócio centralizada

### **✅ Validações e Qualidade**
- **Bean Validation** com mensagens customizadas
- **Tratamento de exceções** centralizado
- **Logs estruturados** para debugging
- **Documentação automática** de APIs

### **🔧 Configurações Flexíveis**
- **CORS habilitado** para desenvolvimento frontend
- **Profiles de ambiente** (desenvolvimento/produção)
- **Configurações externalizadas** em properties

## 🚀 Próximos Passos e Melhorias

### **🎯 Funcionalidades Futuras**
- 🔐 **Autenticação e autorização** com Spring Security
- 📦 **Containerização** com Docker
- 📊 **PostgreSQL** para produção
- 🔄 **WebSocket** para atualizações em tempo real
- 📧 **Notificações** por email/SMS para alertas críticos
- 📈 **Métricas avançadas** com Micrometer
- 🔍 **Logging centralizado** com ELK Stack

### **⚡ Otimizações**
- 🗄️ **Cache** com Redis para consultas frequentes
- 📊 **Paginação avançada** com critérios de busca
- 🔄 **Rate limiting** para proteção da API
- 📈 **Monitoramento** com Actuator e Prometheus

## 👨‍💻 Autor

**David Barbosa Santos**
- 🎯 **Objetivo**: Vaga Desenvolvedor Backend Jr - Meta Telecom
- 💼 **LinkedIn**: [David Bissaco da Silva](https://linkedin.com/in/davidbs09)
- 🐙 **GitHub**: [davidbs09](https://github.com/davidbs09)
- 📧 **Email**: davidbissacodasilva@gmail.com

## 📄 Licença

Este projeto foi desenvolvido como parte de um desafio técnico e está disponível para fins educacionais e demonstração de habilidades técnicas.

---

## 🎬 Demonstração em Vídeo

*Em produção - será enviado junto com este projeto demonstrando:*
- ✅ Funcionamento completo do CRUD
- 📊 Dashboard em tempo real
- 🔧 Integração frontend/backend
- 💭 Explicação da arquitetura e decisões técnicas

---

**⭐ Desenvolvido com paixão para a Meta Telecom | Transformando o futuro da conectividade IoT ⭐**
