# 📱 Actividad 12 - 🔐 App de Autenticación Biométrica

## 📋 Descripción

Esta aplicación permite al usuario autenticarse utilizando su **huella digital** mediante la API **AndroidX Biometric**.  
Su objetivo es demostrar el uso de servicios del dispositivo (biometría), manejo de interfaces y validación segura de identidad dentro de un entorno Android moderno.  
El diseño implementa una interfaz limpia, mensajes dinámicos y validación de compatibilidad con sensores biométricos disponibles en el dispositivo.

---

## 🎯 Objetivos de aprendizaje

- 🔌 Integración con servicios del dispositivo (biometría y seguridad)
- 📡 Implementación de componentes Android (Activity, Helper, UI)
- ⚡ Manejo eficiente de hilos y respuestas del sistema en tiempo real

---

## 🛠️ Tecnologías utilizadas

- 🤖 **Android SDK API 35**
- ☕ **Java**
- 🔐 **AndroidX Biometric**
- 🎨 **Material Design Components**
- 🧩 **ConstraintLayout y CardView**

---

## 📱 Funcionalidades

- 🔏 **Autenticación por huella digital** utilizando la librería `androidx.biometric`.
- ⚙️ **Validación del hardware biométrico**, comprobando si el dispositivo es compatible.
- 🧠 **Retroalimentación visual** mediante mensajes dinámicos en pantalla.
- 🖱️ **Botón de acción principal** para iniciar la autenticación.
- 🟢 **Mensajes de éxito** y 🔴 **mensajes de error o fallo** según el resultado.
- 📡 **Uso de hilos seguros (Executor)** para evitar bloqueos en la interfaz.

---

## ❓ Preguntas de reflexión técnica

1. 🔄 **¿Qué diferencia hay entre un sensor de movimiento basado en hardware y uno basado en software?**  
   Un sensor de movimiento basado en **hardware** obtiene los datos directamente desde los componentes físicos del dispositivo (como acelerómetro o giroscopio).  
   En cambio, un sensor **basado en software** combina la información de varios sensores físicos y la procesa mediante algoritmos para ofrecer datos interpretados o derivados (por ejemplo, un sensor de orientación que combina acelerómetro y magnetómetro).

2. 📊 **¿Cómo se puede acceder a los datos del sensor de movimiento en una aplicación Android?**  
   Se utiliza el servicio `SensorManager` para registrar un `SensorEventListener`. Este escucha los cambios del sensor en tiempo real y obtiene los valores del evento mediante el método `onSensorChanged(SensorEvent event)`.

3. 📱 **Menciona tres ejemplos de aplicaciones que utilizan el sensor de movimiento.**  
   - Aplicaciones de **salud o fitness** (cuentan pasos o miden actividad física).  
   - Juegos que usan el **movimiento del dispositivo** para controlar acciones.  
   - Aplicaciones de **realidad aumentada (AR)** que ajustan la vista según el movimiento del teléfono.

4. 💭 **Reflexión personal del tema**  
   Comprender cómo funcionan los sensores y la autenticación biométrica en Android me permitió valorar la importancia de la **seguridad y la integración con el hardware del dispositivo**.  
   La práctica me ayudó a entender la comunicación entre las capas del sistema y cómo se puede brindar una experiencia fluida y segura al usuario. Además, aprendí a manejar errores comunes del sistema biométrico y adaptar el flujo de la interfaz para diferentes resultados de autenticación.

---

## 📱 Desarrollo de la aplicación

### 8. 🛍️ Especificaciones técnicas de la aplicación

### 🧩 Interfaz

- La aplicación tiene una interfaz **sencilla e intuitiva**.
- Se utiliza un **MaterialButton** para iniciar la autenticación.
- Incluye un ícono de **huella digital** y textos dinámicos que indican el estado.
- Los mensajes cambian según el resultado de la autenticación.

### ⚙️ Funcionalidades

- **Autenticación por huella digital:**  
  Usa la API `androidx.biometric.BiometricPrompt` para autenticar al usuario.
  
- **Validación de huella:**  
  Compara la huella capturada con las almacenadas en el dispositivo y muestra un mensaje de éxito o error.

- **Mensajes dinámicos:**  
  Se muestra texto y color distinto dependiendo del resultado (éxito, error o fallo).

---

## 📸 Vista previa de la interfaz (Mockup)

![Vista de la app](images/1.png)
![Vista de la app](images/2.png)
![Vista de la app](images/3.png)

## ✨ Autor

👤 **CHRISTOPHER URIEL MARTINEZ VILLAFRANCO**  
🎓 Universidad Tecmilenio – Ingeniería en Sistemas Computacionales   
📅 *Noviembre 2025*  