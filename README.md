<div style="text-align:center"><img src="https://github.com/Ankursehrawat15/News-Deck/blob/master/Documentation/icons8-shortcuts-192.png" /></div>
                                                                   # NEWS-DECK  

## Demo
https://user-images.githubusercontent.com/61679890/132259897-cac83109-eb72-4020-b692-7d1b64d2c896.mp4




https://user-images.githubusercontent.com/61679890/132260086-4eb80dfe-55a0-421a-bbaa-fa0a976f5956.mp4







## Project Overview

The goal is to create a News Feed app that gives a user regularly updated news from the internet 
related to a particular topic, person, or location. You can search for the news directly as well.


## API Key Note
You need to insert your API key.
Go to the package named `Fragments` and insert the your Api key from 'News.Api'.
This needs to be done in all the fragments java files.

```
  private static final String API_KEY = "Your Api Key Here";
```

Go to the file named `ApiClient.java` and insert the your baseUrl from 'News.Api'
```
  private static final String BASE_URL = "Your Base Url Here";
```

## ToDo List

- [x] Top Headlines,Sources are listed.
- [x] Allowed users to switch between fragments using  ViewPager.
- [x] Added Preferences Screen to display diverse news according to user's selection.
- [x] Implemented Custom News UI to list news from selected news source which takes place in Sources section.
- [x] Implemented Search feature forHome section and thus user can search any news article in the app.
- [x] Performed UI tests and passed successfully.
- [x] Implement Filter feature for Sources section and thus user can filter results.
- [x] Added shorts ie which displays the article with more description about the news and content as well.
- [ ] Add Day/Night Mode.
- [ ] Implement Firebase and Firestore to send push notifications.
- [ ] Integrated Room Persistence Library to list offline data in the event of no internet connection.













