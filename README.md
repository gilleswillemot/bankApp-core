# bankApp-core
[![](https://jitpack.io/v/gilleswillemot/bankApp-core.svg)](https://jitpack.io/#gilleswillemot/bankApp-core)

This library contains the interfaces (mostly providers, e.g. IBankProvider) that are used in the bankApp (ios & android) and implementations that extend the interfaces (e.g. BankProviderImpl that extends the IBankProvider interface).

Dependency Inversion: by using interfaces, which are implemented in different libraries (e.g. BankProviderImpl) you protect your higher level components
(client => bankApp-android & bankApp-ios) from changes to your lower level components (BankProviderImpl), thus no updates
are needed in your higher level components when frequent updates occur in your lower level components.
The bankApp (client) uses the interfaces that are defined in the core library, and will be injected by the implementations that extend the interfaces.

In a kotlin multiplatform you will have a commonMain source folder which contains the kotlin code that is shared between all platforms. 
Platform specific code will be defined in platform specific folder, e.g. 'jvmMain' folder when defining java code, or 'jsMain' when defining JavaScript.
In general platform specific code will be API implementation.

As this library was made in Android Studio and not Intellij IDEA (recommended), the folder structure uses the main folder (src/main/java), which
is why the main folder was linked to the commonMain with `kotlin.srcDir('src')`, because the compilation of kotlin multiplatform does not keep other folders
than commonMain and target folder (e.g. jsMain, iosMain, ...) into account when building.

The src/main/java folder was renamed to kotlin (as everything is defined in kotlin) and this changed was reflected into the build.gradle. No refactor in the build.gradle file was needed for the tests as they are still defined in java.

It is very import to do a correct linking of the main folder with the commonMain folder (`kotlin.srcDir('src/main/kotlin')`) in the build.gradle file, and
the test directory with the commonTest (`kotlin.srcDir('src/test/java')`).
Failing to do so results in the tests not being able to be run as the tests would not be found (wrong package name reference) and the building of the source files would not work 
as they would not be found by the compiler.