@SauceLabsExamen
Feature: Gestión de productos y carrito en SauceLabs

  Scenario Outline: Validar la adición de productos y actualización del carrito
    Given ingreso al aplicativo de AppConfig
    When valido que carguen correctamente los productos en la galeria
    And selecciono el producto "<producto>"
    And indico la cantidad de <cantidad> unidades
    And hago clic en el boton Add to cart
    Then valido que el carrito de compras refleje el producto y la cantidad correcta
    And vuelvo a la galeria de productos

    Examples:
      | producto                 | cantidad |
      | Sauce Labs Backpack      | 1        |
      | Sauce Labs Bolt T-Shirt  | 1        |
      | Sauce Labs Fleece Jacket | 1        |