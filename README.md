# Item Detail API: API de Produtos e Pagamentos

Este é um projeto teste Spring Boot que simula uma API para retornar informações detalhadas sobre um produto, com dados carregados de um arquivo JSON. Ele inclui documentação OpenAPI/Swagger UI e testes unitários.

---

## 🚀 Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3.4.6**
* **Maven**
* **Spring Web** (para construir a API REST)
* **springdoc-openapi** (para documentação Swagger UI)
* **JUnit 5** e **Mockito** (para testes)
* **Jackson** (para serialização/desserialização JSON)

---

## 🛠️ Pré-requisitos

Para executar este projeto, você precisará ter instalado em sua máquina:

* **Java Development Kit (JDK) 21** ou superior.
* **Apache Maven 3.x** ou superior.

---

## 📦 Como Executar o Projeto

Siga os passos abaixo para executar a API:

### 1. Clonar o repositório

```bash
git clone https://github.com/alana-brolezzi/item.detail.api.git
```

### 2. Compilar e executar

Abra um terminal no diretório do projeto e execute os seguintes comandos:

```bash
# Limpa, compila e empacota o projeto em um JAR executável
mvn clean install

# Navegue para o diretório 'target' onde o JAR foi gerado
cd target

# Execute o JAR (o nome do arquivo JAR pode variar)
java -jar item.detail.api-0.0.1-SNAPSHOT.jar
```

## 🌐 Endpoints da API
A API estará disponível em http://localhost:8080.

### Documentação Swagger UI

* Acesse: http://localhost:8080/swagger-ui/index.html#
* Aqui você poderá explorar todos os endpoints disponíveis, seus parâmetros, modelos de requisição/resposta e até mesmo testá-los diretamente no navegador.

### Endpoint Principal
* GET /api/products/{id}
  * Descrição: Obtém os detalhes de um produto específico pelo seu ID.
  * Exemplo de uso: http://localhost:8080/api/products/1
  * Respostas:
    * 200 OK: Retorna os detalhes do produto.
    * 400 Bad Request: Se o ID for inválido (e.g., nulo, zero, negativo, formato incorreto).
    * 404 Not Found: Se o produto com o ID especificado não for encontrado.
    * 500 Internal Server Error: Erro inesperado no servidor.

## 🧪 Testes
Os testes unitários e de integração podem ser executados via Maven:
```bash
mvn test
```