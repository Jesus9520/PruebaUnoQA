# new feature
# Tags: optional

Feature: crear usuario
  como persona
  quiero crear un usuario
  para tener mi perfil de usuario

  Scenario: registrar usuario
    Given la persona crea un usuario
    When diligencio el formulario de registro
    Then debo quedar registrado

    Scenario: registro sin datos
      Given la persona desea crear un usuario
      When no diligencio el formulario de manera correcta
      Then no se creo registro
