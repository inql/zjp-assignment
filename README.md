# zjp-assignment

## All in one command to execute the project (sonarScan job is optional)

``
sbt clean coverage test && sbt coverageReport && sbt scapegoat && sbt sonarScan
``
