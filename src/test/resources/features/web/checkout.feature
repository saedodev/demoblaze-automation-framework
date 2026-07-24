@web @checkout
Feature: Checkout

  Background:
    Given User berada di halaman utama Demoblaze
    When User menambahkan beberapa produk untuk cart
    And Produk tampil pada Cart

  Scenario: Checkout berhasil
    When User melakukan checkout dengan data valid
    Then Pesanan berhasil dibuat

  Scenario: Checkout tanpa mengisi nama
    When User melakukan checkout tanpa mengisi nama
    Then Muncul pesan error

  Scenario: Checkout tanpa mengisi kartu kredit
    When User melakukan checkout tanpa mengisi kartu kredit
    Then Muncul pesan error