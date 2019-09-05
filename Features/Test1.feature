Feature: Go Discovery
  Perform the various task in https://go.discovery.com/ link.


  Scenario: Scroll down to popular shows, select the last one and get the title and lenth of the videos.
    Given Navigate to https://go.discovery.com/
    And Scroll down to popular shows
    And Go to the last video by pressing the icon '>'
    Then Click on EXPLORE THE SHOW for last video
    And Click on SHOW MORE until its visible
    Then Create a new file and write all the show titles and duration into it
    And Close the browser