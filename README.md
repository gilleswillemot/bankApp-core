# bankApp-core

This library will contain all the interfaces (mostly providers, e.g. IBankProvider).
Dependency Inversion: by using interfaces, which are implemented in different libraries (e.g. BankProviderImpl) you guard your higher level object
(client => bankApp-android & bankApp-ios) from changes to your lower level components (BankProviderImpl), thus no updates
are needed in your higher level components when frequent updates occur in your lower level components.
The bankApp (client) used the interface that are defined in the core library, and will be injected by the implementations that extend the interfaces.

In a kotlin multiplatform you will have a commonMain source folder which contains the kotlin code that is shared between all platforms. 
Platform specific code will be defined in platform specific folder, e.g. 'jvmMain' folder when defining java code, or 'jsMain' when defining JavaScript.
In general platform specific code will be API implementation.

As this library was made in Android Studio and not Intellij IDEA (recommended), the folder structure uses the main folder (src/main/java), which
is why the main folder was linked to the commonMain with `kotlin.srcDir('src')`, because the compilation of kotlin multiplatform does not keep other folders
than commonMain and target folder (e.g. jsMain, iosMain, ...) into account when building.
