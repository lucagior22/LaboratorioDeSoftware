## i)
No se puede ya que Veterinaria se declara estrictamente con tipo Animal y Gato es otra clase.
## ii)
No se puede ya que Veterinaria se declara estrictamente con tipo Gato y Animal es otra clase.
## iii)
Compila la primer linea pero no la segunda porque el setAnimal espera un elemento del tipo E, que en este caso es indefinido y no se le puede pasar un tipo Gato.
## iv)
Se puede porque veterinaria es un raw type.
## v)
No compila porque el comodín "?" solo se puede usar del lado izquierdo de declaración, no del derecho de inicialización.
## vi)
Se puede porque Gato extiende Animal y el tipo declarado exige una clase que extienda animal.