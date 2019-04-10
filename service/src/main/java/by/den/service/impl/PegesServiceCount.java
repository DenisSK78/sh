package by.den.service.impl;

import org.springframework.stereotype.Service;

@Service
public class PegesServiceCount {

    private Integer pages;

    public Integer countPages(Integer count, int numberMessegesFromPage) {

        int q = count % numberMessegesFromPage;
        if (q != 0) {
            pages = count / numberMessegesFromPage + 1;
        } else {
            pages = count / 3;
        }
        return pages;
    }
}
