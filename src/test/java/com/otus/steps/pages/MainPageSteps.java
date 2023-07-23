package com.otus.steps.pages;

import com.google.inject.Inject;
import com.otus.components.CourseComponents;
import com.otus.pages.MainPage;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Тогда;

import java.io.IOException;

public class MainPageSteps {
    @Inject
    public MainPage mainPage;

    @Inject
    public CourseComponents courseComponents;

    @Если("Открываем главную страницу")
    public void pageFactory() {
        mainPage.open();
    }

    @Тогда("На главной странице выбираем курс {string}")
    public void findCourse(String title) {
        courseComponents.findCourseByTitle(title);
    }

    @Тогда("Поиск курса, стартующего в указанную дату {string}, или позже")
    public void findCourseWithMaxDate(String date) {
        courseComponents.getCourseGreaterDate(date);
    }
}
