@LoginInvalido
Feature: Validar mensaje de error al intentar iniciar sesion sin contraseña desde el checkout

  Scenario: Validar mensaje de error "Enter Password" al dejar la contraseña vacia
    Given ingreso al aplicativo de AppConfig
    When valido que carguen correctamente los productos en la galeria
    And agrego los siguientes productos al carrito:
      | producto                | cantidad |
      | Sauce Labs Onesie       | 1        |
    And hago clic en el icono del carrito
    And hago clic en el boton Proceed To Checkout
    When escribo el usuario "danycondor@gmail.com"
    And hago clic en el boton Login del modulo de autenticacion
    Then valido que aparezca el mensaje de error de contraseña "Enter Password"