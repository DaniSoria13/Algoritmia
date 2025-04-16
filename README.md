# Descripción del Proyecto: Juegos de Algoritmos en Java
Este proyecto incluye tres juegos clásicos de algoritmos implementados en Java puro, organizados bajo una estructura Maven. Cada juego tiene su lógica encapsulada y está diseñado para ejecutarse desde un menú interactivo por consola.

# 🧩 ¿Cómo se juega cada uno?
## 1. 🗼 Torres de Hanoi
Objetivo: Mover todos los discos desde la torre A hasta la torre C siguiendo estas reglas:

· Solo puedes mover un disco a la vez.

· No puedes colocar un disco grande sobre uno más pequeño.

· Solo puedes mover el disco más arriba de cada torre.

Niveles: El juego comienza con 3 discos en el nivel 1. Cada vez que ganas, puedes decidir si pasar al siguiente nivel, que incrementa en 1 el número de discos.

### Controles por consola:
Seleccionas la torre de origen y destino usando letras A, B, C.

## 2. 👑 Problema de las N Reinas
Objetivo: Colocar N reinas en un tablero de N x N de forma que ninguna se ataque entre sí.

### Cómo se juega:
El usuario introduce el valor de N. El programa busca todas las soluciones posibles usando backtracking y las muestra por consola, indicando dónde se ubica cada reina.

## 3. ♞ Movimiento del Caballo (Teléfono del Caballo)
Inspirado en un teclado numérico:

1 2 3
4 5 6
7 8 9
  0

Objetivo: Calcular cuántos movimientos válidos puede hacer un caballo de ajedrez desde cada número del teclado.

### Cómo se juega:
El usuario introduce el número de movimientos. El programa calcula y muestra cuántas secuencias válidas se pueden realizar desde cada número inicial.

# 📐 Estructura del Proyecto y Organización del Código
## ✳️ Proyecto Maven
Usamos Maven para estructurar el proyecto, lo cual facilita:

· La organización modular (src/main/java).

· La gestión de dependencias (por ejemplo, para SQLite si decides implementarlo).

· Una estructura limpia y mantenible.

## 📁 Paquetes

```
juegos/
├── Main.java                   # Menú principal
├── hanoi/
│   ├── TorresDeHanoi.java     # Juego Hanoi
│   └── NivelHanoi.java        # Controla los niveles
├── reinas/
│   └── NReinas.java           # Juego de las N reinas
└── caballo/
    └── MovimientoCaballo.java # Juego del caballo
```

## ⚙️ Estructuras de Programación por Juego
### 📌 Torres de Hanoi
· Usa vectores bidimensionales para representar las torres.

· Simula el movimiento de discos manipulando esos vectores.

· Control de niveles mediante una clase NivelHanoi.

### 📌 N Reinas
· Emplea backtracking para generar todas las combinaciones posibles.

· Usa arrays para representar el tablero y verificar ataques.

### 📌 Movimiento del Caballo
· Representa las conexiones entre los dígitos con un array de vectores.

· Calcula recursivamente todos los caminos válidos desde cada número.

## 💬 Interacción
Toda la interacción se hace por consola. El usuario elige el juego desde un menú tipo switch, con controles básicos (A, B, C, o números), y recibe información clara en pantalla.
