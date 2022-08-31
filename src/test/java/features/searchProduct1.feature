Feature: Search and Place the order of products

@OfferPage2
Scenario Outline: Search Experience for product search in both home and offer page
Given User is on GreenCart Landing page 
When User searched with short name <Name> and extracted actual name of product 
Then User searched for <Name> short name in offers page to check if product exit with same name
And Validate product name matches offer page with landing page

Examples:
| Name |
| Bee |
| Tom  |
