@api @user
Feature: User API

  Background:
    Given Dummy API tersedia

  @positive
  Scenario: Create User
    When User mengirim request Create User
    Then Status code harus 200
    And Response sesuai user schema

  @positive
  Scenario: Get User by ID
    Given User telah dibuat
    When User mengirim request Get User berdasarkan ID
    Then Status code harus 200
    And Data user berhasil ditampilkan
    And Response sesuai user schema

  @positive
  Scenario: Update User
    Given User telah dibuat
    When User mengirim request Update User
    Then Status code harus 200
    And Data user berhasil diperbarui
    And Response sesuai user schema

  @positive
  Scenario: Delete User
    Given User telah dibuat
    When User mengirim request Delete User
    Then Status code harus 200
    And User berhasil dihapus

  @negative
  Scenario: Get User dengan format ID tidak valid
    When User mengirim request Get User dengan ID "invalid-id"
    Then Status code harus 400
    And Response menampilkan pesan error

  @negative
  Scenario: Get User dengan ID tidak ditemukan
    When User mengirim request Get User dengan ID "5f9d88a1c7e4b6d2a8f1c3e5"
    Then Status code harus 404
    And Response menampilkan pesan error

  @negative
  Scenario: Update User dengan ID tidak valid
    When User mengirim request Update User dengan ID "61ab2c3d4e5f678901234567"
#   gunakan status code 400 karena field body tidak sesuai
    Then Status code harus 400
    And Response menampilkan pesan error

  @negative
  Scenario: Delete User dengan ID tidak valid
    When User mengirim request Delete User dengan ID "7abcdef0123456789abcdef0"
    Then Status code harus 404
    And Response menampilkan pesan error

  @negative
  Scenario: Create User tanpa First Name
    When User mengirim request Create User tanpa First Name
    Then Status code harus 400
    And Response menampilkan validasi error

  @negative
  Scenario: Create User tanpa Last Name
    When User mengirim request Create User tanpa Last Name
    Then Status code harus 400
    And Response menampilkan validasi error