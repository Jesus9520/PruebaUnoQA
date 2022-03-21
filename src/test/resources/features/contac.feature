

Feature: ingreso
  como cliente
  quiero contactarme con soporte tecnico
  para reportar un pqr

  Scenario: contactarme con soporte
    Given me dirijo a Contact Us
    When para generar un pqr
    Then mis respuestas de acuerdo a mi solicitud

    Scenario: registro sin datos
      Given el cliente se dirije a Contact Us
      When no tiene los datos completos
      Then no genero pqr