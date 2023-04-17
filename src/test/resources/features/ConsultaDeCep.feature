# Language : pt

Feature: Testando uma REST API para consultar um cep

  API viaCep Swagger Link http://localhost:8080/swagger-ui/index.html

  Scenario: Consultar cep
    When Usuarios fazem uma consulta de um cep válido
    Then o servidor deve retornar o corpo e o status de sucesso
