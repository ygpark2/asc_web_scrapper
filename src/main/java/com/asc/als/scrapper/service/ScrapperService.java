package com.asc.als.scrapper.service;

public interface ScrapperService<T> {

    public void navigate();

    public void navigate(String url);

    public T scrape();
}
