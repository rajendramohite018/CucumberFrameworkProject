Feature: Search and Place the order of products

@OfferPage1
Scenario: Search Experience for product search in both home and offer page
Given User is on GreenCart Landing page 
When User searched with shortname "Tom" and extracted actual name of product 
Then User searched for "Tom" shortname in offers page to check if product exit with same name
And Validate product name matches offer page with landing page

