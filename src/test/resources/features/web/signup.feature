@web @signup
Feature: Signup

  Background:
    Given User berada di halaman utama Demoblaze

  @positive
  Scenario: User berhasil melakukan signup
    When User membuka menu Sign Up
    And User mengisi username baru
    And User mengisi password baru
    And User menekan tombol Sign Up
    Then Muncul alert Sign up successful.

  @negative
  Scenario: Signup menggunakan username yang sudah terdaftar
    When User membuka menu Sign Up
    And User mengisi username yang sudah terdaftar
    And User mengisi password
    And User menekan tombol Sign Up
    Then Muncul alert This user already exist.

  @negative
  Scenario: Signup tanpa username
    When User membuka menu Sign Up
    And User mengosongkan username
    And User mengisi password
    And User menekan tombol Sign Up
    Then Muncul alert Please fill out Username and Password.

  @negative
  Scenario: Signup tanpa password
    When User membuka menu Sign Up
    And User mengisi username baru
    And User mengosongkan password
    And User menekan tombol Sign Up
    Then Muncul alert Please fill out Username and Password.

  @negative
  Scenario: Signup tanpa username dan password
    When User membuka menu Sign Up
    And User mengosongkan username
    And User mengosongkan password
    And User menekan tombol Sign Up
    Then Muncul alert Please fill out Username and Password.