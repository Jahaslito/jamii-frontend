package Model;

import java.sql.Date;

public class Death {
    private int id;
    private int corpse_age;
    private Date death_date;
    private int disease_id;
    private int healthcare_provider_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCorpse_age() {
        return corpse_age;
    }

    public void setCorpse_age(int corpse_age) {
        this.corpse_age = corpse_age;
    }

    public Date getDeath_date() {
        return death_date;
    }

    public void setDeath_date(Date death_date) {
        this.death_date = death_date;
    }

    public int getDisease_id() {
        return disease_id;
    }

    public void setDisease_id(int disease_id) {
        this.disease_id = disease_id;
    }

    public int getHealthcare_provider_id() {
        return healthcare_provider_id;
    }

    public void setHealthcare_provider_id(int healthcare_provider_id) {
        this.healthcare_provider_id = healthcare_provider_id;
    }
}
