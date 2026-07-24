@web @login
Feature: Login

  Background:
    Given User membuka website DemoBlaze

  Scenario: Login dengan akun valid
    When User login menggunakan username "testuser" dan password "password123"
    Then User berhasil login

  Scenario: Login dengan username kosong
    When User login menggunakan username "" dan password "password123"
    Then Muncul pesan error login

  Scenario: Login dengan password kosong
    When User login menggunakan username "testuser" dan password ""
    Then Muncul pesan error login

  Scenario: Login dengan akun tidak valid
    When User login menggunakan username "invalid" dan password "invalid"
    Then Muncul pesan error login