Feature: Using different input types on Different Elements page

  Scenario: Using checkboxes, radio buttons and dropdown list to input specific data
    Given I open JDI Testing index page
    And I login as user "Roman Iovlev"
    And I click on "Service" button in Header
    And I click on "Different elements" button in Service dropdown
    When I select the following element checkboxes
      | Water, Wind |
    And I select the following metal radio button
      | Selen |
    And I select the following color from dropdown list
      | Yellow |
    Then Log rows are displayed with the following content
      | Type   | Log                       |
      | Colors | value changed to Yellow   |
      | metal  | value changed to Selen    |
      | Wind   | condition changed to true |
      | Water  | condition changed to true |