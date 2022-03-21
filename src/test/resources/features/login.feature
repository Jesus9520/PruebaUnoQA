# new feature
# Tags: optional

Feature: Ingreso
  como usuario
  quiero ingresar al aplicativo
  para ver mis cuentas

  Scenario: Ingreso correcto
    Given que ingrese a la pagina
    When ingreso mis credenciales correctamente Username "Jesus" y Password "1093777732"
    Then Accedi de manera correcta al aplicativo

    Scenario: Ingreso incorrecto
      Given voy a iniciar sesion
      When ingreso credenciales no validas Username "Mancipe" y Password "1093777732J!"
      Then no puedo ingresar al sistema

