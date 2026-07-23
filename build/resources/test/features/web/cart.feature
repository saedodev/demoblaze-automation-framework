@web @cart
Feature: Cart

  Background:
    Given User login sebagai "testuser"
    And User telah menambahkan produk ke cart

  Scenario: Melihat produk pada cart
    When User membuka halaman Cart
    Then Produk tampil pada Cart

  Scenario: Menghapus produk dari cart
    When User membuka halaman Cart
    And User menghapus produk
    Then Produk berhasil dihapus

  Scenario: Menghapus seluruh produk
    When User membuka halaman Cart
    And User menghapus semua produk
    Then Cart kosong