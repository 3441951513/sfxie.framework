package com.sfxie.test.xml.demo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="articleResult")
public class ArticleQueryList extends QueryList<Article>{

    private static final long serialVersionUID = 1L;

    @XmlElementWrapper
    @XmlElement(name="article")
    @Override
    public List<Article> getResult() {
        // TODO Auto-generated method stub
        return super.result;
    }
    @Override
    public void setResult(List<Article> result) {
        // TODO Auto-generated method stub
        super.result=result;
    }
    @Override
    public void setTotal(int total) {
        // TODO Auto-generated method stub
        super.total=total;
    }
    @XmlElement
    @Override
    public int getTotal() {
        // TODO Auto-generated method stub
        return super.total;
    }

}