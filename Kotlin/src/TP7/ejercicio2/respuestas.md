## a
Lo que hace el syncronized(object) es activar el lock sobre el object dado como parámetro.
En este caso, se activa un lock sobre el objeto System.out, que es quien provee el método println.

## b
Es un lock intrinsic, conocido como **monitor**.
- Es mutex.
- Es bloqueante de hilo (los hilos que no pueden tomar el recurso se bloquean).
- Reentrant, porque el hilo que posee el cerrojo puede volver a adquirirlo.