#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#@tag
#Feature: Title of your feature
  #I want to use this template for my feature file
#
  #@tag1
  #Scenario: Title of your scenario
    #Given I want to write a step with precondition
    #And some other precondition
    #When I complete action
    #And some other action
    #And yet another action
    #Then I validate the outcomes
    #And check more outcomes
#
  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
@Feature001
Feature: Automate Launch URL and Login Functionality and then Verify top navigation links redirection
Description: User Login to the website and To verify the top navigtion redirections in home page

@US001
Scenario: User Login to the website
		Given user is in home page after passing home url
		And user enter username "kwzv387" and password "Summer!kwzv"
		And submit on clicking in login button
		And user navigates to lobby page

@US002
Scenario: To verify the top navigtion redirections in home page
	Given user is in home page after passing home url
	And user enter username "kwzv387" and password "Summer!kwzv"
	And submit on clicking in login button
	And user navigates to lobby page
  Given navigate to homepage
  And tap on accounts link
  Then verify user navigated to accounts page

