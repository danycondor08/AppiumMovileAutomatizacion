@FlujoCompleto
Feature: Flujo completo de compra acumulando múltiples productos sin salir de la app

  Scenario: Agregar tres productos diferentes al carrito y verificar el resumen acumulado
    Given ingreso al aplicativo de AppConfig
    When valido que carguen correctamente los productos en la galeria
    And agrego los siguientes productos al carrito:
      | producto                  | cantidad |
      | Sauce Labs Bolt T-Shirt   | 10       |
      | Sauce Labs Onesie         | 1        |
      | Sauce Labs Fleece Jacket  | 1        |
    And hago clic en el icono del carrito
    And hago clic en el boton Proceed To Checkout
    And ingreso las credenciales de usuario "danycondor@gmail.com" y contraseña "10203040"
    And completo el formulario de direccion de envio con los siguientes datos:
      | fullName   | address1                       | address2                             | city | state | zipCode | country |
      | danycondor | ramon zavala #485 - santa anita | alfonso ugarte # 345 - cercado de lima | Lima | Lima  | 2520    | peru    |
    And hago clic en el boton To Payment
    And completo el formulario de metodo de pago con los siguientes datos:
      | fullName            | cardNumber       | expirationDate | securityCode |
      | dany condor solano  | 3258125675687891 | 05/25          | 234          |
    And hago clic en el boton Review Order
    And hago clic en el boton Place Order
    Then valido que el carrito de compras refleje el producto y la cantidad correcta