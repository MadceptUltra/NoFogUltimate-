# NoFog Ultimate (Minecraft 26.3 Fabric)

## Environment & Build
- **Minecraft**: `26.3` (unobfuscated Mojang names)
- **Fabric Loom**: `1.18.4` with Gradle Wrapper `9.7.1`
- **Fabric Loader**: `0.19.5` (standalone client mod — no `fabric-api` runtime dependency required)
- **JDK**: Requires Java 25 (`C:\Users\Madcept\.devin\extensions\redhat.java-1.58.0-win32-x64\jre\25.0.4.1-win32-x86_64` on this machine)

## Commands
- Build mod JAR (PowerShell):
  ```powershell
  $env:JAVA_HOME = "C:\Users\Madcept\.devin\extensions\redhat.java-1.58.0-win32-x64\jre\25.0.4.1-win32-x86_64"
  .\gradlew.bat build
  ```
- Output artifact: `build/libs/nofog-ultimate-1.0.0+mc26.3.jar`
