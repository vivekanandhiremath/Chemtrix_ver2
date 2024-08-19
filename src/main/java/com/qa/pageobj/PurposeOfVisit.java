package com.qa.pageobj;

public enum PurposeOfVisit {
    SALES_ORDER("Sales order"),
    SALES_QUOTATION("Sales Quotation"),
    COLLECTION_ENTRY("Collection Entry"),
    PROSPECT_ENTRY("Prospect Entry");

    private final String displayValue;

    PurposeOfVisit(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public static PurposeOfVisit fromDisplayValue(String displayValue) {
        for (PurposeOfVisit purpose : PurposeOfVisit.values()) {
            if (purpose.getDisplayValue().equalsIgnoreCase(displayValue)) {
                return purpose;
            }
        }
        throw new IllegalArgumentException("Unknown display value: " + displayValue);
    }
}
