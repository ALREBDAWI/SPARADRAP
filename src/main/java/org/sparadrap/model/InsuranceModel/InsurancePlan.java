package org.sparadrap.model.InsuranceModel;

/**
 * Represents the different insurance plans available.
 * Each plan has a coverage percentage associated with it.
 */
public enum InsurancePlan {
    /** Standard plan with 30% coverage */
    STANDARD(30),

    /** Premium plan with 70% coverage */
    PREMIUM(70),

    /** Ultra plan with 90% coverage */
    ULTRA(90);

    /** Coverage percentage for the plan */
    private int coverage;

    /**
     * Constructor to set the coverage percentage for the plan.
     *
     * @param coverage coverage percentage of the insurance plan
     */
    InsurancePlan(int coverage) {
        this.coverage = coverage;
    }

    /**
     * Returns the coverage percentage of the insurance plan.
     *
     * @return coverage percentage
     */
    public int getCoverage() {
        return coverage;
    }
}
