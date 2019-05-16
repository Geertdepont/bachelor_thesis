package com.hfad.rxjavaretrofitgithub.Model;

import java.util.ArrayList;
import java.util.List;

public class Repository
{
    private String name;
    private String description;

    private List<Contributor> contributorList;

    public Repository(String name, String description) {
        this.name = name;
        this.description = description;
        this.contributorList = new ArrayList<>();
    }

    public void setContributorList(List<Contributor> contributorList) {
        this.contributorList = contributorList;
    }

    public void addContributor(Contributor contributor) {
        this.contributorList.add(contributor);
    }

    public List<Contributor> getContributorList() {
        return contributorList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Repository [name=" + name + ", description=" + description + "]";
    }
}