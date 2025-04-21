# 🎮 Proyecto: Juegos de Algoritmos en Java

Este proyecto contiene tres juegos clásicos de algoritmos implementados en **Java puro**, con una interfaz amigable. Se organiza mediante una estructura **Maven** para facilitar la ejecución, organización y mantenimiento del código. Los juegos están diseñados para aprender y practicar algoritmos fundamentales mientras se juega.

---

# 🧩 ¿Qué juegos incluye?

## 1. 🗼 Torres de Hanoi (Interactivo con niveles)
**Objetivo**: Mover todos los discos desde la torre A hasta la torre C respetando las siguientes reglas:

- Solo se puede mover un disco a la vez.
- No se puede colocar un disco grande sobre uno más pequeño.
- Solo se puede mover el disco que esté arriba en una torre.

**Características:**
- El juego comienza con **3 discos** y aumenta progresivamente hasta **7 discos** (máximo 5 niveles).
- El jugador selecciona desde qué torre quiere mover (`A`, `B`, `C`, sin importar si está en mayúscula o minúscula) y hacia cuál.
- El programa verifica si el movimiento es válido antes de ejecutarlo.
- Se muestra el número total de movimientos realizados.
- Al completar un nivel, puedes elegir entre:
  - 👉 Continuar al siguiente nivel.
  - ❌ Salir del juego.

**Interfaz**: Gráfica, con `JFrame`, `JTextField`, `JButton` y mensajes informativos en un `JTextArea`.

---

## 2. 👑 N Reinas
**Objetivo**: Colocar `N` reinas en un tablero de `N x N` de forma que ninguna se ataque entre sí.

**Características:**
- El usuario introduce el valor de `N` por consola.
- El programa encuentra **todas las soluciones posibles** usando el algoritmo de **backtracking**.
- Se imprimen en consola los tableros con las posiciones correctas de las reinas.

**Interfaz**: Consola.

---

## 3. ♞ Movimiento del Caballo
**Objetivo**: Calcular cuántos caminos posibles puede recorrer un **caballo de ajedrez** en un tablero de tamaño `N x N`, partiendo desde una posición determinada.

**Características:**
- El usuario elige el tamaño del tablero (`N`) y la cantidad de movimientos (`K`) que desea realizar.
- También se especifica la posición inicial del caballo (`fila`, `columna`).
- El programa calcula recursivamente la cantidad total de trayectorias válidas que puede realizar el caballo sin salirse del tablero.
- Se muestra el total de trayectorias válidas desde esa posición.

**Interfaz**: Consola.

---

# 🧱 Estructura del Proyecto (Maven)

El proyecto sigue la estructura estándar de Maven:
```
juegos/
├── App.java # Menú principal
├── hanoi/
│├── TorresDeHanoi.java # Juego interactivo con niveles
│ └── NivelHanoi.java # Control de niveles y lógica de Hanoi
├── reinas/
│ └── NReinas.java # Juego de las N reinas
└── caballo/
└── MovimientoCaballo.java # Juego del caballo en tablero NxN

```

---

# ⚙️ Lógica por juego

### 🗼 Torres de Hanoi
- Usa **vectores** para representar las torres (A, B, C).
- Detecta entradas en mayúsculas o minúsculas (A, b, c...).
- Permite movimientos solo válidos.
- Control de niveles con incremento automático.
- Contador de movimientos y opción de continuar o salir.
- Implementado con `Swing`.

### 👑 N Reinas
- Usa **backtracking** puro.
- Representación en arrays para validar posiciones seguras.
- Salida de soluciones detalladas por consola.

### ♞ Movimiento del Caballo
- Tablero dinámico de `N x N` definido por el usuario.
- El usuario introduce la posición inicial y la cantidad de movimientos (`K`).
- El caballo se mueve usando las 8 posiciones clásicas del ajedrez.
- Se calcula recursivamente cuántas trayectorias distintas puede recorrer sin salir del tablero.

---

# 💬 Interacción y Uso

### 🎮 Menú principal
El archivo `App.java` permite elegir el juego desde consola. Dependiendo de tu elección:

- Para N Reinas y el Caballo: se ejecutan directamente en consola.
- Para Torres de Hanoi: se abre una ventana interactiva con controles.

