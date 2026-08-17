@RemoverItem
Feature: Remover producto del carrito de compras

  Scenario: Validar que se pueda eliminar un producto cuando hay varios en el carrito
    Given ingreso al aplicativo de AppConfig
    When valido que carguen correctamente los productos en la galeria
    And agrego los siguientes productos al carrito:
      | producto                | cantidad |
      | Sauce Labs Onesie       | 1        |
      | Sauce Labs Fleece Jacket| 1        |
    And hago clic en el icono del carrito
    When hago clic en el boton Remove Item del producto
    Then valido que el carrito quede vacio o el producto sea removido