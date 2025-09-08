name: Feature request
description: Propuesta de nueva funcionalidad
labels: [enhancement]
body:
  - type: input
    id: resumen
    attributes:
      label: Resumen
      description: Describí brevemente la mejora
  - type: textarea
    id: detalle
    attributes:
      label: Detalle
      description: ¿Qué se necesita y por qué?
  - type: checkboxes
    id: criterios
    attributes:
      label: Criterios de aceptación
      options:
        - label: Implementado
        - label: Tests OK
        - label: Documentado
