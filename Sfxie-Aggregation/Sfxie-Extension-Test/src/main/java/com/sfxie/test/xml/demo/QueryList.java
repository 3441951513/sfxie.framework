package com.sfxie.test.xml.demo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({
    ArticleQueryList.class})

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public abstract class QueryList<T> implements Serializable{
    private static final long serialVersionUID = 1L;
    //总数量
    protected int total;
    //结果集
    protected List<T> result;
    //查询参数
    @XmlElement
    private String param;
    //页码
    @XmlElement
    private int page;
    //每页数量
    @XmlElement
    private int pageSize;

    public abstract List<T> getResult();
    public abstract void setResult(List<T> result);
    public abstract void setTotal(int total); 
    public abstract int getTotal();
}