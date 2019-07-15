# Repository for website and applications created for describing Android architectures 

This repository contains all files used for describing Android architectures.
Five applications are created to describe the 42 guidelines from the paper by Verdecchia * et al*.
This paper can be found [here](https://robertoverdecchia.github.io/papers/ICSA_2019.pdf).
These applications are: 'ArchitectureExample', 'RxJavaRetrofitGithub', 'BookApplication', 'BossApplication' and MVPLogin

## Table describing coverage of guidelines in applications

Application  | Guidelines
------------- | -------------
ArchitectureExample  | A-5, MVVM-1 to MVVM-8 and CLEAN-2
RxJavaRetrofitGithub | A-6, A-7, A-10, MVVM-9 and MVVM-10
BookApplication      | A-13 and MVP-4
BossApplication      | A-2, A-8, A-9, A-11, A-12, A-15, MVP-2, MVP- 3, CLEAN-1 and CLEAN-2
MVPLogin             | A-1, A-3 to A-6, A-14 MVP-1, MVP-5 to MVP- 11 and CLEAN-3 to CLEAN-5

## Description of all the guidelines
### ArchitectureExample
This application is a note list or TODO list. 
On the frontpage all the notes can be seen. 
Clicking on the plus button takes you to a form where you can create your new note. 
Whenever the new note is added, the notelist is automatically updated. 
![Image of Architecture Example](https://geertdepont.github.io/assets/ArchitecturePhone.png)

### RxJavaRetrofitGithub
This applicaton uses RxJava and performs multiple requests from this [github page](https://github.com/Geertdepont)
And retrieves the contributors from each repository and shows for each contributor the amount of contributions in that repository.
![Image of RxJavaRetrofitGithub](https://geertdepont.github.io/assets/RxjavaGithub.png)
### BookApplication
This application performs a fake GET Request and returns the best books of the moment. 
![Image of BookApplication](https://geertdepont.github.io/assets/BookSecondPhone.png)
### BossApplication
This application performs a GET Request from this url: http://dummy.restapiexample.com/api/v1/employees. 
This is a JSON file containing multiple fake employees with their salaries. 
Whenever this request is performed again within 5 seconds, it returns these employees from the cache. 
![Image of BossApplication](https://geertdepont.github.io/assets/BossAppPhone.png)

### MVPLogin
This is a login form with an empty database. 
So you cannot login without creating a user in the add user form. 
Whenever you have successfully created a user. 
You can use this user to login. If the password is correct, you will go to the greeting page. 
On this page you will be personally greeted, and you can view the other users from the database. 
![Image of MVPLogin](https://geertdepont.github.io/assets/LoginPhone.png)



## Applications described



## Deployment

To deploy the website on a server,:
Download folder 'bachelor-thesis-site'.
Go to this folder in the command line and run:

```
bundle exec jekyll build
```

Then all the files in the _site folder can be dropped in on the server. 

## Website is built with

* [Jekyll](https://jekyllrb.com/) - The web framework used
* [LessCss](http://lesscss.cn/) - The styling from the website.

## Applications are build with
* [Android Studio](https://developer.android.com/studio) - The development environment for creating the applications

## Applications are run on
Nexus 5X API 24 emulator

## Versioning of website
1.0

## Versioning of applications
1.0

## Authors of the repository

* **Roberto Verdecchia** - **Ivano Malavolta** - **Patricia Lago** - **Geert de Pont** - *Initial work* 

