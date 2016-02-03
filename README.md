# cdc_examples

This very simple project has been created to demonstarte how Accurest works in practice.

It consist of two smaller gradle project:

- FraudDetectionService with one REST endpoint
- LoanApplicationService that will make requests to that endpoint

FraudDetectionService has Accurest configured along with sample scripts for generating stubs and tests.

The LoanApplicationService has tests with a WireMock rule that need the stubs generated with Accurest in FraudDetectionService to work.


The master branch has the complete setup and the branch 05_DSLs_with_regexp also contains the full setup along with examples of regular expressions use in the scripts. If you run `./gradlew clean build` against those branches, the stubs and tests should be automically generated, all the tests should pass in both projects and the build should end with success.

The other branches contain different setup stages step by step.
