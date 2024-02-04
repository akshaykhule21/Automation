Feature: Comp and SAOD plans

  Scenario Outline: Select a "<Insurer>" and proceed to PG. 
    Given User is on car insurance homepage
    When user enter car number "<carnum>" and click on view prices button
    When User select City "<City>" and RTO "<RTO>"
    And User select make "<make>"
    And User select model "<model>"
    #And User select fueltype "<type>"
    #And User select varient "<varient>"
#		And User select regyear "<year>"
    #When User enter name mail and mobilenumber
    #And Click on View Prices button
    #And User select expiry month "<month>" and day "<day>"
    #Then User answer claim question "<Claim>"
    #And User see how many plans are available
    #When User select insurer "<Insurer>"
    #Then User select CPA and click on pay securely
    #But if user lands on NPF then user fill proposal form
    #Then User make payment
    
    
    Examples:
   		| carnum     | City      | RTO  | make     | model    | type   | varient |	year	|	month	|	day	|	Claim	|	Insurer	|
      | MH88TT5555 | Mumbai    | MH01 | MARUTI   | ALTO     | Petrol |       1 |	2003	|	July	|	30	|		No	| Chola		|
      | MH88TT5555 | Mumbai    | MH01 | MARUTI   | ALTO     | Petrol |       1 |	2004	|	June	|	18	|		Yes	|	Chola		|
      | MH88TT5555 | Mumbai    | MH01 | MARUTI   | ALTO     | Petrol |       1 |	2005	|	July	|	1		|		No	|	Chola		|
      | MH88TT5555 | Mumbai    | MH01 | MARUTI   | ALTO     | Petrol |       1 |	2005	|	June	|	23	|		Yes	|	Chola		|