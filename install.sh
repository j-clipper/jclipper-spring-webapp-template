mvn clean archetype:create-from-project -Darchetype.properties=archetype.properties &&
cd target/generated-sources/archetype/ &&
mv -f src/main/resources/archetype-resources/.gitlab-ci-template.yml src/main/resources/archetype-resources/.gitlab-ci.yml &&
mv -f target/classes/archetype-resources/.gitlab-ci-template.yml target/classes/archetype-resources/.gitlab-ci.yml &&
mv -f src/main/resources/archetype-resources/README-template.md src/main/resources/archetype-resources/README.md &&
mv -f target/classes/archetype-resources/README-template.md target/classes/archetype-resources/README.md &&
mvn deploy