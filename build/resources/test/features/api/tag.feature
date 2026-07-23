@api @tag
Feature: Tag API

  Background:
    Given Dummy API tersedia

  @positive
  Scenario: Get list of tags successfully
    When User mengirim request Get List Tags
    Then Status code harus 200
    And Response sesuai tag schema
    And List tag tidak kosong

  @positive
  Scenario: Validate total tags information
    When User mengirim request Get List Tags
    Then Status code harus 200
    And Total tag lebih dari 0

  @positive
  Scenario: Validate limit and page information
    When User mengirim request Get List Tags
    Then Status code harus 200
    And Limit lebih dari 0
    And Page sama dengan 0

  @positive
  Scenario: Validate first tag is not empty
    When User mengirim request Get List Tags
    Then Status code harus 200
    And Tag pertama tidak kosong