ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "automation-LT"
  )

libraryDependencies ++= Seq(
  "info.cukes"                        % "cucumber-java8"              % "1.2.5" % "test",
  "info.cukes"                        % "cucumber-junit"              % "1.2.5" % "test",
  "info.cukes"                        % "cucumber-picocontainer"      % "1.2.5" % "test",
  "junit"                             % "junit"                       % "4.12" % "test",
  "com.novocode"                      % "junit-interface"             % "0.11" % "test",
  "com.github.mkolisnyk"              % "cucumber-runner"             % "1.3.5",
  "net.masterthought"                 % "cucumber-reporting"          % "3.20.0",
  "com.vimalselvam"                   % "cucumber-extentsreport"      % "3.1.0",
  "commons-io"                        % "commons-io"                  % "2.6",
  "com.google.guava"                  % "guava"                       % "27.0-jre",
  "org.seleniumhq.selenium"           % "selenium-java"               % "4.8.0",
  //"com.typesafe.play"                 %% "play"                       % "2.6.7",
  //"com.typesafe.play"                 %% "play-json"                  % "2.6.8",
)

resolvers ++= Seq(
  "reports" at "https://mvnrepository.com/artifact/com.vimalselvam/cucumber-extentsreport",
  "Typesafe Releases" at "https://repo.typesafe.com/typesafe/maven-releases/",
  "Local" at Path.userHome.asFile.toURI.toURL + "/.ivy2/local/"
)

unmanagedSourceDirectories in Test += baseDirectory.value / "test"