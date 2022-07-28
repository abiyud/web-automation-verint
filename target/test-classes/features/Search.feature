@Search
Feature: Search on home page Verint.com
  As a user, i want to search articles or news on home page

  @Positive
	  Scenario: Search customer solution
	    Given user open verint website
	    When click button search
	    And user search <text>
	    Then page shows articles contain <text>
	    
	    Examples:
		    |text|
		    |customer solution|
