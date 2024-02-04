Feature: PWCN journey

  @PWCN @REGRESSION
  Scenario Outline: PWCN
    Given Setup data from sheetname "<SheetName>" and rownumber <RowNumber>
    Given User is on car insurance homepage
    When user enter car number and click on view prices button
    When User select City and RTO
    And User select make
    And User select model
    And User select fueltype
    And User select varient
    And User select regyear
    #When User enter name mail and mobilenumber
    #And Click on View Prices button
    #And User select expiry month and day
    #Then User answer claim question
    #Then user will land on quote page V2
    #And User see how many plans are available
    #When User select insurer
    #And User fill proposal form from excel sheet
    #Then User make payment

    Examples: 
      | SheetName | RowNumber |
      | PWCN      |         0 |
      #| PWCN      |         1 |
      #| PWCN      |         2 |
      #| PWCN      |         3 |
      #| PWCN      |         4 |
      #| PWCN      |         5 |
      #| PWCN      |         6 |
      #| PWCN      |         7 |
      #| PWCN      |         8 |
      #| PWCN      |         9 |
      #| PWCN      |        10 |
