Feature: Test Rest API RoomController Get Method

    Scenario: Get Room details
      Given Set a room service api endpoint
      When Get URL is called
      Then Receive valid 200 response
      And response should contain data

