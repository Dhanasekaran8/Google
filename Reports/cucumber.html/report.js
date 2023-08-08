$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/lashm/eclipse-workspace/Maven_Cucumber/src/test/java/com/feature/Google.feature");
formatter.feature({
  "line": 1,
  "name": "To Search The Product In Google Search Bar",
  "description": "",
  "id": "to-search-the-product-in-google-search-bar",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "To Search Value",
  "description": "",
  "id": "to-search-the-product-in-google-search-bar;to-search-value",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "User Must Launch The \"chrome\" Browser",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "User Must Launch The \"https://www.google.com/\" Url",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "User Must Search The Value \"Rose\" In Search Bar",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "chrome",
      "offset": 22
    }
  ],
  "location": "googlestep.user_Must_Launch_The_Browser(String)"
});
formatter.result({
  "duration": 3880510000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.google.com/",
      "offset": 22
    }
  ],
  "location": "googlestep.user_Must_Launch_The_Url(String)"
});
formatter.result({
  "duration": 5517251000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Rose",
      "offset": 28
    }
  ],
  "location": "googlestep.user_Must_Search_The_Value_In_Search_Bar(String)"
});
formatter.result({
  "duration": 339730200,
  "status": "passed"
});
});