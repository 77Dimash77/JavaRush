package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View{
    private Controller controller;
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replace(".", "/") + "/vacancies.html";

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }

    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            String newHtmlBody = getUpdatedFileContent(vacancies);
            updateFile(newHtmlBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        try {
            Document oldVacancies = getDocument();

            Element templateElement = oldVacancies.getElementsByClass("template").first();
            Element templateElementClone = templateElement.clone();
            templateElementClone.removeClass("template");
            templateElementClone.removeAttr("style");

            oldVacancies.getElementsByAttributeValueEnding("class", "vacancy").remove();

            for (Vacancy vacancy : vacancies) {
                Element vacancyElement = templateElementClone.clone();
                vacancyElement.getElementsByAttributeValue("class", "city").first().text(vacancy.getCity());
                vacancyElement.getElementsByAttributeValue("class", "companyName").first().text(vacancy.getCompanyName());
                vacancyElement.getElementsByAttributeValue("class", "salary").first().text(vacancy.getSalary());
                Element link = vacancyElement.getElementsByAttributeValue("href", "url").first();
                link.text(vacancy.getTitle());
                link.attr("href", vacancy.getUrl());

                templateElement.before(vacancyElement);
            }

            return oldVacancies.outerHtml();

        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }

    private void updateFile(String htmlBody) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(htmlBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}