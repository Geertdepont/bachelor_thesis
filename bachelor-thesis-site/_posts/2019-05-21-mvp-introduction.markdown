---
layout: post
title: "What is MVP?"
guideline_id: Introduction
short_description: "Provide views with data"
date:   2019-05-21 01:00:26 +0200
categories: MVP
---
<h3>The MVP architecture</h3>
The MVP architecture consists of three components:
<ul>
<li><b>Model</b> represents the datasource. This layer is accessed to update/store and retrieve the data.</li>
<li><b>View</b> usually implemented by an activity, has a one-to-one relationship with the Presenter</li>
<li><b>Presenter</b> decides which methods from the view to call, and what will be displayed in the view. </li>
</ul>

<h3>Difference MVVM and MVP</h3>
In MVVM the ViewModel exposes it's methods and variables for the View to use it.
In MVP the Presenter has a one-to-one relationship with the View, and decides what the view should do.

<h3>Example</h3>
We created a simple [MVP example][MVP-Login].
As you can see, whenever a button is clicked, the Presenter decides what happens on the View.
The presenter sets the progressbar on the view, and removes it.


<figure>
  <img src="/assets/MVPLogin_event_diagram.png" alt="Login event diagram" width="600">
</figure>

Checkout the [github page][MVP-Login] to view the full repository.


[MVP-Login]: https://github.com/Geertdepont/bachelor_thesis/tree/master/MVPLogin