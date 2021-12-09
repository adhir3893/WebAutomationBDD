@Feature002
Feature: To verify redirection of Geo Distribution link in home page

@US001
Scenario: To verify the top navigtion redirections in home page
	Given user is in home page after passing home url
	And user enter username "kwzv387" and password "Summer!kwzv"
	And submit on clicking in login button
	And user navigates to lobby page
  Given navigate to homepage
  And tap on geoDistribution link
  Then verify user navigated to geoDistribution page