package com.mystreams.dominio;

import java.util.List;

public class Range {

    private int id;
    private List<Installment> installmentOfRange;

    public Range() {
    }

    public Range(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Range{" +
                "id=" + id +
                ", installmentOfRange=" + installmentOfRange +
                '}';
    }

    public List<Installment> getInstallmentOfRange() {
        return installmentOfRange;
    }

    public void setInstallmentOfRange(List<Installment> installmentOfRange) {
        this.installmentOfRange = installmentOfRange;
    }
}
