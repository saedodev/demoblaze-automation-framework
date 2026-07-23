@web @checkout
Feature: Checkout

  Background:
    Given User login sebagai "testuser"
    And User telah menambahkan produk ke cart
    And User membuka halaman Cart

  Scenario: Checkout berhasil
    When User melakukan checkout dengan data valid
    Then Pesanan berhasil dibuat

  Scenario: Checkout tanpa mengisi nama
    When User melakukan checkout tanpa mengisi nama
    Then Muncul pesan error

  Scenario: Checkout tanpa mengisi negara
    When User melakukan checkout tanpa mengisi negara
    Then Muncul pesan error

  Scenario: Checkout tanpa mengisi kartu kredit
    When User melakukan checkout tanpa mengisi kartu kredit
    Then Muncul pesan error