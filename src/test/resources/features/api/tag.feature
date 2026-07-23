@api @user
Feature: User API

  Background:
    Given Dummy API tersedia

  Scenario: Create User
    When User mengirim request Create User
    Then Status code harus 200
    And Response sesuai user schema

  Scenario: Get User by ID
    Given User telah dibuat
    When User mengirim request Get User berdasarkan ID
    Then Status code harus 200
    And Data user berhasil ditampilkan
    And Response sesuai user schema

  Scenario: Update User
    Given User telah dibuat
    When User mengirim request Update User
    Then Status code harus 200
    And Data user berhasil diperbarui
    And Response sesuai user schema

  Scenario: Delete User
    Given User telah dibuat
    When User mengirim request Delete User
    Then Status code harus 200
    And User berhasil dihapus