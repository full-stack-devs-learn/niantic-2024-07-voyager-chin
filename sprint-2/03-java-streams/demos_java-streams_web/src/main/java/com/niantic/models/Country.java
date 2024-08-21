package com.niantic.models;

public class Country
{
    private String code;
    private String code2;
    private String name;
    private String continent;
    private String region;
    private double surfaceArea;
    private int independenceYear;
    private long population;
    private double lifeExpectancy;
    private double gnp;
    private double gnpOld;
    private String localName;
    private String government;
    private String headOfState;
    private String capital;

    public Country()
    {
    }

    public Country(String code, String code2, String name, String continent, String region, double surfaceArea, int independenceYear, long population, double lifeExpectancy, double gnp, double gnpOld, String localName, String government, String headOfState, String capital)
    {
        this.code = code;
        this.code2 = code2;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.independenceYear = independenceYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.gnp = gnp;
        this.gnpOld = gnpOld;
        this.localName = localName;
        this.government = government;
        this.headOfState = headOfState;
        this.capital = capital;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode2()
    {
        return code2;
    }

    public void setCode2(String code2)
    {
        this.code2 = code2;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getContinent()
    {
        return continent;
    }

    public void setContinent(String continent)
    {
        this.continent = continent;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    public double getSurfaceArea()
    {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea)
    {
        this.surfaceArea = surfaceArea;
    }

    public int getIndependenceYear()
    {
        return independenceYear;
    }

    public void setIndependenceYear(int independenceYear)
    {
        this.independenceYear = independenceYear;
    }

    public long getPopulation()
    {
        return population;
    }

    public void setPopulation(long population)
    {
        this.population = population;
    }

    public double getLifeExpectancy()
    {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(double lifeExpectancy)
    {
        this.lifeExpectancy = lifeExpectancy;
    }

    public double getGnp()
    {
        return gnp;
    }

    public void setGnp(double gnp)
    {
        this.gnp = gnp;
    }

    public double getGnpOld()
    {
        return gnpOld;
    }

    public void setGnpOld(double gnpOld)
    {
        this.gnpOld = gnpOld;
    }

    public String getLocalName()
    {
        return localName;
    }

    public void setLocalName(String localName)
    {
        this.localName = localName;
    }

    public String getGovernment()
    {
        return government;
    }

    public void setGovernment(String government)
    {
        this.government = government;
    }

    public String getHeadOfState()
    {
        return headOfState;
    }

    public void setHeadOfState(String headOfState)
    {
        this.headOfState = headOfState;
    }

    public String getCapital()
    {
        return capital;
    }

    public void setCapital(String capital)
    {
        this.capital = capital;
    }
}
