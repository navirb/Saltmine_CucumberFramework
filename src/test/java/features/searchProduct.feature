Feature: search and place the order for products
@OffersPage
Scenario Outline: Search Experience for product search in both Home and Offers page

Given User is on GreenCart Landing Page
When user seached with shortname <Name> and extracted actual name of product
Then user searched for <Name> shortname in offers page 
And validate product name in offers page matches with Landing Page

Examples:

| Name |
| Tom |
| Pot |