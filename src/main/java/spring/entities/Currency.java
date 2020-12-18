package spring.entities;
import javax.persistence.*;


@Entity
@Table(name = "CURRENCY")
public class Currency {
    @Id
    @Column(name = "Date", length = 64, nullable = false)
    private String date;

    @Column(name = "GBR", nullable = false)
    private double gbr;

    @Column(name = "EUR", nullable = false)
    private double eur;

    @Column(name = "CAD", nullable = false)
    private double cad;

    @Column(name = "SGD", nullable = false)
    private double sgd;

    @Column(name = "AUD", nullable = false)
    private double aud;

    @Column(name = "USD", nullable = false)
    private double usd;

    public Currency(String date, double gbr, double eur, double cad, double sgd, double aud, double usd) {
        this.date = date;
        this.gbr = gbr;
        this.eur = eur;
        this.cad = cad;
        this.sgd = sgd;
        this.aud = aud;
        this.usd = usd;
    }

    public Currency() {
        this.date = "No data";
        this.gbr = 0;
        this.eur = 0;
        this.cad = 0;
        this.sgd = 0;
        this.aud = 0;
        this.usd = 0;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "date='" + date + '\'' +
                ", gbr=" + gbr +
                ", eur=" + eur +
                ", cad=" + cad +
                ", sgd=" + sgd +
                ", aud=" + aud +
                ", usd=" + usd +
                '}';
    }

    public String getDate() {
        return date;
    }

    public double getGbr() {
        return gbr;
    }

    public double getEur() {
        return eur;
    }

    public double getCad() {
        return cad;
    }

    public double getSgd() {
        return sgd;
    }

    public double getAud() {
        return aud;
    }

    public double getUsd() {
        return usd;
    }

    public void setGbr(double gbr) {
        this.gbr = gbr;
    }

    public void setEur(double eur) {
        this.eur = eur;
    }

    public void setCad(double cad) {
        this.cad = cad;
    }

    public void setSgd(double sgd) {
        this.sgd = sgd;
    }

    public void setAud(double aud) {
        this.aud = aud;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
