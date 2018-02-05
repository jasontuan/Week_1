# Lecture1

Lecture1 shows the latest movies currently playing in theaters. The app utilizes the Movie Database API to display images and basic information about these movies to the user.

## User Stories

The following **required** functionality is completed:

* [] User can **scroll through current movies** from the Movie Database API
* [] Layout is optimized with the [ViewHolder](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView#improving-performance-with-the-viewholder-pattern) pattern.
* [] For each movie displayed, user can see the following details:
* [] Title, Poster Image, Overview (Portrait mode)
* [] Title, Backdrop Image, Overview (Landscape mode)

The following **optional** features are implemented:

* [] Display a nice default [placeholder graphic](glide) for each image during loading.

The following **bonus** features are implemented:

* [] Allow user to view details of the movie including ratings and popularity within a separate activity or dialog fragment.
* [ ] When viewing a popular movie (i.e. a movie voted for more than 5 stars) the video should show the full backdrop image as the layout.  Uses [Heterogenous ListViews](http://guides.codepath.com/android/Implementing-a-Heterogenous-ListView) or [Heterogenous RecyclerView](http://guides.codepath.com/android/Heterogenous-Layouts-inside-RecyclerView) to show different layouts.
* [] Allow video trailers to be played in full-screen using the YouTubePlayerView.
    * [] Overlay a play icon for videos that can be played.
    * [ ] More popular movies should start a separate activity that plays the video immediately.
    * [ ] Less popular videos rely on the detail page should show ratings and a YouTube preview.
* [ ] Apply the popular [Butterknife annotation library](http://guides.codepath.com/android/Reducing-View-Boilerplate-with-Butterknife) to reduce boilerplate code.
* [] Apply rounded corners for the poster or background images using [Glide transformations](google)
* [ ] Replaced android-async-http network client with the popular [OkHttp](http://guides.codepath.com/android/Using-OkHttp) networking libraries.

The following **additional** features are implemented:
* [] UI has disigned to fit many screen and both of Portrait and Landscape without crash.
* [] Adding loading progress to wait server response.
* [] User can view trailers with thumbnails.
* [] Using tabslayout, blur, corners and splashscreen to improve user's experiences.

## Video Walkthrough

Here's a walkthrough of implemented user stories:

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

Describe any challenges encountered while building the app.

## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
