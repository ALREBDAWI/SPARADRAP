package org.sparadrap.model.InsuranceModel;

public enum InsurancePlan {
    STANDARD(30),
    PREMIUM(70),
    ULTRA(90);

    private int coverage;

    InsurancePlan(int coverage) {
        this.coverage = coverage;
    }

    public int getCoverage() {
        return coverage;
    }
}
