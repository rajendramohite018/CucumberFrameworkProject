Feature: Place the order of products

@PlaceOrder
Scenario Outline: User should be product order place successfully with using promocode
Given User is on GreenCart Landing page 
When User searched with short name <Name> and extracted actual name of product
And Added "3" items of the selected product to cart
Then User procceds to checkOut and validate the <Name> items in checkout Page
And verify user has ability to enter promocode and place the order

Examples:
| Name |
| Pota |

