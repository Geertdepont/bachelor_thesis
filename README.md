# Repository for website and applications created for describing Android architectures 

This repository contains all files used for describing Android architectures.
Five applications are created to describe the 42 guidelines from Verdecchia * et al*.
These applications are: 'ArchitectureExample', 'RxJavaRetrofitGithub', 'BookApplication', 'BossApplication' and MVPLogin

## Table describing coverage of guidelines in applications

Application  | Guidelines
------------- | -------------
ArchitectureExample  | A-5, MVVM-1 to MVVM-8 and CLEAN-2
RxJavaRetrofitGithub | A-6, A-7, A-10, MVVM-9 and MVVM-10
BookApplication      | A-13 and MVP-4
BossApplication      | A-2, A-8, A-9, A-11, A-12, A-15, MVP-2, MVP- 3, CLEAN-1 and CLEAN-2
MVPLogin             | A-1, A-3 to A-6, A-14 MVP-1, MVP-5 to MVP- 11 and CLEAN-3 to CLEAN-5

## Making modifications of this website

For making modifications to this website, the website can be downloaded at this [page](https://github.com/Geertdepont/bachelor_thesis/tree/master/bachelor-thesis-site).

By running in the command line:
```
bundle exec jekyll serve
```

The website is created and hosted locally.
The files that produce the website can be found in the _site folder  


### Prerequisites

This website is build using ruby 2.6
To find the version of ruby, run in the command line:

```
ruby -v
```

## Applications described

The applications that are used as code example can be found on the [GitHub page](https://github.com/Geertdepont/bachelor_thesis/tree/master/bachelor-thesis-site).


## Deployment

To deploy this website on a server, run this on the command line:

```
bundle exec jekyll serve
```

Then all the files in the _site folder can be dropped in on the server. 

## Built With

* [Jekyll](https://jekyllrb.com/) - The web framework used
* [LessCss](http://lesscss.cn/) - The styling from the website.

## Versioning

1.0

## Authors of the website

* **Roberto Verdecchia** - **Ivano Malavolta** - **Patricia Lago** - **Geert de Pont** - *Initial work* 

