<h1 align="center">
  <img src="https://github.com/Ankursehrawat15/News-Deck/blob/master/Documentation/icons8-shortcuts-192.png" width="136" alt="icon">
</h1>

  *This app uses NewsAPI to get various sources and each source can provide major headlines.
  It uses Retrofit 2 to fetch news sources and news headlines from the API and displays in a RecyclerView.
  Using Framents for creating different catogries and fetching the API with category filter.
  Also this app allows to search articles on the whatever Keyword they want*
  
 - - - -
&nbsp;
&nbsp;
&nbsp;
&nbsp;
## ScreenShots 
 - - - -

| 1 | 2 | 3 |
| --- | --- | --- |
| ![Welcome_Screen](https://github.com/Ankursehrawat15/News-Deck/blob/master/Documentation/1630959676961.jpg) | ![Home_Feed](https://github.com/Ankursehrawat15/News-Deck/blob/master/Documentation/1630959676958.jpg) | ![categories_swipe](https://github.com/Ankursehrawat15/News-Deck/blob/master/Documentation/1630959676947.jpg) |


| 4 | 5 | 6 |
| --- | --- | --- |
| ![Welcome_Screen](https://github.com/Ankursehrawat15/News-Deck/blob/master/Documentation/1630959676953.jpg) | ![Home_Feed](https://github.com/Ankursehrawat15/News-Deck/blob/master/Documentation/1630959676951.jpg) | ![categories_swipe](https://github.com/Ankursehrawat15/News-Deck/blob/master/Documentation/1630960274645.jpg) |

 - - - -

&nbsp;
&nbsp;
&nbsp;
&nbsp;

## Project Overview


The goal is to create a News Feed app that gives a user regularly updated news from the internet 
related to a particular topic, person, or location. You can search for the news directly as well.


## API Key Note
 - - - -
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
 - - - -
 &nbsp;
&nbsp;
&nbsp;
&nbsp;

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

 - - - -
 
 ## Authors

- [@AnkurSehrawat15](https://github.com/Ankursehrawat15)












