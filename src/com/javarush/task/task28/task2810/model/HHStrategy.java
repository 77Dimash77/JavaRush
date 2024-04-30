package com.javarush.task.task28.task2810.model;


import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HHStrategy implements Strategy {

    private static final String URL_FORMAT = "https://hh.ru/search/vacancy?text=java+%s&page=%d";

    @Override

    public List<Vacancy> getVacancies(String searchString) {
        List <Vacancy>vacancyList = new ArrayList<>();
        try {
            int pageNumber = 0;
            Document document;
            while (true) {
                document = getDocument(searchString, pageNumber++);
                if (document == null) break;
                Elements elements = document.select("[data-qa=vacancy-serp__vacancy]");
                if (elements.size() == 0) break;
                for (Element element : elements) {
                    // title
                    Element titleElement = element.select("[data-qa=vacancy-serp__vacancy-title]").first();
                    String title = titleElement.text();

                    // salary
                    Element salaryElement = element.select("[data-qa=vacancy-serp__vacancy-compensation]").first();
                    String salary = "";
                    if (salaryElement != null) {
                        salary = salaryElement.text();
                    }

                    // city
                    String city = element.select("[data-qa=vacancy-serp__vacancy-address]").first().text();

                    // company
                    String companyName = element.select("[data-qa=vacancy-serp__vacancy-employer]").first().text();

                    // site
                    String siteName = "http://hh.ua/";

                    // url
                    String url = titleElement.attr("href");


                    // add vacancy to the list
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(title);
                    vacancy.setSalary(salary);
                    vacancy.setCity(city);
                    vacancy.setCompanyName(companyName);
                    vacancy.setSiteName(siteName);
                    vacancy.setUrl(url);
                    vacancyList.add(vacancy);





                }
                //Test and debug
                //System.out.printf("Processed page #%s, got %d vacancies \n",pageNumber, vacancyList.size());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vacancyList;
    }


    protected Document getDocument(String searchString, int page) throws IOException{

        String url = String.format(URL_FORMAT, searchString, page);
        Document document = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.3; Win64; x64)").referrer("none").get();

        return document;
    }
}

//    private static final String URL_FORMAT = "https://hh.kz/search/vacancy?text=Java+%s&page=%d";
//    String url = String.format(URL_FORMAT, "Kiev", 3);