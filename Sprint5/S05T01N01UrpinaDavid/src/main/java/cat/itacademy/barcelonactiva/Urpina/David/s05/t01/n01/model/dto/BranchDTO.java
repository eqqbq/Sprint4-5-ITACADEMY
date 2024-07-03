package cat.itacademy.barcelonactiva.Urpina.David.s05.t01.n01.model.dto;

import java.util.List;

public class BranchDTO {
    private long pk_branchId;
    private String branchName;
    private String branchCountry;
    private String branchType;
    private static final List<String> EU_COUNTRIES = List.of("Austria", "Belgium", "Bulgaria",
            "Croatia", "Republic of Cyprus", "Czech Republic", "Denmark", "Estonia", "Finland",
            "France", "Germany", "Greece", "Hungary", "Ireland", "Italy", "Latvia", "Lithuania",
            "Luxembourg", "Malta", "Netherlands", "Poland", "Portugal", "Romania", "Slovakia",
            "Slovenia", "Spain", "Sweden");


    public BranchDTO(long pk_branchId, String branchName, String branchCountry) {
        this.pk_branchId = pk_branchId;
        this.branchName = branchName;
        this.branchCountry = branchCountry;
        setBranchType(branchCountry);
    }

    public BranchDTO(){
    }

    public long getPk_branchId() {
        return pk_branchId;
    }

    public String getBranchCountry() {
        return branchCountry;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getBranchType() {
        return branchType;
    }

    public void setPk_branchId(long pk_branchId) {
        this.pk_branchId = pk_branchId;
    }

    public void setBranchCountry(String branchCountry) {
        this.branchCountry = branchCountry;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public void setBranchType (String country) {
        if (EU_COUNTRIES.stream().anyMatch(c -> c.equalsIgnoreCase(country))){
            this.branchType = "Euro";
        }
        else this.branchType = "Not Euro";
    }
}
