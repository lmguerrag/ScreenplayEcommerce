Feature: Registro de usuario
  As un usuario
  I want registrarme en el ecommerce

  Scenario: Registro exitoso
    Given un usuario quiere registrarse
    When se registra exitosamente
    Then podra visualizar un mensaje de bienvenida