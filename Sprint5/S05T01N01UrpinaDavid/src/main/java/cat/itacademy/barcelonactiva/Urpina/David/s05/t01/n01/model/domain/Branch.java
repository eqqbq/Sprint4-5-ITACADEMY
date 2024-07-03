package cat.itacademy.barcelonactiva.Urpina.David.s05.t01.n01.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk_branchId;
    private String branchName;
    private String branchCountry;

    public Branch(){

    }

    public Branch(long pk_branchId, String branchName, String branchCountry) {
        this.pk_branchId = pk_branchId;
        this.branchName = branchName;
        this.branchCountry = branchCountry;
    }

    public void setPk_branchId(long pk_branchId) {
        this.pk_branchId = pk_branchId;
    }

    public long getPk_branchId() {
        return pk_branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchCountry() {
        return branchCountry;
    }

    public void setBranchCountry(String branchCountry) {
        this.branchCountry = branchCountry;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "pk_branchId=" + pk_branchId +
                ", branchName='" + branchName + '\'' +
                ", branchCountry='" + branchCountry + '\'' +
                '}';
    }
}
