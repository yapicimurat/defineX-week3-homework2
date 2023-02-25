package org.example.model;


public class Company extends BaseModel{
    private Sector sector;
    private String name;
    public Company(Sector sector, String name){
        this.name = name;
        this.sector = sector;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "sector=" + sector +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Company company = (Company)obj;

        if(company.name == this.name){
            return true;
        }

        return false;
    }
}
