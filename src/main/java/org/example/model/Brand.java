package org.example.model;

public class Brand extends BaseModel{
    private String name;
    private Company company;

    public Brand(Company company, String name){
        this.company = company;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "name='" + name + '\'' +
                ", company=" + company.getName() +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Brand brand = (Brand)obj;

        if(brand.getName().equals(this.name)){
            return true;
        }

        return false;
    }
}
