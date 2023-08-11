Feature: Test register functionality

#  Scenario Outline: Check register is successful with valid credentials
#    Given browser is open
#    And user is on register page
#    When user enters "<username>" and "<password>"
#    Then user is navigated on home page
#    And close browser
#
#    Examples:
#      |username|password|
#      |Test12 | 123456|
##
#  Scenario Outline: Check login is successful with valid credentials
#    Given browser is open
#    And user is on login page
#    When user login "<username>" and "<password>"
#    Then user is navigated on home page
#
#
#
#    Examples:
#      |username|password|
#      |Test1 | 123456|
#
#  Scenario Outline: Check the listed categories has item
#    Given browser is open
#    And user is on login page
#    When user login "<username>" and "<password>"
#    Then user is navigated on home page
#    Then check listed categories to the cart
#
#
#    Examples:
#      |username|password|
#      |Test1 | 123456|
#
#
#  Scenario Outline: Add item to cart
#    Given browser is open
#    And user is on login page
#    When user login "<username>" and "<password>"
#    Then user is navigated on home page
#    Then user choose device
#    Then user click on add cart
#    Then user click on cart button
#
#    Examples:
#      |username|password|
#      |Test1 | 123456|
#
#  Scenario Outline: Delete item to cart
#    Given browser is open
#    And user is on login page
#    When user login "<username>" and "<password>"
#    Then user is navigated on home page
#    Then user choose device
#    Then user click on add cart
#    Then user click on cart button
#    Then user Click Delete
#
#    Examples:
#      |username|password|
#      |Test1 | 123456|




  Scenario Outline: Complete successful checkout
    Given browser is open
    And user is on login page
    When user login "<username>" and "<password>"
    Then user is navigated on home page
    Then user choose device
    Then user click on add cart
    Then user click on cart button
    Then user click checkout
    And user enter "<name>"
    And user enters "<country>"
    And user fill "<city>"
    And user fills "<creditcard>" and "<month>" and "<year>"
    Then user click purchase
    Then user validate success message and press ok
    Examples:
      |username|password|name|country|city|creditcard|month|year|
      |gihad1 | 1234|  testing | egypt| cairo   |374245455400126| 05 | 2026  |





