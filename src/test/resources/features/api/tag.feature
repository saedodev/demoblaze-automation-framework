@api @tag
Feature: Tag API

  Background:
    Given Dummy API tersedia

  @positive
  Scenario: Get list tag data
    When User mengirim request Get List Tags
    Then Status code harus 200
    And Response sesuai tag schema
    And List tag tidak kosong