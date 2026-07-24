@web @cart
Feature: Cart

  Background:
    Given User berada di halaman utama Demoblaze

  Scenario: Menghapus produk dari cart
    When User menambahkan beberapa produk untuk cart
    And Produk tampil pada Cart
    And User menghapus produk
    Then Produk berhasil dihapus