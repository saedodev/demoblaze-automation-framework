@web @product
Feature: Product

  Background:
    Given User berada di halaman utama Demoblaze

  Scenario: Melihat detail produk
    When User memilih salah satu produk
    Then Detail produk berhasil ditampilkan

  Scenario: Menambahkan satu produk ke cart
    When User memilih salah satu produk
    And User menekan tombol Add to Cart
    Then Produk berhasil ditambahkan ke cart

  Scenario: Menambahkan beberapa produk ke cart
    When User menambahkan beberapa produk
    Then Semua produk berhasil masuk ke cart