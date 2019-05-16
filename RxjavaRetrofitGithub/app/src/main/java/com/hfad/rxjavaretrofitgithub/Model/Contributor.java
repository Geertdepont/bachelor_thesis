package com.hfad.rxjavaretrofitgithub.Model;

public class Contributor
{
    public String login;
    public int contributions;
    public Repository repository;

    public Contributor(String login, int contributions) {
        this.login = login;
        this.contributions = contributions;
    }

    public String getLogin() {
        return login;
    }

    public void setRepository(Repository repository) {
        if (this.repository != null){
            this.repository = repository;
            repository.addContributor(this);
        }
    }

    public int getContributions() {
        return contributions;
    }
}