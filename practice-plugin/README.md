#dr-d-plugin

Practice Plugin has two goals.

Goal1 has no parameters.

Goal2 has single parameter called stringParameter.

---
####mvn install
 Do a mvn install to add the plugin to your local .m2 repository.
(e.g. should create /home/drd/.m2/repository/com/drd/drd-plugin)
####mvn package
Uncomment the <build>...</build> lines in the pom.xml file.

Do a maven package. Check that the mvn output shows
...
[INFO] --- drd-plugin:1.0-SNAPSHOT:goal1 (testPlugin) @ drd-plugin ---
[INFO] Executing goal1
...
[INFO] --- drd-plugin:1.0-SNAPSHOT:goal2 (testPlugin2) @ drd-plugin ---
[INFO] Executing goal2
[INFO] stringParameter: Testing Plugin Parameter

---
####Goals/Phases
*goal1* is executing during the compile phase.

*goal2* is executing during the package phase.
