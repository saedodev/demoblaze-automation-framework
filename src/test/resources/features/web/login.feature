@web @login
Feature: Login

  Background:
    Given User berada di halaman utama Demoblaze

  @positive
  Scenario: User berhasil login
    When User membuka menu Log In
    And User mengisi username yang valid
    And User mengisi password yang valid
    And User menekan tombol Log In
    Then Nama user ditampilkan pada navigation bar

  @negative
  Scenario: Login menggunakan password yang salah
    When User membuka menu Log In
    And User mengisi username yang valid
    And User mengisi password yang salah
    And User menekan tombol Log In
    Then Muncul alert "Wrong password."

  @negative
  Scenario: Login menggunakan username yang tidak terdaftar
    When User membuka menu Log In
    And User mengisi username yang tidak terdaftar
    And User mengisi password
    And User menekan tombol Log In
    Then Muncul alert "User does not exist."

  @negative
  Scenario: Login tanpa username
    When User membuka menu Log In
    And User mengosongkan username
    And User mengisi password
    And User menekan tombol Log In
    Then Muncul alert "Please fill out Username and Password."

  @negative
  Scenario: Login tanpa password
    When User membuka menu Log In
    And User mengisi username yang valid
    And User mengosongkan password
    And User menekan tombol Log In
    Then Muncul alert "Please fill out Username and Password."

  @negative
  Scenario: Login tanpa username dan password
    When User membuka menu Log In
    And User mengosongkan username
    And User mengosongkan password
    And User menekan tombol Log In
    Then Muncul alert "Please fill out Username and Password."