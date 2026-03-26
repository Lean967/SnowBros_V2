# SnowBros V2 — p-comision-13

Reimplementación en Java del clásico videojuego **Snow Bros**, desarrollado como proyecto académico.  
El juego incluye modos de partida *Clásico*, *Contrarreloj* y *Supervivencia*, sistema de ranking, múltiples enemigos, jefes de nivel, power-ups y efectos de sonido.

## Estructura del proyecto

```
src/
├── CapaDatos/      # Persistencia, constantes y gestión de sonido
├── Enemigo/        # Lógica de cada tipo de enemigo y sus colisionadores
├── Fabricas/       # Patrón Factory para creación de entidades
├── GUI/            # Paneles Swing (menú, partida, ranking, game over…)
├── Juego/          # Núcleo del juego: hilo principal, colisiones, entidades
├── Jugador/        # Lógica del jugador (SnowBro) y sus estados
├── Launcher/       # Punto de entrada de la aplicación
├── Municiones/     # Proyectiles y bolas de nieve
├── Niveles/        # Diseño y carga de niveles
├── Obstaculos/     # Bloques y obstáculos del escenario
├── Plataformas/    # Plataformas transitables
├── Powers/         # Power-ups (pociones, frutas, vida extra)
├── Sonidos/        # Reproducción de audio
└── Visitor/        # Patrón Visitor para puntuación y colisiones
```

## Requisitos

* **Java 11** o superior
* IDE compatible con Java (IntelliJ IDEA, Eclipse, VS Code con extensión Java)

## Cómo ejecutar

```bash
# Compilar (desde la raíz del proyecto)
javac -sourcepath src -d out src/Launcher/Launcher.java

# Ejecutar
java -cp out Launcher.Launcher
```

---

## GitHub Copilot — Máximo potencial y cómo usarlo en este proyecto

### ¿Qué es GitHub Copilot?

GitHub Copilot es un asistente de programación basado en inteligencia artificial (modelo GPT de OpenAI/Microsoft) que **sugiere código, completa funciones, escribe tests y explica código existente** directamente en tu editor.

### ¿Puedo usarlo en proyectos de código abierto (open source)?

**Sí.** GitHub Copilot funciona en cualquier repositorio, ya sea privado o público (open source). Incluso existe un plan gratuito para estudiantes y colaboradores de proyectos open source a través del **GitHub Student Developer Pack** y **GitHub Copilot Free** (con límite mensual de completaciones).

### Funcionalidades principales

| Funcionalidad | Descripción |
|---|---|
| **Autocompletado inteligente** | Sugiere la siguiente línea o bloque de código mientras escribes |
| **Generación de funciones completas** | Con un comentario descriptivo, genera métodos enteros |
| **Generación de tests** | Crea pruebas unitarias (JUnit, etc.) a partir del código existente |
| **Explicación de código** | Explica qué hace un fragmento de código en lenguaje natural |
| **Refactorización** | Sugiere mejoras de legibilidad, rendimiento o estilo |
| **Corrección de bugs** | Detecta y propone soluciones para errores comunes |
| **Generación de documentación** | Escribe Javadoc o comentarios explicativos automáticamente |
| **Soporte multi-lenguaje** | Java, Python, JavaScript, TypeScript, C#, Go, Ruby y más |
| **Chat en el editor** | Modo conversacional para hacer preguntas sobre el código (Copilot Chat) |

### Cómo aprovecharlo al máximo en este proyecto Java

1. **Autocompletar patrones de diseño existentes**  
   Copilot reconoce los patrones *Factory*, *Visitor* y *Observer* que ya usa el proyecto y puede generar nuevas clases que los implementen automáticamente.

2. **Generar nuevos enemigos**  
   Con un comentario como `// Nuevo enemigo: Fantasma que se mueve en diagonal y lanza proyectiles`, Copilot puede proponer la clase completa siguiendo la estructura de `Enemigo.java`.

3. **Escribir tests unitarios**  
   Abre `Jugador.java`, selecciona un método y pídele a Copilot Chat: *"Genera tests JUnit 5 para este método"*.

4. **Entender código ajeno**  
   Selecciona cualquier método complejo (por ejemplo en `ControladorColisiones.java`) y usa Copilot Chat: *"¿Qué hace este código?"*.

5. **Documentar el proyecto**  
   Selecciona una clase sin Javadoc y pide: *"Agrega documentación Javadoc a esta clase y sus métodos"*.

### Cómo activarlo

1. Instala la extensión **GitHub Copilot** en tu IDE:
   - **VS Code**: extensión `GitHub.copilot` en el Marketplace
   - **IntelliJ IDEA / Android Studio**: plugin `GitHub Copilot` en el Plugin Marketplace
2. Inicia sesión con tu cuenta de GitHub.
3. Activa tu suscripción en [github.com/features/copilot](https://github.com/features/copilot) (hay plan gratuito para estudiantes).

### Limitaciones a tener en cuenta

- Las sugerencias pueden contener errores; siempre revisá el código generado.
- No reemplaza el entendimiento del dominio: conocer el juego y la arquitectura sigue siendo clave.
- En código muy específico o dominio de nicho, las sugerencias pueden ser menos precisas.

---

*Proyecto académico — Comisión 13*
