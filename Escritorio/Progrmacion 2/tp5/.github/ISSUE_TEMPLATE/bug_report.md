name: Bug report
description: Reporte de error
labels: [bug]
body:
  - type: input
    id: contexto
    attributes:
      label: Contexto
      description: Dónde ocurrió (endpoint, servicio, etc.)
  - type: textarea
    id: pasos
    attributes:
      label: Pasos para reproducir
  - type: textarea
    id: esperado
    attributes:
      label: Comportamiento esperado
  - type: textarea
    id: actual
    attributes:
      label: Comportamiento actual
