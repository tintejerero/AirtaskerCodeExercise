# README
Airtasker Android code exercise

* The code exercise involved the implementation of an event feed from data provided in the following endpoints:
    * Data feed: https://stage.airtasker.com/android-code-test/feed.json
    * Task info: https://stage.airtasker.com/android-code-test/task/{taskId}.json
    * Profile info: https://stage.airtasker.com/android-code-test/profile/{profileId}.json
* Used Android Studio 3.0.1
* SDK versions:
    * Minimum SDK 21
    * Target, Compile SDK 26

Assumptions and possible enhancements:
* It was assumed that data in the endpoints will not change, the data is only queried once then displayed. May implement infinite scroll, refresh, caching for a larger amount of data and for changing dataset.
* Possibly explore the use of RxJava to improve handling of network calls.
* The app was built to follow the screenshot provided. The visual design may be enhanced.
* Increase unit test coverage, add integration tests.
* The feed was implemented to fetch the data at activity onCreate() and does not save state. Possible improvement may be to save scroll state when changing screen orientation.
